class MyThread extends Thread
  {
    public void run()
      {
        System.out.print("Hi, I'm a Thread");
      }
  }
 
class Q_No_4
  {
    public static void main(String[] args)
      {
        MyThread thread1 = new MyThread();
        thread1.start();
        thread1.setName("T-1");
        String name1 = thread1.getName();
        System.out.print(" & my name is "+name1+"!\n");
      }
  }

/*
OUTPUT:

javac Q_No_4.java 
java Q_No_4
Hi, I'm a Thread & my name is T-1!
*/
