package org.iesfm.escaperoom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleEscapeRoom {

    static Scanner sc = new Scanner(System.in);

    static final Logger log = LoggerFactory.getLogger(Main.class);

    private EscapeRoom escapeRoom;

    public ConsoleEscapeRoom(EscapeRoom escapeRoom) {
        this.escapeRoom = escapeRoom;
    }

    public void run() {
        log.info("Introduce tu nombre");

        String namePlayer = sc.nextLine();

        String welcomeMsg = "Bienvenid@s! si estáis aquí es que estáis majaras!\n" +
                "A continuación tenéis 25 minutos para descubrir al personaje secreto y\n" +
                "salir de este aula infernal...\n" +
                "Tendréis que resolver todas las pistas, encontrar los códigos secretos e\n" +
                "introducirlos en la pantalla para conseguir la siguiente pista y llegar a la\n" +
                "pantalla final...\n" +
                "¿¿¿PREPARAD@S????";

        List<QuestionAnswer> questions = new LinkedList<>();

        QuestionAnswer questionAnswer0 = new QuestionAnswer("¿Cuándo nació nuestra persona escondida?", "1997");
        QuestionAnswer questionAnswer1 = new QuestionAnswer("Esta persona nació en un país que se caracteriza por esto...", "Pico K2");
        QuestionAnswer questionAnswer2 = new QuestionAnswer("Ha destacado como...", "Activista");
        QuestionAnswer questionAnswer3 = new QuestionAnswer("Este objeto la representa", "Velo Islamico");
        QuestionAnswer questionAnswer4 = new QuestionAnswer("Ha conseguido un reconocimiento muy importante...", "Premio nobel");
        QuestionAnswer questionAnswer5 = new QuestionAnswer("¿Ya sabéis quién es?", "Malala Yousafzai");

        questions.add(questionAnswer0);
        questions.add(questionAnswer1);
        questions.add(questionAnswer2);
        questions.add(questionAnswer3);
        questions.add(questionAnswer4);
        questions.add(questionAnswer5);

        EscapeRoom escapeRoom = new EscapeRoom(namePlayer, welcomeMsg, "Enhorabuena!!!", questions, 0);

        escapeRoom.info();


        while (!escapeRoom.isFinished()) {
            for (QuestionAnswer questionAnswer : questions) {
                questionAnswer = escapeRoom.currentQuestion();
                log.info(questionAnswer.getQuestion());
                String answer = sc.nextLine();
                escapeRoom.correctAnswer(answer);
            }
        }

        escapeRoom.congrats();
    }

    public EscapeRoom getEscapeRoom() {
        return escapeRoom;
    }

    public void setEscapeRoom(EscapeRoom escapeRoom) {
        this.escapeRoom = escapeRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleEscapeRoom that = (ConsoleEscapeRoom) o;
        return Objects.equals(escapeRoom, that.escapeRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(escapeRoom);
    }

    @Override
    public String toString() {
        return "ConsoleEscapeRoom{" +
                "escapeRoom=" + escapeRoom +
                '}';
    }
}