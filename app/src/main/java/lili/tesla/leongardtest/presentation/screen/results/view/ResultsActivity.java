package lili.tesla.leongardtest.presentation.screen.results.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import butterknife.ButterKnife;
import lili.tesla.leongardtest.R;
import lili.tesla.leongardtest.presentation.screen.base.BaseActivity;
import lili.tesla.leongardtest.presentation.screen.results.presenter.ResultsPresenter;

public class ResultsActivity extends BaseActivity implements ResultsView {

    public static void start(Context context ) {
        Intent intent = new Intent(context, ResultsActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private ResultsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ButterKnife.bind(this);
        mPresenter = new ResultsPresenter();
        mPresenter.setView(this);

    }
}
