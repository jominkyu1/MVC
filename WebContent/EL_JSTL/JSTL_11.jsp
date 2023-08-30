<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:set var="now" value="<%=new Date()%>" />
	Original Date(): 	${now} <br><br>
	
	fmt로 날짜값 출력: <fmt:formatDate value="${now}" type="date" dateStyle="full"/> <br>
	fmt로 날짜값 간단히 출력: <fmt:formatDate value="${now}" type="date" timeStyle="short" /> <br><br>
	
	fmt로 시간값 출력: <fmt:formatDate value="${now}" type="time" timeStyle="full" /> <br>
	fmt로 시간값 간단히 출력: <fmt:formatDate value="${now}" type="time" timeStyle="short" /> <br><br>
	
	fmt로 날짜+시간 출력: <fmt:formatDate value="${now}" type="both" /> <%-- type="both"는 date+time --%>
	<hr>
</body>
</html>