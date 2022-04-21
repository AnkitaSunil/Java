import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;

public class MyClient
 {
   public static void main(String arg[])
    {
      Scanner in = new Scanner(System.in);

      int i=0,ch=0,res=0,n1,n2;

      try
       {
         Calc stub=(Calc)Naming.lookup("rmi://localhost:5000/ss");

         System.out.println("1. Addition\n2.Subtraction\n3.Scalar Multiplication");
         System.out.print("\nEnter your choice: ");
         ch=in.nextInt();

         if(ch==1)
          {
            System.out.print("\nEnter the vector 1: ");
            n1=in.nextInt();

            System.out.print("\nEnter the vector 2: ");
            n2=in.nextInt();

            res=stub.add(n1,n2);

            System.out.println("Result: "+res);
          }

         else if(ch==2)
          {
            System.out.print("\nEnter the vector 1: ");
            n1=in.nextInt();

            System.out.print("\nEnter the vector 2: ");
            n2=in.nextInt();

            res=stub.sub(n1,n2);
            System.out.println("\nResult: "+res);
          }

         else if(ch==3)
          {
            System.out.print("\nEnter the vector: ");
            n1=in.nextInt();

            System.out.print("\nEnter the scalar: ");
            n2=in.nextInt();

            res=stub.sm(n1,n2);
            System.out.println("\nResult: "+res);
          }
       }

      catch(Exception e)

       {
         System.out.println(e.getMessage());
       }
    }
 }