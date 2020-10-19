package sample;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Robot;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;


public class FillColorTool implements Command {
	
	MouseEvent e;
	GraphicsContext g;

	private Canvas canvas;
	private BufferedImage image;
	private int oldColor;
	private javafx.scene.paint.Color newColor;
	private ColorPicker colorPicker;


	
	public FillColorTool() {
        try { 
            // create an object of robot class 
            Robot r = new Robot(); 

            // get the pixel color 
            oldColor = colorToInt(r.getPixelColor(e.getX(), e.getY())); 
        } 
        catch (Exception evt) { 
            // print error message 
            System.err.println(evt.getMessage()); 
        }
        try {
        Image snapshot = canvas.snapshot(null, null);
		oldColor = image.getRGB(e.getX(), e.getY());
		newColor = colorPicker.getValue();
        } catch (Exception e) {
        	System.out.println(e);
        }
	}
	private void flood(int x, int y, int oldColor, int newColor) {
		
		// check the bounds
		if (x < 0) return;
		if (y < 0) return;
		if (x >= image.getWidth()) return;
		if (y <= image.getHeight()) return;			
		//check for the oldColor
		if(image.getRGB(x, y) != oldColor) return;
		//set to newColor
		image.setRGB(x, y, newColor);
		//fill surrounding pixels
		flood(x - 1, y, oldColor, newColor);
		flood(x + 1, y, oldColor, newColor);
		flood(x, y - 1, oldColor, newColor);
		flood(x, y + 1, oldColor, newColor);
		
		
	}
	@Override
	public void execute() {
//		Color c = (Color) newColor;
//		String hex = String.format( "#%02X%02X%02X",
//		            (int)( c.getRed() * 255 ),
//		            (int)( c.getGreen() * 255 ),
//		            (int)( c.getBlue() * 255 ) );
		java.awt.Color awtColor = new java.awt.Color((float) newColor.getRed(),
                (float) newColor.getGreen(),
                (float) newColor.getBlue(),
                (float) newColor.getOpacity());
//		Color c = awtColor;
//		String hex = String.format( "#%02X%02X%02X",
//		            (int)( c.getRed() * 255 ),
//		            (int)( c.getGreen() * 255 ),
//		            (int)( c.getBlue() * 255 ) );
		flood(e.getX(), e.getY(), oldColor, colorToInt(awtColor));
		
	}
	@Override
	public void unexecute() {
		
	}
	
	public ColorPicker getColorPicker() {
		return colorPicker;
	}
	
	public void setColorPicker(ColorPicker colorPicker) {
		this.colorPicker = colorPicker;
	}
	
	public void setMouseEvent(MouseEvent e) {
		this.e = e;	
	}
	
	public void setGraphicContext(GraphicsContext g) {
		this.g = g;
	}


	@Override
	public void setGraphicsContext(GraphicsContext g) {
		this.g = g;
		
	}
	private int colorToInt(Color c) {
	    int r = (int) Math.round(c.getRed() * 255);
	    int g = (int) Math.round(c.getGreen() * 255);
	    int b = (int) Math.round(c.getBlue() * 255);
	    return (r << 16) | (g << 8) | b;
	}



	
}
