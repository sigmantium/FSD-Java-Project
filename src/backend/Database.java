package backend;
// imported libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.*;



public class Database {

	// Connection Constants, This should probably be stored in an ini file or something.
	private static final String URL = "jdbc:mysql://localhost/fsd";
	private static final String USER = "fsd_user";
	private static final String PASSWORD = "fsd_password";
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	// Members on the Database Class
	private static Connection conn;
	
	// Constructor for DB class
	public Database() throws Exception {
		conn = getConnection();
	}
	
	// Creates the connection to the database and returns a Java Connection Class.
	public static Connection getConnection() throws Exception{

		try	{
			Class.forName(DRIVER_CLASS);
			Connection connection = DriverManager.getConnection(URL,USER,PASSWORD );	
			System.out.println("Database Connected.");
			return connection;
		}
		catch(SQLException e) {
			System.out.println("Database was unnable to connect: "+e);
		}
			
		// if all else fails return null
		return null;
	}
	// Closes the existing connection to the database.
	public void closeConnection() throws Exception{
		try{
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection was successfully closed.");
	}


	// First overload method for getting properties which accepts no params. Will return ALL properties.
	public static ArrayList<Listing> getListings() throws Exception{
		ArrayList<Listing> returnArray = new ArrayList<Listing>();
		try {
			Statement statement = conn.createStatement();
			ResultSet results = 
					statement.executeQuery(
							"SELECT * FROM listings"
							);
			while(results.next())
			{
				Listing listing = new Listing(
						results.getInt("id"),
						results.getString("address"),
						results.getInt("price"),
						results.getInt("roomCount"),
						results.getInt("bathroomCount"),
						ListingType.valueOf(results.getString("listingType"))
						);
				returnArray.add(listing);
			}
			return returnArray;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		

		return null;
	}
	
	// Second overload for getListings() based on supplied filter requirements from the form.
	public static ArrayList<Listing> getListings(Integer minPrice, Integer maxPrice, Integer roomCount, Integer bathroomCount, String listingType) throws Exception{
		ArrayList<Listing> returnArray = new ArrayList<Listing>();
		try {
			String query = "SELECT * FROM listings";
			ArrayList<String> queryBuilder = new ArrayList<String>();
			
			/**
			 *  Logic for building the SQL query based on the filters supplied by the GUI
			 *  I find it annoying that java only compares the primatives and doesn't consider existing vs null
			 *  validation of entries would be done on the UI
			 */
			if( minPrice != null && minPrice != 0 ) {
				queryBuilder.add("price>"+minPrice.toString());
			}
			if( maxPrice != null && maxPrice != 0 ) {
				queryBuilder.add("price<"+maxPrice.toString());
			}
			if( roomCount != null && roomCount != 0 ) {
				queryBuilder.add("roomCount>="+roomCount.toString());
			}
			if( bathroomCount != null && bathroomCount != 0 ) {
				queryBuilder.add("bathroomCount>="+bathroomCount.toString());
			}
			if( listingType.toLowerCase().equals("sale") ) {
				queryBuilder.add("listingType='sale'");
			}
			if( listingType.toLowerCase().equals("rental") ) {
				queryBuilder.add("listingType='rental'");
			}
			
			if(queryBuilder.size() > 0) {
				query+=" WHERE ";
				
				for(int i = 0; i < queryBuilder.size(); i++) {
					query += queryBuilder.get(i);
					if( i < queryBuilder.size()-1 ) {
						query += " AND ";
					}
				}
			}
			
			
			Statement statement = conn.createStatement();
			System.out.println(query);
			ResultSet results = 
					statement.executeQuery(query);
			while(results.next())
			{
				Listing property = new Listing(
						results.getInt("id"),
						results.getString("address"),
						results.getInt("price"),
						results.getInt("roomCount"),
						results.getInt("bathroomCount"),
						ListingType.valueOf(results.getString("listingType"))
						);
				returnArray.add(property);
			}
			return returnArray;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		

		return null;
	}
	
	// CREATE Listing in database
		public static boolean createListings(String address, Integer price, Integer roomCount, Integer bathroomCount, String listingType) throws Exception{
			try {
				PreparedStatement posted = conn.prepareStatement("INSERT INTO listings (address, price, roomCount, bathroomCount, listingType) VALUES('"+address+"', '"+price+"', '"+roomCount+"', '"+bathroomCount+"', '"+listingType+"')");
				posted.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				System.out.println("Listing successfully added.");
			}
			

			return true;
		}
		
		// DELETE Listing in database
				public static boolean deleteListings( Integer id ) throws Exception{
					try {
						PreparedStatement posted = conn.prepareStatement("DELETE FROM listings WHERE id="+id);
						posted.executeUpdate();
					}
					catch (SQLException e) {
						e.printStackTrace();
						return false;
					} finally {
						System.out.println("Listing "+id+" successfully delted.");
					}
					

					return true;
				}
				
				// UPDATE listing in database
				public static boolean updateListing(Integer id, String address, Integer price, Integer roomCount, Integer bathroomCount, String listingType) throws Exception{
					try {
						/**
						 *  Updates every column, but in a large database that might be expensive,
						 *  it would be better to filter to only those columns
						 *  which have actually changed.
						 */
						PreparedStatement posted = conn.prepareStatement("UPDATE listings SET address ='"+address+"', price='"+price+"', roomCount='"+roomCount+"', bathroomCount='"+bathroomCount+"', listingType='"+listingType+"' WHERE id='"+id+"'");
						posted.executeUpdate();
					}
					catch (SQLException e) {
						e.printStackTrace();
						return false;
					} finally {
						System.out.println("Listing "+id+" successfully updated.");
					}
					

					return true;
				}
}//end of class
