import java.io.File.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class Expt1
 {
    public static void main( String args[]) throws IOException
     {
        BufferedImage image=null;
        File f=null;

        try
         {
            f= new File("C:/Ankita/Water lilies.jpg");
            image=ImageIO.read(f);
         }
        catch(IOException e)
         { 
            System.out.println(e);
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