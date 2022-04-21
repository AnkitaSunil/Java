import java.io.File.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class CS

 {
    public static void main( String args[]) throws IOException
     {
        BufferedImage image=null;
        File f=null;

        try
         {
            f= new File("C:/Ankita/B.jpg");
            image=ImageIO.read(f);
         }

        catch(IOException e)
         { 
            System.out.println(e);
         }

        int width=image.getWidth();
        int height=image.getHeight();

        int p=image.getRGB(0,0);
        int r=(p>>16)&0xff;
        int g=(p>>8)&0xff;
        int b=p&0xff;

        int minr=r;
        int maxr=r;
        int ming=g;
        int maxg=g;
        int minb=b;
        int maxb=b;

        for(int x=0;x<width;x++)
         {
            for(int y=0;y<height;y++)
             {
                p=image.getRGB(x,y);

                int a=(p>>24)&0xff;
                r=(p>>16)&0xff;
                g=(p>>8)&0xff;
                b=p&0xff;

                if(r<minr)
                  minr=r;
                if(r>maxr)
                  maxr=r;

                if(g<ming)
                  ming=g;
                if(g>maxg)
                  maxg=g;

                if(b<minb)
                  minb=b;
                if(b>maxb)
                  maxb=b;
             }
         }

        for(int x=0;x<width;x++)
         {
            for(int y=0;y<height;y++)
             {
                p=image.getRGB(x,y);

                int a=(p>>24)&0xff;
                r=(p>>16)&0xff;
                g=(p>>8)&0xff;
                b=p&0xff;

                int sr=(255*(r-minr))/(maxr-minr);
                int sg=(255*(g-ming))/(maxg-ming);
                int sb=(255*(b-minb))/(maxb-minb);

                p=(a<<24) | (sr<<16) | (sg<<8) | sb;
                image.setRGB(x,y,p);
             }
         }

        System.out.println("Success!!!");

        try
         {
            f=new File("C:/Ankita/Output.jpg");

            ImageIO.write(image,"jpg",f);
         }

        catch(IOException e)
         {
            System.out.println(e);
         }
     }
 }