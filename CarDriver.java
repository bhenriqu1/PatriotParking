import java.text.DecimalFormat;
import java.util.*;

public class CarDriver {
	
	//GUI with window builder and/or Java Swing
	
	//98 destinations based off of GMU Map
	//int destinationArray [];
	ArrayList<Coordinate> destinationArray; //ArrayList with the 98 destinations on Fairfax GMU Campus
   ArrayList<Coordinate> lotArray; //ArrayList with lots on Fairfax GMU campus
	int annualPassCost; //cost of parking pass
	String passName; //parking pass name
	String destination;
	int carpoolNumber; //number of people in car
   
   //98 destinations
    Coordinate aquaticAndFitnessCenter = new Coordinate(38.8263722, -77.3042089);
    Coordinate aquiaBuilding = new Coordinate(38.8320733, -77.3094103);
    Coordinate artAndDesignBuilding = new Coordinate(38.8279848, -77.306326);
    Coordinate buchananHall = new Coordinate(38.8287999, -77.3085567);
    Coordinate carowHall = new Coordinate(38.8314068, -77.3012546);
    Coordinate cartyHouse = new Coordinate(38.8318161, -77.3190484);
    Coordinate centerForTheArts = new Coordinate(38.8295271, -77.3093946);
    Coordinate centralHeatindAndCoolingPlant = new Coordinate(38.8316552, -77.3027805);
    Coordinate childDevelopmentCenter = new Coordinate(38.8356294, -77.3046541);
    Coordinate clock = new Coordinate(38.8309487, -77.3071432);
    Coordinate collegeHall = new Coordinate(38.8289205, -77.3079299);
    Coordinate crossCottage = new Coordinate(38.8287348, -77.3109088);
    Coordinate davidKingHall = new Coordinate(38.8305973, -77.306685);
    Coordinate deLaskiPerformingArtsBuilding = new Coordinate(38.8298799, -77.3086084);
    Coordinate eagleBankArena = new Coordinate(38.8268068, -77.3096186);
    Coordinate eastBuilding = new Coordinate(38.8329812, -77.3082557);
    Coordinate enterpriseHall = new Coordinate(38.8289948, -77.3063708);
    Coordinate exploratoryHall = new Coordinate(38.8296479, -77.3054928);
    Coordinate facilitiesAdministration = new Coordinate(38.8323083, -77.3028703);
    Coordinate facilitiesManagementArchives = new Coordinate(38.8325621, -77.3015238);
    Coordinate facilitiesManagementOperations = new Coordinate(38.8324935, -77.3022936);
	Coordinate fenwickLibrary = new Coordinate(38.832139, -77.307179);
	Coordinate fieldHouseAndModule = new Coordinate(38.8340515, -77.314834);
	Coordinate finleyBuilding = new Coordinate(38.8330503, -77.308884);
	Coordinate georgeMasonStatue = new Coordinate(38.8304222, -77.3083889);
	Coordinate greenhouse = new Coordinate(38.828022, -77.3013668);
	Coordinate harrisTheatre = new Coordinate(38.8309602, -77.30861);
	Coordinate innovationHall = new Coordinate(38.8286144, -77.3074609);
	Coordinate johnsonCenter = new Coordinate(38.8297384, -77.3075063);
	Coordinate kelleyII = new Coordinate(38.8314262, -77.3180612);
	Coordinate krasnowInstitute = new Coordinate(38.8311655, -77.3003744);
	Coordinate krugHall = new Coordinate(38.832448, -77.308525);
	Coordinate lectureHall = new Coordinate(38.8331434, -77.3075377);
	Coordinate mertenHall = new Coordinate(38.835053, -77.3079275);
	Coordinate musicTheaterBuilding = new Coordinate(38.829309, -77.3080905);
	Coordinate nguyenEngineeringBuilding = new Coordinate(38.8275249, -77.3050694);
	Coordinate northeastModule = new Coordinate(38.834537, -77.3041269);
	Coordinate northeastModuleII = new Coordinate(38.8340348, -77.3039474);
	Coordinate nottowayAnnex = new Coordinate(38.8254484, -77.305563);
	Coordinate masonPondParkingDeck = new Coordinate(38.8304308, -77.3095572);
	Coordinate rappahannockRiverParkingDeck = new Coordinate(38.8346877, -77.3057672);
	Coordinate shenandoahParkingDeck = new Coordinate(38.828913, -77.3045308);
	Coordinate parkingServices = new Coordinate(38.828937, -77.3051142);
	Coordinate petersonHall = new Coordinate(38.8342542, -77.3090726);
	Coordinate planetaryHall = new Coordinate(38.8298814, -77.3062813);
	Coordinate policeAndSafetyHdqrt = new Coordinate(38.8353507, -77.3059358);
	Coordinate recreationAndAthleticComplex = new Coordinate(38.8306443, -77.3124311);
	Coordinate recyclingCenter = new Coordinate(38.8325164, -77.3010222);
	Coordinate researchHall = new Coordinate(38.8282768, -77.3052496);
	Coordinate rivannaModule = new Coordinate(38.8325975, -77.3040371);
	Coordinate robertsHouse = new Coordinate(38.8279111, -77.30003);
	Coordinate robinsonHallB = new Coordinate(38.8309161, -77.3081211);
	Coordinate studentUnionBuildingI = new Coordinate(38.8314495, -77.3092105);
	Coordinate theaterSpace = new Coordinate(38.8298799, -77.3086084);
	Coordinate theHub = new Coordinate(38.8308162, -77.305361);
	Coordinate thompsonHall = new Coordinate(38.8327461, -77.3099166);
	Coordinate warehouse = new Coordinate(38.831531, -77.3020175);
	Coordinate westBuilding = new Coordinate(38.8320677, -77.3094198);
	Coordinate westPEModule = new Coordinate(38.8313306, -77.3144487);
	Coordinate blueRidge = new Coordinate(38.8329423, -77.3064297);
	Coordinate easternShore = new Coordinate(38.8334212, -77.3042167);
	Coordinate hamptonRoads = new Coordinate(38.8338515, -77.305204);
	Coordinate northernNeck = new Coordinate(38.8338116, -77.3070027);
	Coordinate piedmont = new Coordinate(38.8323999, -77.3064999);
	Coordinate sandbridge = new Coordinate(38.8325012, -77.3064919);
	Coordinate skylineFitnessCenter = new Coordinate(38.831626, -77.305845);
	Coordinate southside = new Coordinate(38.8313068, -77.3055677);
	Coordinate tidewater = new Coordinate(38.831937, -77.3060324);
	Coordinate commonwealth = new Coordinate(38.8333874, -77.3061016);
	Coordinate dominion = new Coordinate(38.8329459, -77.3057425);
	Coordinate amherst = new Coordinate(38.8326056, -77.304833);
	Coordinate brunswick = new Coordinate(38.8324417, -77.3045517);
	Coordinate carroll = new Coordinate(38.8319049, -77.3044507);
	Coordinate dickenson = new Coordinate(38.8316675, -77.3046504);
	Coordinate essex = new Coordinate(38.8317925, -77.3050525);
	Coordinate franklin = new Coordinate(38.8308613, -77.305988);
	Coordinate grayson = new Coordinate(38.8308613, -77.305988);
	Coordinate hanover = new Coordinate(38.8321452, -77.3047789);
	Coordinate libertySquare = new Coordinate(38.827809, -77.3025014);
	Coordinate potomacHeights = new Coordinate(38.8261366, -77.3023501);
	Coordinate adams = new Coordinate(38.8295906, -77.3010077);
	Coordinate eisenhower = new Coordinate(38.8288451, -77.3023716);
	Coordinate harrison = new Coordinate(38.8294096, -77.3024775);
	Coordinate jackson = new Coordinate(38.8286531, -77.301348);
	Coordinate jefferson = new Coordinate(38.8300383, -77.3025295);
	Coordinate kennedy = new Coordinate(38.8292858, -77.3012238);
	Coordinate lincoln = new Coordinate(38.8282583, -77.3013219);
	Coordinate madison = new Coordinate(38.8301346, -77.3020971);
	Coordinate monroe = new Coordinate(38.8297756, -77.3027059);
	Coordinate roosevelt = new Coordinate(38.828474, -77.301775);
	Coordinate taylor = new Coordinate(38.8276787, -77.3016427);
	Coordinate truman = new Coordinate(38.829542, -77.301504);
	Coordinate washington = new Coordinate(38.829998, -77.301694);
	Coordinate wilson = new Coordinate(38.829268, -77.302261);
	Coordinate rogers = new Coordinate(38.8346547, -77.3110004);
	Coordinate whitetop = new Coordinate(38.8339996, -77.3116664);
	Coordinate masonvale = new Coordinate(38.8329807, -77.2992929);

