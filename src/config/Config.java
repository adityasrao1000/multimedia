package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Config implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
     ServletContext sc = sce.getServletContext();
     System.out.println(sc);
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
} 