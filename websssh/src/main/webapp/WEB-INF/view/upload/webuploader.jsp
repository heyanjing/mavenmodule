<%@ page language="java" pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@include file="/WEB-INF/include/jspTaglib.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>文件上传</title>
    <link rel="stylesheet" type="text/css" href="${WEBUPLOADER}/webuploader.css">
    <link rel="stylesheet" type="text/css" href="${CSS}/upload/webuploader.css">
</head>
<body>
    <div id="uploader" class="wu-example" style="width: 600px;height: 400px;">
        <div class="queueList">
            <div id="dndArea" class="placeholder">
                <div id="filePicker"></div>
                <p>或将照片拖到这里，单次最多可选300张</p>
            </div>
        </div>
        <div class="statusBar" style="display:none;">
            <div class="progress">
                <span class="text">0%</span> <span class="percentage"></span>
            </div>
            <div class="info"></div>
            <div class="btns">
                <div id="filePicker2"></div>
                <div class="uploadBtn">开始上传</div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="${JQUERY}/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${WEBUPLOADER}/webuploader.js"></script>
    <script type="text/javascript" src="${JS}/upload/webuploader.js"></script>
</body>
</html>