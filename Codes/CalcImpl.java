import java.rmi.*;
import java.rmi.server.*;

public class CalcImpl extends UnicastRemoteObject implements Calc
 {
    int res;

    public int add(int n1,int n2)
     {
        res=n1+n2;

       return(res);
     }

    public int sub(int n1,int n2)
     {
        res=n2-n1;

       return(res);
     }

    public int sm(int n1,int n2)
     {
        res=n2*n1;

       return(res);
     }

    CalcImpl() throws RemoteException
     {
       super();
     }
 }