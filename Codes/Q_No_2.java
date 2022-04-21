public class Q_No_2
  {
    public int sum(int x, int y)
      {
        return(x+y);
      }

    public int sum(int x, int y, int z)
      {
        return(x+y+z);
      }

    public double sum(double x, double y)
      {
        return(x+y);
      }

    public static void main(String args[])
      {
        Q_No_2 s = new Q_No_2();

        System.out.println(s.sum(10, 20));

        System.out.println(s.sum(10, 20, 30));

        System.out.println(s.sum(10.5, 20.5));
      }
  }

/*
OUTPUT:

javac Q_No_2.java 
java Q_No_2
30
60
31.0
*/
