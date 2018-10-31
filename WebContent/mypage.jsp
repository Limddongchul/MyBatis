<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function(){
		$("#delete").click(function(){
			$(location).attr("href","delete.do");
		})
		
		$("#select").click(function(){
			$(location).attr("href","select.do");
		})
		$("#update").click(function(){
			$(location).attr("href","update.do");
		})
	})
</script>

</head>
<body>
	<div id="warpper">
		<table border="1">
			<tr>
				<th colspan="3">${sessionScope.loginId}님 환영합니다.</th>
			</tr>
			<tr>
				<th><button id="delete">회원탈퇴</button></th>
				<th><button id="update">정보수정</button></th>
				<th><button id="select">정보보기</button></th>
			</tr>
		</table>
	</div>
</body>
</html>