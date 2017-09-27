import "../../css/contact/contact-content.css";
import React from "react";
import ReactDOM from "react-dom";
import Echarts from "echarts";
import {Table} from "antd";
import PubSub from "pubsub-js";
import Tag from "../common/tag";
import TagShow from "../common/tag-show";
import Note from "../common/note";
import ScrollBox from "../common/ScrollBox";
import {ContactApiInst, MailApiInst} from "../client/index";

const tagController = new Tag();
const noteController = new Note();

/**
 * 联系人详情
 */
export default class ContactContent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            contactId: "",
            contactName: "",
            contactMailAddr: "",
            associateCount: "",
            relations: [],
            diagram: [],
            tags: [],
            data: "",
            style: {
                height: "760px",
                border: "1px solid transparent",
            }
        };
        this.setStateData = this.setStateData.bind(this);
    }

    componentWillMount() {
        this.tokenContactDetailState = PubSub.subscribe("contactContent.load", this.setStateData.bind(this));
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenContactDetailState);
    }

    componentDidMount() {
        let data = this.props.contactData;
        this.setStateData(null, data);
    }

    /**
     * 组装联系人频率图数据
     */
    setDiagram(data) {
        let bar_x = [];
        let bar_y1 = [];
        let bar_y2 = [];
        data.map((cmt) => {
            //bar_x.push(moment(cmt.date).format("YYYY-MM-DD"));
            bar_x.push(cmt.sendTime);
            bar_y1.push(cmt.inboxCount);
            bar_y2.push(cmt.outboxCount);
        });
        var myChart = Echarts.init(document.getElementById('contactBar'));
        myChart.setOption({
                title: {
                    text: '联系人频率图',
                    left: 'center',
                },
                legend: {
                    data: ["收件数", "发件数"],
                    orient: "vertical",
                    right: "10%"
                },
                tooltip: {},
                xAxis: {
                    data: bar_x,
                    name: '时间',
                    splitLine: {show: false},
                    axisLabel: {
                        interval: 0
                    }
                },
                axisLabel: {
                    rotate: 90,
                    interval: 0
                },
                yAxis: {
                    name: '频率'
                },
                series: [
                    {
                        name: '收件数',
                        type: 'line',
                        data: bar_y1
                    },
                    {
                        name: '发件数',
                        type: 'line',
                        data: bar_y2
                    }
                ]
            }
        )
    }

    /**
     * 订阅事件-（为附件详情内容区设置state）
     * @param topic 订阅事件名称
     * @param data 订阅事件数据
     */
    setStateData(topic, data) {
        let caseId = ContactApiInst.ciStorage.get("caseId");
        let contactId = data.contactId.replace(".", "。");
        ContactApiInst.ciStorage.set("contactId", contactId);
        //从联系人列表中获取部分详情界面数据
        let contactName = data.contactName;
        let contactMailAddr = data.contactMailAddr;
        let associateCount = data.associateCount;
        let relations = data.relations;
        let contactDetail = data;
        ContactApiInst.getContactDetail(caseId, contactId, (error, data, response) => {
            if (response.ok) {
                if (data) {
                    this.setDiagram(data.diagram);
                    this.setState({
                        caseId: caseId,
                        contactId: contactId,
                        contactName: contactName,
                        contactMailAddr: contactMailAddr,
                        associateCount: associateCount,
                        relations: relations,
                        notes: data.note,
                        tag: data.tag,
                        data: contactDetail
                    });
                }
            }
        });
    }


    /**
     * 联系人加标签点击事件
     * @param contactId
     */
    handleAddTagClick(id, tag) {
        let caseId = ContactApiInst.ciStorage.get("caseId");
        tagController.tagWindow(id, tag, "", "contactTags",this.state.data);
    }

    /**
     * 联系人加批注点击事件
     * @param contactId
     */
    handleAddNotesClick(contactId, notes) {
        let caseId = ContactApiInst.ciStorage.get("caseId");
        console.log("联系人Id：" + contactId + "案件Id " + caseId + "批注内容 " + notes);
        noteController.notesWindow(contactId, caseId, notes, "contactNotes", this.state.data);
    }

    render() {
        return (
            <div className="panel panel-info">
                <div className="panel-body">
                    <div style={this.state.style}>
                        <ScrollBox>
                            <div className="box box-primary">
                                <div className="box-header with-border">
                                    <i className="fa fa-inbox"/>
                                    <h3 className="box-title">{this.state.contactName + "<" + this.state.contactMailAddr + ">"}</h3>
                                    <div className="box-tools pull-right">
                                        <button type="button" className="btn btn-primary fa fa-plus ci-contact-btn"
                                                onClick={this.handleAddNotesClick.bind(this, this.state.contactId, this.state.note)}>
                                            加批注
                                        </button>
                                    </div>
                                </div>
                                <div className="box-header no-padding with-border">
                                    <div className="row ci-contact-detail-row">
                                        <span className="ci-tag-label">标 签：</span>
                                        <TagShow tag={this.state.tag}
                                                 handleAddTagClick={this.handleAddTagClick.bind(this, this.state.contactId, this.state.tag)}/>
                                    </div>
                                </div>
                                <div className="box-header ci-bar-area with-border">
                                    <div id="contactBar" className="ci-contact-bar"/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-3">
                                    <div className="box box-primary">
                                        <div
                                            className="mailbox-controls with-border text-center"> {this.state.associateCount}
                                            个 {this.state.contactName} 的联系人
                                        </div>
                                        <div className="ci-contact-relation-table">
                                            <AssociateList relations={this.state.relations}/>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-9">
                                    <div className="box box-primary">
                                        <div className="mailbox-controls with-border text-center">相关往来邮件</div>
                                        <div className="ci-contact-mail-table">
                                            <div id="contactRelationMailList"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </ScrollBox>
                    </div>
                </div>
            </div>
        );
    }

}

