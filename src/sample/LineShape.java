package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class LineShape implements Command {
	MouseEvent e;
	GraphicsContext g;
	private ColorPicker colorPicker;
	private Canvas canvas;
	Line line = new Line();
	
	public LineShape()
	{
		System.out.println("Line Shape Init");
	}
	public void setMouseEvent(MouseEvent e) {
		this.e = e;
	}
	public void setColorPicker(ColorPicker colorPicker) {
		this.colorPicker = colorPicker;
	}
	public void setGraphicsContext(GraphicsContext g) {
		this.g = g;
	}
	
	public void execute() {
		System.out.print("Line exe");
		canvas.setOnMousePressed(e -> {
			g.setStroke(colorPicker.getValue());
			line.setStartX(e.getX());
			line.setStartY(e.getY());
			System.out.println("Line Exected");
		});
		canvas.setOnMouseDragged(e -> {
			Pane pane = new Pane();
			Canvas tmp = new Canvas(canvas.getWidth(),canvas.getHeight());
			line.setEndX(e.getX());
			line.setEndY(e.getY());
			GraphicsContext tempGrap = tmp.getGraphicsContext2D();
			tempGrap.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
			pane.getChildren().add(0,tmp);
		});
//		canvas.setOnMouseReleased(e -> {
//			line.setEndX(e.getX());
//			line.setEndY(e.getY());
//			g.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
//		});
		

	}

	public void unexecute() {

	}

	@Override
	public void setCanvas(Canvas c) {
		this.canvas = c;
		
	}
	@Override
	public void unsubAllMouseEvent() {
		canvas.setOnMousePressed(null);
		canvas.setOnMouseDragged(null);
		canvas.setOnMouseReleased(null);
	}

}
