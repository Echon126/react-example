import "../../css/mail/mail-content.css";
import React from "react";
import Notes from "../common/note";
import Tags from "../common/tag";
import TagShow from "../common/tag-show";
import AttachmentContent from "../attachment/attachment-content";
import PubSub from "pubsub-js";
import ScrollBox from "../common/ScrollBox";
import {MailApiInst} from "../client/index";

const noteController = new Notes();
const tagController = new Tags();

/**
 * 邮件详情
 */
export default class MailContent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            tags: [],
            attachments: [],
            mailContent: [],
            to: [],
            cc: [],
            bcc: [],
            isFloat: this.props.isFloat,
            mailDetail: [],
            style: {
                height: "800px",
                border: "1px solid transparent",
            }
        };
    }

    componentWillMount() {
        this.tokenShow = PubSub.subscribe("mailContent.load", this.loadData.bind(this));
    }

    componentDidMount() {
        console.log("邮件详情的isFloat=", this.state.isFloat);
        this.loadData(null, this.props.mailId);
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenShow);
    }

    handleAttachmentClicked(item) {
        console.log("点击了邮件中的附件 attachmentId=" + item.attachmentId + ",attachmentName=" + item.attachmentName);
        if (!this.state.isFloat) {
            // 显示附件浮动详情界面
            PubSub.publish("floatContentPanel.show", {
                data: item, tag: (
                    <AttachmentContent attachmentId={item.attachmentId} isFloat={true}/>
                )
            });
            // 加载附件详情数据
            PubSub.publish("attachmentContent.load", item.attachmentId);
        } else {
            console.log("当前附件相关性分析详情中 -> 邮件的详情 -> 附件不可点击");
        }
    }

    /**
     * 加批注
     * @param mailId
     * @param caseId
     * @param notes
     */
    handleEditNoteClick(mailId, notes) {
        let caseId = MailApiInst.ciStorage.get("caseId");
        noteController.notesWindow(mailId, caseId, notes, "mailNotes");
    }

    /**
     * 加标签
     * @param id
     */
    handleAddTagClick(mailId, tag, sysTagCount) {
        tagController.tagWindow(mailId, tag, sysTagCount, "mailTags");
    }

    /**
     * 加载邮件详情
     * @param topic
     * @param data
     */
    loadData(topic, mailId) {
        let caseId = MailApiInst.ciStorage.get("caseId");
        MailApiInst.getMailDetail(caseId, mailId, (error, data, response) => {
            if (response.ok) {
                if (data) {
                    this.setState({
                        mailDetail: data.mails
                    });
                }
            }
        });
    }

    /**
     * @return {string}
     */
    static StrSubString(str) {
        let subStr = "";
        if (str !== null && str !== "") {
            let data = str.split(",");
            for (let i = 0; i < data.length; i++) {
                let end = data[i].lastIndexOf(" ");
                let name = data[i].substring(0, end);
                let address = data[i].substring(end + 1);
                subStr += name + "<" + address + ">" + ",";
            }
            if (subStr.length > 0) {
                subStr = subStr.substr(0, subStr.length - 1);
            }
            return subStr;
        } else {
            return str;
        }
    }


    render() {
        let sessionContent = this.state.mailDetail.map((item, idx) => {
            let to = MailContent.StrSubString(item.to);
            let cc = MailContent.StrSubString(item.cc);
            let bcc = MailContent.StrSubString(item.bcc);
            return (
                <div className="box box-primary" key={idx}>
                    <div className="box-body no-padding">
                        <div className="mailbox-read-info">
                            <h5>主题：{item.subject}<span
                                className="mailbox-read-time pull-right">{moment(item.sendTime).format("YYYY-MM-DD")}
                                {item.sendTimezone}</span></h5>
                        </div>
                        <div className="mailbox-read-info">
                            <h5>发件人： {item.fromName + "<" + item.from + ">"}<span
                                className="mailbox-read-time pull-right">
                            <button type="button" className="btn btn-primary fa fa-plus"
                                    onClick={this.handleEditNoteClick.bind(this, item.mailId, item.note)}>加批注
                            </button></span></h5>
                        </div>
                        <div className="mailbox-read-info">
                            <h5>收件人： {to}</h5>
                        </div>
                        <div className="mailbox-read-info">
                            <h5>抄&nbsp;&nbsp;&nbsp;送：{cc}</h5>
                        </div>
                        <div className="mailbox-read-info">
                            <h5>暗&nbsp;&nbsp;&nbsp;送： {bcc}</h5>
                        </div>
                        <div className="mailbox-read-info">
                            <h5>标 签： <TagShow tag={item.tag}
                                              handleAddTagClick={this.handleAddTagClick.bind(this, item.mailId, item.tag, item.sysTagCount)}/>
                            </h5>
                        </div>
                        <Attachments attachments={item.attachments}
                                     handleAttachmentClicked={this.handleAttachmentClicked.bind(this)}/>
                        <div className="mailbox-read-message">
                            <div dangerouslySetInnerHTML={{__html: item.mailContent}}/>
                        </div>
                    </div>
                </div>
            )
        });

        return (
            <div className="panel panel-info">
                <div className="panel-body" style={this.state.style}>
                    <ScrollBox>
                        {sessionContent}
                    </ScrollBox>
                </div>
            </div>
        );
    }
}

/**
 * 附件无状态组件
 */
class Attachments extends React.Component {
    constructor(props) {
        super(props);
    }

    /**
     * @return {null}
     */
    static Converter(code) {
        let Icon = {
            'docx': 'fa fa-file-word-o',
            'doc': 'fa fa-file-word-o',
            'pdf': 'fa fa-file-pdf-o',
            'txt': 'fa fa-file-text'
        };
        if (Icon[code]) {
            return Icon[code];
        } else {
            return null;
        }
    }

    render() {
        let attachmentList;
        if (this.props.attachments === null) {
            attachmentList = '';
        } else {
            attachmentList = this.props.attachments.map((item, idx) => {
                let icon = Attachments.Converter(item.fileType);
                return (
                    <li key={idx}>
                        <div className="mailbox-attachment-info">
                            <a href="javascript:void(0)" className="mailbox-attachment-name"
                               onClick={this.props.handleAttachmentClicked.bind(this, item)}>
                                <i className={icon} id="icon"/>{item.attachmentName}
                                <span className="mailbox-attachment-size">{item.attachmentSize}KB</span>
                            </a>
                        </div>
                    </li>
                )
            });
        }

        return (
            <div className="mailbox-read-info">
                <ul className="mailbox-attachments clearfix">
                    {attachmentList}
                </ul>
            </div>
        );
    }
}
