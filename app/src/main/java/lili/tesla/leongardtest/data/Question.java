package lili.tesla.leongardtest.data;

/**
 * Created by Лилия on 12.11.2017.
 */

public class Question {

    private String question;
    private int num;
    private boolean answer;

    public Question(int iNum, String sQuestion) {
        num = iNum;
        question = sQuestion;
        answer = false;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
