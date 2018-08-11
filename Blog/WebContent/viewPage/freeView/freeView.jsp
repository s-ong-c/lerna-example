<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--#48] BoardViewAction 에서 board 
	${board.num} ${board.name}
 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/free.css"> 
<script type="text/javascript" src="/Blog/script/freeScript/free.js"></script>
<style type="text/css">
body {
	background-color: #F9F9F9;
}
</style>
</head>
<body>
<div class="section sec1">
	<div id ="wrap" align="center">
		<table class="table">
			<tr>
				<th>작성자</th>
				<td>${free.name }</td>		
				<th>이메일</th>
				<td>${free.email }</td>		
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${free.writedate }"/></td>
				<th>조회수</th>
				<td>${free.readcount }</td>
			</tr>
			<tr>
				
				<th>제목</th>
				<td>${free.title }</td>
			</tr>
			<tr>
				
				<td colspan="4" ><pre><textarea name="contents" cols="110" rows="20" >${free.content}</textarea></pre></td>
			</tr>
		</table>
		<br>
		<br>
		<!--#49] 수정버튼 눌렀을 때 스크립트 함수 open_win 가자  -->
			<c:if test="${loginUser.id==free.id}">
		<input type="button" value="수정"
		
		 onclick="open_win('FreeServlet?freeCommand=free_check_pass_form&num=${free.num}','update')">
		
		
		<input type="button" value="삭제"
		 onclick="open_win('FreeServlet?freeCommand=free_check_pass_form&num=${free.num}','del')">
		 </c:if>
		 
		<input type="button" value="게시글 리스트" onclick="location.href='/Blog/FreeServlet?freeCommand=free_list'">
		
		<input type="button" value="글쓰기" onclick="location.href='/Blog/FreeServlet?freeCommand=free_write_form'">
	</div>
</div>
</body>
</html>