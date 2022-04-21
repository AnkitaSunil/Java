import java.net.*;
import java.io.*;

class func
 {
    int b, k=1,l=0,i;

    int Reverse(int a)
     {
        b=a;

        while(b!=0)
         {
            b=b/10;
            l=l+1;
         }

        for(b=1;b<l;b++)
         k=k*10;

        b=0;

        while(a!=0)
         {
            l=a%10;
            b=b+(l*k);
            k=k/10;
            a=a/10;
         }

        return b;
     }
 }

class UDPServer 
 {
    public static void main(String args[]) throws Exception
     {
        DatagramSocket ds=new DatagramSocket(9789);

        byte[] recvData=new byte[1024];
        byte[] sendData=new byte[1024];

        int a=0,b=0,i=0,n=0;

        func obj=new func();

        DatagramPacket dp=new DatagramPacket(recvData,recvData.length);
        ds.receive(dp);

        String sent=new String(dp.getData());

        InetAddress ip=dp.getAddress();
        int port=dp.getPort();

        String [] s = sent.split(" ");

        n=Integer.parseInt(s[1]);

        if(s[0].equals("R"))
         {
            a=obj.Reverse(n);

            String s1=Integer.toString(a);
            sendData=s1.getBytes();

            DatagramPacket dps=new DatagramPacket(sendData,sendData.length,ip,port);
            ds.send(dps);
         }

        else if(s[0].equals("F"))
         {
            String s1="0";
            s1=s1.concat("  1");

            a=0;
            b=1;

           for(i=0;i<n-2;i++)
            {
               a=a+b;
               int temp=a;
               a=b;
               b=temp;

               String s2=Integer.toString(b);

               s1=s1.concat("  ");
               s1=s1.concat(s2);
            }

            sendData=s1.getBytes();

            DatagramPacket dps=new DatagramPacket(sendData,sendData.length,ip,port);
            ds.send(dps);
         }

        ds.close();
     }
 }