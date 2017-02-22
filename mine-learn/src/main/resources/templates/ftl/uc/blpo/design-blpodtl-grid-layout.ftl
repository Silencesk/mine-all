
	<@eydForm.tabs>
		<@eydForm.tab id=""  title="grid网格" href="" class="">
			<@eydForm.grid  id= "Grid1" index= "1" gridCount= "2" defaultLoad= "true" columns= '[[{"field":"userCode","width":200,"sortable":true,"title":"用户"},{"editor":{"options":{"required":true},"type":"datebox"},"field":"createTime","width":200,"sortable":true,"title":"创建时间","filterConfig":{"data":[{"id":"true","text":"是"}],"filterOperator":"equal","type":"combobox","valueField":"id","textField":"text"}}]]' data='[]' loadUrl= "/user/find.json" pagination="true" queryParams= '{}' options="" moduleName= "blpodtl" localhost="" saveUrl= "user/hs.json" exportUrl="" subGrids='[]' idName= "userCode" />
		</@eydForm.tab>		
		<@eydForm.tab id=""  title="grid网格2" href="" class="">
			<@eydForm.grid  id= "Grid2" index= "2" gridCount= "2" defaultLoad= "true" columns= '[[{"field":"userCode","width":200,"sortable":true,"title":"用户"},{"editor":{"options":{"required":true},"type":"datebox"},"field":"modifyTime","width":200,"sortable":true,"title":"修改时间","filterConfig":{"data":[{"id":"true","text":"是"}],"filterOperator":"equal","type":"combobox","valueField":"id","textField":"text"}}]]' data='[]' loadUrl= "/user/find.json" pagination="true" queryParams= '{}' options="" moduleName= "blpodtl2" localhost="" saveUrl= "user/hs.json" exportUrl="" subGrids='[]' idName= "userCode" />
		</@eydForm.tab>		
	</@eydForm.tabs>
	
	
	

	

	
	
	
