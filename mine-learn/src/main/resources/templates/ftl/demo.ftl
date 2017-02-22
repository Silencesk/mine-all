<#--demo模板-->
<#--引入UC模板页-->
<#import "uc/templates/UcPageTpl.ftl" as uc>
<#assign headerTitle = "基础组件demo">
<#--start: 覆盖重写 父模板 head-page-->
<#--引入 uc JavaScript 头文件-->
<#--引入本页CSS样式-->
<@override name="head-page">

    <@uc.jsHeader/>
    <@uc.style/>
<link rel="stylesheet" type="text/css" href="/static/cas/css/easyUI.css">
<style type='text/css'>
.widthClass{
	width:100%;
}
</style>
</@override>
<#--end: 覆盖重写 父模板 head-page-->
<#--覆盖重写 父模板 body-page-->
<@override name="body-page">

<div id="tt" class="easyui-tabs" style="width:500px;height:250px;">
    <div  style="padding:20px;display:none;">
		tab1
    </div>
</div>



<#--引入基础元素的宏模板-->
<#include "/ftl/common/templates/EydFormTpl.ftl">
<#include "/ftl/common/templates/elements/EydElementsTpl.ftl">
<@combobox id='id4' name='name4'   title='带label下拉框'     labelWidth=150 display='block' readonly='false'   options="prompt:'请选择',multiple:true,valueField:'value',textField:'label',data:[{label: 'java',value: 'Java'},{label: 'perl',value: 'Perl'},{label: 'ruby',value: 'Ruby'}]"/>


<@baseinput  id="textboxid3" name="textboxname" type='textbox' value='' options="prompt:'普通文本框'" />
<@baseinput  id="numberboxid" name="numberboxname" type='numberbox' value='' options="prompt:'数值文本框'" />
<@baseinput  id="dateboxid" name="dateboxname" type='datebox' value='' options="prompt:'时间文本框'" />
<@baseinput  id="comboboxid" name="comboboxname" type='combobox' value='' options="prompt:'下拉框'" />
<@baseinput  id="searchboxid" name="searchboxname" type='searchbox' value='' options="prompt:'搜索文本框'" />
<br/>
<@baseinputbox id='id1' name='name1'  type='textbox'  title='带label普通文本框'    labelWidth=150 display='block' readonly='true'   options="prompt:'普通文本框'"/>
<@baseinputbox id='id2' name='name2'  type='numberbox'  title='带label数值文本框'    labelWidth=150 display='block' readonly='false'   options="prompt:'请输入数值'"/>
<@baseinputbox id='id3' name='name3'  type='datebox'  title='带label时间文本框' labelClass='-1'    labelWidth=150 display='block' readonly='false'   options="prompt:'请选择时间'"/>
<@baseinputbox id='id4' name='name4'  type='combobox' title='带label下拉框'     labelWidth=150 display='block' readonly='false'   options="prompt:'请选择'"/>
<@baseinputbox id='id5' name='name5'  type='searchbox' title='带label搜索文本框' labelWidth=150    readonly='true'   options="prompt:'请输入'"/>

<br/><br/><br/>

按钮demo
<@buttonbox id="b1" options="iconCls:'icon-edit',text:'按钮'"  />
<@buttonbox id="b2" type="menubutton" value="菜单按钮" options="iconCls:'icon-edit'"  />
<@buttonbox id="b3" type="splitbutton" value="分割按钮"   />
<br/>form 表单
<@formbox id="b4" searchItems=[{
    					"xtype":"textbox",
						"title":"单据编号",
						"name":"billNo"
    				},{
    					"xtype":"textbox",
						"title":"单据编号2",
						"name":"billNo"
    				}, {
    					"id":"storeCombo",
    					"xtype":"combobox",
						"title":"仓库",
						"name":"storeNo",
						"valueField":"storeNo",
						"textField":"storeName"
    				},{
    					"xtype":"datebox",
						"title":"创建时间",
						"name":"createTime1",
						"map":"createTime",
						"spType":"lte"
					},{    				
    					"xtype":"searchbox",
						"title":"供应商",
						"disabled":"true",
						"name":"supplierNo",
						"showWin" : "true",
						"winConfing" : {
							"returnValues" : [ {"field":"appId","map":"id"}, "appName" ],
							"type":"limitSupplier"
						},
						"spType":"in"
    				}]   />

