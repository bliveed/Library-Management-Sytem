package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import Human.Librarian;
import Human.admin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField regName;
	private JTextField regSurname;
	private JTextField regMail;
	private JTextField regPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Registration Panel");
		lblNewLabel.setFont(new Font("Typoster", Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 23, 333, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(61, 61, 357, 357);
		contentPane.add(panel);
		
		JLabel label = new JLabel("New User");
		label.setFont(new Font("Impact", Font.PLAIN, 15));
		label.setBounds(10, 22, 93, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setBounds(10, 82, 80, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Surname:");
		label_2.setBounds(10, 107, 80, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("E-mail:");
		label_3.setBounds(10, 132, 80, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Password:");
		label_4.setBounds(10, 157, 69, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Birthday:");
		label_5.setBounds(10, 182, 80, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Gender:");
		label_6.setBounds(10, 207, 80, 14);
		panel.add(label_6);
		
		regName = new JTextField();
		regName.setColumns(10);
		regName.setBounds(100, 79, 195, 20);
		panel.add(regName);
		
		regSurname = new JTextField();
		regSurname.setColumns(10);
		regSurname.setBounds(100, 104, 195, 20);
		panel.add(regSurname);
		
		regMail = new JTextField();
		regMail.setColumns(10);
		regMail.setBounds(100, 129, 195, 20);
		panel.add(regMail);
		
		regPass = new JTextField();
		regPass.setColumns(10);
		regPass.setBounds(100, 154, 195, 20);
		panel.add(regPass);
		
		JRadioButton regF = new JRadioButton("Female");
		regF.setBackground(new Color(245, 255, 250));
		regF.setBounds(96, 203, 69, 23);
		panel.add(regF);
		
		JRadioButton regM = new JRadioButton("Male");
		regM.setBackground(new Color(245, 255, 250));
		regM.setBounds(226, 203, 69, 23);
		panel.add(regM);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(100, 182, 195, 20);
		panel.add(dateChooser);
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTimezoneOffset());

		JButton btnRegster = new JButton("REGISTER");
		btnRegster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(regMail.getText().length() == 0 || regPass.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Please Enter Required Informations!");
				}
				else {
					try {	
							Librarian lib = new Librarian();
							String name = regName.getText();
							String surname = regSurname.getText();
							String email = regMail.getText();
							String password = regPass.getText();

							String gender;
								if(regF.isSelected()) {
									regM.setSelected(false);
									gender= "Female";
								}
								else {
									regF.setSelected(false);
									regM.setSelected(true);
									gender="Male";
								}
							 
							String status = "User";
							String query ="";
							lib.addUser(name,surname,email,password,sqlDate,gender);
							JOptionPane.showMessageDialog(null, "New User Added Succesfully!");

							}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
			}
			}
			
		});
		btnRegster.setBounds(111, 289, 140, 23);
		panel.add(btnRegster);
	}
}
