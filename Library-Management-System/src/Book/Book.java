package Book;
import java.sql.*;
import java.util.ArrayList;

import Connection.Database;

public class Book extends Database {
	Database data = new Database();
	Connection connect = data.database();
	Statement stat = null;
	ResultSet res = null;
	PreparedStatement prepareStatement =null;
	Book book;
	int bookId;
	float isbn;
	String bookName, author , genre,availability;
	
	public Book() {}

	public Book(String bookName , String author , String genre,float isbn, String availability) {
		
		this.isbn = isbn; //international special number for every book has
		this.bookName = bookName; //books full name
		this.author = author; //author of the book
		this.genre = genre; //genre of the book
		this.availability=availability;
	}
	
	public boolean addBook( String name , String writer , String genre , float isbnNumber, String available) throws SQLException //adding new books to library system
	{	
		
		int execute = 0;
		
		String query = "INSERT INTO book (name, writer, Genre, isbnNumber,available) VALUES (?,?,?,?,?)";
		try {

			stat = connect.createStatement();
			prepareStatement = connect.prepareStatement(query);
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, writer);
			prepareStatement.setString(3, genre);
			prepareStatement.setFloat(4,isbnNumber);
			prepareStatement.setString(5, "Available");
			prepareStatement.executeUpdate();
			execute = 1;

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
	
	public boolean deleteBook(int isbnNumber) {
		
		String query="DELETE FROM Book WHERE ISBNnumber= ?" ;
		int work=0;
		try {
			stat=connect.createStatement();
			prepareStatement = connect.prepareStatement(query);
			prepareStatement.setInt(1, isbnNumber);
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
	
	public ArrayList<Book> viewBooks() throws SQLException {

		ArrayList<Book> booksList = new ArrayList<Book>();
		try {
			String query="SELECT * from Book";
			stat = connect.createStatement();
			res= stat.executeQuery(query);
			while (res.next()) {
				book = new Book(res.getString("BookName"), res.getString("Author"), res.getString("Genre"), res.getFloat("ISBNnumber"),res.getString("Available"));
				booksList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return booksList;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public float getIsbn() {
		return isbn;
	}

	public void setIsbn(float isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

}