<br/><br/><br/><br/><br/><br/><br/><br/><br/>

<@textbox  id='textbox' name='textbox'   title='' options=''  />


<@textbox id='id1' name='name1'    title='带label普通文本框'    labelWidth=150 display='block' readonly='true'   options="prompt:'普通文本框'"/>
<@numberbox id='id2' name='name2'    title='带label数值文本框'    labelWidth=150 display='block' readonly='false'   options="prompt:'请输入数值'"/>
<@datebox id='id3' name='name3'    title='带label时间文本框' labelClass='-1'    labelWidth=150 display='block' readonly='false'   options="prompt:'请选择时间'"/>
<@combobox id='id4' name='name4'   title='带label下拉框'     labelWidth=150 display='block' readonly='false'   options="prompt:'请选择'"/>
<@searchbox id='id5' name='name5'  title='带label搜索文本框' labelWidth=150    readonly='true'   options="prompt:'请输入'"/>
<@linkbuttonbox id="b1" options="iconCls:'icon-edit',text:'按钮'"  />
<@menubuttonbox id="b2" value="菜单按钮" options="iconCls:'icon-edit'"  />
textbox
searchbox
combobox
datebox

<@numberbox  id='' name=''   value=''   title=''  
	labelClass='form-textbox-edit' inputClass='' colSpan=3 
	labelWidth=100 display='block' readonly='false'   
	options=''  />

<@datebox  id='' name=''   value=''   title=''  
	labelClass='form-textbox-edit' inputClass='' colSpan=3 
	labelWidth=100 display='block' readonly='false'   
	options=''  />

<@combobox  id='' name=''   value=''   title=''  
	labelClass='form-textbox-edit' inputClass='' colSpan=3 
	labelWidth=100 display='block' readonly='false'   
	options=''  />
	
<@searchbox  id='' name=''   value=''   title=''  
	labelClass='form-textbox-edit' inputClass='' colSpan=3 
	labelWidth=100 display='block' readonly='false'   
	options=''  />

<br/><br/><br/>
<br/><br/><br/><br/>
-----------------------------------------------------<br/>








<#--文本输入框
options：
	disabled:true/false 禁止输入
	value:''  //值
	prompt:'' //提示信息
	validType：'' //验证类型 email
	multiline:true/false //多行文本
	iconWidth: 22,//图标的宽度
	iconAlign:'' //图标的位置  left\right
	iconCls:''//图标
	icons: [{  //图标和绑定事件组合
				iconCls:'icon-add',  //图标
				handler: function(e){
					$(e.data.target).textbox('setValue', 'Something added!');
				}
			},{
				iconCls:'icon-remove',
				handler: function(e){
					$(e.data.target).textbox('clear');
				}
			}]
	buttonText:'Search', //按钮显示的内容
	buttonIcon:'icon-search'//按钮的图标		
attrs:
	style="width:100%;height:40px;padding:12px" //自定义样式
	disabled=true value='fff' readonly=true 
	size=10  显示10个字符的宽度
events:
	"keyup":"function(e){alert(9)}"  //绑定了键盘事件		
-->
文本输入框示例
<@textinput id="textboxid" name="textboxname" attrs="size=10" options="value:'fff',buttonText:'Search',prompt:'普通文本框'" events={"keyup":"function(e){alert(9)}","click":"function(e){alert(9)}"} />
<br/>
<#--数值输入框
options：
	prompt:'' //提示信息
	disabled	boolean	定义是否禁用该字段。	false
	value	number	默认值。	
	min	number	允许的最小值。	null
	max	number	允许的最大值。	null
	precision	number	显示在小数点后面的最大精度。	0
	decimalSeparator	string	分隔数字的整数部分和小数部分的分隔字符。	.
	groupSeparator	string	分隔整数组合的字符。	
	prefix	string	前缀字符串。	
	suffix	string	后缀字符串。	
	filter	function(e)	定义如何过滤被按下的键，返回 true 则接受输入字符。该属性自版本 1.3.3 起可用。	
	formatter	function(value)	用来格式数字框（numberbox）值的函数。返回显示在框中的字符串值。	
	parser	function(s)	用来解析字符串的函数。返回数字框（numberbox）值。	
	showIncrement true  用来显示微调器	
	increment:10  微调器每次增加或减少的数量		
