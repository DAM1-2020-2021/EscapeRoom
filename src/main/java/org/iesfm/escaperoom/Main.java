package org.iesfm.escaperoom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


        log.info("Introduce tu nombre");

        String namePlayer = sc.nextLine();

        String welcomeMsg = "Bienvenid@! "+ namePlayer + ", si estás aquí es que estás majara!\n" +
                "A continuación tienes 25 minutos para descubrir al personaje secreto y\n" +
                "salir de este aula infernal...\n" +
                "Tendrás que resolver todas las pistas, encontrar los códigos secretos e\n" +
                "introducirlos en la pantalla para conseguir la siguiente pista y llegar a la\n" +
                "pantalla final...\n" +
                "¿¿¿PREPARAD@????";

        List<QuestionAnswer> questions = new LinkedList<>();

        QuestionAnswer questionAnswer0 = new QuestionAnswer("¿Cuándo nació nuestra persona escondida?", "1997");
        QuestionAnswer questionAnswer1 = new QuestionAnswer("Esta persona nació en un país que se caracteriza por esto...", "Pico K2");
        QuestionAnswer questionAnswer2 = new QuestionAnswer("Ha destacado como...", "Activista");
        QuestionAnswer questionAnswer3 = new QuestionAnswer("Este objeto la representa", "Velo Islamico");
        QuestionAnswer questionAnswer4 = new QuestionAnswer("Ha conseguido un reconocimiento muy importante...", "Premio nobel");
        QuestionAnswer questionAnswer5 = new QuestionAnswer("¿Ya sabes quién es?", "Malala Yousafzai");


        questions.add(questionAnswer0);
        questions.add(questionAnswer1);
        questions.add(questionAnswer2);
        questions.add(questionAnswer3);
        questions.add(questionAnswer4);
        questions.add(questionAnswer5);


        EscapeRoom escapeRoom = new EscapeRoom(namePlayer, welcomeMsg, "Enhorabuena " + namePlayer + "!!" + ". Pero la próxima vez, no seré tan benévolo...MWAHAHAHA", questions, 0);

        escapeRoom.info();

        ConsoleEscapeRoom consoleEscapeRoom = new ConsoleEscapeRoom(escapeRoom);

        consoleEscapeRoom.run();

        escapeRoom.congrats();
    }
}