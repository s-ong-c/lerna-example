<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	if(window.name=='update'){
		//window에서 브라우져(parent)를 특정페이지로 href(이동)시킬거야
		//#71] 서블릿으로 가자 GO! 
		window.opener.parent.location.href=
			"ShareServlet?shareCommand=share_update_form&num=${param.num}";
		
	}else if(window.name=='del'){
		window.opener.parent.location.href=
			"ShareServlet?shareCommand=share_delete&num=${param.num}";
		
	}
	window.close();
</script>
<body>
	
</body>
</html>