<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
 function requestByJson() { 
	 var username = $("#Juser").val();
	 var userId=$("#JuserId").val();
    $.ajax({
              type : 'POST',
              url : '${pageContext.request.contextPath }/demo/json.do',
              contentType : 'application/json;charset=utf-8',

              data : JSON.stringify({"user":username,"id":userId}),
              
/*          	data : {"username":username,"userId":userId},		*/  
					success : function(data) {
                       alert(data);
              }
    });
    
} 
 function returnAjax(){
	 
 }
</script>
</head>
<body>
<form action="demo/model.do" method="post">
user:    <input type="text" name="user">
password:<input type="text" name="password">
<input type="submit" value=" model and view submit">
</form>


<input type="button" value="json" onclick="requestByJson()"/>

<form action=""  method="post">
user:    <input type="text" name="user" id="Juser">
userId:<input type="text" name="userId" id="JuserId">
<input type="submit" value=" json submit" onclick="requestByJson()">
</form>

<form action="ajaxDemo.do" method="post">
<input type="submit" value=" ajax button test page">
</form>
<!-- 文件上传 -->
<form method="post" action="demo/fileUpload.do" enctype="multipart/form-data">
description : <input type = "text" name = "desc" >
file:			  <input type ="file" name="file">
<input type="submit" value = "file upload " >

</form>

<form action="" onsubmit="return false" id="checkboxForm">
	<input type="checkbox" name="c" value="1"/>
	<input type="checkbox" name="c" value="2"/>
	<input type="checkbox" name="c" value="3"/>
	<button id="checkboxBtn">submit</button>
</form>
<form action="iodemo.do" method="get">
<input type="submit" value="iodemo button"></button>
</form>

<script type="text/javascript">

	$(function() {
		/* $('#checkboxBtn').click(function() {
			console.log($('#checkboxForm').serialize());
			$.ajax({
				url: '${pageContext.request.contextPath}/checkbox.do',
				type: 'POST',
				data: $('#checkboxForm').serialize(), //c=1&c=2&c=3
				success: function(result) {
					console.log(result);
				}
			});
		}); */
		/* 传输json格式到后台解析 */
		/* $('#checkboxBtn').click(function() {
			console.log($('#checkboxForm').serializeArray());
			$.ajax({
				url: '${pageContext.request.contextPath}/checkboxjson.do',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify($('#checkboxForm').serializeArray()),
				success: function(result) {
					console.log(result);
				}
			});
		}); */
		/* json数组 作为 data的值，后台通过参数获取 */
		$('#checkboxBtn').click(function() {
			console.log($('#checkboxForm').serializeArray());
			window.alert("asdfas");
			$.ajax({
				url: '${pageContext.request.contextPath}/checkboxjsonArray.do',
				type: 'POST',
				/* contentType: 'application/json', */
				data: $('#checkboxForm').serializeArray(),
				success: function(result) {
					console.log(result);
				}
			});
		});
	});
</script>

</body>
</html>