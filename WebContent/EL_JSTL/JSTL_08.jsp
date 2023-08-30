<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
 	<c:if test="true"> <%-- JSTL IF문에는 else는 없다. --%>
		<c:out value="무조건 실행됨." />
	</c:if>
	<hr> 
	<c:if test="${ param.name == 'king' }">
		name파라미터값은 ${param.name} 입니다.
	</c:if>
	<hr>
	<c:if test="${ param.age > 20 }">
		나이가 20보다 큼.
	</c:if>
	<hr>
	<%-- c:choose, c:when, c:otherwise는 switch ~case문에 해당하는 다중 선택문 
		switch -> c:choose
		case -> c:when
		default -> c:otherwise
	--%>
	<c:choose>
		<c:when test="${param.name == 'queen' }">
			퀸입니다. <hr>		
		</c:when>
		<c:when test="${param.age <= 20}">
			20세 이하입니다. <hr>
		</c:when>
		<c:otherwise>king queen 둘다 아님</c:otherwise>
	</c:choose>
</body>
</html>