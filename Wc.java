import java.io.*;

public class Wc {
  
  /**
   * This is a very simple prgram that counts words and lines. 
   * It is not particularly efficient!
  */
    
  public static void main(String[] args) throws IOException {
  
    BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
    
    int lines = 0;
    int words = 0;
    
    String currentLine = null;

    while((currentLine = br.readLine()) != null) {  
      //We have read a line so increment line count
      lines++;
      
      //Split the current line by spaces and add the size of the created array to the total words
      String[] wordsSplit = currentLine.split(" ");
      words += wordsSplit.length;
        
    }
    
    System.out.println("\t" + lines + "\t" + words + "\t" + args[0]);
    
    
  }
  
}