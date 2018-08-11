<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=    "Content-Type" content="text/html; charset=UTF-8">
<title>관리자 메인 페이지</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
<center>


<form action="#" method="get"  style="margin-top: 200px;">
<h1 style="color: #353336; font-weight: bold; font: 굴림;">관리자 메뉴</h1>
${message }<br>
<input type="button" value="회원정보관리" onclick="location.href='/Blog/adminServlet.do?command=member'" style="height: 150px;width : 150px; background: #EBE9EB" >&nbsp;&nbsp;
<input type="button" value="업주정보관리" onclick="location.href='/Blog/adminServlet.do?command=company'"style="height: 150px;width : 150px; background:  #EBE9EB">&nbsp;&nbsp;
<input type="button" value=" 게시판관리 " onclick="location.href='/Blog/adminServlet.do?command=board'"style="height: 150px;width : 150px; background:  #DCDADB">&nbsp;&nbsp;
<input type="button" value=" 등급관리   " onclick="location.href='/Blog/adminServlet.do?command=grade'"style="height: 150px;width : 150px; background: #C5C4C6">&nbsp;&nbsp;
<input type="button" value="탈퇴사유관리" onclick="location.href='/Blog/adminServlet.do?command=outMember'"style="height: 150px;width : 150px; background: #828085">&nbsp;&nbsp;

<br><br><br>
<input type="button" value="홈페이지" onclick="location.href='/Blog/loginServlet?command=mainStart'" style="background: #FFFFFF " class="btn btn-default">
</form>
</center>
</body>
</html>