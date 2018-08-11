<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Blog/script/loginScript/check.js"></script>
<script type="text/javascript">
function newPassCheck(){
	if(document.frm.pass1.value.length==0){
		frm.pass1.focus();
		return false;
	}
	if(document.frm.pass2.value.length==0){
		frm.pass2.focus();
		return false;
	}

	if(document.frm.pass1.value != document.frm.pass2.value){
		alert('암호가 일치하지 않습니다.');
		frm.pass2.focus();
		return false;
	}
	window.close();
	return true;
}

</script>
<style type="text/css">
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

</style>
</head>
<body>
<center>
		<c:if test="${empty id}">
		<h4 style="margin: 20px; margin-top:20px; color: #866768;">회원정보에 입력된 정보를 입력해 주세요.</h4>
		<form action="/Blog/loginServlet?command=loginPassFind" method="post" onsubmit="return passFindNullCheck()" name="frm">
		<div>
		<input type="text" name="id" placeholder="아이디" style="background: white;padding-left: 10px;" class="idtext border1">
		</div>
		<div>
		<input type="text" name="name" placeholder="이름" 
		style="background: white;padding-left: 10px; margin-bottom: 7px;" class="idtext border1">
		</div>
		${message}
		<div>
		<input type="submit" value="확인" class="findbutton" style="margin-top: 20px;">
		<input type="button" value="나가기" onclick="window.close();" class="findbutton">
		</div>
		</form>
		</c:if>

		<c:if test="${!empty id}">
		
		<form action="/Blog/loginServlet?command=loginRepairPass" method="post" onsubmit="return newPassCheck()" name="frm">
		<h4 style="margin: 20px; margin-top:20px; color: #866768;">새 비밀번호를 입력해 주세요.</h4>
		<input type="password" name="pass1" placeholder="새 비밀번호" style="background: white;padding-left: 10px;" class="idtext border1">
		<br>
		<input type="password" name="pass2" placeholder="새 비밀번호 확인" 
		style="background: white;padding-left: 10px; margin-bottom: 7px;" class="idtext border1">
		<input type="hidden" name="id" value="${id}">
		<br>
				<input type="submit" value="변경" class="findbutton" style="margin-top: 20px;">
				<input type="button" value="취소" onclick="window.close();" class="findbutton">
		</form>
		
		
		</c:if>
</center>

</body>
</html>