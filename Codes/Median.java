import java.io.File.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Arrays;

public class Median
 {
    public static void main( String args[]) throws IOException
     {
        BufferedImage image=null;
        File f=null;

        int i=0,r=0,g=0,b=0,a=0,x=0,y=0,p=0,j=0,k=0;

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
        int r2[][]=new int[width][height];
        int g1[][]=new int[width][height];
        int g2[][]=new int[width][height];
        int b1[][]=new int[width][height];
        int b2[][]=new int[width][height];
        int abc[]=new int[9]; 

        for(x=0;x<9;x++)
           abc[x]=0;

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

        for(x=1;x<width-1;x++)
         {
            for(y=1;y<height-1;y++)
             {
                //red
                k=0;

                for(i=x-1;i<x+2;i++)
                for(j=y-1;j<y+2;j++)
                  {
                     abc[k]=r1[i][j];
                     k=k+1;
                  }

                Arrays.sort(abc);

                r2[x][y]=abc[4];

                //green
                for(i=0;i<9;i++)
                  abc[i]=0;

                k=0;

                for(i=x-1;i<x+2;i++)
                for(j=y-1;j<y+2;j++)
                  {
                     abc[k]=g1[i][j];
                     k=k+1;
                  }

                Arrays.sort(abc);

                g2[x][y]=abc[4];

                //blue
                for(i=0;i<9;i++)
                  abc[i]=0;

                k=0;

                for(i=x-1;i<x+2;i++)
                for(j=y-1;j<y+2;j++)
                  {
                     abc[k]=b1[i][j];
                     k=k+1;
                  }

                Arrays.sort(abc);

                b2[x][y]=abc[4];
             }
         }

        for(x=1;x<width-1;x++)
         {
             //1st column
             //red
             for(i=0;i<9;i++)
               abc[i]=0;

             k=0;

             for(i=0;i<2;i++)
             for(j=x-1;j<x+2;j++)
               {
                  abc[k]=r1[i][j];
                  k=k+1;
               }

             Arrays.sort(abc);

             r2[0][x]=abc[4];

             for(i=0;i<9;i++)
              abc[i]=0;

             //green
             for(i=0;i<9;i++)
               abc[i]=0;

             k=0;

             for(i=0;i<2;i++)
             for(j=x-1;j<x+2;j++)
               {
                  abc[k]=g1[i][j];
                  k=k+1;
               }

             Arrays.sort(abc);

             g2[0][x]=abc[4];

             for(i=0;i<9;i++)
              abc[i]=0;

             //blue
             for(i=0;i<9;i++)
               abc[i]=0;

             k=0;

             for(i=0;i<2;i++)
             for(j=x-1;j<x+2;j++)
               {
                  abc[k]=b1[i][j];
                  k=k+1;
               }

             Arrays.sort(abc);

             b2[0][x]=abc[4];

             //1st row
             //red
             for(i=0;i<9;i++)
              abc[i]=0;

             k=0;

             for(i=x-1;i<x+2;i++)
             for(j=0;j<2;j++)
               {
                  abc[k]=r1[i][j];
                  k=k+1;
               }

             Arrays.sort(abc);

             r2[x][0]=abc[4];

             for(i=0;i<9;i++)
              abc[i]=0;

             //green
             for(i=0;i<9;i++)
              abc[i]=0;

             k=0;

             for(i=x-1;i<x+2;i++)
             for(j=0;j<2;j++)
               {
                  abc[k]=g1[i][j];
                  k=k+1;
               }

             Arrays.sort(abc);

             g2[x][0]=abc[4];

             for(i=0;i<9;i++)
              abc[i]=0;

             //blue
             for(i=0;i<9;i++)
              abc[i]=0;

             k=0;

             for(i=x-1;i<x+2;i++)
             for(j=0;j<2;j++)
               {
                  abc[k]=b1[i][j];
                  k=k+1;
               }

             Arrays.sort(abc);

             b2[x][0]=abc[4];

             //last column
             //red
             for(i=0;i<9;i++)
              abc[i]=0;

             k=0;

             for(i=width-2;i<width;i++)
             for(j=x-1;j<x+2;j++)
               {
                  abc[k]=r1[i][j];
                  k=k+1;
               }

             Arrays.sort(abc);

             r2[width-1][x]=abc[4];

             //green
             for(i=0;i<9;i++)
              abc[i]=0;

             k=0;

             for(i=width-2;i<width;i++)
             for(j=x-1;j<x+2;j++)
               {
                  abc[k]=g1[i][j];
                  k=k+1;
               }

             Arrays.sort(abc);

             g2[width-1][x]=abc[4];

             //blue
             for(i=0;i<9;i++)
              abc[i]=0;

             k=0;

             for(i=width-2;i<width;i++)
             for(j=x-1;j<x+2;j++)
               {
                  abc[k]=b1[i][j];
                  k=k+1;
               }

             Arrays.sort(abc);

             b2[width-1][x]=abc[4];

             //last row
             //red
             for(i=0;i<9;i++)
              abc[i]=0;

             k=0;

             for(i=x-1;i<x+2;i++)
             for(j=height-2;j<height;j++)
               {
                  abc[k]=r1[i][j];
                  k=k+1;
               }

             Arrays.sort(abc);

             r2[x][height-1]=abc[4];

            //green
             for(i=0;i<9;i++)
              abc[i]=0;

             k=0;

             for(i=x-1;i<x+2;i++)
             for(j=height-2;j<height;j++)
               {
                  abc[k]=g1[i][j];
                  k=k+1;
               }

             Arrays.sort(abc);

             g2[x][height-1]=abc[4];

            //blue
             for(i=0;i<9;i++)
              abc[i]=0;

             k=0;

             for(i=x-1;i<x+2;i++)
             for(j=height-2;j<height;j++)
               {
                  abc[k]=b1[i][j];
                  k=k+1;
               }

             Arrays.sort(abc);

             b2[x][height-1]=abc[4];
         }

        //Corners
        r2[0][0]=0;
        r2[0][height-1]=0;
        r2[width-1][0]=0;
        r2[width-1][height-1]=0;

        g2[0][0]=0;
        g2[0][height-1]=0;
        g2[width-1][0]=0;
        g2[width-1][height-1]=0;

        b2[0][0]=0;
        b2[0][height-1]=0;
        b2[width-1][0]=0;
        b2[width-1][height-1]=0;

        BufferedImage image1=new BufferedImage(width,height,1);

        for(x=0;x<width;x++)
         {
            for(y=0;y<height;y++)
             {
                r=r2[x][y];
                g=g2[x][y];
                b=b2[x][y];

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