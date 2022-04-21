import java.rmi.*;
import java.rmi.registry.*;

public class MyServer
 {
   public static void main(String arg[])
    {
      try
       {
         Calc s=new CalcImpl();
         Naming.rebind("rmi://localhost:5000/ss",s);
       }

      catch(Exception e)
       { }
    }
 }