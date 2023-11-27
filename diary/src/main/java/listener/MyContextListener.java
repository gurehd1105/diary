package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
@WebListener
public class MyContextListener implements ServletContextListener {

    
    public void contextDestroyed(ServletContextEvent sce)  { 
     
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	//application.setAttribute()
    	System.out.println("MyContextListener currentCnt : "
    			+ sce.getServletContext().getAttribute("currentCnt"));
    }
	
}

