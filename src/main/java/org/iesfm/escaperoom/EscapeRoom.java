package org.iesfm.escaperoom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class EscapeRoom {

    private static final Logger log = LoggerFactory.getLogger(EscapeRoom.class);

    private String playerName;
    private String welcomeMsg;
    private List<QuestionAnswer> questionAnswerList;
    private int currentQuestion;


    //Constructor

    public EscapeRoom(String playerName, String welcomeMsg, List<QuestionAnswer> questionAnswerList, int questionCounter) {
        this.playerName = playerName;
        this.welcomeMsg = welcomeMsg;
        this.questionAnswerList = questionAnswerList;
        this.currentQuestion = questionCounter;
    }


    //----------------Methods-----------------//

    public QuestionAnswer currentQuestion() {
        return questionAnswerList.get(currentQuestion);

    }

    public void info(){
        log.info("Bienvenido " + playerName);
        log.info(welcomeMsg);
    }

    // MODELO 1

    public boolean correctAnswer(String answer) {
        boolean found = false;
        for (QuestionAnswer questionAnswer : questionAnswerList) {
            questionAnswer = currentQuestion();
            if (questionAnswer.checkQuestion(answer)) {
                currentQuestion++;
                found = true;
            }
        }
        return found;
    }


//      MODELO 2
//         public QuestionAnswer correctAnswer(String answer){
//            QuestionAnswer questionAnswer = currentQuestion();
//            if (questionAnswer.checkQuestion(answer)){
//                currentQuestion++;
//            }
//            return questionAnswer;
//        }

    public boolean isFinished() {
        boolean finished = false;
        if (currentQuestion == questionAnswerList.size() - 1) {
            finished = true;
        }
        return finished;
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
        return currentQuestion == that.currentQuestion && Objects.equals(playerName, that.playerName) && Objects.equals(welcomeMsg, that.welcomeMsg) && Objects.equals(questionAnswerList, that.questionAnswerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, welcomeMsg, questionAnswerList, currentQuestion);
    }

    @Override
    public String toString() {
        return "EscapeRoom{" +
                "playerName='" + playerName + '\'' +
                ", welcomeMsg='" + welcomeMsg + '\'' +
                ", questionAnswerList=" + questionAnswerList +
                ", questionCounter=" + currentQuestion +
                '}';
    }
}
