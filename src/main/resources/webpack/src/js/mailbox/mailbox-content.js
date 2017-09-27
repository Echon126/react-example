import "../../css/mailbox/mailbox-content.css";
import React from "react";
import {Table} from "antd";
import PubSub from "pubsub-js";
import Notes from "../common/note";
import Tags from "../common/tag";
import TagShow from "../common/tag-show";
import MailContent from "../mail/mail-content";
import ScrollBox from "../common/ScrollBox";
import {MailboxApiInst} from "../client/index";

const noteController = new Notes();
const tagController = new Tags();

/**
 * 邮件列表
 */
class MailboxTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            tableData: []
        };
    }

    componentDidMount() {

    }

    handleItemClicked(item) {
        console.log("点击了邮件:", item);

        // 显示浮动详情界面
        PubSub.publish("floatContentPanel.show", {
            data: item, tag: (
                <MailContent mailId={item.mailId} isFloat={true}/>
            )
        });

    }

    setTableData(data) {
        this.setState({
            tableData: data
        })
    }

    render() {
        let columns = [{
            title: '主题',
            dataIndex: 'subject',
            render: function (text, record, index) {
                return <a href="javascript:" onClick={this.handleItemClicked.bind(this, record)}>{text}</a>
            }.bind(this)
        }, {
            title: '发送时间',
            dataIndex: 'sendTime'
        }, {
            title: '标签',
            dataIndex: 'tagCount'
        }, {
            title: '附件',
            dataIndex: 'attachmentCount'
        }];

        const pagination = {
            total: this.state.tableData.length,
            showSizeChanger: true,
            onShowSizeChange(current, pageSize) {
                console.log('Current: ', current, '; PageSize: ', pageSize)
            },
            onChange(current) {
                console.log('Current: ', current)
            }
        };

        return (
            <Table columns={columns} dataSource={this.state.tableData} bordered
                   pagination={pagination}/>
        );
    }
}

/**
 * 邮箱详情
 */
