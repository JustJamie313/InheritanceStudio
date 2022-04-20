package tests.quiz;

import com.company.quiz.question.TrueFalse;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestTrueFalse {

    @Test
    public void testTrueFalseExtendsQuestion(){
        TrueFalse testTrueFalse = new TrueFalse("Test Question","true");
        assertTrue(testTrueFalse.getQuestionText().equals("Test Question"));
    }
    @Test
    public void testTrueFalseCreatesUniqueQuestions(){
        TrueFalse testTrueFalse1 = new TrueFalse("Test Question 1","true");
        TrueFalse testTrueFalse2 = new TrueFalse("Test Question 2","false");
        assertTrue(testTrueFalse1.getQuestionText().equals("Test Question 1"));
        assertTrue(testTrueFalse1.getCorrectAnswer().equals("true"));
        assertTrue(testTrueFalse2.getQuestionText().equals("Test Question 2"));
        assertTrue(testTrueFalse2.getCorrectAnswer().equals("false"));
    }
    @Test
    public void testTrueFalseEqualsReturnsCorrectResponse(){
        TrueFalse testTrueFalse1 = new TrueFalse("Test Question 1","true");
        TrueFalse testTrueFalse2 = new TrueFalse("Test Question 2","false");
        assertTrue(testTrueFalse1.equals(testTrueFalse1));
        assertFalse(testTrueFalse1.equals(testTrueFalse2));
    }
    @Test
    public void testTrueFalseToStringReturnsQuestionText(){
        TrueFalse testTrueFalse = new TrueFalse("Test Question 3","false");
        assertTrue(testTrueFalse.toString().equals("Test Question 3"));
    }
    @Test
    public void testTrueFalseGetCorrectAnswerReturnsCorrectAnswer(){
        TrueFalse testTrueFalse1 = new TrueFalse("Test Question 1","true");
        TrueFalse testTrueFalse2 = new TrueFalse("Test Question 2","false");
        assertTrue(testTrueFalse1.getCorrectAnswer().equals("true"));
        assertTrue(testTrueFalse2.getCorrectAnswer().equals("false"));
    }
    @Test
    public void testTrueFalseSetsSubmittedAnswer(){
        TrueFalse testTrueFalse = new TrueFalse("Test Question","true");
        testTrueFalse.setSubmittedAnswer("true");
        assertTrue(testTrueFalse.getSubmittedAnswer().equals("true"));
    }
    @Test
    public void testTrueFalseCorrectlyValidatesUserInput(){
        TrueFalse testTrueFalse = new TrueFalse("Test Question","true");
        assertFalse(testTrueFalse.validateUserInput("a"));
        assertFalse(testTrueFalse.validateUserInput("1"));
        assertFalse(testTrueFalse.validateUserInput(""));
        assertTrue(testTrueFalse.validateUserInput("true"));
        assertTrue(testTrueFalse.validateUserInput("false"));
    }
    @Test
    public void testTrueFalseCorrectlyComparesSubmittedAnswerToCorrectAnswer(){
        TrueFalse testTrueFalse = new TrueFalse("Test Question","true");
        testTrueFalse.setSubmittedAnswer("false");
        assertFalse(testTrueFalse.checkAnswer());
        testTrueFalse.setSubmittedAnswer("true");
        assertTrue(testTrueFalse.checkAnswer());
    }
}
