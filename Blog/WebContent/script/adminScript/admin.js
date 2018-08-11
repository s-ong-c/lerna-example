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
	
	return true;
}