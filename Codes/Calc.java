import java.rmi.*;

public interface Calc extends Remote
 {
   public int add(int n1,int n2) throws RemoteException;
   public int sub(int n1,int n2) throws RemoteException;
   public int sm(int n1,int n2) throws RemoteException;
 }