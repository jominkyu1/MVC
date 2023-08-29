<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h2>기존 useBean 표현식과  EL 비교실습</h2>
	<jsp:useBean id="user" class="net.daum.vo.UserVO" scope="page" />
	<%-- JSP 유즈빈 액션태그를 사용하여 UserVO빈클래스의 객체명 user를 생성 --%>
	<jsp:setProperty name="user" property="firstName" value="홍" />
	<%--값 저장 액션태그이다. 
		자바코드로 표현하면 user.setFirstName("홍");
	--%>
	<jsp:setProperty name="user" property="lastName" value="길동" />
	<h3>기존 useBean</h3>
	성: <jsp:getProperty property="firstName" name="user"/> <br>
	이름: <%=user.getLastName()%> <hr>
	
	<h3>표현언어인 EL로 출력</h3>
	성: ${user.firstName} <br>
	이름: ${user.lastName}
</body>
</html>