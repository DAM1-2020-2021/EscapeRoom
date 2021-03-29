package org.iesfm.escaperoom;

import java.util.Objects;


public class QuestionAnswer {

    private String question;
    private String answer;

    //Constructor

    public QuestionAnswer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    //----------------Methods-----------------//

    public boolean checkQuestion(String answer) {
        boolean found = false;
        if (getAnswer().equalsIgnoreCase(answer)) {
            found = true;
        }

        return found;
    }

    public int[] numLettersPerWordInAnswer(String answer) {
        
        String[] answerSize = answer.split(" ");
        int[] numberWord = new int[answerSize.length];
        for (int i = 0; i < numberWord.length; i++) {
            numberWord[i] = answerSize[i].length();
        }
        return numberWord;
    }


    //--------------------GETTERS--SETTERS----HASHCODE------EQUALS---------------------//

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionAnswer that = (QuestionAnswer) o;
        return Objects.equals(question, that.question) && Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "QuestionAnswer{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
