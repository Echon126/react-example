import React from "react";
import {TagApiInst} from "../client/index";
import PubSub from "pubsub-js";
import "../../css/workspace/tag.css";

/**
 * 标签区域
 * Created by xcp on 2017/5/5.
 */
export default class Tag extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {

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
                        <TagTree clickTag={this.props.clickTag}/>
                    </div>
                </div>
            </div>
        )
    }

}


class TagTree extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            zNodes: [],
        };
        this.resetTagsData = this.resetTagsData.bind(this);
        this.addDiyDom = this.addDiyDom.bind(this);
    }

    componentDidMount() {
        this.resetTagsData();
    }

    componentWillMount() {
        this.tokenResetTagsData = PubSub.subscribe("sidebar.resetTagsData", this.resetTagsData);
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.tokenResetTagsData);
    }

    resetTagsData() {
        let caseId = TagApiInst.ciStorage.get("caseId");
        let treeData = [];

        TagApiInst.selectTagList(caseId, (error, data, response) => {
            if (data) {
                for (let i = 0; i < data.length; i++) {
                    treeData.push({
                        id: i + 1,
                        pId: 0,
                        name: data[i].typeName,
                        open: i == 0 ? true : false,
                        icon: data[i].typeIcon
                    });
                    let child = data[i].tags;
                    for (let j = 0; j < child.length; j++) {
                        treeData.push({
                            id: (i + 1) + "" + j,
                            pId: i + 1,
                            name: child[j].tagName,
                            hitCount: child[j].hitCount,
                        });
                    }
                }
                this.setState({zNodes: treeData});
                const setting = {
                    view: {
                        addDiyDom: this.addDiyDom
                    },
                    data: {
                        simpleData: {
                            enable: true
                        }
                    },
                    callback: {
                        onClick: this.props.clickTag
                    }
                };
                $.fn.zTree.init($("#tagTree"), setting, this.state.zNodes);
            }
        });
    }

    addDiyDom(treeId, treeNode) {
        var aObj = $("#" + treeNode.tId + "_a");
        if ($("#diyBtn_" + treeNode.id).length > 0) return;
        if ($("#" + treeNode.tId + "_a").attr("class") == "level0") return;
        var editStr = " <span class='ci-tag-hit-count'>" + treeNode.hitCount + "</span>";
        aObj.append(editStr);
    }

    render() {
        return (
            <ul id="tagTree" className="ztree"></ul>
        )
    }
}