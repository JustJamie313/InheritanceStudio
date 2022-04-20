package tests.quiz;

import com.company.quiz.question.CheckBox;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCheckBox {
    @Test
    public void testCheckBoxExtendsQuestion(){
        CheckBox testCheckBox = new CheckBox("Test Question","AC","Answer 1,Answer 2,Answer 3,Answer 4");
        assertTrue(testCheckBox.getQuestionText().equals("Test Question"));
    }
    @Test
    public void testCheckBoxCreatesUniqueQuestions(){
        CheckBox testCheckBox1 = new CheckBox("Test Question 1","BC","Answer 1,Answer 2,Answer 3,Answer 4");
        CheckBox testCheckBox2 = new CheckBox("Test Question 2","AD","Answer 1,Answer 2,Answer 3,Answer 4");
        assertTrue(testCheckBox1.getQuestionText().equals("Test Question 1"));
        assertTrue(testCheckBox1.getCorrectAnswer().equals("BC"));
        assertTrue(testCheckBox2.getQuestionText().equals("Test Question 2"));
        assertTrue(testCheckBox2.getCorrectAnswer().equals("AD"));
    }
    @Test
    public void testCheckBoxEqualsReturnsCorrectResponse(){
        CheckBox testCheckBox1 = new CheckBox("Test Question 1","CD","Answer 1,Answer 2,Answer 3,Answer 4");
        CheckBox testCheckBox2 = new CheckBox("Test Question 2","AB","Answer 1,Answer 2,Answer 3,Answer 4");
        assertTrue(testCheckBox1.equals(testCheckBox1));
        assertFalse(testCheckBox1.equals(testCheckBox2));
    }
    @Test
    public void testCheckBoxToStringReturnsQuestionText(){
        CheckBox testCheckBox = new CheckBox("Test Question 3","BD","Answer 1,Answer 2,Answer 3,Answer 4");
        assertTrue(testCheckBox.toString().equals("Test Question 3\n\tA: Answer 1\n\tB: Answer 2\n\tC: Answer 3\n\tD: Answer 4\n"));
    }
    @Test
    public void testCheckBoxSetsSubmittedAnswer(){
        CheckBox testCheckBox = new CheckBox("Test Question","AC","Answer 1,Answer 2,Answer 3,Answer 4");
        testCheckBox.setSubmittedAnswer("AC");
        assertTrue(testCheckBox.getSubmittedAnswer().equals("AC"));
    }
    @Test
    public void testCheckBoxCorrectlyValidatesUserInput(){
        CheckBox testCheckBox = new CheckBox("Test Question","CD","Answer 1,Answer 2,Answer 3,Answer 4");
        assertFalse(testCheckBox.validateUserInput("ce"));
        assertFalse(testCheckBox.validateUserInput("10"));
        assertFalse(testCheckBox.validateUserInput(""));
        assertTrue(testCheckBox.validateUserInput("ac"));
    }
    @Test
    public void testCheckBoxCorrectlyComparesSubmittedAnswerToCorrectAnswer(){
        CheckBox testCheckBox = new CheckBox("Test Question","AD","Answer 1,Answer 2,Answer 3,Answer 4");
        testCheckBox.setSubmittedAnswer("BD");
        assertFalse(testCheckBox.checkAnswer());
        testCheckBox.setSubmittedAnswer("ABD");
        assertFalse(testCheckBox.checkAnswer());
        testCheckBox.setSubmittedAnswer("AD");
        assertTrue(testCheckBox.checkAnswer());
        testCheckBox.setSubmittedAnswer("DA");
        assertTrue(testCheckBox.checkAnswer());
    }
}
