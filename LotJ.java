public class LotJ extends ReservedLotPermit{

	

	int lotJPrice = 565;

	

	public LotJ(String passName, String destination) {

		super(passName, destination);

	}

	

	public int lotJPrice() {

		return lotJPrice;

	}

	

	//determine if will divide by only fall and spring semester?

	//currently rough estimate, 7 months for 2 semesters with 30 days

	public int lotJDayPrice() {

		return lotJPrice / 210; 

	}

	
}