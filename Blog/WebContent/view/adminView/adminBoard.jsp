<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자_게시판관리</title>
</head>
<body>
<center>

<h1 style="color: #080C0B">게시판 관리</h1>
<hr style="border-style: solid; border-width: 3px; border-color:#C5C4C6 ">
<form action="adminServlet.do" name="searchFrm" method="post">

<select name="option"><option value="0">제목</option>
			 						<option value="1">내용 </option></select>                    
 <input type="text" name="boardsearchtext" >
<input type="hidden" name="command" value="boardsearchtext">
<input type="submit" value="검색" style="background: #E9E9F1">


</form>

<hr style="border-style: solid; border-width: 3px; border-color:#C5C4C6 ">
<h2 style="color: #555554">게시글 리스트</h5>
<form action="adminServlet.do" name="deleteFrm" method="post" >
<input type="hidden" name="command" value="deleteBoard"/>
<table class="list" border="2px solid" cellpadding="0" cellspacing="0" bordercolor=#BDBDBD  width="900px" style="color: #4C4C4C">
<tr style="border: 2px solid" bordercolor=#BDBDBD>
				<th style="background: #E5DEDC; color: #420100"> 선택</th>
				<th style="background: #E5DEDC; color: #420100">글번호</th>
				<th style="background: #E5DEDC; color: #420100">아이디</th>
				<th style="background: #E5DEDC; color: #420100">글제목</th>
				<th style="background: #E5DEDC; color: #420100">글내용</th>
				<th style="background: #E5DEDC; color: #420100">조회수</th>
				<th style="background: #E5DEDC; color: #420100">작성일</th>
				<th style="background: #E5DEDC; color: #420100">첨부파일</th>
			</tr>
<c:forEach var="adminBoard" varStatus="A" items="${adminBoard}">
				<tr>
					<td><input type="checkbox" name="chek" value="${A.index }">
					<input type="hidden" name="${A.index}" value="${adminBoard.num }" >  </td>
					
					<td>${adminBoard.num}</td>
					<td>${adminBoard.id }</td>
					<td>${adminBoard.title }</td>
					<td>${adminBoard.content }</td>
					<td>${adminBoard.readcount }</td>
					<td>${adminBoard.writedate }</td>
					<td>${adminBoard.fileRoad }</td>
					
				</tr>
			</c:forEach>


</table>
<br>
<center>
<input type="submit" value="삭제" style="background: #E9E9F1">&nbsp;&nbsp;
<input type="button" value="메인" onclick="location.href='view/adminView/adminmain.jsp'"style="background: #E9E9F1">
</center>
</form>
</center>
</body>

</html>