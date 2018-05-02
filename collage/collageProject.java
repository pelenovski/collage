

/**
 * Pane Elenovski
 * 4/30/2018
 * Collage Project 
 * @Takes pink panther image and manipulates it using 
 */
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; //resolves problem with java.awt.List and java.util.List;

public class collageProject extends Picture
{
  Picture pinkpantherPicture = (new Picture("images\\Pink-Panther.jpg"));
    
    public collageProject()
    {
        super();
    }
    
    public collageProject(String fileName)
    {
        super(fileName);
    }
    
    public void gray()
   {
       Pixel[] pixelArray = this.getPixels();
       Pixel pixel = null;
       int intensity = 0;
       for (int i = 0; i < pixelArray.length; i++)
       {
           pixel = pixelArray[i];
           
           intensity = (int)((pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3);
           pixel.setColor(new Color(intensity,intensity,intensity));
       }
   }
   
   public void copyPicture(sourceFile)
   {
        
       String sourceFile = ("images\\Pink-Panther.jpg");
       Picture sourcePicture = new Picture(sourceFile);
       //initializes two source pixels with no inital value
       Pixel sourcePixel = null;
       Pixel sourcePixel = null;
       //Will get array out of bounds index error if getWidth of getHeight is used in both for loops (DO NOT MAKE THIS MISTAKE)
       //width of source must be = or < the canvas I am copy to
       //loop through the columns
       for (int sourceX = 0, targetX = 100; sourceX < sourcePicture.getWidth(); SourceX++, targetX++)
       {
           //loop through the rows
           for (int sourceY = 0, targetY = 100; sourceY < sourcePicture.getHeight(); SourceY++, targetY++)
           {    //set the target pixel color to source pixel color
               sourcePixel = sourcePicture.getPixel(SourceX,sourceY);
               //this pixel is my target pixel
               targetPixel = this.getPixel(targetX,targetY);
               //sets the color of source pixel to targetpixel
               targetPixel.setColor(sourcePixel.getColor());
           }
       }
  }
  
  public void mirrorVertical()
   {
       int width = this.getWidth();
       int mirrorPoint = width / 2;
       
       Pixel leftPixel = null;
       Pixel rightPixel = null;
       
       //loop throughout all the rows
       for (int y = 0; y < getHeight(); y++)
       {
           //loop from 0 to the middle(mirror point)
           for (int x = 0; x < mirrorPoint; x++)
           {
               leftPixel = getPixel(x,y);
               rightPixel = getPixel(width-1-x,y);
               rightPixel.setColor(leftPixel.getColor());
           }
        }
    }
    
  public void mirrorHorizontal()
   {
       int height = this.getHeight();
       int mirrorPoint = height / 2;
       
       Pixel upPixel = null;
       Pixel downPixel = null;
       
       //loop through all the columns
       for (int x = 0; x < getWidth(); x++)
       {
           //loop from 0 to the middle(mirror point)
           for (int y = 0; y < mirrorPoint; y++)
           {
               //column major
               upPixel = getPixel(x,y);
               downPixel = getPixel(x,height-1-y);
               downPixel.setColor(upPixel.getColor());
            }
        }
    }
    
  public void copySmaller("images\\Pink-Panther.jpg")
   {
       Picture pinkpantherPicture = (new Picture("images\\Pink-Panther.jpg"));
       
       Pixel sourcePixel = null;
       Pixel targetPixel = null;
       
       //loop through columns
       for (sourceX = 0, targetX = 0; sourceX < pinkpantherPicture.getWidth(); sourceX +=2, targetX++)
       {
           //loop through rows
           for (sourceY = 0, targetY = 0; sourceY < pinkpantherPicture.getHeight(); sourceY +=2, targetY++)
           {
               //set the target pixel color to the source pixel color
               sourcePixel = pinkpantherPicture.getPixel(sourceX,sourceY);
               targetPixel = this.getPixel(targetX,targetY);
               targetPixel.setColor(sourcePixel.setColor());
            }
        }
    }
    
  public void blend()
  {
      Pixel sourcePixel = null;
      Pixel targetPixel = null;
      
      Picture pinkpantherPicture = new Picture("images\\Pink-Panther.jpg");
      Picture memesmile = new Picture("images\\memesmile.jpg");
      
      for (sourceX = 0, targetX = 0; sourceX < pinkpantherPicture.getWidth(); sourceX < memesmile.getWidth())
      {
          for (sourceY = 0, targetY = 0; sourceY < pinkpantherPicture.getHeight(); sourceY < memesmile.getHeight())
          {
              sourcePixel = pinkpantherPicture.getPixel(sourceX,sourceY);
              targetPixel = memesmile.getPixel(targetX,targetY);
              targetPixel = memesmile.setColor(pinkpantherPicture.setColor());
          }
      } 
  }
  
  public void glass()
  {
      Picture pinkpantherPicture = new Picture("images\\Pink-Panther.jpg");
      Picture memesmile = new Picture("images\\memesmile.jpg");
      
  }
      
      
  
  
  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }

    
  
    
    
    
    
    
    
    
}
