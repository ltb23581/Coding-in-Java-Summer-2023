package edu.uga.cs1302.quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class QuizResult implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<QuizScore> results = new ArrayList<QuizScore>();

	public QuizResult() {
		String fileName = "Scores.dat";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			if (br.readLine() == null) {

			} else {
				ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
				results = loadResultsFromFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public QuizResult(QuizScore s) {
		String fileName = "Scores.dat";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			if (br.readLine() == null) {
				addScore(s);
			} else {

				ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));

				results = loadResultsFromFile();
				addScore(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addScore(QuizScore r) {
		results.add(0, r);
		saveResultsToFile(results);
	}

	private static void saveResultsToFile(List<QuizScore> quizResults) {
		String fileName = "Scores.dat";
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
			outputStream.writeObject(quizResults);
			outputStream.flush();
			outputStream.close();
			System.out.println("Quiz results saved to " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<QuizScore> loadResultsFromFile() {
		String fileName = "Scores.dat";
		List<QuizScore> loadedResults = new ArrayList<>();
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
			loadedResults = (List<QuizScore>) inputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return loadedResults;
	}

	public String toString() {
		String store = "";
		for (int i = 0; i < results.size(); i++) {
			store = results.get(i).toString();
			store = "\n";
		}
		return store;
	}
}
