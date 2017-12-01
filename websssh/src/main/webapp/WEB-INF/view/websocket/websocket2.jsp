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
    <div class="page-header" id="tou">
        webSocket多终端聊天测试
    </div>
    <div class="well" id="msg"></div>
    <div class="col-lg">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="发送信息..." id="message">
            <span class="input-group-btn">
                    <button class="btn btn-default" type="button" id="send" >发送</button>
                    <button class="btn btn-default" type="button" id="close" >关闭</button>
                    <button class="btn btn-default" type="button" id="conn" >连接</button>
                </span>
        </div>
    </div>


<script src="${JQUERY}/jquery-1.12.4.js"></script>
<script src="${WEBSOCKET}/sockjs.min.js"></script>
<script src="${WEBSOCKET}/stomp.min.js"></script>
<script src="${JS}/websocket/websocket2.js"></script>
</body>

</html>