import java.rmi.*;
import java.rmi.server.*;
public class BubSortServerImpl extends UnicastRemoteObject implements BubSortInterface {
    public BubSortServerImpl() throws RemoteException {}
    public int[] bubbleSort(int[] dataArray) throws RemoteException{
      int c,d,swap;
      int n = dataArray.length;
      for (c = 0; c < ( n - 1 ); c++) {
      for (d = 0; d < n - c - 1; d++) {
        if (dataArray[d] > dataArray[d+1]) /* For descending order use < */
        {
          swap = dataArray[d];
          dataArray[d] = dataArray[d+1];
          dataArray[d+1] = swap;
        }
      }
    }
      return dataArray;
    }
}
