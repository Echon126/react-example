/**
 * dialog弹窗
 * Created by xcp on 2017/5/2.
 */
import React from "react";

export default class Dialog extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
    }

    openDialog(container = "#dialog", title = "提示", btnFunction, width = 520, height = 400, modal = true, closeOnEscape = false) {
        $(container).dialog({
            title: title,
            height: height,
            width: width,
            modal: modal,
            closeOnEscape: closeOnEscape,
            open: function (event, ui) {
                $(".ui-dialog-titlebar-close").hide();
            },
            buttons: btnFunction,
            draggable: false,
            resizable: false
        });
    }

    closeDialog(container = "#dialog") {
        $(container).dialog("close")
    }


}