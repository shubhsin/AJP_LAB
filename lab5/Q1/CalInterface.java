import java.rmi.*;

public interface CalInterface extends Remote{
  double add(double d1,double d2) throws RemoteException;
  double subtract(double d1,double d2) throws RemoteException;
  double multiply(double d1,double d2) throws RemoteException;
  double divide(double d1,double d2) throws RemoteException;
  double expo(double d1,double d2) throws RemoteException;
}
