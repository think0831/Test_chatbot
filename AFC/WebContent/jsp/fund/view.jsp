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
	<%--  <c:if test="${ fund !eq null }"> --%>
		<span>${ fund.fundName }</span><br>
		<span>${ fund.fundNumber }</span><br>
		<span>${ fund.fundType }</span><br>
		<span>${ fund.basePrice }</span><br>
		<span>${ fund.nav }</span><br>
		<span>${ fund.tam }</span><br>
		<span>${ fund.firstFee }</span><br>
		<span>${ fund.resaleFee }</span><br>
		<span>${ fund.repurchase }</span><br>
		<span>${ fund.profit }</span><br>
		<span>${ fund.totalPay }</span><br>
	<%--  </c:if>  --%>
	
	<form action="/fundJoin/add" method="post">
		<input type="hidden" name='fundNumber' value='${ fund.fundNumber }'>
		<input type="submit" id="add" value="가입" />
	</form>
	
	
</body>
</html>