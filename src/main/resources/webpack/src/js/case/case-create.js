import "../../css/case/case-create.css";
import React from "react";

/**
 * 案件新建和修改页面
 * Created by xcp on 2017/4/13.
 */
export default class CaseCreate extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            caseId: this.props.caseId,
            caseCode: this.props.caseCode,
            caseName: this.props.caseName,
            caseOperator: this.props.caseOperator,
            kickoffDate: this.props.kickoffDate == "" ? "" : moment(this.props.kickoffDate).format("YYYY-MM-DD"),
            remark: this.props.remark
        };
    }

    componentDidMount() {
        //初始化时间插件
        $(".input-daterange").datepicker({
            language: "zh-CN",
            todayHighlight: true,
            format: "yyyy-mm-dd",
            autoclose: true
        });
    }

    handleChange(fieldName) {
        return function (event) {
            this.setState({[fieldName]: event.target.value});
        }.bind(this);
    }

    render() {
        return (
            <div className="create-case">
                <div className="input-group">
                    <span className="input-group-addon">案件编号<font color="red">*</font>：</span>
                    <input id="caseId" type="hidden"
                           defaultValue={this.state.caseId} onChange={this.handleChange("caseId")}/>

                    <input id="caseCode" ref="caseCode" className="form-control" type="text"
                           defaultValue={this.state.caseCode}
                           onChange={this.handleChange("caseCode")}/>
                </div>

                <div className="input-group">
                    <span className="input-group-addon">案件名称<font color="red">*</font>：</span>
                    <input id="caseName" className="form-control" type="text" defaultValue={this.state.caseName}
                           onChange={this.handleChange("caseName")}/>
                </div>
                <div className="input-group">
                    <span className="input-group-addon">负 责 人 <font color="red">*</font> ：</span>
                    <input id="caseOperator" className="form-control" type="text" defaultValue={this.state.caseOperator}
                           onChange={this.handleChange("caseOperator")}/>
                </div>
                <div className="input-group input-daterange">
                    <span className="input-group-addon">立 案 时 间<font color="red">*</font> ：</span>
                    <input id="kickoffDate" className="form-control" type="text"
                           defaultValue={this.state.kickoffDate} onChange={this.handleChange("kickoffDate")}
                    />
                </div>
                <div className="input-group">
                    <span className="input-group-addon">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</span>
                    <textarea id="remark" defaultValue={this.state.remark} onChange={this.handleChange("remark")}
                              className="form-control" rows="3"/>
                </div>
            </div>
        );
    }
}
