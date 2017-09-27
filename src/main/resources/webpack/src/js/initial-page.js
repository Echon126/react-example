import React from "react";
import PubSub from "pubsub-js";
/**
 * 初始页面
 * Created by xcp on 2017/5/19.
 */
export default class InitialPage extends React.Component {

    constructor(props) {
        super(props);
    }

    componentDidMount() {
        PubSub.publish("header.changeCase", true);
    }

    render() {
        return (
            <div>
            </div>
        )

    }
}