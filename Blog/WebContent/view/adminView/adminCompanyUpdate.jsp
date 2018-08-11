<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function admin_data_null(){
	
	if(document.frm.pass.value.length==0){
		alert('비밀번호를 입력하세요');
		frm.pass.focus();
		return false;
	}
	if(document.frm.name.value.length==0){
		alert('이름을 입력하세요');
		frm.name.focus();
		return false;
	}
	if(document.frm.nickname.value.length==0){
		alert('닉네임을 입력하세요');
		frm.nickname.focus();
		return false;
	}
	if(document.frm.email.value.length==0){
		alert('이메일을 입력하세요');
		frm.email.focus();
		return false;
	}
	if(document.frm.address.value.length==0){
		alert('주소를 입력하세요');
		frm.address.focus();
		return false;
	}
	if(document.frm.companyName.value.length==0){
		alert('업주이름을 입력하세요');
		frm.companyName.focus();
		return false;
	}
	if(document.frm.companyPhone.value.length==0){
		alert('업주번호를 입력하세요');
		frm.companyPhone.focus();
		return false;
	}
	
	return true;
}</script>
</head>
<body>
<center>
<h1 style="color: #080C0B">업체회원 수정관리</h1>
<hr style="border-style: solid; border-width: 3px; border-color:#C5C4C6 ">
<h2 style="color: #555554">업체회원 수정 리스트</h2>
<form action="adminServlet.do" name="frm" method="post" onsubmit="return admin_data_null()">
<input type="hidden" name="command" value="WriteUpdateCompany"/>
<input type="hidden" name="id" value="${adminCompanyMember.id}">
<table class="list" border="2px solid" cellpadding="0" cellspacing="0" bordercolor=#BDBDBD  width="900px" style="color: #4C4C4C">
<tr style="border: 2px solid" bordercolor=#BDBDBD>
				<th style="background: #E5DEDC; color: #420100;">아이디</th>
				<th style="background: #E5DEDC; color: #420100;">비밀번호</th>
				<th style="background: #E5DEDC; color: #420100;">이름</th>
				<th style="background: #E5DEDC; color: #420100;">닉네임</th>
				<th style="background: #E5DEDC; color: #420100;">이메일</th>
				<th style="background: #E5DEDC; color: #420100;">업주회원 주소</th>
				<th style="background: #E5DEDC; color: #420100;">업주회원 업체명</th>
				<th style="background: #E5DEDC; color: #420100;">업주회원 연락처</th>
			</tr>
				<tr>
					
					<td>${adminCompanyMember.id}<input type="hidden" name="${adminCompanyMember.id}" value="${adminCompanyMember.id}"> </td>
					<td><input type="text"  name="pass" value= "${adminCompanyMember.pass }"> </td>
					<td><input type="text" name="name" value="${adminCompanyMember.name }"> </td>
					<td><input type="text" name="nickname" value="${adminCompanyMember.nickname }"> </td>
					<td><input type="text" name="email" value="${adminCompanyMember.email }"> </td>
					<td><input type="text" name="address" value="${adminCompanyMember.address }"> </td>
					<td><input type="text" name="companyName" value="${adminCompanyMember.companyName }"> </td>
					<td><input type="text" name="companyPhone" value="${adminCompanyMember.companyPhone }"> </td>
				</tr>


</table>
<center>
<input type="submit" value="수정하기"style="background: #E9E9F1">&nbsp;&nbsp;
<input type="button" value="메인" onclick="location.href='view/adminView/adminmain.jsp'" style="background: #E9E9F1">
</center>
</form>
</center>
</body>
</html>