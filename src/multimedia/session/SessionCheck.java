package multimedia.session;

import java.io.IOException;  

import javax.servlet.*;  
import javax.servlet.http.*;

public class SessionCheck implements Filter{  
  
public void init(FilterConfig arg0) throws ServletException {}  
      
public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {  
          
	HttpServletRequest request = (HttpServletRequest) req;
    HttpSession session = request.getSession(false);
    HttpServletResponse response = (HttpServletResponse) resp;
    if(session ==null){  
        
        response.sendRedirect("/multimedia/login");  
        
        
    }  
    else{  
    	chain.doFilter(req, resp);//sends request to next resource 
    }  
          
}  
    public void destroy() {}


  
}  