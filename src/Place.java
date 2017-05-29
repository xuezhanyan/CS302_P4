
// Title:            Places
// Files:            Places.java, PlacesList.java, MyPlacesApp.java
// Semester:         (302) Fall 2016
//
// Author:           Xuezhan Yan
// Email:            xyan56@wisc.edu
// CS Login:         xuezhan
// Lecturer's Name:  Williams, James S.
// Lab Section:      311
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:     No Partner
// Partner Email:     
// Partner CS Login: 
// Lecturer's Name:  
// Lab Section:      
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//    _X_ Write-up states that Pair Programming is allowed for this assignment.
//    _X_ We have both read the CS302 Pair Programming policy.
//    _X_ We have registered our team prior to the team registration deadline.
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This class represents a place contains its name and address.
 *
 * @author Xuezhan Yan
 */
public class Place {
	private String name; // name of the place
	private String address; // address of the place

	/**
	 * Constructs an instance of place type with specific name and address
	 * 
	 * @param name
	 *            string contains name of this place
	 * @param address
	 *            string contains address of this place
	 */
	public Place(String name, String address) {
		this.name = name;
		this.address = address;
	}

	/**
	 * Returns the name of this element.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the address of this element.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Compare one place with another by comparing their address and name
	 * 
	 * @param obj
	 *            object that want to compare with this place instance
	 */
	@Override
	public boolean equals(Object obj) {
		// check whether obj is Place class type
		if (obj instanceof Place) {
			Place place = (Place) obj;
			if (place.name.equalsIgnoreCase(this.name))
				return true;
		}
		return false;
	}

}
