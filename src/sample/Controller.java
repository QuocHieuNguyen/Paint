package sample;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import javafx.event.ActionEvent;
import java.io.File;

/**
 * @author
 */
public class Controller {

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField brushSize;

    @FXML
    private CheckBox eraser;

    @FXML
    private Button fillButton;

    @FXML
    private Button Eraser;

    @FXML
    private Button Pencil;

    @FXML
    private Button Rectangle;
    @FXML
    private Button Brush;
    
    @FXML
    private MenuItem newItem;
    
    @FXML
    private MenuItem openItem;
    @FXML
    private MenuItem saveItem;
    @FXML
    private MenuItem saveAsItem;
    
    Command tool;

    public void initialize() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        Brush.fire();
        canvas.setOnMouseDragged(e -> {
        	tool.setMouseEvent(e);
        	tool.setGraphicsContext(g);
        	tool.execute();
//            double size = Double.parseDouble(brushSize.getText());
//            double x = e.getX() - size / 2;
//            double y = e.getY() - size / 2;
//
//            if (eraser.isSelected()) {
//                g.clearRect(x, y, size, size);
//            } else {
//                g.setFill(colorPicker.getValue());
//                g.fillOval(x, y, size,size);
//                //g.fillRect(x, y, size, size);
//            }
        });
    }
    @FXML
    public void fillButtonInvoked(ActionEvent event) {
        System.out.println("Button click");
    }
    @FXML
    public void pencilButtonInvoked(ActionEvent event) {
        System.out.println("Button click");
    }
    @FXML
    public void rectButtonInvoked(ActionEvent event) {
        System.out.println("Button click");
    }
    @FXML
    public void eraserButtonInvoked(ActionEvent event) {
        System.out.println("Button click");
        
    }
    @FXML
    public void brushButtonInvoked(ActionEvent event) {
    	System.out.println("Brush Button Click");
        tool = new BrushTool();
        BrushTool brushTool = (BrushTool)tool;
        brushTool.setBrushSize(brushSize);
        brushTool.setColorPicker(colorPicker);
        
    }
    @FXML
    public void newItemInvoked(ActionEvent event)
    {
    	System.out.println("newItem click");
    }
    @FXML
    public void openItemInvoked(ActionEvent event)
    {

    }
    @FXML
    public void saveItemInvoked(ActionEvent event)
    {
    	 onSave();
    }
    @FXML
    public void saveAsItemInvoked(ActionEvent event)
    {
    	
    }

    public void onSave() {
    	System.out.println("Save S?");
        try {
            Image snapshot = canvas.snapshot(null, null);
            
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File("paint.png"));
            System.out.println("Save S");
        } catch (Exception e) {
            System.out.println("Failed to save image: " + e);
        }
    }

    public void onExit() {
        Platform.exit();
    }
}
