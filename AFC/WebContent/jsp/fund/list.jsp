<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${ fundList }" var="fund" varStatus="status">
		<a href="view?number=${ fund.fundNumber }">${ fund.fundName }</a><br>
	</c:forEach>
</body>
</html>