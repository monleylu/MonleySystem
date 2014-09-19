<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>AddIP</title>
</head>
<body>
<h1>add user test</h1>
<!-- <form action="showuser.jsp" method="get" target="_blank"> -->
<form action="/testjsp/aa/TestServletFirst" method="post" target="_blank">
IP Add: <input type="text"  name="ip"><br>
OS: <input type="text" name="ostype"><br>
<input type="checkbox" name="chB1" value="Linux">Linux
<input type="checkbox" name="chB2" value="Window">XP<br>
<input type="submit" value="submit"> 
</form>
</body>
</html>