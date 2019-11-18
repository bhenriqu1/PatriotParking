public class ReservedParkingDeckPermit extends CarDriver{

	public ReservedParkingDeckPermit(String passName, String destination) {

		super(passName, destination);

	}
   //ReservedParkingDeckPermit does not have yearPrice() or dayPrice() here because the price is different in Lot I and Lot J
   //it will be in the subClass
	//algorithm to determine distance from lot to destination

	public float distance() {

		return (Float) null;

	}



}