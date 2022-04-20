package tests.quiz;

import com.company.quiz.question.ShortAnswer;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestShortAnswer {

    @Test
    public void testShortAnswerExtendsQuestion(){
        ShortAnswer testShortAnswer = new ShortAnswer("Test Short Answer","answer");
        assertTrue(testShortAnswer.getQuestionText().equals("Test Short Answer"));
    }
    @Test
    public void testShortAnswerCreatesUniqueQuestions(){
        ShortAnswer testShortAnswer1 = new ShortAnswer("Test Short Answer 1","answer1");
        ShortAnswer testShortAnswer2 = new ShortAnswer("Test Short Answer 2","answer2");
        assertTrue(testShortAnswer1.getQuestionText().equals("Test Short Answer 1"));
        assertTrue(testShortAnswer1.getCorrectAnswer().equals("answer1"));
        assertTrue(testShortAnswer2.getQuestionText().equals("Test Short Answer 2"));
        assertTrue(testShortAnswer2.getCorrectAnswer().equals("answer2"));
    }
    @Test
    public void testShortAnswerEqualsReturnsCorrectResponse(){
        ShortAnswer testShortAnswer1 = new ShortAnswer("Test Short Answer 1","answer1");
        ShortAnswer testShortAnswer2 = new ShortAnswer("Test Short Answer 2","answer2");
        assertTrue(testShortAnswer1.equals(testShortAnswer1));
        assertFalse(testShortAnswer1.equals(testShortAnswer2));
    }
    @Test
    public void testShortAnswerToStringReturnsQuestionText(){
        ShortAnswer testShortAnswer = new ShortAnswer("Test Short Answer 3","answer");
        assertTrue(testShortAnswer.toString().equals("Test Short Answer 3"));
    }
    @Test
    public void testShortAnswerGetCorrectAnswerReturnsCorrectAnswer(){
        ShortAnswer testShortAnswer1 = new ShortAnswer("Test Short Answer 1","answer1");
        ShortAnswer testShortAnswer2 = new ShortAnswer("Test Short Answer 2","answer2");
        assertTrue(testShortAnswer1.getCorrectAnswer().equals("answer1"));
        assertTrue(testShortAnswer2.getCorrectAnswer().equals("answer2"));
    }
    @Test
    public void testShortAnswerSetsSubmittedAnswer(){
        ShortAnswer testShortAnswer = new ShortAnswer("Test Short Answer","answer");
        testShortAnswer.setSubmittedAnswer("answer");
        assertTrue(testShortAnswer.getSubmittedAnswer().equals("answer"));
    }
    @Test
    public void testShortAnswerCorrectlyValidatesUserInput(){
        ShortAnswer testShortAnswer = new ShortAnswer("Test Short Answer","answer");
        assertFalse(testShortAnswer.validateUserInput("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertTrue(testShortAnswer.validateUserInput("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
    @Test
    public void testShortAnswerCorrectlyComparesSubmittedAnswerToCorrectAnswer(){
        ShortAnswer testShortAnswer = new ShortAnswer("Test Short Answer","right answer");
        testShortAnswer.setSubmittedAnswer("wrong answer");
        assertFalse(testShortAnswer.checkAnswer());
        testShortAnswer.setSubmittedAnswer("right answer");
        assertTrue(testShortAnswer.checkAnswer());
    }
}
