package multimedia.session;

import java.io.IOException;

import javax.servlet.*;  
import javax.servlet.http.*;

public class RestrictAccessFilter implements Filter {

  public void init(FilterConfig arg0) throws ServletException {} 
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException  {

	HttpServletResponse resp = (HttpServletResponse) response;
   
    try {
		resp.sendError(403 , "Forbidden");
	} catch (IOException e) {
		e.printStackTrace();
	}
    
  }

}