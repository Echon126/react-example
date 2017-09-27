import React from "react";
import "../../css/common/tag-show.css";
/**
 * 标签展示
 */
export default class TagShow extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        let content = [];
        if (this.props.tag) {
            let data = this.props.tag.split(",");
            for (let i = 0; i < data.length; i++) {
                content.push(<a key={i} href="javascript:void(0)" target="_blank"
                                className="btn btn-warning ci-tag">{data[i]}</a>);
            }
        }

        /*
         let tagList = this.props.tags.map((cmt, idx) => {
         return (
         <a key={idx} href="javascript:void(0)" target="_blank" className="btn btn-warning ci-tag">
         <i className={cmt.typeIcon}/> {cmt.typeName}
         </a>
         );
         });*/

        return (
            <div className="ci-tag-content">
                {content}
                <a href="javascript:void(0)" target="_blank" className="btn btn-warning ci-tag" title="编辑"
                   onClick={this.props.handleAddTagClick}>
                    <i className="fa fa-edit"/>
                </a>
            </div>
        );
    }
}
