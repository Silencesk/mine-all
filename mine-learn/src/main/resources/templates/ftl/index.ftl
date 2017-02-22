<#--主页模板-->

<#--引入UC模板页-->
<#import "uc/templates/UcPageTpl.ftl" as uc>

<#--页面标题-->
<#assign headerTitle = "信息管理系统 v0.1">

<#--声明<body>的class, 变量在父模板使用-->
<#--表示为 easyui layout-->
<#assign bodyClassName = "easyui-layout">

<#--start: 覆盖重写 父模板 head-page-->
<#--引入 uc JavaScript 头文件-->
<#--引入本页CSS样式-->
<@override name="head-page">
    <@uc.jsHeader/>
    <@uc.style/>
</@override>
<#--end: 覆盖重写 父模板 head-page-->


<#--start: 覆盖重写 父模板 footer-page-->
<#--调用当前页 javascript index.init() 方法进行页面初始化-->
<@override name="js_footer">
    <@uc.jsInit "index"/>
</@override>
<#--end: 覆盖重写 父模板 footer-page-->


<#--start: 覆盖重写 父模板 body-page-->
<@override name="body-page">

    <@eydForm.layout_north class="header" split=false border=true style="height:70px;font-size:100%">
    <#--页面顶部导航 左边页面-->
    <div class="content">
        <@index_north_left/>
        <@index_north_right/>
        <div style="clear:both"></div>
    </div>
    </@eydForm.layout_north>

<#--菜单树-->
<#--引入左边导航区域-->
    <@eydForm.layout_west title="系统菜单" border=true  style="width:20%;min-width:200px;width:180px;">

        <@index_left/>

    </@eydForm.layout_west>

<#--模块显示区域-->
    <@eydForm.layout_center border=true>

        <@eydForm.tabs id="tabsIndex" >
            <@eydForm.tab id="index_tab" title="首页" href="welcome" class="content-doc"/>
        </@eydForm.tabs>

    </@eydForm.layout_center>
</@override>
<#--end: 覆盖重写 父模板 body-page-->

<#--继承统一的基础模板-->
<#--注意:必须放在模板文件最后, 否则 override 指令不生效-->
<@extends name="/ftl/common/pages/EydPage.ftl"/>


<#--===================== This Page Macro define =====================-->

<#--顶部-工具条-左边部分-->
<#macro index_north_left>
<div class="index-toolbar eyd-layout-left">
    <div class="eyd-layout-left"><img id="index-logo" src="/static/images/index_logo.png"></div>
    <div class="index-title eyd-layout-left">供应商协同管理系统</div>
</div>
</#macro>

<#--顶部-工具条-右边部分-->
<#macro index_north_right>
<div id="navbar" class="index-toolbar eyd-layout-right">

    <#assign toolbarText >
        [
        {'caption':'开发者','icon':'fa-user','id':'btnUser'},
        {"caption":"我的分组","icon":"fa-group",'id':"btnUserGroup"},
        
        {'caption':'我的消息','icon':'fa-envelope','id':"btnMyMsg"},
        {'caption':'帮助','icon':'fa-home','id':"btnHelpe"},
        {'caption':'设置','icon':'fa-gear','id':"btnSeting",
        	'menu':"[{'caption':'修改密码','id':'btnChangePwd','icon':'fa-gear'}]"
        },
        {'caption':'注销','icon':'fa-power-off','id':"btnLoginOut"}
        ]
    </#assign>
<#--字符串转换为json对象-->
    <#assign toolbar = toolbarText?eval>

    <#list toolbar as item>
    	<#if item.menu?exists>
    		<#assign menu=item.menu>
    	<#else>
    		<#assign menu='[]'>
    	</#if>
    	
        <@eydForm.button menu="${menu}" caption="${item.caption}" id="${item.id}" icon = "${item.icon} fa-lg" iconAlign = "left"/>
    </#list>
</div>
</#macro>

<#--侧边（左/右边）菜单导航区域-->
<#macro index_left>
    <@eydForm.layout >
    <#--导航树过滤条件-->
        <@eydForm.layout_north >
        	<div class="bl-col-12">
        	<@eydForm.search id="menuSearch" style="width:100%" prompt="请输入模块编号或名称查询!"/>
        	</div>
            
        </@eydForm.layout_north>
    <#--导航树-->
        <@eydForm.layout_center border=false>
            <@eydForm.tree "naviTree"/>
        </@eydForm.layout_center>


    </@eydForm.layout>
</#macro>