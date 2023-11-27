package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dao.CounterDao;
import vo.Counter;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

   
	// view에서 application.getAttribute("currentCnt")값을 호출하면 현재 접속자수를 출력가능
    public void sessionCreated(HttpSessionEvent se)  { 
    	// 현재 접속자
    	int n = (Integer)(se.getSession().getServletContext().getAttribute("currentCnt"));
        se.getSession().getServletContext().setAttribute("currentCnt", n+1);
        
        //오늘날짜 누적 접속자
        CounterDao counterDao = new CounterDao();
        Counter counter = counterDao.selectCounterByToday();
        	if(counter == null) {//오늘 첫번째 접속
        		counterDao.insertCounter();        		
        	}else {
        		counterDao.updateCounter();
        	}
        }
    

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	//현재 접속자 -1
    	 int n = (Integer)(se.getSession().getServletContext().getAttribute("currentCnt"));
         se.getSession().getServletContext().setAttribute("currentCnt", n-1);
    }
	
}
