package multimedia.registration;

public class PasswordValidate {
  
	static boolean isValid(String password){
		if(password.length()<6 || password.length()>255) {
			return false;
		}
		return true;
	}
}
