package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @author 
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
        stage.setTitle("Paint App");
        stage.show();
        Line line = new Line();
        line.setStartX(100.0); 
        line.setStartY(150.0); 
        line.setEndX(500.0); 
        line.setEndY(150.0);
        Group root = new Group(line);
        Scene scene = new Scene(root, 600, 300); 
        
        //Setting title to the scene 
        stage.setTitle("Sample application"); 
           
        //Adding the scene to the stage 
        stage.setScene(scene); 
           
        //Displaying the contents of a scene 
        stage.show(); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}
