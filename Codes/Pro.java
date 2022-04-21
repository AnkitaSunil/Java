import java.io.File.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.lang.Math;

public class Pro
 {
    public static void main( String args[]) throws IOException
     {
        BufferedImage image=null,image1=null;
        File f=null,f1=null;

        int i=0,r=0,g=0,b=0,a=0,x=0,y=0,p=0,count=0;
        int r1=0,g1=0,b1=0,a1=0,x1=0,y1=0,p1=0; 

        int [][] ra=new int[1000][1000];     

        try
         {
            f= new File("C:/Ankita/ABC.jpg");
            image=ImageIO.read(f);
         }

        catch(IOException e)
         { 
            System.out.println(e);
         }

        try
         {
            f1= new File("C:/Ankita/ABC.jpg");
            image1=ImageIO.read(f1);
         }

        catch(IOException e)
         { 
            System.out.println(e);
         }

        int width=image.getWidth();
        int height=image.getHeight();

        int width1=image1.getWidth();
        int height1=image1.getHeight();

        if(width>width1)
         width=width1;

        if(height>height1)
         height=height1;

        for(x=0;x<width;x++)
         {
            for(y=0;y<height;y++)
             {
                p=image.getRGB(x,y);
                p1=image1.getRGB(x,y);

                a=(p>>24)&0xff;
                r=(p>>16)&0xff;
                g=(p>>8)&0xff;
                b=p&0xff;

                a1=(p1>>24)&0xff;
                r1=(p1>>16)&0xff;
                g1=(p1>>8)&0xff;
                b1=p1&0xff;

                ra[x][y]=(int)((r*.3)+(g*.59)+(.11*b));
             }

         }


        for(x=0;x<width;x++)
          {
             for(y=0;y<height;y++)
               System.out.print(ra[x][y]+"  ");

               System.out.println();
          }

        int per=(width*height)*75/100;

         System.out.println(count);

        if(count>=per)
         System.out.println("Matched");

        else
          System.out.println("Not-matched");
     }
 }