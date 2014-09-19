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
		
		var id=$('#hideid').attr("value");
		var fieldshow=true;
		if(id==101 || id ==102){
			fieldshow=false;
			$('#ostype').attr("hidden",false);
			$('#diskinfo').attr("hidden",false);
			$('#memory').attr("hidden",false);
			$('#hba').attr("hidden",false);
		}else{
			$('#ostype').attr("hidden",true);
			$('#diskinfo').attr("hidden",true);
			$('#memory').attr("hidden",true);
			$('#hba').attr("hidden",true);
		}
			
		$('#showResdg').datagrid({
			url:'/testjsp/getresource?resid='+id,
			toolbar:'#toolbar',
			fit:true,
			pagination:true,
			rownumbers:true,
			fitColumns:true,
			singleSelect:true,
			columns:[[
			          {	field:'resid',title:'设备种类'},
			          { field:'machinetype',title:'设备型号'},
			          {	field:'ip',title:'IP地址'},
			          {	field:'ostype',hidden:fieldshow,title:'操作系统'},
			          {	field:'diskinfo',hidden:fieldshow,title:'硬盘'},
			          {	field:'memory',hidden:fieldshow,title:'内存'},
			          {	field:'hba',hidden:fieldshow,title:'HBA卡'},
			          {	field:'position',title:'设备位置'},
			          {	field:'modeName',title:'所在项目'},
			          {	field:'description',title:'描述信息'},
			          ]]
		});
	
	
		
	});
	
	var url;
	function newRes(id){
		$('#modifydlg').dialog('open').dialog('setTitle','Add Resect');
		 $('#fm').form('clear');
		 $('#dlgResID').combobox('setValue',id);
		 $('#sechba').combobox('setValue','0');
		 $('#dlgMode').combobox('setValue',200);
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
<input id="hideid" type="hidden" value=<%out.print(id);%>>
<table id="showResdg"></table>
<%-- 
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
	</table> --%>
	
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRes(<%out.print(id);%>)">New Res</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRes()">Edit Res</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteRes()">Delete Res</a>
	</div>
	
	<div id="modifydlg" class="easyui-dialog" style="width:500px;height:400px;padding:10px 20px" closed="true" buttons="#modifydlgbtn">
		<div class="ftitle">Resource Information</div>
		<form id="fm" method="post">
			<div class="fitem" >
				<label width="50">设备种类</label>
				<!-- <input name="resid"  class="easyui-validatebox" required="true"> -->
				<input id="dlgResID" name="resid" editable="false"  class="easyui-combobox" data-options="valueField:'resid',textField:'text',url:'/testjsp/getresourceitem'" required="true" >
			</div>
			<div class="fitem">
				<label width="50">设备型号</label>
				<input name="machinetype"  class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label width="50">IP地址</label>
				<input name="ip" rclass="easyui-validatebox" required="true">
			</div>
			<div id="ostype"  class="fitem">
				<label width="50">操作系统</label>
				<!-- <input name="ostype" > -->
				<input name="ostype" editable="false" class="easyui-combobox" data-options="valueField:'label',textField:'value',data:[{label:'SUSE',value:'SUSE'},{label:'Window',value:'Window'},{label:'Unknow',value:'Unknow',selected:true}]" >
			</div>
			<div id="diskinfo" class="fitem">
				<label style="width:100px">硬  盘</label>
				<input name="diskinfo" >
			</div>
			<div id="memory" class="fitem">
				<label width="50">内  存</label>
				<input name="memory" >
			</div>
			<div id="hba" class="fitem">
				<label width="50">HBA卡</label>
				<input id="sechba" name="hba" class="easyui-combobox"  editable="false" data-options="valueField:'label',textField:'value',data:[{label:'0',value:'NO',selected:true},{label:'1',value:'YES'}]" >
			</div>
			<div class="fitem">
				<label width="50">设备位置</label>
				<input name="position" >
			</div>
			<div class="fitem">
				<label width="50">所在项目</label>
				<!-- <input name="mode" > -->
				<input id="dlgMode"  name="mode" class="easyui-combobox" editable="false" data-options="valueField:'resid',textField:'text',url:'/testjsp/getprojmenu'" required="true">
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