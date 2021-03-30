package org.iesfm.escaperoom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        while (!escapeRoom.isFinished()) {
            QuestionAnswer questionAnswer = escapeRoom.currentQuestion();
            log.info(questionAnswer.getQuestion());
            String answer = sc.nextLine();
            escapeRoom.correctAnswer(answer);
        }

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
