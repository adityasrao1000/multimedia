package multimedia.session;

import java.io.IOException;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "DirectJspAccess", urlPatterns = {"*.jsp"})
public class RestrictAccessFilter implements javax.servlet.Filter {

 
  @Override
  public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain)  {

	HttpServletResponse resp = (HttpServletResponse) response;
    System.out.println("Entered restrict accessFilter");
    System.out.println("protocol is " + request.getProtocol());
    System.out.println("remote host is " + request.getRemoteHost());
   
    try {
		resp.sendError(403 , "Forbidden");
	} catch (IOException e) {
		e.printStackTrace();
	}
    
  }

  
}