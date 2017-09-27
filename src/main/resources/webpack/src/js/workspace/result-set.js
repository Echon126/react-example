import React from "react";
import PubSub from "pubsub-js";
import {ResultsetApiInst} from "../client/index";
import "../../css/workspace/result-set.css";

/**
 * 结果集区域
 * Created by xcp on 2017/5/5.
 */
export default class ResultSet extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: []
        };
        this.resetResultSet = this.resetResultSet.bind(this);
    }

    componentWillMount() {
        this.tokenResetResultSet = PubSub.subscribe("sidebar.resetResultSet", this.resetResultSet.bind(this));
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenResetResultSet)
    }

    /**
     * 重置结果集列表
     * @param key
     * @param msg
     */
    resetResultSet() {
        let resultSetData = [];
        console.log("触发结果集列表重新加载数据");
        let caseId = ResultsetApiInst.ciStorage.get("caseId");

        ResultsetApiInst.selectResultSetList(caseId, (error, data, response) => {
            if (data) {
                for (let i = 0; i < data.length; i++) {
                    resultSetData.push({
                        resultSetId: data[i].resultsetId,
                        resultSetName: data[i].resultsetName,
                        resultSetToken: data[i].resultSetToken,
                        resultSetTime: data[i].createTime,
                    });
                }
            }
            this.setState({data: resultSetData});
        });
    }

    componentDidMount() {
        this.resetResultSet();
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
                        <ResultSetList chooseResultSet={this.props.chooseResultSet}
                                       deleteResultSet={this.props.deleteResultSet}
                                       data={this.state.data}/>
                    </div>
                </div>
            </div>
        )
    }
}


class ResultSetList extends React.Component {
    constructor(props) {
        super(props);

    }

    render() {
        let lists = this.props.data.map((cmt, idx) => {
            return (
                <li className="ci-result-set-li" key={idx}>
                    <div className="row ci-result-set-row">
                        <div className="col-md-10 ci-result-set-item"
                             onClick={this.props.chooseResultSet.bind(this, cmt.resultSetId)}>
                            <span>{cmt.resultSetName}</span>

                            <div className="text-gray">{moment(cmt.resultSetTime).format("YYYY-MM-DD HH:mm:ss")}</div>
                        </div>
                        <div className="col-md-2 ci-result-set-btn">
                            <button type="button" className="btn btn-danger btn-xs pull-right"
                                    onClick={this.props.deleteResultSet.bind(this, cmt)}>
                                <i className="fa fa-remove"/>
                            </button>
                        </div>

                    </div>

                </li>
            );
        });

        return (
            <ul className="nav nav-pills nav-stacked ci-result-set-area">
                {lists}
            </ul>
        );
    }
}
