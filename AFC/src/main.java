
import java.math.BigDecimal;

import com.afc.domain.Fund;
import com.afc.persistence.FundDao;

public class main {
	public static void main(String[] args) {
		
		BigDecimal ee = new BigDecimal("2618156349");
		
		FundDao fundDao = new FundDao();
		Fund vo1 = new Fund();
		vo1.setFundNumber(6);
		vo1.setFundName("신영퇴직연금채권증권자(채권)");
		vo1.setFundType("2");
		vo1.setBasePrice(1039.09);
		vo1.setNav(ee);		
		vo1.setTam("수익증권최저비율 90%, 수익증권최고비율 100% - 신영퇴직연금채권증권모(채권)");
		vo1.setFirstFee(0);
		vo1.setResaleFee(0);
		vo1.setRepurchase(0);
		vo1.setProfit(0.15);
		vo1.setTotalPay(0.6);
				
		int b = fundDao.add(vo1);

	}

}