export default class MailboxContent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            from: "",
            to: "",
            cc: "",
            subject: "",
            content: "",
            data: {
                inboxCount: 0,
                outboxCount: 0,
                draftboxCount: 0,
                trashboxCount: 0
            },
            tags: [],
            inboxData: [],
            outboxData: [],
            draftboxData: [],
            trashboxData: [],
            tabPanels: {
                inbox: {label: "收件箱", tag: <MailboxTable ref="inboxTable" boxType="inbox"/>, icon: "envelope"},
                outbox: {label: "发件箱", tag: <MailboxTable ref="outboxTable" boxType="outbox"/>, icon: "envelope"},
                draftbox: {label: "草稿箱", tag: <MailboxTable ref="draftboxTable" boxType="draftbox"/>, icon: "envelope"},
                trashbox: {label: "垃圾箱", tag: <MailboxTable ref="trashboxTable" boxType="trashbox"/>, icon: "envelope"}
            },
            style: {
                height: "760px",
                border: "1px solid transparent",
            }
        };
    }

    componentWillMount() {
        this.tokenShow = PubSub.subscribe("mailboxContent.load", this.loadData.bind(this));
    }

    componentDidMount() {
        let data = this.props.mailboxData;
        this.loadData(null, data);
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenShow);
    }

    /**
     * 加批注
     * @param mailboxId
     */
    handleAddNotesClick(mailboxId, notes) {
        let caseId = MailboxApiInst.ciStorage.get("caseId");
        console.log("邮箱Id：" + mailboxId + "案件Id " + caseId + "批注内容 " + notes);
        noteController.notesWindow(mailboxId, caseId, notes, "mailboxNotes");
    }

    /**
     * 加标签点击事件
     * @param id
     */
    handleAddTagClick(id) {
        let caseId = MailboxApiInst.ciStorage.get("caseId");
        console.log("加标签" + "邮箱id " + id + "案件id" + caseId);
        tagController.tagWindow(id, caseId, "mailboxTags");
    }

    /**
     * 邮件筛选
     * @param event
     */
    handleFilterClicked(mailboxId) {
        console.log("根据筛选条件进行查询 = ", this.state);
        let caseId = MailboxApiInst.ciStorage.get("caseId");
        let conditions = this.state;
        this.loadListData(caseId, mailboxId, conditions);
    }

    handleInputChanged(fieldName) {
        return function (inputName, event) {
            this.setState({[inputName]: event.target.value});
        }.bind(this, fieldName)

    }

    /**
     * 加载收件箱数据
     */
    setInboxData(caseId, mailboxId, conditions) {
        MailboxApiInst.selecInboxList(caseId, mailboxId, conditions, (error, data, response) => {
            if (response.ok) {
                this.setState({inboxData: data}, function () {
                    this.refs["inboxTable"].setTableData(this.state.inboxData)
                }.bind(this));
            }
        });
    }

    /**
     * 加载发件箱数据
     */
    setOutboxData(caseId, mailboxId, conditions) {
        MailboxApiInst.selecOutboxList(caseId, mailboxId, conditions, (error, data, response) => {
            if (response.ok) {
                this.setState({outboxData: data}, function () {
                    this.refs["outboxTable"].setTableData(this.state.outboxData)
                }.bind(this));
            }
        });

    }

    /**
     * 加载草稿箱数据
     */
    setDraftboxData(caseId, mailboxId, conditions) {
        MailboxApiInst.selecDraftboxList(caseId, mailboxId, conditions, (error, data, response) => {
            if (response.ok) {
                this.setState({draftboxData: data}, function () {
                    this.refs["draftboxTable"].setTableData(this.state.draftboxData)
                }.bind(this));
            }
        });
    }

    /**
     * 加载垃圾箱数据
     */
    setTrashboxData(caseId, mailboxId, conditions) {
        MailboxApiInst.selecTrashList(caseId, mailboxId, conditions, (error, data, response) => {
            if (response.ok) {
                this.setState({trashboxData: data}, function () {
                    this.refs["trashboxTable"].setTableData(this.state.trashboxData)
                }.bind(this))
            }
        });
    }

    /**
     * 加载邮箱详情界面的四个列表的数据
     * @param caseId
     * @param mailboxId
     * @param conditions 筛选条件
     */
    loadListData(caseId, mailboxId, conditions) {
        this.setInboxData(caseId, mailboxId, conditions);
        this.setOutboxData(caseId, mailboxId, conditions);
        this.setDraftboxData(caseId, mailboxId, conditions);
        this.setTrashboxData(caseId, mailboxId, conditions);
    }

    /**
     * 联动显示邮箱详情
     * @param topic
     * @param item
     */
    loadData(topic, item) {
        console.log("execute loadData with item = ", item);
        let caseId = MailboxApiInst.ciStorage.get("caseId");
        let mailboxId = item.mailboxId;
        MailboxApiInst.getMailboxStatistics(caseId, mailboxId, {}, (error, data, response) => {
            if (response.ok) {
                this.setState({
                    caseId: caseId,
                    mailboxId: item.mailboxId,
                    mailboxAddress: item.mailboxAddress,
                    notes: item.note,
                    tags: item.tags,
                    data: {
                        inboxCount: data.inboxCount,
                        outboxCount: data.outboxCount,
                        draftboxCount: data.draftboxCount,
                        trashboxCount: data.trashCount
                    }
                }, function () {
                    $("#ci-mb-content-tabs li").removeClass("active");
                    $("#ci-mb-content-tabs li:first").addClass("active");
                    $("#ci-mb-content-tabPanes .tab-pane").removeClass("active");
                    $("#tab_inbox").addClass("active");

                    for (let key in this.state.tabPanels) {
                        this.refs[key + "Table"].setTableData(this.state[key + "Data"]);
                    }
                });
            }
        });
        this.loadListData(caseId, mailboxId, {});//首次进入邮箱详情界面时，邮件筛选条件为空
    }

    render() {

        let tabHandlerList = [], tabPanelList = [];

        for (let key in this.state.tabPanels) {
            let item = this.state.tabPanels[key];

            tabHandlerList.push(
                <li className={key == "inbox" ? "active" : ""} key={key}>
                    <a href={"#tab_" + key} data-toggle="tab" aria-expanded="true"><i
                        className={"fa fa-" + item.icon}/> {item.label}<span
                        className="pull-right">({this.state.data[key + "Count"]})</span></a>
                </li>
            );

            tabPanelList.push(
                <div className={key == "inbox" ? "tab-pane active" : "tab-pane"} id={"tab_" + key} key={key}>
                    {item.tag}
                </div>
            );
        }

        return (
            <div className="panel panel-info">
                <div className="panel-body">
                    <div style={this.state.style}>
                        <ScrollBox>
                            <div className="box box-primary">
                                <div className="box-header with-border">
                                    <i className="fa fa-inbox"/>
                                    <h3 className="box-title">{this.state.mailboxAddress} &lg; {this.state.mailboxId}</h3>

                                    <div className="box-tools pull-right">
                                        <button type="button" className="btn btn-primary fa fa-plus ci-contact-btn"
                                                onClick={this.handleAddNotesClick.bind(this, this.state.mailboxId, this.state.notes)}>
                                            加批注
                                        </button>
                                    </div>
                                </div>

                                <div className="box-body no-padding">

                                    <div className="mailbox-controls with-border">
                                        <span className="ci-tag-label">标 签：</span>
                                        <div className="ci-tag-content">
                                            <TagShow tags={this.state.tags}
                                                     handleAddTagClick={this.handleAddTagClick.bind(this, this.state.mailboxId)}/>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <div className="box box-default">
                                <div className="box-header with-border">
                                    <h3 className="box-title">邮件筛选</h3>

                                    <div className="box-tools pull-right">
                                        <button type="button" className="btn btn-box-tool" data-widget="collapse"><i
                                            className="fa fa-minus"/>
                                        </button>
                                    </div>
                                </div>
                                <div className="box-body no-padding">
                                    <div className="input-group">
                                        <span className="input-group-addon">发件人</span>
                                        <input type="text" className="form-control" placeholder="sample@mail.com"
                                               onChange={this.handleInputChanged("from")}
                                               value={this.state.from}/>
                                        <span className="input-group-addon">收件人</span>
                                        <input type="text" className="form-control" placeholder="sample@mail.com"
                                               onChange={this.handleInputChanged("to")}
                                               value={this.state.to}/>
                                        <span className="input-group-addon">抄送</span>
                                        <input type="text" className="form-control" placeholder="sample@mail.com"
                                               onChange={this.handleInputChanged("cc")}
                                               value={this.state.cc}/>
                                    </div>

                                    <div className="input-group">
                                        <span className="input-group-addon">主题</span>
                                        <input type="text" className="form-control" placeholder="多个关键词之间可用空格或逗号分割"
                                               onChange={this.handleInputChanged("subject")}
                                               value={this.state.subject}/>
                                        <span className="input-group-addon">正文</span>
                                        <input type="text" className="form-control" placeholder="多个关键词之间可用空格或逗号分割"
                                               onChange={this.handleInputChanged("content")}
                                               value={this.state.content}/>
                                        <div className="input-group-btn">
                                            <button type="button"
                                                    className="btn btn-primary"
                                                    onClick={this.handleFilterClicked.bind(this, this.state.mailboxId)}>
                                                <i
                                                    className="fa fa-search"/>
                                            </button>
                                        </div>
                                    </div>
                                </div>

                                <div className="box-footer">

                                    <div className="nav-tabs-custom">
                                        <ul className="nav nav-tabs" id="ci-mb-content-tabs">
                                            {tabHandlerList}
                                        </ul>
                                        <div className="tab-content" id="ci-mb-content-tabPanes">
                                            {tabPanelList}
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