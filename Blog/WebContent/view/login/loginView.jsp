<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
Cookie[] cook =  request.getCookies();
if(cook!=null){
	for(int i = 0 ; i<cook.length ; i++)
		if(cook[i].getName().equals("foodid")){
			String foodid = cook[i].getValue();
			session.setAttribute("id", foodid);
			
		}
}


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Blog/css/login.css">
<script type="text/javascript" src="/Blog/script/loginScript/check.js"></script>
<style type="text/css">
a {
	text-decoration: none;
	color: #8C8C8C;
}

hr {
	border: solid 0.1px #BDBDBD;
	margin: 15px;
	"
}

body {
	background-color: #F9F9F9;
}

input {
	border: 1px solid #BDBDBD;
}

input[type=text]:focus {
	border: solid 1px #FFB6B9;
}

input[type=password]:focus {
	border: solid 1px #FFB6B9;
}
</style>
</head>
<body>
	<center>
		<div style="width: 550px">
			<div style="padding-top: 40px; margin-bottom: 65px">
				<img width="400" height="100" alt="사진안뜰리가 없다" src="/Blog/picture/title.jpg" onclick="location.href='/Blog/loginServlet?command=mainStart'">
			</div>
			<form action="/Blog/loginServlet?command=loginCheck" method="post" onsubmit="return loginNullCheck()" name="frm">


				<input type="text" name="id"
					style="height: 45px; width: 514px; font-size: 22px; padding-left: 15px;"
					placeholder="아이디" value="${id }"><br> <input type="password"
					name="pass"
					style="height: 45px; width: 514px; margin-top: 12px; font-size: 22px; padding-left: 15px;"
					placeholder="비밀번호" ><br> 
					<div style="color: red; margin-top: 10px;">
					${message }
					</div>
					<input
					type="submit" value="로그인" class="button1"><br>
		
			<div style="text-align: left; margin: 5px; margin-bottom: 30px;">
				<input type="checkbox" name="check" value="1">아이디 저장
			</div>
			</form>
			<hr>
			<div style="margin-top: 20px; margin-bottom: 55px; color: #8C8C8C" >
				<a href="javascript:idFind()">아이디 찾기</a> | <a href="javascript:passFind()">비밀번호 찾기</a> | <a href="/Blog/view/login/join.jsp">회원가입</a><br>
			</div>
			<div style="margin-bottom: 30px">
				<img width="520" height="180" alt="사진안뜰리가 없다" src="/Blog/picture/e.jpg">
			</div>
		</div>
	</center>
	<%@include file="./footer.jspf"%>
</body>
</html>