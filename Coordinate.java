public class Coordinate {

   private final double x;
   private final double y;

   /**
    * Constructor
    * @param x the x value of the coordinate that will be set
    * @param y the y value of the coordinate that will be set
    */
   public Coordinate(double x, double y) {
      this.x = x;
      this.y = y;
   }

   /**
    *
    * @return the x value of the coordinate
    */
   public double getX() {
      return x;
   }

   /**
    *
    * @return the y value of the coordinate
    */
   public double getY() {
      return y;
   }

   /**
    *
    * @param dx the change of x value
    * @param dy the change of y value
    * @return the new coordinate value after the addition
    *
   public Coordinate plus(int dx, int dy) {
      return new Coordinate (x + dx, y + dy);
   }
    */


   /**
    *
    * @return the string representation of the coordinate
    */
   @Override public String toString() {
      return "(" + x + ", " + y + ")"; 
   }
}