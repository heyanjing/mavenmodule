<%@ page language="java" pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@include file="/WEB-INF/include/jspTaglib.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${BOOTSTRAP}/css/bootstrap.css">
    <style type="text/css">
        #connect-container {
            float: left;
            width: 400px
        }
        #connect-container div {
            padding: 5px;
        }
        #console-container {
            float: left;
            margin-left: 15px;
            width: 400px;
        }
        #console {
            border:1px solid #CCCCCC;
            border-right-color:#33333333;
            border-bottom-color:#999999;
            height: 170px;
            overflow-y: scroll;
            padding: 5px;
            width: 100%;
        }
        #console p {
            padding: 0;
            margin: 0;
        }
    </style>
</head>
<body>
    <noscript><h2 style="color:#ff0000">Seems your browser doesn't supportJavascript!Websockets
        rely on Javascript being enabled. Please enable
        Javascript and reload this page!</h2></noscript>
    <div>
        <div id="connect-container">
            <input id="radio1"type="radio"name="group1"onclick="updateUrl('${CTX}/websocket');">
            <label for="radio1">W3C WebSocket</label>
            <br>
            <input id="radio2"type="radio"name="group1"onclick="updateUrl('${CTX}/sockjs/websocket');">
            <label for="radio2">SockJS</label>
            <div id="sockJsTransportSelect" style="visibility:hidden;">
                <span>SockJS transport:</span>
                <select onchange="updateTransport(this.value)">
                    <option value="all">all</option>
                    <option value="websocket">websocket</option>
                    <option value="xhr-polling">xhr-polling</option>
                    <option value="jsonp-polling">jsonp-polling</option>
                    <option value="xhr-streaming">xhr-streaming</option>
                    <option value="iframe-eventsource">iframe-eventsource</option>
                    <option value="iframe-htmlfile">iframe-htmlfile</option>
                </select>
            </div>
            <div>
                <button id="connect"onclick="connect();">Connect</button>
                <button id="disconnect"disabled="disabled"onclick="disconnect();">Disconnect</button>
            </div>
            <div>
                <textarea id="message"style="width:350px">Here is a message!</textarea>
            </div>
            <div>
                <button id="echo"onclick="echo();"disabled="disabled">Echo message</button>
            </div>
        </div>
        <div id="console-container">
            <div id="console"></div>
        </div>
    </div>

    <script src="${JQUERY}/jquery-1.12.4.js"></script>
<script src="${WEBSOCKET}/sockjs.min.js"></script>
<script src="${WEBSOCKET}/stomp.min.js"></script>
<script src="${JS}/websocket/websocket3.js"></script>
</body>

</html>