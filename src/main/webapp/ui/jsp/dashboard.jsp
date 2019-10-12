<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
.footer {
  
  left: 0;
  bottom: 0;
  width: 100%;
  background: #4F4D4C;
  color: white;
  text-align: center;
}
.header {
  padding: 20px;
  text-align: center;
  background: #4F4D4C;
  color: white;
  font-size: 30px;
}
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}


.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
</style>

<head>
    <title>Survey Shrike Survey</title>
    <link href="/bootstrap.min.css" rel="stylesheet">
    <script src="/jquery-2.2.1.min.js"></script>
    <script src="/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular.min.js"></script>
     
</head>
<body>
  
<div class="header">
  <h1>Survey Shrike Form Creation</h1>
  
</div>
<div>
            <form action="/logout" method="post">
                <button type="submit" class="btn btn-danger" style='float: right;'>Log Out</button>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>
        </div>
        <br/>
        
    <label id="formSet">List Of Forms Available</label>
   <div id="allForms" style="border: 1px solid green;"><b></b></div>
   
   <br/><br/><br/>
   <label id="formName">Enter the Name of the form</label>
   <div class="col-sm-03">
   <input type="text" class="form-control" id="queryId"><br/>
   <div class=tabs>
   <button type="button" class="btn btn-success" onclick="displayTheForm()" class="form-control">Display The Form</button>
   &nbsp; &nbsp; &nbsp;
   <button type="button" class="btn btn-success" onclick="createTheForm()" class="form-control">Create The Form</button>
   </div>
   </div>
   
   <br/><b><label id="randomMessage">Your Form Is Here</label></b><br/>
   
   <div class="col-md-8" id="resultantForm" style="border: 1px solid green;"><b></b></div>
   <div class="col-md-8" id="createForm" ><b></b>
   <button type="button" class="btn btn-success" onclick="createTextBox()" class="form-control">Create TextBox</button>
   <button type="button" class="btn btn-success" onclick="createTextArea()" class="form-control">Create TextArea</button>
   <button type="button" class="btn btn-success" onclick="createUploadButton()" class="form-control">Create Upload Button</button>
  <button type="button" class="btn btn-success" onclick="saveTheForm()" class="form-control">Save The Form</button>
  
  <input type="text" class="form-control" id="formNameId" placeholder="Name of form to save">
  </div>
  
  
  <div class="col-md-8" id="createdForm" style="border: 1px solid green;"><b></b>
     
  </div> 
  
   
   
   </br>
   
 
