package com.example.planetquiz;

import java.util.ArrayList;
import java.util.List;

public class QuizRepository {
    private static final List<Question> QUESTIONS = new ArrayList<>();

    static {
        QUESTIONS.add(new Question(
                0,
                R.string.question_1,
                R.string.planet_jupiter,
                R.string.detail_largest_planet
        ));
        QUESTIONS.add(new Question(
                1,
                R.string.question_2,
                R.string.planet_saturn,
                R.string.detail_most_moons
        ));
        QUESTIONS.add(new Question(
                2,
                R.string.question_3,
                R.string.planet_uranus,
                R.string.detail_spins_on_side
        ));
    }

    public static List<Question> getQuestions() {
        return QUESTIONS;
    }

    public static Question getQuestion(int index) {
        if (index >= 0 && index < QUESTIONS.size()) {
            return QUESTIONS.get(index);
        }
        return QUESTIONS.get(0);
    }
}
