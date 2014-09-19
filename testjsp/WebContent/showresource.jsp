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
	

<script type="text/javascript">

	$(document).ready(function(){

	});
	
	var url;
	function newRes(){
		$('#modifydlg').dialog('open').dialog('setTitle','Add Resect');
		 $('#fm').form('clear');
		url='/testjsp/saveRes';
	}
	
	function editRes(){
		var row=$('#showResdg').datagrid('getSelected');
		if(row){
			$('#modifydlg').dialog('open').dialog('setTitle','Edit Resect');
			$('#fm').form('load',row);
			url='/testjsp/updateRes?id='+row.id;
		}
	}
	
	function saveRes(){
		$('#fm').form('submit',{
			url:url,
			onSubmit:function(){
				return $(this).form('validate')
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result.errorMsg){
					$.messager.show({
						title:'error',
						msg:result.errorMsg
					});
				}else{
					$('#modifydlg').dialog('close');
					$('#showResdg').datagrid('reload');
				}
			}
		}
	);}
	
	function deleteRes(){
		var row=$('#showResdg').datagrid('getSelected');
		if(row){
			$.messager.confirm('Confirm','are you sure to delete this Resect?',function(r){
				if(r){
					$.post('/testjsp/deleteRes',{id:row.id},function(result){
						if(result.success){
							$('#showResdg').datagrid('reload');
						}else{
							$.messager.show({
								title:'error',
								msg:result.errorMsg
							});
						}
					},'json')
				}
			});
		}
	}
</script>
</head>
<body>
<%
	int id=0;
	
	String strID=request.getParameter("id");
	if(strID!=null){
		id=Integer.parseInt(strID);
	}
	/* out.print(id); */
%>
<table id="showResdg" title="Add Resect Information" class="easyui-datagrid" fit="true"
	url="/testjsp/getresource?resid=<%out.print(id);%>"  pagination="true" toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="resid" width="50">设备种类</th>
				<th field="machinetype" width="50">设备型号</th>
				<th field="ip"  width="50">IP地址</th>
				<th field="ostype"  width="50">操作系统</th>
				<th field="diskinfo"  width="50">硬盘</th>
				<th field="memory"  hidden width="50">内存</th>
				<th field="hba"  width="50">HBA卡</th>
				<th field="position"  width="50">设备位置</th>
				<th field="modeName"  width="50">所在项目</th>
				<th field="description"  width="50">描述信息</th>
			</tr>
		</thead>
	</table>
	
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRes()">New Res</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRes()">Edit Res</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteRes()">Delete Res</a>
	</div>
	
	<div id="modifydlg" class="easyui-dialog" style="width:500px;height:400px;padding:10px 20px" closed="true" buttons="#modifydlgbtn">
		<div class="ftitle">Resource Information</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label width="50">设备种类</label>
				<!-- <input name="resid"  class="easyui-validatebox" required="true"> -->
				<input name="resid"  class="easyui-combobox" data-options="valueField:'resid',textField:'text',url:'/testjsp/getresourceitem'" >
			</div>
			<div class="fitem">
				<label width="50">设备型号</label>
				<input name="machinetype"  class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label width="50">IP地址</label>
				<input name="ip" rclass="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label width="50">操作系统</label>
				<!-- <input name="ostype" > -->
				<input name="ostype" class="easyui-combobox" data-options="valueField:'label',textField:'value',data:[{label:'SUSE',value:'SUSE'},{label:'Window',value:'Window'},{label:'Unknow',value:'Unknow',select:true}]" >
			</div>
			<div class="fitem">
				<label style="width:100px">硬  盘</label>
				<input name="diskinfo" >
			</div>
			<div class="fitem">
				<label width="50">内  存</label>
				<input name="memory" >
			</div>
			<div class="fitem">
				<label width="50">HBA卡</label>
				<!-- <input name="hba" > -->
				<input name="hba" class="easyui-combobox"  editable="false" data-options="valueField:'label',textField:'value',data:[{label:'0',value:'NO',select:true},{label:'1',value:'YES'}]" >
			</div>
			<div class="fitem">
				<label width="50">设备位置</label>
				<input name="position" >
			</div>
			<div class="fitem">
				<label width="50">所在项目</label>
				<!-- <input name="mode" > -->
				<input name="mode" class="easyui-combobox" data-options="valueField:'resid',textField:'text',url:'/testjsp/getprojmenu'">
			</div>
			<div class="fitem">
				<label width="50">描述信息</label>
				<input name="description" >
			</div>
		</form>
	</div>
	
	<div id="modifydlgbtn">
		<a  class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRes()">Save</a>
		<a  class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$(modifydlg).dialog('close')">Cancel</a>
	</div>
	
</body>
</html>