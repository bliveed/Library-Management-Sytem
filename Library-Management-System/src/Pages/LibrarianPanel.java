package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import Book.*;
import Human.*;


import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LibrarianPanel extends JFrame {

	private JPanel contentPane;
	private JTextField usName;
	private JTextField usSurname;
	private JTextField usMail;
	private JTextField usPass;
	private JTextField userMailDel;
	private JTextField bookName;
	private JTextField bookAuthor;
	private JTextField bookGenre;
	private JTextField bookISBN;
	private JTextField bookISBNDel;
	private JTextField isBookName;
	private JTextField isUsMail;
	private JTextField isISBNnum;
	private JTextField retUsMail;
	private JTextField retBookName;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianPanel frame = new LibrarianPanel();
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
	public LibrarianPanel() throws SQLException {
		
		
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(29, 53, 680, 371);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("User Management", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(255, 255, 240));
		panel_4.setBounds(10, 11, 320, 321);
		panel.add(panel_4);
		
		JLabel label = new JLabel("New User");
		label.setFont(new Font("Impact", Font.PLAIN, 15));
		label.setBounds(10, 22, 93, 14);
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setBounds(10, 82, 80, 14);
		panel_4.add(label_1);
		
		JLabel label_2 = new JLabel("Surname:");
		label_2.setBounds(10, 107, 80, 14);
		panel_4.add(label_2);
		
		JLabel label_3 = new JLabel("E-mail:");
		label_3.setBounds(10, 132, 80, 14);
		panel_4.add(label_3);
		
		JLabel label_4 = new JLabel("Password:");
		label_4.setBounds(10, 157, 69, 14);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("Birthday:");
		label_5.setBounds(10, 182, 80, 14);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("Gender:");
		label_6.setBounds(10, 207, 80, 14);
		panel_4.add(label_6);
		
		usName = new JTextField();
		usName.setColumns(10);
		usName.setBounds(100, 79, 195, 20);
		panel_4.add(usName);
		
		usSurname = new JTextField();
		usSurname.setColumns(10);
		usSurname.setBounds(100, 104, 195, 20);
		panel_4.add(usSurname);
		
		usMail = new JTextField();
		usMail.setColumns(10);
		usMail.setBounds(100, 129, 195, 20);
		panel_4.add(usMail);
		
		usPass = new JTextField();
		usPass.setColumns(10);
		usPass.setBounds(100, 154, 195, 20);
		panel_4.add(usPass);
		
		JRadioButton usGenderF = new JRadioButton("Female");
		usGenderF.setBackground(new Color(255, 255, 240));
		usGenderF.setBounds(96, 203, 69, 23);
		panel_4.add(usGenderF);
		
		JRadioButton usGenderM = new JRadioButton("Male");
		usGenderM.setBackground(new Color(255, 255, 240));
		usGenderM.setBounds(226, 203, 69, 23);
		panel_4.add(usGenderM);
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTimezoneOffset());
		
		JDateChooser usBirthday = new JDateChooser();
		usBirthday.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlDate.getDate();
			}
		});
		usBirthday.setBounds(100, 182, 195, 20);
		panel_4.add(usBirthday);
		
		JButton button_1 = new JButton("ADD");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usMail.getText().length() == 0 || usPass.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Please Enter Required Informations!");
				}
				else {
					try {	
						//ResultSet res = stat.executeQuery("SELECT * FROM Person  WHERE Status='Admin'" );
						//while(res.next()) {
							admin admn = new admin();
							String name = usName.getText();
							String surname = usSurname.getText();
							String email = usMail.getText();
							String password = usPass.getText();
							 //userBirthday.getDate();
						
							//Date birthday = new java.sql.Date(new java.util.Date().setDate());
							String gender;
								if(usGenderF.isSelected()) {
									usGenderM.setSelected(false);
									gender= "Female";
								}
								else {
									usGenderF.setSelected(false);
									usGenderM.setSelected(true);
									gender="Male";
								}
							 
							String status = "User";
							String query ="";
							admn.addLibrarian(name,surname,email,password,sqlDate,gender);
							JOptionPane.showMessageDialog(null, "New User Added Succesfully!");

							}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
			}
			}
		});
		button_1.setBounds(100, 287, 89, 23);
		panel_4.add(button_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(255, 255, 240));
		panel_5.setBounds(345, 11, 320, 321);
		panel.add(panel_5);
		
		JLabel label_7 = new JLabel("Delete User");
		label_7.setFont(new Font("Impact", Font.PLAIN, 15));
		label_7.setBounds(10, 22, 123, 14);
		panel_5.add(label_7);
		
		JLabel label_8 = new JLabel("E-mail:");
		label_8.setBounds(10, 132, 80, 14);
		panel_5.add(label_8);
		
		userMailDel = new JTextField();
		userMailDel.setColumns(10);
		userMailDel.setBounds(100, 129, 195, 20);
		panel_5.add(userMailDel);
		
		JLabel label_9 = new JLabel("Please enter Users email address");
		label_9.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_9.setBounds(100, 151, 189, 14);
		panel_5.add(label_9);
		
		JButton button_2 = new JButton("DELETE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Librarian lib=new Librarian();
					String mail = userMailDel.getText();
					lib.deleteUser(mail);
					JOptionPane.showMessageDialog(null, "User Deleted Succesfully!");
				}
		
		});
		button_2.setBounds(115, 287, 89, 23);
		panel_5.add(button_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("Book Management", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(255, 255, 240));
		panel_6.setBounds(10, 11, 320, 321);
		panel_1.add(panel_6);
		
		JLabel label_10 = new JLabel("New Book");
		label_10.setFont(new Font("Impact", Font.PLAIN, 15));
		label_10.setBounds(10, 22, 93, 14);
		panel_6.add(label_10);
		
		JLabel label_11 = new JLabel("Book Name:");
		label_11.setBounds(10, 112, 80, 14);
		panel_6.add(label_11);
		
		JLabel label_12 = new JLabel("Author:");
		label_12.setBounds(10, 137, 80, 14);
		panel_6.add(label_12);
		
		JLabel label_13 = new JLabel("Genre:");
		label_13.setBounds(10, 162, 80, 14);
		panel_6.add(label_13);
		
		JLabel label_14 = new JLabel("ISBN Number:");
		label_14.setBounds(10, 187, 69, 14);
		panel_6.add(label_14);
		
		bookName = new JTextField();
		bookName.setColumns(10);
		bookName.setBounds(100, 109, 195, 20);
		panel_6.add(bookName);
		
		bookAuthor = new JTextField();
		bookAuthor.setColumns(10);
		bookAuthor.setBounds(100, 134, 195, 20);
		panel_6.add(bookAuthor);
		
		bookGenre = new JTextField();
		bookGenre.setColumns(10);
		bookGenre.setBounds(100, 159, 195, 20);
		panel_6.add(bookGenre);
		
		bookISBN = new JTextField();
		bookISBN.setColumns(10);
		bookISBN.setBounds(100, 184, 195, 20);
		panel_6.add(bookISBN);
		
		JButton addBookLib = new JButton("ADD");
		addBookLib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	

					String name = bookName.getText();
					String author = bookAuthor.getText();
					String genre = bookGenre.getText();
					int isbn = Integer.parseInt(bookISBN.getText());
					String availability="Available";
					Book book = new Book(name,author,genre,isbn,availability);
					if(book.getIsbn()!=isbn&&book.getBookName()!=name) {
						book.addBook(name,author,genre,isbn,availability);
						JOptionPane.showMessageDialog(null, "New Book Added Succesfully!");
					}
					else
						JOptionPane.showMessageDialog(null, "This Book Already Exists!");
					}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
			}
		});
		addBookLib.setBounds(100, 287, 89, 23);
		panel_6.add(addBookLib);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(255, 255, 240));
		panel_7.setBounds(345, 11, 320, 321);
		panel_1.add(panel_7);
		
		JLabel label_15 = new JLabel("Delete Book");
		label_15.setFont(new Font("Impact", Font.PLAIN, 15));
		label_15.setBounds(10, 22, 123, 14);
		panel_7.add(label_15);
		
		JLabel label_16 = new JLabel("ISBN Number:");
		label_16.setBounds(10, 132, 80, 14);
		panel_7.add(label_16);
		
		bookISBNDel = new JTextField();
		bookISBNDel.setColumns(10);
		bookISBNDel.setBounds(100, 129, 195, 20);
		panel_7.add(bookISBNDel);
		
		JLabel label_17 = new JLabel("Please enter Librarians email address");
		label_17.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_17.setBounds(100, 151, 189, 14);
		panel_7.add(label_17);
		
		JButton delBookLib = new JButton("DELETE");
		delBookLib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book =new Book();
				int isbn =Integer.parseInt(bookISBNDel.getText()) ;
				
				if(book.getIsbn()==isbn) {
					book.deleteBook(isbn);
					JOptionPane.showMessageDialog(null, "Book Deleted Succesfully!");
				}
				else
					JOptionPane.showMessageDialog(null, "Book Could Not Found!");

			}
		});
		delBookLib.setBounds(115, 287, 89, 23);
		panel_7.add(delBookLib);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("Issue Management", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(255, 255, 240));
		panel_8.setBounds(10, 11, 320, 321);
		panel_2.add(panel_8);
		
		JLabel label_18 = new JLabel("New Issue");
		label_18.setFont(new Font("Impact", Font.PLAIN, 15));
		label_18.setBounds(10, 22, 93, 14);
		panel_8.add(label_18);
		
		JLabel label_19 = new JLabel("Book Name:");
		label_19.setBounds(10, 124, 80, 14);
		panel_8.add(label_19);
		
		JLabel label_20 = new JLabel("User E-mail:");
		label_20.setBounds(10, 96, 80, 14);
		panel_8.add(label_20);
		
		JLabel label_21 = new JLabel("Issue Date:");
		label_21.setBounds(10, 183, 69, 14);
		panel_8.add(label_21);
		
		JLabel label_22 = new JLabel("Due Date:");
		label_22.setBounds(10, 211, 80, 14);
		panel_8.add(label_22);
		
		isBookName = new JTextField();
		isBookName.setColumns(10);
		isBookName.setBounds(100, 121, 195, 20);
		panel_8.add(isBookName);
		
		isUsMail = new JTextField();
		isUsMail.setColumns(10);
		isUsMail.setBounds(100, 93, 195, 20);
		panel_8.add(isUsMail);
		
		isISBNnum = new JTextField();
		isISBNnum.setColumns(10);
		isISBNnum.setBounds(100, 149, 195, 20);
		panel_8.add(isISBNnum);
		
		JLabel label_23 = new JLabel("ISBN Number:");
		label_23.setBounds(10, 152, 80, 14);
		panel_8.add(label_23);
		
		JDateChooser isDate = new JDateChooser();
		isDate.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		isDate.setBounds(100, 183, 195, 20);
		panel_8.add(isDate);
		
		JDateChooser dueDate = new JDateChooser();
		dueDate.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dueDate.setBounds(100, 211, 195, 20);
		panel_8.add(dueDate);
		
		User us=new User();
		JButton issueBook = new JButton("ADD");
		issueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Issues is = new Issues();
				String mail = isUsMail.getText();
				String book = isBookName.getText();
				String isbnNum= isISBNnum.getText();
				float isbn = Float.parseFloat(isbnNum);
				String availability="Issued";
				isDate.getDate();
				dueDate.getDate();
				if(us.getEmail()==mail) {
					is.addIssue(mail,book,isbn,sqlDate,sqlDate);
					JOptionPane.showMessageDialog(null, "Issue Added Succesfully!");
				}
				else
					JOptionPane.showMessageDialog(null, "Please Try Again!");

			}
		});
		issueBook.setBounds(100, 287, 89, 23);
		panel_8.add(issueBook);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(255, 255, 240));
		panel_9.setBounds(345, 11, 320, 321);
		panel_2.add(panel_9);
		
		JLabel label_24 = new JLabel("Return Book");
		label_24.setFont(new Font("Impact", Font.PLAIN, 15));
		label_24.setBounds(10, 22, 123, 14);
		panel_9.add(label_24);
		
		JButton returnBook = new JButton("RETURN");
		returnBook.setBounds(115, 287, 89, 23);
		panel_9.add(returnBook);
		
		JLabel label_25 = new JLabel("User E-mail:");
		label_25.setBounds(10, 110, 80, 14);
		panel_9.add(label_25);
		
		retUsMail = new JTextField();
		retUsMail.setColumns(10);
		retUsMail.setBounds(100, 107, 195, 20);
		panel_9.add(retUsMail);
		
		JLabel label_26 = new JLabel("Book Name:");
		label_26.setBounds(10, 138, 80, 14);
		panel_9.add(label_26);
		
		retBookName = new JTextField();
		retBookName.setColumns(10);
		retBookName.setBounds(100, 135, 195, 20);
		panel_9.add(retBookName);
		
		JLabel label_27 = new JLabel("Issued Date:");
		label_27.setBounds(10, 166, 69, 14);
		panel_9.add(label_27);
		
		JLabel label_28 = new JLabel("Return Date:");
		label_28.setBounds(10, 194, 80, 14);
		panel_9.add(label_28);
		
		JDateChooser retisDate = new JDateChooser();
		retisDate.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		retisDate.setBounds(100, 166, 195, 20);
		panel_9.add(retisDate);
		
		JDateChooser retDate = new JDateChooser();
		retDate.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		retDate.setBounds(100, 194, 195, 20);
		panel_9.add(retDate);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("View", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 11, 655, 321);
		panel_3.add(tabbedPane_1);
		
		DefaultTableModel viewUser = new DefaultTableModel();
		Object[] userColumn = new Object[8];
		userColumn[0] = "Id";
		userColumn[1] = "Name";
		userColumn[2] = "Surname";
		userColumn[3] = "E-Mail";
		userColumn[4] = "Password";
		userColumn[5] = "Birthday";
		userColumn[6] = "Gender";
		userColumn[7] = "Status";
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Surname", "E-Mail", "Password", "Birthday", "Gender", "Status"
			}
		));
		tabbedPane_1.addTab("User", null, table, null);
		
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Book Name", "Author", "Genre", "ISBN Number", "Availability"
			}
		));
		tabbedPane_1.addTab("Book", null, table_1, null);
		
		table_2 = new JTable();
		
		tabbedPane_1.addTab("Issue", null, table_2, null);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "User E-Mail", "ISBN Number", "Issued Date", "Return Date"
			}
		));
		tabbedPane_1.addTab("Return", null, table_3, null);
		
		JButton show = new JButton("SHOW");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[]bookList=null;
				Book book=new Book();

				DefaultTableModel viewBookList = new DefaultTableModel();
				viewBookList.setRowCount(0);
				
				Object[] bookColumn = new Object[8];
				bookColumn[0] = "Id";
				bookColumn[1] = "Book Name";
				bookColumn[2] = "Author";
				bookColumn[3] = "Genre";
				bookColumn[4] = "ISBN Number";
				bookColumn[5] = "Availability";
				
				
				viewBookList.setColumnIdentifiers(bookColumn);
				
				try {
					for(int i =0; i<book.viewBooks().size();i++) {
						bookList[0]=book.viewBooks().get(i).getBookId();
						bookList[1]=book.viewBooks().get(i).getBookName();
						bookList[2]=book.viewBooks().get(i).getAuthor();
						bookList[3]=book.viewBooks().get(i).getGenre();
						bookList[4]=book.viewBooks().get(i).getIsbn();
						bookList[5]=book.viewBooks().get(i).getAvailability();
						viewBookList.addRow(bookList);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table_1.setModel(viewBookList);
			}
		});
		show.setBounds(576, 0, 89, 23);
		panel_3.add(show);
		
		JButton button = new JButton("LOGOUT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				JOptionPane.showMessageDialog(null, "Thanks For Using Library Management System!");
			}
		});
		button.setBounds(322, 427, 89, 23);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Librarian Panel");
		lblNewLabel.setFont(new Font("Typoster", Font.ITALIC, 20));
		lblNewLabel.setBounds(211, 28, 326, 14);
		contentPane.add(lblNewLabel);
	}
}
