package org.iesfm.escaperoom;

import org.junit.Assert;
import org.junit.Test;

public class QuestionAnswerTest {

    @Test
    public void correctAnswerTest(){

        QuestionAnswer questionAnswer = new QuestionAnswer("¿Cuantas patas tiene un perro?", "4");

        boolean res = questionAnswer.checkQuestion("4");

        Assert.assertTrue(res);

    }
    @Test
    public void incorrectAnswerTest(){

        QuestionAnswer questionAnswer = new QuestionAnswer("¿Cuantas patas tiene un perro?", "4");

        boolean res = questionAnswer.checkQuestion("5");

        Assert.assertFalse(res);

    }

    @Test
    public void correctAnswerIgnoreCaseTest(){

        QuestionAnswer questionAnswer = new QuestionAnswer("¿Cuantas patas tiene un perro?", "CUATRO");

        boolean res = questionAnswer.checkQuestion("cuatro");

        Assert.assertTrue(res);

    }




}
