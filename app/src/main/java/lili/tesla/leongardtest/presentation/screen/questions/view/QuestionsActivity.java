package lili.tesla.leongardtest.presentation.screen.questions.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import lili.tesla.leongardtest.R;
import lili.tesla.leongardtest.presentation.screen.base.BaseActivity;
import lili.tesla.leongardtest.presentation.screen.questions.presenter.QuestionsPresenter;

public class QuestionsActivity extends BaseActivity implements QuestionsView {

    private QuestionsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        ButterKnife.bind(this);
        mPresenter = new QuestionsPresenter();
        mPresenter.setView(this);

    }
}
