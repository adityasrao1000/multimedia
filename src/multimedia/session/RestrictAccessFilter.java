package multimedia.session;

import java.io.IOException;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "DirectJspAccess", urlPatterns = {"*.jsp"})
public class RestrictAccessFilter implements javax.servlet.Filter {

 
  @Override
  public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain)  {

	HttpServletResponse resp = (HttpServletResponse) response;
   
    try {
		resp.sendError(403 , "Forbidden");
	} catch (IOException e) {
		e.printStackTrace();
	}
    
  }

}