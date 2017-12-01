<%@ page language="java" pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@include file="/WEB-INF/include/jspTaglib.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${BOOTSTRAP}/css/bootstrap.css">
    <link rel="stylesheet" href="${CSS}/websocket/websocket.css">
</head>
<body>
    <noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
        Javascript and reload this page!</h2></noscript>
    <div>
        <div>sessionId:<input id="sessionId" value="${sessionId}" /></div>
        <div>
            <button id="connect" onclick="connect();">Connect</button>
            <button id="connectAny" onclick="connectAny();">ConnectAny</button>
            <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
        </div>
        <div id="conversationDiv">
            <label>What is your name?</label><input type="text" id="name" />
            <button id="sendName" onclick="sendName();">Send</button>
            <button id="sendName2" onclick="sendName2();">Send2</button>
            <p id="response"></p>
        </div>
    </div>

    <script src="${JQUERY}/jquery-1.12.4.js"></script>
<script src="${WEBSOCKET}/sockjs.min.js"></script>
<script src="${WEBSOCKET}/stomp.min.js"></script>
<script src="${JS}/websocket/websocket4.js"></script>
</body>

</html>