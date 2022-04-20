package com.company.quiz.question;

public class TrueFalse extends Question{
    public TrueFalse(String aQuestionText, String aCorrectAnswer) {
        super(aQuestionText, aCorrectAnswer);
    }

    @Override
    public boolean equals(Object obj) {
        return ((TrueFalse) obj).getQuestionText().equals(this.getQuestionText());
    }

    @Override
    public String toString() {
        return super.getQuestionText();
    }
    @Override
    public boolean validateUserInput(String aInput) {
        return aInput.toUpperCase().matches("TRUE|FALSE");
    }
    @Override
    public boolean checkAnswer(){
        return getSubmittedAnswer().equals(getCorrectAnswer());
    }
}
