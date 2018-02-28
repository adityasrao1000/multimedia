package multimedia.database;

import java.sql.*; 
import config.DatabaseVariables;

public class InitializeMySqlDb {
	
  String url = DatabaseVariables.database_url;
  String username = DatabaseVariables.database_username;
  String password = DatabaseVariables.database_password;
  
  public Connection mySqlDao() throws SQLException, ClassNotFoundException {
	  
	  Class.forName("com.mysql.cj.jdbc.Driver");  
	  Connection con=DriverManager.getConnection(url,username,password);
	  return con;
		
  }
  
  public void close(PreparedStatement ps,ResultSet rs, Connection con) {
	  try {
		ps.close();
		rs.close();
		con.close();
		System.out.println("database connections closed");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  
  }
  
  public void close(PreparedStatement ps, Connection con) {
	  try {
		ps.close();
		con.close();
		System.out.println("database connections closed");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  
  }
  
}
