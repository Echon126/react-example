import React from "react";
import PubSub from "pubsub-js";
import {ResultsetApiInst, TagApiInst} from "../client/index";
import "../../css/workspace/search.css";


/**
 * 检索区域
 * Created by xcp on 2017/5/9.
 */
export default class Search extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            tagsData: [],
            resultSetData: []
        };
        this.resetTagsData = this.resetTagsData.bind(this);
        this.resetResultSet = this.resetResultSet.bind(this);
    }

    componentWillMount() {
        this.tokenResetTagsData = PubSub.subscribe("sidebar.resetTagsData", this.resetTagsData);
        this.tokenResetResultSet = PubSub.subscribe("sidebar.resetResultSet", this.resetResultSet);
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenResetTagsData);
        PubSub.unsubscribe(this.tokenResetResultSet);
    }

    componentDidMount() {
        this.resetTagsData();
        this.resetResultSet();
    }

    resetTagsData() {
        console.log("触发检索区 标签选项重置");
        let tagsData = [];
        let caseId = TagApiInst.ciStorage.get("caseId");
        TagApiInst.selectTagList(caseId, (error, data, response) => {
            if (data) {
                for (let i = 0; i < data.length; i++) {
                    let child = data[i].tags;
                    for (let j = 0; j < child.length; j++) {
                        tagsData.push({
                            id: (i + 1) + "" + j,
                            name: child[j].tagName
                        });
                    }
                }
            }
            this.setState({tagsData: tagsData});
        });

    }

    resetResultSet() {
        console.log("触发检索区 结果集选项重置");
        let resultSetData = [];
        let caseId = ResultsetApiInst.ciStorage.get("caseId");
        ResultsetApiInst.selectResultSetList(caseId, (error, data, response) => {
            if (data) {
                for (let i = 0; i < data.length; i++) {
                    resultSetData.push({
                        resultSetId: data[i].resultsetId,
                        resultSetName: data[i].resultsetName,
                        resultSetToken: data[i].resultsetToken,
                        resultSetTime: data[i].createTime,
                    });
                }
            }
            this.setState({resultSetData: resultSetData});
        });
    }

    componentDidUpdate() {
        $(".ci-add-btn").hide();
        $(".ci-add-btn:last").show();
    }

    render() {
        let conditionList = this.props.data.map((cmt, idx) => {
            return (
                <div key={idx} className="row ci-condition-row">
                    <div className="col-md-2  text-right">
                        <select id={"relation" + idx} name={idx} className="form-control relation"
                                value={cmt.relation}
                                onChange={this.props.handleChange("relation")}>
                            <option value="and">并且</option>
                            <option value="or">或者</option>
                        </select>
                    </div>
                    <div className="col-md-3 text-center">
                        <select id={"keyword" + idx} name={idx} className="form-control keyword"
                                value={cmt.keyword}
                                onChange={this.props.handleChange("keyword")}>
                            <option value="tag">标签</option>
                            <option value="mail">邮件</option>
                            <option value="subject">邮件标题</option>
                            <option value="mailContent">邮件内容</option>
                            <option value="attachmentType">附件类型</option>
                            <option value="from">发件人</option>
                            <option value="to">收件人</option>
                            <option value="attachmentSize">附件大小</option>
                            <option value="sendTime">邮件发送时间</option>
                            <option value="resultSet">结果集</option>
                            <option value="attachmentContent">附件内容</option>
                        </select>
                    </div>
                    <div className="col-md-2  text-center">
                        <ExpressionSelect keyword={cmt.keyword} keys={idx}
                                          expression={cmt.expression}
                                          handleChange={this.props.handleChange}/>
                    </div>
                    <div className="col-md-4  text-center">
                        <ResultSelect keyword={cmt.keyword} keys={idx}
                                      result={cmt.result}
                                      handleChange={this.props.handleChange}
                                      tags={this.state.tagsData}
                                      resultSets={this.state.resultSetData}
                        />
                    </div>
                    <div className="col-md-1 ci-search-btn-area text-left">
                        <button type="button" className="btn btn-default btn-xs ci-add-btn"
                                onClick={this.props.addCondition.bind(this, idx)}>
                            <i className="fa fa-plus"/>
                        </button>
                        <button type="button" className="btn btn-default btn-xs ci-remove-btn"
                                onClick={this.props.removeCondition.bind(this, idx)}>
                            <i className="fa fa-remove"/>
                        </button>
                    </div>
                </div>
            );
        });
        return (
            <div className="row">
                <div id="searchContent" className="col-md-10 ci-search-content">
                    {conditionList}
                </div>
                <div className="col-md-2 ci-operation-btn-area">
                    <button type="button" className="btn btn-default btn-xs ci-search-btn"
                            onClick={this.props.searchClick.bind(this)}
                            title="检索">
                        <i className="fa fa-search"/>
                    </button>
                    <button type="button" className="btn btn-default btn-xs ci-save-btn"
                            onClick={this.props.saveClick.bind(this)}
                            title="保存结果集">
                        <i className="fa fa-save"/>
                    </button>
                </div>
            </div>
        )
    }

}

