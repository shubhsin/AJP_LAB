import java.net.*;
import java.rmi.*;

public class CalServer
{
  public static void main(String[] args) {
    try{
      CalServerImpl calServerImpl = new CalServerImpl();
      Naming.rebind("CalServer",calServerImpl);
    }
    catch(Exception e) {
      System.out.println("Exception: "+e);
    }
  }
}
