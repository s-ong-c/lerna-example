<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--#21] 글쓰기 양식  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%
	//버전 2에서 c:set안에 넣어 forword시키는 걸로 바꿔서 자바문 없얘기
	 if(session.getAttribute("loginUser")==null){

		request.getRequestDispatcher("/view/login/loginView.jsp").forward(request, response);				
	} 
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/free.css"> 
<script type="text/javascript" src="script/freeScript/free.js"></script>
<style type="text/css">
body {
	background-color: #F9F9F9;
}
</style>
</head>
<body>
<div class="section sec1">
<div id="wrap" align="center">
<h1>글쓰기</h1>
<div></div>
<form action="FreeServlet" method="post" name="frm">
	<input type="hidden" name="freeCommand" value="free_write"/>
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" value="${loginUser.id }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="title">* 필수</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="70" rows="15" name="content"></textarea></td>
		</tr>
	</table>
	<br>
	<br>
										<!--#22스크립트 갔다 오자   -->
	<input type="submit" value="등록" onclick="return boardCheck()"/>
												<!--#25] 프론트로 갖   
													작성자, 제목 , 내용, 비번, 이메일 -->
	<input type="reset" value="다시작성" />

	<input type="button" value="목록보기" onclick="location.href='FreeServlet?freeCommand=free_list'"/>
</form>
</div>
</div>
</body>
</html>

