<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- #59] CheckPassAction에서 dispatch 되었다. -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/free.css"> 
<script type="text/javascript" src="/Blog/script/freeScript/free.js"></script>
</head>
<body>
	<div align="center">
	<h1>비밀번호 확인</h1>
	<form action="FreeServlet" method="get" name="frm">
		<!-- BoardServlet?command=board_ch&num=23 -->
		<input type="hidden" name="freeCommand" value="free_check_pass">
		<input type="hidden" name="num" value="${param.num }">

		<table style="width: 80%">
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="pass" size="20">
			</td>
		</tr>		
		</table> 
		<br>			
		<input type="submit" value="확인" onclick="return passCheck()"><br>
		<br>${message } <!-- 비번 체크 -->
	</form>
	</div>

</body>
</html>