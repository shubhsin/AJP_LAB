import java.rmi.*;
import java.io.*;

public class StropClient {
  public static void main(String[] args) {
    try {
      String stropServerURL = "rmi://"+args[0]+"/StropServer";
      StropInterface stropServerIntf =(StropInterface)Naming.lookup(stropServerURL);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter a string");
      String s= br.readLine();
      System.out.println("Length is : "+stropServerIntf.giveLength(s));
      System.out.println("Char at second index is : "+stropServerIntf.giveAtTwo(s));
      System.out.println("String after replacing a with A : "+stropServerIntf.replaceWithA(s));
      System.out.println("substring from index 2 is : "+stropServerIntf.returnSub(s));
      System.out.println("String in uppercase is : "+stropServerIntf.convertToUpper(s));

    }
    catch(Exception e){
      System.out.println("Exception :"+e);
    }
  }
}
