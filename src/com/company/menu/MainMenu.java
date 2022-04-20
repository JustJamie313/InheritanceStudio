package com.company.menu;

import com.company.QuizRunner;
import com.company.quiz.Quiz;

public class MainMenu extends Menu{
    private static final String MENU_TEXT = "Main Menu";
    private static final String MENU_INSTRUCTIONS = """
            Select from the following menu options
            or press `Enter` to quit.
            """;
    private String menuOptions;
    private Quiz quiz;

    public MainMenu(Quiz aQuiz) {
        super(MENU_TEXT, MENU_INSTRUCTIONS);
        this.quiz = aQuiz;
        this.menuOptions = buildMenu();
    }

    public String getMenuOptions() {
        return menuOptions;
    }

    public void displayMenu(){
        buildMenu();
        StringBuilder output = new StringBuilder();
        output.append(getMenuText()).append("\n\n").append(getMenuInstructions());
        String [] optionsArray = getMenuOptions().split(",");
        for(int a=0;a<optionsArray.length;a++){
            output.append("\t").append(QuizRunner.PREFIX.charAt(a)).append(": ").append(optionsArray[a]).append("\n");
        }
        System.out.println(output);
    }
    public String buildMenu(){
        StringBuilder menu = new StringBuilder();
        menu.append("Add Question");
        if(!this.quiz.getQuestions().isEmpty()){
           menu.append(",Take Quiz");
        }
        if(this.quiz.getCompleted()){
            menu.append(",Grade Quiz");
        }
        return menu.toString();
    }
    @Override
    public boolean validateMenuSelection(String aInput){
        StringBuilder regex = new StringBuilder();
        regex.append("[A-").append(QuizRunner.PREFIX.charAt(getMenuOptions().split(",").length-1)).append("]");
        return aInput.toUpperCase().matches(regex.toString());
    }
}
