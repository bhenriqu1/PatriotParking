import java.text.DecimalFormat;

public class LotJ extends ReservedLotPermit{

	

	double lotJPrice = 565.0;

	

	public LotJ(String passName, String destination) {

		super(passName, destination);

	}

	
   /**
    * @param carpoolNumber number of people carpooling one vehicle
    * @return the permit price that the vehicle owner will actually pay
    * @throws WrongCarpoolNumberException if the carpoolNumber is zero or a negative integer
    */
	public double lotJYearPrice() {
		return lotJPrice;

	}

	

	//determine if will divide by only fall and spring semester?

	//currently rough estimate, 7 months for 2 semesters with 30 days

	public double lotJDayPrice() {


		double price = lotJPrice / 210.0;
		DecimalFormat df = new DecimalFormat("0.00");      
		price = Double.valueOf(df.format(price));
		
		
		return price;

	}

	
}