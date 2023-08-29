<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/images/grape.jpg" var="data" />
<h3>그림파일명: ${data}</h3>
<img src="${data}" alt="청포도">