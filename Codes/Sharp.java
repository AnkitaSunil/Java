import java.io.File.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.lang.Math;

public class Sharp
 {
    public static void main( String args[]) throws IOException
     {
        BufferedImage image=null;
        File f=null;

        int i=0,r=0,g=0,b=0,a=0,x=0,y=0,p=0;

        try
         {
            f= new File("C:/Ankita/CBA.jpg");
            image=ImageIO.read(f);
         }

        catch(IOException e)
         { 
            System.out.println(e);
         }

        int width=image.getWidth();
        int height=image.getHeight();

        int r1[][]=new int[width][height];
        int r2[][]=new int[width][height];
        int r3[][]=new int[width][height];
        double r4[][]=new double[width][height];
        int g1[][]=new int[width][height];
        int g2[][]=new int[width][height];
        int g3[][]=new int[width][height];
        double g4[][]=new double[width][height];
        int b1[][]=new int[width][height];
        int b2[][]=new int[width][height];
        int b3[][]=new int[width][height];
        double b4[][]=new double[width][height];

        int maskv[][]=new int[3][3];
        int maskh[][]=new int[3][3];

        for(x=0;x<3;x++)
         for(y=0;y<3;y++)
           {
               if(y==0)
                maskv[x][y]=-1;
           
               if(y==2)
                maskv[x][y]=1;

               if(y==1)
                maskv[x][y]=0;
           }

        for(x=0;x<3;x++)
         for(y=0;y<3;y++)
           {
               if(x==0)
                maskh[x][y]=-1;
           
               if(x==2)
                maskh[x][y]=1;

               if(x==1)
                maskh[x][y]=0;
           }


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

        //VERTICAL
        //Corners
        r2[0][0]=(r1[0][0]*maskv[1][1]) + (r1[1][0]*maskv[1][2]) + (r1[0][1]*maskv[2][1]) + (r1[1][1]*maskv[2][2]);
        r2[0][height-1]=(r1[0][height-1]*maskv[1][1]) + (r1[0][height-2]*maskv[0][1]) + (r1[1][height-2]*maskv[0][2]) + (r1[1][height-1]*maskv[1][2]);
        r2[width-1][0]=(r1[width-1][0]*maskv[1][1]) + (r1[width-1][1]*maskv[2][1]) + (r1[width-2][0]*maskv[1][0]) + (r1[width-2][1]*maskv[2][0]);
        r2[width-1][height-1]=(r1[width-1][height-1]*maskv[1][1]) + (r1[width-1][height-2]*maskv[0][1]) + (r1[width-2][height-1]*maskv[1][0]) + (r1[width-2][height-2]*maskv[0][0]);

        g2[0][0]=(g1[0][0]*maskv[1][1]) + (g1[1][0]*maskv[1][2]) + (g1[0][1]*maskv[2][1]) + (g1[1][1]*maskv[2][2]);
        g2[0][height-1]=(g1[0][height-1]*maskv[1][1]) + (g1[0][height-2]*maskv[0][1]) + (g1[1][height-2]*maskv[0][2]) + (g1[1][height-1]*maskv[1][2]);
        g2[width-1][0]=(g1[width-1][0]*maskv[1][1]) + (g1[width-1][1]*maskv[2][1]) + (g1[width-2][0]*maskv[1][0]) + (g1[width-2][1]*maskv[2][0]);
        g2[width-1][height-1]=(g1[width-1][height-1]*maskv[1][1]) + (g1[width-1][height-2]*maskv[0][1]) + (g1[width-2][height-1]*maskv[1][0]) + (g1[width-2][height-2]*maskv[0][0]);

        b2[0][0]=(b1[0][0]*maskv[1][1]) + (b1[1][0]*maskv[1][2]) + (b1[0][1]*maskv[2][1]) + (b1[1][1]*maskv[2][2]);
        b2[0][height-1]=(b1[0][height-1]*maskv[1][1]) + (b1[0][height-2]*maskv[0][1]) + (b1[1][height-2]*maskv[0][2]) + (b1[1][height-1]*maskv[1][2]);
        b2[width-1][0]=(b1[width-1][0]*maskv[1][1]) + (b1[width-1][1]*maskv[2][1]) + (b1[width-2][0]*maskv[1][0]) + (b1[width-2][1]*maskv[2][0]);
        b2[width-1][height-1]=(b1[width-1][height-1]*maskv[1][1]) + (b1[width-1][height-2]*maskv[0][1]) + (b1[width-2][height-1]*maskv[1][0]) + (b1[width-2][height-2]*maskv[0][0]);

        for(i=1;i<width-1;i++)
         {
            r2[i][0]=(r1[i][0]*maskv[1][1]) + (r1[i-1][0]*maskv[1][0]) + (r1[i+1][0]*maskv[1][2]);
            r2[i][0]=r2[i][0] + ((r1[i][1]*maskv[2][1]) + (r1[i-1][1]*maskv[2][0]) + (r1[i+1][1]*maskv[2][2]));
            r2[i][height-1]=(r1[i][height-1]*maskv[1][1]) + (r1[i-1][height-1]*maskv[1][0]) + (r1[i+1][height-1]*maskv[1][2]);
            r2[i][height-1]=r2[i][height-1] + ((r1[i][height-2]*maskv[0][1]) + (r1[i-1][height-2]*maskv[0][0]) + (r1[i+1][height-2]*maskv[0][2]));

            g2[i][0]=(g1[i][0]*maskv[1][1]) + (g1[i-1][0]*maskv[1][0]) + (g1[i+1][0]*maskv[1][2]);
            g2[i][0]=g2[i][0] + ((g1[i][1]*maskv[2][1]) + (g1[i-1][1]*maskv[2][0]) + (g1[i+1][1]*maskv[2][2]));
            g2[i][height-1]=(g1[i][height-1]*maskv[1][1]) + (g1[i-1][height-1]*maskv[1][0]) + (g1[i+1][height-1]*maskv[1][2]);
            g2[i][height-1]=g2[i][height-1] + ((g1[i][height-2]*maskv[0][1]) + (g1[i-1][height-2]*maskv[0][0]) + (g1[i+1][height-2]*maskv[0][2]));

            b2[i][0]=(b1[i][0]*maskv[1][1]) + (b1[i-1][0]*maskv[1][0]) + (b1[i+1][0]*maskv[1][2]);
            b2[i][0]=b2[i][0] + ((b1[i][1]*maskv[2][1]) + (b1[i-1][1]*maskv[2][0]) + (b1[i+1][1]*maskv[2][2]));
            b2[i][height-1]=(b1[i][height-1]*maskv[1][1]) + (b1[i-1][height-1]*maskv[1][0]) + (b1[i+1][height-1]*maskv[1][2]);
            b2[i][height-1]=b2[i][height-1] + ((b1[i][height-2]*maskv[0][1]) + (b1[i-1][height-2]*maskv[0][0]) + (b1[i+1][height-2]*maskv[0][2]));
         }

        for(i=1;i<height-1;i++)
         {
            r2[0][i]=(r1[0][i]*maskv[1][1]) + (r1[0][i+1]*maskv[2][1]) + (r1[0][i-1]*maskv[0][1]);
            r2[0][i]=r2[0][i] + ((r1[1][i]*maskv[1][2]) + (r1[1][i+1]*maskv[2][2]) + (r1[1][i-1]*maskv[0][2]));
            r2[width-1][i]=(r1[width-1][i]*maskv[1][1]) + (r1[width-1][i+1]*maskv[2][1]) + (r1[width-1][i-1]*maskv[0][1]);
            r2[width-1][i]=r2[width-1][i] +((r1[width-2][i]*maskv[1][0]) + (r1[width-2][i+1]*maskv[2][0]) + (r1[width-2][i-1]*maskv[0][0]));

            g2[0][i]=(g1[0][i]*maskv[1][1]) + (g1[0][i+1]*maskv[2][1]) + (g1[0][i-1]*maskv[0][1]);
            g2[0][i]=g2[0][i] + ((g1[1][i]*maskv[1][2]) + (g1[1][i+1]*maskv[2][2]) + (g1[1][i-1]*maskv[0][2]));
            g2[width-1][i]=(g1[width-1][i]*maskv[1][1]) + (g1[width-1][i+1]*maskv[2][1]) + (g1[width-1][i-1]*maskv[0][1]);
            g2[width-1][i]=g2[width-1][i] +((g1[width-2][i]*maskv[1][0]) + (g1[width-2][i+1]*maskv[2][0]) + (g1[width-2][i-1]*maskv[0][0]));

            b2[0][i]=(b1[0][i]*maskv[1][1]) + (b1[0][i+1]*maskv[2][1]) + (b1[0][i-1]*maskv[0][1]);
            b2[0][i]=b2[0][i] + ((b1[1][i]*maskv[1][2]) + (b1[1][i+1]*maskv[2][2]) + (b1[1][i-1]*maskv[0][2]));
            b2[width-1][i]=(b1[width-1][i]*maskv[1][1]) + (b1[width-1][i+1]*maskv[2][1]) + (b1[width-1][i-1]*maskv[0][1]);
            b2[width-1][i]=b2[width-1][i] +((b1[width-2][i]*maskv[1][0]) + (b1[width-2][i+1]*maskv[2][0]) + (b1[width-2][i-1]*maskv[0][0]));
         }

        for(x=1;x<width-1;x++)
         {
            for(y=1;y<height-1;y++)
             {
                r2[x][y]=(r1[x][y]*maskv[1][1]) + (r1[x][y-1]*maskv[0][1]) + (r1[x][y+1]*maskv[2][1]);
                r2[x][y]=r2[x][y] + ((r1[x-1][y-1]*maskv[0][0]) + (r1[x-1][y]*maskv[1][0]) + (r1[x-1][y+1]*maskv[2][0]));
                r2[x][y]=r2[x][y] + ((r1[x+1][y-1]*maskv[0][2]) + (r1[x+1][y]*maskv[1][2]) + (r1[x+1][y+1]*maskv[2][2]));

                g2[x][y]=(g1[x][y]*maskv[1][1]) + (g1[x][y-1]*maskv[0][1]) + (g1[x][y+1]*maskv[2][1]);
                g2[x][y]=g2[x][y] + ((g1[x-1][y-1]*maskv[0][0]) + (g1[x-1][y]*maskv[1][0]) + (g1[x-1][y+1]*maskv[2][0]));
                g2[x][y]=g2[x][y] + ((g1[x+1][y-1]*maskv[0][2]) + (g1[x+1][y]*maskv[1][2]) + (g1[x+1][y+1]*maskv[2][2]));

                b2[x][y]=(b1[x][y]*maskv[1][1]) + (b1[x][y-1]*maskv[0][1]) + (b1[x][y+1]*maskv[2][1]);
                b2[x][y]=b2[x][y] + ((b1[x-1][y-1]*maskv[0][0]) + (b1[x-1][y]*maskv[1][0]) + (b1[x-1][y+1]*maskv[2][0]));
                b2[x][y]=b2[x][y] + ((b1[x+1][y-1]*maskv[0][2]) + (b1[x+1][y]*maskv[1][2]) + (b1[x+1][y+1]*maskv[2][2]));
             }
         }

        //HORIZONTAL
        //Corners
        r3[0][0]=(r1[0][0]*maskh[1][1]) + (r1[1][0]*maskh[1][2]) + (r1[0][1]*maskh[2][1]) + (r1[1][1]*maskh[2][2]);
        r3[0][height-1]=(r1[0][height-1]*maskh[1][1]) + (r1[0][height-2]*maskh[0][1]) + (r1[1][height-2]*maskh[0][2]) + (r1[1][height-1]*maskh[1][2]);
        r3[width-1][0]=(r1[width-1][0]*maskh[1][1]) + (r1[width-1][1]*maskh[2][1]) + (r1[width-2][0]*maskh[1][0]) + (r1[width-2][1]*maskh[2][0]);
        r3[width-1][height-1]=(r1[width-1][height-1]*maskh[1][1]) + (r1[width-1][height-2]*maskh[0][1]) + (r1[width-2][height-1]*maskh[1][0]) + (r1[width-2][height-2]*maskh[0][0]);

        g3[0][0]=(g1[0][0]*maskh[1][1]) + (g1[1][0]*maskh[1][2]) + (g1[0][1]*maskh[2][1]) + (g1[1][1]*maskh[2][2]);
        g3[0][height-1]=(g1[0][height-1]*maskh[1][1]) + (g1[0][height-2]*maskh[0][1]) + (g1[1][height-2]*maskh[0][2]) + (g1[1][height-1]*maskh[1][2]);
        g3[width-1][0]=(g1[width-1][0]*maskh[1][1]) + (g1[width-1][1]*maskh[2][1]) + (g1[width-2][0]*maskh[1][0]) + (g1[width-2][1]*maskh[2][0]);
        g3[width-1][height-1]=(g1[width-1][height-1]*maskh[1][1]) + (g1[width-1][height-2]*maskh[0][1]) + (g1[width-2][height-1]*maskh[1][0]) + (g1[width-2][height-2]*maskh[0][0]);

        b3[0][0]=(b1[0][0]*maskh[1][1]) + (b1[1][0]*maskh[1][2]) + (b1[0][1]*maskh[2][1]) + (b1[1][1]*maskh[2][2]);
        b3[0][height-1]=(b1[0][height-1]*maskh[1][1]) + (b1[0][height-2]*maskh[0][1]) + (b1[1][height-2]*maskh[0][2]) + (b1[1][height-1]*maskh[1][2]);
        b3[width-1][0]=(b1[width-1][0]*maskh[1][1]) + (b1[width-1][1]*maskh[2][1]) + (b1[width-2][0]*maskh[1][0]) + (b1[width-2][1]*maskh[2][0]);
        b3[width-1][height-1]=(b1[width-1][height-1]*maskh[1][1]) + (b1[width-1][height-2]*maskh[0][1]) + (b1[width-2][height-1]*maskh[1][0]) + (b1[width-2][height-2]*maskh[0][0]);

        for(i=1;i<width-1;i++)
         {
            r3[i][0]=(r1[i][0]*maskh[1][1]) + (r1[i-1][0]*maskh[1][0]) + (r1[i+1][0]*maskh[1][2]);
            r3[i][0]=r3[i][0] + ((r1[i][1]*maskh[2][1]) + (r1[i-1][1]*maskh[2][0]) + (r1[i+1][1]*maskh[2][2]));
            r3[i][height-1]=(r1[i][height-1]*maskh[1][1]) + (r1[i-1][height-1]*maskh[1][0]) + (r1[i+1][height-1]*maskh[1][2]);
            r3[i][height-1]=r3[i][height-1] + ((r1[i][height-2]*maskh[0][1]) + (r1[i-1][height-2]*maskh[0][0]) + (r1[i+1][height-2]*maskh[0][2]));

            g3[i][0]=(g1[i][0]*maskh[1][1]) + (g1[i-1][0]*maskh[1][0]) + (g1[i+1][0]*maskh[1][2]);
            g3[i][0]=g3[i][0] + ((g1[i][1]*maskh[2][1]) + (g1[i-1][1]*maskh[2][0]) + (g1[i+1][1]*maskh[2][2]));
            g3[i][height-1]=(g1[i][height-1]*maskh[1][1]) + (g1[i-1][height-1]*maskh[1][0]) + (g1[i+1][height-1]*maskh[1][2]);
            g3[i][height-1]=g3[i][height-1] + ((g1[i][height-2]*maskh[0][1]) + (g1[i-1][height-2]*maskh[0][0]) + (g1[i+1][height-2]*maskh[0][2]));

            b3[i][0]=(b1[i][0]*maskh[1][1]) + (b1[i-1][0]*maskh[1][0]) + (b1[i+1][0]*maskh[1][2]);
            b3[i][0]=b3[i][0] + ((b1[i][1]*maskh[2][1]) + (b1[i-1][1]*maskh[2][0]) + (b1[i+1][1]*maskh[2][2]));
            b3[i][height-1]=(b1[i][height-1]*maskh[1][1]) + (b1[i-1][height-1]*maskh[1][0]) + (b1[i+1][height-1]*maskh[1][2]);
            b3[i][height-1]=b3[i][height-1] + ((b1[i][height-2]*maskh[0][1]) + (b1[i-1][height-2]*maskh[0][0]) + (b1[i+1][height-2]*maskh[0][2]));
         }

        for(i=1;i<height-1;i++)
         {
            r3[0][i]=(r1[0][i]*maskh[1][1]) + (r1[0][i+1]*maskh[2][1]) + (r1[0][i-1]*maskh[0][1]);
            r3[0][i]=r3[0][i] + ((r1[1][i]*maskh[1][2]) + (r1[1][i+1]*maskh[2][2]) + (r1[1][i-1]*maskh[0][2]));
            r3[width-1][i]=(r1[width-1][i]*maskh[1][1]) + (r1[width-1][i+1]*maskh[2][1]) + (r1[width-1][i-1]*maskh[0][1]);
            r3[width-1][i]=r3[width-1][i] +((r1[width-2][i]*maskh[1][0]) + (r1[width-2][i+1]*maskh[2][0]) + (r1[width-2][i-1]*maskh[0][0]));

            g3[0][i]=(g1[0][i]*maskh[1][1]) + (g1[0][i+1]*maskh[2][1]) + (g1[0][i-1]*maskh[0][1]);
            g3[0][i]=g3[0][i] + ((g1[1][i]*maskh[1][2]) + (g1[1][i+1]*maskh[2][2]) + (g1[1][i-1]*maskh[0][2]));
            g3[width-1][i]=(g1[width-1][i]*maskh[1][1]) + (g1[width-1][i+1]*maskh[2][1]) + (g1[width-1][i-1]*maskh[0][1]);
            g3[width-1][i]=g3[width-1][i] +((g1[width-2][i]*maskh[1][0]) + (g1[width-2][i+1]*maskh[2][0]) + (g1[width-2][i-1]*maskh[0][0]));

            b3[0][i]=(b1[0][i]*maskh[1][1]) + (b1[0][i+1]*maskh[2][1]) + (b1[0][i-1]*maskh[0][1]);
            b3[0][i]=b3[0][i] + ((b1[1][i]*maskh[1][2]) + (b1[1][i+1]*maskh[2][2]) + (b1[1][i-1]*maskh[0][2]));
            b3[width-1][i]=(b1[width-1][i]*maskh[1][1]) + (b1[width-1][i+1]*maskh[2][1]) + (b1[width-1][i-1]*maskh[0][1]);
            b3[width-1][i]=b3[width-1][i] +((b1[width-2][i]*maskh[1][0]) + (b1[width-2][i+1]*maskh[2][0]) + (b1[width-2][i-1]*maskh[0][0]));
         }

        for(x=1;x<width-1;x++)
         {
            for(y=1;y<height-1;y++)
             {
                r3[x][y]=(r1[x][y]*maskh[1][1]) + (r1[x][y-1]*maskh[0][1]) + (r1[x][y+1]*maskh[2][1]);
                r3[x][y]=r3[x][y] + ((r1[x-1][y-1]*maskh[0][0]) + (r1[x-1][y]*maskh[1][0]) + (r1[x-1][y+1]*maskh[2][0]));
                r3[x][y]=r3[x][y] + ((r1[x+1][y-1]*maskh[0][2]) + (r1[x+1][y]*maskh[1][2]) + (r1[x+1][y+1]*maskh[2][2]));

                g3[x][y]=(g1[x][y]*maskh[1][1]) + (g1[x][y-1]*maskh[0][1]) + (g1[x][y+1]*maskh[2][1]);
                g3[x][y]=g3[x][y] + ((g1[x-1][y-1]*maskh[0][0]) + (g1[x-1][y]*maskh[1][0]) + (g1[x-1][y+1]*maskh[2][0]));
                g3[x][y]=g3[x][y] + ((g1[x+1][y-1]*maskh[0][2]) + (g1[x+1][y]*maskh[1][2]) + (g1[x+1][y+1]*maskh[2][2]));

                b3[x][y]=(b1[x][y]*maskh[1][1]) + (b1[x][y-1]*maskh[0][1]) + (b1[x][y+1]*maskh[2][1]);
                b3[x][y]=b3[x][y] + ((b1[x-1][y-1]*maskh[0][0]) + (b1[x-1][y]*maskh[1][0]) + (b1[x-1][y+1]*maskh[2][0]));
                b3[x][y]=b3[x][y] + ((b1[x+1][y-1]*maskh[0][2]) + (b1[x+1][y]*maskh[1][2]) + (b1[x+1][y+1]*maskh[2][2]));
             }
         }

        for(x=0;x<width;x++)
         {
            for(y=0;y<height;y++)
             {
                r4[x][y]=Math.sqrt(Math.pow((double)r2[x][y],2.0)+Math.pow((double)r3[x][y],2.0));
                g4[x][y]=Math.sqrt(Math.pow((double)g2[x][y],2.0)+Math.pow((double)g3[x][y],2.0));
                b4[x][y]=Math.sqrt(Math.pow((double)b2[x][y],2.0)+Math.pow((double)b3[x][y],2.0));
             }
         }

        for(x=0;x<width;x++)
         {
            for(y=0;y<height;y++)
             {
                r1[x][y]=Math.round((float)r4[x][y]);
                g1[x][y]=Math.round((float)g4[x][y]);
                b1[x][y]=Math.round((float)b4[x][y]);
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