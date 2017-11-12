package lili.tesla.leongardtest.presentation.screen.description.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Лилия on 12.11.2017.
 */

public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();

            default:
                return null;
        }
    }

}