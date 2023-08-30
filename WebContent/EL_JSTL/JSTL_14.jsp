<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:requestEncoding value="UTF-8"/>
    <%-- POST로 전달되는 한글을 UTF-8로 인코딩하여 한글을 안깨지게 만듦
    	JSP의 request.setCharacterEncoding("UTF-8");과 같은 기능
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form method="post" action="">
		<label for="name">이름입력: </label>
		<input type="text" id="name" name="name">
		<input type="submit" value="확인">
	</form>
	<hr>
	입력하신 이름: <strong>${param.name}</strong>
</body>
</html>