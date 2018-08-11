<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Blog/css/login.css">
<script type="text/javascript" src="/Blog/script/loginScript/check.js"></script>
</head>
<body>
<center>
					<h2 style="font-size: 30px; font-weight: bold;">아이디 중복확인</h2>

 <form action="/Blog/loginServlet?command=loginIdOverCheck" method="post" name="frm">
 	<input type="text" name="id" value="${id}" style="width: 300px; height: 30px; font-size: 20px;" placeholder="아이디">
 	<%-- 중복 체크 누를떄마다 서블릿을 순환하게 된다. --%>
 	<input type="submit" value="중복체크" class="button3" style="width: 70px; height: 30px">
 	
		<c:if test="${result == 1 }">
			<%--창에 있는 input의 userid 항목에 value를 ""로 만들어 주면 편하다 --%>
			<%-- 현재 열려있는 창이라는 뜻 : opener --%>
			<script type="text/javascript">
				//현재 열려 있는 창 window.  의 userid값!
				opener.document.frm.id.value="";
			</script>
			<div class="font1">
			<span style="color: red; font-weight: bold;">
			사용불가능한 
			</span>아이디 입니다.
			</div>
		</c:if>
		<c:if test="${result == -1 }">
			<div class="font1">
			<span style="color: #47C83E; font-weight: bold;">
			사용가능한 
			</span>아이디 입니다.
			</div>
			<%--28]스크립트로 가서 join.jsp에 userid를 올려주도록 하자 --%>
			
			<input type="button" value="사용하기" onclick="idOk('${id}')" class="button3" style="width: 70px; height: 30px">
				
		</c:if>
 </form>
 </center>
 
</body>
</html>