package lili.tesla.leongardtest.presentation.screen.description.view;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.leongardtest.R;
import lili.tesla.leongardtest.presentation.screen.base.BaseActivity;
import lili.tesla.leongardtest.presentation.screen.description.presenter.DescriptionPresenter;
import lili.tesla.leongardtest.presentation.screen.questions.view.QuestionsActivity;

public class DescriptionActivity extends BaseActivity implements DescriptionView {

    private DescriptionPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ButterKnife.bind(this);

        mPresenter = new DescriptionPresenter();
        mPresenter.setView(this);

        showFragment(new FragmentDescription());

    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(fragment.getClass() == android.support.v4.app.Fragment.class) {
            transaction.add(R.id.container, fragment);
            transaction.addToBackStack("tag");
        } else {
            transaction.replace(R.id.container, fragment);
        }
        transaction.commit();
    }

    @OnClick(R.id.button_start_test)
    void startClicked() { mPresenter.startQuestionsScreen(); }

    @Override
    public void startQuestionsScreen() {
        QuestionsActivity.start(this);
    }
}
