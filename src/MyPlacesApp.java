
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
import java.util.Scanner;
import java.io.*;

/**
 * (This program provides a way to create, store and retrieve lists of places.
 * Each place has a name and address. The program can load places from one or
 * more files, the user can add, edit and delete these places and then save a
 * list of places to a file. Optionally, you may extend this project to utilize
 * Google's Geocoding service and Gson library to find the latitude and
 * longitude for an address and then order the places by distance.)
 *
 * @author Xuezhan Yan
 */
public class MyPlacesApp {
	/**
	 * This is the main method for application of myplace.There is a menu in
	 * this method contains functions of add, remove, delete, read, write and
	 * show place.
	 * 
	 * @param args
	 *            command line input. No need in this program. 
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		PlaceList placeList = new PlaceList();
		do {
			System.out.println("");
			System.out.println("My Places 2016");
			System.out.println("--------------------------");
			// different print out depending on whether there is place in the
			// list
			if (!placeList.hasPlaces())
				System.out.println("No places in memory.");
			else {
				for (int i = 0; i < placeList.size(); i++) {
					System.out
							.println(i + 1 + ") " + placeList.get(i).getName());
				}
			}
			System.out.println("--------------------------");
			// different print out depending on whether there is place in the
			// list
			if (!placeList.hasPlaces())
				System.out.print("A)dd R)ead Q)uit: ");
			else {
				System.out.print("A)dd S)how D)elete R)ead W)rite Q)uit: ");
			}
			// menu
			String choice = scan.nextLine().trim();
			switch (choice) {
			// add new place to list
			case "a":
			case "A":
				System.out.print("Enter the name: ");
				String name = scan.nextLine();
				System.out.print("Enter the address: ");
				String address = scan.nextLine();
				Place place = new Place(name, address);
				placeList.add(place);
				System.out.println("Adding: " + name);
				System.out.print("Press Enter to continue.");
				break;
			// show specified place
			case "s":
			case "S":
				System.out.print("Enter number of place to Show: ");
				int showIndex = scan.nextInt();
				scan.nextLine();
				if ((showIndex > 0) && (showIndex <= placeList.size())) {
					System.out.println(placeList.get(showIndex - 1).getName());
					System.out
							.println(placeList.get(showIndex - 1).getAddress());
				} else
					System.out.println("Expected a number between 1 and "
							+ placeList.size() + ".");
				System.out.print("Press Enter to continue.");
				break;
			// delete specified place
			case "d":
			case "D":
				System.out.print("Enter number of place to Delete: ");
				int delectIndex = scan.nextInt();
				scan.nextLine();
				if ((delectIndex > 0) && (delectIndex <= placeList.size())) {
					System.out.println("Deleting: "
							+ placeList.get(delectIndex - 1).getName());
					placeList.remove(delectIndex - 1);
				} else
					System.out.println("Expected a number between 1 and "
							+ placeList.size() + ".");
				System.out.print("Press Enter to continue.");
				break;
			// read place
			case "r":
			case "R":
				System.out.println("My Places Files: ");
				printFileList();
				System.out.println("");
				System.out.print("Enter filename: ");
				String fileName = scan.nextLine();
				System.out.println("Reading file: " + fileName);
				scanFile(fileName, placeList);
				System.out.print("Press Enter to continue.");
				break;
			// write place
			case "w":
			case "W":
				System.out.println("My Places Files: ");
				printFileList();
				System.out.println("");
				System.out.print("Enter filename: ");
				String writeFileName = scan.nextLine();
				System.out.println("Writing file: " + writeFileName);
				writeFile(writeFileName, placeList);
				System.out.print("Press Enter to continue.");
				break;
			// quit
			case "q":
			case "Q":
				System.out.println("Thank you for using My Places 2016!");
				// used for terminate the program
				System.exit(0);
				break;
			// other wrong input
			default:
				System.out.println("Unrecognized choice: " + choice);
				System.out.print("Press Enter to continue.");
				break;
			}
		} while (scan.nextLine() != "");
	}

	/**
	 * Show the list of files ending with the ".mp" file extension. In this
	 * program, the path will expect to look for the current, which is typically
	 * the project directory in Eclipse.
	 */
	public static void printFileList() {
		File folder = new File(".");
		for (File file : folder.listFiles()) {
			if (file.getName().endsWith(".mp")) {
				System.out.println(" " + file.getName());
			}
		}
	}

	/**
	 * Read places from a file into the list of places in memory. If a place
	 * being read in already exists in the list in memory, by comparing the name
	 * case-insensitively, then a message is displayed and the place is not
	 * added. This method can also catch any FileNotFoundExceptions. If a
	 * FileNotFoundException is caught then the message "Unable to read from
	 * file: <name of file>" should be printed to the console, substituting in
	 * the actual name of the file.
	 * 
	 * @param fileName
	 *            string contains the name of the file will be written from
	 * @param placeList
	 *            list in memory contains places that will be written
	 */
	public static void scanFile(String fileName, PlaceList placeList)
			throws IOException {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			Scanner scan = new Scanner(fis);
			while (scan.hasNextLine()) {
				String[] nameAndaddress = scan.nextLine().split(";");
				Place newPlace = new Place(nameAndaddress[0],
						nameAndaddress[1]);
				// add first elements
				if (!placeList.hasPlaces())
					placeList.add(newPlace);
				else {
					// compare whether there are the same place existing
					for (int i = 0; i < placeList.size(); i++) {
						if (newPlace.equals(placeList.get(i))) {
							System.out.println(
									newPlace.getName() + " already in list.");
							break;
						}
						if (i == placeList.size() - 1) {
							placeList.add(newPlace);
							break;
						}
					}
				}
			}
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to read from file: " + fileName);
		}
	}

	/**
	 * Writes the list of places in memory to a specified file in the specified
	 * format. If a FileNotFoundException is caught when writing the file then
	 * print the message "Unable to write to file: <name of file>", substituting
	 * in the name of the file.
	 * 
	 * @param writeFileName
	 *            string contains the name of the file will be written to
	 * @param placeList
	 *            list in memory contains places that will be written
	 */
	public static void writeFile(String writeFileName, PlaceList placeList) {
		try {
			FileOutputStream fos = new FileOutputStream(writeFileName);
			PrintWriter pw = new PrintWriter(fos);
			for (int i = 0; i < placeList.size(); i++) {
				pw.println(placeList.get(i).getName() + ";"
						+ placeList.get(i).getAddress());
			}
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to write to file: " + writeFileName);
		}
	}
}
