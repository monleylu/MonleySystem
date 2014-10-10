<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(request.getAttribute("errqq1")!=null){
		out.println(request.getAttribute("errqq"));
	}
%>
<h1>Welcome Login</h1>
<form action="loginverify"  method="post">

Input Name :<input type="text" name="loginname"><br>
<input type="submit" value="submit">

</form>
</body>
</html>