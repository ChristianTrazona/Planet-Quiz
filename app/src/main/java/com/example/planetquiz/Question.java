package com.example.planetquiz;

public class Question {
    private final int id;
    private final int questionResId;
    private final int correctAnswerPlanetResId;
    private final int detailResId;

    public Question(int id, int questionResId, int correctAnswerPlanetResId, int detailResId) {
        this.id = id;
        this.questionResId = questionResId;
        this.correctAnswerPlanetResId = correctAnswerPlanetResId;
        this.detailResId = detailResId;
    }

    public int getId() {
        return id;
    }

    public int getQuestionResId() {
        return questionResId;
    }

    public int getCorrectAnswerPlanetResId() {
        return correctAnswerPlanetResId;
    }

    public int getDetailResId() {
        return detailResId;
    }
}
