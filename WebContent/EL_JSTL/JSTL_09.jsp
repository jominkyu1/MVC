<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4> 1부터 100까지의 홀수 누적 합</h4>
<c:set var="sum" value="0" /> <%-- c:set은 JSTL의 변수설정태그 --%>

<c:forEach var="i" begin="1" end="100" step="2">
	<c:set var="sum" value ="${sum+i}" />
</c:forEach>

누적합: ${sum}

<hr>

<h4>구구단: 7단</h4>
<%--
	c:forEach JSTL반복문을 사용하여 구구단 7단 출력
--%>

<c:forEach var="i" begin="1" end="9" step="1">
	7 x ${ i } = ${ 7 * i } <br>
</c:forEach>