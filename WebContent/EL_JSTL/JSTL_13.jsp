<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:set var="country" value="${param.country}" />
	
	<c:if test="${!empty country}">
		국가명: ${country} <hr>
	</c:if>
	
	<c:choose>
		<c:when test="${ country == 'korea' }"> ${country}의 겨울은 춥다 </c:when>
		<c:when test="${ country == 'canada' }"> ${country}의 겨울은 더 춥다. </c:when>
		<c:otherwise>해당하는 나라가 없음</c:otherwise>
	</c:choose>
</body>
</html>