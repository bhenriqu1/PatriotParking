import java.text.DecimalFormat;

public class EconomyPermit extends CarDriver2{
	
	double westCampusPrice = 175.0; //38.8327968, -77.3264524
	
	public EconomyPermit(String passName, String destination) {
		super(passName, destination);
	}
	
	
	public double westCampuYearPrice() {
		return westCampusPrice;
	}
	
	
	//currently rough estimate, 7 months for 2 semesters 
	public double westCampusDayPrice() {
		double price = westCampusPrice / 210.0;
		DecimalFormat df = new DecimalFormat("0.00");      
		price = Double.valueOf(df.format(price));
		
		
		return price; 
	}
	
	
	/*algorithm to determine distance from lot to destination
	public float distance() {
		return (Float) null;
	}*/


}
