import java.rmi.*;
import java.io.*;

public class BubSortClient {
  public static void main(String[] args) {
    try {
      String bubSortServerURL = "rmi://"+args[0]+"/BubSortServer";
      BubSortInterface bubSortServerIntf =(BubSortInterface)Naming.lookup(bubSortServerURL);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("Enter number of elements");
      int arrCount = Integer.parseInt(br.readLine());
      int[] dataArray = new int[arrCount];
      for (int i = 0; i<arrCount; i++) {
        System.out.println("Enter element "+i);
        dataArray[i] = Integer.parseInt(br.readLine());
      }
      int[] resultArray = bubSortServerIntf.bubbleSort(dataArray);
      System.out.println("ASCENDING ORDER IS :");
      for (int j=0; j< resultArray.length; j++) {
        System.out.println(resultArray[j]);
      }
    }
    catch(Exception e){
      System.out.println("Exception :"+e);
    }
  }
}
