import java.rmi.*;
import java.rmi.server.*;
public class StropServerImpl extends UnicastRemoteObject implements StropInterface {
    public StropServerImpl() throws RemoteException {}
    public int giveLength(String s) throws RemoteException{
      return s.length();
    }
    public char giveAtTwo(String s) throws RemoteException{
      return s.charAt(2);
    }
    public String replaceWithA(String s) throws RemoteException{
      return s.replace('a', 'A');
    }
    public String returnSub(String s) throws RemoteException{
      return s.substring(2);
    }
    public String convertToUpper(String s) throws RemoteException{
      return s.toUpperCase();
    }


}
