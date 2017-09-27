import React from "react";
import Vis from "vis";
import PubSub from "pubsub-js";
import ScrollBox from "../common/ScrollBox";
import {ContactApiInst} from "../client/index";

/**
 * 联系人关系图
 */
export default class ContactList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isExpand: true,
            activeId: 0,
            dataList: [],
            diagram: null,
            nodes: [],
            edges: [],
            style: {
                height: "680px",
                border: "1px solid transparent",
            }
        };
    }

    componentWillMount() {
        this.tokenExpand = PubSub.subscribe("contentFrame.expand", this.setExpand.bind(this));
        this.tokenShrink = PubSub.subscribe("contentFrame.shrink", this.setShrink.bind(this));
        this.tokenSetContactList = PubSub.subscribe("tabList.load", this.setContactList.bind(this));
    }

    componentDidMount() {
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenShrink);
        PubSub.unsubscribe(this.tokenExpand);
        PubSub.unsubscribe(this.tokenSetContactList);
    }

    //加载联系人关系图
    setContactList(topic, conditions) {
        let caseId = ContactApiInst.ciStorage.get("caseId");
        let dataSources = [];
        let nodes = [];
        let edges = [];
        ContactApiInst.selectContactList(caseId, conditions, (error, data, response) => {
            if (data) {
                PubSub.publish("hitListCount.contact", data.total);//加载检索到的联系人数量
                let contactData = data.contacts;
                for (let i = 0; i < contactData.length; i++) {
                    dataSources.push({
                        caseId: caseId,
                        contactId: contactData[i].contactId,
                        contactName: contactData[i].contactName,
                        contactMailAddr: contactData[i].contactMailAddr,
                        relations:contactData[i].relations,
                        associateCount: contactData[i].relations.length

                    });
                    //拼接联系人关系图数据
                    nodes.push({
                        id: contactData[i].contactId,
                        label: contactData[i].contactMailAddr
                    });
                    //拼接关系图连线数据
                    let relation = contactData[i].relations;
                    for (let j = 0; j < relation.length; j++) {
                        edges.push({
                            from: contactData[i].contactId,
                            to: relation[j].mailboxId,
                            arrows: "to"
                        })
                    }
                }
            }
        });
        this.setState({dataList: dataSources, nodes: nodes, edges: edges});
    }

    /**
     * 处理界面收缩事件
     */
    setShrink() {
        this.setState({isExpand: false});
        $(".vis-network").hide();
    }

    /**
     * 处理界面展开事件
     */
    setExpand() {
        this.setState({isExpand: true}, function () {
            $(".vis-network").show();
        });
    }

    /**
     * 构建关系图
     */
    makeDiagram() {
        let nodes = new Vis.DataSet(this.state.nodes);
        let edges = new Vis.DataSet(this.state.edges);
        let data = {
            nodes: nodes,
            edges: edges,
        };
        let options = {
            autoResize: true,
            height: '430px',
            width: '100%',
            nodes: {shadow: true}
        };

        let container = document.getElementById("ws-contact-diagram");
        let network = new Vis.Network(container, data, options);
        network.on("click", function (event) {
            console.log("Vis click with event = ", event);
            console.log("Vis click this = ", this);
            //用于联系人列表和详情界面联动
            let data = this.state.dataList;
            let contactId = event.nodes;
            let item = "";
            for (let i = 0; i < data.length; i++) {
                if (contactId == data[i].contactId) {
                    item = data[i];
                }
            }
            this.handleItemClicked(item, {diagram: data});

        }.bind(this));
        network.redraw();

        this.setState({
            diagram: network
        }, function () {
            console.log("diagram position = ", network.getViewPosition())
        });
    }

    handleItemClicked(item, data) {
        console.log("联系人详情界面");
        PubSub.publish("contentFrame.shrink", this);
        PubSub.publish("contentPanel.show", {type: "contact", item: item});
        PubSub.publish("contactContent.load", item);
        this.setState({activeId: item.contactId});

        let selector = data.selector;
        if (selector) {
            $("#ws-contact-list .nav .active").each(function () {
                $(this).removeClass("active")
            });
            //$("#" + selector).addClass("active");
            document.getElementById(selector).className += "active";
        }

    }

    render() {
        if (this.state.isExpand) {
            return (
                <div id="ws-contact-diagram-container">
                    <div id="ws-contact-diagram" className="vis-network"/>
                </div>
            )
        } else {

            let contactList = this.state.dataList.map((item) => {
                return (
                    <li key={item.contactId}
                        className={"ci-contact-shrink-row " + (this.state.activeId == item.contactId ? "active" : "")}
                        id={"ws-contact-item-" + item.contactId}>
                        <a onClick={this.handleItemClicked.bind(this, item, {selector: "ws-contact-item-" + item.contactId})}>
                            <i className="fa fa-user"/>
                            {item.contactName}
                            <span className="label label-primary pull-right">{item.associateCount}</span>
                        </a>
                    </li>
                )
            });

            return (
                <div className="box box-solid" id="ws-contact-list">
                    <div className="box-body no-padding">
                        <div style={this.state.style}>
                            <ScrollBox>
                                <ul className="nav nav-pills nav-stacked">
                                    {contactList}
                                </ul>
                            </ScrollBox>
                        </div>
                    </div>
                </div>
            )

        }
    }
}