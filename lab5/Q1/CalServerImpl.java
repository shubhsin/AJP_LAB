import java.rmi.*;
import java.rmi.server.*;
public class CalServerImpl extends UnicastRemoteObject implements CalInterface {
    public CalServerImpl() throws RemoteException {}
    public double add(double d1,double d2) throws RemoteException{
      return d1 + d2;
    }
    public double subtract(double d1,double d2) throws RemoteException {
      return d1 - d2;
    }
    public double multiply(double d1,double d2) throws RemoteException {
      return d1 * d2;
    }
    public double divide(double d1,double d2) throws RemoteException {
      return d1 / d2;
    }
    public double expo(double d1,double d2) throws RemoteException{
      return Math.pow(d1, d2);
    }
}
