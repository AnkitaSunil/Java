import java.io.File.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.lang.Math;

public class HistEqual
 {
    public static void main( String args[]) throws IOException
     {
        BufferedImage image=null;
        File f=null;

        int i=0,n=256,sumr=0,r=0,g=0,b=0,a=0,x=0,y=0,p=0,max=0,sum=0,k=0;        

        int r1[]=new int[260];
        float r2[]=new float[260];
        int r3[]=new int[260];
        int r4[]=new int[260];

        for(i=0;i<n;i++)
         {
           r1[i]=0;
           r4[i]=0;
         }

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

        for(x=0;x<width;x++)
         {
            for(y=0;y<height;y++)
             {
                p=image.getRGB(x,y);

                a=(p>>24)&0xff;
                r=(p>>16)&0xff;
                g=(p>>8)&0xff;
                b=p&0xff;

                r1[r]=r1[r]+1;
             }
         }

        for(i=0;i<n;i++)
         {
            sum=sum+r1[i];
         }

        for(i=0;i<n;i++)
         {
           r2[i]=(float)r1[i]/(float)sum;
         }

        for(i=1;i<n;i++)
         {
           r2[i]=r2[i-1]+r2[i];
         }

        for(i=0;i<n;i++)
         {
           r2[i]=(n-1)*r2[i];
         }

        for(i=0;i<n;i++)
         {
            r3[i]=Math.round(r2[i]);
         }

        for(i=0;i<n;i++)
         {
            k=r3[i];

            r4[k]=r1[i]+r4[k];
         }

        for(i=0;i<n;i++)
         {
           if(max<r4[i])
             max=r4[i];
         }

        max=r4[0];

        for(i=1;i<n;i++)
         {
           if(max<r4[i])
             max=r4[i];
         }

        BufferedImage image1=new BufferedImage(256,max,1);

        for(x=0;x<256;x++)
         {
            for(y=0;y<max;y++)
             {                
                p=(a<<24) | (255<<16) | (255<<8) | 255;
                image1.setRGB(x,y,p);
             }
         }

        for(x=0;x<256;x++)
         {
            for(y=0;y<r4[x];y++)
             {                
                p=(a<<24) | (0<<16) | (0<<8) |0;
                image1.setRGB(x,y,p);
             }
         }

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