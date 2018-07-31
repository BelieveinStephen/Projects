import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.*;

public class Image 
{
	private int width, height; 
	private int[][] pixels;
   
	public Image(String filename) throws Exception 
	{ 
		this.read(filename); 
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
   
	public void read(String filename) throws Exception 
	{
		File fileImage = new File(filename);
        
      BufferedImage bufImage = ImageIO.read(fileImage);
		this.width = bufImage.getWidth();
		this.height = bufImage.getHeight();
		
		pixels = new int[this.height][this.width];
      
      for( int i = 0; i < height; i++ )
         for( int j = 0; j < width; j++ )
            pixels[i][j] = bufImage.getRGB( j, i );
   }
            
   public void flipY()
   {
      int[][] a = new int[this.height][this.width];
      
      for(int i = 0; i < this.height; i++)
      {
         for(int j = this.width - 1; j >= 0; j--)
         {
            a[i][this.width-j-1] = this.pixels[i][j];
         }
      }
      this.pixels = a;
   }
   
   public void greyscale()
   {
      int[][] a = new int[this.height][this.width];
      
      for(int i = 0; i < this.height; i++)
      {
         for(int j = 0; j < this.width; j++)
         {
            Color o = new Color(this.pixels[i][j]);
            int b = o.getBlue();
            int r = o.getRed();
            int g = o.getGreen();
            int grey = (r + b + g)/3;
            Color o1 = new Color(grey, grey, grey);
            int total = o1.getRGB();
            a[i][j] = total;
         }
      }
      this.pixels = a;
   }
   
   public void flipX()
   {
      int[][] a = new int[this.height][this.width];
      for(int i = 0; i < this.height; i++)
      {
         for(int j = this.width - 1; j >= 0; j--)
         {
            a[this.height - i - 1][j] = this.pixels[i][j];
         }
      }
      this.pixels = a;
   }



         
      
      // Complete the remainder of this method 
         
   
   
   private BufferedImage createBufferedImage() 
   { 
      BufferedImage bufImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
  
     	for (int row = 0; row < this.height; row++)
     	{
        	for (int col = 0; col < this.width; col++)
        	{
        		bufImage.setRGB(col, row, this.pixels[row][col]);
        	}
      }         
     	return bufImage;
	   }
   
   public void write(String filename) throws Exception 
   {
      File fileImage = new File(filename);
      String ext = filename.substring(filename.indexOf('.') + 1);
      BufferedImage bufImage = createBufferedImage();
      ImageIO.write(bufImage, ext, fileImage);
   }
   
   
	public void draw(Graphics gc, int x, int y)
	{
   	BufferedImage bufImage = createBufferedImage();
      gc.drawImage(bufImage, x, y, null);
   }

} 