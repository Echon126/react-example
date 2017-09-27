import "../../css/mail/mail-content.css";
import React from "react";
import {Table} from "antd";
import PubSub from "pubsub-js";
import {MailApiInst} from "../client/index";
import ScrollBox from "../common/ScrollBox";

/**
 * 邮件列表-完整版
 */
export default class MailList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isExpand: true,
            tableData: [],
            style: {
                height: "680px",
                border: "1px solid transparent",
            }
        };

    }

    componentWillMount() {
        this.tokenExpand = PubSub.subscribe("contentFrame.expand", this.setExpand.bind(this));
        this.tokenShrink = PubSub.subscribe("contentFrame.shrink", this.setShrink.bind(this));
        this.tokenSetMailList = PubSub.subscribe("tabList.load", this.setMailList.bind(this));

    }

    componentDidMount() {
        //this.setMailList("",[]);
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenShrink);
        PubSub.unsubscribe(this.tokenExpand);
        PubSub.unsubscribe(this.tokenSetMailList);

    }

    /**
     * 加载邮列表数据
     * @param topic
     * @param data
     */
    setMailList(topic, conditions) {
        let caseId = MailApiInst.ciStorage.get("caseId");
        MailApiInst.selectMailList(caseId, conditions, (error, data, response) => {
            if (response.ok) {
                //PubSub.publish("hitListCount.mail",parseInt(Math.random()*(20-10)+10,10));
                PubSub.publish("hitListCount.mail", data.total);
                this.setState({
                    tableData: data.mails
                });
            }
        });
    }

    /**
     * 邮件详情
     */
    handleItemClicked(mailId, data) {
        // 收缩列表界面，展开详情界面
        PubSub.publish("contentFrame.shrink", this);
        PubSub.publish("contentPanel.show", {type: "mail", id: mailId});
        PubSub.publish("mailContent.load", mailId);

        this.setState({activeId: mailId});
        let selector = data.selector;
        if (selector) {
            $("#ws-mail-list .nav .active").each(function () {
                $(this).removeClass("active")
            });
            $("#" + selector).addClass("active");
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

    }

    render() {
        const columns = [
            {
                title: '标题',
                dataIndex: 'subject',
                render: ((text, data) => {
                    return <a href="#" onClick={this.handleItemClicked.bind(this, data.mailId)}>{text}</a>
                }).bind(this)
            }, {
                title: '邮箱',
                dataIndex: 'from'
            }, {
                title: '时间',
                dataIndex: 'sendTime',
                render: ((text) => {
                    return moment(text).format("YYYY-MM-DD HH:mm:ss");
                })
            }, {
                title: '会话数',
                dataIndex: 'sessionCount',
                render: ((text) => {
                    return text === null ? 0 : text;
                })
            }, {
                title: '标签',
                dataIndex: 'tagCount',
                render: ((text) => {
                    return text === null ? 0 : text;
                })
            }, {
                title: '附件',
                dataIndex: 'attachmentCount',
                render: ((text) => {
                    return text === null ? 0 : text;
                })
            }
        ];

        const pagination = {
            total: this.state.tableData.length,
            showSizeChanger: true,
            onShowSizeChange(current, pageSize) {
                console.log('Current: ', current, '; PageSize: ', pageSize);
            },
            onChange(current) {
                console.log('Current: ', current);
            }
        };

        if (this.state.isExpand) {
            return (
                <Table rowKey={record => record.mailId} columns={columns} dataSource={this.state.tableData} bordered
                       pagination={pagination}/>
            );
        } else {
            let mailShrink = this.state.tableData.map((item, idx) => {
                return (
                    <li key={idx}
                        className={"ci-mail-shrink-row " + (this.state.activeId == item.mailId ? "active" : "")}
                        id={"ws-mail-item-" + item.mailId}>
                        <a onClick={this.handleItemClicked.bind(this, item.mailId, {selector: "ws-mail-item-" + item.mailId})}>
                            <small className="text-gray">{item.from}</small>
                            <span className="label label-primary pull-right">{item.sessionCount}</span>
                            <div className="ci-mail-subject">{item.subject}</div>
                        </a>
                    </li>
                );
            });
            return (
                <div className="box box-solid" id="ws-mail-list">
                    <div className="box-body no-padding">
                        <div style={this.state.style}>
                            <ScrollBox>
                                <ul className="nav nav-pills nav-stacked">
                                    {mailShrink}
                                </ul>
                            </ScrollBox>
                        </div>
                    </div>
                </div>
            );
        }
    }
}