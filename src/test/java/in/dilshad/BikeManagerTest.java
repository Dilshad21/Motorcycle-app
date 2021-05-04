package in.dilshad;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class BikeManagerTest {

	@Test
	public void testAddingBike() {
		BikeSpecification bike3 = new BikeSpecification();

		bike3.brand = "Bajaj";
		bike3.name = "Sprit";
		bike3.color = "gray";
		bike3.price = 15000;
		bike3.km = 16000;
		bike3.year = 2000;
		bike3.gear = false;

		HashMap<String, String> engine3 = new HashMap<String, String>();
		engine3.put("engineNo", "A64e34");
		engine3.put("vin", "3340000");
		engine3.put("noPlate", "TN-89A1111");

		bike3.engineDetails = engine3;
		// System.out.println(engine3.get("noPlate"));
		BikeManager.addBike(engine3.get("noPlate"), bike3);

		BikeManager.displayBikes();

	}

	@Test
	public void testValidation() {
		boolean a = BikeManager.validatePlateNo("TN-67A0000");
		assertTrue(a);
	}

	@Test
	public void testPriceRevision() {

		String plateNo = "TN-67A0000";
		int price = 35000;

		boolean a = BikeManager.validatePlateNo(plateNo);
		assertTrue(a);
		if (a) {
			BikeManager.priceRevision(plateNo, price);
			int revisedPrice = BikeManager.getPrice(plateNo);
			assertEquals(price, revisedPrice);
		}
	}

	@Test
	public void testCount() {
		HashMap<String, BikeSpecification> allBikes = BikeManager.getAllBikes();
		assertEquals(2, allBikes.size());
		BikeManager.displayBikes();
		allBikes.remove("TN-67A0000");
		assertEquals(1, allBikes.size());
		BikeManager.displayBikes();
	}

}
