package edu.uga.cs1302.quiz;

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
import javafx.scene.control.RadioButton;
import javafx.scene.text.TextAlignment;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
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
	private Scene scene1,scene2,scene3,scene4,scene5,scene6,scoreScene,previousResults,helpStage;
	private RadioButton radio1, radio2, radio3, radio21, radio22, radio23, radio31, radio32, radio33, radio41, radio42, radio43, radio51, radio52, radio53, radio61, radio62, radio63, c1,c2,c3,c4,c5,c6;
	private ToggleGroup question1, question2, question3, question4, question5, question6;

	private Button nextButton;
	private Button prevButton;
	private Button start;
	private Button submit;
	private Label name;
	private FontWeight weight;
	private FontPosture posture;

	@Override
	public void start(Stage primaryStage) {
		// creates a quiz
		Quiz quiz = new Quiz();

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
		Button startButton = new Button("Start");
		startButton.setOnAction(this::startButtonHandler);

		// Quit the program by exiting the JavaFX application
		Button quitButton = new Button("Quit");
		quitButton.setOnAction(this::quitButtonHandler);

		// Button to view instructions and rules
		Button helpButton = new Button("Help");
		helpButton.setOnAction(this::helpButtonHandler);

		Button closeButton = new Button("Close");
		closeButton.setOnAction(this::closeButtonHandler);

		// Button to submit the whole quiz
		Button submitButton = new Button("Submit");
		submitButton.setOnAction(this::submitButtonHandler);

		// Button to view past scores
		Button resultButton = new Button("Previous Results");
		resultButton.setOnAction(this::resultButtonHandler);

		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(40);
		root.getChildren().addAll(title, instructions, start, startButton, quitButton);

		this.primaryStage = primaryStage;

		Scene scene = new Scene(root, 450, 350);
		primaryStage.setTitle("Geography Quiz");
		primaryStage.setScene(scene);
		primaryStage.show();

		Text q1 = new Text(quiz.getQuestion(0).getQuestion());
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q1.setFont(Font.font("Helvetica", weight, posture, 24));
		String store [] = quiz.getQuestion(0).getAnswer();
		radio1 = new RadioButton(store[0]);
		radio2 = new RadioButton(store[1]);
		radio3 = new RadioButton(store[2]);
		question1= new ToggleGroup();
		radio1.setToggleGroup(question1);
		radio2.setToggleGroup(question1);
		radio3.setToggleGroup(question1);
		VBox p1 = new VBox();
		p1.setAlignment(Pos.CENTER);
		p1.setSpacing(40);
		for(int i = 0; i < 3; i++) {
			if(store[i].equals(quiz.getQuestion(0).getCorrectAnswer())) {
				if(i == 0) {
					c1 = radio1;
					p1.getChildren().addAll(q1, c1, radio2,radio3);
				}
				if(i == 1) {
					c1 = radio2;
					p1.getChildren().addAll(q1, radio1, c1,radio3);
				}
				if(i == 2) {
					c1 = radio3;
					p1.getChildren().addAll(q1, radio1, radio2,c1);
				}
			}
		}
		scene1 = new Scene(p1, 450, 350);
		
		Text q2 = new Text(quiz.getQuestion(1).getQuestion());
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q2.setFont(Font.font("Helvetica", weight, posture, 24));
		store = quiz.getQuestion(1).getAnswer();
		radio21 = new RadioButton(store[0]);
		radio22 = new RadioButton(store[1]);
		radio23 = new RadioButton(store[2]);
		question2= new ToggleGroup();
		radio21.setToggleGroup(question2);
		radio22.setToggleGroup(question2);
		radio23.setToggleGroup(question2);
		VBox p2 = new VBox();
		p2.setAlignment(Pos.CENTER);
		p2.setSpacing(40);
		for(int i = 0; i < 3; i++) {
			if(store[i].equals(quiz.getQuestion(1).getCorrectAnswer())) {
				if(i == 0) {
					c2 = radio1;
					p2.getChildren().addAll(q2, c2, radio2,radio3);
				}
				if(i == 1) {
					c2 = radio2;
					p2.getChildren().addAll(q2, radio1, c2,radio3);
				}
				if(i == 2) {
					c2 = radio3;
					p2.getChildren().addAll(q2, radio1, radio2,c2);
				}
			}
		}
		scene2 = new Scene(p2, 450, 350);
		
		Text q3 = new Text(quiz.getQuestion(2).getQuestion());
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q3.setFont(Font.font("Helvetica", weight, posture, 24));
		store = quiz.getQuestion(2).getAnswer();
		radio31 = new RadioButton(store[0]);
		radio32 = new RadioButton(store[1]);
		radio33 = new RadioButton(store[2]);
		question3= new ToggleGroup();
		radio31.setToggleGroup(question3);
		radio32.setToggleGroup(question3);
		radio33.setToggleGroup(question3);
		VBox p3 = new VBox();
		p3.setAlignment(Pos.CENTER);
		p3.setSpacing(40);
		for(int i = 0; i < 3; i++) {
			if(store[i].equals(quiz.getQuestion(2).getCorrectAnswer())) {
				if(i == 0) {
					c3 = radio1;
					p3.getChildren().addAll(q3, c3, radio2,radio3);
				}
				if(i == 1) {
					c3 = radio2;
					p3.getChildren().addAll(q3, radio1, c3,radio3);
				}
				if(i == 2) {
					c3 = radio3;
					p3.getChildren().addAll(q3, radio1, radio2,c3);
				}
			}
		}
		scene3 = new Scene(p3, 450, 350);
		
		Text q4 = new Text(quiz.getQuestion(3).getQuestion());
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q4.setFont(Font.font("Helvetica", weight, posture, 24));
		store = quiz.getQuestion(3).getAnswer();
		radio41 = new RadioButton(store[0]);
		radio42 = new RadioButton(store[1]);
		radio43 = new RadioButton(store[2]);
		question4= new ToggleGroup();
		radio41.setToggleGroup(question4);
		radio42.setToggleGroup(question4);
		radio43.setToggleGroup(question4);
		VBox p4 = new VBox();
		p4.setAlignment(Pos.CENTER);
		p4.setSpacing(40);
		for(int i = 0; i < 3; i++) {
			if(store[i].equals(quiz.getQuestion(3).getCorrectAnswer())) {
				if(i == 0) {
					c4 = radio1;
					p4.getChildren().addAll(q4, c4, radio2,radio3);
				}
				if(i == 1) {
					c4 = radio2;
					p4.getChildren().addAll(q4, radio1, c4,radio3);
				}
				if(i == 2) {
					c4 = radio3;
					p4.getChildren().addAll(q4, radio1, radio2,c4);
				}
			}
		}
		scene4 = new Scene(p4, 450, 350);
		
		Text q5 = new Text(quiz.getQuestion(4).getQuestion());
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q5.setFont(Font.font("Helvetica", weight, posture, 24));
		store = quiz.getQuestion(4).getAnswer();
		radio51 = new RadioButton(store[0]);
		radio52 = new RadioButton(store[1]);
		radio53 = new RadioButton(store[2]);
		question5= new ToggleGroup();
		radio51.setToggleGroup(question5);
		radio52.setToggleGroup(question5);
		radio53.setToggleGroup(question5);
		VBox p5 = new VBox();
		p5.setAlignment(Pos.CENTER);
		p5.setSpacing(40);
		for(int i = 0; i < 3; i++) {
			if(store[i].equals(quiz.getQuestion(4).getCorrectAnswer())) {
				if(i == 0) {
					c5 = radio1;
					p5.getChildren().addAll(q5, c5, radio2,radio3);
				}
				if(i == 1) {
					c5 = radio2;
					p5.getChildren().addAll(q5, radio1, c5,radio3);
				}
				if(i == 2) {
					c5 = radio3;
					p5.getChildren().addAll(q5, radio1, radio2,c5);
				}
			}
		}
		scene5 = new Scene(p5, 450, 350);
		
		Text q6 = new Text(quiz.getQuestion(5).getQuestion());
		weight = FontWeight.BOLD;
		posture = FontPosture.REGULAR;
		q6.setFont(Font.font("Helvetica", weight, posture, 24));
		store = quiz.getQuestion(5).getAnswer();
		radio61 = new RadioButton(store[0]);
		radio62 = new RadioButton(store[1]);
		radio63 = new RadioButton(store[2]);
		question6= new ToggleGroup();
		radio61.setToggleGroup(question6);
		radio62.setToggleGroup(question6);
		radio63.setToggleGroup(question6);
		VBox p6 = new VBox();
		p6.setAlignment(Pos.CENTER);
		p6.setSpacing(40);
		for(int i = 0; i < 3; i++) {
			if(store[i].equals(quiz.getQuestion(5).getCorrectAnswer())) {
				if(i == 0) {
					c6 = radio1;
					p6.getChildren().addAll(q6, c6, radio2,radio3);
				}
				if(i == 1) {
					c6 = radio2;
					p6.getChildren().addAll(q6, radio1, c6,radio3);
				}
				if(i == 2) {
					c6 = radio3;
					p6.getChildren().addAll(q6, radio1, radio2,c6);
				}
			}
		}
		scene6 = new Scene(p6, 450, 350);
	}

	public void startButtonHandler(ActionEvent event) {
		primaryStage.setScene(scene1);
	}

	// Button to go from one question page to the next
	public void nextButtonHandler(ActionEvent event) {
		if (primaryStage.getScene() == scene1) {
			primaryStage.setScene(scene2);
		} else if (primaryStage.getScene() == scene2) {
			primaryStage.setScene(scene3);
		} else if (primaryStage.getScene() == scene3) {
			primaryStage.setScene(scene4);
		} else if (primaryStage.getScene() == scene4) {
			primaryStage.setScene(scene5);
		} else if (primaryStage.getScene() == scene5) {
			primaryStage.setScene(scene6);
		}
	}

	public void prevButtonHandler(ActionEvent event) {
		if (primaryStage.getScene() == scene6) {
			primaryStage.setScene(scene5);
		} else if (primaryStage.getScene() == scene5) {
			primaryStage.setScene(scene4);
		} else if (primaryStage.getScene() == scene4) {
			primaryStage.setScene(scene3);
		} else if (primaryStage.getScene() == scene3) {
			primaryStage.setScene(scene2);
		} else if (primaryStage.getScene() == scene2) {
			primaryStage.setScene(scene1);
		}
	}

	// Quit the program by exiting the JavaFX application
	public void quitButtonHandler(ActionEvent event) {
		Platform.exit();
	}

	// Closes a window
	public void closeButtonHandler(ActionEvent event) {
		
	}

	// Button to submit the quiz and view score
	public void submitButtonHandler(ActionEvent event) {
		int num = 0;
		if(c1.isSelected() == true) {
			num++;
		}
		if(c2.isSelected() == true) {
			num++;
		}
		if(c3.isSelected() == true) {
			num++;
		}
		if(c4.isSelected() == true) {
			num++;
		}
		if(c5.isSelected() == true) {
			num++;
		}
		if(c6.isSelected() == true) {
			num++;
		}
		String scores = num + " out of 6";
		result = new QuizScore(scores);
		primaryStage.setScene(scoreScene);
	}

	// Button to view past scores
	public void resultButtonHandler(ActionEvent event) {
		QuizResult r = new QuizResult(result);
		Button quitButton = new Button("Quit");
		quitButton.setOnAction(this::quitButtonHandler);
		Text re = new Text(r.toString());
		VBox rev = new VBox();
		rev.setAlignment(Pos.CENTER);
		rev.setSpacing(40);
		rev.getChildren().addAll(rev, quitButton);
		primaryStage.setScene(previousResults);
	}

	public void helpButtonHandler(ActionEvent event) {
		primaryStage.setScene(helpStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
