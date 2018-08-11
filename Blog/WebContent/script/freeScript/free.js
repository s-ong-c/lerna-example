//#23] 글쓰기.jsp 에서 왔다.
function freeCheck(){
	if(document.frm.name.value.length==0){
		alert('작성자를 입력하세요');
		frm.name.focus();
		return false;
	}
	if(document.frm.pass.value.length==0){
		alert('비밀번호를 입력하세요');
		frm.pass.focus();
		return false;
	}
	if(document.frm.title.value.length==0){
		alert('제목을 입력하세요');
		frm.title.focus();
		return false;
	}
	//#24] 글쓰기.jsp로 가자
	return true; 
}

//#50] 수정 삭제 버튼을 눌렀을 때 호출할 함수!
function open_win(url, name){
	//창 열기 - 수정 #51] 서블릿 - 수정하러 가자!  board_check_pass_form, 'update'
	window.open(url, name, "width=500, height=300");
	
}
function passCheck(){
	if(document.frm.pass.value.length==0){
		alert('비밀번호 입력하세요');
		return false;
	}
	return true;
}






