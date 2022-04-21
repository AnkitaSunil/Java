import java.io.File.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class Threshold
 {
    public static void main( String args[]) throws IOException
     {
        BufferedImage image=null;
        File f=null;
        int t=100;

        try
         {
            f= new File("C:/Ankita/Penguins.jpg");
            image=ImageIO.read(f);
         }

        catch(IOException e)
         { 
            System.out.println(e);
         }

        int width=image.getWidth();
        int height=image.getHeight();
 
        for(int x=0;x<width;x++)
         {
            for(int y=0;y<height;y++)
             {
                int p=image.getRGB(x,y);

                int a=(p>>24)&0xff;
                int r=(p>>16)&0xff;
                int g=(p>>8)&0xff;
                int b=p&0xff;
 
                if(r>=t && g>=t && b>=t)
                  r=g=b=255;
                else
                  r=g=b=0;

                p=(a<<24) | (r<<16) | (g<<8) | b;
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