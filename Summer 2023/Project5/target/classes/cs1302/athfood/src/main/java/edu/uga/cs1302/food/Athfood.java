package edu.uga.cs1302.food;

import java.util.List;
import java.util.Iterator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;

import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

import javafx.scene.text.TextAlignment;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
 

// A simple JavaFX app illustrating:
//  -- reading from a CSV file in resources folder
//  -- using a ComboBox control
//  -- opening a modal window
//  -- reusing the modal window's controls to update its content
//  -- closing the modal window
//
public class Athfood extends Application {

    // several of these variables are instance variables and not
    // local variables as they are needed in listeners (event handlers)
    private Stage                primaryStage;
    private Stage                restaurantStage;
    private ComboBox<String>     restaurantsCBox;
    private RestaurantsData      restaurantsData;
    private Iterator<Restaurant> iter;
    private Button               prevButton;
    private Button               nextButton;
    private Label                name;
    private Label                description;
    private Label                address;
    private FontWeight           weight;
    private FontPosture          posture;

    @Override
    public void start( Stage primaryStage ) {
 
	// read the restaurants data
	restaurantsData = new RestaurantsData();

	// create the layout of the main window
	//
	// create and populate the ComboBox
	restaurantsCBox = new ComboBox<String>(); 
	restaurantsCBox.setPromptText( "Restaurant type" );
        restaurantsCBox.getItems().add( "Seafood" );
        restaurantsCBox.getItems().add( "Mexican" );
        restaurantsCBox.getItems().add( "Steakhouse" );

	// Text with the title of tha app
	Text info = new Text( "Restaurants in Athens, Ga." );
	weight = FontWeight.BOLD;
	posture = FontPosture.REGULAR;
        info.setFont( Font.font( "Helvetica", weight, posture, 24 ) );

	// Button to open the window in which restaurant info is shown
	Button viewButton = new Button( "Show" );
	viewButton.setOnAction( this::viewButtonHandler );

	// Button to quit the whole app
	Button quitButton = new Button( "Quit" );
	quitButton.setOnAction( this::quitButtonHandler );

	// create a nested layut
	HBox hbox = new HBox();
	hbox.setAlignment( Pos.CENTER );
        hbox.setSpacing( 40 );
	hbox.getChildren().addAll( restaurantsCBox, viewButton );

	// create the main layout
	VBox root = new VBox();
	root.setAlignment( Pos.CENTER );
        root.setSpacing( 40 );
	root.getChildren().addAll( info, hbox, quitButton );

	// make it accessible in the button handler
	this.primaryStage = primaryStage;
 
	// create the Scene
	Scene scene = new Scene( root, 400, 300 );
 
	primaryStage.setTitle( "Athens Restaurants" );
	primaryStage.setScene( scene );
	primaryStage.show();
    }

    public void viewButtonHandler( ActionEvent event )
    {
	Restaurant restaurant = null;
	Label space = new Label( "" );
	String type;

	// properties of a restaurant
	name = new Label();
	description = new Label();
	address = new Label();

	// set the properties of the displayed restaurants info
	name.setWrapText( true );
	name.setTextAlignment( TextAlignment.LEFT );
	name.setMaxWidth( 300 );

	description.setWrapText( true );
	description.setTextAlignment( TextAlignment.LEFT );
	description.setMaxWidth( 300 );

	address.setWrapText( true );
	address.setTextAlignment( TextAlignment.LEFT );
	address.setMaxWidth( 300 );

	// obtain the ComboBox value selected by the user (restaurant type)
	// if not selected, pick "Seafood"
	type = restaurantsCBox.getValue();
	if( type == null )
	    type = "Seafood";

	// get a list of restaurants of the selected type
	List<Restaurant> listToView = restaurantsData.getType( type );
	
	// obtain an iterator and get the first restaurant data
	iter = listToView.iterator();
	if( iter.hasNext() )
	    restaurant = iter.next();

	// update the name, description and address labels
	if( restaurant != null ) {
	    name.setText( restaurant.getName() );
	    name.setFont( Font.font( "Helvetica", weight, posture, 24 ) );
	    description.setText( restaurant.getDescription() );
	    address.setText( restaurant.getAddress() );
	}

	// setup a button to close the window
	Button closeButton = new Button( "Close" );
	closeButton.setOnAction( this::closeButtonHandler );

	// setup a button to move to the next restaurant
	nextButton = new Button( ">>" );
	nextButton.setOnAction( this::nextButtonHandler );

	// create a sublayout
	HBox hbox = new HBox();
	hbox.setAlignment( Pos.CENTER );
        hbox.setSpacing( 200 );
	hbox.getChildren().addAll( closeButton, nextButton );

	// the main layout in the new window is an HBox
	VBox vbox = new VBox();
        vbox.setSpacing( 20 );
	vbox.getChildren().addAll( name, description, address, space, hbox );
	vbox.setAlignment( Pos.CENTER );

	// create a new Scene with the newLayout
	Scene newScene = new Scene( vbox, 400, 300 );
 
	// New window (it is a Stage object)
	Stage restaurantStage = new Stage();
	restaurantStage.setTitle( "Restaurants" );
	restaurantStage.setScene( newScene );
 
	// set the modality for the new window;  the main window will be blocked
	// until this window is closed
	restaurantStage.initModality( Modality.APPLICATION_MODAL );
 
	// Set position of the song window vs. the main window.
	restaurantStage.setX( primaryStage.getX() + 200);
	restaurantStage.setY( primaryStage.getY() + 100);

	// make it accessible in the butoon handler
	this.restaurantStage = restaurantStage;

	restaurantStage.show();
    }
 
    public void nextButtonHandler( ActionEvent event )
    {
	// get the next restaurant to view
	if( iter.hasNext() ) {
	    Restaurant restaurant = iter.next();
	    name.setText( restaurant.getName() );
	    description.setText( restaurant.getDescription() );
	    address.setText( restaurant.getAddress() );
	}
	else {
	    // if at the end, inform the user and hide the next button
	    name.setText( "" );
	    description.setText( "No more restaurants to view" );
	    description.setFont( Font.font( "Helvetica", weight, posture, 18 ) );
	    address.setText( "" );
	    nextButton.setVisible( false );
	}
    }

    // quit the program by exiting the JavaFX application
    public void quitButtonHandler( ActionEvent event )
    {
	Platform.exit();
    }

    // close a window by closing the Stage
    public void closeButtonHandler( ActionEvent event )
    {
	restaurantStage.close();
    }

    // the usual main method, calling launch
    public static void main(String[] args) {
	launch(args);
    }
 
}
