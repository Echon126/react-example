import React from "react";
import ReactDOM from "react-dom";
import Dialog from "../dialog";
import {LexiconApiInst, LogoutApiInst, PluginApiInst} from "../client/index";
import "../../css/menu/menu.css";
import PubSub from "pubsub-js";
const dialog = new Dialog();

/**
 * 功能菜单
 * Created by xcp on 2017/5/4.
 */
export default class Menu extends React.Component {

    constructor(props) {
        super(props);
        this.openPromptDialog = this.openPromptDialog.bind(this);
    }

    componentWillMount() {
        // 订阅打开提示页面
        this.tokenOpenPromptDialog = PubSub.subscribe("header.openPromptDialog", this.openPromptDialog);
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenOpenPromptDialog);
    }


    openPromptDialog(topic, title) {
        ReactDOM.unmountComponentAtNode($("#dialog2")[0]);
        ReactDOM.render(
            <div>{title}</div>,
            $("#dialog2")[0]
        );
        dialog.openDialog("#dialog2", "删除案件", {
            "确 定": function () {
                $(this).dialog("close");
            }
        }, 400, 150);
    }

    // 插件管理 菜单点击事件
    pluginManagement() {
        ReactDOM.unmountComponentAtNode($("#dialog")[0]);

        ReactDOM.render(
            <Plugin></Plugin>,
            $("#dialog")[0]
        );
        dialog.openDialog("#dialog", "插件管理", {
            "确 定": function () {
                let pluginIds = "";
                // 获取已选中的所有插件id
                $("input[name='plugin']:checked").each(function () {
                    pluginIds += $(this).val() + ","
                });
                if (pluginIds.length > 1) {
                    pluginIds = pluginIds.substr(0, pluginIds.length - 1);
                }
                // 保存插件管理信息
                PluginApiInst.updatePluginOptions(pluginIds, (error, data, response) => {
                    if (response.ok) {
                        $(this).dialog("close");
                    }
                });
            },
            "取 消": function () {
                $(this).dialog("close");
            }
        });

    }

    // 词库管理 菜单点击事件
    lexiconManagement() {
        ReactDOM.unmountComponentAtNode($("#dialog")[0]);

        ReactDOM.render(
            <Lexicon></Lexicon>,
            $("#dialog")[0]
        );
        dialog.openDialog("#dialog", "词库管理", {
            "确 定": function () {
                let lexiconIds = "";
                // 获取已选中的所有词库id
                $("input[name='lexicon']:checked").each(function () {
                    lexiconIds += $(this).val() + ","
                });
                if (lexiconIds.length > 1) {
                    lexiconIds = lexiconIds.substr(0, lexiconIds.length - 1);
                }
                console.log("选中的词库id为：" + lexiconIds);

                // 保存词库管理信息 api
                LexiconApiInst.updateLexiconOptions(lexiconIds, (error, data, response) => {
                    if (response.ok) {
                        $(this).dialog("close");
                    }
                });
            },
            "取 消": function () {
                $(this).dialog("close");
            }
        });
    }

    // 安全退出 菜单点击事件
    safeExit() {
        ReactDOM.unmountComponentAtNode($("#dialog")[0]);

        ReactDOM.render(
            <div>您确认要安全退出吗？</div>,
            $("#dialog")[0]
        );
        dialog.openDialog("#dialog", "安全退出", {
            "确 定": function () {

                // 调用安全退出 api
                LogoutApiInst.safeLogout((error, data, response) => {
                    if (response.ok) {
                        console.log("已安全退出");
                        // TODO 调用浏览器退出方法
                        $(this).dialog("close");

                        window.cInsight.uiExit(function (data, err) {
                            console.log("uiExit with ", data, err);
                        });
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
            <div className="ci-menu-area">
                <button type="button" className="btn btn-default btn-xs ci-menu-area-btn"
                        onClick={this.pluginManagement} title="插件管理">
                    <i className="fa fa-gears"/>
                </button>
                <button type="button" className="btn btn-default btn-xs ci-menu-area-btn"
                        onClick={this.lexiconManagement} title="词库管理">
                    <i className="fa fa-book"/>
                </button>
                <button type="button" className="btn btn-default btn-xs ci-menu-area-btn"
                        onClick={this.safeExit} title="安全退出">
                    <i className="fa fa-power-off"/>
                </button>
            </div>
        )
    }

}

// 插件管理
class Plugin extends React.Component {

    constructor(props) {
        super(props);
        this.handleChangeCheckBox = this.handleChangeCheckBox.bind(this);
        this.handleClickPluginName = this.handleClickPluginName.bind(this);
        this.state = {
            remark: "",
            data: []
        };
    }

    componentDidMount() {
        let pluginData = [];
        PluginApiInst.selectPluginOptionList((error, data, response) => {
            if (data) {
                for (let i = 0; i < data.length; i++) {
                    pluginData.push({
                        key: i,
                        pluginId: data[i].pluginId,
                        pluginName: data[i].pluginName,
                        pluginDescription: data[i].pluginDescription,
                        pluginEnabled: (data[i].pluginEnabled == 1)
                    });
                }
            }
            this.setState({data: pluginData});
        });
    }

    // 插件checkbox 改变事件
    handleChangeCheckBox(e) {
        let data = this.state.data;
        if (data[e.target.id].pluginEnabled) {
            data[e.target.id].pluginEnabled = false;
        } else {
            data[e.target.id].pluginEnabled = true;
        }
        this.setState({});
    }

    // 插件名称 点击事件
    handleClickPluginName(remark) {
        this.setState({remark: remark});
    }

    render() {

        let pluginList = this.state.data.map((cmt) => {
            return (
                <span key={cmt.key} className="checkbox">
                    <label>
                        <input type="checkbox" value={cmt.pluginId} id={cmt.key} name="plugin"
                               onChange={this.handleChangeCheckBox.bind(this)} checked={cmt.pluginEnabled}/>
                        <span
                            onClick={this.handleClickPluginName.bind(this, cmt.pluginDescription)}>{cmt.pluginName}</span>
                    </label>
                </span>
            );
        });

        return (
            <div id="plugin-area" className="plugin-area">
                <div className="row">
                    <div className="col-md-5 text-center">系统可用插件</div>
                    <div className="col-md-7 text-center">描述</div>
                </div>
                <div className="row">
                    <div className="col-md-5">
                        <div className="plugin-label">
                            {pluginList}
                        </div>
                    </div>
                    <div className="col-md-7">
                        <div className="plugin-remark">
                            <div className="remark-content">
                                {this.state.remark}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

}

// 词库管理
class Lexicon extends React.Component {

    constructor(props) {
        super(props);
        this.checkAll = this.checkAll.bind(this);
        this.checkInvert = this.checkInvert.bind(this);
        this.handleChangeCheckBox = this.handleChangeCheckBox.bind(this);
        this.state = {
            data: []
        };
    }

    componentDidMount() {
        let lexiconData = [];
        LexiconApiInst.selectLexiconOptionList((error, data, response) => {
            if (data) {
                for (let i = 0; i < data.length; i++) {
                    lexiconData.push({
                        key: i,
                        lexiconId: data[i].lexiconId,
                        lexiconName: data[i].lexiconName,
                        lexiconEnabled: data[i].lexiconEnabled
                    });
                }
            }
            this.setState({data: lexiconData});
        });
    }

    // 全选
    checkAll() {
        this.state.data.forEach(function (lexicon) {
            lexicon.lexiconEnabled = true;
        });
        this.setState({});
    }

    // 反选
    checkInvert() {
        this.state.data.forEach(function (lexicon) {
            if (lexicon.lexiconEnabled) {
                lexicon.lexiconEnabled = false;
            } else {
                lexicon.lexiconEnabled = true;
            }

        });
        this.setState({});
    }

    handleChangeCheckBox(e) {
        let data = this.state.data;
        if (data[e.target.id].lexiconEnabled) {
            data[e.target.id].lexiconEnabled = false;
        } else {
            data[e.target.id].lexiconEnabled = true;
        }
        this.setState({});
    }

    render() {
        let lists = this.state.data.map((cmt) => {
            return (
                <span key={cmt.key} className="checkbox">
                    <label>
                        <input type="checkbox" value={cmt.lexiconId} id={cmt.key} name="lexicon"
                               onChange={this.handleChangeCheckBox.bind(this)}
                               checked={cmt.lexiconEnabled}/> {cmt.lexiconName}
                    </label>
                </span>
            );
        });
        return (
            <div className="lexicon">
                <div className="lexicon-title">
                    请选择要加入的词库
                    <span>
                        <button type="button" className="btn btn-primary lexicon-btn" onClick={this.checkAll}>全选
                        </button>
                        <button type="button" className="btn btn-primary lexicon-btn" onClick={this.checkInvert}>反选
                        </button>
                    </span>
                </div>
                <div className="lexicon-content">
                    {lists}
                </div>
            </div>
        )
    }

}