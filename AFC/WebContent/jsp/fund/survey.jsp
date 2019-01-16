<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="list.jsp" method="post">
		<p>투자성향분석</p><br>
		<input type="radio" name="type" value="s">안정형 
		<input type="radio" name="type" value="v">안정추구형
		<input type="radio" name="type" value="s">위험중립형 
		<input type="radio" name="type" value="v">적극투자형
		<input type="radio" name="type" value="v">공격투자형
		<br>
		
		<input type="submit" value="다음">
	</form>
</body>

</html>