package multimedia.registration;

import java.sql.*;
import multimedia.database.InitializeMySqlDb;


public class EmailCheck {
	
	
	public boolean checkIfEmailExists(String email) throws ClassNotFoundException {

		try {
		
		Connection con = new InitializeMySqlDb().mySqlDao(); 
		PreparedStatement stmt = con.prepareStatement("select * from users where user_email=? ");
		
		stmt.setString(1,email);  
		ResultSet rs=stmt.executeQuery(); 
		
		if(rs.next()) {
			stmt.close();
			con.close();
			return true;  
	        
		}else {
			 stmt.close();
			 con.close();
			 return false;
			
		}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
}
