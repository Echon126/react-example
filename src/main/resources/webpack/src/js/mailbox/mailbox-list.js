import React from "react";
import {Table} from "antd";
import PubSub from "pubsub-js";
import ScrollBox from "../common/ScrollBox";
import {MailboxApiInst} from "../client/index";

/**
 * 邮箱列表-完整版
 */
export default class MailboxList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isExpand: true,
            activeId: 0,
            tableData: [],
            tags: [],
            style: {
                height: "680px",
                border: "1px solid transparent",
            }
        };
        this.handleItemClicked = this.handleItemClicked.bind(this);
    }

    componentWillMount() {
        this.tokenExpand = PubSub.subscribe("contentFrame.expand", this.setExpand.bind(this));
        this.tokenShrink = PubSub.subscribe("contentFrame.shrink", this.setShrink.bind(this));
        this.tokenSetMailboxList = PubSub.subscribe("tabList.load", this.setMailboxList.bind(this));
    }

    componentDidMount() {
        //this.setMailboxList("","");
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenShrink);
        PubSub.unsubscribe(this.tokenExpand);
        PubSub.unsubscribe(this.tokenSetMailboxList);
    }

    handleItemClicked(item, data) {
        console.log("加载邮箱详情");
        PubSub.publish("contentFrame.shrink", this);
        PubSub.publish("contentPanel.show", {type: "mailbox", item: item});
        PubSub.publish("mailboxContent.load", item);
        this.setState({activeId: item.mailboxId});

        let selector = data.selector;

        if (selector) {
            $("#ws-mailbox-list .nav .active").each(function () {
                $(this).removeClass("active")
            });
            $("#" + selector).addClass("active");
        }

    }

    /**
     * 加载邮箱列表
     */
    setMailboxList(topic, conditions) {
        let caseId = MailboxApiInst.ciStorage.get("caseId");
        MailboxApiInst.selectMailboxList(caseId, conditions, (error, data, response) => {
            if (response.ok) {
                PubSub.publish("hitListCount.mailbox",parseInt(Math.random()*(20-10)+10,10));
                this.setState({
                    tableData: data
                })
            }
        });
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
    }

    render() {
        const columns = [
            {
                title: '邮箱名称',
                width: '15%',
                dataIndex: 'mailboxAddress',
                render: ((text, data) => {
                    return <a href="#" onClick={this.handleItemClicked.bind(this, data)}>{text}</a>
                }).bind(this)
            }, {
                title: '收件箱',
                width: '20%',
                dataIndex: 'inboxCount'
            }, {
                title: '发件箱',
                width: '20%',
                dataIndex: 'outboxCount'
            }, {
                title: '草稿箱',
                width: '10%',
                dataIndex: 'draftboxCount'
            }, {
                title: '垃圾箱',
                width: '10%',
                dataIndex: 'trashCount'
            }
        ];

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
        if (this.state.isExpand) {
            return (
                <Table rowKey={record => record.mailboxId} columns={columns} dataSource={this.state.tableData} bordered pagination={pagination}/>
            )
        } else {
            let dataList = this.state.tableData.map((item, idx) => {
                return (
                    <li key={idx}
                        className={"ci-mailbox-shrink-row " + (this.state.activeId == item.mailboxId ? "active" : "")}
                        id={"ws-mailbox-item-" + item.mailboxId}>
                        <a onClick={this.handleItemClicked.bind(this, item, {selector: "ws-mailbox-item-" + item.mailboxId})}>
                            <i className="fa  fa-inbox"/>{item.mailboxAddress}</a>
                    </li>
                );
            });
            return (
                <div className="box box-solid" id="ws-mailbox-list">
                    <div className="box-body no-padding">
                        <div style={this.state.style}>
                            <ScrollBox>
                                <ul className="nav nav-pills nav-stacked">
                                    {dataList}
                                </ul>
                            </ScrollBox>
                        </div>
                    </div>
                </div>
            );
        }
    }
}