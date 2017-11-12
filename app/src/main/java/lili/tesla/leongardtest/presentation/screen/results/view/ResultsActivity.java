package lili.tesla.leongardtest.presentation.screen.results.view;

import android.os.Bundle;
import butterknife.ButterKnife;
import lili.tesla.leongardtest.R;
import lili.tesla.leongardtest.presentation.screen.base.BaseActivity;
import lili.tesla.leongardtest.presentation.screen.results.presenter.ResultsPresenter;

public class ResultsActivity extends BaseActivity implements ResultsView {

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
