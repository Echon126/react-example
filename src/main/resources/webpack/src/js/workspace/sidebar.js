import React from "react";
import ReactDOM from "react-dom";
import PubSub from "pubsub-js";
import Tag from "./tag";
import Dialog from "../dialog";
import ResultSet from "./result-set";
import History from "./history";
import {HistoryApiInst, ResultsetApiInst} from "../client/index";
import "../../css/workspace/sidebar.css";

PubSub.immediateExceptions = true
const dialog = new Dialog();

export default class Sidebar extends React.Component {
    constructor(props) {
        super(props);
        this.clickTag = this.clickTag.bind(this);
    }

    componentWillMount() {
        this.tokenShrink = PubSub.subscribe(this.props.shrinkTopic, this.handleShrink);
        this.tokenExpand = PubSub.subscribe(this.props.expandTopic, this.handleExpand);
    }

    componentDidMount() {
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenShrink);
        PubSub.unsubscribe(this.tokenExpand);
    }

    handleShrink() {
        // 折叠侧边栏
        if (!$("body").hasClass('sidebar-collapse')) {
            $("body").addClass('sidebar-collapse').trigger('collapsed.pushMenu');
        }

    }

    handleExpand() {
        // 展开菜单栏
        if ($("body").hasClass('sidebar-collapse')) {
            $("body").removeClass('sidebar-collapse').trigger('expanded.pushMenu');
        }
    }

    // 点击标签 事件
    clickTag(event, treeId, treeNode, clickFlag) {
        if (treeNode.pId == null || treeNode.pId == 0) return;
        console.log("点击了标签：id=" + treeNode.id + " -- name=" + treeNode.name +"----parentName"+treeNode.getParentNode().name);
        let tree = {id: treeNode.id, name: treeNode.name,parentName:treeNode.getParentNode().name};
        PubSub.publish("contentFrame.addCondition", tree);
    }

    // 双击选择结果集事件
    chooseResultSet(resultSetId) {
        let caseId = ResultsetApiInst.ciStorage.get("caseId");
        let conditions = [];
        // 通过resultSetId查询出条件列表数据
        ResultsetApiInst.getResultSetDetail(caseId, resultSetId, (error, data, response) => {
            if (data) {
                let conditionList = data.conditions;
                for (let i = 0; i < conditionList.length; i++) {
                    conditions.push({
                        relation: conditionList[i].relation,
                        keyword: conditionList[i].keyword,
                        expression: conditionList[i].expression,
                        result: conditionList[i].result
                    });
                }
            }
            //发布调用 重置检索条件接口
            PubSub.publish("contentFrame.setCondition", conditions);
        });
    }

    // 删除结果集事件
    deleteResultSet(cmt) {
        let resultSetName = cmt.resultSetName;
        ReactDOM.unmountComponentAtNode($("#dialog2")[0]);
        ReactDOM.render(
            <div>你确定要删除结果集： {resultSetName} 吗？</div>,
            $("#dialog2")[0]
        );
        dialog.openDialog("#dialog2", "删除操作记录", {
            "确 定": function () {
                // 发布重置结果集列表数据
                let caseId = ResultsetApiInst.ciStorage.get("caseId");
                // 调用删除结果集方法
                ResultsetApiInst.deleteResultSet(caseId, cmt.resultSetId, (error, data, response) => {
                    if (response.ok) {
                        PubSub.publish("sidebar.resetResultSet");
                        $(this).dialog("close");
                    }
                });
            },
            "取 消": function () {
                $(this).dialog("close");
            }
        }, 400, 150);

    }

    // 双击选择操作记录事件
    chooseHistory(history) {
        let historyId = history.historyId;
        let historyName = history.historyName;
        let createTime = history.createTime;
        console.log("historyId = " + historyId + " |-| historyName = " + historyName + " |-| createTime = " + createTime);
        //TODO 将操作记录恢复检索区
    }

    // 删除操作记录事件
    deleteHistory(history) {
        console.log("deleteHistory:" + history.historyId + "--" + history.historyName);
        ReactDOM.unmountComponentAtNode($("#dialog2")[0]);
        ReactDOM.render(
            <div>你确定要删除操作记录： {history.historyName} 吗？</div>,
            $("#dialog2")[0]
        );
        dialog.openDialog("#dialog2", "删除操作记录", {
            "确 定": function () {
                // 调用删除操作记录方法 并重新渲染 操作记录列表
                let caseId = HistoryApiInst.ciStorage.get("caseId");
                HistoryApiInst.deleteHistory(caseId, history.historyId, (error, data, response) => {
                    if (response.ok) {
                        //发布调用 重置操作记录接口
                        PubSub.publish("sidebar.resetHistory", "");
                        $(this).dialog("close");
                    }
                });
            },
            "取 消": function () {
                $(this).dialog("close");
            }
        }, 400, 150);

    }

    render() {
        return (
            <aside className="main-sidebar">
                <section className="sidebar">

                    <Tag title="标签" clickTag={this.clickTag.bind(this)}/>

                    <ResultSet title="结果集" chooseResultSet={this.chooseResultSet}
                               deleteResultSet={this.deleteResultSet}/>

                    <History title="操作记录" chooseHistory={this.chooseHistory}
                             deleteHistory={this.deleteHistory}/>

                </section>
            </aside>
        )
    }

}