/**
 * 表达式下拉选择
 * 根据不同的关键字显示不同的表达式
 */
class ExpressionSelect extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        switch (this.props.keyword) {
            case "tag": {
                return (
                    <select id={"expression" + this.props.keys} name={this.props.keys}
                            className="form-control expression"
                            value={this.props.expression}
                            onChange={this.props.handleChange("expression")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value="like">包含</option>
                        <option value="not like">不包含</option>
                    </select>
                );
            }
            case "mail": {
                return (
                    <select id={"expression" + this.props.keys} name={this.props.keys}
                            className="form-control expression"
                            value={this.props.expression}
                            onChange={this.props.handleChange("expression")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value="like">包含</option>
                        <option value="not like">不包含</option>
                    </select>
                );
            }
            case "subject": {
                return (
                    <select id={"expression" + this.props.keys} name={this.props.keys}
                            className="form-control expression"
                            value={this.props.expression}
                            onChange={this.props.handleChange("expression")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value="like">包含</option>
                        <option value="not like">不包含</option>
                        <option value="=">等于</option>
                    </select>
                );
            }
            case "mailContent": {
                return (
                    <select id={"expression" + this.props.keys} name={this.props.keys}
                            className="form-control expression"
                            value={this.props.expression}
                            onChange={this.props.handleChange("expression")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value="like">包含</option>
                        <option value="not like">不包含</option>
                    </select>
                );
            }
            case "attachmentType": {
                return (
                    <select id={"expression" + this.props.keys} name={this.props.keys}
                            className="form-control expression"
                            value={this.props.expression}
                            onChange={this.props.handleChange("expression")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value="like">包含</option>
                        <option value="not like">不包含</option>
                    </select>
                );
            }
            case "from": {
                return (
                    <select id={"expression" + this.props.keys} name={this.props.keys}
                            className="form-control expression"
                            value={this.props.expression}
                            onChange={this.props.handleChange("expression")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value="=">等于</option>
                    </select>
                );
            }
            case "to": {
                return (
                    <select id={"expression" + this.props.keys} name={this.props.keys}
                            className="form-control expression"
                            value={this.props.expression}
                            onChange={this.props.handleChange("expression")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value="like">包含</option>
                        <option value="not like">不包含</option>
                    </select>
                );
            }
            case "attachmentSize": {
                return (
                    <select id={"expression" + this.props.keys} name={this.props.keys}
                            className="form-control expression"
                            value={this.props.expression}
                            onChange={this.props.handleChange("expression")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value=">">大于</option>
                        <option value="<">小于</option>
                        <option value="=">等于</option>
                    </select>
                );
            }
            case "sendTime": {
                return (
                    <select id={"expression" + this.props.keys} name={this.props.keys}
                            className="form-control expression"
                            value={this.props.expression}
                            onChange={this.props.handleChange("expression")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value=">">大于</option>
                        <option value="<">小于</option>
                        <option value="=">等于</option>
                    </select>
                );
            }
            case "resultSet": {
                return (
                    <select id={"expression" + this.props.keys} name={this.props.keys}
                            className="form-control expression"
                            value={this.props.expression}
                            onChange={this.props.handleChange("expression")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value="in">在...之中</option>
                        <option value="not in">不在...之中</option>
                    </select>
                );
            }
            case "attachmentContent": {
                return (
                    <select id={"expression" + this.props.keys} name={this.props.keys}
                            className="form-control expression"
                            value={this.props.expression}
                            onChange={this.props.handleChange("expression")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value="like">包含</option>
                        <option value="not like">不包含</option>
                    </select>
                );
            }
        }
    }
}


/**
 * 结果下拉选择
 * 根据不同的关键字显示不同的表达式
 */
class ResultSelect extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        switch (this.props.keyword) {

            case "tag": {
                let tagLists = this.props.tags.map((cmt, idx) => {
                    return (
                        <option key={idx} value={cmt.name}>{cmt.name}</option>
                    );
                });
                return (
                    <select id={"result" + this.props.keys} name={this.props.keys} className="form-control result"
                            value={this.props.result}
                            onChange={this.props.handleChange("result")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        {tagLists}
                    </select>
                );
            }
            case "mail": {
                return (
                    <select id={"result" + this.props.keys} name={this.props.keys} className="form-control result"
                            value={this.props.result}
                            onChange={this.props.handleChange("result")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value="attachment">附件</option>
                    </select>
                );
            }
            case "subject": {
                return (
                    <input id={"result" + this.props.keys} name={this.props.keys} className="form-control result"
                           type="text" value={this.props.result}
                           onChange={this.props.handleChange("result")}/>
                );
            }
            case "mailContent": {
                return (
                    <input id={"result" + this.props.keys} name={this.props.keys} className="form-control result"
                           type="text" value={this.props.result}
                           onChange={this.props.handleChange("result")}/>
                );
            }
            case "attachmentType": {
                return (
                    <select id={"result" + this.props.keys} name={this.props.keys} className="form-control result"
                            value={this.props.result} onChange={this.props.handleChange("result")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        <option value="word">word</option>
                        <option value="excel">excel</option>
                        <option value="pdf">pdf</option>
                        <option value="zip">压缩包</option>
                        <option value="image">图片</option>
                        <option value="txt">文本</option>
                    </select>
                );
            }
            case "from": {
                return (
                    <input id={"result" + this.props.keys} name={this.props.keys} className="form-control result"
                           type="text"
                           placeholder="" value={this.props.result}
                           onChange={this.props.handleChange("result")}/>
                );
            }
            case "to": {
                return (
                    <input id={"result" + this.props.keys} name={this.props.keys} className="form-control result"
                           type="text"
                           placeholder="" value={this.props.result}
                           onChange={this.props.handleChange("result")}/>
                );
            }
            case "attachmentSize": {
                return (
                    <input id={"result" + this.props.keys} name={this.props.keys} className="form-control result"
                           type="text" value={this.props.result}
                           onChange={this.props.handleChange("result")}/>
                );
            }
            case "sendTime": {
                return (
                    <input id={"result" + this.props.keys} name={this.props.keys} className="form-control result"
                           type="text" value={this.props.result}
                           onChange={this.props.handleChange("result")}/>
                );
            }
            case "resultSet": {
                let resultSetLists = this.props.resultSets.map((cmt, idx) => {
                    return (
                        <option key={idx} name={cmt.resultSetId} value={cmt.resultSetToken}>{cmt.resultSetName}</option>
                    );
                });
                return (
                    <select id={"result" + this.props.keys} name={this.props.keys} className="form-control result"
                            value={this.props.result}
                            onChange={this.props.handleChange("result")}>
                        <option value="" defaultValue="" disabled="true">请选择</option>
                        {resultSetLists}
                    </select>
                );
            }
            case "attachmentContent": {
                return (
                    <input id={"result" + this.props.keys} name={this.props.keys} className="form-control result"
                           type="text" value={this.props.result}
                           onChange={this.props.handleChange("result")}/>
                );
            }
        }
    }
}