   //lots
   Coordinate westCampus = new Coordinate(38.8327968, -77.3264524);
   Coordinate lotA = new Coordinate(38.82623, -77.307073);
   Coordinate lotC = new Coordinate(38.8252031, -77.3059246);
   Coordinate lotK = new Coordinate(38.827806, -77.312655);
   Coordinate lotL = new Coordinate(38.8256766, -77.3106616);
   Coordinate lotM = new Coordinate(38.833843, -77.3136804);
   Coordinate lotO = new Coordinate(38.8344029, -77.3135063);
   Coordinate lotP = new Coordinate(38.8349269, -77.3163289);
   Coordinate lotPV = new Coordinate(38.8308986, -77.3142792);
   Coordinate lotI = new Coordinate(38.83333, -77.3119133);
   Coordinate lotJ = new Coordinate(38.8298081, -77.3147599);


	/**
	 * Constuctor with minimum user input of passName and 
	 * destination on Fairfax GMU Campus
	 * @param annualPassCost,  
	 */
	public CarDriver(String passName,String destination) {
		destinationArray = new ArrayList<>(Arrays.asList(aquaticAndFitnessCenter, aquiaBuilding, artAndDesignBuilding, buchananHall, carowHall, cartyHouse, centerForTheArts, centralHeatindAndCoolingPlant, childDevelopmentCenter, clock, collegeHall, crossCottage, davidKingHall, deLaskiPerformingArtsBuilding, eagleBankArena, eastBuilding, enterpriseHall,
				exploratoryHall, facilitiesAdministration, facilitiesManagementArchives, facilitiesManagementOperations, fenwickLibrary, fieldHouseAndModule, finleyBuilding, georgeMasonStatue, greenhouse, harrisTheatre, innovationHall, johnsonCenter, kelleyII, krasnowInstitute, krugHall, lectureHall, mertenHall,
				robinsonHallB, studentUnionBuildingI, theaterSpace, theHub, thompsonHall, warehouse, westBuilding, westPEModule, blueRidge, easternShore, hamptonRoads, northernNeck, piedmont, sandbridge,
				skylineFitnessCenter, southside, tidewater, commonwealth, dominion, amherst, brunswick, carroll, dickenson, essex, franklin, grayson, hanover,
				libertySquare, potomacHeights, adams, eisenhower, harrison, jackson, jefferson, kennedy, lincoln, madison, monroe, roosevelt, taylor, truman,
				washington, wilson, rogers, whitetop, masonvale));
		lotArray = new ArrayList<>(Arrays.asList(westCampus, lotA, lotC, lotK, lotL, lotM, lotO, lotP, lotPV, lotI, lotJ, shenandoahParkingDeck, masonPondParkingDeck, rappahannockRiverParkingDeck));
		this.passName = passName;
		this.destination = destination;
	}

	
	/**
	 * Constructor with additional carpool params
	 */
	public CarDriver(String passName,String destination, int carpoolNumber) {
		destinationArray = new ArrayList<>(Arrays.asList(aquaticAndFitnessCenter, aquiaBuilding, artAndDesignBuilding, buchananHall, carowHall, cartyHouse, centerForTheArts, centralHeatindAndCoolingPlant, childDevelopmentCenter, clock, collegeHall, crossCottage, davidKingHall, deLaskiPerformingArtsBuilding, eagleBankArena, eastBuilding, enterpriseHall,
				exploratoryHall, facilitiesAdministration, facilitiesManagementArchives, facilitiesManagementOperations, fenwickLibrary, fieldHouseAndModule, finleyBuilding, georgeMasonStatue, greenhouse, harrisTheatre, innovationHall, johnsonCenter, kelleyII, krasnowInstitute, krugHall, lectureHall, mertenHall,
				robinsonHallB, studentUnionBuildingI, theaterSpace, theHub, thompsonHall, warehouse, westBuilding, westPEModule, blueRidge, easternShore, hamptonRoads, northernNeck, piedmont, sandbridge,
				skylineFitnessCenter, southside, tidewater, commonwealth, dominion, amherst, brunswick, carroll, dickenson, essex, franklin, grayson, hanover,
				libertySquare, potomacHeights, adams, eisenhower, harrison, jackson, jefferson, kennedy, lincoln, madison, monroe, roosevelt, taylor, truman,
				washington, wilson, rogers, whitetop, masonvale));
      lotArray = new ArrayList<>(Arrays.asList(westCampus, lotA, lotC, lotK, lotL, lotM, lotO, lotP, lotPV, lotI, lotJ, shenandoahParkingDeck, masonPondParkingDeck, rappahannockRiverParkingDeck));
		this.passName = passName;
		this.destination = destination;
		this.carpoolNumber = carpoolNumber;
	}
	
	
   //Average walking speed is 3.1mph
   //1 hour = 60 minutes
   
   /**
    * @param the coordinate of the destination
    * @return time spent walking between two coordinates in minutes
    */
   public double timeCalculator(Coordinate lot, Coordinate destination) throws WrongPassNameException{
	   Double time = ((getDistance(lot, destination) * 60) / 3.1);
	   DecimalFormat df = new DecimalFormat("0.00");      
	   time = Double.valueOf(df.format(time));
      return time;
   }
   
      /**
    * I made this method static so this method can be referenced from other classes
    * Calculates the distance between two coordinates by using the Haversine formula
    * @param the coordinate of the destination
    * @return the distance between two coordinates is miles
    */
	public double getDistance(Coordinate lot, Coordinate destination) { 
   

    double latDistance = Math.toRadians(destination.getX() - lot.getX());
    double lngDistance = Math.toRadians(destination.getY() - lot.getY());

    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
             + Math.cos(Math.toRadians(destination.getX())) * Math.cos(Math.toRadians(lot.getX()))
             * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    return (3958.8 * c); //multiply by the average distance of earth in miles
   }

	
}