attrs:
	style="width:100%;height:40px;padding:12px" //自定义样式
	disabled=true value='fff' readonly=true 
	size=10  显示10个字符的宽度
events:
	"keyup":"function(e){alert(9)}"  //绑定了键盘事件		
-->
数值输入框demo
<@numberinput id="numberboxid" name="textboxname" attrs="title='title'" options="showIncrement:'true',prompt:'数字输入框',increment:10,precision:2,min:0"   />
<br/>
<#--日期输入框
options：
	prompt:'' //提示信息
	disabled	boolean	定义是否禁用该字段。	false
	value	number	默认值。	
	panelWidth	number	下拉日历面板的宽度。	180
	panelHeight	number	下拉日历面板的高度。	auto
	currentText	string	当前日期按钮上显示的文本。	Today
	closeText	string	关闭按钮上显示的文本。	Close
	okText	string	确定按钮上显示的文本。	Ok
	disabled	boolean	设置为 true 时禁用该域。	false
	buttons	array	日历下面的按钮。该属性自版本 1.3.5 起可用。
		代码实例：var buttons = $.extend([], $.fn.datebox.defaults.buttons);buttons.splice(1, 0, {text: 'MyBtn',handler: function(target){alert('click MyBtn');}});
		$('#dd').datebox({buttons: buttons});
	sharedCalendar	string,selector	多个日期框（datebox）组件使用的共享日历。该属性自版本 1.3.5 起可用。
		代码实例：
		<input class="easyui-datebox" sharedCalendar="#sc">
		<input class="easyui-datebox" sharedCalendar="#sc">
	<div id="sc" class="easyui-calendar"></div>
	formatter	function	格式化日期的函数，该函数有一个 'date' 参数，并返回一个字符串值。
	parser	function	解析日期字符串的函数，该函数有一个 'date' 字符串，并返回一个日期值。
	showSeconds:'true' 	显示时分秒
	timeSeparator	string	时分秒之间的时间分隔符。该属性自版本 1.3 起可用。
attrs:
	style="width:100%;height:40px;padding:12px" //自定义样式
	disabled=true value='fff' readonly=true value='2016-08-09 08:04'
	size=10  显示10个字符的宽度
events:
	"keyup":"function(e){alert(9)}"  //绑定了键盘事件		
-->
日期输入框demo
<@timeinput id="timeboxid" name="timeboxname" attrs="forNum='aaaa' value='2016-08-09 08:04'" options="showSeconds:'true'"  />
<@timeinput id="timeboxid" name="timeboxname" attrs="fjoin='aaaa'" options="prompt:'ff'"  />
<br/>

<#--按钮
options：
	disabled	boolean	定义是否禁用。	false
	id	string	该组件的 id 属性。	null
	disabled	boolean	如果设置为 true，则禁用按钮。	false
	toggle	boolean	如果设置为 true，则允许用户切换按钮的选中状态。该属性自版本 1.3.3 起可用。	false
	selected	boolean	定义按钮状态是否已选择。该属性自版本 1.3.3 起可用。	false
	group	string	指示按钮所属的分组名称。该属性自版本 1.3.3 起可用。	null
	plain	boolean	如果设置为 true，则显示一个简单的效果。	false
	text	string	按钮文本。	''
	iconCls	string	在左边显示一个 16x16 图标的 CSS class。	null
	iconAlign	string	按钮图标的位置。可能的值：'left'、'right'。该属性自版本 1.3.2 起可用。	left
	type:'linkbutton' 按钮的类型   可能的值：'linkbutton'、'menubutton'，‘splitbutton’
	plain	boolean	如果设置为 true，则显示一个简单的效果。	  menubutton、splitbutton 的属性
	menu	string	用于创建对应菜单（menu）的选择器。	 menubutton、splitbutton 的属性
	duration	number	当悬停在按钮上时，以毫秒为单位定义的，显示菜单（menu）的持续时间。	menubutton、splitbutton 的属性
attrs:
	style="width:100%;height:40px;padding:12px" //自定义样式
	disabled=true value='2016-08-09 08:04'
events:
	"click":"function(e){alert(9)}"  //绑定了键盘事件
-->
<div id="mm" style="width:150px;">
    <div data-options="iconCls:'icon-undo'">Undo</div>
    <div data-options="iconCls:'icon-redo'">Redo</div>
    <div class="menu-sep"></div>
    <div>Cut</div>
    <div>Copy</div>
    <div>Paste</div>
    <div class="menu-sep"></div>
    <div data-options="iconCls:'icon-remove'">Delete</div>
    <div>Select All</div>
