package com.company.quiz.question;

import com.company.QuizRunner;

public class MultipleChoice extends Question{
    private String possibleAnswers;

    public MultipleChoice(String aQuestionText, String aCorrectAnswer, String possibleAnswers) {
        super(aQuestionText, aCorrectAnswer);
        this.possibleAnswers = possibleAnswers;
    }

    public String getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(String possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    @Override
    public boolean equals(Object obj) {
        return ((MultipleChoice)obj).getQuestionText().equals(this.getQuestionText());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(getQuestionText()).append("\n");
        String[] possibleAnswersArray = getPossibleAnswers().split(",");
        for(int a=0;a<possibleAnswersArray.length;a++){
            output.append("\t").append(QuizRunner.PREFIX.charAt(a)).append(": ").append(possibleAnswersArray[a]).append("\n");
        }
        return output.toString();
    }

    @Override
    public boolean validateUserInput(String aInput) {
        StringBuilder regex = new StringBuilder();
        regex.append("[A-").append(QuizRunner.PREFIX.charAt(getPossibleAnswers().split(",").length-1)).append("]");
        return aInput.toUpperCase().matches(regex.toString());
    }

    @Override
    public boolean checkAnswer() {
        return getSubmittedAnswer().equals(getCorrectAnswer());
    }
}
