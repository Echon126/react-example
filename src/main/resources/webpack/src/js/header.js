import React from "react";
import Case from "./case/case";
import Menus from "./menu/menu";

/**
 * 标题栏
 */
export default class Header extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <header id="header" className="main-header row">
                <div className="col-md-12" id="caseArea">
                    <div id="caseSelector" className="pull-left">
                        <Case/>
                    </div>
                    <div id="menuArea" className="dropdown pull-right">
                        <Menus/>
                    </div>
                </div>
            </header>
        )
    }

}