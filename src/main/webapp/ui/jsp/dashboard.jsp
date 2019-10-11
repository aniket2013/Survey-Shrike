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
</style>

<head>
    <title>Spring Security Example</title>
    <link href="/bootstrap.min.css" rel="stylesheet">
    <script src="/jquery-2.2.1.min.js"></script>
    <script src="/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular.min.js"></script>
     
</head>
<body>
   <!--  <div>
    <div class="container" style="margin: 50px">
        <div>
            <form action="/logout" method="post">
                <button type="submit" class="btn btn-danger">Log Out</button>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>
        </div>
        <div class="row text-center">
            <strong> User Details</strong>
        </div>
        <div class="row" style="border: 1px solid green; padding: 10px">
            <div class="col-md-4 text-center">
                <strong>UserId</strong>
            </div>
            <div class="col-md-4 text-center">
                <strong>FormId</strong>
            </div>
            
        </div>
        <c:forEach var="form" items="${forms}">
            <div class="row" style="border: 1px solid green; padding: 10px">
                
                <div class="col-md-4 text-center">${form.formId}</div>
                <div class="col-md-4 text-center">${form.formName}</div>

            </div>
        </c:forEach>

    </div>
</div>-->
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
    <label>List Of Forms Available</label>
   <div id="allForms" style="border: 1px solid green;"><b></b></div>
   <br/><br/><br/>
   <label>Enter the Name of the form</label>
   <div class="col-sm-03">
   <input type="text" class="form-control" id="queryId"><br/>
   <button type="button" class="btn btn-success" onclick="displayTheForm()" class="form-control">Display The Form</button>
   </div>
   
   <br/><b>Your Form Is Here</b><br/>
   
   <div class="col-md-8" id="resultantForm" style="border: 1px solid green;"><b></b></div>
   
   
   
   
   </br>
   
 
<script>

	window.onload = function() {
		var url = "http://localhost:8080/form/displayAllForms";
		$.get(url, function(data, status) {
			// alert(data.formId);
			var str="";
			for ( var i = 0; i < data.length; i++) {
				
				str+='<b>'+data[i].formName+'</b><br/>'
				
			}
			document.getElementById("allForms").innerHTML=str;
		});
	};

	
	function displayTheForm() {
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
									alert(cb.formId + " " + cb.checkBoxId);
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
							document.getElementById("resultantForm").innerHTML = str;

						});

	}
</script>

</body>
</html>