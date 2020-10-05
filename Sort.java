import java.io.*;
import java.util.*;

public class Sort {
  
  public static void main(String[] args) throws IOException {
    
    ArrayList<String> words = new ArrayList<String>(); 
    BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
    
    String currentLine = null;
    while((currentLine = br.readLine()) != null) {
      words.add(currentLine);
    }
    
    String[] wordArray = words.toArray(new String[1]);
    
    bubbleSort(wordArray);
    
    for(int i=0;i<wordArray.length;i++) {
      System.out.println(wordArray[i]);
    }
    
  }
  
  /**
   * This is a very naive implemnentation of bubble sort, it does not provide good performance. 
   *
   * This is used for demonstration purposes only.
   *  
  */
  public static void bubbleSort(String[] words) {
    
    for(int i=0; i< words.length-1; i++) {
      for(int j=i+1; j<words.length; j++) {
        if(words[j].compareTo(words[i]) < 0) {
          String s = words[j];
          words[j] = words[i];
          words[i] = s;
        }
      } 
    }
  }
  
}