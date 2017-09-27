import React from "react";
import ReactDOM from "react-dom";
import PubSub from "pubsub-js";
import Search from "./search";
import {MailApiInst, ResultsetApiInst, SearchApiInst} from "../client/index";
import "../../css/workspace/content-frame.css";
import MailList from "../mail/mail-list";
import MailContent from "../mail/mail-content";
import AttachmentList from "../attachment/attachment-list";
import AttachmentContent from "../attachment/attachment-content";
import MailboxList from "../mailbox/mailbox-list";
import MailboxContent from "../mailbox/mailbox-content";
import ContactList from "../contact/contact-list";
import ContactContent from "../contact/contact-content";
import "../../css/common/antd.css";
import Dialog from "../dialog";
const dialog = new Dialog();

/**
 * 检索面板
 */
class SearchPanel extends React.Component {
    constructor(props) {
        super(props);

        this.handleExpandClicked = this.handleExpandClicked.bind(this);
        this.setShrink = this.setShrink.bind(this);
        this.setExpand = this.setExpand.bind(this);

        this.handleChange = this.handleChange.bind(this);
        this.addCondition = this.addCondition.bind(this);
        this.setCondition = this.setCondition.bind(this);
        this.removeCondition = this.removeCondition.bind(this);
        this.searchClick = this.searchClick.bind(this);
        this.saveClick = this.saveClick.bind(this);
        this.objDeepCopy = this.objDeepCopy.bind(this);

        this.state = {
            isExpand: true,
            data: [],
            searchData: [],
            queryData:[]
        }
    }

    handleExpandClicked() {
        console.log("详情界面返回注检索界面时，再次调一下检索按钮方法");
        this.searchClick();
        PubSub.publish("contentFrame.expand", this)
    }

    setShrink(msg, data) {
        this.setState({isExpand: false})
    }

    setExpand() {
        this.setState({isExpand: true})
    }

    componentWillMount() {
        this.tokenShrink = PubSub.subscribe("contentFrame.shrink", this.setShrink.bind(this));
        this.tokenExpand = PubSub.subscribe("contentFrame.expand", this.setExpand.bind(this));
        this.tokenAddCondition = PubSub.subscribe("contentFrame.addCondition", this.addCondition.bind(this));
        this.tokenSetCondition = PubSub.subscribe("contentFrame.setCondition", this.setCondition.bind(this));
    }

    componentDidMount() {
        SearchApiInst.ciStorage.set("searchToken", "");
    }

    componentWillUnmount() {
        SearchApiInst.ciStorage.set("searchToken", "");
        PubSub.unsubscribe(this.tokenShrink);
        PubSub.unsubscribe(this.tokenExpand);
        PubSub.unsubscribe(this.tokenAddCondition);
        PubSub.unsubscribe(this.tokenSetCondition);
    }

    /**
     * 添加检索条件事件 + / 点击标签列表添加条件事件
     * @param key 点击的key值
     * @param msg 条件参数对象
     */
    addCondition(key, msg) {

        let data = this.state.data;
        let queryData = this.state.queryData;
        if (key == "contentFrame.addCondition") {
            data.push({
                relation: "and",
                keyword: "tag",
                expression: "like",
                result:  msg.name
            });
            queryData.push({
                relation: "and",
                keyword: "tag",
                expression: "like",
                result:  msg.parentName+","+msg.name
            });
        } else {
            data.push({
                relation: "and",
                keyword: "subject",
                expression: "",
                result: ""
            });
            queryData.push({
                relation: "and",
                keyword: "subject",
                expression: "",
                result: ""
            });
        }
        this.setState({data: data,queryData:queryData})
    }

    /**
     * 点击结果集回填条件事件
     * @param key 点击的key值
     * @param msg 条件参数对象
     */
    setCondition(key, msg) {
        console.log(`点击结果集回填条件:`, msg);
        this.setState({data: msg});
        this.searchClick();
    }

