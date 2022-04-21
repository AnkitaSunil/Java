class balance
  {
    String name;
    double bal;

    balance(String n,double b)
      {
        name=n;
        bal=b;
      }

    void show()
      {
        System.out.println(name +": $"+bal);
      }
  }

class Q_No_3
  {
    public static void main(String args[])
      {
        balance current[]=new balance[2];
        current[0]=new balance("Sunil",1000);
        current[1]=new balance("Ankita",500);

        for(int i=0;i<2;i++)
          current[i].show();
      }
  }

/*
OUTPUT:

javac Q_No_3.java 
java Q_No_3
Sunil: $1000.0
Ankita: $500.0
*/
