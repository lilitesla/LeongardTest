package lili.tesla.leongardtest.presentation.screen.questions.presenter;

import lili.tesla.leongardtest.presentation.application.App;
import lili.tesla.leongardtest.presentation.screen.base.BasePresenter;
import lili.tesla.leongardtest.presentation.screen.questions.view.QuestionsView;

/**
 * Created by Лилия on 12.11.2017.
 */

public class QuestionsPresenter extends BasePresenter<QuestionsView> {

    private int questionNum = -1;
    private boolean isButtonResultsVisible = false;

    public void startResultsScreen() {
        mView.startResultsScreen();
    }

    public void changeQuestion() {
        questionNum ++;

        if (questionNum < 88) {

            if (isButtonResultsVisible) {
                isButtonResultsVisible = false;
                mView.makeQuestionsVisible();
            }

            String sNum = "Вопрос: " + App.questions.get(questionNum).getNum() + " из 88";
            String sQuestion = App.questions.get(questionNum).getQuestion();

            mView.changeQuestion(sNum, sQuestion);
        } else {
            isButtonResultsVisible = true;
            mView.makeButtonResultVisible();
        }
    }

    public void setYesAnswer() {
        App.questions.get(questionNum).setAnswer(true);
        changeQuestion();
    }

    public void setNoAnswer() {
        App.questions.get(questionNum).setAnswer(false);
        changeQuestion();
    }

    public void setBack() {
        questionNum = questionNum - 2;
        changeQuestion();
    }



}
