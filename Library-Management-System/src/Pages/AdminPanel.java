package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Database;
import Human.Librarian;
import Human.admin;
import Book.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JYearChooser;

public class AdminPanel extends JFrame {

	private JPanel contentPane;
	private JTextField libName;
	private JTextField libSurname;
	private JTextField libMail;
	private JTextField libPass;
	private JTextField libMailDel;
	private JTextField userName;
	private JTextField userSurname;
	private JTextField userEmail;
	private JTextField userPass;
	private JTextField userMailDel;
	private JTextField isBookName;
	private JTextField isUserMail;
	private JTextField bookName;
	private JTextField bookAuthor;
	private JTextField bookGenre;
	private JTextField bookISBN;
	private JTextField bookISBNDel;
	private JTextField isISBNnumber;
	private JTextField retUserMail;
	private JTextField retBookName;
	private JTable libTab;
	private JTable userTab;
	private JTable bookTab;
	private JTable issueTab;
	private JTable returnTab;
	
	Librarian libra = new Librarian();
	
	Database conn = new Database();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AdminPanel() throws SQLException {
		
		Connection connect = conn.database();
		Statement stat = connect.createStatement();
		
	
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(32, 53, 680, 371);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("Librarian Management", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 240));
		panel_5.setBounds(10, 11, 320, 321);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Librarian");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 22, 93, 14);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 82, 80, 14);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(10, 107, 80, 14);
		panel_5.add(lblSurname);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 132, 80, 14);
		panel_5.add(lblEmail);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(10, 157, 69, 14);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setBounds(10, 182, 80, 14);
		panel_5.add(lblBirthday);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 214, 80, 14);
		panel_5.add(lblGender);
		
		libName = new JTextField();
		libName.setBounds(100, 79, 195, 20);
		panel_5.add(libName);
		libName.setColumns(10);
		
		libSurname = new JTextField();
		libSurname.setColumns(10);
		libSurname.setBounds(100, 104, 195, 20);
		panel_5.add(libSurname);
		
		libMail = new JTextField();
		libMail.setColumns(10);
		libMail.setBounds(100, 129, 195, 20);
		panel_5.add(libMail);
		
		libPass = new JTextField();
		libPass.setColumns(10);
		libPass.setBounds(100, 154, 195, 20);
		panel_5.add(libPass);
		
		JRadioButton libGenderF = new JRadioButton("Female");
		libGenderF.setBackground(new Color(255, 255, 240));
		libGenderF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libra.setGender("Female");
			}
		});
		libGenderF.setBounds(96, 210, 69, 23);
		panel_5.add(libGenderF);
		
		JRadioButton libGenderM = new JRadioButton("Male");
		libGenderM.setBackground(new Color(255, 255, 240));
		libGenderM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libra.setGender("Male");
			}
		});
		libGenderM.setBounds(226, 210, 69, 23);
		panel_5.add(libGenderM);
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTimezoneOffset());
		//String date = null;
		JDateChooser libBirthday = new JDateChooser();
		libBirthday.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String date = (((JTextField) libBirthday.getDateEditor().getUiComponent()).getText());
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                        "yyyy-mm-dd");
				sdf.format(sqlDate);
				sqlDate.getDate();				}
		});
		libBirthday.setBounds(100, 182, 195, 20);
		panel_5.add(libBirthday);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(libMail.getText().length() == 0 || libPass.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Please Enter Required Informations!");
				}
				else {
					try {	
						//ResultSet res = stat.executeQuery("SELECT * FROM Person  WHERE Status='Admin'" );
						//while(res.next()) {
							admin admn = new admin();
							String name = libName.getText();
							String surname = libSurname.getText();
							String email = libMail.getText();
							String password = libPass.getText();
							 libBirthday.getDate();
						
							//Date birthday = new java.sql.Date(new java.util.Date().setDate());
							String gender;
								if(libGenderF.isSelected()) {
									libGenderM.setSelected(false);
									gender= "Female";
								}
								else {
									libGenderF.setSelected(false);
									libGenderM.setSelected(true);
									gender="Male";
								}
							 
							String status = "Librarian";
							String query ="";
							admn.addLibrarian(name,surname,email,password,sqlDate,gender);
							JOptionPane.showMessageDialog(null, "New Librarian Added Succesfully!");

							}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
			}
				
			}
		});
		btnNewButton_1.setBounds(100, 287, 89, 23);
		panel_5.add(btnNewButton_1);
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 240));
		panel_6.setBounds(345, 11, 320, 321);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblDeleteLibrarian = new JLabel("Delete Librarian");
		lblDeleteLibrarian.setFont(new Font("Impact", Font.PLAIN, 15));
		lblDeleteLibrarian.setBounds(10, 22, 123, 14);
		panel_6.add(lblDeleteLibrarian);
		
		JLabel label = new JLabel("E-mail:");
		label.setBounds(10, 132, 80, 14);
		panel_6.add(label);
		
		libMailDel = new JTextField();
		libMailDel.setColumns(10);
		libMailDel.setBounds(100, 129, 195, 20);
		panel_6.add(libMailDel);
		
		JLabel lblNewLabel_4 = new JLabel("Please enter Librarians email address");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_4.setBounds(100, 151, 189, 14);
		panel_6.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin admn=new admin();
				String mail = libMailDel.getText();
				admn.deleteLibraian(mail);
				JOptionPane.showMessageDialog(null, "Librarian Deleted Succesfully!");
				}
		});
		btnNewButton_2.setBounds(115, 287, 89, 23);
		panel_6.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("User Management", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(255, 255, 240));
		panel_7.setBounds(10, 11, 320, 321);
		panel_1.add(panel_7);
		
		JLabel lblNewUser = new JLabel("New User");
		lblNewUser.setFont(new Font("Impact", Font.PLAIN, 15));
		lblNewUser.setBounds(10, 22, 93, 14);
		panel_7.add(lblNewUser);
		
		JLabel label_2 = new JLabel("Name:");
		label_2.setBounds(10, 82, 80, 14);
		panel_7.add(label_2);
		
		JLabel label_3 = new JLabel("Surname:");
		label_3.setBounds(10, 107, 80, 14);
		panel_7.add(label_3);
		
		JLabel label_4 = new JLabel("E-mail:");
		label_4.setBounds(10, 132, 80, 14);
		panel_7.add(label_4);
		
		JLabel label_5 = new JLabel("Password:");
		label_5.setBounds(10, 157, 69, 14);
		panel_7.add(label_5);
		
		JLabel label_6 = new JLabel("Birthday:");
		label_6.setBounds(10, 182, 80, 14);
		panel_7.add(label_6);
		
		JLabel label_7 = new JLabel("Gender:");
		label_7.setBounds(10, 207, 80, 14);
		panel_7.add(label_7);
		
		userName = new JTextField();
		userName.setColumns(10);
		userName.setBounds(100, 79, 195, 20);
		panel_7.add(userName);
		
		userSurname = new JTextField();
		userSurname.setColumns(10);
		userSurname.setBounds(100, 104, 195, 20);
		panel_7.add(userSurname);
		
		userEmail = new JTextField();
		userEmail.setColumns(10);
		userEmail.setBounds(100, 129, 195, 20);
		panel_7.add(userEmail);
		
		userPass = new JTextField();
		userPass.setColumns(10);
		userPass.setBounds(100, 154, 195, 20);
		panel_7.add(userPass);
		
		JRadioButton userGenderF = new JRadioButton("Female");
		userGenderF.setBackground(new Color(255, 255, 240));
		userGenderF.setBounds(96, 203, 69, 23);
		panel_7.add(userGenderF);
		
		JRadioButton userGenderM = new JRadioButton("Male");
		userGenderM.setBackground(new Color(255, 255, 240));
		userGenderM.setBounds(226, 203, 69, 23);
		panel_7.add(userGenderM);
		
		JDateChooser userBirthday = new JDateChooser();
		userBirthday.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton addUser = new JButton("ADD");
		addUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userEmail.getText().length() == 0 || userPass.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Please Enter Required Informations!");
				}
				else {
					try {	
						//ResultSet res = stat.executeQuery("SELECT * FROM Person  WHERE Status='Admin'" );
						//while(res.next()) {
							admin admn = new admin();
							String name = userName.getText();
							String surname = userSurname.getText();
							String email = userEmail.getText();
							String password = userPass.getText();
							 //userBirthday.getDate();
						
							//Date birthday = new java.sql.Date(new java.util.Date().setDate());
							String gender;
								if(userGenderF.isSelected()) {
									userGenderM.setSelected(false);
									gender= "Female";
								}
								else {
									userGenderF.setSelected(false);
									userGenderM.setSelected(true);
									gender="Male";
								}
							 
							String status = "User";
							String query ="";
							admn.addUser(name,surname,email,password,sqlDate,gender);
							JOptionPane.showMessageDialog(null, "New User Added Succesfully!");

							}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
			}
			}
		});
		addUser.setBounds(100, 287, 89, 23);
		panel_7.add(addUser);
		
		userBirthday.setBounds(100, 182, 195, 20);
		panel_7.add(userBirthday);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(255, 255, 240));
		panel_8.setBounds(345, 11, 320, 321);
		panel_1.add(panel_8);
		
		JLabel lblDeleteUser = new JLabel("Delete User");
		lblDeleteUser.setFont(new Font("Impact", Font.PLAIN, 15));
		lblDeleteUser.setBounds(10, 22, 123, 14);
		panel_8.add(lblDeleteUser);
		
		JLabel label_9 = new JLabel("E-mail:");
		label_9.setBounds(10, 132, 80, 14);
		panel_8.add(label_9);
		
		userMailDel = new JTextField();
		userMailDel.setColumns(10);
		userMailDel.setBounds(100, 129, 195, 20);
		panel_8.add(userMailDel);
		
		JLabel lblPleaseEnterUsers = new JLabel("Please enter Users email address");
		lblPleaseEnterUsers.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblPleaseEnterUsers.setBounds(100, 151, 189, 14);
		panel_8.add(lblPleaseEnterUsers);
		
		JButton deleteUser = new JButton("DELETE");
		deleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin admn=new admin();
				String mail = userMailDel.getText();
				admn.deleteUser(mail);
				JOptionPane.showMessageDialog(null, "User Deleted Succesfully!");
			}
		});
		deleteUser.setBounds(115, 287, 89, 23);
		panel_8.add(deleteUser);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("Book Management", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBackground(new Color(255, 255, 240));
		panel_13.setBounds(10, 11, 320, 321);
		panel_4.add(panel_13);
		
		JLabel lblNewBook = new JLabel("New Book");
		lblNewBook.setFont(new Font("Impact", Font.PLAIN, 15));
		lblNewBook.setBounds(10, 22, 93, 14);
		panel_13.add(lblNewBook);
		
		JLabel lblBookName = new JLabel("Book Name:");
		lblBookName.setBounds(10, 112, 80, 14);
		panel_13.add(lblBookName);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(10, 137, 80, 14);
		panel_13.add(lblAuthor);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setBounds(10, 162, 80, 14);
		panel_13.add(lblGenre);
		
		JLabel lblIsbnNumber = new JLabel("ISBN Number:");
		lblIsbnNumber.setBounds(10, 187, 69, 14);
		panel_13.add(lblIsbnNumber);
		
		bookName = new JTextField();
		bookName.setColumns(10);
		bookName.setBounds(100, 109, 195, 20);
		panel_13.add(bookName);
		
		bookAuthor = new JTextField();
		bookAuthor.setColumns(10);
		bookAuthor.setBounds(100, 134, 195, 20);
		panel_13.add(bookAuthor);
		
		bookGenre = new JTextField();
		bookGenre.setColumns(10);
		bookGenre.setBounds(100, 159, 195, 20);
		panel_13.add(bookGenre);
		
		bookISBN = new JTextField();
		bookISBN.setColumns(10);
		bookISBN.setBounds(100, 184, 195, 20);
		panel_13.add(bookISBN);
		
		JButton button_4 = new JButton("ADD");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	

						Book book = new Book();
						String name = bookName.getText();
						String author = bookAuthor.getText();
						String genre = bookGenre.getText();
						int isbn = Integer.parseInt(bookISBN.getText());
						String availability="Available";
						
						 book.addBook(name,author,genre,isbn,availability);
						JOptionPane.showMessageDialog(null, "New Book Added Succesfully!");

						}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
		
			}
		});
		button_4.setBounds(100, 287, 89, 23);
		panel_13.add(button_4);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBackground(new Color(255, 255, 240));
		panel_14.setBounds(345, 11, 320, 321);
		panel_4.add(panel_14);
		
		JLabel lblDeleteBook = new JLabel("Delete Book");
		lblDeleteBook.setFont(new Font("Impact", Font.PLAIN, 15));
		lblDeleteBook.setBounds(10, 22, 123, 14);
		panel_14.add(lblDeleteBook);
		
		JLabel lblIsbnNumber_1 = new JLabel("ISBN Number:");
		lblIsbnNumber_1.setBounds(10, 132, 80, 14);
		panel_14.add(lblIsbnNumber_1);
		
		bookISBNDel = new JTextField();
		bookISBNDel.setColumns(10);
		bookISBNDel.setBounds(100, 129, 195, 20);
		panel_14.add(bookISBNDel);
		
		JLabel label_37 = new JLabel("Please enter Librarians email address");
		label_37.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_37.setBounds(100, 151, 189, 14);
		panel_14.add(label_37);
		
		JButton button_5 = new JButton("DELETE");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book =new Book();
				int isbn =Integer.parseInt(bookISBNDel.getText()) ;
				book.deleteBook(isbn);
				JOptionPane.showMessageDialog(null, "Book Deleted Succesfully!");
			}
		});
		button_5.setBounds(115, 287, 89, 23);
		panel_14.add(button_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("Issue Management", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(255, 255, 240));
		panel_9.setBounds(10, 11, 320, 321);
		panel_2.add(panel_9);
		
		JLabel lblNewIssue = new JLabel("New Issue");
		lblNewIssue.setFont(new Font("Impact", Font.PLAIN, 15));
		lblNewIssue.setBounds(10, 22, 93, 14);
		panel_9.add(lblNewIssue);
		
		JLabel lblBookName_1 = new JLabel("Book Name:");
		lblBookName_1.setBounds(10, 124, 80, 14);
		panel_9.add(lblBookName_1);
		
		JLabel lblUserEmail = new JLabel("User E-mail:");
		lblUserEmail.setBounds(10, 96, 80, 14);
		panel_9.add(lblUserEmail);
		
		JLabel lblIssueDate = new JLabel("Issue Date:");
		lblIssueDate.setBounds(10, 183, 69, 14);
		panel_9.add(lblIssueDate);
		
		JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setBounds(10, 211, 80, 14);
		panel_9.add(lblDueDate);
		
		isBookName = new JTextField();
		isBookName.setColumns(10);
		isBookName.setBounds(100, 121, 195, 20);
		panel_9.add(isBookName);
		
		isUserMail = new JTextField();
		isUserMail.setColumns(10);
		isUserMail.setBounds(100, 93, 195, 20);
		panel_9.add(isUserMail);
		
	
		
		isISBNnumber = new JTextField();
		isISBNnumber.setColumns(10);
		isISBNnumber.setBounds(100, 149, 195, 20);
		panel_9.add(isISBNnumber);
		
		JLabel lblIsbnNumber_2 = new JLabel("ISBN Number:");
		lblIsbnNumber_2.setBounds(10, 152, 80, 14);
		panel_9.add(lblIsbnNumber_2);
		
		java.util.Date date1 = new java.util.Date();
		java.sql.Date sqlDate1 = new java.sql.Date(date1.getTimezoneOffset());
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                    "yyyy-mm-dd");
			sdf.format(sqlDate1);
			sqlDate1.getClass();
			}});
		dateChooser_1.setBounds(100, 183, 195, 20);
		panel_9.add(dateChooser_1);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                        "yyyy-mm-dd");
				sdf.format(sqlDate);
				sqlDate.getClass();
			}
		});
		dateChooser_2.setBounds(100, 211, 195, 20);
		panel_9.add(dateChooser_2);
		
		JButton addIssue = new JButton("ADD");
		addIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Issues is = new Issues();
				String mail = isUserMail.getText();
				String book = isBookName.getText();
				String isbnNum= isISBNnumber.getText();
				float isbn = Float.parseFloat(isbnNum);
				String availability="Issued";
				dateChooser_2.getDate();
				
				is.addIssue(mail,book,isbn,sqlDate1,sqlDate);
				JOptionPane.showMessageDialog(null, "Issue Added Succesfully!");
			}
		});
		addIssue.setBounds(100, 287, 89, 23);
		panel_9.add(addIssue);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(255, 255, 240));
		panel_10.setBounds(345, 11, 320, 321);
		panel_2.add(panel_10);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setFont(new Font("Impact", Font.PLAIN, 15));
		lblReturnBook.setBounds(10, 22, 123, 14);
		panel_10.add(lblReturnBook);
		
		JLabel label_1 = new JLabel("User E-mail:");
		label_1.setBounds(10, 110, 80, 14);
		panel_10.add(label_1);
		
		retUserMail = new JTextField();
		retUserMail.setColumns(10);
		retUserMail.setBounds(100, 107, 195, 20);
		panel_10.add(retUserMail);
		
		JLabel label_8 = new JLabel("Book Name:");
		label_8.setBounds(10, 138, 80, 14);
		panel_10.add(label_8);
		
		retBookName = new JTextField();
		retBookName.setColumns(10);
		retBookName.setBounds(100, 135, 195, 20);
		panel_10.add(retBookName);
		
		JLabel lblIssuedDate = new JLabel("Issued Date:");
		lblIssuedDate.setBounds(10, 166, 69, 14);
		panel_10.add(lblIssuedDate);
		
		JLabel lblReturnDate = new JLabel("Return Date:");
		lblReturnDate.setBounds(10, 194, 80, 14);
		panel_10.add(lblReturnDate);

		java.util.Date date3 = new java.util.Date();
		java.sql.Date sqlDate3 = new java.sql.Date(date3.getTimezoneOffset());
		
		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                        "yyyy-mm-dd");
				sdf.format(sqlDate3);
				sqlDate3.getClass();
			}
		});
		dateChooser_3.setBounds(100, 166, 195, 20);
		panel_10.add(dateChooser_3);

		java.util.Date date4 = new java.util.Date();
		java.sql.Date sqlDate4 = new java.sql.Date(date4.getTimezoneOffset());
		
		JDateChooser dateChooser_4 = new JDateChooser();
		dateChooser_4.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                        "yyyy-mm-dd");
				sdf.format(sqlDate4);
				sqlDate4.getClass();
			}
		});
		dateChooser_4.setBounds(100, 194, 195, 20);
		panel_10.add(dateChooser_4);
		
		
		JButton returnBook = new JButton("RETURN");
		returnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Issues is = new Issues();
				String mail = isUserMail.getText();
				String isbnNum= isISBNnumber.getText();
				float isbn = Float.parseFloat(isbnNum);
				String availability="Issued";
				dateChooser_2.getDate();
				
				is.addReturn(mail,isbn,sqlDate3,sqlDate4);
				JOptionPane.showMessageDialog(null, "Issue Added Succesfully!");
			}
		});
		returnBook.setBounds(115, 287, 89, 23);
		panel_10.add(returnBook);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("View", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 11, 655, 321);
		panel_3.add(tabbedPane_1);
		
		libTab = new JTable();
		libTab.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Surname", "E-Mail", "Password", "Birthday", "Gender", "Status"
			}
		));
		tabbedPane_1.addTab("Librarian", null, libTab, null);
		
		userTab = new JTable();
		userTab.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Surname", "E-Mail", "Password", "Birthday", "Gender", "Status"
			}
		));
		tabbedPane_1.addTab("User", null, userTab, null);
		
		bookTab = new JTable();
		bookTab.setModel(new DefaultTableModel(
			new Object[][] {
				//vi.viewBooks(),
			},
			new String[] {
				"Id", "Book Name", "Author", "Genre", "ISBN Number", "Availability"
			}
		));
		tabbedPane_1.addTab("Book", null, bookTab, null);
		
		issueTab = new JTable();
		issueTab.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "User E-Mail", "Book Name", "ISBN Number", "Issue Date", "Due Date"
			}
		));
		tabbedPane_1.addTab("Issue", null, issueTab, null);
		
		returnTab = new JTable();
		returnTab.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "User E-Mail", "ISBN Number", "Issued Date", "Return Date"
			}
		));
		tabbedPane_1.addTab("Return", null, returnTab, null);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to the Admin Panel");
		lblNewLabel_2.setFont(new Font("Typoster", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(235, 11, 298, 33);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				JOptionPane.showMessageDialog(null, "Thanks For Using Library Management System!");
			}
		});
		btnNewButton.setBounds(325, 427, 89, 23);
		contentPane.add(btnNewButton);
	}
}
