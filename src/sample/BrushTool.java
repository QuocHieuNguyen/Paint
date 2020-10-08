package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class BrushTool implements Command
{
    MouseEvent e;
    GraphicsContext g;
    private ColorPicker colorPicker;
    private TextField brushSize;
    
    public void setMouseEvent(MouseEvent e)
    {
    	this.e = e;
    	
    }
    public void setGraphicsContext(GraphicsContext g)
    {
    	this.g = g;
    	
    }
    public void setBrushSize(TextField size)
    {
    	brushSize = size;
    }
    public BrushTool()
    {

    }
    public void execute()
    {
        double size = Double.parseDouble(brushSize.getText());
        double x = e.getX() - size / 2;
        double y = e.getY() - size / 2;
        g.setFill(colorPicker.getValue());
        g.fillRect(x, y, size, size);
    }
    public void unexecute()
    {

    }
	public ColorPicker getColorPicker() {
		return colorPicker;
	}
	public void setColorPicker(ColorPicker colorPicker) {
		this.colorPicker = colorPicker;
	}   
}