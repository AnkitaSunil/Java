import java.net.*;
import java.*;
import java.util.Scanner;
import java.io.*;

class UDPClient
 {
    public static void main(String args[])throws Exception
     {
        Scanner in = new Scanner(System.in);

        DatagramSocket ds= new DatagramSocket();
        InetAddress ip=InetAddress.getByName("localhost");

        byte[] sd=new byte[1024];
        byte[] rd=new byte[1024];

        System.out.println("R: Reverse\nF: Fibonacci");
        System.out.print("Enter your choice: ");
        String ch=in.nextLine();

        System.out.print("Enter the number: ");
        String inp=in.nextLine();

        String s=new String();

        s=s.concat(ch);
        s=s.concat(" ");
        s=s.concat(inp);
        s=s.concat(" ");
        s=s.concat("*");

        sd=s.getBytes();

        DatagramPacket dp= new DatagramPacket(sd,sd.length,ip,9789);
        ds.send(dp);

        DatagramPacket dpr=new DatagramPacket(rd,rd.length);
        ds.receive(dpr);

        String st=new String(dpr.getData());
        System.out.println("Output: "+st);

        ds.close();
    }
 }