import "../../css/attachment/attachment-content.css";
import React from "react";
import ReactDOM from "react-dom";
import {Table} from "antd";
import PubSub from "pubsub-js";
import Tag from "../common/tag";
import TagShow from "../common/tag-show";
import Note from "../common/note";
import ScrollBox from "../common/ScrollBox";
import MailContent from "../mail/mail-content";
import {AttachmentApiInst} from "../client/index";

const tagController = new Tag();
const noteController = new Note();

/**
 * 附件详情-右侧内容区
 * Created by xcp on 2017/5/10.
 */
export default class AttachmentContent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            caseId: "",
            attachmentId: "",
            attachmentName: "",
            attachmentSize: "",
            referenceCount: "",
            fileType: "",
            filePath: "",
            tableData: [],
            data: [],
            tags: [],
            total: 0,
            isFloat: this.props.isFloat,
            style: {
                height: "760px",
                border: "1px solid transparent",
            }
        };
        this.loadData = this.loadData.bind(this);
        this.handleRelationClick = this.handleRelationClick.bind(this);
    }

    componentWillMount() {
        this.tokenAttachmentDetailState = PubSub.subscribe("attachmentContent.load", this.loadData.bind(this));
    }

    componentDidMount() {
        this.loadData(null, this.props.attachmentId);
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenAttachmentDetailState);
    }

    /**
     * 订阅事件-（为附件详情内容区设置state）
     * @param topic 订阅事件名称
     * @param data 订阅事件数据
     */
    loadData(topic, attachmentId) {
        let caseId = AttachmentApiInst.ciStorage.get("caseId");
        AttachmentApiInst.getAttachmentDetail(caseId, attachmentId, (error, data, response) => {
            if (response.ok) {
                this.setState({
                    caseId: caseId,
                    attachmentId: data.attachmentId,
                    attachmentName: data.attachmentName,
                    attachmentSize: data.attachmentSize,
                    createTime: data.createTime,
                    attachmentContent: data.content,
                    notes: data.note,
                    fileType: data.fileType,
                    filePath: data.filePath,
                    tag: data.tag,
                    author: data.author,
                    gps: data.gps,
                    camera: data.camera,
                    company: data.company,
                    shotTime: data.shotTime,
                    referenceCount: data.referenceCount,
                    sysTagCount: data.sysTagCount
                });
            }
        });

        /**
         * 相关性分析列表数据
         */
        AttachmentApiInst.getAttachmentRelation(caseId, attachmentId, (error, data, response) => {
            if (response.ok) {
                if (data) {
                    this.setState({
                        tableData: data.mails,
                        total: data.total
                    })
                }
            }
        });

    }

    /**
     * 组件数据变化时，解绑附件主内容区，并重新绘制显示附件内容
     * */
    componentDidUpdate() {
        ReactDOM.unmountComponentAtNode($("#attachmentMainContent")[0]);
        ReactDOM.render(
            <AttachmentShow filePath={this.state.filePath} fileType={this.state.fileType}
                            fileContent={this.state.attachmentContent}/>,
            $("#attachmentMainContent")[0]
        );
    }

    /**
     * 加标签点击事件
     * @param e
     */
    handleAddTagClick(attachmentId, tag, sysTagCount) {
        tagController.tagWindow(attachmentId, tag, sysTagCount, "attachmentTags");
    }

    /**
     * 加批注点击事件
     * @param id
     */
    handleAddNotesClick(attachmentId, notes) {
        let caseId = AttachmentApiInst.ciStorage.get("caseId");
        noteController.notesWindow(attachmentId, caseId, notes, "attachmentNotes");
    }

    /**
     * 相关性分析点击按钮事件
     * @param id
     */
    handleRelationClick(id) {
        ReactDOM.unmountComponentAtNode($("#attachmentMainContent")[0]);
        ReactDOM.render(
            <AttachmentRelation data={this.state.tableData} attachmentCount={this.state.total}
                                handlerSubjectClick={this.handlerSubjectClick.bind(this)}/>,
            $("#attachmentMainContent")[0]
        );
    }

    /**
     * 相关性分析中 邮件点击
     * @param item
     */
    handlerSubjectClick(item) {
        if (!this.state.isFloat) {
            // 显示邮件浮动详情界面
            PubSub.publish("floatContentPanel.show", {
                data: item, tag: (
                    <MailContent mailId={item.mailId} isFloat={true}/>
                )
            });
            // 加载邮件详情数据
            PubSub.publish("mailContent.load", item);
        } else {
            console.log("当前邮件详情中 -> 附件相关性分析 -> 邮件不可点击");
        }
    }


    /**
     * 附件导出点击按钮事件
     * @param id
     */
    handleAttachmentExportClick(filePath) {
        console.log("附件导出：" + filePath);
        window.cInsight.exportAttachment(filePath, function (data, err) {
            console.log("export attachment with data = ", data, " err = ", err)
        })
    }

    /**
     * 本地应用打开点击按钮事件
     * @param id
     */
    handleLocalOpenClick(filePath) {
        console.log("本地应用打开：" + filePath);
        window.cInsight.openAttachment(filePath, function (data, err) {
            console.log("export attachment with data = ", data, " err = ", err)
        })
    }

    render() {
        return (
            <div className="panel panel-info">
                <div className="panel-body">
                    <div style={this.state.style}>
                        <ScrollBox>
                            <div className="box box-primary">
                                <div className="box-body no-padding">
                                    <div className="mailbox-read-info">
                                        <h5>{this.state.attachmentName}
                                            <span className="mailbox-read-time pull-right">
                                         <button type="button"
                                                 className="btn btn-block btn-primary btn-sm ci-attachment-btn"
                                                 onClick={this.handleAddNotesClick.bind(this, this.state.attachmentId, this.state.note)}>加批注</button></span>
                                        </h5>
                                    </div>
                                    <div className="mailbox-read-info">
                                        <h5><span className="ci-attachment-attr">作者：{this.state.author}</span><span
                                            className="ci-attachment-attr">公司：{this.state.company}</span><span
                                            className="ci-attachment-attr">相机：{this.state.camera}</span><span
                                            className="ci-attachment-attr">GSP:{this.state.gps}</span>
                                            <span className="mailbox-read-time pull-right">
                                    <button type="button" className="btn btn-block btn-primary btn-sm ci-attachment-btn"
                                            onClick={this.handleRelationClick.bind(this, this.state.attachmentId)}>相关性分析</button></span>
                                        </h5>
                                    </div>
                                    <div className="mailbox-read-info">
                                        <h5>创建时间：{moment(this.state.createTime).format("YYYY-MM-DD")}
                                            <span className="mailbox-read-time pull-right">
                                    <button type="button" className="btn btn-block btn-primary btn-sm ci-attachment-btn"
                                            onClick={this.handleAttachmentExportClick.bind(this, this.state.filePath)}>附件导出</button></span>
                                        </h5>
                                    </div>
                                    <div className="mailbox-read-info">
                                        <h5>大小：{this.state.attachmentSize}<span
                                            className="mailbox-read-time pull-right">
                                 <button type="button" className="btn btn-block btn-primary btn-sm ci-attachment-btn"
                                         onClick={this.handleLocalOpenClick.bind(this, this.state.filePath)}>本地应用打开</button> </span>
                                        </h5>
                                    </div>
                                    <div className="mailbox-read-info">
                                        <h5>标 签：<TagShow tag={this.state.tag}
                                                         handleAddTagClick={this.handleAddTagClick.bind(this, this.state.attachmentId, this.state.tag, this.state.sysTagCount)}/>
                                        </h5>
                                    </div>
                                    <div id="attachmentMainContent">
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
 * 附件展示
 */
class AttachmentShow extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
    }

    static haveCode(code) {
        let Icon = {
            'jpg': 'jpg',
            'png': 'png',
            'gif': 'gif',
            'jpeg': 'jpeg',
            'bmp': 'bmp'
        };
        return !!Icon[code];
    }

    render() {
        let content = "";
        if (AttachmentShow.haveCode(this.props.fileType)) {
            content = <img className="ci-attachment-image" src={"/showImg?uri=" + this.props.filePath}
                           alt="无法打开该类型附件"/>
        } else if (this.props.fileType === "zip" || this.props.fileType === "rar") {
            content = <img className="ci-attachment-image" src={"/showImg?uri=" + this.props.filePath}
                           alt="无法打开该类型附件"/>
        } else {
            content = <div dangerouslySetInnerHTML={{__html: this.props.fileContent}}/>
        }
        return (
            <div className="ci-attachment-show">
                {content}
            </div>
        )
    }
}

