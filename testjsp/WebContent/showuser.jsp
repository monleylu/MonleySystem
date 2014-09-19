<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show IP Information</title>
<style type="text/css">
table,th,td{
border: 1px solid blue;
with:450;
}
</style>
</head>
<body>
<h1>Show User Information</h1>
<table >
<tr>
<th>IP</th><th>OSType</th>
</tr>
<tr>
<td><%=request.getParameter("ip") %></td>
<td><%=request.getParameter("ostype")%></td>
</tr>
</table>

<table >
<tr>
<th>Paramter Name</th>
<th>Paramter Value</th>
</tr>
<%
	Enumeration<String> paramNames=request.getParameterNames();
	while(paramNames.hasMoreElements()){
		String paramName=paramNames.nextElement();
		out.print("<tr><td>" + paramName+ "</td>");
		String paramValue=request.getParameter(paramName);
		out.print("<td>" + paramValue + "</td></tr>");
	}
%>
</table>
<div >
	<label><%=request.getParameter("chB1") %></label>
	<label><% if( request.getParameter("chB2")==null)
					{
						out.print("no selected");
					}
				else
					{
						out.print(request.getParameter("chB2"));
					}
				%>
		</label>
				
</div>

</body>
</html>