<script>

	window.onload = function() {
		var url = "http://localhost:8080/form/displayAllForms";
		document.getElementById("createForm").style.display="none";
		document.getElementById("formNameId").style.display="none";
		
		$.get(url, function(data, status) {
			// alert(data.formId);
			var str="";
			for ( var i = 0; i < data.length; i++) {
				
				str+='<b>'+data[i].formName+'</b><br/>'
				
			}
			document.getElementById("allForms").innerHTML=str;
			
		});
	};
	function saveTheForm () {
		
		if(typeof document.getElementById("formNameId")!=undefined && document.getElementById("formNameId").value!=null && document.getElementById("formNameId").value!="")
		{var str="Name_"+document.getElementById("formNameId").value+";";
		
		for(var i=1;;i++)
			{
			var id="t"+i;
			if(typeof document.getElementById(id) != undefined && document.getElementById(id)!=null){
			var val=document.getElementById(id).value;
			
			str+="TB_"+val+";";
			}
			
			else 
				break;
			
			}
		for(var i=1;;i++){
			var id="ta"+i;
			
			if(typeof document.getElementById(id)!= undefined && document.getElementById(id)!=null){
			var val=document.getElementById(id).value;		
			str+="TA_"+val+";";
			}
			else
				break;
		}
		for(var i=1;;i++){
			var id="bt"+i;
			
			if(typeof document.getElementById(id)!= undefined && document.getElementById(id)!=null){
				var val=document.getElementById(id).value;
				str+="BT_"+val+";";

			}else
					break;
		}
		
		
		var url="http://localhost:8080/form/saveForm?url="+str;
		
		$.get(url,function(data, status) {
					 alert("Form Saved SucessFully");
					
				});
		
		$.get("http://localhost:8080/form/displayAllForms", function(data, status) {
			// alert(data.formId);
			var str="";
			for ( var i = 0; i < data.length; i++) {
				
				str+='<b>'+data[i].formName+'</b><br/>'
				
			}
			document.getElementById("allForms").innerHTML=str;
			
		});
		
		
		
		
		
		
		
		}
		else
			{
			alert("Form Name is mandatory");
			}
	}
	var bid=0
	function createUploadButton() {
		document.getElementById("createForm").style.display="block";
		document.getElementById("randomMessage").style.display="none";
		document.getElementById("resultantForm").innerHTML="";
		document.getElementById("queryId").value="";
		
		var val=document.getElementById("createdForm").innerHTML;
		if(typeof val !== 'undefined'){
			bid=bid+1;
			var str='<button type="button" class="btn" value="UploadFile"  id="bt'+(bid)+'">Upload File</button>';
			val+=str;
			document.getElementById("createdForm").innerHTML=val;
		}
		else{
			bid=bid+1;
			document.getElementById("createdForm").innerHTML='<button type="button" class="btn" value="UploadFile"  id="bt'+(bid)+'">Upload File</button>';
		}
	}
	var taid=0;
	function createTextArea() {
		document.getElementById("createForm").style.display="block";
		document.getElementById("randomMessage").style.display="none";
		document.getElementById("resultantForm").innerHTML="";
		document.getElementById("queryId").value="";
		
		var val=document.getElementById("createdForm").innerHTML;
		if(typeof val !== 'undefined'){
			taid=taid+1;
			var str='<textarea class="form-control" placeholder="Enter Your Question" rows="5" id="ta'+(taid)+'">';
			val+=str;
			document.getElementById("createdForm").innerHTML=val;
		}
		else{
			taid=taid+1;
			document.getElementById("createdForm").innerHTML='<textarea class="form-control" rows="5" placeholder="Enter Your Question" id="ta'+(taid)+'">';
		}
	}
	var tid=0;
    function createTextBox() {
    	document.getElementById("createForm").style.display="block";
		document.getElementById("randomMessage").style.display="none";
		document.getElementById("resultantForm").innerHTML="";
		document.getElementById("queryId").value="";
		
		var val=document.getElementById("createdForm").innerHTML;
		if(typeof val !== 'undefined'){
			tid=tid+1;
			var str='<input type="text" class="form-control" placeholder="Enter Your Question" id="t'+(tid)+'">';
			val+=str;
			
			document.getElementById("createdForm").innerHTML=val;
		}
		else{
			tid=tid+1;
			document.getElementById("createdForm").innerHTML='<input type="text" class="form-control" placeholder="Enter Your Question" id="t'+(tid)+'">';
		}
		
		
    }
	function createTheForm() {
		document.getElementById("createForm").style.display="block";
		document.getElementById("createdForm").innerHTML="";
		document.getElementById("randomMessage").style.display="none";
		document.getElementById("resultantForm").innerHTML="";
		document.getElementById("formNameId").style.display="block";
		document.getElementById("formNameId").value=null;
		
		document.getElementById("queryId").value="";
		
		tid=0;
		taid=0;
		bid=0;
		
		
	}
	
	function displayTheForm() {
		document.getElementById("createForm").style.display="none";
		document.getElementById("createdForm").innerHTML="";
		document.getElementById("randomMessage").style.display="block";
		
		document.getElementById("formNameId").style.display="none";
		var val = document.getElementById("queryId").value;

		var url = "http://localhost:8080/form/displayForm?id=" + val;
		$
				.get(
						url,
						function(data, status) {
							// alert(data.formId);
							var str = "";

							if (data.textboxes != null) {
								for ( var i = 0; i < data.textboxes.length; i++) {
									var tx = data.textboxes[i];

									str += '<p><b>' + tx.placeholderValue
											+ '</b></p>';
									str += '<input type="text" class="form-control"><br/>';
								}
							}
							if (data.buttons != null) {
								for ( var i = 0; i < data.buttons.length; i++) {
									str += '<button type="button" class="btn">Upload File</button>&nbsp&nbsp';
								}
							}
							if (data.checkBoxes != null) {
								for ( var i = 0; i < data.checkBoxes.length; i++) {
									var cb = data.checkBoxes[i];
									
								}
							}
							if (data.textAreas != null) {
								for ( var i = 0; i < data.textAreas.length; i++) {
									var ta = data.textAreas[i];

									str += '<p><b>' + ta.placeholderValue
											+ '</b></p>';
									str += '<textarea class="form-control" rows="4"></textarea><br/>';
								}
							}
                           if(data.checkBoxes!=null){
                        	   for(var i=0;i<data.checkBoxes.length;i++){
                        		   var cb=data.checkBoxes[i];
                        		   str+='<p><b>'+cb.checkBoxValue+'</b></p>';
                        		   //str+='<select>'
                        		   for(var j=0;j<cb.optionValues.length;j++){
                        			   var cbVal=cb.optionValues[j];
                        			   str+='<input type="checkbox">'+cbVal+'<br/>';
                        			   }
                        		   str+='<br/>';
                        		  // str+='</select>';
                        	   }
                           }
                           if(data.dropdDowns!=null){
                        	   for(var i=0;i<data.dropdDowns.length;i++){
                        		   var cb=data.dropdDowns[i];
                        		   str+='<p><b><br/>'+cb.selectedValue+'</b></p><br/>';
                        		   str+='<select>'
                        		   for(var j=0;j<cb.options.length;j++){
                        			   var cbVal=cb.options[j];
                        			   str+='<option>'+cbVal+'</option>';
                        			   }
                        		  str+='</select>';
                        		  str+='<br/>';
                        	   }
                           }
							str += '<br/><br/>';
							document.getElementById("resultantForm").innerHTML  = str;

						});

	}
</script>

</body>
</html>