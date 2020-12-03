package gui;

import backend.Contract;
import backend.Portfolio;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;

//14137400 Calvin Wong Chung Ki 
public class AgreementSearchGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblAgent;
	private JLabel lblOwner;
	private JLabel lblNewLabel_1;
	private JTextField txtAgent;
	private JTextField textOwner;
	private ArrayList<Contract> contracts = new ArrayList<Contract>();

	public void addAgreement(String owner, String agent, Date start, Date expiry) {
		Contract a;
		a = new Contract();
		a.setOwner(owner);
		a.setAgent(agent);
		a.setStart(start);
		a.setExpiry(expiry);
		contracts.add(a);

	}

	// find agentName
	public void findAgentName(String agent) {
		int i;
		Contract a;
		for (i = 0; i < contracts.size(); i++) {
			a = contracts.get(i);
			if (a.getAgent().equals(agent)) {
				a.printAgreement();
				i++;

			}

		}

	}

	public void findOwnertName(String owner) {
		int i;
		Contract a;
		for (i = 0; i < contracts.size(); i++) {
			a = contracts.get(i);
			if (a.getOwner().equals(owner)) {
				a.printAgreement();
				i++;
				continue;
			}

		}

	}

	/**
	 * Create the frame.
	 */
	public AgreementSearchGUI() {
		setTitle("Contract Database");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 820, 307);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Search Contract Agreement");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(41, 11, 212, 37);
		contentPane.add(lblNewLabel);

		lblAgent = new JLabel("Agent");
		lblAgent.setForeground(Color.GREEN);
		lblAgent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAgent.setBackground(Color.BLACK);
		lblAgent.setBounds(41, 82, 212, 37);
		contentPane.add(lblAgent);

		lblOwner = new JLabel("Home Owner ");
		lblOwner.setForeground(Color.GREEN);
		lblOwner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOwner.setBackground(Color.BLACK);
		lblOwner.setBounds(41, 111, 212, 37);
		contentPane.add(lblOwner);

		lblNewLabel_1 = new JLabel("Please enter first name :");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(41, 50, 144, 37);
		contentPane.add(lblNewLabel_1);

		txtAgent = new JTextField();
		txtAgent.setBounds(263, 91, 152, 20);
		contentPane.add(txtAgent);
		txtAgent.setColumns(10);

		textOwner = new JTextField();
		textOwner.setColumns(10);
		textOwner.setBounds(263, 120, 152, 20);
		contentPane.add(textOwner);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Portfolio portfolio = new Portfolio();

				Date d1 = new Date("2019/03/24");
				Date d2 = new Date("2020/03/24");
				Date d3 = new Date("2020/01/16");
				Date d4 = new Date("2020/06/16");
				Date d5 = new Date("2020/02/28");
				Date d6 = new Date("2020/08/28");
				Date d7 = new Date("2019/12/26");
				Date d8 = new Date("2020/12/26");

				// like table
				portfolio.addAgreement("Joanne", "Calvin", d1, d2);
				portfolio.addAgreement("Lee", "Jonathan", d3, d4);
				portfolio.addAgreement("Colleen", "Elliot", d5, d6);
				portfolio.addAgreement("Taryn", "Calvin", d7, d8);

				String agentname = txtAgent.getText();
				portfolio.findAgentName(agentname);

				String owername = textOwner.getText();
				portfolio.findOwnertName(owername);

			}
		});
		btnSearch.setBounds(263, 155, 89, 23);
		contentPane.add(btnSearch);
	}
}
