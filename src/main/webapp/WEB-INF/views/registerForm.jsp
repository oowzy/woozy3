<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>


<html>
<head>
	<title>register</title>
</head>
<body>
	<H1>회원가입</H1>
	<form action="registerAction" >
	ID : <input type="text" name="id"/><br/>
	PW : <input type="password" name="pw"/><br/>
	NAME : <input type="text" name="name"/><br/>
	
	<input type="submit" value="회원가입완료"/>
	</form>


</body>
</html>
