package edu.uga.cs1302.quiz;

import java.util.List;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;

import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.TextAlignment;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class GeographyQuiz extends Application {

	private QuizScore result;

	private Stage primaryStage;
	private Scene scene, scene1, scene2, scene3, scene4, scene5, scene6, scoreScene, previousResults, helpStage;
	private RadioButton choice11, choice12, choice13, choice21, choice22, choice23, choice31, choice32, choice33,
			choice41, choice42, choice43, choice51, choice52, choice53, choice61, choice62, choice63, c1, c2, c3, c4,
			c5, c6;
	private ToggleGroup question1, question2, question3, question4, question5, question6;
	
	private Button nextButton1,nextButton2,nextButton3,nextButton4,nextButton5,nextButton6;
	private Button prevButton1,prevButton2,prevButton3,prevButton4,prevButton5,prevButton6;
	private Button startButton;
	private Button submitButton;
    private Button closeButton,closeButton1;
	private Button helpButton;
	private Button quitButton;
	private Button resultButton;
	private Label name;
	private FontWeight weight;
	private FontPosture posture;

	@Override
	public void start(Stage primaryStage) {

		// creating the main window

		// creating the title text
		Text title = new Text("Countries & Continents Quiz");
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		title.setFont(Font.font("Helvetica", weight, posture, 24));

		// creating the Help text
		Text instructions = new Text("To see the rules and how to play, click 'Help'.");
		Text start = new Text("If you're ready to begin, click 'Start'!");
		posture = FontPosture.REGULAR;
		title.setFont(Font.font("Helvetica", null, posture, 24));

		// Button to start quiz
		startButton = new Button("Start");
		startButton.setOnAction(this::startButtonHandler);

		// Quit the program by exiting the JavaFX application
		quitButton = new Button("Quit");
		quitButton.setOnAction(this::quitButtonHandler);

		// Button to view instructions and rules
		helpButton = new Button("Help");
		helpButton.setOnAction(this::helpButtonHandler);

		closeButton = new Button("Close");
		closeButton.setOnAction(this::closeButtonHandler);
                closeButton1 = new Button("Close");
		closeButton1.setOnAction(this::closeButtonHandler);
		// Button to submit the whole quiz
		submitButton = new Button("Submit");
		submitButton.setOnAction(this::submitButtonHandler);

		// Button to view past scores
		resultButton = new Button("Previous Results");
		resultButton.setOnAction(this::resultButtonHandler);

		nextButton1 = new Button("next");
		nextButton1.setOnAction(this::nextButtonHandler);

		prevButton1 = new Button("prev");
		prevButton1.setOnAction(this::prevButtonHandler);
		
		nextButton2 = new Button("next");
		nextButton2.setOnAction(this::nextButtonHandler);

		prevButton2 = new Button("prev");
		prevButton2.setOnAction(this::prevButtonHandler);
		
		nextButton3 = new Button("next");
		nextButton3.setOnAction(this::nextButtonHandler);

		prevButton3 = new Button("prev");
		prevButton3.setOnAction(this::prevButtonHandler);
		
		nextButton4 = new Button("next");
		nextButton4.setOnAction(this::nextButtonHandler);

		prevButton4 = new Button("prev");
		prevButton4.setOnAction(this::prevButtonHandler);
		
		nextButton5 = new Button("next");
		nextButton5.setOnAction(this::nextButtonHandler);

		prevButton5 = new Button("prev");
		prevButton5.setOnAction(this::prevButtonHandler);
		
		nextButton6 = new Button("next");
		nextButton6.setOnAction(this::nextButtonHandler);

		prevButton6 = new Button("prev");
		prevButton6.setOnAction(this::prevButtonHandler);

		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(40);
		root.getChildren().addAll(title, instructions, start, startButton, resultButton, helpButton, quitButton);

		this.primaryStage = primaryStage;

		scene = new Scene(root, 600, 600);
		primaryStage.setTitle("Geography Quiz");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void startButtonHandler(ActionEvent event) {
		Quiz quiz = new Quiz();
		HBox bottom1 = new HBox();
		bottom1.setAlignment(Pos.CENTER);
		bottom1.setSpacing(40);
		bottom1.getChildren().addAll(prevButton1,nextButton1);
		HBox bottom2 = new HBox();
		bottom2.setAlignment(Pos.CENTER);
		bottom2.setSpacing(40);
		bottom2.getChildren().addAll(prevButton2,nextButton2);
		HBox bottom3 = new HBox();
		bottom3.setAlignment(Pos.CENTER);
		bottom3.setSpacing(40);
		bottom3.getChildren().addAll(prevButton3,nextButton3);
		HBox bottom4 = new HBox();
		bottom4.setAlignment(Pos.CENTER);
		bottom4.setSpacing(40);
		bottom4.getChildren().addAll(prevButton4,nextButton4);
		HBox bottom5 = new HBox();
		bottom5.setAlignment(Pos.CENTER);
		bottom5.setSpacing(40);
		bottom5.getChildren().addAll(prevButton5,nextButton5);
		HBox bottom6 = new HBox();
		bottom6.setAlignment(Pos.CENTER);
		bottom6.setSpacing(40);
		bottom6.getChildren().addAll(prevButton6,submitButton,nextButton6);
		//
		Text q1 = new Text("Question: Which continent is " + quiz.getQuestion(0).getQuestion() + " located on?");
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q1.setFont(Font.font("Helvetica", null, posture, 18));

		VBox question1 = new VBox();
		String[] store = quiz.getQuestion(0).getAnswer();
		choice11 = new RadioButton(store[0]);
		choice12 = new RadioButton(store[1]);
		choice13 = new RadioButton(store[2]);

		question1.setAlignment(Pos.CENTER);
		question1.setSpacing(40);
		this.question1 = new ToggleGroup();
		if (store[0].equals(quiz.getQuestion(0).getCorrectAnswer())) {
			c1 = new RadioButton(store[0]);
			question1.getChildren().addAll(q1, c1, choice12, choice13, bottom1);
			c1.setToggleGroup(this.question1);
			choice12.setToggleGroup(this.question1);
			choice13.setToggleGroup(this.question1);
		} else if (store[1].equals(quiz.getQuestion(0).getCorrectAnswer())) {
			c1 = new RadioButton(store[1]);
			question1.getChildren().addAll(q1, choice11, c1, choice13, bottom1);
			choice11.setToggleGroup(this.question1);
			c1.setToggleGroup(this.question1);
			choice13.setToggleGroup(this.question1);
		} else {
			c1 = new RadioButton(store[2]);
			question1.getChildren().addAll(q1, choice11, choice12, c1, bottom1);
			choice11.setToggleGroup(this.question1);
			choice12.setToggleGroup(this.question1);
			c1.setToggleGroup(this.question1);
		}
		scene1 = new Scene(question1, 600, 600);
//		
		Text q2 = new Text("Question: Which continent is " + quiz.getQuestion(1).getQuestion() + " located on?");
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q2.setFont(Font.font("Helvetica", null, posture, 18));

		VBox question2 = new VBox();
		store = quiz.getQuestion(2).getAnswer();
		choice21 = new RadioButton(store[0]);
		choice22 = new RadioButton(store[1]);
		choice23 = new RadioButton(store[2]);

		question2.setAlignment(Pos.CENTER);
		question2.setSpacing(40);
		this.question2 = new ToggleGroup();
		if (store[0].equals(quiz.getQuestion(1).getCorrectAnswer())) {
			c2 = new RadioButton(store[0]);
			question2.getChildren().addAll(q2, c2, choice22, choice23, bottom2);
			c2.setToggleGroup(this.question2);
			choice22.setToggleGroup(this.question2);
			choice23.setToggleGroup(this.question2);
		} else if (store[1].equals(quiz.getQuestion(1).getCorrectAnswer())) {
			c2 = new RadioButton(store[1]);
			question2.getChildren().addAll(q2, choice21, c2, choice23, bottom2);
			choice21.setToggleGroup(this.question2);
			c2.setToggleGroup(this.question2);
			choice23.setToggleGroup(this.question2);
		} else {
			c2 = new RadioButton(store[2]);
			question2.getChildren().addAll(q2, choice21, choice22, c2, bottom2);
			choice21.setToggleGroup(this.question2);
			choice22.setToggleGroup(this.question2);
			c2.setToggleGroup(this.question2);
		}
		scene2 = new Scene(question2, 600, 600);
		//
		Text q3 = new Text("Question: Which continent is " + quiz.getQuestion(2).getQuestion() + " located on?");
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q3.setFont(Font.font("Helvetica", null, posture, 18));

		VBox question3 = new VBox();
		store = quiz.getQuestion(2).getAnswer();
		choice31 = new RadioButton(store[0]);
		choice32 = new RadioButton(store[1]);
		choice33 = new RadioButton(store[2]);

		question3.setAlignment(Pos.CENTER);
		question3.setSpacing(40);
		this.question3 = new ToggleGroup();
		if (store[0].equals(quiz.getQuestion(2).getCorrectAnswer())) {
			c3 = new RadioButton(store[0]);
			question3.getChildren().addAll(q3, c3, choice32, choice33, bottom3);
			c3.setToggleGroup(this.question3);
			choice32.setToggleGroup(this.question3);
			choice33.setToggleGroup(this.question3);
		} else if (store[1].equals(quiz.getQuestion(2).getCorrectAnswer())) {
			c3 = new RadioButton(store[1]);
			question3.getChildren().addAll(q3, choice31, c3, choice33, bottom3);
			choice31.setToggleGroup(this.question3);
			c3.setToggleGroup(this.question3);
			choice33.setToggleGroup(this.question3);
		} else {
			c3 = new RadioButton(store[2]);
			question3.getChildren().addAll(q3, choice31, choice32, c3, bottom3);
			choice31.setToggleGroup(this.question3);
			choice32.setToggleGroup(this.question3);
			c3.setToggleGroup(this.question3);
		}
		scene3 = new Scene(question3, 600, 600);
		//
		Text q4 = new Text("Question: Which continent is " + quiz.getQuestion(3).getQuestion() + " located on?");
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q4.setFont(Font.font("Helvetica", null, posture, 18));

		VBox question4 = new VBox();
		store = quiz.getQuestion(3).getAnswer();
		choice41 = new RadioButton(store[0]);
		choice42 = new RadioButton(store[1]);
		choice43 = new RadioButton(store[2]);

		question4.setAlignment(Pos.CENTER);
		question4.setSpacing(40);
		this.question4 = new ToggleGroup();
		if (store[0].equals(quiz.getQuestion(3).getCorrectAnswer())) {
			c4 = new RadioButton(store[0]);
			question4.getChildren().addAll(q4, c4, choice42, choice43, bottom4);
			c4.setToggleGroup(this.question4);
			choice42.setToggleGroup(this.question4);
			choice43.setToggleGroup(this.question4);
		} else if (store[1].equals(quiz.getQuestion(3).getCorrectAnswer())) {
			c4 = new RadioButton(store[1]);
			question4.getChildren().addAll(q4, choice41, c4, choice43, bottom4);
			choice41.setToggleGroup(this.question4);
			c4.setToggleGroup(this.question4);
			choice43.setToggleGroup(this.question4);
		} else {
			c4 = new RadioButton(store[2]);
			question4.getChildren().addAll(q4, choice41, choice42, c4, bottom4);
			choice41.setToggleGroup(this.question4);
			choice42.setToggleGroup(this.question4);
			c4.setToggleGroup(this.question4);
		}
		scene4 = new Scene(question4, 600, 600);
		//
		Text q5 = new Text("Question: Which continent is " + quiz.getQuestion(4).getQuestion() + " located on?");
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q5.setFont(Font.font("Helvetica", null, posture, 18));

		VBox question5 = new VBox();
		store = quiz.getQuestion(4).getAnswer();
		choice51 = new RadioButton(store[0]);
		choice52 = new RadioButton(store[1]);
		choice53 = new RadioButton(store[2]);

		question5.setAlignment(Pos.CENTER);
		question5.setSpacing(40);
		this.question5 = new ToggleGroup();
		if (store[0].equals(quiz.getQuestion(4).getCorrectAnswer())) {
			c5 = new RadioButton(store[0]);
			question5.getChildren().addAll(q5, c5, choice52, choice53, bottom5);
			c5.setToggleGroup(this.question5);
			choice52.setToggleGroup(this.question5);
			choice53.setToggleGroup(this.question5);
		} else if (store[1].equals(quiz.getQuestion(4).getCorrectAnswer())) {
			c5 = new RadioButton(store[1]);
			question5.getChildren().addAll(q5, choice51, c5, choice53, bottom5);
			choice51.setToggleGroup(this.question5);
			c5.setToggleGroup(this.question5);
			choice53.setToggleGroup(this.question5);
		} else {
			c5 = new RadioButton(store[2]);
			question5.getChildren().addAll(q5, choice51, choice52, c5, bottom5);
			choice51.setToggleGroup(this.question5);
			choice52.setToggleGroup(this.question5);
			c5.setToggleGroup(this.question5);
		}
		scene5 = new Scene(question5, 600, 600);
		//
		Text q6 = new Text("Question: Which continent is " + quiz.getQuestion(5).getQuestion() + " located on?");
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q6.setFont(Font.font("Helvetica", null, posture, 18));

		VBox question6 = new VBox();
		store = quiz.getQuestion(5).getAnswer();
		choice61 = new RadioButton(store[0]);
		choice62 = new RadioButton(store[1]);
		choice63 = new RadioButton(store[2]);

		question6.setAlignment(Pos.CENTER);
		question6.setSpacing(40);
		this.question6 = new ToggleGroup();
		if (store[0].equals(quiz.getQuestion(5).getCorrectAnswer())) {
			c6 = new RadioButton(store[0]);
			question6.getChildren().addAll(q6, c6, choice62, choice63, bottom6);
			c6.setToggleGroup(this.question6);
			choice62.setToggleGroup(this.question6);
			choice63.setToggleGroup(this.question6);
		} else if (store[1].equals(quiz.getQuestion(5).getCorrectAnswer())) {
			c6 = new RadioButton(store[1]);
			question6.getChildren().addAll(q6, choice61, c6, choice63, bottom6);
			choice61.setToggleGroup(this.question6);
			c6.setToggleGroup(this.question6);
			choice63.setToggleGroup(this.question6);
		} else {
			c6 = new RadioButton(store[2]);
			question6.getChildren().addAll(q6, choice61, choice62, c6, bottom6);
			choice61.setToggleGroup(this.question6);
			choice62.setToggleGroup(this.question6);
			c6.setToggleGroup(this.question6);
		}
		scene6 = new Scene(question6, 600, 600);
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	// Button to go from one question page to the next
	public void nextButtonHandler(ActionEvent event) {
		if (primaryStage.getScene() == scene1) {
			primaryStage.setScene(scene2);
			primaryStage.show();
		} else if (primaryStage.getScene() == scene2) {
			primaryStage.setScene(scene3);
			primaryStage.show();
		} else if (primaryStage.getScene() == scene3) {
			primaryStage.setScene(scene4);
			primaryStage.show();
		} else if (primaryStage.getScene() == scene4) {
			primaryStage.setScene(scene5);
			primaryStage.show();
		} else if (primaryStage.getScene() == scene5) {
			primaryStage.setScene(scene6);
			primaryStage.show();
		}
	}

	public void prevButtonHandler(ActionEvent event) {
		if (primaryStage.getScene() == scene6) {
			primaryStage.setScene(scene5);
			primaryStage.show();
		} else if (primaryStage.getScene() == scene5) {
			primaryStage.setScene(scene4);
			primaryStage.show();
		} else if (primaryStage.getScene() == scene4) {
			primaryStage.setScene(scene3);
			primaryStage.show();
		} else if (primaryStage.getScene() == scene3) {
			primaryStage.setScene(scene2);
			primaryStage.show();
		} else if (primaryStage.getScene() == scene2) {
			primaryStage.setScene(scene1);
			primaryStage.show();
		}
	}

	// Quit the program by exiting the JavaFX application
	public void quitButtonHandler(ActionEvent event) {
		Platform.exit();
	}

	// Closes a window
	public void closeButtonHandler(ActionEvent event) {
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// Button to submit the quiz and view score
	public void submitButtonHandler(ActionEvent event) {
		int num = 0;
		if (c1.isSelected() == true) {
			num++;
		}
		if (c2.isSelected() == true) {
			num++;
		}
		if (c3.isSelected() == true) {
			num++;
		}
		if (c4.isSelected() == true) {
			num++;
		}
		if (c5.isSelected() == true) {
			num++;
		}
		if (c6.isSelected() == true) {
			num++;
		}
		String scores = num + " out of 6";
		result = new QuizScore(scores);
		Text q1 = new Text(scores);
		QuizResult r = new QuizResult(result);
	
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q1.setFont(Font.font("Helvetica", weight, posture, 24));

		VBox pick = new VBox();
		pick.setAlignment(Pos.CENTER);
		pick.setSpacing(40);
		pick.getChildren().addAll(q1, closeButton);

		scoreScene = new Scene(pick, 600, 600);
		primaryStage.setScene(scoreScene);
		primaryStage.show();

	}

	// Button to view past scores
	public void resultButtonHandler(ActionEvent event) {
	    System.out.println("Creating quiz results");
		QuizResult r = new QuizResult();
		System.out.println("created");
		System.out.println("Creating the text for the quiz results");
		Text re = new Text(r.toString());
		weight = FontWeight.BLACK;
		posture = FontPosture.REGULAR;
		re.setFont(Font.font("Helvetica", weight, posture, 12));
		System.out.println("Finished");

		System.out.println("Created VBox");
		VBox rev = new VBox();
		rev.setAlignment(Pos.CENTER);
		rev.setSpacing(40);
		rev.getChildren().addAll(re, closeButton1);
		System.out.println("Finish");
        
		previousResults = new Scene(rev, 600, 600);
		primaryStage.setScene(previousResults);
		primaryStage.show();

	}

	public void helpButtonHandler(ActionEvent event) {
		Text q1 = new Text("To start the quiz click the start button. After clicking start \n"
				+          "a question will pop up with 3 answer choices. The question will\n"
				+          "list one country asking which continent the country is located\n"
				+          "on. There will be 3 continents to choose from, one of which\n"
				+          "will be the correct answer. The quiz contains 6 questions in\n" + 
				           "total. To go to the next question a button next will be located\n"
				          +"in the bottom right. To go to a previous question a previous\n"
				          +"button will be located in the bottom left. Once you are finished\n"
				          + "click sumbit which will be located in the bottom middle of the\n"
				          + "screen. After sumbiting a screen will pop up with your score out\n"
				          + "of 6. You then click close which will send you to the main menu.\n"
				          + "To see the previous results click the previous results button\n"
				          + "located in the main menu. You can scroll through old results and\n"
				          + "go back to main menu by clicking close. You can test again by\n"
				          + "clicking the start button again or end the program by clicking\n"
				          + "quit.");
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q1.setFont(Font.font("Helvetica", null, posture, 20));

		VBox pick = new VBox();
		pick.setAlignment(Pos.CENTER);
		pick.setSpacing(40);
		pick.getChildren().addAll(q1, closeButton);

		helpStage = new Scene(pick, 600, 600);
		primaryStage.setScene(helpStage);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}
}
