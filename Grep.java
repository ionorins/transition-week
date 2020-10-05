import java.io.*;

/* This class acts as a filter for the input piped in through standard input. 
 * It should act similarly to the standard tool grep
 *
*/

public class Grep {
  
  public static void main(String[] args) throws IOException {
    
    //The pattern will be passed in as the first parameter
    String pattern = args[0];
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String currentLine = null;
    while((currentLine = br.readLine()) != null) {
      
      //We simply print the line. here- We're not doing any useful work -you'll need to implement this! 
      System.out.println(currentLine);
    }
    
  }
  
}