import java.util.ArrayList;

public class CarDriver {
	
	//GUI with window builder and/or Java Swing
	
	//98 destinations based off of GMU Map
	//int destinationArray [];
	ArrayList destinationArray; //ArrayList with the 98 destinations on Fairfax GMU Campus
	int annualPassCost; //cost of parking pass
	String passName; //parking pass name
	String destination;
	int carpoolNumber; //number of people in car
	
	
	/**
	 * Constuctor with minimum user input of passName and 
	 * destination on Fairfax GMU Campus
	 * @param annualPassCost,  
	 */
	public CarDriver(String passName,String destination) {
		destinationArray = new ArrayList();
		this.passName = passName;
		this.destination = destination;
	}
	
	/**
	 * Constructor with additional carpool params
	 */
	public CarDriver(String passName,String destination, int carpoolNumber) {
		destinationArray = new ArrayList();
		this.passName = passName;
		this.destination = destination;
		this.carpoolNumber = carpoolNumber;
	}
	
	
	
	
}
