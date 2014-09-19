<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add data to test table </title>
</head>
<body>


<h1>Add data </h1>
<form action="todb" method="post" >
<%
	int id=0;
	if(request.getParameter("id")!=null){
		id=(Integer.parseInt((String)request.getParameter("id")));
	}
	
	
	if (id != 0) {
		out.print("<input type=\"hidden\" name=\"id\" value =" + id
				+ "><br>");
		out.print("name:<input type=\"text\" name=\"name\" value ="
				+ request.getAttribute("name") + " ><br>");
		out.print("description:<input type=\"text\" name=\"desc\" value = "
				+ request.getAttribute("desc") + "><br>");
	} else {
		out.println("<input type=\"hidden\" name=\"id\" value =><br>");
		out.println("name:<input type=\"text\" name=\"name\" ><br>");
		out.println("description:<input type=\"text\" name=\"desc\"><br>");
	}
%>
<!-- <input type="hidden" name="id" value =>
<br>
name:<input type="text" name="name" ><br>
description:<input type="text" name="desc"><br> -->
<input type="submit" value="submit">

</form>
</body>
</html>