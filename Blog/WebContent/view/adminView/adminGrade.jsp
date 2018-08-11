<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String id = request.getParameter("id"); %>
    <%String admin =  request.getParameter("admin"); %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자_등급관리</title>
</head>
<body>
<center>
<h1 style="color: #080C0B">회원등급 관리</h1>
<form action="adminServlet.do" name="searchFrm" method="post">
회원ID 검색 <input type="text" name="searchtext"  value="" style="font-weight: bold;">



					<input type="hidden" name="command" value="searchresultGrade">
<input type="submit" value="검색"  style="background: #E9E9F1">


</form>
<h1 style="color: #080C0B">회원등급 관리</h1>

<table border="1" cellpadding="0" cellspacing="0">

	<tr><td>등급 0 : 일반회원</td></tr>
	<tr><td>등급 1 : 업주회원</td></tr>
	<tr><td>등급 2 : 일반회원 관리자</td></tr>
	<tr><td>등급 3 : 업주회원 관리자</td></tr>
	<tr><td>등급 4 : 게시판 관리자</td></tr>
	<tr><td>등급 5 : 탈퇴사유 관리자</td></tr>
	<tr><td>등급 6 : 최상위 관리자</td></tr>

</table>



<hr style="border-style: solid; border-width: 3px; border-color:#C5C4C6 ">
<h2 style="color: #555554">등급 리스트</h2>
<table class="list" border="2px solid" cellpadding="0" cellspacing="0" bordercolor=#BDBDBD  width="900px" style="color: #4C4C4C">
<tr style="border: 2px solid" bordercolor=#BDBDBD>
				<th style="background: #E5DEDC; color: #420100;">아이디</th>
				<th style="background: #E5DEDC; color: #420100;">등급</th>
				<th style="background: #E5DEDC; color: #420100;">수정</th>
			</tr>
				<c:forEach var="adminMember" items="${adminMember}">
				<tr>
					<td>${adminMember.id}</td>
					<td>${adminMember.admin}</td>
					<td><a href="adminServlet.do?command=WriteUpdateGrade&id=${adminMember.id}"  >수정</a></td>
					
				</tr>

</c:forEach>
	
</table>
<center>
<input type="button" value="메인" onclick="location.href='view/adminView/adminmain.jsp'" style="background: #E9E9F1">
</center>
</center>
</body>
</html>