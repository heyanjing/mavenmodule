<%@ page language="java" pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h2>Hello World!何彦静   </h2>
    <br>
    requestScope    user-${requestScope.user}<br>
    requestScope    user2-${requestScope.user2}<br>
    requestScope    user3-${requestScope.user3}<br>
    requestScope    usercopy-${requestScope.usercopy}<br>
    requestScope    a-${requestScope.a}<br> b-- ${requestScope.b}<br><br><br><br><br><br>


    sessionScope    user-${sessionScope.user}<br>
    sessionScope    user2-${sessionScope.user2}<br>
    sessionScope    user3-${sessionScope.user3}<br>
    sessionScope    usercopy-${sessionScope.usercopy}<br>
    sessionScope    a-${sessionScope.a}<br> b-- ${sessionScope.b}<br><br><br><br><br>

    x--${x}
    <br><br><br><br><br>
    ${message}
    <br><br><br><br><br>
    <br><br><br><br><br>
    <br><br><br><br><br>
    <br><br><br><br><br>
</body>
</html>
