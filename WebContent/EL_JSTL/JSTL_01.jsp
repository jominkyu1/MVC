<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- JSTL 코어 태그립 추가, JSTL은 JSP Standard Tag Library의 약자이다. 
	Servlet MVC를 포함한 스프링 프레임워크에서 뷰페이지 문법으로 많이 사용되어짐.
	Spring Boot이후부터는 ThymeLeaf를 제공
	
	뷰페이지 문법으로 JSTL과 EL을 사용하면 기존의 JSP 스크립트 요소인 선언문, 
	스크립트 릿, 표현식보다 가독성이 좋아지고 코드가 더 간결해진다.
--%>

<jsp:useBean id="user" class="net.daum.vo.UserVO" />
<jsp:setProperty name="user" property="firstName" value="세종" />
<jsp:setProperty name="user" property="lastName" value="대왕님" />

<h3> 기존 JSP 스크립트 요소로 성과 이름 가져오기 </h3>
성: <%=user.getFirstName()%> <br>
이름: <%=user.getLastName()%> 

<h3> JSTL과 EL을 사용하여 성과 이름 가져오기</h3>
성: ${user.firstName} <br>
이름: 
<c:if test="${!empty user.lastName}"> <%-- c:if JSTL 조건문이다. test속성값으로  EL이 사용됨 --%>
	${user.lastName}
</c:if>
