package edu.uga.cs1302.quiz;

import java.util.*;

public class Question {
    private String question;
    private String correctAnswer;
    private String[] answerOptions = new String[3];
    private List<String> continents = new ArrayList<String>();
    private List<Integer> numbers = new ArrayList<Integer>();

    public Question() {
        this.correctAnswer = null;
        this.answerOptions = null;
    }
    public Question(Country c) {
        continents.add("North America");
        continents.add("South America");
        continents.add("Asia");
        continents.add("Europe");
        continents.add("Africa");
        continents.add("Antarctica");
        continents.add("Oceania");
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        continents.remove(c.getContinent());
        Collections.shuffle(numbers);
        Collections.shuffle(continents);

        this.question = c.getName();

        this.correctAnswer = c.getContinent();
        this.answerOptions[numbers.get(0)] = correctAnswer;

        this.answerOptions[numbers.get(1)] = continents.get(0);

        this.answerOptions[numbers.get(2)] = continents.get(1);


    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswer() {
        return answerOptions;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String toString() {
        return "Question: Which continent is " + question + " located on?\n" + answerOptions[0] + "\n" + answerOptions[1] + "\n" + answerOptions[2];
    }

}
