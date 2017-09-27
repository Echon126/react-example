import "../../css/common/plug.css";
import React from "react";
import ReactDOM from "react-dom";
import Dialog from "../dialog";
import PubSub from "pubsub-js";
import {AttachmentApiInst, ContactApiInst, MailApiInst, MailboxApiInst, TagApiInst} from "../client/index";

const dialog = new Dialog();

/**
 * 标签界面
 */
class Tags extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data: [],
            tag: this.props.tag
        };
        this.selectCustomTagList = this.selectCustomTagList.bind(this);
    }

    componentDidMount() {
        this.selectCustomTagList();
        this.setState({tag: this.props.tag})
    }

    selectCustomTagList() {
        console.log("加载默认自定义标签数据");
        let caseId = TagApiInst.ciStorage.get("caseId");
        TagApiInst.selectCustomTagList(caseId, (error, data, response) => {
            if (response.ok) {
                this.setState({
                    data: data,
                    isChecked: false
                });
            } else {
                console.log(response.data);
            }
        });
    }

    handlerAddTagClick() {
        let tagName = $("#name").val();
        let caseId = TagApiInst.ciStorage.get("caseId");
        TagApiInst.createCustomTagList(caseId, tagName, (error, data, response) => {
            if (response.ok) {
                this.selectCustomTagList();
            } else {
                console.log(response.data);
            }
        });
    }

    changeCheck(e) {
        this.setState({
            isChecked: !this.state.isChecked,
        });
    }

    addHtml(item) {
        let tag = this.state.tag.split(",");
        let check = "";
        for (let i = 0; i < tag.length; i++) {
            if (item.tagName === tag[i]) {
                check = <input type="checkbox" name={item.tagId} value={item.tagName}
                               onChange={this.changeCheck.bind(this)} defaultChecked={!this.state.isChecked}/>;
                break;
            } else {
                check = <input type="checkbox" name={item.tagId} value={item.tagName}
                               onChange={this.changeCheck.bind(this)} defaultChecked={this.state.isChecked}/>;
            }
        }
        return check;
    }

    render() {
        let content = this.state.data.map((item, idx) => {
            let html = <label key={idx} className="ci-plug-tag-checkbox">
                {this.addHtml(item)}
                <span className="btn btn-warning btn-xs ci-plug-tag-button">
                    <i className={item.tagIcon}/> {item.tagName}
                </span>
            </label>;
            if ((idx + 1) % 4 === 0) {
                html + <div dangerouslySetInnerHTML={{__html: "</br>"}}/>;
            }
            return (html);
        });
        return (
            <div className="ci-plung-tag">
                <div className="row ci-plung-tag-tags">
                    <div id="tagId">
                        {content}
                    </div>
                </div>
                <div className="ci-plung-tag-label">
                    <div className="row ci-plung-tag-labels">
                        <div className="col-md-3 col-sm-4"><label >自定义标签:</label></div>
                        <div className="col-md-7 col-sm-7">
                            <input type="text" className="form-control" id="name" placeholder="请输入标签名称"/>
                        </div>
                        <div className="col-md-2 col-sm-2">
                            <span>
                                <button type="button" className="btn btn-primary"
                                        onClick={this.handlerAddTagClick.bind(this)} title="新增">
                                    <i className="fa fa-plus"/>
                                </button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

/**
 * 加标签
 */
export default class Tag extends React.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }

    componentDidMount() {
        console.log(this.props);
    }


    tagWindow(id, tag, sysTagCount, type, data) {
        let detail = data;
        let caseId = MailApiInst.ciStorage.get("caseId");
        const _self = this;
        let result = ReactDOM.unmountComponentAtNode(document.getElementById("dialog"));
        ReactDOM.render(<Tags tag={tag}/>, document.getElementById("dialog"));

        dialog.openDialog("#dialog", "加标签", {
            "确定": function () {
                let options = [];
                $("#tagId").find("input[type='checkbox']").each(function () {
                    let isChecked = $(this).prop("checked");
                    if (isChecked) {
                        options.push($(this).val());
                    }
                });
                let tags = options.join();
                switch (type) {
                    case "mailTags":
                        MailApiInst.updateMailTag(caseId, id, tags, sysTagCount, (error, data, response) => {
                            if (response.ok) {
                                PubSub.publish("mailContent.load", id);
                                $(this).dialog("close");
                            }
                        });
                        break;
                    case "attachmentTags":
                        AttachmentApiInst.updateAttachmentTag(caseId, id, tags, sysTagCount, (error, data, response) => {
                                if (response.ok) {
                                    PubSub.publish("attachmentContent.load", id);
                                    $(this).dialog("close");
                                }
                            }
                        );
                        break;
                    case "mailboxTags":
                        MailboxApiInst.updateMailboxTag(caseId, id, tags, (error, data, response) => {
                            if (response.ok) {
                                $(this).dialog("close");
                            }
                        });
                        break;
                    case "contactTags":
                        ContactApiInst.updateContactTag(caseId, id, tags, (error, data, response) => {
                            if (response.ok) {
                                PubSub.publish("contactContent.load", detail);
                                $(this).dialog("close");
                            }
                        });
                        break;
                }
            },
            "关闭": function () {
                $(this).dialog("close");
            }
        }, 560);
    }
}

