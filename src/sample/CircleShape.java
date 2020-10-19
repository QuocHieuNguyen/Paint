package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class CircleShape implements Command {
	MouseEvent e;
	GraphicsContext g;
	private Canvas canvas;
	private ColorPicker colorPicker;
	
	Circle circle = new Circle();
	
	@Override
	public void execute() {
		
		
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMouseEvent(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGraphicsContext(GraphicsContext g) {
		// TODO Auto-generated method stub
		
	}

}
