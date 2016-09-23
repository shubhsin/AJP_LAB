import java.net.*;
import java.rmi.*;

public class BubSortServer
{
  public static void main(String[] args) {
    try{
      BubSortServerImpl bubSortServerImpl = new BubSortServerImpl();
      Naming.rebind("BubSortServer",bubSortServerImpl);
    }
    catch(Exception e) {
      System.out.println("Exception: "+e);
    }
  }
}
