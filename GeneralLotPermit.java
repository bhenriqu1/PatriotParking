public class GeneralLotPermit extends CarDriver{

	

	int generalLotPrice = 400;

	

	public GeneralLotPermit(String passName, String destination) {

		super(passName, destination);

	}

	

	public int generalLotYearPrice() {

		return generalLotPrice;

	}

	

	//determine if will divide by only fall and spring semester?

	//currently rough estimate, 7 months for 2 semesters with 30 days

	public int generalLotDayPrice() {

		return generalLotPrice / 210; 

	}

	

	

	//algorithm to determine distance from lot to destination

	public float distance() {

		return (Float) null;

	}



}