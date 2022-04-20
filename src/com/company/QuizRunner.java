package com.company;

import com.company.quiz.Quiz;

public class QuizRunner {
    public static final String PREFIX = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Quiz quiz = new Quiz("Test");
        quiz.startQuiz();
    }
}
