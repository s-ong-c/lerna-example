<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Blog/script/loginScript/check.js">
</script>
<link rel="stylesheet" type="text/css" href="/Blog/css/login.css">
<style type="text/css">
input[type=text]:focus {
	border: solid 1px #FFB6B9;
}
.idtext{
	width: 230px;
	height: 30px
}
.findbutton{
	width: 70px;
	height: 25px;
	 border-radius: 3px 3px 3px 3px;
	 border: solid 2px #fae3d9;
	 background: #f8f3e6;
	 color: #866768;
	 font-weight: bold ;
}
body {
	background-color: #F9F9F9;
}
input[type=button]:HOVER {
	border: solid 2px #866768;
}
input[type=submit]:HOVER {
	border: solid 2px #866768;
}

</style>


</head>
<body>
<center>
		<c:if test="${empty id}">
		<h4 style="margin: 20px; margin-top:20px;  color: #866768;">회원정보에 입력된 정보를 입력해 주세요.</h4>
		<form action="/Blog/loginServlet?command=loginIdFind" method="post" onsubmit="return idFindNullCheck()" name="frm">		

		<div style="">

		<input type="text" name="name" placeholder="이름" style="background: white;padding-left: 10px;" class="idtext border1">
				<div style="">
				</div>
		<input type="text" name="nickname" placeholder="닉네임" style="background: white;padding-left: 10px;" class="idtext border1">
				<div style="">
				</div>
		<input type="text" name="email" placeholder="이메일" style="background: white;padding-left: 10px; margin-bottom: 7px" class="idtext border1">

		</div>
		<div style="color: #e25f70;">
		${message}
		</div>
		<div>
		<input type="submit" value="확인" class="findbutton" style="margin-top: 5px;">
		<input type="button" value="나가기" onclick="window.close();" class="findbutton">
		</div>
		<input type="hidden" name="find">
		</form>
		</c:if>
			<form action="/Blog/view/login/find/">

				<div style="margin: 20px; margin-top:40px;  color: #866768; font-size: 18px">
				<c:if test="${!empty id}">
				귀하의 아이디는 <span style="	 font-weight: bold ;" > ${id} </span>입니다.
				</div>
				<div>
					<input type="button" value="비밀번호 찾으러 가기" onclick="location.href='/Blog/view/login/find/passFind.jsp'" 
					class="findbutton" style="width: 160px; margin-top: 20px;">
					<input type="button" value="나가기" onclick="window.close();" class="findbutton">
					</div>
				</c:if>
				</form>

</center>
</body>
</html>