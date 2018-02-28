package multimedia.session;

public class RandomToken {
	
    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789";	
    
	    public static String getToken(int count) {
		
			int character;
			StringBuilder builder = new StringBuilder();
			
			while (count-- != 0) {
				character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
				builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			}
			
			return builder.toString();
		}  
}
