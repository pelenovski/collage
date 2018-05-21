

/**
 * Pane Elenovski
 * 4/30/2018
 * Collage Project 
 * @Takes halva image and manipulates it using 
 */
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

//DOESNT WORK
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
      String sourceFile = ("halva.jpg");
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
     String fileName = FileChooser.pickAFile();
     Picture pic = new Picture(fileName);
     Picture pic2 = new Picture(fileName);
     Picture pic3 = new Picture(fileName);
     Picture pic4 = new Picture(fileName);
     Picture pic5 = new Picture(fileName);
     pic.mirrorVertical();
     pic.explore();
     pic2.mirrorHorizontal();
     pic2.explore();
     pic3.gray();
     pic3.explore();
     pic4.recursivePic(pic4);
     pic4.explore();
     pic5.explore();
     
  
     pic.write("C:\\Users\\gelen\\Downloads\\collage-master\\collage\\pic.png");
     pic2.write("C:\\Users\\gelen\\Downloads\\collage-master\\collage\\pic2.png");
     pic3.write("C:\\Users\\gelen\\Downloads\\collage-master\\collage\\pic3.png");
     pic4.write("C:\\Users\\gelen\\Downloads\\collage-master\\collage\\pic4.png");
     pic5.write("C:\\Users\\gelen\\Downloads\\collage-master\\collage\\pic5.png");
     














//public static BufferedImage joinBufferedImage(BufferedImage img1,
  //    BufferedImage img2) {
    //int offset = 2;
    //int width = img1.getWidth() + img2.getWidth() + offset;
    //int height = Math.max(img1.getHeight(), img2.getHeight()) + offset;
    //BufferedImage newImage = new BufferedImage(width, height,
    //    BufferedImage.TYPE_INT_ARGB);
    //Graphics2D g2 = newImage.createGraphics();
    //Color oldColor = g2.getColor();
    //g2.setPaint(Color.BLACK);
    //g2.fillRect(0, 0, width, height);
    //g2.setColor(oldColor);
    //g2.drawImage(img1, null, 0, 0);
    //g2.drawImage(img2, null, img1.getWidth() + offset, 0);
    //g2.dispose();
    //return newImage;
  //}
  
} // this } is the end of class Picture, put all new methods before this}
}

