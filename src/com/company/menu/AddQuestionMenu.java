package com.company.menu;

import com.company.QuizRunner;
import com.company.quiz.Quiz;

public class AddQuestionMenu extends Menu{
    private static final String MENU_TEXT = "Add Question Menu";
    private static final String MENU_INSTRUCTIONS = """
            Select from the following menu options
            or press `Enter` to return to previous menu.
            """;
    private static final String PREVIOUS_MENU = "MainMenu";
    private String menuOptions = "Multiple Choice,CheckBox,True False,Linear Scale,Short Answer,Essay";

    public AddQuestionMenu() {
        super(MENU_TEXT, MENU_INSTRUCTIONS);
    }

    public String getMenuOptions() {
        return menuOptions;
    }

    @Override
    public void displayMenu() {
        StringBuilder output = new StringBuilder();
        output.append(getMenuText()).append("\n\n").append(getMenuInstructions());
        String [] optionsArray = getMenuOptions().split(",");
        for(int a=0;a<optionsArray.length;a++){
            output.append("\t").append(QuizRunner.PREFIX.charAt(a)).append(": ").append(optionsArray[a]).append("\n");
        }
        System.out.println(output);
    }
    public boolean validateMenuSelection(String aInput){
        StringBuilder regex = new StringBuilder();
        regex.append("[A-").append(QuizRunner.PREFIX.charAt(getMenuOptions().split(",").length-1)).append("]");
        return aInput.toUpperCase().matches(regex.toString());
    }
}
