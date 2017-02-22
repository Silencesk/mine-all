
	<@eydForm.tabs>
		<@eydForm.tab  title="编辑" >
			<@eydForm.form id="id2">
				<@eydForm.textbox  name="admin" value="" title= "是否管理员" required= "false" labelClass="form-textbox-edit" inputClass="" colSpan=3  labelWidth=100 display="block" readonly= "false"   options="" />
				<@eydForm.textbox  name="email" value="" title= "邮箱" required= "false" labelClass="form-textbox-edit" inputClass="" colSpan=3  labelWidth=100 display="block" readonly= "false"   options="" />
				<@eydForm.textbox  name="userCode" value="" title= "供应商" required= "false" labelClass="form-textbox-edit" inputClass="" colSpan=3  labelWidth=100 display="block" readonly= "false"   options="" />
			</@eydForm.form>
		</@eydForm.tab>
		<@eydForm.tab id=""  title="grid网格" href="" class="">
			<@eydForm.grid  id= "Grid2" index= "2" gridCount= "3" defaultLoad= "true" columns= '[[{"editor":{"options":{"required":true},"type":"datebox"},"field":"admin","width":200,"sortable":true,"title":"是否管理员","filterConfig":{"data":[{"id":"true","text":"是"}],"filterOperator":"equal","type":"combobox","valueField":"id","textField":"text"}}]]' data='[]' loadUrl= "/user/find.json" pagination="true" queryParams= '{}' options="" moduleName= "模块名称22" localhost="" saveUrl= "user/hs.json" exportUrl=""  />
		</@eydForm.tab>			
	</@eydForm.tabs>
	
	
	

	

	
	
	
