<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%response.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자_회원등급 수정페이지</title>
<script type="text/javascript">

function check() {
	if(document.frm.admin.value==""){
		alert('등급을 입력하세요');
		frm.admin.focus();
		return false;
	}else{
		if(isNaN(document.frm.admin.value)){
			alert('숫자를 입력하세요');
			return false;
		}
	}
	

	return true;
}

</script>
</head>
<body>
<center>
<h1 style="color: #080C0B">회원등급 수정관리</h1>
<hr style="border-style: solid; border-width: 3px; border-color:#C5C4C6 ">
<h2 style="color: #555554">등급수정 리스트 </h5>
<form action="adminServlet.do" name="frm" method="post" onsubmit="return check()" >
<input type="hidden" name="command" value="WriteUpdateGradeView"/>
<input type="hidden" name="id" value="${adminMember.id}">
<table class="list" border="2px solid" cellpadding="0" cellspacing="0" bordercolor=#BDBDBD  width="900px" style="color: #4C4C4C">
<tr>
				<th style="background: #E5DEDC; color: #420100;">아이디</th>
				<th style="background: #E5DEDC; color: #420100;">등급</th>
			</tr>
				<tr>
					
					<td>${adminMember.id}<input type="hidden" name="${adminMember.id}" value="${adminMember.id}"> </td>
					<td><input type="text"  name="admin" value="${adminMember.admin}" onclick="return strCheck()"> </td>
				</tr>


</table>
<center>
<input type="submit" value="수정하기" style="background: #E9E9F1">&nbsp;&nbsp;
<input type="button" value="메인" onclick="location.href='view/adminView/adminmain.jsp'" style="background: #E9E9F1">
</center>
</form>
</center>
</body>
</html>