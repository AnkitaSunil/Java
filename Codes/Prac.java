import java.io.File.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class Prac
 {
    public static void main( String args[]) throws IOException
     {
        BufferedImage image=new BufferedImage(3840,3840,1);
        File f=null;

        int p,r;
 
        for(int x=0;x<3840;x++)
         {
            for(int y=0;y<3840;y++)
             {
                r=(x+y);

                if(r%2==0)
                  r=x;

               else
                  r=y;

                p=(r<<24) | (r<<16) | (r<<8) | r;
                image.setRGB(y,x,p);
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