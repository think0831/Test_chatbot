<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/fund/list" method="post" id="addForm">
		<span>1. 고객님의 연령대는 어떻게 되십니까?</span><br>
		<input type="radio" name="q1" value="13" checked="checked">29세이하 
		<input type="radio" name="q1" value="10">30세~40세
		<input type="radio" name="q1" value="7">41세~50세 
		<input type="radio" name="q1" value="4">51세~60세
		<input type="radio" name="q1" value="1">61세이상
		<br><br>
		
		<span>2. 고객님께서 예상하시는 퇴직시점까지의 퇴직금 운용기간은 얼마나 되십니까?</span><br>
		<input type="radio" name="q2" value="1" checked="checked">2년이내 
		<input type="radio" name="q2" value="4">2년이상~5년이내
		<input type="radio" name="q2" value="7">5년이상~10년이내
		<input type="radio" name="q2" value="10">10년이상~20년이내
		<input type="radio" name="q2" value="14">20년이상
		<br><br>
		
		<span>3. 고객님의 투자경험과 가장 가까운 금융투자상품은 어느 것입니까?</span><br>
		<input type="radio" name="q3" value="2" checked="checked">안정형상품 - 은행 예적금, 국채, 지방채, 보증채, MMF, CMA <br>
		<input type="radio" name="q3" value="5">안정추구형 상품 - 금융채, 신용도가 높은 회사채, 채권형 펀드, 원금장형  ELS<br>
		<input type="radio" name="q3" value="8">위험중립형 상품 - 신용도 중간등급의 회사채, 주식, 원금이 보장 되지않은 ELS, 시장수익률 수준의 수익을 추구하는 주식형 펀드 등<br>
		<input type="radio" name="q3" value="11">적극투자형 상품 - 신용도가 낮은 회사채, 주식, 원금이 보장되지않은 ELS, 시장수익률 수준의 수익을 추구하는 주식형 펀드 등<br>
		<input type="radio" name="q3" value="14">공격형 상품 - ELW, 선물옵션, 시장수익율 이상의 수익을 추구하는 주식형 펀드, 파생 상품에 투자하는 펀드, 주식신용거래 등
		<br><br>
		
		<span>4. 금융상품 투자에 대한 본인의 지식 수준이 어느 정도라고 생각하십니까?</span><br>
		<input type="radio" name="q4" value="2" checked="checked">매우 낮은 수준 - 투자의사결정을 스스로 내려본 경험이 없는 정도 <br>
		<input type="radio" name="q4" value="5">낮은 수준 - 주식과 채권의 차이를 구별할 수 있는 정도<br>
		<input type="radio" name="q4" value="8">높은 수준 - 투자할 수 있는 대부분의 금융상품의 차이를 이해할 수 있는 정도<br>
		<input type="radio" name="q4" value="11">매우 높은 수준 - 금융상품을 비롯하여 모든 투자대상 상품의 차이를 이해할 수 있는 정도
		<br><br>
		
		<span>5. 고객님의 예상 퇴직급여는 전체 노후대비자산 중(부동산 등을 제외) 어느 정도의 비중을 차지합니까?</span><br>
		<input type="radio" name="q5" value="14" checked="checked">10% 이내 
		<input type="radio" name="q5" value="11">10% 이상~20% 이내
		<input type="radio" name="q5" value="8">20% 이상~30% 이내
		<input type="radio" name="q5" value="5">30% 이상~40% 이내
		<input type="radio" name="q5" value="2">40% 이상
		<br><br>
		
		<span>6. 고객님의 퇴직 시까지의 수입원을 가장 잘 나타내는 것은 어느 것입니까?</span><br>
		<input type="radio" name="q6" value="8" checked="checked">현재 일정한 수입이 발생하고 향후에도 현재 수준 유지하거나 증가할 것으로 예상 <br>
		<input type="radio" name="q6" value="5">현재 일정한 수입이 발생하고 있으나, 향후 감소할 것으로 예상<br>
		<input type="radio" name="q6" value="2">현재 일정한 수입이 있으나, 향후 매우 불안정할 것으로 예상
		<br><br>
		
		<span>7. 고객님의 투자원금에 손실이 발생할 경우 다음 중 고객님이 감내할 수 있는 손실 수준은 어느 수준입니까?</span><br>
		<input type="radio" name="q7" value="2" checked="checked">무슨 일이 있어도 투자원금 만큼은 보전되어야 한다.<br>
		<input type="radio" name="q7" value="14">10% 미만까지는 손실을 감수할 수 있을 것 같다.<br>
		<input type="radio" name="q7" value="20">20% 미만까지는 손실을 감수할 수 있을 것 같다.<br>
		<input type="radio" name="q7" value="26">기대수익이 높다면 위험이 높아도 상관하지 않겠다.
		<br><br>
		
		<span>8. 다음 중에서 고객님의 투자목표와 투자성향을 가장 잘 설명한 것은 어느 것입니까?</span><br>
		<input type="radio" name="q8" value="1" checked="checked">안정형 - 예금 또는 적금 수준의 수익률을 기대하며, 안정성이 가장 중요하다. <br>
		<input type="radio" name="q8" value="2">안정추구형 - 투자원금의 손실위험은 최소화하는 수준에서 퇴직연금 부담금 납부금액을 줄이는 것을 목표로 한다.<br>
		<input type="radio" name="q8" value="3">위험중립형 - 투자원금의 손실위험을 감수하면서 예,적금보다 높은 수익 또는 임금상승률 만큼의 기대수익을 얻는 것을 목표로한다.<br>
		<input type="radio" name="q8" value="4">적극투자형 - 투자원금의 보전보다는 위험을 감내하더라도 퇴직 연금 부담금 규모를 줄이기 위해 높은 수준의 투자수익 실현을 목표로한다.<br>
		<input type="radio" name="q8" value="5">공격투자형 - 퇴직연금 부담금 규모를 최소화 하기 위해 시장 평균수익률을 훨씬 넘어서는 높은 수준의 투자수익 실현을 목표로한다.
		<br><br>
		
		<input type="hidden" id="type"  name="type" value="1">
		<input type="button" value="다음" onclick="send()">
	</form>
	
		
	
</body>
<script type="text/javascript">

	var textarea = document.getElementById("messageWindow");
	
	function send() {
		var score = 0;	
		var type1 = 0;
		var type2 = 0;

		for(var i=1; i<=7; i++) {
			var part1 = document.getElementsByName('q' + i);

			for(var j=0; j<part1.length;j++) {
				if(part1[j].checked){
					score += Number(part1[j].value);
				}
			}
		}
		 
		if(score > 81)
			type1 = 5;
		else if(score > 61)
			type1 = 4;
		else if(score > 41)
			type1 = 3;
		else if(score > 21)
			type1 = 2;
		else
			type1 = 1;
		
		
		 var part2 = document.getElementsByName('q8');
		
		for(var j=0; j<part2.length;j++) {
			if(part2[j].checked){
				type2 = Number(part2[j].value);
			}
		}
		
		var fType = (type1 < type2) ? type1 : type2;
		
		document.getElementById('type').value = fType;
		document.getElementById('addForm').submit();
	}
	
</script>

</html>