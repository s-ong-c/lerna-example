function loginNullCheck(){
	if(document.frm.id.value.length==0){
		frm.id.focus();
		return false;
	}
	if(document.frm.pass.value.length==0){
		frm.pass.focus();
		return false;
	}
	return true;
}




function joinCheck(){
	if(document.frm.id.value.length==0){
		frm.id.focus();
		return false;
	}
	if(document.frm.reid.value.length==0){
		alert('중복체크를 하지 않았습니다.');
		frm.id.focus();
		return false;
	}
	if(document.frm.pass1.value.length==0){
		frm.pass1.focus();
		return false;
	}
	if(document.frm.pass1.value != document.frm.pass2.value){
		alert('암호가 일치하지 않습니다.');
		frm.pass2.focus();
		return false;
	}
	if(document.frm.name.value.length==0){
		frm.name.focus();
		return false;
	}

	if(document.frm.nickname.value.length==0){
		frm.nickname.focus();
		return false;
	}
	if(document.frm.email.value.length==0){
		frm.email.focus();
		return false;
	}
	if(document.frm.adminNum.value==""){
		alert('등급을 선택해 주세요.');
		return false;
	}
	if(document.frm.address.value.length==0){
		frm.address.focus();
		return false;
	}
	if(document.frm.adminNum.value==1){
		
		if(document.frm.companyName.value.length==0){
		frm.companyName.focus();
		return false;		
		}		
		if(document.frm.companyPhone.value.length==0){
			frm.companyPhone.focus();
			return false;		
		}
		
		
	}
		
	//#32] 종료 -> join.jsp의 submit하러 가자!
	return true;
}


function updateCheck(){

	if(document.frm.pass1.value.length==0){
		frm.pass1.focus();
		return false;
	}
	if(document.frm.pass1.value != document.frm.pass2.value){
		alert('암호가 일치하지 않습니다.');
		frm.pass2.focus();
		return false;
	}

	if(document.frm.email.value.length==0){
		frm.email.focus();
		return false;
	}
	if(document.frm.adminNum.value==""){
		alert('등급을 선택해 주세요.');
		return false;
	}

	//#32] 종료 -> join.jsp의 submit하러 가자!
	return true;
}

function idCheck(){
	if(document.frm.id.value==""){
		document.frm.id.focus();
	}
	
	var url ="/Blog/loginServlet?command=loginIdOverCheck&id="+document.frm.id.value;
	
	//테두리 - 중복 체크용
	//A:url 요청값(뷰페이지)
	//B:타이틀 ( 프레임의 이름)
	//c:프레임 설정하기 
	var setting = "toolbar=no, menuber=no, scrollbars=yes, resizable=no, width=400, height=240";
	//20] idcheckservlet.java 서블릿으로 get방식으로 이동한다. userid를 파라미터에 담아서 데려간다. 
	window.open(url,"_blank_1",setting);
}
function idFind(){

	
	var url ="/Blog/view/login/find/idFind.jsp";
	

	var setting = "toolbar=no, menuber=no, scrollbars=yes, resizable=no, width=400, height=240";

	window.open(url,"_blank_1",setting);
}
function idFindNullCheck(){
	if(document.frm.name.value.length==0){
		frm.name.focus();
		return false;
	}

	if(document.frm.nickname.value.length==0){
		frm.nickname.focus();
		return false;
	}
	if(document.frm.email.value.length==0){
		frm.email.focus();
		return false;
	}
	return true;
}
function passFindNullCheck(){
	if(document.frm.id.value.length==0){
		frm.id.focus();
		return false;
	}
	if(document.frm.name.value.length==0){
		frm.name.focus();
		return false;
	}
	return true;
}


function passFind(){

	
	var url ="/Blog/view/login/find/passFind.jsp";
	

	var setting = "toolbar=no, menuber=no, scrollbars=yes, resizable=no, width=400, height=240";

	window.open(url,"_blank_1",setting);
}

function idOk(id){
	//join.jsp를 뭐라고 부를까? -> opener 
	opener.frm.id.value=id;
	
	//나중에 sumbit할 때, 데이터 유효성 검토할 거다
	//reid의 value여부로 id체크 결과를
	//따질 수 있다.
	opener.frm.reid.value=id;
	
	//열려있는 창 _blank_1 을 닫아라
	self.close();

	//join.jsp의 중복체크 버튼으로 이동
}
