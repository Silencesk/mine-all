<#import "../templates/UcPageTpl.ftl" as uc>
<#assign headerTitle = "用户分配角色">

<#assign modulePage="userrole">
<@override name="head-page">
		<@uc.jsHeader />	
		<@uc.style />
</@override>

<#--覆盖重写EydPage里面的body-->
<@override name="body-page">
	<@eydForm.page modulePage>
		<#--布局toolbar为north-->
		<@eydForm.layout_north  split=false border=false style="height:32px">
			<@eydForm.toolbar id="searchFormToolbar">
				<@eydForm.toolbarlist />
			</@eydForm.toolbar>	
		</@eydForm.layout_north>
		<@eydForm.layout_center style="overflow:hidden;">
			<@eydForm.layout >
				<@eydForm.layout_north  id="searchFormPanel" title="查询面板" border=true split=true  style="height:73px">
					<@eydForm.form id="searchForm">
						<#--由继承的模板实现具体的搜索框-->
						<@block name="search-pane">
							<@eydForm.textbox id="roleName" name="roleName" value="" title="角色名称" required="false" labelClass="form-textbox-edit" inputClass="" colSpan=3  labelWidth=100 display="block" readonly="false"   options='' spType="" />
							<@eydForm.combobox id="status" name="status" value="" title="状态" required="false" labelClass="form-textbox-edit" inputClass="" colSpan=3  labelWidth=100 display="block" readonly="false"   options='spType:"in",
									multiple:false,
									valueField:"value",
									textField:"label",
									data:[
										{
											label:"启用",
											value:"1"
										},
										{
											label:"禁用",
											value:"0"
										}
									]
									' spType="" multiple='false' valueField="value" textField="label" data='[]' />
							<@eydForm.textbox id="rightName" name="rightName" value="" title="角色拥有者" required="false" labelClass="form-textbox-edit" inputClass="" colSpan=3  labelWidth=100 display="block" readonly="false"   options='' spType="like" />
						</@block>	
					</@eydForm.form>
				</@eydForm.layout_north>
				
			    <@eydForm.layout_west title="部门" border=true  style="width:20%;min-width:200px;width:180px;">
			    </@eydForm.layout_west>
			    
		        <@eydForm.layout_center border=true>
		        	<@eydForm.layout>
			        	<@eydForm.layout_north title="未分配角色" style="height:50%;">
			        		
			        	</@eydForm.layout_north>
			        	<@eydForm.layout_south title="已分配角色" style="height:50%;">
			        	</@eydForm.layout_south>
		        	</@eydForm.layout>
    			</@eydForm.layout_center>
				
			</@eydForm.layout>
		</@eydForm.layout_center>
	</@eydForm.page >
	
	<#--精灵窗口-->
	<@eydForm.searchWin>
	</@eydForm.searchWin>
</@override>


<@override name="js_footer">
    <@uc.jsInit modulePage /> 
</@override>

<@extends name="/ftl/common/pages/EydSimplePage.ftl"/>