<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Blog/script/loginScript/check.js"></script>
<style type="text/css">
.findbutton{
	width: 100px;
	height: 150px;
	 border-radius: 3px 3px 3px 3px;
	 border: solid 2px #fae3d9;
	 background: #f8f3e6;
	 color: #866768;
}
body {
	background-color: #F9F9F9;
}
input[type=button]:HOVER {
	border: solid 2px #866768;
}

</style>
</head>
<body>
<center>
<h4 style="margin: 10px; margin-top:5px;  color: #866768;">안전하게 찾으실 수 있도록 도와드리겠습니다</h4>
	<input type="button" value="아이디 찾기" class=findbutton onclick="idFind()" style="margin-top: 10px;">
	<input type="button" value="비밀번호 찾기"  class=findbutton onclick="passFind()">
	</center>
</body>
</html>