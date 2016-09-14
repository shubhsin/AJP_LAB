import java.io.*;

class exphand {
  public static void main(String[] args) throws Exception {

    System.out.println("Type the generation of the iPhone -");
    InputStreamReader r=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(r);
    String num=br.readLine();
    int gen = Integer.parseInt(num);

    String[] iPhoneArray = {"iPhone", "iPhone 3G", "iPhone 3GS","iPhone 4","iPhone 4S","iPhone 5","iPhone 5S","iPhone 6","iPhone 6S"};

    try {
      String selected = iPhoneArray[gen-1];
      System.out.println("Selected iPhone is -"+selected);
    }
    catch(Exception e) {
        System.out.print(e);
        System.out.println("No such iPhone exists for this generation");
    }
  }
}
