import "../../css/loadmail/load.css";
import React from "react";
import ReactDOM from "react-dom";
import {LoadApiInst} from "../client/index";
import PubSub from "pubsub-js";
import Dialog from "../dialog";
import Configuration from "./configuration";
import LoadProgress from "./loadprogress";
const dialog = new Dialog();

export default class LoadMail extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            options: []
        };
        this.showWindow = this.showWindow.bind(this);
        this.loadProgress = this.loadProgress.bind(this);
    }

    componentDidMount() {

    }

    /**
     * 文件夹或者文件
     * @param folder
     */
    showWindow(folder) {
        const self = this;
        ReactDOM.unmountComponentAtNode(document.getElementById("dialog"));
        ReactDOM.render(
            <Configuration/>,
            document.getElementById("dialog")
        );
        dialog.openDialog("#dialog", "装载配置", {
            "执行装载": function () {
                // 保存配置数据
                let options = [];
                $(".ci-load-option-result").each(function (i) {
                    let isChecked = $(this).prop("checked");
                    if (isChecked) {
                        options.push({
                            optionKey: $(this).attr("name"),
                            optionValue: $(this).val()
                        });
                    }
                });

                $(this).dialog("close");
                //跳转到装载进度界面，选择的文件夹
                if (folder) {
                    self.loadProgress(options, folder);
                }
            },
            "关闭": function () {
                $(this).dialog("close");
            }
        }, 520, 430);

    }

    /**
     * 装载进度
     * @param options 配置项信息
     * @param folder 选择的文件夹或者文件
     */
    loadProgress(options, folder) {
        console.log("装载进度");
        let caseId = LoadApiInst.ciStorage.get("caseId");
        let conditions = JSON.stringify(options);
        // 调用开始装载 api
        LoadApiInst.loadMailData(caseId, folder, conditions, (error, data, response) => {
            if (response.ok) {
                ReactDOM.unmountComponentAtNode(document.getElementById("dialog"));
                dialog.openDialog("#dialog", "装载进度", {
                    "停止": function () {
                        // 调用停止装载 api
                        LoadApiInst.stopLoadMail(caseId, (error, data, response) => {
                            if (response.ok) {
                                PubSub.publish("load.stopLoadState");
                                $(this).dialog("close");
                            }
                        });
                    }
                }, 520, 320);
                ReactDOM.render(
                    <LoadProgress/>,
                    document.getElementById("dialog")
                );

            }
        });
    }

    render() {
        return (
            <div className="load-container">
                <div className="row row-centered">
                    <div className="col-md-6 col-centered">
                        <button type="file" className="btn btn-default btn-block" onClick={this.showWindow}>邮件装载
                        </button>
                    </div>
                </div>
            </div>
        )
    }

}