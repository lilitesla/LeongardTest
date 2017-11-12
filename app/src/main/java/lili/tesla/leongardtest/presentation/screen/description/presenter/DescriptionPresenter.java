package lili.tesla.leongardtest.presentation.screen.description.presenter;

import lili.tesla.leongardtest.presentation.application.App;
import lili.tesla.leongardtest.presentation.screen.base.BasePresenter;
import lili.tesla.leongardtest.presentation.screen.description.view.DescriptionView;

/**
 * Created by Лилия on 12.11.2017.
 */

public class DescriptionPresenter extends BasePresenter<DescriptionView> {

    public void startQuestionsScreen() {

        App.questions.clear();
        mView.startQuestionsScreen();

    }

}
