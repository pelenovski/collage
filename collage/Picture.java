import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture// extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */

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

  public void copyKatie(/*sourceFile*/)
  {
      String sourceFile = ("images\\memesmile.jpeg");
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
   
   /**
    * Method to mirror around a vertical line in the middle
    * of the picture based on the width
    */
   
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
   public void copyflowerSmaller(/*fileName*/)
   {
       Picture flowerPicture = (new Picture("images\\whiteFlower.jpg"));
       
       Pixel sourcePixel = null;
       Pixel targetPixel = null;
       
       //loop through columns
       for (sourceX = 0, targetX = 0; sourceX < flowerPicture.getWidth(); sourceX +=2, targetX++)
       {
           //loop through rows
           for (sourceY = 0, targetY = 0; sourceY < flowerPicture.getHeight(); sourceY +=2, targetY++)
           {
               //set the target pixel color to the source pixel color
               sourcePixel = flowerPicture.getPixel(sourceX,sourceY);
               targetPixel = this.getPixel(targetX,targetY);
               targetPixel.setColor(sourcePixel.setColor());
            }
        }
    }
    


  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }

} // this } is the end of class Picture, put all new methods before this
