<#--登录模板-->

<#assign headerTitle = "welcome">

<#--覆盖重写 父模板 body-page-->
<@override name="body-page">



</@override>

<#--继承统一的基础模板-->
<#--注意:必须放在模板文件最后, 否则override 指令不生效-->
<@extends name="/ftl/common/pages/EydPage.ftl"/>