
public class EconomyPermit extends CarDriver{
	
	int westCampusPrice = 175; //38.8327968, -77.3264524
	
	public EconomyPermit(String passName, String destination) {
		super(passName, destination);
	}
	
	public int westCampuYearPrice() {
		return westCampusPrice;
	}
	
	//determine if will divide by only fall and spring semester?
	//currently rough estimate, 7 months for 2 semesters with 30 days
	public int westCampusDayPrice() {
		return westCampusPrice / 210; 
	}
	
	
	/*algorithm to determine distance from lot to destination
	public float distance() {
		return (Float) null;
	}*/


}
