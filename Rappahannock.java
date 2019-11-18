public class Rappahannock extends ReservedParkingDeckPermit{

	

	int rappahannockPrice = 645;

	

	public Rappahannock(String passName, String destination) {

		super(passName, destination);

	}

	

	public int rappahannockYearPrice() {

		return rappahannockPrice;

	}

	

	//determine if will divide by only fall and spring semester?

	//currently rough estimate, 7 months for 2 semesters with 30 days

	public int rappahannockDayPrice() {

		return rappahannockPrice / 210; 

	}

	
}