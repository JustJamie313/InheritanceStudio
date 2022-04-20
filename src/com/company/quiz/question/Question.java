package com.company.quiz.question;

public abstract class Question {

    private String questionText;
    private String correctAnswer;
    private String submittedAnswer;

    //constructors
    //For Essay and Linear Scale Questions
    public Question(String aQuestionText) {this.questionText = aQuestionText;}
    //For all the other questions
    public Question(String aQuestionText, String aCorrectAnswer) {
        this.questionText = aQuestionText;
        this.correctAnswer = aCorrectAnswer;
    }
    //getters
    public String getQuestionText() {
        return questionText;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public String getSubmittedAnswer() {
        return submittedAnswer;
    }

    //setters
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    public void setSubmittedAnswer(String submittedAnswer) {
        this.submittedAnswer = submittedAnswer;
    }

    //abstract overrides
    @Override
    public abstract boolean equals(Object obj);
    @Override
    public abstract String toString();

    //abstract methods
    public abstract boolean validateUserInput(String aInput);
    public abstract boolean checkAnswer();

    //methods
    public void displayQuestion(){
        System.out.println(toString());
    }
}
