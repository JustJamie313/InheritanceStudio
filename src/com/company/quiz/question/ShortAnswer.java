package com.company.quiz.question;

import java.util.Locale;

public class ShortAnswer extends Question{
    public ShortAnswer(String aQuestionText, String aCorrectAnswer) {
        super(aQuestionText, aCorrectAnswer);
    }

    @Override
    public boolean equals(Object obj) {
        return ((ShortAnswer) obj).getQuestionText().equals(this.getQuestionText());
    }

    @Override
    public String toString() {
        return super.getQuestionText();
    }

    @Override
    public boolean validateUserInput(String aInput) {
        return aInput.length()<=80;
    }
    public boolean checkAnswer(){
        return getSubmittedAnswer().toUpperCase().equals(getCorrectAnswer().toUpperCase());
    }
}
