<%@page import="net.daum.vo.TestVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:if test="${empty tlist}">
		<h2>목록이 없습니다.</h2>
	</c:if>
	<c:forEach var="t" items="${tlist}">
		${t.no} -- ${t.content} <br>
	</c:forEach>
	<hr>
	<button onclick="location='service_write'">글작성</button>
</body>
</html>