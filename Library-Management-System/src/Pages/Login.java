package Pages;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connection.Database;//This Connection is name of package which has Database class
import Human.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userLogField;
	private JPasswordField userPass;
	private JPasswordField libPass;
	private JTextField libMail;
	private JPasswordField adminPass;
	private JTextField adminMail;
	private Database con=new Database();//

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 240));
		tabbedPane.setBounds(234, 99, 215, 245);
		contentPane.add(tabbedPane);
		
		JPanel UserLogin = new JPanel();
		UserLogin.setBackground(new Color(255, 255, 240));
		tabbedPane.addTab("User Login", null, UserLogin, null);
		UserLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-Mail: ");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 79, 70, 14);
		UserLogin.add(lblNewLabel);
		
		userLogField = new JTextField();
		userLogField.setBounds(100, 78, 86, 20);
		UserLogin.add(userLogField);
		userLogField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password: ");
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 121, 100, 14);
		UserLogin.add(lblNewLabel_1);
		
		userPass = new JPasswordField();
		userPass.setBounds(100, 120, 86, 20);
		UserLogin.add(userPass);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userLogField.getText().length() == 0 || userPass.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Please Enter Required Informations!");
				}
				else {
					try {
						Connection connect = con.database();
						Statement stat = connect.createStatement();
						ResultSet res = stat.executeQuery("SELECT * FROM Person WHERE Status='User'" );
						while(res.next()) {
							UserPanel usPanel=new UserPanel();
							User us= new User();
							us.setId(res.getInt("Id"));
							us.setName(res.getString("Name"));
							us.setSurname(res.getString("Surname"));
							us.setEmail(res.getString("Email"));
							us.setPassword(res.getString("Password"));
							us.setBirthday(res.getDate("Birthday"));
							us.setGender(res.getString("Gender"));
							us.setStatus(res.getString("Status"));
							System.out.println(us.getStatus());
							usPanel.setVisible(true);}
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Typoster", Font.PLAIN, 10));
		btnNewButton.setBounds(120, 167, 80, 23);
		UserLogin.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGISTER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register();
				reg.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Typoster", Font.PLAIN, 10));
		btnNewButton_1.setBounds(10, 167, 100, 23);
		UserLogin.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to the Library");
		lblNewLabel_2.setFont(new Font("Typoster", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(36, 30, 164, 14);
		UserLogin.add(lblNewLabel_2);
		
		JPanel LibrarianLogin = new JPanel();
		LibrarianLogin.setBackground(new Color(255, 255, 240));
		tabbedPane.addTab("Librarian Login", null, LibrarianLogin, null);
		LibrarianLogin.setLayout(null);
		
		JLabel label = new JLabel("Welcome to the Library");
		label.setFont(new Font("Typoster", Font.PLAIN, 13));
		label.setBounds(36, 33, 164, 14);
		LibrarianLogin.add(label);
		
		JLabel label_1 = new JLabel("E-Mail: ");
		label_1.setFont(new Font("Impact", Font.PLAIN, 15));
		label_1.setBounds(10, 82, 70, 14);
		LibrarianLogin.add(label_1);
		
		JLabel label_2 = new JLabel("Password: ");
		label_2.setFont(new Font("Impact", Font.PLAIN, 15));
		label_2.setBounds(10, 124, 100, 14);
		LibrarianLogin.add(label_2);
		
		libPass = new JPasswordField();
		libPass.setBounds(100, 123, 86, 20);
		LibrarianLogin.add(libPass);
		
		libMail = new JTextField();
		libMail.setColumns(10);
		libMail.setBounds(100, 81, 86, 20);
		LibrarianLogin.add(libMail);
		
		JButton button_1 = new JButton("LOGIN");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(libMail.getText().length() == 0 || libPass.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Please Enter Required Informations!");
				}
				else {
					try {
						Connection connect = con.database();
						Statement stat = connect.createStatement();
						ResultSet res = stat.executeQuery("SELECT * FROM Person  WHERE Status='Librarian' " );
						while(res.next()) {
							LibrarianPanel libPanel=new LibrarianPanel();
							Librarian lib= new Librarian();
							lib.setId(res.getInt("Id"));
							lib.setName(res.getString("Name"));
							lib.setSurname(res.getString("Surname"));
							lib.setEmail(res.getString("Email"));
							lib.setPassword(res.getString("Password"));
							lib.setBirthday(res.getDate("Birthday"));
							lib.setGender(res.getString("Gender"));
							lib.setStatus(res.getString("Status"));
							System.out.println(lib.getStatus());
							libPanel.setVisible(true);
						}
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
			}
		}});
		button_1.setFont(new Font("Typoster", Font.PLAIN, 10));
		button_1.setBounds(59, 169, 80, 23);
		LibrarianLogin.add(button_1);
		
		JPanel AdminLogin = new JPanel();
		AdminLogin.setBackground(new Color(255, 255, 240));
		tabbedPane.addTab("Admin Login", null, AdminLogin, null);
		AdminLogin.setLayout(null);
		
		JLabel label_3 = new JLabel("Welcome to the Library");
		label_3.setFont(new Font("Typoster", Font.PLAIN, 13));
		label_3.setBounds(36, 32, 164, 14);
		AdminLogin.add(label_3);
		
		JLabel label_4 = new JLabel("E-Mail: ");
		label_4.setFont(new Font("Impact", Font.PLAIN, 15));
		label_4.setBounds(10, 81, 70, 14);
		AdminLogin.add(label_4);
		
		JLabel label_5 = new JLabel("Password: ");
		label_5.setFont(new Font("Impact", Font.PLAIN, 15));
		label_5.setBounds(10, 123, 100, 14);
		AdminLogin.add(label_5);
		
		adminPass = new JPasswordField();
		adminPass.setBounds(100, 122, 86, 20);
		AdminLogin.add(adminPass);
		
		adminMail = new JTextField();
		adminMail.setColumns(10);
		adminMail.setBounds(100, 80, 86, 20);
		AdminLogin.add(adminMail);
		
		JButton button_3 = new JButton("LOGIN");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adminMail.getText().length() == 0 || adminPass.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Please Enter Required Informations!");
				}
				else {
					try {
						Connection connect = con.database();
						Statement stat = connect.createStatement();
						ResultSet res = stat.executeQuery("SELECT * FROM Person  WHERE Status='Admin'" );
						while(res.next()) {
							admin admn = new admin();
							AdminPanel admnPanel = new AdminPanel();
							admn.setId(res.getInt("Id"));
							admn.setName(res.getString("Name"));
							admn.setSurname(res.getString("Surname"));
							admn.setEmail(res.getString("Email"));
							admn.setPassword(res.getString("Password"));
							admn.setBirthday(res.getDate("Birthday"));
							admn.setGender(res.getString("Gender"));
							admn.setStatus(res.getString("Status"));
							admnPanel.setVisible(true);
							dispose();
							}
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
			}
		}});
		button_3.setFont(new Font("Typoster", Font.PLAIN, 10));
		button_3.setBounds(57, 169, 80, 23);
		AdminLogin.add(button_3);
		
		JLabel lblbackground = new JLabel(new ImageIcon(getClass().getResource("librarylogin.png")));
		lblbackground.setBounds(0, 0, 500, 500);
		contentPane.add(lblbackground);
	}
}
