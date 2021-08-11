<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>

<%
	if(request.getAttribute("msg")!=null){
		
%>		
	<script>alert('${msg}');</script>
	
<% 	
	}

%>

<html>
<head>
	<title>Home</title>
</head>
<body>
	<form action="loginAction">
	ID : <input type="text" name="id"/><br/>
	PW : <input type="password" name="pw"/><br/>
	
	<input type="submit" value="로그인" style="width:200px;"/>
	
	
	</form>
<a href="register"><button style="width:200px;">회원가입</button></a>
</body>
</html>
