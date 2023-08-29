<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:out value="JSTL 출력문" />

<%-- JSTL msg변수에 안녕하세요 문자열 저장 --%>
<c:set var="msg" value="${'안녕하세요'}" />
<c:set var="age" scope="page"> ${28} </c:set>
<hr>
<c:out value="${msg}" /> <br>
나이: <c:out value="${age}" />
<hr>

<c:remove var="age" scope="page" /> <%-- JSTL문으로 age 변수 제거 --%>
나이: ${age} 
<hr>

<c:catch var="errmsg"> <%-- 발생된 예외를 변수 errmsg에 담아옴 --%>
예외 발생전
	<%=10/0%> <br>
예외 발생후
</c:catch>
<c:out value="${errmsg}" />
<hr>