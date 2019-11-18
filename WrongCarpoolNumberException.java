public class WrongCarpoolNumberException extends Exception {

   public WrongCarpoolNumberException() {
      super();
      System.out.println("Please enter a positive integer.");
   }
}
