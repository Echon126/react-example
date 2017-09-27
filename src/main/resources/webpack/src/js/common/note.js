import React from "react";
import ReactDOM from "react-dom";
import Dialog from "../dialog";
import PubSub from "pubsub-js";
import {AttachmentApiInst, ContactApiInst, MailApiInst, MailboxApiInst} from "../client/index";

const dialog = new Dialog();

/**
 * 批注界面
 */
class Notes extends React.Component {

    constructor(props) {
        super(props);
        this.state = {notesValue: this.props.notesValue};
    }

    componentDidMount() {
        this.setState({
            notesValue: this.props.notesValue
        });
    }

    handleChange(fieldName) {
        return function (event) {
            this.setState({[fieldName]: event.target.value});
        }.bind(this);
    }

    render() {
        return (
            <div className="input-group">
                    <textarea className="form-control ci-plug-note" id="notesId" rows="3"
                              placeholder="请输入批注内容最大输入字数为500......"
                              style={{margin: "0px", width: "465px", height: "143px"}}
                              value={this.state.notesValue} onChange={this.handleChange("notesValue")}/>
            </div>
        );
    }
}

/*加批注*/
export default class Note extends React.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }

    componentDidMount() {
        console.log(this.props);
    }

    notesWindow(id, caseId, notes, type, data) {
        let detail = data;
        let result = ReactDOM.unmountComponentAtNode(document.getElementById("dialog"));
        ReactDOM.render(
            <Notes notesValue={notes}/>,
            $("#dialog")[0]
        );
        dialog.openDialog("#dialog", "加批注", {
            "确定": function () {
                let notesValue = $("#notesId").val();
                switch (type) {
                    case "mailNotes":
                        MailApiInst.updateMailNotes(caseId, id, notesValue, (error, data, response) => {
                            if (response.ok) {
                                PubSub.publish("mailContent.load", id);
                                $(this).dialog("close");
                            }
                        });
                        break;
                    case "attachmentNotes":
                        AttachmentApiInst.updateAttachmentNotes(caseId, id, notesValue, (error, data, response) => {
                            if (response.ok) {
                               PubSub.publish("attachmentContent.load", id);
                                $(this).dialog("close");
                            }
                        });
                        break;
                    case "mailboxNotes":
                        MailboxApiInst.updateMailboxNotes(caseId, id, notesValue, (error, data, response) => {
                            if (response.ok) {
                                $(this).dialog("close");
                            }
                        });
                        break;
                    case "contactNotes":
                        ContactApiInst.updateContactNotes(caseId, id, notesValue, (error, data, response) => {
                            if (response.ok) {
                                PubSub.publish("contactContent.load", detail);
                                $(this).dialog("close");
                            }
                        });
                }
            },
            "关闭": function () {
                $(this).dialog("close");
            }
        }, 520, 300);
    }
}


