import java.util.Scanner;

public class Matrix
{
  public static void main (String args[])
   {
     int a[][] = new int[3][3];
     int b[][] = new int[3][3];

     int i, j ,k;
   
     Scanner s = new Scanner(System.in);
    
     int c[][] = new int[3][3];

     System.out.println("Enter the elements of Matrix A:");

     for(i = 0; i < 3; i++)
      for(j = 0; j < 3; j++)
        a[i][j] = s.nextInt();

     System.out.println("Enter the elements of Matrix B:");

     for(i = 0; i < 3; i++)
      for(j = 0; j < 3; j++)
        b[i][j] = s.nextInt();

     for(i = 0; i < 3; i++)
      for(j = 0; j < 3; j++)
       for(k = 0; k < 3; k++)
        c[i][j] = c[i][j]+(a[i][k]*b[k][j]);

     System.out.println("\nMatrix A:\n");
     for (i = 0; i < 3; i++)
      {
        for (j = 0; j < 3; j++)
         System.out.print (" "+a[i][j]);

        System.out.println();
      }

     System.out.println("\nMatrix B:\n");
     for (i = 0; i < 3; i++)
      {
        for (j = 0; j < 3; j++)
         System.out.print (" "+b[i][j]);

        System.out.println();
      }

     System.out.println("\nMatrix C: Matrix A*Matrix B\n");
     for (i = 0; i < 3; i++)
      {
        for (j = 0; j < 3; j++)
         System.out.print (" "+c[i][j]);

        System.out.println();
      }
   }
 }