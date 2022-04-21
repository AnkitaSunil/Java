class Q_No_1
  {
    public static void main(String args[])
      {
        try
          {
            int a = 30, b = 0;
            int c = a/b;
            System.out.println ("Result = " + c);
          }
        catch(ArithmeticException e)
          {
            System.out.println ("Can't divide a number by 0!");
          }
      }
  }

/*
OUTPUT:

javac Q_No_1.java 
java Q_No_1
Can't divide a number by 0!
*/

