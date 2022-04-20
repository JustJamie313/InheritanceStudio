package tests.quiz;

import com.company.quiz.question.LinearScale;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestLinearScale {
    @Test
    public void testLinearScaleExtendsQuestion(){
        LinearScale testLinearScale = new LinearScale("Test Question",1,5);
        assertTrue(testLinearScale.getQuestionText().equals("Test Question"));
    }
    @Test
    public void testLinearScaleCreatesUniqueQuestions(){
        LinearScale testLinearScale1 = new LinearScale("Test Question 1",1,5);
        LinearScale testLinearScale2 = new LinearScale("Test Question 2",6,10);
        assertTrue(testLinearScale1.getQuestionText().equals("Test Question 1"));
        assertTrue(testLinearScale1.getMinValue().equals(1));
        assertTrue(testLinearScale2.getQuestionText().equals("Test Question 2"));
        assertTrue(testLinearScale2.getMaxValue().equals(10));
    }
    @Test
    public void testLinearScaleEqualsReturnsCorrectResponse(){
        LinearScale testLinearScale1 = new LinearScale("Test Question 1",1,5);
        LinearScale testLinearScale2 = new LinearScale("Test Question 2",6,10);
        assertTrue(testLinearScale1.equals(testLinearScale1));
        assertFalse(testLinearScale1.equals(testLinearScale2));
    }
    @Test
    public void testLinearScaleToStringReturnsQuestionText(){
        LinearScale testLinearScale = new LinearScale("Test Question 3",1,5);
        assertTrue(testLinearScale.toString().equals("Test Question 3\nEnter an integer between 1 and 5"));
    }
    @Test
    public void testLinearScaleSetsSubmittedAnswer(){
        LinearScale testLinearScale = new LinearScale("Test Question",1,5);
        testLinearScale.setSubmittedAnswer("3");
        assertTrue(testLinearScale.getSubmittedAnswer().equals("3"));
    }
    @Test
    public void testLinearScaleCorrectlyValidatesUserInput(){
        LinearScale testLinearScale = new LinearScale("Test Question",1,5);
        assertFalse(testLinearScale.validateUserInput("a"));
        assertFalse(testLinearScale.validateUserInput("10"));
        assertFalse(testLinearScale.validateUserInput(""));
        assertTrue(testLinearScale.validateUserInput("3"));
    }
    @Test
    public void testLinearScaleCorrectlyComparesSubmittedAnswerToCorrectAnswer(){
        LinearScale testLinearScale = new LinearScale("Test Question",1,5);
        testLinearScale.setSubmittedAnswer("6");
        assertFalse(testLinearScale.checkAnswer());
        testLinearScale.setSubmittedAnswer("5");
        assertTrue(testLinearScale.checkAnswer());
    }
}
