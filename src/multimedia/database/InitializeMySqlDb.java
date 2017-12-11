package multimedia.database;

import java.sql.*; 
import config.DatabaseVariables;

public class InitializeMySqlDb {
	
  String url = DatabaseVariables.database_url;
  String username = DatabaseVariables.database_username;
  String password = DatabaseVariables.database_password;
  
  public Connection mySqlDao() throws SQLException, ClassNotFoundException {
	  Class.forName("com.mysql.jdbc.Driver");  
	  Connection con=DriverManager.getConnection(url,username,password);
	  return con;
		
  }
  
}
