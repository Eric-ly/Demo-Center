<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("button").click(function(){
		$.load("../resource/demo.txt",function(data,status){
			alert("data: "+data+"status: "+status);
		})
	})
	
})
</script>
<button> ajax button </button>
</body>
</html>