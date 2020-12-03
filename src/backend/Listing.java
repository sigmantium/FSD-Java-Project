package backend;


/**
 * 
 * Property class used to hold details regarding an individual property.
 *
 */

public class Listing {
	
	private Integer id;
	private String address;
	private Integer price;
	private Integer roomCount;
	private Integer bathroomCount;
	private ListingType listingType;
	
	//constructor
	public Listing(Integer id, String address, Integer price,Integer roomCount,Integer bathroomCount,ListingType listingType) {
		// I've used this.<memberName> in this instances as all the parameters are named the same as the desired members.
		this.id = id;
		this.address = address;
		this.price = price;
		this.roomCount = roomCount;
		this.bathroomCount = bathroomCount;
		this.listingType = listingType;
	}
	
	
	//getters
	public Integer getId() {
		return id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public Integer getPrice() {
		return price;
	}

	public Integer getRoomCount() {
		return roomCount;
	}

	
	public Integer getBathroomCount() {
		return bathroomCount;
	}
	
	public ListingType getListingType() {
		return listingType;
	}
}
