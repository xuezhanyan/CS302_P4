
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
import java.util.ArrayList;

/**
 * This class maintains an ArrayList which stores places.
 *
 * @author Xuezhan Yan
 */
public class PlaceList {
	private ArrayList<Place> placeList; //list of elements in place type

	/**
	 * Constructs an empty list with an initial capacity of zero.
	 */
	public PlaceList() {
		placeList = new ArrayList<Place>();
	}

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * * @param place 
	 * 			the reference of new place elements will be added to the list
	 */
	public void add(Place place) {
		placeList.add(place);
	}

	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * * @param index 
	 * 			index of expected removed elements
	 */
	public void remove(int index) {
		placeList.remove(index);
	}

	/**
	 * Returns the number of elements in this list.
	 */
	public int size() {
		return placeList.size();
	}

	/**
	 * Returns true if this list contains any elements.
	 */
	public boolean hasPlaces() {
		return !placeList.isEmpty();
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index 
	 * 			index of expected removed elements
	 */
	public Place get(int index) {
		return placeList.get(index);
	}

	/**
	 * Returns true if this list contains the specified element.
	 * 
	 * @param place 
	 * 			specified place element 
	 */
	public boolean contains(Place place) {
		return placeList.contains((Place) place);
	}
}
