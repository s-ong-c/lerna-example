<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script type="text/javascript" src="./js/attrImg.js"></script>
<link rel="stylesheet" type="text/css" href="css/free.css"> 
<style type="text/css">
body {
	background-color: #F9F9F9;
}
</style>
</head>
<body>

<div class="section sec1">
	<div id="wrap" align="center">   
		<table class="list table">		<%--  .list{ } --%>
			<tr>
				<td colspan="5" style="border:white; text-align: right;">
				<%--#14 ] 서블릿 board_write_form 패턴을 들고 간다. --%>
				<a href="FreeServlet?freeCommand=free_write_form">글쓰기</a>
				
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="freeList" items="${freeList }">
				<tr>
					<td>${freeList.num }</td>
					<!--#38] 글한건 보러 가기   -->
					<td><a href="FreeServlet?freeCommand=free_view&num=${freeList.num}">${freeList.title }</a></td>
					<td>${freeList.name }</td>
					<td><fmt:formatDate value="${freeList.writedate }"/></td>
					<td>${freeList.readcount }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</div>

</body>
</html>