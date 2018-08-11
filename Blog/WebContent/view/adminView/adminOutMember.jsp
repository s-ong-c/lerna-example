<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자_탈퇴관리</title>
</head>
<body>
<center>
<h1 style="color: #080C0B">탈퇴회원 관리</h1>
<hr style="border-style: solid; border-width: 3px; border-color:#C5C4C6 ">
<!-- view/adminView/adminmain.jsp -->
<h2 style="color: #555554">게시글 리스트</h2>
<form action="adminServlet.do" name="deleteFrm" method="post">
<input type="hidden" name="command" value="deleteOutMember"/> 
<table class="list" border="2px solid" cellpadding="0" cellspacing="0" bordercolor=#BDBDBD  width="900px" style="color: #4C4C4C">
<tr style="border: 2px solid" bordercolor=#BDBDBD>
				<th style="background: #E5DEDC; color: #420100;">선택</th>
				<th style="background: #E5DEDC; color: #420100;">글번호</th>
				<th style="background: #E5DEDC; color: #420100;">탈퇴사유(번호)</th>
				<th style="background: #E5DEDC; color: #420100;">탈퇴사유</th>
				<th style="background: #E5DEDC; color: #420100;">등급</th>
</tr>
	<c:forEach var="adminOutMember" varStatus="A" items="${adminOutMember}">
	
				<tr>
					<td><input type="checkbox" name="chek" value="${A.index}">
					<input type="hidden" name="${A.index}" value="${adminOutMember.num}" >  </td>
					
					<td>${adminOutMember.num}</td>
					<td>${adminOutMember.outNum}</td>
					<td>${adminOutMember.content}</td>
					<td>${adminOutMember.admin}</td>
					
				</tr>

</c:forEach>
</table>
<br>
<center>
<input type="submit" value="삭제" style="background: #E9E9F1">&nbsp;&nbsp;
<input type="button" value="메인" onclick="location.href='view/adminView/adminmain.jsp'" style="background: #E9E9F1">
</center>
</form>
</body>
</html>