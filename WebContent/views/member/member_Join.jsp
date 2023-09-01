<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet MVC 회원가입 폼</title>
</head>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="./js/member.js"></script>
<body>
	<form method="post" action="mem_join_ok.daum" onsubmit="return join_check()">
		아이디: <input type="text" name="mem_id" id="mem_id"> <br><br>
		비밀번호: <input type="password" name="mem_pwd" id="mem_pwd"> <br><br>
		비번확인: <input type="password" name="pwd_chk" id="pwd_chk"> <br><br>
		회원이름: <input name="mem_name" id="mem_name"> <br><br>
		Phone: <input type="tel" name="mem_phone" id="mem_phone"> <br><br>
		E-mail: <input type="email" name="mem_email" id="mem_email"> <hr><br>
		
		<input type="submit" value="회원가입">
		<input type="reset" value="Reset" onclick="$('#mem_id').focus()">
	</form>
</body>
</html>