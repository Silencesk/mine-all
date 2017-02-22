Ext.define("Belle_mdm.Application",{extend:"Ext.app.Application",name:"Belle_mdm",
requires:["Belle_mdm.view.basaccountperiod.BasAccountPeriod","xxxxxxxxxxx"],
appFolder:"resources/app",
init:function(){var a=this;a.setDefaultToken("bascustomer")});
Ext.setGlyphFontFamily("FontAwesome");
Ext.QuickTips.init()},launch:function(){}});
Ext.define("Belle_mdm.model.BasAccountPeriod",{
	extend:"Ext.data.Model",
	alias:"model.basaccountperiod",
	requires:["Belle_mdm.view.basaccountperiod.BasAccountPeriod","yyyyyyyyyyyyy"],
	{name:"remarks",text:"备注",type:"string"}]});