    /**
     * 删除检索条件事件 x
     * @param key 点击的key值
     */
    removeCondition(key) {
        let data = this.state.data;
        for (var i = 0; i < data.length; i++) {
            var temp = data[i];
            if (!isNaN(key)) {
                temp = i
            }
            if (temp == key) {
                for (var j = i; j < data.length; j++) {
                    data[j] = data[j + 1]
                }
                data.length = data.length - 1
            }
            // if (data[i]) data[i].key = i
        }
        this.setState({data: data});

        let queryData = this.state.queryData;
        for (var i = 0; i < queryData.length; i++) {
            var temp = queryData[i];
            if (!isNaN(key)) {
                temp = i
            }
            if (temp == key) {
                for (var j = i; j < queryData.length; j++) {
                    queryData[j] = queryData[j + 1]
                }
                queryData.length = queryData.length - 1
            }
        }
        this.setState({queryData: queryData});
    }

    /**
     * 检索按钮点击事件
     * @param e
     */
    searchClick(e) {
        let conditionData = this.state.data;

        let caseId = SearchApiInst.ciStorage.get("caseId");
        let opt = {};
        if (!conditionData || conditionData.length < 1) {
            console.log("不存在检索条件，不进行查询");

            return;
        }
        console.log(`检索时条件=`, conditionData);

        let copyConditionData = this.objDeepCopy(conditionData);

        this.setState({
            searchData: copyConditionData
        });
        opt['conditions'] = JSON.stringify(this.state.queryData);
        SearchApiInst.getSearchDataCount(caseId, opt, (error, data, response) => {
            SearchApiInst.ciStorage.set("searchToken", "");
            if (response.ok) {
                //查询出结果，将该searchToken保存
                SearchApiInst.ciStorage.set("searchToken", data.searchToken);
                let obj = {
                    caseId: caseId,
                    conditions: JSON.stringify(this.state.queryData)
                };
                PubSub.publish("tabList.load", obj);
            }
        });
    }

    objDeepCopy(source) {
        var sourceCopy = source instanceof Array ? [] : {};
        for (var item in source) {
            sourceCopy[item] = typeof source[item] === 'object' ? this.objDeepCopy(source[item]) : source[item];
        }
        return sourceCopy;
    }

    /**
     * 保存按钮点击事件
     * @param e
     */
    saveClick(e) {
        console.log("点击保存结果集按钮:");

        let searchToken = ResultsetApiInst.ciStorage.get("searchToken");
        let searchConditionData = this.state.searchData;

        console.log(`保存的条件=`, searchConditionData);
        ReactDOM.unmountComponentAtNode($("#dialog2")[0]);
        ReactDOM.render(
            <div className="input-group">
                <span className="input-group-addon">结果集名称:</span>
                <input id="saveResultSetName" type="text" className="form-control" placeholder="请输入结果集名称"/>
            </div>,
            $("#dialog2")[0]
        );

        if (searchToken == "") {
            console.log("不存在检索结果token，无法保存结果集");
            return;
        }

        dialog.openDialog("#dialog2", "保存结果集", {
            "确 定": function () {
                // 发布重置结果集列表数据
                let caseId = ResultsetApiInst.ciStorage.get("caseId");

                let resultSetName = $("#saveResultSetName").val();
                if (resultSetName == "" || resultSetName.length < 1) {
                    console.log("保存结果集名称不能为空");
                    return;
                }
                let opt = {};
                opt['conditions'] = searchConditionData;
                ResultsetApiInst.createResultSet(caseId, resultSetName, searchToken, JSON.stringify(opt), (error, data, response) => {
                    if (response.ok) {
                        PubSub.publish("sidebar.resetResultSet");
                        $(this).dialog("close");
                    } else {
                        console.log(response.data);
                    }
                });
            },
            "取 消": function () {
                $(this).dialog("close");
            }
        }, 400, 180);
    }

    /**
     * onChange事件
     * @param fieldName 改变属性名
     * @returns {function(this:SearchPanel)}
     */
    handleChange(fieldName) {
        return function (e) {
            let data = this.state.data;
            let key = e.target.name;
            data[key][fieldName] = e.target.value;
            if (fieldName == "keyword") {
                data[key]["expression"] = "";
                data[key]["result"] = "";
            }
            this.setState({})
        }.bind(this)
    }


