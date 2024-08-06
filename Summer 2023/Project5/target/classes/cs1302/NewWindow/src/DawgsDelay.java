import java.util.concurrent.TimeUnit;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

 
public class DawgsDelay extends Application {
 
    private Stage primaryStage;
    private Stage songStage;
    private Text  song;

    @Override
    public void start( Stage primaryStage ) {
 
	Button singButton = new Button( "Let's sing!" );
	Button quitButton = new Button( "Quit" );
 
	singButton.setOnAction( this::singButtonHandler );
	quitButton.setOnAction( this::quitButtonHandler );
 
	VBox root = new VBox();
	root.setAlignment( Pos.CENTER );
        root.setSpacing( 40 );
	root.getChildren().addAll( singButton, quitButton );

	this.primaryStage = primaryStage;
 
	Scene scene = new Scene( root, 400, 300 );
 
	primaryStage.setTitle("Bulldawgs");
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    public void singButtonHandler( ActionEvent event )
    {
	song = new Text( "From the hills of Georgia's northland\n"
			       + "Beams thy noble brow,\n"
			       + "And the sons of Georgia rising\n"
			       + "Pledge with sacred vow.\n" 
			       + "'Neath the pine tree's stately shadow\n"
			       + "Spread thy riches rare,\n"
			       + "And thy sons, dear Alma Mater,\n"
			       + "Will thy treasure share.\n\n"
			       + "And thy daughters proudly join thee,\n"
			       + "Take their rightful place,\n"
			       + "Side by side into the future,\n"
			       + "Equal dreams embrace.\n\n"
			       + "Through the ages, Alma Mater,\n"
			       + "Men will look to thee;\n"
			       + "Thou the fairest of the Southland\n"
			       + "Georgia's Varsity.\n\n"
			       + "Chorus:\n"
			       + "Alma Mater, thee we'll honor,\n"
			       + "True and loyal be,\n"
			       + "Ever crowned with praise and glory,\n"
			       + "Georgia, hail to thee." );
 
	// ScrollPane will provide scroll bars, as needed
	ScrollPane scrollPane = new ScrollPane();
	scrollPane.setFitToHeight(true);
	scrollPane.setFitToWidth(true);
	scrollPane.setPrefViewportWidth(280);
	scrollPane.setContent( song );

	Button closeButton = new Button( "Close" );
	closeButton.setOnAction( this::closeButtonHandler );

	// the main layout in the new window is an HBox, with the ScrollPane as its child
	VBox newLayout = new VBox();
	newLayout.getChildren().addAll( closeButton, scrollPane );
	// provide margins around the ScrollPane inside the HBox
	newLayout.setAlignment( Pos.CENTER );
	VBox.setMargin( scrollPane, new Insets( 10, 10, 10, 10 ) );

	// create a new Scene with the newLayout
	Scene newScene = new Scene( newLayout, 300, 200 );
 
	// New window (Stage)
	Stage songStage = new Stage();
	songStage.setTitle( "Sing!" );
	songStage.setScene( newScene );
 
	// set the modality for the new window;  the main window will be blocked
	songStage.initModality( Modality.APPLICATION_MODAL );
 
	// Set position of the song window vs the main window.
	songStage.setX( primaryStage.getX() + 200);
	songStage.setY( primaryStage.getY() + 100);

	this.songStage = songStage;
 
	songStage.show();
    }
 
    public void quitButtonHandler( ActionEvent event )
    {
	Platform.exit();
    }

    public void closeButtonHandler( ActionEvent event )
    {
	// The Task class object will be execute in a different thread than the main JavaFX thread.
	// As a result, the delay included here will not block the main thread.
        Task<Void> delayedClosing = new Task<Void>() {
            @Override
            protected Void call()
	    {

		// Update the content of the song shown in the ScrollPane
		song.setText( "Going back, going back\n"
			      + "Going back to Athens town.\n"
			      + "Going back, going back\n"
			      + "To the best old place around.\n"
			      + "Going back, going back\n"
			      + "To hear that grand old sound\n"
			      + "Of a chapel bell and a Georgia yell,\n"
			      + "Going back to Athens town." );

		// now, wait for 3 seconds before closing the window
                try {
		    TimeUnit.SECONDS.sleep( 3 );
                } 
		catch( InterruptedException e ) {
		    System.out.println( e );
                }
                return null;
            }
        };

	// This is how we provide a handler for the Tas class object.
	// this handler (setOnSucceeded) will be called automatically once the
	// task completes correctly.  Here, we just simplu close the window
	// by closing its stage.
        delayedClosing.setOnSucceeded( new EventHandler<WorkerStateEvent>() {
		    @Override
		    public void handle( WorkerStateEvent event ) {
			songStage.close();
		    }
	    });

	// Now, start the new thread.
        new Thread( delayedClosing ).start();
    }

    // the usual main method, calling launch
    public static void main(String[] args) {
	launch(args);
    }
 
}
