package multimedia.registration;

import java.sql.*;
import config.DatabaseVariables;

public class EmailCheck {
	
	
	public boolean checkIfEmailExists(String email) throws ClassNotFoundException {

		try {
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(DatabaseVariables.database_url,DatabaseVariables.database_username,DatabaseVariables.database_password);  
      
		PreparedStatement stmt = con.prepareStatement("select * from users where user_email=? ");
		
		stmt.setString(1,email);  
		ResultSet rs=stmt.executeQuery(); 
		
		if(rs.next()) {
			con.close();
			return true;  
	        
		}else {
			 con.close();
			 return false;
			
		}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
}