    render() {

        if (this.state.isExpand) {

            return (
                <div className="box">

                    <div className="box-header with-border">
                        <h3 className="box-title">检索条件</h3>

                        <div className="box-tools pull-right">
                            <button type="button" className="btn btn-box-tool" data-widget="collapse">
                                <i className="fa fa-minus"/></button>
                        </div>
                    </div>

                    <div className="box-body ci-search-area">
                        <Search addCondition={this.addCondition} removeCondition={this.removeCondition}
                                searchClick={this.searchClick} saveClick={this.saveClick}
                                handleChange={this.handleChange}
                                data={this.state.data}/>
                    </div>
                </div>
            )

        }

        return (
            <div className="box box-widget">
                <div className="btn-group">
                    <button className="btn btn-xs btn-primary" onClick={this.handleExpandClicked}><i
                        className="fa fa-forward"/></button>
                </div>
            </div>
        )

    }
}

/**
 * 检索结果面板
 */
class SearchResultPanel extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            isExpand: true,
            active: "mail",
            data: {
                mailCount: 0,
                attachmentCount: 0,
                mailboxCount: 0,
                contactCount: 0
            },
            tabPanels: {
                mail: {label: "邮件", tag: <MailList ref="mailList"/>, icon: "envelope"},
                attachment: {label: "附件", tag: <AttachmentList ref="attachmentList"/>, icon: "paperclip"},
                mailbox: {label: "邮箱", tag: <MailboxList ref="mailboxList"/>, icon: "inbox"},
                contact: {label: "联系人", tag: <ContactList ref="contactList"/>, icon: "user"}
            }
        };

    }

    fixActiveTab() {
        let tabPanelId = "tab_" + this.state.active;
        let tabHandlerId = "tab_handler_" + this.state.active;

        $(".ci-ws-container-list .tab-pane .active, .nav-tabs .active").each(function () {
            $(this).removeClass("active");
        });
        $("#" + tabPanelId + ",#" + tabHandlerId).addClass("active");
    }

    componentWillMount() {
        this.tokenExpand = PubSub.subscribe("contentFrame.expand", this.setExpand.bind(this));
        this.tokenShrink = PubSub.subscribe("contentFrame.shrink", this.setShrink.bind(this));
        this.tokenSetHitList = PubSub.subscribe("hitListCount", this.setHitCount.bind(this));
    }

    componentDidMount() {
        this.fixActiveTab();

    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenShrink);
        PubSub.unsubscribe(this.tokenExpand);
        PubSub.unsubscribe(this.tokenSetHitList);
    }

    /**
     * 加载命中的邮件、邮箱、附件、联系的个数
     * @param topic
     * @param data
     */
    setHitCount(topic, data) {
        console.log("加载命中的列表数量");
        let start = topic.lastIndexOf(".") + 1;
        let title = topic.substring(start);
        SearchResultPanel.setCount(title, data);
        this.setState({
            data: {
                mailCount: MailApiInst.ciStorage.get("mail"),
                attachmentCount: MailApiInst.ciStorage.get("attachment"),
                mailboxCount: MailApiInst.ciStorage.get("mailbox"),
                contactCount: MailApiInst.ciStorage.get("contact")
            }
        });
    }

    static setCount(title, data) {
        if (title === "mail") {
            MailApiInst.ciStorage.set("mail", data);
        }
        if (title === "attachment") {
            MailApiInst.ciStorage.set("attachment", data);
        }
        if (title === "mailbox") {
            MailApiInst.ciStorage.set("mailbox", data);
        }
        if (title === "contact") {
            MailApiInst.ciStorage.set("contact", data);
        }
    }

    /**
     * 处理界面收缩事件
     */
    setShrink() {
        this.setState({isExpand: false});
    }

    /**
     * 处理界面展开事件
     */
    setExpand() {
        this.setState({isExpand: true});

        this.fixActiveTab();
    }

    handleTabClicked(tabName, tabLabel) {
        this.setState({
            active: tabName
        });

        if (tabName == "contact") {
            this.refs[tabName + "List"].makeDiagram();
        }
    }

    render() {
        let tabHandlerList = [], tabPanelList = [];

        if (this.state.isExpand) {
            // 显示展开的界面

            for (let key in this.state.tabPanels) {
                let item = this.state.tabPanels[key];

                tabHandlerList.push(
                    <li id={"tab_handler_" + key} key={key}>
                        <a href={"#tab_" + key} data-toggle="tab" aria-expanded="true"
                           onClick={this.handleTabClicked.bind(this, key)}><i
                            className={"fa fa-" + item.icon}/> {item.label} <span
                            className="pull-right">({this.state.data[key + "Count"]})</span></a>
                    </li>
                );

                tabPanelList.push(
                    <div className="tab-pane" id={"tab_" + key} key={key}>
                        {item.tag}
                    </div>
                );
            }

        } else {
            // 显示收缩的界面
            let key = this.state.active;
            let item = this.state.tabPanels[key];

            tabHandlerList = [(
                <li className="active" key={key}>
                    <a href={"#tab_" + this.state.active} data-toggle="tab" aria-expanded="true"
                       onClick={this.handleTabClicked.bind(this, key)}><i
                        className={"fa fa-" + item.icon}/> {item.label} <span
                        className="pull-right">({this.state.data[key + "Count"]})</span></a>
                </li>
            )];

            tabPanelList = [(
                <div className="tab-pane" id={"tab_" + key} key={key}>
                    {item.tag}
                </div>
            )];

        }

        return (
            <div className="box box-widget nav-tabs-custom">
                <ul className="nav nav-tabs">
                    {tabHandlerList}
                </ul>
                <div className="tab-content">
                    {tabPanelList}
                </div>
            </div>
        )
    }
}

