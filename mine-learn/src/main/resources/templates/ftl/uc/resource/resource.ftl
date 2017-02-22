<#------------------单表示例-------------------------------------->

<#--引入UC模板页-->
<#import "../templates/UcPageTpl.ftl" as uc>

<#--页面标题-->
<#assign headerTitle = "resource模块">
<#--模块一定要传且不能和其他模块重复-->
<#assign modulePage="resource">
<#--start: 覆盖重写 父模板 head-page-->
<#--引入 uc JavaScript 头文件-->
<#--引入本页CSS样式-->
<@override name="head-page">
		<@uc.jsHeader />	
		<@uc.style />
		

</@override>
<#--end: 覆盖重写 父模板 head-page-->

<#--start: 覆盖重写 父模板 查询面板区域-->
<@override name="search-pane">
	<#--引入resource-searchForm.ftl文件，该文件存放查询面板中输入框的集合	
		模板命名规则：模块名 加 "-" 加 "searchForm" 加 "-layout.ftl"明确指示是布局文件
		注意：模板不存在就会报错
	-->
	<#include  "resource-searchForm-layout.ftl" >
</@override>
<#--end: 覆盖重写 父模板 查询面板-->


<#--start: 覆盖重写 父模板 网格区域-->
<@override name="grid-pane">
	<@eydForm.layout>
	<@eydForm.layout_center style="overflow:hidden;">
		<#include  "resource-grid-layout.ftl" >	
	</@eydForm.layout_center >
		<@eydForm.layout_south  border=true split=true  style="height:100px">
			<div id="dlRightList">
			</div>	
		</@eydForm.layout_south>
	</@eydForm.layout>
	<#--引入resource-searchForm.ftl文件，该文件存放查询面板中输入框的集合	
		模板命名规则：模块名 加 "-" 加 "grid"
		注意：模板不存在就会报错
	-->
	
</@override>
<#--end: 覆盖重写 父模板 网格区域-->

<#--start: 覆盖重写 父模板 footer-page-->
<#--调用当前页 javascript user.init() 方法进行页面初始化-->
<@override name="js_footer">

    <@uc.jsInit modulePage /> 

</@override>
<#--end: 覆盖重写 父模板 footer-page-->


<#--如果是单表结构的页面   继承统一的EydSingPage模板-->
<#--注意:必须放在模板文件最后, 否则 override 指令不生效-->
<@extends name="/ftl/common/pages/EydSimplePage.ftl"/>