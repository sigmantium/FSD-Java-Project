package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Database;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainMenu(Database db) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Group CMP1 02 - 6");
		lblNewLabel.setBackground(UIManager.getColor("menu"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		
		JButton btnUserRegistration = new JButton("View User Registration");
		btnUserRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationGui frame = new RegistrationGui();
				frame.setVisible(true);
				//MainMenu.this.setVisible(false);
			}
		});
		
		JButton btnDisplayProperties = new JButton("View Display Properties");
		btnDisplayProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayProperties frame = new DisplayProperties(db);
				frame.setVisible(true);
				//MainMenu.this.setVisible(false);
			}
		});
		
		JButton btnAgreementSearch = new JButton("View Agreement Search");
		btnAgreementSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgreementSearchGUI frame = new AgreementSearchGUI();
				frame.setVisible(true);
				//MainMenu.this.setVisible(false);
			}
		});
		
		JButton btnDisplayProperties_1_1 = new JButton("Exit");
		btnDisplayProperties_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnDisplayProperties, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAgreementSearch, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnUserRegistration, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnDisplayProperties_1_1, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUserRegistration, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAgreementSearch, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDisplayProperties, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDisplayProperties_1_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(192))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
