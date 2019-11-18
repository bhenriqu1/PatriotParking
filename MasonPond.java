public class MasonPond extends ReservedParkingDeckPermit{

	

	int masonPondPrice = 700;

	

	public MasonPond(String passName, String destination) {

		super(passName, destination);

	}

	
   /**
    * @param carpoolNumber number of people carpooling one vehicle
    * @return the permit price that the vehicle owner will actually pay
    * @throws WrongCarpoolNumberException if the carpoolNumber is zero or a negative integer
    */
	public int masonPondYearPrice(int carpoolNumber) throws WrongCarpoolNumberException {

      if(carpoolNumber < 1) {
         throw new WrongCarpoolNumberException();
      } else if (carpoolNumber > 1 && carpoolNumber < 4){
         this.masonPondPrice *= (1 - (0.1 * carpoolNumber));
      } else if (carpoolNumber >= 4){
         this.masonPondPrice *= 0.6;
      }
		return masonPondPrice;

	}

	

	//determine if will divide by only fall and spring semester?

	//currently rough estimate, 7 months for 2 semesters with 30 days

	public int masonPondDayPrice() throws WrongCarpoolNumberException {

		return masonPondYearPrice(carpoolNumber) / 210; 

	}

	
}