/**
 * 联系人详情中相关联系人列表
 */
class AssociateList extends React.Component {
    constructor(props) {
        super(props);
    }

    componentWillMount() {
        this.tokenContactDetailState = PubSub.subscribe("contactContent.load", AssociateList.setData.bind(this));
    }

    /**
     * 点击联系人列表时，用于清空相关往来邮件的数据
     */
    static setData() {
        let data = [];
        ReactDOM.render(<ContactsMailList mails={data}/>, $("#contactRelationMailList")[0]);
    }

    handleMailBoxClick(relationMail) {
        console.log("相关往来邮件查询");
        let contactId = ContactApiInst.ciStorage.get("contactId");
        ContactApiInst.getContactRelationList(contactId, relationMail, (error, data, response) => {
            if (response.ok) {
                if (data) {
                    ReactDOM.render(<ContactsMailList mails={data.mails}/>, $("#contactRelationMailList")[0]);
                }
            }
        });
    }

    componentDidMount() {
    }


    render() {
        const columns = [{
            title: '关系邮箱',
            width: '80%',
            dataIndex: 'to',
            render: ((text, data) => {
                return <a href="#"
                          onClick={this.handleMailBoxClick.bind(this, data.to)}>{text}</a>
            }).bind(this)
        }, {
            title: '会话',
            width: '20%',
            dataIndex: 'count',
        }];

        const pagination = {
            total: this.props.relations.length,
            showSizeChanger: true,
            onShowSizeChange(current, pageSize) {
                console.log('Current: ', current, '; PageSize: ', pageSize)
            },
            onChange(current) {
                console.log('Current: ', current)
            }
        };

        return (
            <Table rowKey={record => record.to} columns={columns} dataSource={this.props.relations} bordered
                   pagination={pagination}/>
        );
    }


}

/**
 * 往来邮件列表
 */
class ContactsMailList extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
    }

    handleMailClick(mailId) {
        console.log("点击了邮件:" + mailId);
        // TODO 打开上层浮动页面显示点击邮件详情
    }

    render() {
        const columns = [{
            title: '主题',
            width: '70%',
            dataIndex: 'subject',
            render: ((text, data) => {
                return <a href="#" onClick={this.handleMailClick.bind(this, data.mailId)}>{text}</a>
            }).bind(this)
        }, {
            title: '发送时间',
            width: '30%',
            dataIndex: 'sendTime',
            render: ((text) => {
                return moment(text).format("YYYY-MM-DD HH:mm:ss");
            })
        }];

        const pagination = {
            total: this.props.mails.length,
            showSizeChanger: true,
            onShowSizeChange(current, pageSize) {
                console.log('Current: ', current, '; PageSize: ', pageSize)
            },
            onChange(current) {
                console.log('Current: ', current)
            }
        };

        return (
            <Table rowKey={record => record.mailId} columns={columns} dataSource={this.props.mails} bordered
                   pagination={pagination}/>
        );
    }

}