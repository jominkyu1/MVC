<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! //선언문 => 변수 선언용도로 활용됨
    	Connection con=null;
    	DataSource ds = null;
    %>
    <%
		    try{
		    	Context ctx = new InitialContext();
		    	//JNDI 디렉토리 서비스에 의해서 폴더 server.xml에 설정된 xe데이터베이스를 찾아서 커넥션 풀 관리 DataSource 생성
		    	ds = (DataSource) ctx.lookup("java:comp/env/jdbc/xe"); 
		    	con = ds.getConnection();
		    	out.println("DBCP 커넥션 풀 연결 성공!");
		    } catch (Exception e){
		    	e.printStackTrace();
		    } finally {
		    	try {
		    		if (con!=null) con.close();	
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
</body>
</html>