class FloatContentPanel extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            content: null,
            data: null
        };
    }

    componentWillMount() {
        this.tokenShow = PubSub.subscribe("floatContentPanel.show", this.handleShow.bind(this));
        this.tokenHide = PubSub.subscribe("floatContentPanel.hide", this.handleHide.bind(this));
        this.tokenContentPanelHide = PubSub.subscribe("contentPanel", this.handleHide.bind(this));
    }

    componentDidMount() {
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenShow);
        PubSub.unsubscribe(this.tokenHide);
        PubSub.unsubscribe(this.tokenContentPanelHide);
    }

    handleShow(topic, msg) {
        this.setState({
            data: msg.data,
            content: msg.tag
        }, function () {

            const shrinkWidth = 240;
            let documentWidth = $(document).width();
            let documentHeight = $(document).height();
            let windowHeight = $(window).height();
            let freeWidth = documentWidth - 130 - shrinkWidth;
            $(".ci-ws-container-details-float,#ci-ws-details-float-overlay").css({
                width: documentWidth - 100,
                height: documentHeight - 80
            }).show();
            $("#ci-ws-details-float").css({
                width: freeWidth,
                height: documentHeight - 80,
                left: shrinkWidth + 20
            }).slideDown();

        });
    }

    handleOverlayClicked(event) {
        console.log("got overlay click = ", event);
        this.handleHide(null);
    }

    handleHide(topic) {
        console.log("got handle hide topic = ", topic);

        $("#ci-ws-details-float").slideUp(function () {
            $(".ci-ws-container-details-float,#ci-ws-details-float-overlay").hide();
        });
    }

    render() {

        return (
            <div className="ci-ws-container-details-float pull-right">
                <div id="ci-ws-details-float-overlay" onClick={this.handleOverlayClicked.bind(this)}>&nbsp;</div>
                <div id="ci-ws-details-float">
                    {this.state.content != null ? this.state.content : <h4>没有数据</h4>}
                </div>
            </div>
        )

    }
}

/**
 * 详情面板
 */
