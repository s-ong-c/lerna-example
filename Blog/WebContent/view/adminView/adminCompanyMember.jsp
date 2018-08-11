<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자_업체회원관리</title>
</head>
<body>
<center>
<h1 style="color: #080C0B">업체회원 관리</h1>
<hr style="border-style: solid; border-width: 3px; border-color:#C5C4C6 ">
<form action="adminServlet.do" name="searchFrm" method="post">
회원ID 검색 <input type="text" name="searchtext"  value="" style="font-weight: bold;">



					<input type="hidden" name="command" value="searchresultCompany">
<input type="submit" value="검색" style="background: #E9E9F1">


</form>
<hr style="border-style: solid; border-width: 3px; border-color:#C5C4C6 ">
<h2 style="color: #555554">회원 리스트</h2>
<form action="adminServlet.do" name="deleteFrm" method="post">
<input type="hidden" name="command" value="deleteCompay"/>
<table class="list" border="2px solid" cellpadding="0" cellspacing="0" bordercolor=#BDBDBD  width="900px" style="color: #4C4C4C">
<tr style="border: 2px solid" bordercolor=#BDBDBD>
				<th style="background: #E5DEDC; color: #420100;"> 선택</th>
				<th style="background: #E5DEDC; color: #420100">아이디</th>
				<th style="background: #E5DEDC; color: #420100">비밀번호</th>
				<th style="background: #E5DEDC; color: #420100">이름</th>
				<th style="background: #E5DEDC; color: #420100">닉네임</th>
				<th style="background: #E5DEDC; color: #420100">이메일</th>
				<th style="background: #E5DEDC; color: #420100">업주회원 주소</th>
				<th style="background: #E5DEDC; color: #420100">업주회원 업체명</th>
				<th style="background: #E5DEDC; color: #420100">업주회원 연락처</th>
				<th style="background: #E5DEDC; color: #420100">수정</th>
			</tr>
<c:forEach var="adminCompanyMember" varStatus="A" items="${adminCompanyMember}">
				<tr>
					<td><input type="checkbox" name="chek" value="${A.index }">${A.index } 
					<input type="hidden" name="${A.index}" value="${adminCompanyMember.id }" >  </td>
					<td>${adminCompanyMember.id}</td>
					<td>${adminCompanyMember.pass }</td>
					<td>${adminCompanyMember.name }</td>
					<td>${adminCompanyMember.nickname }</td>
					<td>${adminCompanyMember.email }</td>
					<td>${adminCompanyMember.address }</td>
					<td>${adminCompanyMember.companyName }</td>
					<td>${adminCompanyMember.companyPhone }</td>
					<td><a href="adminServlet.do?command=updateCompanyView&id=${adminCompanyMember.id}"  >수정</a></td>
					
				</tr>
			</c:forEach>


</table>
<center>
<input type="submit" value="삭제" style="background: #E9E9F1">&nbsp;&nbsp;
<input type="button" value="메인" onclick="location.href='view/adminView/adminmain.jsp'" style="background: #E9E9F1">
</center>
</form>
</body>
</html>