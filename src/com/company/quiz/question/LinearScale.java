package com.company.quiz.question;

public class LinearScale extends Question{
    private Integer minValue;
    private Integer maxValue;

    public LinearScale(String aQuestionText, Integer aMinValue, Integer aMaxValue) {
        super(aQuestionText);
        minValue = aMinValue;
        maxValue = aMaxValue;
    }

    public Integer getMinValue() {
        return minValue;
    }
    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }
    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public boolean equals(Object obj) {
        return ((LinearScale) obj).getQuestionText().equals(this.getQuestionText());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(getQuestionText()).append("\nEnter an integer between ").append(getMinValue()).append(" and ").append(getMaxValue());
        return output.toString();
    }

    @Override
    public boolean validateUserInput(String aInput) {
        try{
            Integer input = Integer.parseInt(aInput);
            return (input >= getMinValue() && input <= getMaxValue());
        } catch (Exception e){
            return false;
        }
    }
    public boolean checkAnswer(){
        return Integer.parseInt(getSubmittedAnswer()) >= getMinValue() && Integer.parseInt(getSubmittedAnswer()) <= getMaxValue();
    }
}
