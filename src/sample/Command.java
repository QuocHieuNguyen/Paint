package sample;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
public interface Command
{
    void execute();
    void unexecute();
    void setMouseEvent(MouseEvent e);
    void setGraphicsContext(GraphicsContext g);
}