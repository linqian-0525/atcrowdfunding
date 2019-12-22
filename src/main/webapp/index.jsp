<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" errorPage="WEB-INF/jsp/error/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%--<h2>Hello World!</h2>
<a href="${pageContext.request.contextPath}/test.do">test</a>
<a href="${APP_PATH}/test.do">test2</a>--%>
<jsp:forward page="${APP_PATH}/index.htm"></jsp:forward>
</body>
</html>
