<%@page language="java" pageEncoding="UTF-8" %>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <c:set var="CTX" value="${pageContext.request.contextPath}" />
 <c:set var="STATIC" value="${CTX}/static" />
 <c:set var="IMG" value="${STATIC}/img" />
 <c:set var="JS" value="${STATIC}/js" />
 <c:set var="LIBS" value="${STATIC}/libs" />
 <c:set var="JQUERY" value="${LIBS}/jquery" />
 <c:set var="BOOTSTRAP" value="${LIBS}/bootstrap-3.3.7-dist" />
 <c:set var="WEBUPLOADER" value="${LIBS}/webuploader" />


 <c:set var="JS" value="${STATIC}/js" />
 <c:set var="CSS" value="${STATIC}/css" />
 <c:set var="PAG" value="${LIBS}/pagination" />
 <c:set var="HAND" value="${LIBS}/handlebars" />
 <c:set var="RENDER" value="${LIBS}/jsrender" />
 <c:set var="BMAP" value="${LIBS}/bmap" />
 <c:set var="PDF" value="${STATIC}/pdf" />
 <c:set var="UE" value="${LIBS}/ueditor" />
 <c:set var="FLOW" value="${LIBS}/flow" />
 <c:set var="ZTREE" value="${LIBS}/ztree" />
<script type="text/javascript">
    window.App = {
        log : function(msg) {
            if (window.console) {
                console.log(msg);
            }
        }
    };
    window.CTX = '${CTX}';
    window.JS = '${JS}';
    window.IMG = '${IMG}';
    window.LIBS = '${LIBS}';
</script>