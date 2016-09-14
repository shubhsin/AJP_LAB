import java.net.*;
import java.rmi.*;

public class StropServer
{
  public static void main(String[] args) {
    try{
      StropServerImpl stropServerImpl = new StropServerImpl();
      Naming.rebind("StropServer",stropServerImpl);
    }
    catch(Exception e) {
      System.out.println("Exception: "+e);
    }
  }
}
