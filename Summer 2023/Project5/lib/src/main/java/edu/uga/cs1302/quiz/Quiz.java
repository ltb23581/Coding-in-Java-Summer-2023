package edu.uga.cs1302.quiz;

import java.util.*;


public class Quiz {
    private List<Question> questions = new ArrayList<Question>();;

    public Quiz() {
        Random rand = new Random();
        CountryCollection countries = new CountryCollection();
        List<Country> c = countries.getCountries();
        Collections.shuffle(c);
        if (c.size() > 0) {
            Question q1 = new Question(c.get(0));
            Question q2 = new Question(c.get(1));
            Question q3 = new Question(c.get(2));
            Question q4 = new Question(c.get(3));
            Question q5 = new Question(c.get(4));
            Question q6 = new Question(c.get(5));
            questions.add(q1);
            questions.add(q2);
            questions.add(q3);
            questions.add(q4);
            questions.add(q5);
            questions.add(q6);
        }
    }

    public Question getQuestion(int num) {
        return questions.get(num);
    }

    public String toString() {
        return questions.get(0).toString() + "\n" + questions.get(1).toString() + "\n" + questions.get(2).toString()
                + "\n" + questions.get(3).toString() + "\n" + questions.get(4).toString() + "\n"
                + questions.get(5).toString();
    }
}
