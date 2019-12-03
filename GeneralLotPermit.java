import java.text.DecimalFormat;

public class GeneralLotPermit extends CarDriver{

	

	double generalLotPrice = 400.0;

	

	public GeneralLotPermit(String passName, String destination) {

		super(passName, destination);

	}

	

	public double generalLotYearPrice() {

		return generalLotPrice;

	}

	

	//determine if will divide by only fall and spring semester?

	//currently rough estimate, 7 months for 2 semesters

	public double generalLotDayPrice() {

		double price = generalLotPrice / 210.0;
		DecimalFormat df = new DecimalFormat("0.00");      
		price = Double.valueOf(df.format(price));
		
		return price;
		
	}




}