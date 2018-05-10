/**
 * Pane Elenovski
 * 4/30/2018
 * Collage Project 
 * @Takes halva image and manipulates it using 
 */
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List


public class collageProject extends Picture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public collageProject()
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
  public collageProject(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public collageProject(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public collageProject(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public collageProject(BufferedImage image)
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

  public void copy(Picture image, int x, int y)
  {
      String sourceFile = ("images\\halva.jpeg");
      Picture sourcePicture = image;
      //initializes two source pixels with no inital value
      Pixel sourcePixel = null;
      //Will get array out of bounds index error if getWidth of getHeight is used in both for loops (DO NOT MAKE THIS MISTAKE)
      //width of source must be = or < the canvas I am copy to
      //loop through the columns
      for (int sourceX = 0, targetX = x; sourceX < sourcePicture.getWidth(); sourceX++, targetX++)
      {
          //loop through the rows
          for (int sourceY = 0, targetY = y; sourceY < sourcePicture.getHeight(); sourceY++, targetY++)
          {    //set the target pixel color to source pixel color
              sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
              //this pixel is my target pixel
              Pixel targetPixel = this.getPixel(targetX,targetY);
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
   public void copySmaller(Picture image)
   {
       Picture pic = image;
       
       Pixel sourcePixel = null;
       Pixel targetPixel = null;
       
       //loop through columns
       for (int sourceX = 0, targetX = 0; sourceX < pic.getWidth(); sourceX +=2, targetX++)
       {
           //loop through rows
           for (int sourceY = 0, targetY = 0; sourceY < pic.getHeight(); sourceY +=2, targetY++)
           {
               //set the target pixel color to the source pixel color
               sourcePixel = pic.getPixel(sourceX,sourceY);
               targetPixel = this.getPixel(targetX,targetY);
               targetPixel.setColor(sourcePixel.getColor());
            }
        }
    }
    
    public void recursivePic(Picture pic){
       Picture image = pic;
        if (image.getHeight() < 30)
        {} //base case
        else
       {
         Picture copy = new Picture(image.getWidth()/2 , image.getHeight()/2 );
         copy.copySmaller(image);
         
         image.recursivePic(copy);
         image.copy(copy, 0, 0);
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
     //String fileName = FileChooser.pickAFile();
     //Picture pictObj = new Picture(fileName);
     //pictObj.explore();
     Picture pic = new Picture("images\\halva.jpg");
     Picture copyTo = new Picture("images\\toCopy.jpg");
     copyTo.recursivePic(pic);
    }

} // this } is the end of class Picture, put all new methods before this

