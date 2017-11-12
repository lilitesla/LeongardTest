package lili.tesla.leongardtest.presentation.screen.questions.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import lili.tesla.leongardtest.R;
import lili.tesla.leongardtest.presentation.screen.base.BaseActivity;
import lili.tesla.leongardtest.presentation.screen.questions.presenter.QuestionsPresenter;
import lili.tesla.leongardtest.presentation.screen.results.view.ResultsActivity;

public class QuestionsActivity extends BaseActivity implements QuestionsView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, QuestionsActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private QuestionsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        ButterKnife.bind(this);
        mPresenter = new QuestionsPresenter();
        mPresenter.setView(this);

    }

    @Override
    public void startResultsScreen() {
        ResultsActivity.start(this);
        finish();
    }
}
