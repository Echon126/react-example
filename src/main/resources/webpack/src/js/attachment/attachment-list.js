import "../../css/attachment/attachment-list.css";
import React from "react";
import {Table} from "antd";
import PubSub from "pubsub-js";
import ScrollBox from "../common/ScrollBox";
import {AttachmentApiInst} from "../client/index";

/**
 * 附件详情-左侧列表
 * Created by xcp on 2017/5/10.
 */
export default class AttachmentList extends React.Component {
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
        this.tokenSetAttachmentList = PubSub.subscribe("tabList.load", this.setAttachmentList.bind(this));
        console.log("attachment tokens=", this.tokenExpand, this.tokenShrink);
    }

    componentDidMount() {
        //this.setAttachmentList("","")
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenShrink);
        PubSub.unsubscribe(this.tokenExpand);
        PubSub.unsubscribe(this.tokenSetAttachmentList);
    }

    /**
     * 加载附件列表
     * @param topic
     * @param conditions
     */
    setAttachmentList(topic, conditions) {
        let caseId = AttachmentApiInst.ciStorage.get("caseId");
        AttachmentApiInst.selectAttachmentList(caseId, conditions, (error, data, response) => {
                if (response.ok) {
                    PubSub.publish("hitListCount.attachment", data.total);//用于显示命中的附件数量
                    this.setState({tableData: data.attachments});
                }
            }
        );
    }

    handleItemClicked(attachmentId, data) {
        this.setShrink();
        // 收缩列表界面，展开详情界面
        PubSub.publish("contentFrame.shrink", this);
        PubSub.publish("contentPanel.show", {type: "attachment", id: attachmentId});
        PubSub.publish("attachmentContent.load", attachmentId);
        this.setState({activeId: attachmentId});
        let selector = data.selector;
        if (selector) {
            $("#ws-attachment-list .nav .active").each(function () {
                $(this).removeClass("active")
            });
            $("#" + selector).addClass("active");
        }

    }

    /**
     * 处理界面收缩事件
     */
    setShrink() {
        console.log("!!attachment list got shrink event");
        this.setState({isExpand: false}, function () {
            console.log("shrink complete, state=", this.state);
        });
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
                title: '附件名称',
                width: '15%',
                dataIndex: 'attachmentName',
                render: ((text, data) => {
                    return <a href="#" onClick={this.handleItemClicked.bind(this, data.attachmentId)}>{text}</a>
                }).bind(this)
            }, {
                title: '大小',
                width: '20%',
                dataIndex: 'attachmentSize',
                render: ((text) => {
                    return text === null ? 0 : text
                })
            }, {
                title: '转发次数',
                width: '20%',
                dataIndex: 'refrenceCount',
                render: ((text) => {
                    return text === null ? 0 : text
                })
            }, {
                title: '标签',
                width: '10%',
                dataIndex: 'tagCount',
                render: ((text) => {
                    return text === null ? 0 : text
                })
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
                <Table rowKey={record => record.attachmentId} columns={columns} dataSource={this.state.tableData}
                       bordered
                       pagination={pagination}/>
            )
        } else {
            let attachmentList = this.state.tableData.map((item, idx) => {
                return (
                    <li key={idx}
                        className={"ci-attachment-shrink-row " + (this.state.activeId == item.attachmentId ? "active" : "")}
                        id={"ws-attachment-item-" + item.attachmentId}>
                        <a onClick={this.handleItemClicked.bind(this, item.attachmentId, {selector: "ws-attachment-item-" + item.attachmentId})}>
                            <span>{item.attachmentName}</span>
                            <span className="label label-primary pull-right">{item.referenceCount}</span>

                            <div className="text-gray">{item.attachmentSize}</div>
                        </a>
                    </li>
                );
            });
            return (
                <div className="box box-solid" id="ws-attachment-list">
                    <div className="box-body no-padding">
                        <div style={this.state.style}>
                            <ScrollBox>
                                <ul className="nav nav-pills nav-stacked">
                                    {attachmentList}
                                </ul>
                            </ScrollBox></div>
                    </div>
                </div>
            );
        }
    }
}