class ContentPanel extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            data: {type: null, id: 0},
            dataId: 0
        };
    }

    componentWillMount() {
        this.tokenShow = PubSub.subscribe("contentPanel.show", this.handleShow.bind(this));
    }

    componentDidMount() {
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenShow);
    }

    handleShow(msg, data) {
        this.setState({data: data});
        console.log("update state set data = ", data);
    }

    render() {
        let content;
        switch (this.state.data.type) {
            case "mail":
                content = (<MailContent mailId={this.state.data.id} isFloat={false}/>);
                break;
            case "attachment":
                content = (<AttachmentContent attachmentId={this.state.data.id} isFloat={false}/>);
                break;
            case "mailbox":
                content = (<MailboxContent mailboxData={this.state.data.item}/>);
                break;
            case "contact":
                content = (<ContactContent contactData={this.state.data.item}/>);
                break;
            default:
                content = (<h4>没有数据</h4>);
        }

        return (
            <div className="ci-ws-container-details pull-right">
                {content}
            </div>
        )
    }

}

/**
 * 内容框架
 */
export default class ContentFrame extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            resize: {
                time: 0,
                width: 0,
                lastAction: "expand"
            }
        };
    }

    componentWillMount() {
        this.tokenExpand = PubSub.subscribe("contentFrame.expand", this.handleExpand.bind(this));
        this.tokenShrink = PubSub.subscribe("contentFrame.shrink", this.handleShrink.bind(this));
        this.tokenContentFrame = PubSub.subscribe("contentFrame", this.handleMessageDispatched.bind(this));
    }

    componentDidMount() {
        setTimeout(this.handleResize.bind(this), 500);

        setTimeout(function () {
            window.cInsight.uiComplete(function (data, err) {
                console.log("uiComplete with ", data, err);
            });
        }, 400);
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenExpand);
        PubSub.unsubscribe(this.tokenShrink);
        PubSub.unsubscribe(this.tokenContentFrame);
    }

    handleMessageDispatched(topic) {
        if (topic == "contentFrame.shrink")
            this.state.resize.lastAction = "shrink";
        if (topic == "contentFrame.expand")
            this.state.resize.lastAction = "expand";
    }

    /**
     * 处理界面收缩事件
     */
    handleShrink() {
        const shrinkWidth = 240;
        let freeWidth = $(document).width() - 130 - shrinkWidth;
        if (!$(".ci-ws-container-list").hasClass('pull-left')) {
            $(".ci-ws-container-list").addClass("pull-left");
        }
        $(".ci-ws-container-list").animate({width: shrinkWidth + "px"});
        $(".ci-ws-container-details").show().animate({width: freeWidth + "px"}, function () {
            $(this).show();
        });
    }

    /**
     * 处理界面展开事件
     */
    handleExpand() {
        $(".ci-ws-container-list").animate({width: '100%'});
        $(".ci-ws-container-details").animate({width: 0}, function () {
            if ($(this).width() == 0)
                $(this).hide();
        });
    }

    handleResize() {
        this.state.resize.time = this.state.resize.time || new Date().getTime();
        let windowWidth = $(window).width();
        let timeCost = new Date().getTime() - this.state.resize.time;
        let widthOffset = Math.abs(windowWidth - this.state.resize.width);

        if ((timeCost > 1000) && (widthOffset > 100)) {
            console.log("resize state = ", this.state.resize);

            if (this.state.resize.lastAction == "shrink") {
                this.handleShrink();
            }
            if (this.state.resize.lastAction == "expand") {
                this.handleExpand();
            }

            this.state.resize.time = new Date().getTime();
            this.state.resize.width = windowWidth;

            $("#contentWrapper").height($(document).height() - 50);
        }

        setTimeout(this.handleResize.bind(this), 500);


        if (!$(".ci-ws-container-details").is(":visible") && this.state.resize.lastAction == "shrink") {
            this.handleShrink();
        }

    }

    /**
     * 处理检索结果列表中数据项点击事件，根据所传类型和ID装载显示详情界面
     */
    handleSearchResultItemClicked(type, itemId) {

    }

    render() {

        return (
            <div id="contentWrapper" className="content-wrapper container-fluid">

                <div className="ci-ws-container-list">
                    <SearchPanel />
                    <SearchResultPanel onItemClick={this.handleSearchResultItemClicked}/>
                </div>

                <ContentPanel />

                <FloatContentPanel />

            </div>

        )
    }

}
