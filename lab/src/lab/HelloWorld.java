package lab;
/** Comment
 * Displays "Hello World!" to the standard output. 

Class Name: HelloWorld
Object Reference: helloObj (in Line 1)
Object Created: helloObj (In Line 2)
Member Function: printMessage
Field: output (String)
Static Member: helloObj
Instance Member : output (String)

 */
public class HelloWorld {
      String output = "";
      static HelloWorld helloObj;  //Line 1 

      public HelloWorld(){
            output = "Hello World";
      } 

      public String printMessage(){
            return output;
      } 

      public static void main (String args[]) {
            helloObj = new HelloWorld();  //Line 2
            System.out.println(helloObj.printMessage());
  }

}