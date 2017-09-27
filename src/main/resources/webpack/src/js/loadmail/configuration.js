import React from "react";
import {LoadApiInst} from "../client/index";


/**
 * 装载配置
 */
export default class Configuration extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            clickProps: false,
            loadOptionData: [],
        };
    }

    //数据加载
    componentDidMount() {
        // 调用获取装载案件配置 api
        let caseId = LoadApiInst.ciStorage.get("caseId");
        console.log("案件ID"+caseId);
        let loadOptionData = [];
        LoadApiInst.selectLoadCaseOptionList(caseId, (error, data, response) => {
            if (data) {
                for (let i = 0; i < data.length; i++) {
                    let childOptions = [];
                    let children = data[i].options;
                    for (let j = 0; j < children.length; j++) {
                        childOptions.push({
                            optionKey: children[j].optionKey,
                            optionLabel: children[j].optionLabel,
                            optionValue: children[j].optionValue
                        });
                    }
                    loadOptionData.push({
                        pluginName: data[i].pluginName,
                        options: childOptions
                    });
                }
                this.setState({
                    loadOptionData: loadOptionData
                })
            }
        });
    }

    render() {
        let content = this.state.loadOptionData.map((rep, idx) => {
            let html = <FieldSet key={idx} title={rep.pluginName} options={rep.options}/>;
            return (html);
        });
        return (
            <div className="ci-load-configuration">
                {content}
            </div>
        )
    }
}

//FieldSet组件
class FieldSet extends React.Component {
    constructor(props) {
        super(props);
    }

    //全选
    checkAll(e) {
        let checked = e.target.checked;
        $(e.target).parent().parent().parent().find("input[type='checkbox']").each(function () {
            $(this).prop('checked', checked);
        })
    }

    //反选(选中子节点时反选父节点)
    checkParent(e) {
        let parentNode = $(e.target).parent().parent().parent().parent().find("legend input[name='parent']");
        let isChecked = parentNode.is(":checked");
        if (!isChecked) {
            parentNode.prop("checked", true);
        }
    }

    render() {
        let options = this.props.options;
        let lists = options.map((cmt, idx) => {
            return (
                <span key={idx} className="checkbox ci-load-option-checkbox">
                    <label>
                        <input type="checkbox" value={cmt.optionValue} name={cmt.optionKey}
                               className="ci-load-option-result"
                               onChange={this.checkParent.bind(this)}/>
                        <span>{cmt.optionLabel}</span>
                    </label>
                </span>
            );
        });
        return (
            <fieldset className="ci-fieldset-configuration">
                <legend className="ci-title-configuration">
                    <label>
                        <input type="checkbox" name="parent" defaultValue={this.props.title}
                               onChange={this.checkAll.bind(this)}/>
                        <span className="plugin-name">{this.props.title}</span>
                    </label>
                </legend>
                <div>
                    {lists}
                </div>
            </fieldset>
        )
    }
}
