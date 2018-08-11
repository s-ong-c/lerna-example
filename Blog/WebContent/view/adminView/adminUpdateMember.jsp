
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%response.setCharacterEncoding("utf-8"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자_일반회원 수정페이지</title>
<script type="text/javascript" src="/Blog/script/adminScript/admin.js"></script>
</head>
<body>
<center>
<h1 style="color: #080C0B">일반회원 수정관리</h1>
<hr style="border-style: solid; border-width: 3px; border-color:#C5C4C6 ">
<h2 style="color: #555554">일반회원 수정 리스트 </h2>
<form action="adminServlet.do" name="frm" method="post" onsubmit="return admin_data_null()">
<input type="hidden" name="command" value="WriteUpdateMember"/>
<input type="hidden" name="id" value="${adminMember.id}">
<table class="list" border="2px solid" cellpadding="0" cellspacing="0" bordercolor=#BDBDBD  width="900px" style="color: #4C4C4C">
<tr style="border: 2px solid" bordercolor=#BDBDBD>
				<th style="background: #E5DEDC; color: #420100;">아이디</th>
				<th style="background: #E5DEDC; color: #420100;">비밀번호</th>
				<th style="background: #E5DEDC; color: #420100;">이름</th>
				<th style="background: #E5DEDC; color: #420100;">닉네임</th>
				<th style="background: #E5DEDC; color: #420100;">이메일</th>
			</tr>
				<tr>
					
					<td>${adminMember.id}<input type="hidden" name="${adminMember.id}" value="${adminMember.id}"> </td>
					<td><input type="text"  name="pass" value= "${adminMember.pass }"> </td>
					<td><input type="text" name="name" value="${adminMember.name }"> </td>
					<td><input type="text" name="nickname" value="${adminMember.nickname }"> </td>
					<td><input type="text" name="email" value="${adminMember.email }"> </td>
				</tr>


</table>
<center>
<input type="submit" value="수정하기" style="background: #E9E9F1">&nbsp;&nbsp;
<input type="button" value="메인" onclick="location.href='view/adminView/adminmain.jsp'"style="background: #E9E9F1">
</center>
</form>
</center>
</body>

</html>