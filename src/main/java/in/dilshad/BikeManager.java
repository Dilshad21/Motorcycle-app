package in.dilshad;

import java.util.ArrayList;
import java.util.HashMap;

public class BikeManager {

	public static HashMap<String, BikeSpecification> bikes = new HashMap<String, BikeSpecification>();
	//Plate number - as key value
	
	static {
		// Sample 1	
		BikeSpecification bike1 = new BikeSpecification();
			
			bike1.brand = "Hero Honda";
			bike1.name = "Splendor";
			bike1.color = "blue";
			bike1.price = 30000;
			bike1.km = 96000;
			bike1.year = 2005;
			bike1.gear = true;
			
			HashMap<String, String> engine1 = new HashMap<String,String>();
			engine1.put("engineNo", "A2we34");
			engine1.put("vin","33452323");
			engine1.put("noPlate","TN-67A0000");
			
			bike1.engineDetails = engine1;
			
		//Sample 2	
		BikeSpecification bike2 = new BikeSpecification();
			bike2.brand = "TVS";
			bike2.name = "Victor";
			bike2.color = "Silver";
			bike2.price = 25000;
			bike2.km = 91000;
			bike2.year = 2011;
			bike2.gear = true;
			
			HashMap<String, String> engine2 = new HashMap<String,String>();
			engine2.put("engineNo", "A2eo34");
			engine2.put("vin","3345453");
			engine2.put("noPlate","TN-67A0001");
			
			bike2.engineDetails = engine2;
		
			bikes.put(engine1.get("noPlate") , bike1);
			bikes.put(engine2.get("noPlate") , bike2);
	}
	

	/**
	 * To add new bike along with its specifications
	 * @param plateNo
	 * @param newBike
	 */
	public static void addBike(String plateNo, BikeSpecification newBike) {
		bikes.put(plateNo,newBike);	
		//System.out.println(bikes);
	}
	
	
	/**
	 * To display the List of bikes available
	 */
	static void displayBikes() {
		for (BikeSpecification bikelist : bikes.values()) {
			System.out.println(bikelist);	
			}		
	}
	
	/**
	 * Plate number and revised price as input - Updates the price of the corresponding plate no. bike
	 * @param plateNo
	 * @param revisedPrice
	 */
	public static void priceRevision(String plateNo, int revisedPrice)
	{	
		if(validatePlateNo(plateNo)) {
		BikeSpecification bikeSpecification = bikes.get(plateNo);
		bikeSpecification.price  = revisedPrice;
		bikes.put(plateNo, bikeSpecification);
		System.out.println("Price successfull revised for" + plateNo );
		}
		else
			System.out.println("Invalid plate no.");
		
	}	
	
	/**
	 * Validates the availability of bike using plate number
	 * @param plateNo
	 * @return
	 */
	public static boolean validatePlateNo(String plateNo) {
		boolean isValid = false;
		for (String bikelist : bikes.keySet()) {
			if(bikelist.equals(plateNo)) {
				isValid = true;
				break;
			}
		}
		return isValid;
	}
	
	/**
	 * Returns the price of the bike when valid Plate no. is given as input
	 * @param plateNo
	 * @return
	 */
	public static int getPrice(String plateNo) {
		BikeSpecification bikeSpecification = bikes.get(plateNo);
		return bikeSpecification.price;
	}
		
	/**
	 * Return the whole document
	 * @return
	 */
	public static HashMap<String, BikeSpecification> getAllBikes() {
		return bikes;	
	}
	
	/**
	 * Removes the corresponding bike details when valid plate no. is passed
	 * @param plateNo
	 */
	public static void removeBike(String plateNo) {
		if(validatePlateNo(plateNo))
			bikes.remove(plateNo);
	}
}

