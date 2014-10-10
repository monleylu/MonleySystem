<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/testjsp/jquery-easyui-1.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/testjsp/jquery-easyui-1.4/themes/icon.css">
	<script type="text/javascript" src="/testjsp/jquery-easyui-1.4/jquery.min.js"></script>
	<script type="text/javascript" src="/testjsp/jquery-easyui-1.4/jquery.easyui.min.js"></script>
</head>
<body>
<%
	int id=0;
	String strID=request.getParameter("id");
	if(strID!=null){
		id=Integer.parseInt(strID);
	}
%>

<table id="showResdg" title="关联资源信息" class="easyui-datagrid" fit="true"
	url="/testjsp/getassociateresource?resid=<%out.print(id);%>"   rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="resIdName" width="50">设备种类</th>
				<th field="machinetype" width="50">设备型号</th>
				<th field="ip"  width="50">IP地址</th>
			</tr>
		</thead>
	</table>
	
	
</body>
</html>