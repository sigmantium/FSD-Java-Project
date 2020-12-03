package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Database;
import backend.Listing;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

public class UpdateListingGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tf_Address;
	private JTextField tf_Price;
	private JSpinner sp_RoomCount;
	private JSpinner sp_BathroomCount;
	private JComboBox cb_ListingType;


	/**
	 * Create the frame.
	 */
	public UpdateListingGUI(Database db, Listing listing) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Listing");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 414, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_Price= new JLabel("Price:");
		lbl_Price.setBounds(20, 90, 58, 14);
		contentPane.add(lbl_Price);
		
		JButton btnUpdate = new JButton("Update");

		btnUpdate.setBounds(10, 264, 196, 31);
		contentPane.add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(228, 264, 196, 31);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setBounds(20, 53, 58, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Bedrooms:");
		lblNewLabel_3.setBounds(20, 127, 58, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Bathrooms:");
		lblNewLabel_3_1.setBounds(20, 173, 58, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Listing Type:");
		lblNewLabel_3_1_1.setBounds(20, 215, 71, 14);
		contentPane.add(lblNewLabel_3_1_1);
		
		tf_Address = new JTextField();
		tf_Address.setBounds(79, 53, 345, 20);
		tf_Address.setText(listing.getAddress());
		contentPane.add(tf_Address);
		tf_Address.setColumns(10);
		
		tf_Price = new JTextField();
		tf_Price.setColumns(10);
		tf_Price.setBounds(79, 87, 345, 20);
		tf_Price.setText(Integer.toString(listing.getPrice()));
		contentPane.add(tf_Price);
		
		sp_RoomCount = new JSpinner();
		sp_RoomCount.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		sp_RoomCount.setBounds(99, 124, 71, 20);
		sp_RoomCount.setValue(listing.getRoomCount());
		contentPane.add(sp_RoomCount);
		
		sp_BathroomCount = new JSpinner();
		sp_BathroomCount.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		sp_BathroomCount.setBounds(99, 170, 71, 20);
		sp_BathroomCount.setValue(listing.getBathroomCount());
		contentPane.add(sp_BathroomCount);
		
		cb_ListingType = new JComboBox();
		cb_ListingType.setModel(new DefaultComboBoxModel(new String[] {"sale", "rental"}));
		cb_ListingType.setBounds(99, 211, 71, 22);
		cb_ListingType.setSelectedItem(listing.getListingType().toString().toLowerCase());
		contentPane.add(cb_ListingType);
		
		// Clicking cancel button hides window and disposes of frame.
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
	
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				int intPrice=0;
				
				// Validation
				try {
					intPrice = Integer.parseInt(tf_Price.getText());
				}catch (NumberFormatException e){
					JOptionPane.showMessageDialog(contentPane, "Please enter a price in whole dollars only.");
					lbl_Price.setForeground(Color.RED);
				}
				try{
					Database.updateListing(listing.getId(), tf_Address.getText(), intPrice, Integer.parseInt(sp_RoomCount.getValue().toString()), Integer.parseInt(sp_BathroomCount.getValue().toString()), cb_ListingType.getSelectedItem().toString());
				}catch (Exception e) {
					e.printStackTrace();
				}finally {

					setVisible(false);
					dispose();
					
				}
			}
		});
		
	}
}
