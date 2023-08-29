<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="fruit" value="${param.name}" /> <%-- 쿼리파라미터 name의 값을 fruit JSTL 변수에 저장 --%>

파라미터이름 name에 실려온 값: 
<c:if test="${!empty fruit}">
	<c:out value="${fruit}" />
</c:if>
<hr>

<c:choose>
	<c:when test="${fruit == 'apple' }">
		맛있는 사과입니다! <br>
	</c:when>
	<c:otherwise> 해당사항 없음 </c:otherwise>
</c:choose>