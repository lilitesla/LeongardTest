package lili.tesla.leongardtest.presentation.screen.base;

/**
 * Created by Лилия on 12.11.2017.
 */

public abstract class BasePresenter<View> {

    protected View mView;

    public void setView(View view) {
        mView = view;
    }

    public void destroy() {
        mView = null;
    }
}
