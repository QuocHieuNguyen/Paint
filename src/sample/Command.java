package sample;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
public interface Command
{
    void execute();
    void unexecute();
    void setCanvas(Canvas c);
    void setMouseEvent(MouseEvent e);
    void setGraphicsContext(GraphicsContext g);
    void unsubAllMouseEvent();
}