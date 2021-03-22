package org.iesfm.escaperoom;

import java.util.List;
import java.util.Objects;

public class EscapeRoom {
    private String playerName;
    private String welcomeMsg;
    private List<QuestionAnswer> questionAnswerList;
    private int questionCounter;


    //Constructor

    public EscapeRoom(String playerName, String welcomeMsg, List<QuestionAnswer> questionAnswerList, int questionCounter) {
        this.playerName = playerName;
        this.welcomeMsg = welcomeMsg;
        this.questionAnswerList = questionAnswerList;
        this.questionCounter = questionCounter;
    }


    //----------------Methods-----------------//

    public QuestionAnswer currentQuestion(List<QuestionAnswer> questions, int index) {
        if (questions.isEmpty()) {
            return null;
        }
        return questions.get(index);

    }


    //--------------------GETTERS--SETTERS----HASHCODE------EQUALS---------------------//


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

    public List<QuestionAnswer> getQuestionAnswerList() {
        return questionAnswerList;
    }

    public void setQuestionAnswerList(List<QuestionAnswer> questionAnswerList) {
        this.questionAnswerList = questionAnswerList;
    }

    public int getQuestionCounter() {
        return questionCounter;
    }

    public void setQuestionCounter(int questionCounter) {
        this.questionCounter = questionCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EscapeRoom that = (EscapeRoom) o;
        return questionCounter == that.questionCounter && Objects.equals(playerName, that.playerName) && Objects.equals(welcomeMsg, that.welcomeMsg) && Objects.equals(questionAnswerList, that.questionAnswerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, welcomeMsg, questionAnswerList, questionCounter);
    }

    @Override
    public String toString() {
        return "EscapeRoom{" +
                "playerName='" + playerName + '\'' +
                ", welcomeMsg='" + welcomeMsg + '\'' +
                ", questionAnswerList=" + questionAnswerList +
                ", questionCounter=" + questionCounter +
                '}';
    }
}
