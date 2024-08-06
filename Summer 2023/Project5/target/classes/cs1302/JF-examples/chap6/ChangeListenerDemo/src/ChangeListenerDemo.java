import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//************************************************************************
//  ChangeListenerDemo.java       Java Foundations
//
//  Demonstrates the ability to respond to property changes using
//  change listeners. Functionally equivalent to PropertyBindingDemo.
//************************************************************************

public class ChangeListenerDemo extends Application
{
    private Scene scene;
    private Circle center;
    private Text widthText, heightText;
    
    //--------------------------------------------------------------------
    //  Displays the width and height of the scene, as well as a circle
    //  in the center of the scene. The scene is updated using a change
    //  listener as the window is resized.
    //--------------------------------------------------------------------
    public void start(Stage primaryStage)
    {
        Group root = new Group();
        
        scene = new Scene(root, 300, 200, Color.SKYBLUE);
        scene.widthProperty().addListener(this::processResize);
        scene.heightProperty().addListener(this::processResize);

        center = new Circle(6);
        center.setCenterX(scene.getWidth() / 2);
        center.setCenterY(scene.getHeight() / 2);

        widthText = new Text(20, 30, "Width: " + scene.getWidth());
        heightText = new Text(20, 60, "Height: " + scene.getHeight());
        
        root.getChildren().addAll(center, widthText, heightText);
         
        primaryStage.setTitle("Change Listener Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //--------------------------------------------------------------------
    //  Updates the position of the circle and the displayed width and
    //  height when the window is resized.
    //--------------------------------------------------------------------
    public void processResize(ObservableValue<? extends Number> property,
        Object oldValue, Object newValue)
    {
        center.setCenterX(scene.getWidth() / 2);
        center.setCenterY(scene.getHeight() / 2);
        widthText.setText("Width: " + scene.getWidth());
        heightText.setText("Height: " + scene.getHeight());
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
