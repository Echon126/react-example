import "./css/main.css";
import React from "react";
import ReactDOM from "react-dom";
import Header from "./js/header";
import InitialPage from "./js/initial-page";


ReactDOM.render(
    <Header/>,
    $("#header")[0]
);

ReactDOM.render(
    <InitialPage/>,
    $("#workspace")[0]
);