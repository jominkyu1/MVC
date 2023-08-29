<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h3>EL 표현언어 닷(.) 연산자</h3>
	<%-- requestScope는 jsp내장객체의 request에 해당한다. name키이름 값을 가져온다. --%>
	${requestScope.name}  <br>
	${param.id} <hr> <%-- 파라미터이름 id에 실려온 값을 EL로 출력 URI?id=값 --%>
	
	<h3>브라켓 [ ] 연산자</h3>
	${requestScope["name"]} <br>
	${param['id']} <hr>
	
	<h3>jsp로 표현</h3>
	<%=request.getAttribute("name")%> <br>
	<%=request.getParameter("id")%>	<hr>
</body>
</html>