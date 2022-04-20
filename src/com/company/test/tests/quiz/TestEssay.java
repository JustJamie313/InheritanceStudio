package tests.quiz;

import com.company.quiz.question.Essay;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestEssay {

    @Test
    public void testEssayExtendsQuestion(){
        Essay testEssay = new Essay("Test Essay");
        assertTrue(testEssay.getQuestionText().equals("Test Essay"));
    }
    @Test
    public void testEssayCreatesUniqueQuestions(){
        Essay testEssay1 = new Essay("Test Essay 1");
        Essay testEssay2 = new Essay("Test Essay 2");
        assertTrue(testEssay1.getQuestionText().equals("Test Essay 1"));
        assertTrue(testEssay2.getQuestionText().equals("Test Essay 2"));
    }
    @Test
    public void testEssayEqualsReturnsCorrectResponse(){
        Essay testEssay1 = new Essay("Test Essay 1");
        Essay testEssay2 = new Essay("Test Essay 2");
        assertTrue(testEssay1.equals(testEssay1));
        assertFalse(testEssay1.equals(testEssay2));
    }
    @Test
    public void testEssayToStringReturnsQuestionText(){
        Essay testEssay = new Essay("Test Essay 3");
        assertTrue(testEssay.toString().equals("Test Essay 3"));
    }
    @Test
    public void testEssaySetsSubmittedAnswer(){
        Essay testEssay = new Essay("Test Essay");
        testEssay.setSubmittedAnswer("answer");
        assertTrue(testEssay.getSubmittedAnswer().equals("answer"));
    }
    @Test
    public void testEssayCorrectlyValidatesUserInput(){
        Essay testEssay = new Essay("Test Essay");
        assertFalse(testEssay.validateUserInput("aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaaaaaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaaaaaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaaaaaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaaaaaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaaaa"));
        assertTrue(testEssay.validateUserInput("aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaaaaaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaaaaaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaaaaaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaaaaaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaaa"));
    }
}
