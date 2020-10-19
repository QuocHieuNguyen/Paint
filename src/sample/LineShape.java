package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class LineShape implements Command {
	MouseEvent e;
	GraphicsContext g;
	private ColorPicker colorPicker;
	private Canvas canvas;
	Line line = new Line();

	public void setMouseEvent(MouseEvent e) {
		this.e = e;
	}

	public void setGraphicsContext(GraphicsContext g) {
		this.g = g;
	}

	public void execute() {
		canvas.setOnMousePressed(e -> {
			g.setStroke(colorPicker.getValue());
			line.setStartX(e.getX());
			line.setStartY(e.getY());

		});
		canvas.setOnMouseReleased(e -> {
			line.setEndX(e.getX());
			line.setEndY(e.getY());
			g.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
		});

	}

	public void unexecute() {

	}

}
