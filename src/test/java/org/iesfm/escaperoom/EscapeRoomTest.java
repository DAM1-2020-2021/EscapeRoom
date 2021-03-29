package org.iesfm.escaperoom;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class EscapeRoomTest {


    @Test
    public void currentQuestionTest() {

        List<QuestionAnswer> questions = new LinkedList<>();
        QuestionAnswer question0 = new QuestionAnswer("Cual era el nombre del caballo de Don Quijote?", "Rocinante");
        QuestionAnswer question1 = new QuestionAnswer("Que tipo de animal es una araña?", "Aracnido");
        QuestionAnswer question2 = new QuestionAnswer("Cual es el nombre de nuestra estrella?", null);
        QuestionAnswer question3 = new QuestionAnswer("Que va despues del cuatro?", null);
        QuestionAnswer question4 = new QuestionAnswer("Que representa la marca Apple?", null);


        questions.add(0, question0);
        questions.add(1, question1);
        questions.add(2, question2);
        questions.add(3, question3);
        questions.add(4, question4);

        int questionIndex = 2;

        EscapeRoom escapeRoom = new EscapeRoom("Ramiro", "Bienvenido Ramiro", "Enhorabuena!!!", questions, questionIndex);

        QuestionAnswer indexQuestion = escapeRoom.currentQuestion();

        QuestionAnswer nextQuestion = new QuestionAnswer("Cual es el nombre de nuestra estrella?", null);

        Assert.assertEquals(nextQuestion, indexQuestion);

    }

    @Test
    public void isFinishedTest() {

        List<QuestionAnswer> questions = new LinkedList<>();
        QuestionAnswer question0 = new QuestionAnswer("Cual era el nombre del caballo de Don Quijote?", "Rocinante");
        QuestionAnswer question1 = new QuestionAnswer("Que tipo de animal es una araña?", "Aracnido");
        QuestionAnswer question2 = new QuestionAnswer("Cual es el nombre de nuestra estrella?", "Sol");
        QuestionAnswer question3 = new QuestionAnswer("Que va despues del cuatro?", "cinco");
        QuestionAnswer question4 = new QuestionAnswer("Que representa la marca Apple?", "manzana");


        questions.add(0, question0);
        questions.add(1, question1);
        questions.add(2, question2);
        questions.add(3, question3);
        questions.add(4, question4);

        int currentQuestion = 4;

        EscapeRoom escapeRoom = new EscapeRoom("Ramiro", "Bienvenido Ramiro", "Enhorabuena!!!", questions, currentQuestion);

        boolean res = escapeRoom.isFinished();

        Assert.assertTrue(res);
    }

    @Test
    public void isNotFinishedTest() {

        List<QuestionAnswer> questions = new LinkedList<>();
        QuestionAnswer question0 = new QuestionAnswer("Cual era el nombre del caballo de Don Quijote?", "Rocinante");
        QuestionAnswer question1 = new QuestionAnswer("Que tipo de animal es una araña?", "Aracnido");
        QuestionAnswer question2 = new QuestionAnswer("Cual es el nombre de nuestra estrella?", "Sol");
        QuestionAnswer question3 = new QuestionAnswer("Que va despues del cuatro?", "cinco");
        QuestionAnswer question4 = new QuestionAnswer("Que representa la marca Apple?", "manzana");


        questions.add(0, question0);
        questions.add(1, question1);
        questions.add(2, question2);
        questions.add(3, question3);
        questions.add(4, question4);

        int currentQuestion = 3;

        EscapeRoom escapeRoom = new EscapeRoom("Ramiro", "Bienvenido Ramiro", "Enhorabuena!!!", questions, currentQuestion);

        boolean res = escapeRoom.isFinished();

        Assert.assertFalse(res);
    }

    @Test
    public void correctQuestionTest() {

        List<QuestionAnswer> questions = new LinkedList<>();
        QuestionAnswer question0 = new QuestionAnswer("Cual era el nombre del caballo de Don Quijote?", "Rocinante");
        QuestionAnswer question1 = new QuestionAnswer("Que tipo de animal es una araña?", "Aracnido");
        QuestionAnswer question2 = new QuestionAnswer("Cual es el nombre de nuestra estrella?", "Sol");
        QuestionAnswer question3 = new QuestionAnswer("Que va despues del cuatro?", "cinco");
        QuestionAnswer question4 = new QuestionAnswer("Que representa la marca Apple?", "manzana");

        questions.add(0, question0);
        questions.add(1, question1);
        questions.add(2, question2);
        questions.add(3, question3);
        questions.add(4, question4);

        int currentQuestion = 2;

        EscapeRoom escapeRoom = new EscapeRoom("Ramiro", "Bienvenido Ramiro", "Enhorabuena!!!", questions, currentQuestion);

        boolean res = escapeRoom.correctAnswer("Sol");

        Assert.assertTrue(res);
    }

    @Test
    public void incorrectQuestionTest() {

        List<QuestionAnswer> questions = new LinkedList<>();
        QuestionAnswer question0 = new QuestionAnswer("Cual era el nombre del caballo de Don Quijote?", "Rocinante");
        QuestionAnswer question1 = new QuestionAnswer("Que tipo de animal es una araña?", "Aracnido");
        QuestionAnswer question2 = new QuestionAnswer("Cual es el nombre de nuestra estrella?", "Sol");
        QuestionAnswer question3 = new QuestionAnswer("Que va despues del cuatro?", "cinco");
        QuestionAnswer question4 = new QuestionAnswer("Que representa la marca Apple?", "manzana");

        questions.add(0, question0);
        questions.add(1, question1);
        questions.add(2, question2);
        questions.add(3, question3);
        questions.add(4, question4);

        int currentQuestion = 0;

        EscapeRoom escapeRoom = new EscapeRoom("Ramiro", "Bienvenido Ramiro", "Enhorabuena!!!", questions, currentQuestion);

        boolean res = escapeRoom.correctAnswer("Pedro");

        Assert.assertFalse(res);
    }

}
