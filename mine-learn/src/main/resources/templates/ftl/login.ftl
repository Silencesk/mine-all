<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <title>登录认证中心</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link type="text/css" rel="stylesheet" href="/static/cas/css/login.css"/>
</head>
<body class="blf1-body">
<div id="cas">
    <div id="content" class="container">
        <div class="blf1-login">
            <h1 class="logo">Belle 百丽生产管理系统</h1>
            <form id="fm1" class="form-horizontal" action="login" method="post">
                <div class="form-group username">
                    <input id="username" name="username" class="form-control" tabindex="1" placeholder="用户名"
                           type="text" value="admin" maxlength="30" autocomplete="false"/>
                </div>

                <div class="form-group password">
                    <input id="password" name="password" class="form-control" tabindex="2" placeholder="密码"
                           type="password" value="123456" size="25" maxlength="30" autocomplete="off"/>
                </div>

                <div class="form-group">
                    <button type="submit" id="btn_login" class="btn-login" tabindex="4">登录</button>
                </div>
                <div>
                </div>
            </form>
        </div>
        <div class="blf1-banner"></div>
        <p class="copyright">Copyright &copy; 2016 云盛海宏信息技术（深圳）有限公司</p>
    </div>
</div>
</body>
</html>