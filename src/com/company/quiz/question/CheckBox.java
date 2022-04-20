package com.company.quiz.question;

import com.company.QuizRunner;

public class CheckBox extends Question{
    private String possibleAnswers;

    public CheckBox(String aQuestionText, String aCorrectAnswer, String possibleAnswers) {
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
        return ((CheckBox)obj).getQuestionText().equals(this.getQuestionText());
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
        if(aInput.equals("")){return false;}
        StringBuilder regex = new StringBuilder();
        regex.append("[A-").append(QuizRunner.PREFIX.charAt(getPossibleAnswers().split(",").length-1)).append("]*");
        return aInput.toUpperCase().matches(regex.toString());
    }

    @Override
    public boolean checkAnswer() {
        String[] submittedAnswerArray = getSubmittedAnswer().split("");
        String[] correctAnswerArray = getCorrectAnswer().split(",");
        Integer count = 0;
        if(submittedAnswerArray.length == correctAnswerArray.length){
            for(String answer:submittedAnswerArray){
                for(String correctAnswer:correctAnswerArray){
                    if(answer.equals(correctAnswer)){
                        count++;
                    }
                }
            }
            if(count.equals(correctAnswerArray.length)){
                return true;
            }
            return false;
        }
        return false;
    }
}
