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
<script type="text/javascript" src="/Blog/script/loginScript/check.js">

</script>
<script type="text/javascript">
function outPassCheck(loginUserPass){
//스크립트 파일로 가져가기 
	if(document.frm.pass.value != loginUserPass){
		alert('암호가 일치하지 않습니다.');
		frm.pass.focus();
		return false;
	}

	return true;
}
function outReason0() {document.getElementById("outReason").value="0";}
function outReason1() {document.getElementById("outReason").value="1";}
function outReason2() {document.getElementById("outReason").value="2";}
function outReason3() {document.getElementById("outReason").value="3";}
function outReason4() {document.getElementById("outReason").value="4";}
function outReason5() {document.getElementById("outReason").value="5";}
function outReason6() {document.getElementById("outReason").value="6";}
function outReason7() {document.getElementById("outReason").value="7";}
function outReason8() {document.getElementById("outReason").value="8";}
function outReason9() {document.getElementById("outReason").value="9";}

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
			<form action="/Blog/loginServlet?command=loginDeleteReason" method="post" onsubmit="return outPassCheck('${loginUser.pass}')"
				 name="frm">

					<input type="hidden" name="reid">
							<input type="text" name="id" class="border1"
							style="height: 60px; width: 514px; font-size: 22px; padding-left: 15px;"
							placeholder="아이디" value="${loginUser.id }" readonly disabled> 
							<input type="hidden" name="id" value="${loginUser.id }">
							<input type="password" name="pass" class="border1"
							style="height: 55px; width: 514px; font-size: 22px; padding-left: 15px;"
							placeholder="비밀번호"> 

							<div style="margin : 25px;">
			<span style="color: #E25F70;font-size: 30px;font-weight:bold;">탈퇴 사유 </span>

			<span style="font-size: 30px;font-weight:bold;">말하기.</span>
							</div>
							
			<c:if test="${loginUser.admin==0}">
							<input type="button" id="reason0" onclick="outReason0()" class="border1" value="제휴업체가 별로 없어서"
							style="height: 65px;  width: 532px; font-size: 22px; padding-left: 15px; background: white;"> 
							<input type="button" id="reason1" onclick="outReason1()" class="border1" value="회원가입 혜택이 적어서"
							style="height: 65px; width: 532px; font-size: 22px; padding-left: 15px; background: white;"> 
							<input type="button" id="reason2" onclick="outReason2()" class="border1" value="별로 필요없는 사이트 같아서"
							style="height: 65px; width: 532px; font-size: 22px; padding-left: 15px; background: white;"> 
							<input type="button" id="reason3" onclick="outReason3()" class="border1" value="불필요한 내용이 많아서"
							style="height: 65px; width: 532px; font-size: 22px; padding-left: 15px; background: white;"> 
							<input type="button" id="reason4" onclick="outReason4()" class="border1" value="다이어트를 위해"
							style="height: 65px; width: 532px; font-size: 22px; padding-left: 15px; background: white;"> 
							<textarea rows="2" cols="20" name=texttext placeholder="기타 내용을 적어주세요." 
							style="height: 65px; width: 500px; font-size: 25px; padding: 15px; background: white; overflow:hidden; text-align: center;
							margin: 10px; vertical-align: middle;"></textarea>
				</c:if>
				<c:if test="${loginUser.admin==1}">
							<input type="button" id="reason5" onclick="outReason5()" class="border1" value="광고 효과가 적어서"
							style="height: 65px; width: 532px; font-size: 22px; padding-left: 15px; background: white;"> 
							<input type="button" id="reason6" onclick="outReason6()" class="border1" value="일부업체의 독점이 심해서"
							style="height: 65px; width: 532px; font-size: 22px; padding-left: 15px; background: white;"> 
							<input type="button" id="reason7" onclick="outReason7()" class="border1" value="수수료가 비싸서"
							style="height: 65px; width: 532px; font-size: 22px; padding-left: 15px; background: white;"> 
							<input type="button" id="reason8" onclick="outReason8()" class="border1" value="업주 혜택이 적어서"
							style="height: 65px; width: 532px; font-size: 22px; padding-left: 15px; background: white;"> 
							<input type="button" id="reason9" onclick="outReason9()" class="border1" value="업주관리방식의 불만"
							style="height: 65px; width: 532px; font-size: 22px; padding-left: 15px; background: white;"> 
							<textarea rows="2" cols="20" name=texttext placeholder="기타 내용을 적어주세요." 
							style="height: 65px; width: 500px; font-size: 25px; padding: 15px; background: white; overflow:hidden; text-align: center;
							margin: 10px; vertical-align: middle;"></textarea>
							
								</c:if>
				<c:if test="${loginUser.admin>=2}">

							<textarea rows="2" cols="20" name=texttext placeholder="관리자 탈퇴사유" 
							style="height: 65px; width: 500px; font-size: 25px; padding: 15px; background: white; overflow:hidden; text-align: center;
							margin: 10px; vertical-align: middle;"></textarea>
							
								</c:if>
							
							
							
							
						<input type="hidden" name="outReason" id="outReason" >
						<input type="hidden" name="admin" value="${loginUser.admin }" >
							<input class="button1" type="submit" value="탈퇴하기" style="background : #E25F70 ;width: 530px; height: 70px; margin: 5px; margin-bottom: 70px">
			</form>
	<%@include file="./footer.jspf"%>


		</div>
	</center>
</body>
</html>