import "../../css/case/case.css";
import React from "react";
import ReactDOM from "react-dom";
import Dialog from "../dialog";
import CaseCreate from "./case-create";
import LoadMail from "../loadmail/loadmail";
import Sidebar from "../workspace/sidebar";
import ContentFrame from "../workspace/content-frame";
import {CaseApiInst} from "../client/index";
import PubSub from "pubsub-js";

const dialog = new Dialog();
const loadmail = new LoadMail();
/**
 * 案件区域
 * Created by xcp on 2017/5/2.
 */
export default class Case extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isCaseSelected: false
        };
        this.createCase = this.createCase.bind(this);
        this.changeCase = this.changeCase.bind(this);
        this.loadCase = this.loadCase.bind(this);
        this.editClick = this.editClick.bind(this);
        this.delClick = this.delClick.bind(this);
        this.chooseCase = this.chooseCase.bind(this);
        this.renderMainArea = this.renderMainArea.bind(this);
        this.renderNoLoadData = this.renderNoLoadData.bind(this);
    }

    componentDidMount() {
        CaseApiInst.ciStorage.set("caseId", "");
        localStorage.caseId = "";
    }

    componentWillMount() {
        // 订阅选择案件
        this.tokenChangeCase = PubSub.subscribe("header.changeCase", this.changeCase);
        // 订阅装载案件
        this.tokenLoadCase = PubSub.subscribe("header.loadCase", this.loadCase);
        // 订阅渲染主内容区域
        this.tokenRenderMainArea = PubSub.subscribe("header.renderMainArea", this.renderMainArea);
        // 订阅渲染未加载数据页面
        this.tokenRenderNoLoadData = PubSub.subscribe("header.renderNoLoadData", this.renderNoLoadData);
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenChangeCase);
        PubSub.unsubscribe(this.tokenLoadCase);
        PubSub.unsubscribe(this.tokenRenderMainArea);
        PubSub.unsubscribe(this.tokenRenderNoLoadData);
    }

    openPromptDialog() {

    }

    // 案件列表 修改事件
    editClick(caseId, caseCode, caseName, caseOperator, kickoffDate, remark, mailAmount) {
        console.log("修改了：" + caseId + "-" + caseCode + "-" + caseName + " - " + mailAmount);
        ReactDOM.unmountComponentAtNode(document.getElementById('dialog'));
        const self = this;
        let currentCaseId = CaseApiInst.ciStorage.get("caseId");
        dialog.openDialog("#dialog", "编辑案件", {
            "保 存": function () {
                let caseName = $("#caseName").val();
                let caseOperator = $("#caseOperator").val();
                let kickoffDate = $("#kickoffDate").val();
                let remark = $("#remark").val();
                let opt = {};
                opt['remark'] = remark;

                // 保存修改案件
                CaseApiInst.updateCase(caseId, caseName, caseOperator, kickoffDate, opt, (error, data, response) => {
                    if (response.ok) {
                        // 关闭dialog
                        $(this).dialog("close");
                        if (currentCaseId == "") {
                            self.changeCase("", true);
                        } else {
                            self.changeCase("", false);
                        }
                    }
                });
            },
            "取 消": function () {
                $(this).dialog("close");
                if (currentCaseId == "") {
                    self.changeCase("", true);
                } else {
                    self.changeCase("", false);
                }
            }
        });
        try {
            ReactDOM.render(
                <CaseCreate caseId={caseId} caseCode={caseCode} caseName={caseName} caseOperator={caseOperator}
                            kickoffDate={kickoffDate}
                            remark={remark}/>,
                document.getElementById('dialog')
            );
            $("#caseId").attr("disabled", "disabled");
            $("#caseId").css("border", "none");
        } catch (e) {
            console.log("error");
        }

    }

    // 案件列表 删除事件
    delClick(id, code, name) {
        console.log("删除了：" + id + " - " + code + " - " + name);
        let currentCaseId = CaseApiInst.ciStorage.get("caseId");
        ReactDOM.unmountComponentAtNode($("#dialog2")[0]);
        const self = this;
        ReactDOM.render(
            <div>你确定要删除吗？</div>,
            $("#dialog2")[0]
        );
        dialog.openDialog("#dialog2", "删除案件", {
            "确 定": function () {
                // 调用删除案件 api
                CaseApiInst.deleteCase(id, (error, data, response) => {
                    if (response.ok) {
                        if (currentCaseId == "") {
                            self.changeCase("", true);
                        } else {
                            self.changeCase("", false);
                        }
                    } else {
                        console.log("错误返回数据 = ", response.data);
                    }
                    $(this).dialog("close");
                });
            },
            "取 消": function () {
                $(this).dialog("close");
            }
        }, 400, 150);
    }

    // 选择案件 双击事件
    chooseCase(cmt) {
        let caseId = cmt.caseId;
        let caseCode = cmt.caseCode;
        let caseName = cmt.caseName;
        let caseOperator = cmt.caseOperator;
        let kickoffDate = cmt.kickoffDate;
        let remark = cmt.remark;
        let mailAmount = cmt.mailAmount;
        CaseApiInst.activateCase(caseId, (error, data, response) => {
            if (response.ok) {
                CaseApiInst.ciStorage.set("caseId", caseId);
                localStorage.caseId = caseId;
                this.setState({
                    caseId: caseId,
                    caseCode: caseCode,
                    caseName: caseName,
                    caseOperator: caseOperator,
                    kickoffDate: kickoffDate,
                    remark: remark,
                    mailAmount: mailAmount,
                    isCaseSelected: true
                });
                if (mailAmount > 0) {
                    // 含有装载的邮件数据，渲染主内容区域
                    this.renderMainArea();
                } else {
                    // 没有装载的邮件数据，渲染无数据待装载页面
                    this.renderNoLoadData();
                }
                dialog.closeDialog("#dialog");
            } else {
                console.log(response.data);
            }
        });

    }

    renderMainArea() {
        ReactDOM.unmountComponentAtNode($("#workspace")[0]);
        ReactDOM.render(
            <div className="container-fluid">
                <Sidebar shrinkTopic="contentFrame.shrink" expandTopic="contentFrame.expand"/>
                <ContentFrame/>
            </div>,
            $("#workspace")[0]
        );
    }

    renderNoLoadData() {
        console.log("装载界面");
        ReactDOM.unmountComponentAtNode($("#workspace")[0]);
        ReactDOM.render(
            <div className="container-fluid ci-no-load-content">
                <div className="ci-no-load-data">
                    <div>
                        暂 无 数 据
                    </div>
                    <div>
                        <button type="button" className="btn btn-block btn-primary btn-lg" onClick={this.loadCase}>
                            邮件装载
                        </button>
                    </div>
                </div>
            </div>,
            $("#workspace")[0]
        );
    }

    // 案件切换 按钮点击事件
    changeCase(key, msg) {
        const self = this;
        // 初始化进入
        if (msg == true) {
            dialog.openDialog("#dialog", "案件切换", {
                "新建案件": function () {
                    $(this).dialog("close");
                    self.createCase();
                }
            });
        } else {
            // 点击切换案件进入
            dialog.openDialog("#dialog", "案件切换", {
                "新建案件": function () {
                    $(this).dialog("close");
                    self.createCase();
                },
                "关 闭": function () {
                    $(this).dialog("close");
                }
            });
        }
        ReactDOM.unmountComponentAtNode($("#dialog")[0]);
        ReactDOM.render(
            <CaseList editClick={this.editClick} delClick={this.delClick} chooseCase={this.chooseCase}/>,
            $("#dialog")[0]
        );
    }

    // 新建案件
    createCase() {
        let currentCaseId = CaseApiInst.ciStorage.get("caseId");
        ReactDOM.unmountComponentAtNode($("#dialog")[0]);
        const self = this;
        // 调用生成案件id api
        CaseApiInst.generatorCaseCode((error, data, response) => {
            if (response.ok) {
                ReactDOM.render(
                    <CaseCreate caseId="" caseCode={data.caseCode} caseName="" caseOperator="" kickoffDate=""
                                remark=""/>,
                    $("#dialog")[0]
                );
            }
        });

        dialog.openDialog("#dialog", "新建案件", {
            "确 定": function () {
                let caseId = $("#caseId").val();
                let caseCode = $("#caseCode").val();
                let caseName = $("#caseName").val();
                let caseOperator = $("#caseOperator").val();
                let kickoffDate = $("#kickoffDate").val();
                let remark = $("#remark").val();
                let opt = {};
                console.log(caseId);
                //CaseApiInst.ciStorage.set("caseId", caseId);
                localStorage.caseId = caseId;
                opt['remark'] = remark;
                // 调用新建案件 api
                CaseApiInst.createCase(caseCode, caseName, caseOperator, kickoffDate, opt, (error, data, response) => {
                    if (response.ok) {
                        // 将上方标题替换
                        self.setState({
                            caseId: caseId,
                            caseCode: caseCode,
                            caseName: caseName,
                            caseOperator: caseOperator,
                            kickoffDate: kickoffDate,
                            remark: remark,
                            mailAmount: 0,
                            isCaseSelected: true,
                        });
                        CaseApiInst.ciStorage.set("caseId", data.caseId);
                        // 关闭dialog
                        $(this).dialog("close");
                        self.renderNoLoadData();
                    } else {
                        console.log(`新建案件失败=`, response.data);
                    }
                });
            },
            "取 消": function () {
                $(this).dialog("close");
                if (currentCaseId == "") {
                    self.changeCase("", true);
                } else {
                    self.changeCase("", false);
                }

            }
        });


    }

    // 案件装载 按钮点击事件
    loadCase() {
        console.log("案件装载");
        console.log("调用shell接口选择文件夹");
       let data = "D:\rwe";
        loadmail.showWindow(data);
       /* window.cInsight.selectFileAndFolder(function (data, err) {
            console.log("选择文件", data, " err = ", err);
            loadmail.showWindow(data);
        });*/
    }

    render() {
        let caseTag = <div></div>;
        if (this.state.isCaseSelected) {
            caseTag = (
                <CaseTitle caseId={this.state.caseId}
                           caseCode={this.state.caseCode}
                           caseName={this.state.caseName}
                           caseOperator={this.state.caseOperator}
                           kickoffDate={this.state.kickoffDate}
                           loadCase={this.loadCase}
                           changeCase={this.changeCase}
                />
            );
        }
        return (
            <div>
                {caseTag}
            </div>
        )
    }

}
//案件标题栏
class CaseTitle extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            caseId: this.props.caseId,
            caseCode: this.props.caseCode
        }
    }

    handlerChangeCaseId(e) {
        let value = e.target.value;
        this.setState({
            caseId: value,
        });
    }

    render() {
        return (
            <div className="row caseTitle">
                <div className="col-md-6 case-title1 text-right">
                    <input type="hidden" id="currentCaseId" defaultValue={this.props.caseId}
                           onChange={this.handlerChangeCaseId.bind(this)}/>
                    {this.props.caseCode}：{this.props.caseName}
                </div>
                <div className="col-md-4 case-title2 text-center">
                    <span className="case-title2-1 text-center">{this.props.caseOperator}</span>
                    <span
                        className="case-title2-2 text-center"> · {moment(this.props.kickoffDate).format('YYYY-MM-DD')}</span>
                </div>
                <div className="col-md-2 case-title3 text-left">
                    <button type="button" className="btn btn-default btn-xs change-case-btn"
                            onClick={this.props.changeCase}
                            title="案件切换">
                        <i className="glyphicon glyphicon-folder-open"/>
                    </button>
                    <button type="button" className="btn btn-default btn-xs load-case-btn"
                            onClick={this.props.loadCase} title="邮件装载">
                        <i className="glyphicon glyphicon-import"/>
                    </button>
                </div>
            </div>
        )
    }
}
// 案件列表
class CaseList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data: []
        };
    }

    componentDidMount() {
        const self = this;
        let caseData = [];
        console.log("案件列表重新加载数据");
        // 调用查询案件列表 api
        CaseApiInst.selectCaseList((error, data, response) => {
            if (data) {
                for (let i = 0; i < data.length; i++) {
                    caseData.push({
                        caseId: data[i].caseId,
                        caseCode: data[i].caseCode,
                        caseName: data[i].caseName,
                        caseOperator: data[i].caseOperator,
                        kickoffDate: data[i].kickoffDate,
                        remark: data[i].remark,
                        mailAmount: data[i].mailAmount
                    });
                }
            }
            self.setState({data: caseData});

        });
    }

    render() {
        let lists = this.state.data.map((cmt, idx) => {
            return (
                <li className="ci-case-li" key={idx}>
                    <CaseItem key={idx} caseId={cmt.caseId} caseCode={cmt.caseCode} caseName={cmt.caseName}
                              caseOperator={cmt.caseOperator}
                              kickoffDate={cmt.kickoffDate} remark={cmt.remark} mailAmount={cmt.mailAmount}
                              editClick={this.props.editClick} chooseCase={this.props.chooseCase.bind(this, cmt)}
                              delClick={this.props.delClick} cmt={cmt}/>
                </li>
            );
        });

        return (
            <ul className="nav nav-pills nav-stacked ci-case-area">
                {lists}
            </ul>
        );
    }
}
// 案件条目
class CaseItem extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        let icon = <i className="fa fa-battery-empty"/>;
        if (this.props.mailAmount > 0) {
            icon = <i className="fa fa-battery-full"/>;
        }
        return (
            <div className="ci-case-item">
                <div className="row">
                    <div className="row col-xs-9 ci-case-item-text"
                         onClick={this.props.chooseCase.bind(this, this.props.cmt)}>
                        <div className="col-xs-5 case-id">
                            {icon}&nbsp;&nbsp;
                            {this.props.caseCode}
                        </div>
                        <div className="col-xs-7 case-name">
                            {this.props.caseName}
                        </div>
                        <input className="case-operator" type="hidden" value={this.props.caseOperator}/>
                        <input className="kickoff-date" type="hidden" value={this.props.kickoffDate}/>
                        <input className="remark" type="hidden" value={this.props.remark}/>
                    </div>
                    <div className="col-xs-3 ci-case-item-btn">
                        <button type="button" className="btn btn-default btn-xs ci-case-edit-btn"
                                name={this.props.caseId}
                                onClick={this.props.editClick.bind(this, this.props.caseId, this.props.caseCode, this.props.caseName, this.props.caseOperator, this.props.kickoffDate, this.props.remark, this.props.mailAmount)}>
                            <i className="fa fa-pencil"/>
                        </button>
                        <button type="button" className="btn btn-default btn-xs ci-case-del-btn"
                                name={this.props.caseId}
                                onClick={this.props.delClick.bind(this, this.props.caseId, this.props.caseCode, this.props.caseName)}>
                            <i className="fa fa-close"/>
                        </button>
                    </div>
                </div>
            </div>
        );
    }
}