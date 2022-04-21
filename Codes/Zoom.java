import java.io.File.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class Zoom
 {
    public static void main( String args[]) throws IOException
     {
        BufferedImage image=null;
        File f=null;

        try
         {
            f= new File("C:/Ankita/1.jpg");
            image=ImageIO.read(f);
         }

        catch(IOException e)
         { 
            System.out.println(e);
         }

        int width=image.getWidth();
        int height=image.getHeight();

        BufferedImage image1=new BufferedImage(2*width,2*height,1);
 
        for(int x=0;x<2*width;x++)
         {
            for(int y=0;y<2*height;y++)
             {
                int p=image.getRGB(x/2,y/2);

                int a=(p>>24)&0xff;
                int r=(p>>16)&0xff;
                int g=(p>>8)&0xff;
                int b=p&0xff;

                p=(a<<24) | (r<<16) | (g<<8) | b;

                image1.setRGB(x,y,p);
             }
         }

        System.out.println("Success!!!");

        try
         {
            f=new File("C:/Ankita/Output.jpg");

            ImageIO.write(image1,"jpg",f);
         }

        catch(IOException e)
         {
            System.out.println(e);
         }
     }
 }