package Book;
import java.sql.*;
import java.util.ArrayList;

import Connection.Database;

public class Issues {
		Database data = new Database();
		Connection connect = data.database();
		Statement stat = null;
		ResultSet res = null;
		PreparedStatement prepareStatement =null;
		String usermail,bookName;
		float ISBNnumber;
		Date dueDate,issueDate;
		Issues issue;
		int id;


	public Issues() {}
	
	public Issues(String usermail, String bookName, float ISBNnumber, Date issueDate, Date DueDate) {
		this.usermail=usermail;
		this.bookName=bookName;
		this.ISBNnumber=ISBNnumber;
		this.issueDate=issueDate;
		this.dueDate=dueDate;
	}
	
	public boolean addIssue(String usMail, String BookName,float ISBNnumber,Date issueDate, Date dueDate) {
		int execute=0;
		String query = "INSERT INTO issue (UserEmail, BookName, ISBNnumber, IssueDate,DueDate) VALUES (?,?,?,?,?)";
		try {

			stat = connect.createStatement();
			prepareStatement = connect.prepareStatement(query);
			prepareStatement.setString(1, usMail);
			prepareStatement.setString(2, BookName);
			prepareStatement.setFloat(3, ISBNnumber);
			prepareStatement.setDate(4,issueDate);
			prepareStatement.setDate(5, dueDate);
			prepareStatement.executeUpdate();
			execute = 1;
			
			String isQuery = "UPDATE book Availability='Issued'";
			prepareStatement = connect.prepareStatement(isQuery);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (execute == 1) 
		{
			return true;
		}
		else {
			return false;	
			}
	}
	
	public boolean addReturn(String userMail,float ISBNnumber,Date issuedDate, Date returnDate) {
		int execute=0;
		String query = "INSERT INTO return (UserEmail,ISBNnumber, IssuedDate,ReturnDate) VALUES (?,?,?,?)";
		try {

			stat = connect.createStatement();
			prepareStatement = connect.prepareStatement(query);
			prepareStatement.setString(1, userMail);
			prepareStatement.setFloat(2, ISBNnumber);
			prepareStatement.setDate(3,issuedDate);
			prepareStatement.setDate(4, returnDate);
			prepareStatement.executeUpdate();
			execute = 1;
			
			String retQuery = "UPDATE book Availability='Available'";
			prepareStatement = connect.prepareStatement(retQuery);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (execute == 1) 
		{
			return true;
		}
		else {
			return false;	
			}
	}
	
	public ArrayList<Issues> viewIssue() throws SQLException {

		ArrayList<Issues>	issueList = new ArrayList<Issues>();
		try {
			String query="SELECT * from issue";
			stat = connect.createStatement();
			res= stat.executeQuery(query);
			while (res.next()) {
				issue = new Issues(res.getString("UserMail"), res.getString("BookName"), res.getFloat("ISBNnumber"), res.getDate("IssueDate"),res.getDate("DueDate"));
				issueList.add(issue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return issueList;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public float getISBNnumber() {
		return ISBNnumber;
	}

	public void setISBNnumber(float iSBNnumber) {
		ISBNnumber = iSBNnumber;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Issues getIssue() {
		return issue;
	}

	public void setIssue(Issues issue) {
		this.issue = issue;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
