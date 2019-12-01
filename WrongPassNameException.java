public class WrongPassNameException extends Exception {

   public WrongPassNameException() {
      super();
      System.out.println("Please enter a valid pass.");
   }
}