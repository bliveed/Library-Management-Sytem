package Human;
import java.sql.*;


import Human.Librarian;
import Human.User;
import Connection.Database;

public class admin extends Person  {
	Connection connect = data.database();
	Statement stat = null;
	ResultSet res = null;
	PreparedStatement prepareStatement =null;
	

	public admin(String name,String surname,String email,String password,Date birthday,String gender,String status) {
		super(name,surname,email,password,birthday,gender,"Admin");
	}
	
	public admin() {}
	
	public boolean addLibrarian(String name,String surname,String email, String password, Date birthday , String gender) throws SQLException {
		
		String query="INSERT INTO Person (name,surname,email,password,birthday,gender,status) VALUES (?,?,?,?,?,?,?)";
		int execute=0;
		try {
				//java.sql.Date date= new java.sql.Date(new java.util.Date().getTime());
				//birthday=date;
				stat=connect.createStatement();
				prepareStatement = connect.prepareStatement(query);
				prepareStatement.setString(1, name);
				prepareStatement.setString(2, surname);
				prepareStatement.setString(3,email);
				prepareStatement.setString(4,password); 
				prepareStatement.setDate(5,birthday); 
				prepareStatement.setObject(6,gender);
				prepareStatement.setString(7,"Librarian");
				prepareStatement.executeUpdate();
				execute=1;
		}catch (Exception e) {
				e.printStackTrace();
		}
		
		if(execute==1) {
			return true;
		}else {
			return false;
		}
				
	}
	
	public boolean deleteLibraian(String email) {
		
		String query="DELETE FROM Person WHERE Status ='Librarian' AND Email= ?" ;
		int work=0;
		try {
			stat=connect.createStatement();
			prepareStatement = connect.prepareStatement(query);
			prepareStatement.setString(1, email);
			prepareStatement.executeUpdate();
			work=1;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		if(work==1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean addUser(String name,String surname,String email, String password, Date birthday , String gender) throws SQLException {
		
		String query="INSERT INTO Person (name,surname,email,password,birthday,gender,status) VALUES (?,?,?,?,?,?,?)";
		int execute=0;
		try {
				//java.sql.Date date= new java.sql.Date(new java.util.Date().getTime());
				//birthday=date;
				stat=connect.createStatement();
				prepareStatement = connect.prepareStatement(query);
				prepareStatement.setString(1, name);
				prepareStatement.setString(2, surname);
				prepareStatement.setString(3,email);
				prepareStatement.setString(4,password); 
				prepareStatement.setDate(5,birthday); 
				prepareStatement.setObject(6,gender);
				prepareStatement.setString(7,"User");
				prepareStatement.executeUpdate();
				execute=1;
		}catch (Exception e) {
				e.printStackTrace();
		}
		
		if(execute==1) {
			return true;
		}else {
			return false;
		}
				
	}
	
public boolean deleteUser(String email) {
		
		String query="DELETE FROM Person WHERE Status ='Librarian' AND Email= ?" ;
		int work=0;
		try {
			stat=connect.createStatement();
			prepareStatement = connect.prepareStatement(query);
			prepareStatement.setString(1, email);
			prepareStatement.executeUpdate();
			work=1;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		if(work==1) {
			return true;
		}
		else {
			return false;
		}
	}

}