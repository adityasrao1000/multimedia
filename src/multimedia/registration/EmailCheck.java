package multimedia.registration;

import java.sql.*;



public class EmailCheck {
	
	
	public boolean checkIfEmailExists(String email) throws ClassNotFoundException {
		
		try {
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/multimedia","root","adi101992");  
      
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
