import java.rmi.*;

public interface StropInterface extends Remote{
  int giveLength(String s) throws RemoteException; // return length of the string
  char giveAtTwo(String s) throws RemoteException; // Will return char at index 2
  String replaceWithA(String s) throws RemoteException; // Replace some char with 'A'
  String returnSub(String s) throws RemoteException; // Will return a substring
  String convertToUpper(String s) throws RemoteException; // Will return string in uppercase
}
