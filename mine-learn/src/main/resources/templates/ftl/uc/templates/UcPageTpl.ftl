<#--uc javascript 头文件-->
<#macro jsHeader>
<!-- mergeTo:uc.min.js -->
<script type="text/javascript" src="/static/js/uc/uc.js"></script>
<script type="text/javascript" src="/static/js/uc/uc-tabs.js"></script>
<script type="text/javascript" src="/static/js/uc/uc-left-tree.js"></script>
<script type="text/javascript" src="/static/js/uc/user.js"></script>
<script type="text/javascript" src="/static/js/uc/bassupplier.js"></script>
<script type="text/javascript" src="/static/js/uc/blpo.js"></script>
<script type="text/javascript" src="/static/js/uc/blpodtl.js"></script>
<script type="text/javascript" src="/static/js/uc/blposubdtl.js"></script>
<script type="text/javascript" src="/static/js/uc/application.js"></script>
<script type="text/javascript" src="/static/js/uc/project.js"></script>
<script type="text/javascript" src="/static/js/uc/rightlist.js"></script>
<script type="text/javascript" src="/static/js/uc/userrole.js"></script>
<script type="text/javascript" src="/static/js/uc/resource.js"></script>
<script type="text/javascript" src="/static/js/uc/versionlog.js"></script>
<!-- mergeTo -->
</#macro>

<#--指定模块进行初始化-->
<#macro jsInit module>
<script type="text/javascript">	
	(function($) {
		//重写jquery easyui的 onComplete方法，该方法在页面加载完jquery easyui控件后触发 
		$.extend($.parser,{
			onComplete:function(_1){
				//页面完成编译easyui控件后触发这个onComplete方法，
				//重写这个方法，当_1 为空或者id为'billDateilWin'时候才触发页面初始化方法
				if(typeof _1 == 'undefined' || _1.attr('id') == 'billDateilWin'){
					$.eyd.uc.${module}.init();
				}
			}
		});
    })(jQuery);
</script>
</#macro >

<#macro style>
<style>
    img,div
    {
        padding: 0em;
        margin: 0em;
        border: 0em;
    }

    .tree-title {
        font-size: 14px;
    }

    .tree-title a {
        text-decoration: none;
    }

    .index-toolbar {
        padding: 0em 0.5em;
    }

    .index-title {
        font-size: 1.3em;
        padding: 10px;
    }

    #index-logo {
        height: 45px;
    }

	#navbar{
		line-height: 50px;
	}
</style>
</#macro >
