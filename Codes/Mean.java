import java.io.File.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.lang.Math;

public class Mean
 {
    public static void main( String args[]) throws IOException
     {
        BufferedImage image=null;
        File f=null;

        int i=0,r=0,g=0,b=0,a=0,x=0,y=0,p=0;

        try
         {
            f= new File("C:/Ankita/ABC.jpg");
            image=ImageIO.read(f);
         }

        catch(IOException e)
         { 
            System.out.println(e);
         }

        int width=image.getWidth();
        int height=image.getHeight();

        int r1[][]=new int[width][height];
        float r2[][]=new float[width][height];
        int g1[][]=new int[width][height];
        float g2[][]=new float[width][height];
        int b1[][]=new int[width][height];
        float b2[][]=new float[width][height];
        int mask[][]=new int[3][3];

        for(x=0;x<3;x++)
         for(y=0;y<3;y++)
           mask[x][y]=1;

        for(x=0;x<width;x++)
         {
            for(y=0;y<height;y++)
             {
                p=image.getRGB(x,y);

                a=(p>>24)&0xff;
                r=(p>>16)&0xff;
                g=(p>>8)&0xff;
                b=p&0xff;

                r1[x][y]=r;
                g1[x][y]=g;
                b1[x][y]=b;
             }
         }

        //Corners
        r2[0][0]=(r1[0][0]*mask[1][1]) + (r1[1][0]*mask[1][2]) + (r1[0][1]*mask[2][1]) + (r1[1][1]*mask[2][2]);
        r2[0][height-1]=(r1[0][height-1]*mask[1][1]) + (r1[0][height-2]*mask[0][1]) + (r1[1][height-2]*mask[0][2]) + (r1[1][height-1]*mask[1][2]);
        r2[width-1][0]=(r1[width-1][0]*mask[1][1]) + (r1[width-1][1]*mask[2][1]) + (r1[width-2][0]*mask[1][0]) + (r1[width-2][1]*mask[2][0]);
        r2[width-1][height-1]=(r1[width-1][height-1]*mask[1][1]) + (r1[width-1][height-2]*mask[0][1]) + (r1[width-2][height-1]*mask[1][0]) + (r1[width-2][height-2]*mask[0][0]);

        g2[0][0]=(g1[0][0]*mask[1][1]) + (g1[1][0]*mask[1][2]) + (g1[0][1]*mask[2][1]) + (g1[1][1]*mask[2][2]);
        g2[0][height-1]=(g1[0][height-1]*mask[1][1]) + (g1[0][height-2]*mask[0][1]) + (g1[1][height-2]*mask[0][2]) + (g1[1][height-1]*mask[1][2]);
        g2[width-1][0]=(g1[width-1][0]*mask[1][1]) + (g1[width-1][1]*mask[2][1]) + (g1[width-2][0]*mask[1][0]) + (g1[width-2][1]*mask[2][0]);
        g2[width-1][height-1]=(g1[width-1][height-1]*mask[1][1]) + (g1[width-1][height-2]*mask[0][1]) + (g1[width-2][height-1]*mask[1][0]) + (g1[width-2][height-2]*mask[0][0]);

        b2[0][0]=(b1[0][0]*mask[1][1]) + (b1[1][0]*mask[1][2]) + (b1[0][1]*mask[2][1]) + (b1[1][1]*mask[2][2]);
        b2[0][height-1]=(b1[0][height-1]*mask[1][1]) + (b1[0][height-2]*mask[0][1]) + (b1[1][height-2]*mask[0][2]) + (b1[1][height-1]*mask[1][2]);
        b2[width-1][0]=(b1[width-1][0]*mask[1][1]) + (b1[width-1][1]*mask[2][1]) + (b1[width-2][0]*mask[1][0]) + (b1[width-2][1]*mask[2][0]);
        b2[width-1][height-1]=(b1[width-1][height-1]*mask[1][1]) + (b1[width-1][height-2]*mask[0][1]) + (b1[width-2][height-1]*mask[1][0]) + (b1[width-2][height-2]*mask[0][0]);

        for(i=1;i<width-1;i++)
         {
            r2[i][0]=(r1[i][0]*mask[1][1]) + (r1[i-1][0]*mask[1][0]) + (r1[i+1][0]*mask[1][2]);
            r2[i][0]=r2[i][0] + ((r1[i][1]*mask[2][1]) + (r1[i-1][1]*mask[2][0]) + (r1[i+1][1]*mask[2][2]));
            r2[i][height-1]=(r1[i][height-1]*mask[1][1]) + (r1[i-1][height-1]*mask[1][0]) + (r1[i+1][height-1]*mask[1][2]);
            r2[i][height-1]=r2[i][height-1] + ((r1[i][height-2]*mask[0][1]) + (r1[i-1][height-2]*mask[0][0]) + (r1[i+1][height-2]*mask[0][2]));

            g2[i][0]=(g1[i][0]*mask[1][1]) + (g1[i-1][0]*mask[1][0]) + (g1[i+1][0]*mask[1][2]);
            g2[i][0]=g2[i][0] + ((g1[i][1]*mask[2][1]) + (g1[i-1][1]*mask[2][0]) + (g1[i+1][1]*mask[2][2]));
            g2[i][height-1]=(g1[i][height-1]*mask[1][1]) + (g1[i-1][height-1]*mask[1][0]) + (g1[i+1][height-1]*mask[1][2]);
            g2[i][height-1]=g2[i][height-1] + ((g1[i][height-2]*mask[0][1]) + (g1[i-1][height-2]*mask[0][0]) + (g1[i+1][height-2]*mask[0][2]));

            b2[i][0]=(b1[i][0]*mask[1][1]) + (b1[i-1][0]*mask[1][0]) + (b1[i+1][0]*mask[1][2]);
            b2[i][0]=b2[i][0] + ((b1[i][1]*mask[2][1]) + (b1[i-1][1]*mask[2][0]) + (b1[i+1][1]*mask[2][2]));
            b2[i][height-1]=(b1[i][height-1]*mask[1][1]) + (b1[i-1][height-1]*mask[1][0]) + (b1[i+1][height-1]*mask[1][2]);
            b2[i][height-1]=b2[i][height-1] + ((b1[i][height-2]*mask[0][1]) + (b1[i-1][height-2]*mask[0][0]) + (b1[i+1][height-2]*mask[0][2]));
         }

        for(i=1;i<height-1;i++)
         {
            r2[0][i]=(r1[0][i]*mask[1][1]) + (r1[0][i+1]*mask[2][1]) + (r1[0][i-1]*mask[0][1]);
            r2[0][i]=r2[0][i] + ((r1[1][i]*mask[1][2]) + (r1[1][i+1]*mask[2][2]) + (r1[1][i-1]*mask[0][2]));
            r2[width-1][i]=(r1[width-1][i]*mask[1][1]) + (r1[width-1][i+1]*mask[2][1]) + (r1[width-1][i-1]*mask[0][1]);
            r2[width-1][i]=r2[width-1][i] +((r1[width-2][i]*mask[1][0]) + (r1[width-2][i+1]*mask[2][0]) + (r1[width-2][i-1]*mask[0][0]));

            g2[0][i]=(g1[0][i]*mask[1][1]) + (g1[0][i+1]*mask[2][1]) + (g1[0][i-1]*mask[0][1]);
            g2[0][i]=g2[0][i] + ((g1[1][i]*mask[1][2]) + (g1[1][i+1]*mask[2][2]) + (g1[1][i-1]*mask[0][2]));
            g2[width-1][i]=(g1[width-1][i]*mask[1][1]) + (g1[width-1][i+1]*mask[2][1]) + (g1[width-1][i-1]*mask[0][1]);
            g2[width-1][i]=g2[width-1][i] +((g1[width-2][i]*mask[1][0]) + (g1[width-2][i+1]*mask[2][0]) + (g1[width-2][i-1]*mask[0][0]));

            b2[0][i]=(b1[0][i]*mask[1][1]) + (b1[0][i+1]*mask[2][1]) + (b1[0][i-1]*mask[0][1]);
            b2[0][i]=b2[0][i] + ((b1[1][i]*mask[1][2]) + (b1[1][i+1]*mask[2][2]) + (b1[1][i-1]*mask[0][2]));
            b2[width-1][i]=(b1[width-1][i]*mask[1][1]) + (b1[width-1][i+1]*mask[2][1]) + (b1[width-1][i-1]*mask[0][1]);
            b2[width-1][i]=b2[width-1][i] +((b1[width-2][i]*mask[1][0]) + (b1[width-2][i+1]*mask[2][0]) + (b1[width-2][i-1]*mask[0][0]));
         }

        for(x=1;x<width-1;x++)
         {
            for(y=1;y<height-1;y++)
             {
                r2[x][y]=(r1[x][y]*mask[1][1]) + (r1[x][y-1]*mask[0][1]) + (r1[x][y+1]*mask[2][1]);
                r2[x][y]=r2[x][y] + ((r1[x-1][y-1]*mask[0][0]) + (r1[x-1][y]*mask[1][0]) + (r1[x-1][y+1]*mask[2][0]));
                r2[x][y]=r2[x][y] + ((r1[x+1][y-1]*mask[0][2]) + (r1[x+1][y]*mask[1][2]) + (r1[x+1][y+1]*mask[2][2]));

                g2[x][y]=(g1[x][y]*mask[1][1]) + (g1[x][y-1]*mask[0][1]) + (g1[x][y+1]*mask[2][1]);
                g2[x][y]=g2[x][y] + ((g1[x-1][y-1]*mask[0][0]) + (g1[x-1][y]*mask[1][0]) + (g1[x-1][y+1]*mask[2][0]));
                g2[x][y]=g2[x][y] + ((g1[x+1][y-1]*mask[0][2]) + (g1[x+1][y]*mask[1][2]) + (g1[x+1][y+1]*mask[2][2]));

                b2[x][y]=(b1[x][y]*mask[1][1]) + (b1[x][y-1]*mask[0][1]) + (b1[x][y+1]*mask[2][1]);
                b2[x][y]=b2[x][y] + ((b1[x-1][y-1]*mask[0][0]) + (b1[x-1][y]*mask[1][0]) + (b1[x-1][y+1]*mask[2][0]));
                b2[x][y]=b2[x][y] + ((b1[x+1][y-1]*mask[0][2]) + (b1[x+1][y]*mask[1][2]) + (b1[x+1][y+1]*mask[2][2]));
             }
         }

        for(x=0;x<width;x++)
         {
            for(y=0;y<height;y++)
             {
                r2[x][y]=r2[x][y]/9;
                g2[x][y]=g2[x][y]/9;
                b2[x][y]=b2[x][y]/9;
             }
         }

        for(x=0;x<width;x++)
         {
            for(y=0;y<height;y++)
             {
                r1[x][y]=Math.round(r2[x][y]);
                g1[x][y]=Math.round(g2[x][y]);
                b1[x][y]=Math.round(b2[x][y]);
             }
         }

        BufferedImage image1=new BufferedImage(width,height,1);

        for(x=0;x<width;x++)
         {
            for(y=0;y<height;y++)
             {
                r=r1[x][y];
                g=g1[x][y];
                b=b1[x][y];

                p=(a<<24) | (r<<16) | (g<<8) | b;
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