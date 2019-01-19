import com.afc.domain.FundJoin;
import com.afc.persistence.FundJoinDao;

public class main {
	public static void main(String[] args) {
		
		FundJoin fundJoin = new FundJoin();
		FundJoinDao fundJoinDao = new FundJoinDao();
		
		
//		fundJoin.setJoinNumber(1);
//		fundJoin.setFundNumber(1);
//		fundJoin.setMemberNumber(1);
//		 
//		
//		fundJoinDao.add(fundJoin);
		
		
		fundJoinDao.remove(1);
		
	}

}
