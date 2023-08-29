<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form method="post" action="EL_04.jsp">
		<label for="addr">주소</label> <%-- label을 눌러도 입력텍스트로 포커스 이동 --%>
		<input type="text" name="addr" id="addr" value="${param.addr}">
		<input type="submit" value="전송">
		<hr>
		<h3>입력하신 주소: ${param.addr}</h3> 
	</form>
</body>
</html>