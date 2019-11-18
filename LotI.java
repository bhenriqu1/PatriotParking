public class LotI extends ReservedLotPermit{

	

	int lotIPrice = 625;
	

	public LotI(String passName, String destination) {

		super(passName, destination);

	}

	

	public int lotIPrice() {

		return lotIPrice;

	}

	

	//determine if will divide by only fall and spring semester?

	//currently rough estimate, 7 months for 2 semesters with 30 days

	public int lotIDayPrice() {

		return lotIPrice / 210; 

	}

	
}
