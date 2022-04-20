package tests.quiz;

import com.company.quiz.question.MultipleChoice;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestMultipleChoice {
    @Test
    public void testMultipleChoiceExtendsQuestion(){
        MultipleChoice testMultipleChoice = new MultipleChoice("Test Question","C","Answer 1,Answer 2,Answer 3,Answer 4");
        assertTrue(testMultipleChoice.getQuestionText().equals("Test Question"));
    }
    @Test
    public void testMultipleChoiceCreatesUniqueQuestions(){
        MultipleChoice testMultipleChoice1 = new MultipleChoice("Test Question 1","B","Answer 1,Answer 2,Answer 3,Answer 4");
        MultipleChoice testMultipleChoice2 = new MultipleChoice("Test Question 2","A","Answer 1,Answer 2,Answer 3,Answer 4");
        assertTrue(testMultipleChoice1.getQuestionText().equals("Test Question 1"));
        assertTrue(testMultipleChoice1.getCorrectAnswer().equals("B"));
        assertTrue(testMultipleChoice2.getQuestionText().equals("Test Question 2"));
        assertTrue(testMultipleChoice2.getCorrectAnswer().equals("A"));
    }
    @Test
    public void testMultipleChoiceEqualsReturnsCorrectResponse(){
        MultipleChoice testMultipleChoice1 = new MultipleChoice("Test Question 1","D","Answer 1,Answer 2,Answer 3,Answer 4");
        MultipleChoice testMultipleChoice2 = new MultipleChoice("Test Question 2","A","Answer 1,Answer 2,Answer 3,Answer 4");
        assertTrue(testMultipleChoice1.equals(testMultipleChoice1));
        assertFalse(testMultipleChoice1.equals(testMultipleChoice2));
    }
    @Test
    public void testMultipleChoiceToStringReturnsQuestionText(){
        MultipleChoice testMultipleChoice = new MultipleChoice("Test Question 3","B","Answer 1,Answer 2,Answer 3,Answer 4");
        assertTrue(testMultipleChoice.toString().equals("Test Question 3\n\tA: Answer 1\n\tB: Answer 2\n\tC: Answer 3\n\tD: Answer 4\n"));
    }
    @Test
    public void testMultipleChoiceSetsSubmittedAnswer(){
        MultipleChoice testMultipleChoice = new MultipleChoice("Test Question","C","Answer 1,Answer 2,Answer 3,Answer 4");
        testMultipleChoice.setSubmittedAnswer("C");
        assertTrue(testMultipleChoice.getSubmittedAnswer().equals("C"));
    }
    @Test
    public void testMultipleChoiceCorrectlyValidatesUserInput(){
        MultipleChoice testMultipleChoice = new MultipleChoice("Test Question","D","Answer 1,Answer 2,Answer 3,Answer 4");
        assertFalse(testMultipleChoice.validateUserInput("e"));
        assertFalse(testMultipleChoice.validateUserInput("10"));
        assertFalse(testMultipleChoice.validateUserInput(""));
        assertTrue(testMultipleChoice.validateUserInput("c"));
    }
    @Test
    public void testMultipleChoiceCorrectlyComparesSubmittedAnswerToCorrectAnswer(){
        MultipleChoice testMultipleChoice = new MultipleChoice("Test Question","A","Answer 1,Answer 2,Answer 3,Answer 4");
        testMultipleChoice.setSubmittedAnswer("B");
        assertFalse(testMultipleChoice.checkAnswer());
        testMultipleChoice.setSubmittedAnswer("A");
        assertTrue(testMultipleChoice.checkAnswer());
    }
}
