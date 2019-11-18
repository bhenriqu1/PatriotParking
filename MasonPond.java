public class MasonPond extends ReservedParkingDeckPermit{

	

	int masonPondPrice = 700;

	

	public MasonPond(String passName, String destination) {

		super(passName, destination);

	}

	

	public int masonPondYearPrice() {

		return masonPondPrice;

	}

	

	//determine if will divide by only fall and spring semester?

	//currently rough estimate, 7 months for 2 semesters with 30 days

	public int masonPondDayPrice() {

		return masonPondPrice / 210; 

	}

	
}