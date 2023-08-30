<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:set var="str01" value="aBcD e f" />
문자열: [${str01}] <br>
문자열길이:  ${fn:length(str01)} <br>
대문자로변경: [${fn:toUpperCase(str01)}] <br>
소문자로변경: [${fn:toLowerCase(str01)}] <br>
문자열 index 2이상 4미만: ${fn:substring(str01, 2, 4)} <br>
빈공백을 -로 변경: ${fn:replace(str01, " ", "-")} <hr>

	<c:set var="token" value="1,2,3,4,5" />
	<c:set var="arr" value="${fn:split(token, ',')}" />
배열로 분리:	<c:forEach var="i" items="${arr}">
					${i}
				</c:forEach>
				<br>
배열원소값을 +로 결합: ${fn:join(arr, "+")} <hr>
</body>
</html>