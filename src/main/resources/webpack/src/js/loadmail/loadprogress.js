import React from "react";
import ReactDOM from "react-dom";
import Dialog from "../dialog";
import PubSub from "pubsub-js";
import LoadReport from "./loadreport";
import {LoadApiInst} from "../client/index";

const dialog = new Dialog();

/**
 * 装载进度
 */
export default class LoadProgress extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            progress: '0%',
            executeTime: "00:00:00",
            remainTime: "∞",
            hadLoad: 0,
            loadSuccess: 0,
            loadFail: 0,
            loadingFile: "准备加载",
            stop: false
        };
        this.loadReport = this.loadReport.bind(this);
        this.getLoadState = this.getLoadState.bind(this);
        this.stopLoadState = this.stopLoadState.bind(this);
        this.formatDuring = this.formatDuring.bind(this);
    }

    componentWillMount() {
        this.tokenStopLoadState = PubSub.subscribe("load.stopLoadState", this.stopLoadState);
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenStopLoadState);
    }

    //数据加载
    componentDidMount() {
        this.getLoadState();
    }

    getLoadState() {
        let caseId = LoadApiInst.ciStorage.get("caseId");
        let self = this;
        let timer = setInterval(function () {
            let currentTime = (new Date()).valueOf();
            LoadApiInst.getLoadState(caseId, (error, data, response) => {
                if (data) {
                    // 装载总数
                    let totalCount = data.totalCount;
                    // 执行事件
                    let executeTime = currentTime - data.startTime;
                    // 已装载数量
                    let progressCount = data.processCount;
                    // 剩余数量
                    let remainCount = parseInt(totalCount) - parseInt(progressCount);
                    // 装载进度
                    let progress = (((progressCount / totalCount).toFixed(4)) * 100).toFixed(2) + "%";
                    // 一个邮件平均执行时间
                    let eachMailExecuteTime = (parseInt(executeTime) / parseInt(progressCount))
                    // 剩余时间
                    let remainTime = parseInt(eachMailExecuteTime * remainCount);
                    self.setState({
                        progress: progress,
                        executeTime: self.formatDuring(executeTime),
                        remainTime: self.formatDuring(remainTime),
                        hadLoad: data.processCount,
                        loadSuccess: data.successCount,
                        loadFail: data.failCount,
                        loadingFile: data.progressLabel
                    });
                    // 当装载完毕 或者 手动停止装载 时停止调用获取装载状态api，并渲染装载报告页面
                    if ((data.successCount + data.failCount) >= data.totalCount || self.state.stop == true) {
                        clearInterval(timer);//清除定时器
                        self.loadReport(progressCount);
                    }
                }
            });
        }, 200);
    }

    formatDuring(mss) {
        // var days = parseInt(mss / (1000 * 60 * 60 * 24));
        var hours = parseInt((mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        var minutes = parseInt((mss % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = parseInt((mss % (1000 * 60)) / 1000);
        return hours + " 时 " + minutes + " 分 " + seconds + " 秒 ";
    }

    stopLoadState() {
        this.state.stop = true;
        this.setState({});
        console.log("装载停止");
    }


    loadReport(progressCount) {
        ReactDOM.unmountComponentAtNode(document.getElementById("dialog"));
        ReactDOM.render(
            <LoadReport/>,
            document.getElementById("dialog")
        );
        dialog.openDialog("#dialog", "装载报告", {
            "完成": function () {
                // 已装载数量大于0跳转到邮件分析主内容界面，未装载则跳转到邮件未装载页面
                if (progressCount > 0) {
                    PubSub.publish("header.renderMainArea");
                } else {
                    PubSub.publish("header.renderNoLoadData");
                }
                $(this).dialog("close");
            }
        });
    }

    render() {
        return (
            <div className="ci-load-progress-container">
                <div className="loadFile">{this.state.loadingFile}</div>
                <div className="progress active">
                    <div className="progress-bar progress-bar-primary progress-bar-striped" role="progressbar"
                         aria-valuenow="0"
                         aria-valuemin="0" aria-valuemax="100" style={{width: this.state.progress}}>
                        <span className="ci-progress-bar-number">{this.state.progress}</span>
                    </div>
                </div>
                <div className="row ci-load-progress-time">
                    <div className="col-md-6"> 已执行时间: {this.state.executeTime}</div>
                    <div className="col-md-6"> 剩余时间: {this.state.remainTime}</div>
                </div>
                <div className="row ci-load-progress-count">
                    <div className="col-md-4"> 已装载:{this.state.hadLoad}</div>
                    <div className="col-md-4"> 装载成功：{this.state.loadSuccess}</div>
                    <div className="col-md-4"> 装载失败：{this.state.loadFail}</div>
                </div>
            </div>
        )
    }
}
