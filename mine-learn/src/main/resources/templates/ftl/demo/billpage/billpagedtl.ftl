<#------------------单据详情从表示例-------------------------------------->

<#--引入UC模板页-->
<#import "../templates/DemoPageTpl.ftl" as uc>

<#--页面标题-->
<#assign headerTitle = "单据详情从表demo模块">
<#--模块一定要传且不能和其他模块重复-->
<#assign modulePage="billpagedtl">
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
	<#--引入user-searchForm.ftl文件，该文件存放查询面板中输入框的集合	
		模板命名规则：模块名 加 "-" 加 "searchForm" 加 "-layout.ftl"明确指示是布局文件
		注意：模板不存在就会报错
	-->
	<#include  "billpagedtl-editForm-layout.ftl" >
</@override>
<#--end: 覆盖重写 父模板 查询面板-->


<#--start: 覆盖重写 父模板 网格区域-->
<@override name="grid-pane">
	<#--引入user-searchForm.ftl文件，该文件存放查询面板中输入框的集合	
		模板命名规则：模块名 加 "-" 加 "grid"
		注意：模板不存在就会报错
	-->
	<#include  "billpagedtl-detailGrid-layout.ftl" >
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
<@extends name="/ftl/common/pages/EydBillDetailPage.ftl"/>