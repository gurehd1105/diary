package dao;

import vo.Counter;

public class CounterDao {
	
		
		// 오늘날짜의 카운트가 존재하는지
		// 오늘날짜의 접속자 수
		public Counter selectCounterByToday() {
			//SELECT * FROM counter
			//WHERE cnt_date = CURDATE()		
			return null ;
		}
		
		//selectCounterByToday() 결과가 없을때
		public int insertCounter() {
		//INSERT INTO counter(cnt_date, cnt_num)
		//VALUES(CURDATE(),1)
			return 0;
	}
		
		
		//selectCounterByToday() 결과가 있을때
		public int updateCounter() {
			//UPDATE counter SET cnt_num = cnt_num+1
			////WHERE cnt_date = CURDATE()
			
			return 0;
		}
		
		// 누적 접속자수
		public int selectCounterSum() {
			// SELECT SUM(cnt_num) FROM counter
			
			return 0;
		}
		
		
}
