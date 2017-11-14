package lili.tesla.leongardtest.presentation.screen.questions.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.leongardtest.R;
import lili.tesla.leongardtest.presentation.application.App;
import lili.tesla.leongardtest.presentation.screen.base.BaseActivity;
import lili.tesla.leongardtest.presentation.screen.questions.presenter.QuestionsPresenter;
import lili.tesla.leongardtest.presentation.screen.results.view.ResultsActivity;

public class QuestionsActivity extends BaseActivity implements QuestionsView {

    public static final String KEY_QUESTION_NUM = "QUESTION_NUM";
    public static final String KEY_IS_BUTTON_RESULT_VISIBLE = "IS_BUTTON_RESULT_VISIBLE";

    public static void start(Context context ) {
        Intent intent = new Intent(context, QuestionsActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private QuestionsPresenter mPresenter;

    @BindView(R.id.button_yes) Button mButtonYes;
    @BindView(R.id.button_no) Button mButtonNo;
    @BindView(R.id.button_back) Button mButtonBack;
    @BindView(R.id.button_go_to_result) Button mButtonGoToResult;
    @BindView(R.id.textview_question) TextView mTextviewQuestion;
    @BindView(R.id.textview_question_num) TextView mTextviewQuestionNum;
    @BindView(R.id.ll_answers) LinearLayout mLinearlayoutAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        ButterKnife.bind(this);
        mPresenter = new QuestionsPresenter();
        mPresenter.setView(this);

        if (savedInstanceState != null) {
            mPresenter.questionNum = savedInstanceState.getInt(KEY_QUESTION_NUM, 0);
            mPresenter.isButtonResultsVisible = savedInstanceState.getBoolean(KEY_IS_BUTTON_RESULT_VISIBLE, false);
        }

        mPresenter.questionNum --;
        mPresenter.changeQuestion();
    }

    @Override
    public void changeQuestion(String sNum, String sQuestion) {
        mTextviewQuestionNum.setText(sNum);
        mTextviewQuestion.setText(sQuestion);
    }

    @Override
    public void makeButtonResultVisible() {

        mTextviewQuestionNum.setVisibility(View.GONE);
        mTextviewQuestion.setVisibility(View.GONE);
        mLinearlayoutAnswers.setVisibility(View.GONE);

        mButtonGoToResult.setVisibility(View.VISIBLE);
    }

    @Override
    public void makeQuestionsVisible() {

        mTextviewQuestionNum.setVisibility(View.VISIBLE);
        mTextviewQuestion.setVisibility(View.VISIBLE);
        mLinearlayoutAnswers.setVisibility(View.VISIBLE);

        mButtonGoToResult.setVisibility(View.GONE);

    }

    @Override
    public void startResultsScreen() {
        ResultsActivity.start(this);
        finish();
    }

    @OnClick(R.id.button_go_to_result)
    void goToResultClicked() {
        mPresenter.startResultsScreen();
    }

    @OnClick(R.id.button_yes)
    void yesClicked() {
        mPresenter.setYesAnswer();
    }

    @OnClick(R.id.button_no)
    void noClicked() {
        mPresenter.setNoAnswer();
    }

    @OnClick(R.id.button_back)
    void backClicked() { mPresenter.setBack(); }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_QUESTION_NUM, mPresenter.questionNum);
        outState.putBoolean(KEY_IS_BUTTON_RESULT_VISIBLE, mPresenter.isButtonResultsVisible);
    }
}
