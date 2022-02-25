package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Book.Book;
import Book.Issues;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserPanel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JButton show;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPanel frame = new UserPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserPanel() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(245, 255, 250));
		tabbedPane.setBounds(27, 53, 680, 371);
		contentPane.add(tabbedPane);
		
		table = new JTable();
		table.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("View Book", null, table, null);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("View Your Issues", null, table_1, null);
		
		table_2 = new JTable();
		table_2.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("View Your Returns", null, table_2, null);
		
		JButton button = new JButton("LOGOUT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				JOptionPane.showMessageDialog(null, "Thanks For Using Library Management System!");
			}
		});
		button.setBounds(320, 427, 89, 23);
		contentPane.add(button);
		
		show = new JButton("SHOW");
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
				table.setModel(viewBookList);
				
				Object[]issueList=null;
				Issues is=new Issues();

				DefaultTableModel viewIssue = new DefaultTableModel();
				viewIssue.setRowCount(0);
				
				Object[] issueColumn = new Object[8];
				issueColumn[0] = "Id";
				issueColumn[1] = "UserEmail";
				issueColumn[2] = "BookName";
				issueColumn[3] = "ISBNnumber";
				issueColumn[4] = "IssueDate";
				issueColumn[5] = "DueDate";
				
				
				viewIssue.setColumnIdentifiers(issueColumn);
				
				try {
					for(int i =0; i<is.viewIssue().size();i++) {
						issueList[0]=is.viewIssue().get(i).getId();
						issueList[1]=is.viewIssue().get(i).getUsermail();
						issueList[2]=is.viewIssue().get(i).getBookName();
						issueList[3]=is.viewIssue().get(i).getISBNnumber();
						issueList[4]=is.viewIssue().get(i).getIssueDate();
						issueList[5]=is.viewIssue().get(i).getDueDate();
						viewIssue.addRow(issueList);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table_1.setModel(viewIssue);
			}
			
			
		});
		show.setBounds(618, 11, 89, 23);
		contentPane.add(show);
		
		JLabel lblNewLabel = new JLabel("Welcome to the User Panel");
		lblNewLabel.setFont(new Font("Typoster", Font.ITALIC, 15));
		lblNewLabel.setBounds(27, 15, 201, 27);
		contentPane.add(lblNewLabel);
	}
}
