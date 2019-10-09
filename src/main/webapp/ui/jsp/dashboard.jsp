<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring Security Example</title>
    <link href="/bootstrap.min.css" rel="stylesheet">
    <script src="/jquery-2.2.1.min.js"></script>
    <script src="/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular.min.js"></script>
     
</head>
<body>
   <div>
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
</div>
<!--  <div ng-app="myApp" ng-controller="myCtrl">
   <div id="para">
    <form id="para1">
      First name:<br>
      <input type="text" name="firstname" >
      <br>
     Last name:<br>
     <input type="text" name="lastname" >
     <br><br>
      <input type="submit" value="Submit">
   </form>
 </div>
  <button ng-click="myFunc()">get Text</button>
  
 <div ng-bind-html="myData"></div>
 </div>
<script>
var app=angular.module('myApp', [])
app.controller('myCtrl', ['$scope','$http', function($scope,$http) {
  
  $scope.myFunc = function() {
	  var a = document.getElementsByTagName('form')[0].innerHTML;
	  document.getElementById("para1").style.display="none";
	 // alert(a);
	  //document.getElementsByTagName('form')[1].innerHTML=a;
	  a=a.replace(/\n/g, '')
	  var url="http://localhost:8080/books/"+a;
	  alert(url);
	  $http.get(url).then(function(response) {
		    $scope.myData = a;
		    window.location = url;
		  });
	  alert("ok");
	  
	  
  };
}]);



</script>-->
</body>
</html>