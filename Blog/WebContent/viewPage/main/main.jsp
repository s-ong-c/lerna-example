<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Blog/css/login.css">
<style type="text/css">

a {
color: #866768;
	text-decoration: none;
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

</style>

<script type="text/javascript" src="/Blog/script/loginScript/check.js"></script>
<script type="text/javascript">
function find(){
	//옮기기
	var url ="/Blog/view/login/find/Find.jsp";
	

	var setting = "toolbar=no, menuber=no, scrollbars=yes, resizable=no, width=400, height=240";

	window.open(url,"_blank_1",setting);
}
</script>
</head>
<body>
<center>
<div style=" width: 1200px">

	<img alt="720 * 500" src="/Blog/picture/mainpic.png" width="680" height="500px" style="border-radius: 60px 60px 60px 60px; margin-right: 25px">

	<iframe src="/Blog/view/main/right.jsp" width="450"  height="500px" style="margin-left :25px; border-radius: 60px 60px 60px 60px; border: solid 5px #FFB6B9;"></iframe>

	<br>
	<table width="1200px" height="100px" align="center" style="margin-top: 20px;  border-radius: 30px 30px 30px 30px; border: solid 2px #F26986;">
		<tr>
			<td width="300px">오늘 방문자 : ${todayCount} <br> 누적 방문자 : ${totalacount }
			</td>
			
			
			<td width="10"><img alt=
			"아직 사진 없음" src="/Blog/picture/adver.png" style="border-radius: 40px 40px 40px 40px; height: 100; width: 600;"></td>
			
			
			<td colspan="1" width="25%" >
			<c:if test="${empty loginUser}">
				<form action="/Blog/loginServlet?command=loginCheck" method="post" name="frm" onsubmit="return loginNullCheck()">
						<div style="padding-top:10px;">
						
							<table align="center" cellpadding="0" cellspacing="0">
								<tr valign="middle">
									<td><input type="text" name="id" placeholder="아이디" value="${id }" class="button4"
										style="height: 25px; width: 200px; border-radius: 10px 0px 0px 0px; padding-left: 10px;"></td>
									<td rowspan="2"><input type="submit" value="로그인" class="button3"
										style="height: 50px; width: 60px; border-radius: 0px 10px 10px 0px; "></td>
								</tr>
								<tr>
									<td><input type="password" name="pass" placeholder="비밀번호" class="button4"
										style="height: 25px; width: 200px; border-radius: 0px 0px 0px 10px; padding-left: 10px;"></td>
								</tr>
								
							</table>
						</div>
							<div style="font-size: 12px; margin-top: 10px; padding-bottom: 7px">
									
									<div style="color: #8C8C8C">
									<input type="checkbox" name="check" value="1" title="아이디 저장" style="margin-left: 12px">아이디 저장
									
									<a href="/Blog/view/login/join.jsp" style="margin-left: 17px;color: #8C8C8C;">회원가입</a> | 
									<a href="javascript:find()" style="margin-left: 0px ;color: #8C8C8C;">아이디.비밀번호 찾기</a>
									</div>
								</tr>
							</div>
					</form>
			</c:if> 
			<c:if test="${!empty loginUser}">
			<div style="text-align: center; margin: 20px">
				${loginUser.id} 님 반갑습니다.
			</div>
			<dir>
								<c:if test="${loginUser.admin<=1}">
				<input type="button" value="정보수정" class="findbutton" onclick="location.href='/Blog/view/login/repairView.jsp'">
				<input type="button" value="로그아웃" class="findbutton" onclick="location.href='/Blog/loginServlet?command=loginLogout'">
				<input type="button" value="기능없음" class="findbutton">
				</c:if>
					<c:if test="${loginUser.admin>=2}">
									<input type="button" value="로그아웃" class="findbutton" onclick="location.href='/Blog/loginServlet?command=loginLogout'">
									<input type="button" value="관리자페이지" class="findbutton" onclick="location.href='/Blog/view/adminView/adminmain.jsp'" style="margin-left: 30px; width: 120px;" >
					</c:if>
			</dir>
			</c:if></td>
		</tr>
	</table>
	<br>
	<br>
</div>
</center>
</body>

</html>