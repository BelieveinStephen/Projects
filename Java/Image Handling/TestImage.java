import java.awt.*;
import javax.imageio.*; 

class TestImage 
{
	public static void main(String args[]) throws Exception 
	{
    	   //BufferedImage i = null;
         Frame frame = new Frame("My Images");
      	frame.setSize(1024,768);
      	frame.setVisible(true);
      	Graphics gc = frame.getGraphics();
      
      	try 
      	{
         
         Image i = new Image("animals.jpg");
         i.draw(gc, 10, 40);
         
         Image g = new Image("animals.jpg");
         g.greyscale();
         g.draw(gc, 10, 340);
         
         i.flipY();
         i.draw(gc, 350, 40);
         i.write("animalsReversed.jpg");
         
         Image x = new Image("animals.jpg");
         x.flipX();
         x.draw(gc, 750, 40);
         x.write("animalsUpsidedown.jpg");
         
         
         	
		} 
		catch (Exception e)
		{
         	e.printStackTrace();
      	}
	}
}