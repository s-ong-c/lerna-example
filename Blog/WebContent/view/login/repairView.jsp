<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	//버전 2에서 c:set안에 넣어 forword시키는 걸로 바꿔서 자바문 없얘기
	 if(session.getAttribute("loginUser")==null){

		request.getRequestDispatcher("loginView.jsp").forward(request, response);				
	} 
	%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Blog/css/login.css">
<script type="text/javascript" src="/Blog/script/loginScript/check.js"></script>
<script type="text/javascript" >
           
           function joinAdmin0() {
        	   document.getElementById("adminNum").value="0";
        	   document.getElementById("admin0").style.border = "solid 1px #E25F70";
        	   document.getElementById("admin0").style.color="#E25F70";
        	   document.getElementById("admin1").style.border = "solid 1px #BDBDBD";
        	   document.getElementById("admin1").style.color="#8C8C8C";
        	   document.getElementById("address").placeholder="집 주소를 입력해 주세요.";
        	   document.getElementById("company1").type="hidden";
        	   document.getElementById("company2").type="hidden";
        	  
		}
           function joinAdmin1() {
        	   document.getElementById("adminNum").value="1";
        	   document.getElementById("admin1").style.border = "solid 1px #E25F70";
        	   document.getElementById("admin1").style.color="#E25F70";
        	   document.getElementById("admin0").style.border = "solid 1px #BDBDBD";
        	   document.getElementById("admin0").style.color="#8C8C8C"; 
        	   document.getElementById("address").placeholder="업소의 주소를 입력해 주세요.";
        	   document.getElementById("company1").type="text";
        	   document.getElementById("company2").type="text";
        	  
		}
          

</script>
<style type="text/css">
</style>
</head>
<body>
	<center>
		<div style="width: 550px">
			<div style="padding-top: 40px; margin-bottom: 25px">
				<img width="400" height="100" alt="사진안뜰리가 없다"
					src="/Blog/picture/title.jpg" onclick="location.href='/Blog/loginServlet?command=mainStart'">
			</div>
			<h1 style="color: #FFB6B9; margin-bottom: 25px">정보수정</h1>
			<form action="/Blog/loginServlet?command=repairCheck" method="post" onsubmit="return updateCheck()"
				 name="frm">

					<input type="hidden" name="reid">
							<input type="text" name="id" class="border1"
							style="height: 60px; width: 514px; font-size: 22px; padding-left: 15px;"
							placeholder="아이디" value="${loginUser.id }" readonly disabled> 
							<input type="hidden" name="id" value="${loginUser.id }">
							<input type="password" name="pass1" class="border1"
							style="height: 55px; width: 514px; font-size: 22px; padding-left: 15px;"
							placeholder="새 비밀번호"> 

							<input type="password" name="pass2" class="border1"
							style="height: 55px; width: 514px; font-size: 22px; padding-left: 15px;"
							placeholder="새 비밀번호 재확인"> 

						<input type="text" name="name" class="border1"
						style="height: 55px; width: 514px; font-size: 22px; padding-left: 15px; margin-top: 50px;"
						placeholder="이름" value="${loginUser.name }" readonly disabled> 
						<input type="text" name="nickname" class="border1"
						style="height: 55px; width: 514px; font-size: 22px; padding-left: 15px;"
						placeholder="새 닉네임" value="${loginUser.nickname }"> 

						<div class="field">

							<input type="button" value="일반회원"  onclick="joinAdmin0()" id="admin0" style="width: 245px; height: 45px; margin: 7px; "
							class="border1 button2">
							<input type="button" value="업주회원" onclick="joinAdmin1()" id="admin1" style="width: 245px; height: 45px; margin: 7px; "
							class="border1 button2">
						
						</div>
						<input type="hidden" id="adminNum" name = "adminNum">
						<input type="text" name="email" class="border1"
						style="height: 55px; width: 514px; font-size: 22px; padding-left: 15px; margin-bottom: 50px"
						placeholder="새 이메일" value="${loginUser.email}"> 
						
						
						<input type="text" name="address" class="border1"
						style="height: 55px; width: 514px; font-size: 22px; padding-left: 15px;  color : #8C8C8C"
						placeholder="회원 종류를 먼저 선택해 주세요." id="address" value="${loginUser.address }"> 
						
						<input type="hidden" name="companyName" class="border1" value="${loginUser.companyName }"
						style="height: 55px; width: 514px; font-size: 22px; padding-left: 15px; color : #8C8C8C" id="company1" placeholder="새 업체명">					
						<input type="hidden" name="companyPhone" class="border1" value="${loginUser.companyPhone }"
						style="height: 55px; width: 514px; font-size: 22px; padding-left: 15px; color : #8C8C8C" id="company2" placeholder="새 업체 전화번호 (형식 : 000-0000-0000)">
						
						
						
						
							<input class="button1" type="submit" value="수정하기" style="width: 541px; height: 70px; margin: 5px; margin-bottom: 20px">
							<input class="button1" type="button" value="탈퇴하러 가기" onclick="location.href='DeleteView.jsp'"
							style="background : #E25F70 ;width: 541px; height: 70px; margin: 5px; margin-bottom: 70px">
			</form>
	<%@include file="./footer.jspf"%>


		</div>
	</center>
</body>
</html>