package org.iesfm.escaperoom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class EscapeRoom {

    private static final Logger log = LoggerFactory.getLogger(EscapeRoom.class);

    private String playerName;
    private String welcomeMsg;
    private String congratulationsMsg;
    private List<QuestionAnswer> questionAnswerList;
    private int currentQuestion;


    //Constructor

    public EscapeRoom(String playerName, String welcomeMsg, String congratulationsMsg, List<QuestionAnswer> questionAnswerList, int currentQuestion) {
        this.playerName = playerName;
        this.welcomeMsg = welcomeMsg;
        this.congratulationsMsg = congratulationsMsg;
        this.questionAnswerList = questionAnswerList;
        this.currentQuestion = currentQuestion;
    }


    //----------------Methods-----------------//

    public QuestionAnswer currentQuestion() {
        return questionAnswerList.get(currentQuestion);

    }

    public void info() {
//        log.info("Bienvenido " + playerName);
        log.info(welcomeMsg);
    }

    public void congrats() {
        log.info(congratulationsMsg);
    }


    public boolean correctAnswer(String answer) {
        boolean found = false;
        QuestionAnswer questionAnswer = currentQuestion();
            if (questionAnswer.checkQuestion(answer) && currentQuestion <= questionAnswerList.size() - 1) {
                currentQuestion++;
                found = true;
            }

        return found;
    }


    public boolean isFinished() {
        boolean finished = false;
        if (currentQuestion == questionAnswerList.size()) {
            finished = true;
        }
        return finished;
    }


    //--------------------GETTERS--SETTERS----HASHCODE------EQUALS---------------------//


    public static Logger getLog() {
        return log;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    public String getCongratulationsMsg() {
        return congratulationsMsg;
    }

    public void setCongratulationsMsg(String congratulationsMsg) {
        this.congratulationsMsg = congratulationsMsg;
    }

    public List<QuestionAnswer> getQuestionAnswerList() {
        return questionAnswerList;
    }

    public void setQuestionAnswerList(List<QuestionAnswer> questionAnswerList) {
        this.questionAnswerList = questionAnswerList;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EscapeRoom that = (EscapeRoom) o;
        return currentQuestion == that.currentQuestion && Objects.equals(playerName, that.playerName) && Objects.equals(welcomeMsg, that.welcomeMsg) && Objects.equals(congratulationsMsg, that.congratulationsMsg) && Objects.equals(questionAnswerList, that.questionAnswerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, welcomeMsg, congratulationsMsg, questionAnswerList, currentQuestion);
    }

    @Override
    public String toString() {
        return "EscapeRoom{" +
                "playerName='" + playerName + '\'' +
                ", welcomeMsg='" + welcomeMsg + '\'' +
                ", congratulationsMsg='" + congratulationsMsg + '\'' +
                ", questionAnswerList=" + questionAnswerList +
                ", currentQuestion=" + currentQuestion +
                '}';
    }
}