</div>
按钮demo
<@buttonbox1 id="buttonboxid1" name="buttonboxname" attrs="classq='spinner'" options="type:'linkbutton',iconCls:'icon-edit',text:'按钮'" events={"click":'function(){alert(4)}'} />
<@buttonbox1 id="buttonboxid2" name="buttonboxname" attrs="classq='spinner'" options="type:'menubutton',iconCls:'icon-edit',menu:'#mm',text:'test'" events={"click":'function(){alert(4)}'} />
<br/>
<#--下拉框
options：
	prompt:'' //提示信息
	width	number	组件的宽度。	auto
	height	number	组件的高度。该属性自版本 1.3.2 起可用。	22
	panelWidth	number	下拉面板的宽度。	null
	panelHeight	number	下拉面板的高度。	200
	multiple	boolean	定义是否支持多选。	false
	selectOnNavigation	boolean	定义当通过键盘导航项目时是否选择项目。该属性自版本 1.3.3 起可用。	true
	separator	string	多选时文本的分隔符。	,
	editable	boolean	定义用户是否可以往文本域中直接输入文字。	true
	disabled	boolean	定义是否禁用文本域。	false
	readonly	boolean	定义组件是否只读。该属性自版本 1.3.3 起可用。	false
	hasDownArrow	boolean	定义是否显示向下箭头的按钮。	true
	value	string	默认值。	
	delay	number	从最后一个键的输入事件起，延迟进行搜索。	200
	keyHandler	object	当用户按键后调用的函数。默认的 keyHandler 定义如下：keyHandler: {up: function(){},down: function(){},enter: function(){},query: function(q){}}
	valueField	string	绑定到该组合框（ComboBox）的 value 上的基础数据的名称。	value
	textField	string	绑定到该组合框（ComboBox）的 text 上的基础数据的名称。	text
	groupField	string	指示要被分组的字段。该属性自版本 1.3.4 起可用。	null
	groupFormatter	function(group)	返回要显示在分组项目上的分组文本。该属性自版本 1.3.4 起可用。
	mode	string	定义在文本改变时如何加载列表数据。如果组合框（combobox）从服务器加载就设置为 'remote'。当设置为 'remote' 模式时，用户输入的值将会被作为名为 'q' 的 http 请求参数发送到服务器，以获取新的数据。	local
	url	string	从远程加载列表数据的 URL 。	null
	method	string	用来检索数据的 http 方法。	post
	data	array	被加载的列表数据。data:[{"id":'id',"text":"text"}
	filter	function	定义当 'mode' 设置为 'local' 时如何过滤本地数据。该函数有两个参数：
	formatter	function	定义如何呈现行。该函数有一个参数：row。
	loader	function(param,success,error)	定义如何从远程服务器加载数据。返回 false 则取消该动作。该函数有下列参数：
	param：要传到远程服务器的参数对象。
	success(data)：当获取数据成功时将被调用的回调函数。
	error()：当获取数据失败时将被调用的回调函数。
	json loader
	loadFilter	function(data)	返回要显示的过滤数据。该属性自版本 1.3.3 起可用。
attrs:
	style="width:100%;height:40px;padding:12px" //自定义样式
	disabled=true value='fff' readonly=true value='2016-08-09 08:04'
	size=10  显示10个字符的宽度
events:
	"click":"function(e){alert(9)}"  //绑定了事件		
-->
下拉框demo
<@downdropinput id="downdropid" name="downdropname" attrs="classq='spinner'" options="onChange:function(v,b){alert(0)},editable:false,multiple:true,valueField:'value',textField:'label',data:[{label: 'java',value: 'Java'},{label: 'perl',value: 'Perl'},{label: 'ruby',value: 'Ruby'}]" events={"click":'function(){alert(4)}'} />

<br/>
<#--搜索框
options：
	prompt:'' //提示信息
	width	number	组件的宽度。	auto
	height	number	组件的高度。该属性自版本 1.3.2 起可用。	22
	prompt	string	显示在输入框里的提示信息。	''
	value	string	输入的值。	''
	menu	selector	搜索类型的菜单。每个菜单项可以有下列的属性：name：搜索类型名称。selected：当前选择的搜索类型名称。
	searcher	function(value,name)	当用户按下搜索按钮或者按下 ENTER 键时，searcher 函数将被调用。
attrs:
	style="width:100%;height:40px;padding:12px" //自定义样式
	disabled=true value='fff' readonly=true value='2016-08-09 08:04'
	size=10  显示10个字符的宽度
events:
	"click":"function(e){alert(9)}"  //绑定了事件		
-->
搜索框demo
<@searchinput id="searchboxid" name="searchboxname" attrs="classq='spinner'" options="prompt:'ssa',searcher:function(v,b){alert(0)}" events={} />
<br/>
<#--文本框
options：{
	disabled:true/false 禁止输入
	value:''  //值
	prompt:'' //提示信息
	validType：'' //验证类型 email
	multiline:true/false //多行文本
	iconWidth: 22,//图标的宽度
	iconAlign:'' //图标的位置  left\right
	iconCls:''//图标
	icons: [{  //图标和绑定事件组合
				iconCls:'icon-add',  //图标
				handler: function(e){
					$(e.data.target).textbox('setValue', 'Something added!');
				}
			},{
				iconCls:'icon-remove',
				handler: function(e){
					$(e.data.target).textbox('clear');
				}
			}]
	buttonText:'Search', //按钮显示的内容
	buttonIcon:'icon-search'//按钮的图标	
	}	
attrs:
	{'id':'fffffff','xtype':'textbox','title':'单据编号','name':'billNo','readonly':'true','disabled':'true'}
events:
	"keyup":"function(e){alert(9)}"  //绑定了键盘事件		
-->
文本框示例<br/>
<@textbox1 id="textboxid2"  attrs="{'xtype':'textbox','disabled':'true','title':'单据编号}','name':'billNo'}" options="{value:'fff',prompt:'普通文本框'}" events={"keyup":"function(e){alert(9)}"} />

<br/><br/>数字框示例<br/>
<@numberbox1 id="numberboxid2"  attrs="{'xtype':'numberbox','title':'{数字框','name':'billNo'}" options="{showIncrement:'true',prompt:'数字输入框',increment:10,precision:2,min:0}" events={"keyup":"function(e){alert(9)}"} />

<br/><br/>日期输入框demo<br/>
<@timebox1 id="timeboxid2" attrs="{'xtype':'numberbox','title':'日期输入框','name':'billNo'}" options="{showSeconds:'true'}"  />
<br/><br/>
<@downdropbox1 id="downdropid2" attrs="{'xtype':'combobox','title':'下拉框','name':'billNo'}" options="{onChange:function(v,b){alert(0)},editable:false,multiple:true,valueField:'value',textField:'label',data:[{label: 'java',value: 'Java'},{label: 'perl',value: 'Perl'},{label: 'ruby',value: 'Ruby'}]}" events={"click":'function(){alert(4)}'} />
<br/><br/>
<@searchbox1 id="searchboxid2" attrs="{'xtype':'searchbox','title':'精灵搜索框','name':'billNo'}" options="{prompt:'ssa',searcher:function(v,b){alert(0)}}" events={} />



<br/><br/><br/><br/>
form表单
<@form id="formid" searchItems=[{
    					"xtype":"textbox",
						"title":"单据编号",
						"name":"billNo"
    				},{
    					"xtype":"textbox",
						"title":"单据编号2",
						"name":"billNo"
    				}, {
    					"id":"storeCombo",
    					"xtype":"combobox",
						"title":"仓库",
						"name":"storeNo",
						"valueField":"storeNo",
						"textField":"storeName"
    				},{
    					"xtype":"datebox",
						"title":"到",
						"titleColWidth":4,
						"name":"createTime1",
						"map":"createTime",
						"spType":"lte"
					},{    				
    					"xtype":"searchbox",
						"title":"供应商",
						"disabled":"true",
						"titleColWidth":4,
						"name":"supplierNo",
						"showWin" : "true",
						"winConfing" : {
							"returnValues" : [ {"field":"appId","map":"id"}, "appName" ],
							"type":"limitSupplier"
						},
						"spType":"in"
    				}] />
<br/>



</@override>
<#--继承统一的基础模板-->
<#--注意:必须放在模板文件最后, 否则override 指令不生效-->
<@extends name="/ftl/common/pages/EydPage.ftl"/>

