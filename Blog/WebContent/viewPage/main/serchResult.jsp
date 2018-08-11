<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h5>게시글 리스트</h5>
<input type="hidden" name="command" value="deleteBoard"/>
<table class="list" border="3">
<tr>
            <th>&nbsp;글번호&nbsp;</th>
            <th>&nbsp;아이디&nbsp;</th>
            <th>&nbsp;글제목&nbsp;</th>
            <th>&nbsp;글내용&nbsp;</th>
            <th>&nbsp;조회수&nbsp;</th>
            <th>&nbsp;작성일&nbsp;</th>
            <th>&nbsp;첨부파일&nbsp;</th>
         </tr>
<c:forEach var="adminMain" varStatus="A" items="${adminMain}">
            <tr>
               
               <td>${adminMain.num}</td>
               <td>${adminMain.id }</td>
               <td><a href="/Blog/loginServlet?command=mainReserch&num=${adminMain.num}&kind=${adminMain.boardkind}"> ${adminMain.title }</a></td>
               <td>${adminMain.content }</td>
               <td>${adminMain.readcount }</td>
               <td>${adminMain.writedate }</td>
               <td>${adminMain.fileRoad }</td>
            </tr>
         </c:forEach>


</table>
</center>
<br>
</body>

</html>