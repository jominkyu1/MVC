<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<script>
	function sw_check(){
		if ($.trim($('#title').val()).length == 0 ){
			alert('제목입력');
			$('#title').val('').focus();
			return false;
		}
		
		if($('#content').val() == '') {
			alert('내용입력');
			$('#content').focus();
			return false;
		}
	}
</script>
<body>
	<form method="post" action="service_ok" onsubmit="return sw_check();">
	Title: <input name="title" id="title"> <br><br> <!-- type생략시 기본값 text -->
	Content: <textarea name="content" id="content" rows="10" cols="35"></textarea><hr>
	<input type="submit" value="Submit">
	<input type="reset" value="Reset">
	</form>
</body>
</html>