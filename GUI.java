import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class GUI extends JFrame implements ActionListener {
   private JButton calcButton;            // Triggers time calculation
   private JLabel destinationLabel;
   private JLabel parkingLabel;
   private JLabel carpoolLabel;
   private JTextField hrsFlyField;        // Displays fly time
   private JTextField hrsDriveField;      // Displays drive time
   private JFormattedTextField distField; // Holds distance input
   private JTextArea outputArea;
   JScrollPane scrollPane = null; 
   private JLabel lbl;						//top label
   String[] choices = { "Lot A", "Lot C", "Lot I", "Lot J", "Lot K",
           "Lot L", "Lot M", "Lot O", "Lot P", "Lot PV",
            "Mason Pond Parking Deck", "Rappahannock River Parking Deck" , "Shenandoah Parking Deck", "West Campus"};
   
   final JComboBox<String> cb = new JComboBox<String>(choices); 
   
   String[] choices2 = { "Adams", "Amherst", "Aquatic And Fitness Center", "Aquia Building", "Art And Design Building", 
		   "Blue Ridge", "Brunswick", "Buchanan Hall",
           "Carow Hall",  "Carroll", "Carty House", "Center For The Arts", "Central Heating And Cooling Plant", 
           "Child Development Center", "Clock", "College Hall", "Commonwealth", "Cross Cottage" , 
           "David King Hall", "DeLaski Performing Arts Building", "Dickenson",  "Dominion", "EagleBank Arena", "East Building", "Eastern Shore", "Eisenhower", "Enterprise Hall",
           "Essex", "Exploratory Hall", "Facilities Administration", "Facilities Management Archives", "Facilities Management Operations", 
			"Fenwick Library", "Field House And Module", "Finley Building",  "Franklin", "George Mason Statue", "Greenhouse", "Grayson", "Hampton Roads", "Hanover",
			 "Harrison", "Harris Theatre", 
			"Innovation Hall", "Jackson", "Jefferson", "Johnson Center", "Kelley II",  "Kennedy", "Krasnow Institute", "Krug Hall", "Lecture Hall",
			"Liberty Square",  "Lincoln", "Madison", "Masonvale", "Merten Hall", "Monroe",
			"Northern Neck",  "Piedmont", "Potomac Heights",
			"Robinson Hall B", "Rogers",  "Roosevelt", "Sandbridge", "Skyline Fitness Center", "Southside", "Student Union Building I", "Taylor", "Theater Space", "The Hub", 
			"Thompson Hall", "Tidewater",  "Truman", "Warehouse", "Washington", "West Building", "West PE Module", "Whitetop", "Wilson", 
		
			};
   
   
   final JComboBox<String> cb2 = new JComboBox<String>(choices2);
 
   //String[] choices3 = { "1","2","3","4" };
   //final JComboBox<String> cb3 = new JComboBox<String>(choices3); 
   private JSpinner yearsSpinner; 
   
   

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   GUI() {
      // Used to specify GUI component layout
      GridBagConstraints layoutConst = null;

      // Set frame's title
      setTitle("Patriot Parking");

      // Create labels
     
      parkingLabel = new JLabel("Parking location:");
      lbl = new JLabel("Select one of the locations on the GMU Fairfax Campus and click Calculate");
      destinationLabel = new JLabel("Destination:");
      carpoolLabel = new JLabel("If you carpool, with how many people?");
      
      
      cb.setForeground(Color.GREEN.darker());
      cb2.setForeground(Color.YELLOW.darker());
      
      //spinner
      int initNum;     // Spinner initial value display
      int minNum;      // Spinner min value
      int maxNum;      // Spinner max value
      int stepVal;      // Spinner step

      initNum = 0;
      minNum = 0;
      maxNum = 4;
      stepVal = 1;
      
      SpinnerNumberModel spinnerModel = null;
      spinnerModel = new SpinnerNumberModel(initNum, minNum, maxNum, stepVal);
      yearsSpinner = new JSpinner(spinnerModel);
      //yearsSpinner.addActionListener(this);
      
      
      
      //output text box
      outputArea = new JTextArea(10, 15);
      scrollPane = new JScrollPane(outputArea);
      outputArea.setEditable(false);
      
      
      
      
      
      // Create button and add action listener
      calcButton = new JButton("Calculate");
      calcButton.addActionListener(this);

      // Create flight time filed
      hrsFlyField = new JTextField(15);
      hrsFlyField.setEditable(false);

      // Create driving time field
      hrsDriveField = new JTextField(15);
      hrsDriveField.setEditable(false);

      // Create and set-up an input field for numbers (not text)
      distField = new JFormattedTextField(NumberFormat.getNumberInstance());
      distField.setEditable(true);
      distField.setText("0");
      distField.setColumns(15); // Initial width of 10 units 

      
      
      // Use a GridBagLayout
      setLayout(new GridBagLayout());

      layoutConst = new GridBagConstraints();
      //layoutConst.insets = new Insets(10, 10, 10, 1);
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      add(lbl, layoutConst);
      
      
      layoutConst = new  GridBagConstraints();
      //layoutConst.insets = new Insets(10, 0, 1, 10);
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      add(parkingLabel, layoutConst);
      
      layoutConst = new GridBagConstraints();
      //layoutConst.insets = new Insets(10, 10, 10, 1);
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      add(cb, layoutConst);
      
      layoutConst = new  GridBagConstraints();
      //layoutConst.insets = new Insets(10, 0, 1, 10);
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      add(destinationLabel, layoutConst);
      
      layoutConst = new GridBagConstraints();
      //layoutConst.insets = new Insets(10, 10, 10, 1);
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      add(cb2, layoutConst);
      
      layoutConst = new  GridBagConstraints();
      //layoutConst.insets = new Insets(10, 0, 1, 10);
      layoutConst.gridx = 0;
      layoutConst.gridy = 3;
      add(carpoolLabel, layoutConst);
      
     /** 
      layoutConst = new GridBagConstraints();
      //layoutConst.insets = new Insets(10, 10, 10, 1);
      layoutConst.gridx = 1;
      layoutConst.gridy = 3;
      add(cb3, layoutConst);
      
      **/
      
      layoutConst = new GridBagConstraints();
      //layoutConst.insets = new Insets(10, 1, 10, 10);
      //layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 1;
      layoutConst.gridy = 3;
      add(yearsSpinner, layoutConst);
      
    

      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(1, 10, 10, 10);
      layoutConst.fill = GridBagConstraints.HORIZONTAL;
      layoutConst.gridx = 0;
      layoutConst.gridy = 5;
      layoutConst.gridwidth = 3; // 3 cells wide
      add(scrollPane, layoutConst);
      
      
      
      // Specify component's grid location
      
/**
      layoutConst = new GridBagConstraints();
      layoutConst.insets = new Insets(10, 1, 10, 10);
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      add(distField, layoutConst);
**/
      layoutConst = new GridBagConstraints();
      //layoutConst.insets = new Insets(10, 5, 10, 10);
      layoutConst.gridx = 1;
      layoutConst.gridy = 4;
      add(calcButton, layoutConst);

      
      
      
   }

   /* Method is automatically called when an event 
      occurs (e.g, Enter key is pressed) */
   @Override
   public void actionPerformed(ActionEvent event) {
   
	   
	   
	   String s = (String) cb.getSelectedItem();
	   String s2 = (String) cb2.getSelectedItem();
	   
	   //list of lots
       String lot0 = "West Campus";
       String lot1 = "Lot A";
       String lot2 = "Lot C";
       String lot3 = "Lot K";
       String lot4 = "Lot L";
       String lot5 = "Lot M";
       String lot6 = "Lot O";
       String lot7 = "Lot P";
       String lot8 = "Lot PV";
       String lot9 = "Lot I";
       String lot10 = "Lot J";
       String lot11 = "Shenandoah Parking Deck";
       String lot12 = "Mason Pond Parking Deck";
       String lot13 = "Rappahannock River Parking Deck";
   
		
       //GMU Locations
       String des0 = "Aquatic And Fitness Center";
       String des1 = "Aquia Building";
       String des2 = "Art And Design Building";
       String des3 = "Buchanan Hall";
       String des4 = "Carow Hall";
       String des5 = "Carty House";
       String des6 = "Center For The Arts";
       String des7 = "Central Heating And Cooling Plant";
       String des8 = "Child Development Center";
       String des9 =  "Clock";
       String des10 = "College Hall";
       String des11 = "Cross Cottage";
       String des12 = "David King Hall";
       String des13 = "DeLaski Performing Arts Building";
       String des14 = "EagleBank Arena";
       String des15 = "East Building";
       String des16 = "Enterprise Hall";
       String des17 = "Exploratory Hall";
       String des18 = "Facilities Administration";
       String des19 = "Facilities Management Archives";
       String des20 = "Facilities Management Operations";
       String des21 = "Fenwick Library";
       String des22 = "Field House And Module";
       String des23 = "Finley Building";
       String des24 = "George Mason Statue";
       String des25 = "Greenhouse";
       String des26 = "Harris Theatre";
       String des27 = "Innovation Hall";
       String des28 = "Johnson Center";
       String des29 = "Kelley II";
       String des30 = "Krasnow Institute";
       String des31 = "Krug Hall";
       String des32 = "Lecture Hall";
       String des33 = "Merten Hall";
       String des34 = "Robinson Hall B";
       String des35 = "Student Union Building I";
       String des36 = "Theater Space";
       String des37 = "The Hub";
       String des38 = "Thompson Hall";
       String des39 = "Warehouse";
       String des40 = "West Building";
       String des41 = "West PE Module"; 
       String des42 = "Blue Ridge";
       String des43 = "Eastern Shore";
       String des44 = "Hampton Roads";
       String des45 = "Northern Neck";
       String des46 = "Piedmont";
       String des47 = "Sandbridge";
       String des48 = "Skyline Fitness Center";
       String des49 = "Southside";
       String des50 =  "Tidewater";
       String des51 = "Commonwealth";	   
       String des52 = "Dominion";
       String des53 = "Amherst";
       String des54 = "Brunswick";
       String des55 = "Carroll";
       String des56 = "Dickenson";
       String des57 = "Essex";
       String des58 = "Franklin";
       String des59 = "Grayson";
       String des60 = "Hanover";
       String des61 = "Liberty Square";
       String des62 = "Potomac Heights";
       String des63 = "Adams";
       String des64 = "Eisenhower";
       String des65 = "Harrison";
       String des66 = "Jackson";
       String des67 = "Jefferson";
       String des68 = "Kennedy";
       String des69 = "Lincoln";
       String des70 = "Madison";
       String des71 = "Monroe";
       String des72 = "Roosevelt";
       String des73 = "Taylor";
       String des74 = "Truman";
       String des75 = "Washington";
       String des76 = "Wilson";
       String des77 = "Rogers";
       String des78 = "Whitetop";
       String des79 = "Masonvale";
       
       //lot
       /**
       //EconomyPermit e = new EconomyPermit(lot0, des0);
       CarDriver c = new CarDriver(lot0,des0);
       
       
       Coordinate lot0coord = c.lotArray.get(0); //wccoord
       Coordinate lot1coord = c.lotArray.get(1); //lotA
       Coordinate lot2coord = c.lotArray.get(2); //lotC
       Coordinate lot3coord = c.lotArray.get(3); //lotK
       Coordinate lot4coord = c.lotArray.get(4); //lotL
       Coordinate lot5coord = c.lotArray.get(5); //lotM
       Coordinate lot6coord = c.lotArray.get(6);//lotO
       Coordinate lot7coord = c.lotArray.get(7);//lotP
       Coordinate lot8coord = c.lotArray.get(8);//lotPV
       Coordinate lot9coord = c.lotArray.get(9);//LotI
       Coordinate lot10coord = c.lotArray.get(10);//LotJ
       Coordinate lot11coord = c.lotArray.get(11);//Shenan
       Coordinate lot12coord = c.lotArray.get(12);//masonpond
       Coordinate lot13coord = c.lotArray.get(13);//rapp
       
       //destinations
       Coordinate des0coord = c.destinationArray.get(0); //afc
       Coordinate des1coord = c.destinationArray.get(1);//aquia
       Coordinate des2coord = c.destinationArray.get(2);//artanddes
       Coordinate des3coord = c.destinationArray.get(3);//buch
       Coordinate des4coord = c.destinationArray.get(4);//carrow
       Coordinate des5coord = c.destinationArray.get(5);//carty
       Coordinate des6coord = c.destinationArray.get(6);//cfa
       Coordinate des7coord = c.destinationArray.get(7);//cool
       Coordinate des8coord = c.destinationArray.get(8);//child
       Coordinate des9coord = c.destinationArray.get(9);//clock 
       Coordinate des10coord = c.destinationArray.get(10);//college
       Coordinate des11coord = c.destinationArray.get(11);//cross
       Coordinate des12coord = c.destinationArray.get(12);//david
       Coordinate des13coord = c.destinationArray.get(13);//delaski
       Coordinate des14coord = c.destinationArray.get(14);//eagle
       Coordinate des15coord = c.destinationArray.get(15);//east
       Coordinate des16coord = c.destinationArray.get(16);//
      
       **/
       
       //westcampus to afc
       EconomyPermit e = new EconomyPermit(lot0, des0);
       CarDriver c = new CarDriver(lot0,des0);
       Coordinate des0coord = c.destinationArray.get(0); //afccoord
       Coordinate lot0coord = c.lotArray.get(0); //wccoord
      
     //WESTCAMPUS price
       double price = e.westCampusDayPrice();
       
       
       if (s.equals(lot0) && s2.equals(des0)){
    	   
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c.timeCalculator(lot0coord, des0coord) + " minutes to get from " + lot0 + " to "  +  des0);
		} catch (WrongPassNameException e1) {
			e1.printStackTrace();
		}
       }
       
       
       //westcampus to aquia
       //EconomyPermit e1 = new EconomyPermit(lot0, des1);
       CarDriver c1 = new CarDriver(lot0,des1);
       Coordinate des1coord = c1.destinationArray.get(1); //aquiacoord
       Coordinate lot1coord = c1.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des1)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c1.timeCalculator(lot1coord, des1coord) + " minutes to get from " + lot0 + " to "  +  des1);
		} catch (WrongPassNameException e2) {
			e2.printStackTrace();
		}
       }
       
       //wc to artAndDesignBuilding
       //EconomyPermit e2 = new EconomyPermit(lot0, des2);
       CarDriver c2 = new CarDriver(lot0,des2);
       Coordinate des2coord = c2.destinationArray.get(2); //artanddes
       Coordinate lot2coord = c2.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des2)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c2.timeCalculator(lot2coord, des2coord) + " minutes to get from " + lot0 + " to "  +  des2);
		} catch (WrongPassNameException e3) {
			e3.printStackTrace();
		}
       }
       
       //wc to  buchananHall
       //EconomyPermit e3 = new EconomyPermit(lot0, des3);
       CarDriver c3 = new CarDriver(lot0,des3);
       Coordinate des3coord = c3.destinationArray.get(3); //buch
       Coordinate lot3coord = c3.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des3)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c3.timeCalculator(lot0coord, des3coord) + " minutes to get from " + lot0 + " to "  +  des3);
		} catch (WrongPassNameException e4) {
			e4.printStackTrace();
		}
       }
       
       //wc to carowHall
       EconomyPermit e4 = new EconomyPermit(lot0, des4);
       CarDriver c4 = new CarDriver(lot0, des4);
       Coordinate des4coord = c4.destinationArray.get(4); //carr
       Coordinate lot4coord = c4.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des4)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c4.timeCalculator(lot4coord, des4coord) + " minutes to get from " + lot0 + " to "  +  des4);
		} catch (WrongPassNameException e5) {
			e5.printStackTrace();
		}
       }
       
       //wc to cartyHouse
       EconomyPermit e5 = new EconomyPermit(lot0, des5);
       CarDriver c5 = new CarDriver(lot0, des4);
       Coordinate des5coord = c5.destinationArray.get(5); //carty
       Coordinate lot5coord = c5.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des5)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c5.timeCalculator(lot5coord, des5coord) + " minutes to get from " + lot0 + " to "  +  des5);
		} catch (WrongPassNameException e6) {
			e6.printStackTrace();
		}
       }
       //wc to centerForTheArts
       EconomyPermit e6 = new EconomyPermit(lot0, des6);
       CarDriver c6 = new CarDriver(lot0, des4);
       Coordinate des6coord = c6.destinationArray.get(6); //cfa
       Coordinate lot6coord = c6.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des6)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c6.timeCalculator(lot6coord, des6coord) + " minutes to get from " + lot0 + " to "  +  des6);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to centralHeati
       
       CarDriver c7 = new CarDriver(lot0, des7);
       Coordinate des7coord = c7.destinationArray.get(7); //cooling
       Coordinate lot7coord = c7.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des7)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c7.timeCalculator(lot0coord, des7coord) + " minutes to get from " + lot0 + " to "  +  des7);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       
       //wc to childDevelopmentCenter
       CarDriver c8 = new CarDriver(lot0, des8);
       Coordinate des8coord = c8.destinationArray.get(8); //carr
       Coordinate lot8coord = c8.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des8)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c8.timeCalculator(lot0coord, des8coord) + " minutes to get from " + lot0 + " to "  +  des8);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       
       //wc to clock
       CarDriver c9 = new CarDriver(lot0, des9);
       Coordinate des9coord = c9.destinationArray.get(9); //carr
       Coordinate lot9coord = c9.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des9)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c9.timeCalculator(lot0coord, des9coord) + " minutes to get from " + lot0 + " to "  +  des9);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to collegeHall
       CarDriver c10 = new CarDriver(lot0, des10);
       Coordinate des10coord = c10.destinationArray.get(10); //carr
       Coordinate lot10coord = c10.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des10)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c10.timeCalculator(lot10coord, des10coord) + " minutes to get from " + lot0 + " to "  +  des10);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to crossCottage
       CarDriver c11 = new CarDriver(lot0, des11);
       Coordinate des11coord = c11.destinationArray.get(11); //carr
       Coordinate lot11coord = c11.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des11)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c.timeCalculator(lot0coord, des11coord) + " minutes to get from " + lot0 + " to "  +  des11);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to davidKingHall
       CarDriver c12 = new CarDriver(lot0, des9);
       Coordinate des12coord = c12.destinationArray.get(12); //carr
       Coordinate lot12coord = c12.lotArray.get(0); //wc
      
       if (s.equals(lot0) && s2.equals(des12)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c12.timeCalculator(lot12coord, des12coord) + " minutes to get from " + lot0 + " to "  +  des12);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       //wc to deLaskiPerformingArtsBuilding
       CarDriver c13 = new CarDriver(lot0, des13);
       Coordinate des13coord = c13.destinationArray.get(13); //carr
       Coordinate lot13coord = c13.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des13)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c13.timeCalculator(lot12coord, des13coord) + " minutes to get from " + lot0 + " to "  +  des13);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to eagleBankArena
       CarDriver c14 = new CarDriver(lot0, des14);
       Coordinate des14coord = c14.destinationArray.get(14); //carr
       Coordinate lot14coord = c14.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des14)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c14.timeCalculator(lot14coord, des14coord) + " minutes to get from " + lot0 + " to "  +  des14);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to eastBuilding
       CarDriver c15 = new CarDriver(lot0, des15);
       Coordinate des15coord = c15.destinationArray.get(15); //carr
       Coordinate lot15coord = c15.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des15)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c15.timeCalculator(lot15coord, des15coord) + " minutes to get from " + lot0 + " to "  +  des15);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to enterpriseHall
       CarDriver c16 = new CarDriver(lot0, des16);
       Coordinate des16coord = c16.destinationArray.get(16); //carr
       Coordinate lot16coord = c16.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des16)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c16.timeCalculator(lot16coord, des16coord) + " minutes to get from " + lot0 + " to "  +  des16);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to exploratoryHall
       CarDriver c17 = new CarDriver(lot0, des17);
       Coordinate des17coord = c17.destinationArray.get(17); //carr
       Coordinate lot17coord = c17.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des17)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c17.timeCalculator(lot17coord, des17coord) + " minutes to get from " + lot0 + " to "  +  des17);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to facilitiesAdministration
       CarDriver c18 = new CarDriver(lot0, des18);
       Coordinate des18coord = c18.destinationArray.get(18); //carr
       Coordinate lot18coord = c18.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des18)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c18.timeCalculator(lot18coord, des18coord) + " minutes to get from " + lot0 + " to "  +  des18);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to facilitiesManagementArchives
       CarDriver c19 = new CarDriver(lot0, des17);
       Coordinate des19coord = c19.destinationArray.get(19); //carr
       Coordinate lot19coord = c19.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des19)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c19.timeCalculator(lot19coord, des19coord) + " minutes to get from " + lot0 + " to "  +  des19);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to facilitiesManagementOperations, 
       CarDriver c20 = new CarDriver(lot0, des20);
       Coordinate des20coord = c20.destinationArray.get(20); //carr
       Coordinate lot20coord = c20.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des20)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c20.timeCalculator(lot20coord, des20coord) + " minutes to get from " + lot0 + " to "  +  des20);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
      //wc to fenwickLibrary
       CarDriver c21 = new CarDriver(lot0, des21);
       Coordinate des21coord = c21.destinationArray.get(21); //carr
       Coordinate lot21coord = c2.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des21)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c21.timeCalculator(lot21coord, des21coord) + " minutes to get from " + lot0 + " to "  +  des21);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to fieldHouseAndModule
       CarDriver c22 = new CarDriver(lot0, des22);
       Coordinate des22coord = c22.destinationArray.get(22); //carr
       Coordinate lot22coord = c22.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des22)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c22.timeCalculator(lot22coord, des22coord) + " minutes to get from " + lot0 + " to "  +  des22);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to finleyBuilding
       CarDriver c23 = new CarDriver(lot0, des23);
       Coordinate des23coord = c23.destinationArray.get(23); 
       Coordinate lot23coord = c23.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des23)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c23.timeCalculator(lot23coord, des23coord) + " minutes to get from " + lot0 + " to "  +  des23);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
      //wc to georgeMasonStatue
       CarDriver c24 = new CarDriver(lot0, des24);
       Coordinate des24coord = c24.destinationArray.get(24); 
       Coordinate lot24coord = c24.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des24)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c24.timeCalculator(lot24coord, des24coord) + " minutes to get from " + lot0 + " to "  +  des24);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to greenhouse
       CarDriver c25 = new CarDriver(lot0, des25);
       Coordinate des25coord = c25.destinationArray.get(25); 
       Coordinate lot25coord = c25.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des25)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c25.timeCalculator(lot25coord, des25coord) + " minutes to get from " + lot0 + " to "  +  des25);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to harrisTheatre
       CarDriver c26 = new CarDriver(lot0, des26);
       Coordinate des26coord = c26.destinationArray.get(26); 
       Coordinate lot26coord = c26.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des26)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c26.timeCalculator(lot26coord, des26coord) + " minutes to get from " + lot0 + " to "  +  des26);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to innovationHall
       CarDriver c27 = new CarDriver(lot0, des27);
       Coordinate des27coord = c27.destinationArray.get(27); 
       Coordinate lot27coord = c27.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des27)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c27.timeCalculator(lot27coord, des27coord) + " minutes to get from " + lot0 + " to "  +  des27);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to johnsonCenter
       CarDriver c28 = new CarDriver(lot0, des28);
       Coordinate des28coord = c28.destinationArray.get(28); 
       Coordinate lot28coord = c28.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des28)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c28.timeCalculator(lot28coord, des28coord) + " minutes to get from " + lot0 + " to "  +  des28);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to kelleyII
       CarDriver c29 = new CarDriver(lot0, des29);
       Coordinate des29coord = c29.destinationArray.get(29); 
       Coordinate lot29coord = c29.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des29)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c29.timeCalculator(lot29coord, des29coord) + " minutes to get from " + lot0 + " to "  +  des29);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to krasnowInstitute
       CarDriver c30 = new CarDriver(lot0, des30);
       Coordinate des30coord = c30.destinationArray.get(30); 
       Coordinate lot30coord = c30.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des30)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c30.timeCalculator(lot30coord, des30coord) + " minutes to get from " + lot0 + " to "  +  des30);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to krugHall
       CarDriver c31 = new CarDriver(lot0, des31);
       Coordinate des31coord = c31.destinationArray.get(31); 
       Coordinate lot31coord = c31.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des31)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c31.timeCalculator(lot31coord, des31coord) + " minutes to get from " + lot0 + " to "  +  des31);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to lectureHall
       CarDriver c32 = new CarDriver(lot0, des32);
       Coordinate des32coord = c32.destinationArray.get(32); 
       Coordinate lot32coord = c32.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des32)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c32.timeCalculator(lot32coord, des32coord) + " minutes to get from " + lot0 + " to "  +  des32);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to mertenHall,
       CarDriver c33 = new CarDriver(lot0, des33);
       Coordinate des33coord = c33.destinationArray.get(33); 
       Coordinate lot33coord = c33.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des33)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c33.timeCalculator(lot33coord, des33coord) + " minutes to get from " + lot0 + " to "  +  des33);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to robinsonHallB
       CarDriver c34 = new CarDriver(lot0, des34);
       Coordinate des34coord = c34.destinationArray.get(34); 
       Coordinate lot34coord = c34.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des34)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c34.timeCalculator(lot34coord, des34coord) + " minutes to get from " + lot0 + " to "  +  des34);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to studentUnionBuildingI
       CarDriver c35 = new CarDriver(lot0, des35);
       Coordinate des35coord = c35.destinationArray.get(35); 
       Coordinate lot35coord = c35.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des35)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c35.timeCalculator(lot35coord, des35coord) + " minutes to get from " + lot0 + " to "  +  des35);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to theaterSpace
       CarDriver c36 = new CarDriver(lot0, des36);
       Coordinate des36coord = c36.destinationArray.get(36); 
       Coordinate lot36coord = c36.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des36)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c36.timeCalculator(lot36coord, des36coord) + " minutes to get from " + lot0 + " to "  +  des36);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to theHub
       CarDriver c37 = new CarDriver(lot0, des37);
       Coordinate des37coord = c37.destinationArray.get(37); 
       Coordinate lot37coord = c37.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des37)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c37.timeCalculator(lot37coord, des37coord) + " minutes to get from " + lot0 + " to "  +  des37);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to thompsonHall
       CarDriver c38 = new CarDriver(lot0, des38);
       Coordinate des38coord = c38.destinationArray.get(3); 
       Coordinate lot38coord = c38.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des38)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c38.timeCalculator(lot38coord, des38coord) + " minutes to get from " + lot0 + " to "  +  des38);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to warehouse
       CarDriver c39 = new CarDriver(lot0, des39);
       Coordinate des39coord = c39.destinationArray.get(39); 
       Coordinate lot39coord = c39.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des39)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c39.timeCalculator(lot39coord, des39coord) + " minutes to get from " + lot0 + " to "  +  des39);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to westBuilding
       CarDriver c40 = new CarDriver(lot0, des40);
       Coordinate des40coord = c40.destinationArray.get(40); 
       Coordinate lot40coord = c40.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des40)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c40.timeCalculator(lot40coord, des40coord) + " minutes to get from " + lot0 + " to "  +  des40);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to westPEModule
       CarDriver c41 = new CarDriver(lot0, des41);
       Coordinate des41coord = c41.destinationArray.get(41); 
       Coordinate lot41coord = c41.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des41)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c41.timeCalculator(lot41coord, des41coord) + " minutes to get from " + lot0 + " to "  +  des41);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to blueRidge
       CarDriver c42 = new CarDriver(lot0, des42);
       Coordinate des42coord = c42.destinationArray.get(42); 
       Coordinate lot42coord = c42.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des42)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c42.timeCalculator(lot42coord, des42coord) + " minutes to get from " + lot0 + " to "  +  des42);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to easternShore
       CarDriver c43 = new CarDriver(lot0, des43);
       Coordinate des43coord = c43.destinationArray.get(43); 
       Coordinate lot43coord = c43.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des43)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c43.timeCalculator(lot43coord, des43coord) + " minutes to get from " + lot0 + " to "  +  des43);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to hamptonRoads
       CarDriver c44 = new CarDriver(lot0, des44);
       Coordinate des44coord = c44.destinationArray.get(44); 
       Coordinate lot44coord = c44.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des44)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c44.timeCalculator(lot44coord, des44coord) + " minutes to get from " + lot0 + " to "  +  des44);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to northernNeck
       CarDriver c45 = new CarDriver(lot0, des45);
       Coordinate des45coord = c45.destinationArray.get(45); 
       Coordinate lot45coord = c45.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des45)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c45.timeCalculator(lot45coord, des45coord) + " minutes to get from " + lot0 + " to "  +  des45);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to piedmont
       CarDriver c46 = new CarDriver(lot0, des46);
       Coordinate des46coord = c46.destinationArray.get(46); 
       Coordinate lot46coord = c46.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des46)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c46.timeCalculator(lot46coord, des46coord) + " minutes to get from " + lot0 + " to "  +  des46);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to sandbridge
       CarDriver c47 = new CarDriver(lot0, des47);
       Coordinate des47coord = c40.destinationArray.get(47); 
       Coordinate lot47coord = c40.lotArray.get(0); //wc
       
       if (s.equals(lot0) && s2.equals(des47)){
    	   outputArea.setText("");
    	   try {
			outputArea.append( "The daily cost will be " + price + "\n" 
			   		+ "It takes " + c47.timeCalculator(lot47coord, des47coord) + " minutes to get from " + lot0 + " to "  +  des47);
		} catch (WrongPassNameException e7) {
			e7.printStackTrace();
		}
       }
       
       //wc to skylineFitnessCenter
       //wc to southside
       //wc to tidewater
       //wc to commonwealth
       //wc to dominion
       //wc to amherst
       //wc to brunswick
       //wc to carroll
       //wc to dickenson
       //wc to essex
       //wc to franklin
       //wc to grayson
       //wc to hanover
		
       
       
       

   }
 	


   /* Creates a myframe and makes it visible */
   public static void main(String[] args) {
      // Creates myframe and its components
      GUI myFrame = new GUI();
      
      
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
      
      
   }
}