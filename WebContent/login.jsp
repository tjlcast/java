<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/login.action" methode="post">
		<label>name<input name="name" type="text" /></label>
		<br />
		<label>password<input name="pwd" type="password"/></label>
		
		<br />
		<input type="submit">
	</form>
</body>
</html>