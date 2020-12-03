package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import backend.Registration;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegistrationGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -429904782598555446L;
	private JPanel contentPane;
	private JTextField textLastName;
	private JTextField textFirstName;
	private JTextField textAddress;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textUsername;
	private JTextField textPassword;

	/**
	 * Create the frame.
	 */
	public RegistrationGui() {
		
		setBackground(Color.GRAY);
		setTitle("Registration ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 698, 414);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Best Real Estate Registration Form");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(194, 20, 348, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(52, 71, 77, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(52, 110, 88, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(52, 146, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone");
		lblNewLabel_4.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(52, 188, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(52, 226, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Set Username");
		lblNewLabel_6.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(52, 264, 110, 24);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Set Password");
		lblNewLabel_7.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(52, 300, 128, 24);
		contentPane.add(lblNewLabel_7);
		
		textLastName = new JTextField();
		textLastName.setFont(new Font("Helvetica", Font.PLAIN, 13));
		textLastName.setBounds(162, 110, 348, 26);
		contentPane.add(textLastName);
		textLastName.setColumns(10);
		
		textFirstName = new JTextField();
		textFirstName.setFont(new Font("Helvetica", Font.PLAIN, 13));
		textFirstName.setColumns(10);
		textFirstName.setBounds(162, 70, 348, 26);
		contentPane.add(textFirstName);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Helvetica", Font.PLAIN, 13));
		textAddress.setColumns(10);
		textAddress.setBounds(162, 142, 348, 26);
		contentPane.add(textAddress);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("Helvetica", Font.PLAIN, 13));
		textPhone.setColumns(10);
		textPhone.setBounds(162, 182, 348, 26);
		contentPane.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Helvetica", Font.PLAIN, 13));
		textEmail.setColumns(10);
		textEmail.setBounds(162, 220, 348, 26);
		contentPane.add(textEmail);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Helvetica", Font.PLAIN, 13));
		textUsername.setColumns(10);
		textUsername.setBounds(162, 262, 348, 26);
		contentPane.add(textUsername);
		
		textPassword = new JTextField();
		textPassword.setFont(new Font("Helvetica", Font.PLAIN, 13));
		textPassword.setColumns(10);
		textPassword.setBounds(162, 298, 348, 26);
		contentPane.add(textPassword);
		
		JButton Register = new JButton("Register");
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create the registration object from the Registration class
				Registration newReg = new Registration( textFirstName.getText(), textLastName.getText(), textAddress.getText(), textPhone.getText(), textEmail.getText(), textUsername.getText(), textPassword.getText());
				String msg;
				msg = "Registration has been created with First Name: " + textFirstName.getText() + "\n";
				msg+= "and Last Name: " + textLastName.getText() + "\n";
				msg+= "and Address: " + textAddress.getText() + "\n";
				msg+= "and Phone: " + textPhone.getText() + "\n";
				msg+= "and Email: " + textEmail.getText() + "\n";
				msg+= "and Username: " + textUsername.getText() + "\n";
				msg+= "and Password: " + textPassword.getText() + "\n";
				System.out.println(msg);
			}
		});
		Register.setForeground(Color.BLACK);
		Register.setFont(new Font("Helvetica", Font.PLAIN, 13));
		Register.setBounds(214, 336, 117, 29);
		contentPane.add(Register);
		
		JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Registration has not been created");
				setVisible(false);
				dispose();
			}
		});
		Cancel.setForeground(Color.BLACK);
		Cancel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		Cancel.setBounds(355, 335, 117, 29);
		contentPane.add(Cancel);
	}
}
