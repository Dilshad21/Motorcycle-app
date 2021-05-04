package in.dilshad;

import java.util.HashMap;
//Project title: Second-hand motorcycle buying, selling & renting

public class BikeSpecification {
	public String brand;
	
	public String name;
	
	public String color;
	
	public int price;
	
	public int km;
	
	public int year;
	
	public boolean gear;
	
	public HashMap<String,String> engineDetails;

	

	@Override
	public String toString() {
		return "BikeSpecification [brand=" + brand + ", name=" + name + ", color=" + color + ", price=" + price
				+ ", km=" + km + ", year=" + year + ", gear=" + gear + ", engineDetails=" + engineDetails + "]";
	}
}

