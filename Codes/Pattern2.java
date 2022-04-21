import java.io.File.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class Pattern2
 {
    public static void main( String args[]) throws IOException
     {
        BufferedImage img=new BufferedImage(1000,1000,1);
        File f=null;

        int width=img.getWidth();
        int height=img.getHeight();

        for(int i=0;i<height;i++)
         {
            for(int j=0;j<width;j++)
             {
                int p=(0<<24) | (255<<16) | (255<<8) | 255;
                img.setRGB(i,j,p);
             }
         }

        for(int i=0;i<height/4;i++)
         {
            for(int j=0;j<width/4;j++)
             {
                int p=(0<<24) | (0<<16) | (0<<8) | 255;
                img.setRGB(i,j,p);
             }
         }

        for(int i=height/4;i<height/2;i++)
         {
            for(int j=width/4;j<width/2;j++)
             {
                int p=(0<<24) | (0<<16) | (0<<8) | 255;
                img.setRGB(i,j,p);
             }
         }

        for(int i=height/2;i<3*height/4;i++)
         {
            for(int j=width/2;j<3*width/4;j++)
             {
                int p=(0<<24) | (0<<16) | (0<<8) | 255;
                img.setRGB(i,j,p);
             }
         }

        for(int i=3*height/4;i<height;i++)
         {
            for(int j=3*width/4;j<width;j++)
             {
                int p=(0<<24) | (0<<16) | (0<<8) | 255;
                img.setRGB(i,j,p);
             }
         }

        try
         {
            f=new File("C:/Ankita/Output.jpg");

            ImageIO.write(img,"jpg",f);
         }

        catch(IOException e)
         {
            System.out.println(e);
         }
     }
 }