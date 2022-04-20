package com.company.quiz.question;

public class Essay extends Question{
    public Essay(String aQuestionText) {
        super(aQuestionText);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Essay) obj).getQuestionText().equals(this.getQuestionText());
    }

    @Override
    public String toString() {
        return super.getQuestionText();
    }

    @Override
    public boolean validateUserInput(String aInput) {
        return aInput.length()<=500;
    }
    public boolean checkAnswer(){
        return getSubmittedAnswer().length()<=500;
    }
}
