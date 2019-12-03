import java.awt.BorderLayout;
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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class GUI2 extends JFrame implements ActionListener {
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
           "Carrow Hall",  "Carroll", "Carty House", "Center For The Arts", "Central Heating And Cooling Plant", 
           "Child Development Center", "Clock", "College Hall", "Commonwealth", "Cross Cottage" , 
           "David King Hall", "DeLaski Performing Arts Building", "Dickenson",  "Dominion", "EagleBank Arena", 
           "East Building", "Eastern Shore", "Eisenhower", "Enterprise Hall", "Essex", "Exploratory Hall", 
           "Facilities Administration", "Facilities Management Archives", "Facilities Management Operations",
           "Fenwick Library", "Field House And Module", "Finley Building",  "Franklin", "George Mason Statue", 
           "Greenhouse", "Grayson", "Hampton Roads", "Hanover","Harrison", "Harris Theatre", 
		   "Innovation Hall", "Jackson", "Jefferson", "Johnson Center", "Kelley II",  "Kennedy", "Krasnow Institute",
		   "Krug Hall", "Lecture Hall", "Liberty Square",  "Lincoln", "Madison", "Masonvale", "Merten Hall", "Monroe",
		   "Music Theater Building", "Nguyen Engineering Building", "Northeast Module", "Northeast Module II","Northern Neck", 
		   "Nottoway Annex", "Parking Services", "Peterson Hall", "Planetary Hall",  "Piedmont", "Police and Safety Hdqrt", 
		   "Potomac Heights", "Recreation and Athletic Complex","Recycling Center", "Research Hall", "Rivanna Module", 
		   "Robert's House", "Robinson Hall B", "Rogers",  "Roosevelt", "Sandbridge", "Skyline Fitness Center", 
			"Southside", "Student Union Building I", "Taylor", "Theater Space", "The Hub", "Thompson Hall", "Tidewater", 
			"Truman", "Warehouse", "Washington", "West Building", "West PE Module", "Whitetop", "Wilson", 
		};
   
   
   final JComboBox<String> cb2 = new JComboBox<String>(choices2);
 
   //String[] choices3 = { "1","2","3","4" };
   //final JComboBox<String> cb3 = new JComboBox<String>(choices3); 
   private JSpinner yearsSpinner; 
   
   

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   GUI2() {
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
       
	   EconomyPermit e1 = new EconomyPermit(lot0, des0);
	   double price = e1.westCampusDayPrice();
	   
	   CarDriver2 cd = new CarDriver2(s);
	   CarDriver2 cd2 = new CarDriver2(s2);
	   
	   Coordinate cr = cd.getCoord();
       Coordinate cr2 = cd2.getCoord();
       
		double db = cd.timeCalculator(cr, cr2);
		
		
      if(s.equals("West Campus")) {
       outputArea.setText("");
		outputArea.append( "Daily cost of a West Campus parking pass: $" + price + "\n" 
		   		+ "It takes " + db + " minutes to get from " + s + " to "  +  s2);
	   
      }
  
      else if(s.equals("Lot A") || s.equals("Lot C") || s.equals("Lot K") || s.equals("Lot L") || 
    		  s.equals("Lot M") || s.equals("Lot O") || s.equals("Lot P") || s.equals("Lot PV")) {
    	  GeneralLotPermit gl = new GeneralLotPermit(lot0, des0);
    	  double priceg = gl.generalLotDayPrice();
    	  	outputArea.setText("");
  			outputArea.append( "Daily cost of a General Lot parking pass: $" + priceg + "\n" 
  		   		+ "It takes " + db + " minutes to get from " + s + " to "  +  s2);
      }
      
      else if(s.equals("Lot J")) {
    	  LotJ lj = new LotJ(lot0, des0);
    	  double pricelj = lj.lotJDayPrice();
    	  	outputArea.setText("");
  			outputArea.append( "Daily cost of a Lot J parking pass: $" + pricelj + "\n" 
  		   		+ "It takes " + db + " minutes to get from " + s + " to "  +  s2);
      }
      
      else if(s.equals("Lot I")) {
    	  LotI li = new LotI(lot0, des0);
    	  double priceli = li.lotIDayPrice();
    	  	outputArea.setText("");
  			outputArea.append( "Daily cost of a Lot I parking pass: $" + priceli + "\n" 
  		   		+ "It takes " + db + " minutes to get from " + s + " to "  +  s2);
      }
      
      else if(s.equals("Shenandoah Parking Deck")) {
    	  Shenandoah shan = new Shenandoah(lot0, des0);
    	  double priceshan = shan.shenandoahDayPrice();
    	  	outputArea.setText("");
  			outputArea.append( "Daily cost of a Shenandoah Parking Deck parking pass: $" + priceshan + "\n" 
  		   		+ "It takes " + db + " minutes to get from " + s + " to "  +  s2);
      }
      
      else if(s.equals("Mason Pond Parking Deck")) {
    	  MasonPond mp = new MasonPond(lot0, des0);
    	  double pricemp = mp.masonPondDayPrice();
    	  	outputArea.setText("");
  			outputArea.append( "Daily cost of a Mason Pond Parking Deck parking pass: $" + pricemp + "\n" 
  		   		+ "It takes " + db + " minutes to get from " + s + " to "  +  s2);
      }
      
      else if(s.equals("Rappahannock River Parking Deck")) {
    	  Rappahannock rap = new Rappahannock(lot0, des0);
    	  double pricerap = rap.rappahannockDayPrice();
    	  	outputArea.setText("");
  			outputArea.append( "Daily cost of a Rappahannock River Parking Deck parking pass: $" + pricerap + "\n" 
  		   		+ "It takes " + db + " minutes to get from " + s + " to "  +  s2);
      }
	   
   }
   
   public static void main(String[] args) {
	      // Creates myframe and its components
	      GUI2 myFrame = new GUI2();
	      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      myFrame.setBackground(Color.BLUE); 
	      myFrame.pack();
	      myFrame.setVisible(true);
	      
	      
	   }
   
   
   //add image to GUI
   //take out exceptions
   //TAKE OUT carpool discounts
   
}