/**
 * 相关性分析组件
 */
class AttachmentRelation extends React.Component {

    constructor(props) {
        super(props);
    }

    componentDidMount() {
    }

    render() {
        return (
            <div>
                <div className="mailbox-controls with-border text-center">
                    共计<span> {this.props.attachmentCount} </span>封邮件
                </div>
                <div className="mailbox-read-info">
                    <AttachmentRelationTable data={this.props.data}
                                             handlerSubjectClick={this.props.handlerSubjectClick}/>
                </div>
            </div>
        );
    }

}

/**
 * 相关性分析表格
 */
class AttachmentRelationTable extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {

    }

    render() {
        let self = this;
        const columns = [{
            title: '主题',
            width: '30%',
            dataIndex: 'subject',
            render(text, record, index) {
                return <a href="#" onClick={self.props.handlerSubjectClick.bind(this, record)}>{text}</a>
            }
        }, {
            title: '发件人',
            width: '30%',
            dataIndex: 'from',
        }, {
            title: '发送时间',
            width: '20%',
            dataIndex: 'sendTime',
            render: ((text) => {
                return moment(text).format("YYYY-DD-MM HH:mm:ss");
            })
        }, {
            title: '会话数',
            width: '10%',
            dataIndex: 'sessionCount',
            render: ((text) => {
                return text === null ? 0 : text;
            })
        }, {
            title: '标签',
            width: '10%',
            dataIndex: 'tagCount',
            render: ((text) => {
                return text === null ? 0 : text;
            })
        }];

        const pagination = {
            total: this.props.data.length,
            showSizeChanger: true,
            onShowSizeChange(current, pageSize) {
                console.log('Current: ', current, '; PageSize: ', pageSize)
            },
            onChange(current) {
                console.log('Current: ', current)
            }
        };

        return (
            <Table rowKey={record => record.mailId} columns={columns} dataSource={this.props.data} bordered
                   pagination={pagination}/>
        );
    }
}