import java.rmi.*;

public interface BubSortInterface extends Remote{
  int[] bubbleSort(int[] dataArray) throws RemoteException;
//  int giveLength(String s) throws RemoteException; // return length of the string
}
