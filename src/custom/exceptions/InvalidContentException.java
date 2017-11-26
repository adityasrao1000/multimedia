package custom.exceptions;

public class InvalidContentException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
		String reason;
		   public InvalidContentException(String reason) {
		     this.reason=reason;
		   }
		   public String toString(){
		     return (reason) ;
		  }
		
}
