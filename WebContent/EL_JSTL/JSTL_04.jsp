<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int[] score = {100, 200, 300};
	request.setAttribute("arr", score);
%>
<h2> JSTL c:forEach문과 c:forTokens문 실습</h2>
배열 원소값 출력: 
<c:forEach var="i" items="${arr}" begin="0" end="2" step="1">
	<%-- begin, end, step은 생략하여도 상관 없음 --%>
	<c:out value="${i}" /> &nbsp; <%-- &nbsp;는 한칸의 빈공백 --%>
	<c:set var="total" value="${total+i}" />
</c:forEach>
<hr>
누적합: ${total}
<hr>
1~11까지 짝수값: 
<c:forEach var="a" begin="1" end="11" step="1">
	<c:if test="${a%2 == 0}"> ${a} </c:if>
</c:forEach>

<hr>

<c:forTokens var="cityName" items="서울,부산,인천" delims=",">
	<c:out value="${cityName }" />
</c:forTokens>