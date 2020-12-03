package gui;
import backend.Database;
import backend.Listing;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;

public class DisplayProperties extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup listingType = new ButtonGroup();
	private JTextField tf_minPrice;
	private JTextField tf_maxPrice;
	private JSlider slider_Page;
	private ArrayList<Listing> propertyArray;
	
	/**
	 * Used to limit the number of properties to display.
	 * If you were going to support variable display size 
	 * you would likely have this as a variable which scales
	 * dependant on the size of the users screen
	 */
	final int maxPropertiesToDisplay = 7; 
	
	// currentPage is used to work the pagination system. 
	int currentPage = 0;


	/**
	 * Create the frame.
	 */
	public DisplayProperties(Database db) {
		
		setTitle("Search and Display Property Listings");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 752, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Filter:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Listing Type:");
		lblNewLabel_1.setBounds(10, 36, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdBtn_Listing_Sale = new JRadioButton("Sale");
		listingType.add(rdBtn_Listing_Sale);
		rdBtn_Listing_Sale.setBounds(93, 32, 56, 23);
		contentPane.add(rdBtn_Listing_Sale);
		
		JRadioButton rdBtn_Listing_Rental = new JRadioButton("Rental");
		listingType.add(rdBtn_Listing_Rental);
		rdBtn_Listing_Rental.setBounds(151, 32, 61, 23);
		contentPane.add(rdBtn_Listing_Rental);
		
		JRadioButton rdBtn_Listing_Both = new JRadioButton("Both");
		listingType.add(rdBtn_Listing_Both);
		rdBtn_Listing_Both.setSelected(true);
		rdBtn_Listing_Both.setBounds(214, 32, 55, 23);
		contentPane.add(rdBtn_Listing_Both);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price:");
		lblNewLabel_1_1.setBounds(10, 61, 61, 14);
		contentPane.add(lblNewLabel_1_1);
		
		tf_minPrice = new JTextField();
		tf_minPrice.setBounds(43, 80, 86, 20);
		contentPane.add(tf_minPrice);
		tf_minPrice.setColumns(10);
		
		tf_maxPrice = new JTextField();
		tf_maxPrice.setColumns(10);
		tf_maxPrice.setBounds(157, 80, 86, 20);
		contentPane.add(tf_maxPrice);
		
		JLabel lbl_MinPrice = new JLabel("MIN:");
		lbl_MinPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MinPrice.setBounds(63, 61, 46, 14);
		contentPane.add(lbl_MinPrice);
		
		JLabel lbl_MaxPrice = new JLabel("MAX:");
		lbl_MaxPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MaxPrice.setBounds(177, 61, 46, 14);
		contentPane.add(lbl_MaxPrice);
		
		JLabel lblNewLabel_3 = new JLabel("to");
		lblNewLabel_3.setBounds(130, 83, 27, 14);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 145, 716, 14);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Min Bedrooms:");
		lblNewLabel_1_1_1.setBounds(283, 46, 99, 14);
		contentPane.add(lblNewLabel_1_1_1);

		
		slider_Page = new JSlider();
		/**
		 * This is the event that listens for when the pageination slider has changed value.
		 */
		slider_Page.addChangeListener(new ChangeListener() {
	      public void stateChanged(ChangeEvent event) {
	    	  int value = slider_Page.getValue();
	    	  if( value != currentPage ) {
		    	  currentPage = value;
		    	  clearScreen( contentPane );	
		    	  buildPropertyList(db, contentPane, currentPage, propertyArray);
	    	  }
	      }
	    });
		slider_Page.setPaintTicks(true);
		slider_Page.setSnapToTicks(true);
		slider_Page.setPaintLabels(true);
		slider_Page.setValue(currentPage);
		slider_Page.setMinorTickSpacing(1);
		slider_Page.setMajorTickSpacing(1);
		slider_Page.setBounds(107, 918, 619, 43);
		contentPane.add(slider_Page);
		
		JSpinner sp_Bedrooms = new JSpinner();
		sp_Bedrooms.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		sp_Bedrooms.setBounds(392, 46, 104, 20);
		contentPane.add(sp_Bedrooms);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Min Bathrooms:");
		lblNewLabel_1_1_1_1.setBounds(283, 80, 99, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JSpinner sp_Bathrooms = new JSpinner();
		sp_Bathrooms.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		sp_Bathrooms.setBounds(392, 80, 104, 20);
		contentPane.add(sp_Bathrooms);
		
		JLabel lblNewLabel_4 = new JLabel("Page:");
		lblNewLabel_4.setBounds(10, 924, 61, 26);
		contentPane.add(lblNewLabel_4);
		
		
		
		JButton btnAddListing = new JButton("Add Listing");
		btnAddListing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddListingGUI frame = new AddListingGUI(db);
				frame.setVisible(true);
			}
		});
		btnAddListing.setBounds(625, 7, 89, 23);
		contentPane.add(btnAddListing);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
				propertyArray = Database.getListings();
		    	clearScreen( contentPane );	
		    	buildPropertyList(db, contentPane, currentPage, propertyArray);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(625, 36, 89, 23);
		contentPane.add(btnRefresh);
		
		JButton btn_filterProperties = new JButton("FILTER");
		btn_filterProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
					Integer intMinPrice = 0;
					if(!tf_minPrice.getText().isBlank()) {
						intMinPrice = Integer.parseInt(tf_minPrice.getText());
					}
					
					Integer intMaxPrice = 0;
					if(!tf_maxPrice.getText().isBlank()) {
						intMaxPrice = Integer.parseInt(tf_maxPrice.getText());
					}
					
					Integer intBedrooms = Integer.parseInt(sp_Bedrooms.getValue().toString());
					Integer intBathrooms = Integer.parseInt(sp_Bathrooms.getValue().toString());
					String strListingType = getSelectedButtonText(listingType);
					
					// validate entries
					if( !tf_minPrice.getText().isBlank() && !tf_maxPrice.getText().isBlank()) {
						intMinPrice = Integer.parseInt(tf_minPrice.getText());
						intMaxPrice = Integer.parseInt(tf_maxPrice.getText());
						if( intMinPrice  >  intMaxPrice ) {
							JOptionPane.showMessageDialog(contentPane, "Minimum price must be less that Maximum price.");
							lbl_MinPrice.setForeground(Color.RED);
							return;
						}
					}
			
				// clear current view
				clearScreen( contentPane );
				
				//clear the property array and get listings again.
				propertyArray.clear();
				try {
					propertyArray = Database.getListings(intMinPrice, intMaxPrice, intBedrooms, intBathrooms, strListingType);
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				// set the page back to 0 and display results.
				currentPage = 0;
				slider_Page.setValue(0);
				buildPropertyList(db, contentPane, currentPage, propertyArray);
				
			}
		});
		btn_filterProperties.setBounds(43, 111, 453, 23);
		contentPane.add(btn_filterProperties);
		
		// First database load when the page is first drawn.
		try {
			propertyArray = Database.getListings();
			buildPropertyList(db, contentPane, currentPage, propertyArray);				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	//Clears all property tiles from the lower section and forces a repaint.
	private void clearScreen( JPanel contentPane ) {
		System.out.println("Refreshing Screen.");
		//Get the components in the panel
		for( Component c : contentPane.getComponents() ) {
			if( c.getName() == "propertyPanel") {
				contentPane.remove(c);
			}
		}
		
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	private void buildPropertyList(Database db, JPanel contentPane, int page, ArrayList<Listing> propertyArray) {
		
		// Calculate the number of pages
		int pageCount = propertyArray.size() / maxPropertiesToDisplay;
		int startingProperty = page * maxPropertiesToDisplay;
		int position = 0;
		slider_Page.setValue(page);
		slider_Page.setMaximum(pageCount);

		/**
		 * We create a new JPanel as a container for all the properties.
		 * This makes it easier to find and delete the propertyPanel
		 * when we need to clear the list of properties for redraw
		 */
		JPanel propertyPanel = new JPanel();
		propertyPanel.setBounds(0, 156, 716, 762);
		propertyPanel.setName("propertyPanel");
		propertyPanel.setLayout(null);
		contentPane.add(propertyPanel);
		
		/**
		 * This section of the code iterates over the array of properties.
		 * Starting with startingProperty which is calculated by the users
		 * current page * the max number of properties the screen can display.
		 * With each property drawn it increments the position which moves
		 * the next property down the y axis.
		 */
		for ( int i = startingProperty; i < (startingProperty+maxPropertiesToDisplay); i++) {
			propertyContainerTemplate(db, propertyPanel, position, propertyArray.get(i) );
			position++;
		}
	}
	
	// Creates a property tile from this template at the position supplied for property object passed.
	private void propertyContainerTemplate(Database db, JPanel contentPane, int position, Listing property ) {
		if ( position > maxPropertiesToDisplay ) {
			System.out.println(" Somehow too many properties were sent to the template: "+Integer.toString(position));
			return;
		}
		
		int x = 25;
		int y = position * 110; // if new lines are added down the track the *110 will need to be adjusted to allow additional height
		JLabel prop_lbl_property_Address = new JLabel("House Number: "+property.getAddress());
		prop_lbl_property_Address.setBounds(x, y, 686, 14);
		contentPane.add(prop_lbl_property_Address);
		JButton btn_updateProperty = new JButton("UPDATE");
		btn_updateProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				UpdateListingGUI frame = new UpdateListingGUI(db, property);
				frame.setVisible(true);
			}
		});
		btn_updateProperty.setBounds(610, y, 100, 23);
		contentPane.add(btn_updateProperty);
		
		
		y+=25;//increments line position in case we need to add stuff further down the track 
		JLabel prop_lbl_property_price = new JLabel("Property Price:"+property.getPrice());
		prop_lbl_property_price.setBounds(x, y, 686, 14);
		contentPane.add(prop_lbl_property_price);
		JButton btn_deleteProperty = new JButton("DELETE");
		btn_deleteProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you use you want to delete property "+property.getAddress()+" ?","Warning",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					try {
					Database.deleteListings( property.getId());
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						//After deleting the record refresh the screen
						try {
							propertyArray = Database.getListings();
					    	clearScreen( contentPane );	
					    	buildPropertyList(db, contentPane, currentPage, propertyArray);
							}catch(Exception e) {
								e.printStackTrace();
							}
						
					}
				}
			}
			});
		btn_deleteProperty.setBounds(610, y, 100, 23);
		contentPane.add(btn_deleteProperty);

		y+=25;
		JLabel prop_lbl_property_postcode = new JLabel("Listing Type:"+property.getListingType().toString());
		prop_lbl_property_postcode.setBounds(x, y, 686, 14);
		contentPane.add(prop_lbl_property_postcode);

		y+=25;
		JLabel prop_lbl_property_features = new JLabel("Contains "+property.getRoomCount()+" Bedrooms and "+property.getBathroomCount()+" Bathrooms.");
		prop_lbl_property_features.setBounds(x, y, 686, 14);
		contentPane.add(prop_lbl_property_features);

		y+=25;
		JSeparator prop_sep_property = new JSeparator();
		prop_sep_property.setBounds(x-15, y, 716, 14);
		contentPane.add(prop_sep_property);
	}
	
	// I didn't write this it came from: https://stackoverflow.com/questions/201287/how-do-i-get-which-jradiobutton-is-selected-from-a-buttongroup
	    public String getSelectedButtonText(ButtonGroup buttonGroup) {
	        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }

	        return null;
	    }
}
