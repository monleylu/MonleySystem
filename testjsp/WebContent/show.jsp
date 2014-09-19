<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.test.testservlet.Catalog" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Data From DataBase </title>
</head>
<body>
<table border="1px ">
<tr>
<th>Name</th><th>Desc</th><th>Modify</th><th>Delete</th>
</tr>
<%
	ArrayList<Catalog> list = new ArrayList<Catalog>();
	list=(ArrayList<Catalog>)request.getAttribute("list");
	for(int i = 0 ;i<list.size();i++){
		out.print("<tr>");
		out.print("<td>"+list.get(i).getName()+ "</td>");
		out.print("<td>"+list.get(i).getDesc()+ "</td>");
		out.print("<td><a href=/testjsp/modify?id=" +list.get(i).getId()+">" +"modify"+ "</a></td>");
		out.print("<td><a href=/testjsp/delete?id=" +list.get(i).getId()+">" +"delete" +"</a></td>");
		out.println("</tr>");
	}


%>

</table>
</body>
</html>