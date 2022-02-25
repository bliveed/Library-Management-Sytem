package Connection;

import java.sql.*;


public class Database {
	
		Connection con= null;
	
		public Connection database()  {
			try {
				this.con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database_lms?user=root");
				return con;			
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
			
		}
}
