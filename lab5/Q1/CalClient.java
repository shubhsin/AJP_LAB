import java.rmi.*;

public class CalClient {
  public static void main(String[] args) {
    try {
      String calServerURL = "rmi://"+args[0]+"/CalServer";
      CalInterface calServerIntf =(CalInterface)Naming.lookup(calServerURL);
      System.out.println("The first number is : "+args[1]);
      double d1 = Double.valueOf(args[1]).doubleValue();
      System.out.println("The second number is: "+args[2]);
      double d2 = Double.valueOf(args[2]).doubleValue();
      System.out.println("The sum is: "+calServerIntf.add(d1,d2));
      System.out.println("The difference is: "+calServerIntf.subtract(d1,d2));
      System.out.println("The product is: "+calServerIntf.multiply(d1,d2));
      System.out.println("The fraction is: "+calServerIntf.divide(d1,d2));
      System.out.println("The exponent is :"+calServerIntf.expo(d1,d2));
    }
    catch(Exception e){
      System.out.println("Exception :"+e);
    }
  }
}
