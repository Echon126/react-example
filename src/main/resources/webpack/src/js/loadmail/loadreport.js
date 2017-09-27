import React from "react";
import {LoadApiInst} from "../client/index";

/**
 * 装载完成报告
 */
export default class LoadReport extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            totalCount: 0,
            successCount: 0,
            failCount: 0,
            failFiles: []
        }
        this.getLoadReport = this.getLoadReport.bind(this);
    }

    //数据加载
    componentDidMount() {
        this.getLoadReport();
    }

    getLoadReport() {
        let caseId = LoadApiInst.ciStorage.get("caseId");
        LoadApiInst.getLoadReport(caseId, (error, data, response) => {
            if (data) {
                this.setState({
                    totalCount: data.totalCount,
                    successCount: data.successCount,
                    failCount: data.failCount,
                    failFiles: data.failFiles
                });
            }
        });
    }

    render() {
        let content01 = <div>装载数量统计：已装载：{this.state.totalCount} 装载成功：{this.state.successCount}
            装载失败：{this.state.failCount}</div>;
        let content02 = this.state.failFiles.map((rsp, idx) => {
            let html = <h5 key={idx}>{rsp}</h5>;
            return (html);
        });
        return (
            <div>
                <div className="ci-load-report-text">{content01}</div>
                <div className="loadReport">
                    <div className="ci-load-report-head">
                        <span className="ci-load-report-title">错误报告</span>
                    </div>
                    <div className="box-body ci-load-report-errors">
                        {content02}
                    </div>
                </div>
            </div>
        )
    }
}
