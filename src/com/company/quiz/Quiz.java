package com.company.quiz;

import com.company.QuizRunner;
import com.company.menu.AddQuestionMenu;
import com.company.menu.MainMenu;
import com.company.menu.Menu;
import com.company.quiz.question.CheckBox;
import com.company.quiz.question.Essay;
import com.company.quiz.question.LinearScale;
import com.company.quiz.question.MultipleChoice;
import com.company.quiz.question.Question;
import com.company.quiz.question.ShortAnswer;
import com.company.quiz.question.TrueFalse;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static java.util.Objects.isNull;

public class Quiz {
    private TreeMap<String, ArrayList<Question>> questions = new TreeMap<String, ArrayList<Question>>();
    private String name;
    private String pathToCSVFile;
    private Boolean completed = false;

    public Quiz(String aName) {
        this.name = aName;
    }
    public Quiz(String aName, TreeMap<String, ArrayList<Question>> questions) {
        this.questions = questions;
        this.name = aName;
    }
    public Quiz(String aName, String aPathToCSVFile){
        this.name = aName;
        this.pathToCSVFile = aPathToCSVFile;
    }

    public TreeMap<String, ArrayList<Question>> getQuestions() {
        return questions;
    }

    public String getName() {
        return name;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public String getPathToCSVFile() {
        return pathToCSVFile;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void startQuiz(){
        System.out.println(getName());
        MainMenu menu = new MainMenu(this);
        menu.displayMenu();
        String response = getMenuSelection(menu);
        if(isNull(response)){
            return;
        }
        switch(response){
            case "A":
                addQuestion(menu);
            break;
            case "B":
                takeQuiz();
            break;
            case "C":
                gradeQuiz();
            break;
        }
        startQuiz();
    }
    public void addQuestion(Menu aPreviousMenu){
        AddQuestionMenu addMenu = new AddQuestionMenu();
        ArrayList<Question> currentQuestions = null;
        addMenu.displayMenu();
        String response = getMenuSelection(addMenu);
        String q;
        String a;
        StringBuilder possibleAnswers;
        StringBuilder correctAnswers;
        int count;
        boolean exit;
        if(isNull(response)){
            return;
        }
        switch (response){
            case "A":
                currentQuestions = questions.get("MultipleChoiceQuestions");
                System.out.println("Enter the text of the new Multiple Choice question: ");
                if(isNull(currentQuestions)){
                    currentQuestions = new ArrayList<>();
                }
                q = getUserInput(false);
                exit = false;
                possibleAnswers = new StringBuilder();
                do{
                    System.out.println("Enter a possible answer for the Multiple Choice question: \nor press `Enter` when finished");
                    a = getUserInput(false);
                    if(a.equals("")){
                        exit = true;
                        continue;
                    }
                    if(possibleAnswers.isEmpty()){
                        possibleAnswers.append(a);
                    } else {
                        possibleAnswers.append(",").append(a);
                    }
                } while(!exit);
                System.out.println("Enter the letter of the correct answer (Range: A-"+QuizRunner.PREFIX.charAt(possibleAnswers.toString().split(",").length-1)+")");
                a = getUserInput(true);
                currentQuestions.add(new MultipleChoice(q,a,possibleAnswers.toString()));
                questions.put("MultipleChoiceQuestions",currentQuestions);
            break;
            case "B":
                currentQuestions = questions.get("CheckBoxQuestions");
                System.out.println("Enter the text of the new CheckBox question: ");
                if(isNull(currentQuestions)){
                    currentQuestions = new ArrayList<>();
                }
                q = getUserInput(false);
                exit = false;
                possibleAnswers = new StringBuilder();
                correctAnswers = new StringBuilder();
                do{
                    System.out.println("Enter a possible answer for the CheckBox question: \nor press `Enter` when finished");
                    a = getUserInput(false);
                    if(a.equals("")){
                        exit = true;
                        continue;
                    }
                    if(possibleAnswers.isEmpty()){
                        possibleAnswers.append(a);
                    } else {
                        possibleAnswers.append(",").append(a);
                    }
                    System.out.println("Is this a correct answer?\n `Y` for yes");
                    String response2 = getUserInput(true);
                    if(response2.equals("Y")){
                        if(correctAnswers.isEmpty()){
                            correctAnswers.append(QuizRunner.PREFIX.charAt(possibleAnswers.toString().split(",").length-1));
                        } else {
                            correctAnswers.append(",").append(QuizRunner.PREFIX.charAt(possibleAnswers.toString().split(",").length-1));
                        }
                    }
                } while(!exit);
                currentQuestions.add(new CheckBox(q,correctAnswers.toString(),possibleAnswers.toString()));
                questions.put("CheckBoxQuestions",currentQuestions);
            break;
            case "C":
                currentQuestions = questions.get("TrueFalseQuestions");
                System.out.println("Enter the text of the new True/False question: ");
                if(isNull(currentQuestions)){
                    currentQuestions = new ArrayList<>();
                }
                q = getUserInput(false);
                System.out.println("Is the correct answer true or false?");
                a = getUserInput(true);
                currentQuestions.add(new TrueFalse(q,a));
                questions.put("TrueFalseQuestions",currentQuestions);
            break;
            case "D":
                currentQuestions = questions.get("LinearScaleQuestions");
                System.out.println("Enter the text of the new Linear Scale question: ");
                if(isNull(currentQuestions)){
                    currentQuestions = new ArrayList<>();
                }
                q = getUserInput(false);
                System.out.println("Enter the minimum value(integer) for the linear scale question");
                String minV = getUserInput(false);
                System.out.println("Enter the maximum value(integer) for the linear scale question");
                String maxV = getUserInput(false);
                currentQuestions.add(new LinearScale(q,Integer.parseInt(minV),Integer.parseInt(maxV)));
                questions.put("LinearScaleQuestions",currentQuestions);
            break;
            case "E":
                currentQuestions = questions.get("ShortAnswerQuestions");
                System.out.println("Enter the text of the new Short Answer question:");
                if(isNull(currentQuestions)){
                    currentQuestions = new ArrayList<>();
                }
                q = getUserInput(false);
                System.out.println("Enter the correct answer (max 80 chars):");
                a = getUserInput(false);
                currentQuestions.add(new ShortAnswer(q,a));
                questions.put("ShortAnswerQuestions", currentQuestions);
            break;
            case "F":
                currentQuestions = questions.get("EssayQuestions");
                System.out.println("Enter the text of the new essay question: ");
                if(isNull(currentQuestions)){
                    currentQuestions = new ArrayList<>();
                }
                currentQuestions.add(new Essay(getUserInput(false)));
                questions.put("EssayQuestions", currentQuestions);
            break;
        }
        addQuestion(aPreviousMenu);
    }
    public String getUserInput(Boolean toUpper){
        Scanner input = new Scanner(System.in);
        String output = input.nextLine();
        if(toUpper){
            output = output.toUpperCase();
        }
        return output;
    }
    private String getMenuSelection(Menu aMenu){
        boolean exit;
        String response;
        do{
            response = getUserInput(true);
            if(response.equals("")){
                return null;
            }
            exit = aMenu.validateMenuSelection(response);
            if(!exit){
                System.out.println("Invalid Response. Please try again");
            }
        } while (!exit);
        return response;
    }
    private void takeQuiz(){
        for(Map.Entry<String,ArrayList<Question>> category:questions.entrySet()){
            System.out.println(category.getKey());
            for(Question question:category.getValue()){
                question.displayQuestion();
                boolean exit;
                String answer;
                do{
                    answer = getUserInput(true);
                    exit = question.validateUserInput(answer);
                    if(!exit){
                        System.out.println("Invalid Response.  Please try again.");
                    }
                } while (!exit);
                question.setSubmittedAnswer(answer);
            }
        }
        this.completed = true;
    }
    public void gradeQuiz(){
        DecimalFormat df = new DecimalFormat("0.00");
        double correct = 0.0;
        int totalQuestions = 0;
        for(Map.Entry<String,ArrayList<Question>> category:questions.entrySet()){
            for(Question question:category.getValue()){
                totalQuestions++;
                System.out.println(question.getQuestionText());
                System.out.println((question.checkAnswer())?"Correct":"Incorrect");
                if(question.checkAnswer()){
                    correct++;
                } else {
                    System.out.println("Correct Answer:"+question.getCorrectAnswer());
                }
            }
        }
        System.out.println("Your score for this quiz is: "+ df.format((correct/totalQuestions)*100) + "%");
    }
}
