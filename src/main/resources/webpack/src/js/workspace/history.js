import React from "react";
import {HistoryApiInst} from "../client/index";
import PubSub from "pubsub-js";
import "../../css/workspace/history.css";


/**
 * 历史记录区域
 * Created by xcp on 2017/5/5.
 */
export default class History extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data: []
        };
        this.resetHistory = this.resetHistory.bind(this);
    }

    componentWillMount() {
        this.tokenResetHistory = PubSub.subscribe("sidebar.resetHistory", this.resetHistory);
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenResetHistory);
    }

    componentDidMount() {
        this.resetHistory();
    }

    resetHistory() {
        let historyData = [];
        console.log("操作记录列表重新加载数据");
        let caseId = HistoryApiInst.ciStorage.get("caseId");
        HistoryApiInst.selectHistoryList(caseId, (error, data, response) => {
            if (data) {
                for (let i = 0; i < data.length; i++) {
                    historyData.push({
                        key: i,
                        historyId: data[i].historyId,
                        historyName: data[i].historyName,
                        createTime: moment(data[i].createTime).format("YYYY-MM-DD HH:mm:ss"),
                    });
                }
            }
            this.setState({data: historyData});
        });
    }

    render() {
        return (
            <div className="sidebar-form">
                <div className="box box-solid">
                    <div className="box-header">{this.props.title}
                        <div className="box-tools">
                            <button type="button" className="btn btn-box-tool" data-widget="collapse">
                                <i className="fa fa-minus"/>
                            </button>
                        </div>
                    </div>
                    <div className="box-body">
                        <HistoryList chooseHistory={this.props.chooseHistory}
                                     deleteHistory={this.props.deleteHistory}
                                     data={this.state.data}/>
                    </div>
                </div>
            </div>
        )
    }

}


class HistoryList extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {

    }

    render() {
        let lists = this.props.data.map((cmt, idx) => {
            return (
                <li className="ci-history-li" key={idx}>
                    <div className="row ci-history-row">
                        <div className="col-md-10 ci-history-item"
                             onClick={this.props.chooseHistory.bind(this, cmt)}>
                            <span>{cmt.historyName}</span>
                            <div className="text-gray">{cmt.createTime}</div>
                        </div>
                        <div className="col-md-2 ci-history-btn">
                            <button type="button" className="btn btn-danger btn-xs pull-right"
                                    onClick={this.props.deleteHistory.bind(this, cmt)}>
                                <i className="fa fa-remove"></i>
                            </button>
                        </div>

                    </div>
                </li>
            );
        });

        return (
            <ul className="nav nav-pills nav-stacked ci-history-area">
                {lists}
            </ul>
        );
    }
}