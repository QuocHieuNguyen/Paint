package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ClearTool implements Command{
	GraphicsContext g;
	Canvas canvas;
	private TextField brushSize;
	@Override
	public void execute() {
	      canvas.setOnMouseDragged(e -> {

	          double size = Double.parseDouble(brushSize.getText());
	          double x = e.getX() - size / 2;
	          double y = e.getY() - size / 2;
	          g.clearRect(x, y, size, size);
	      });
		
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCanvas(Canvas c) {
		this.canvas = c;
		
	}

	@Override
	public void setMouseEvent(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void setBrushSize(TextField size) {
		brushSize = size;
	}
	@Override
	public void setGraphicsContext(GraphicsContext g) {
		this.g = g;
		
	}

	@Override
	public void unsubAllMouseEvent() {
		canvas.setOnMouseDragged(null);
		
	}

}
