public class Shenandoah extends ReservedParkingDeckPermit{

	

	int shenandoahPrice = 750;

	

	public Shenandoah(String passName, String destination) {

		super(passName, destination);

	}

	

	public int shenandoahYearPrice() {

		return shenandoahPrice;

	}

	

	//determine if will divide by only fall and spring semester?

	//currently rough estimate, 7 months for 2 semesters with 30 days

	public int shenandoahDayPrice() {

		return shenandoahPrice / 210; 

	}

	
}