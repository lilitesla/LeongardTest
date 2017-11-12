package lili.tesla.leongardtest.presentation.screen.description.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lili.tesla.leongardtest.R;

/**
 * Created by Лилия on 12.11.2017.
 */

public class Fragment2 extends Fragment {

    public static Fragment2 newInstance() {
        Bundle bundle = new Bundle();
        Fragment2 fragment = new Fragment2();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        return view;
    }

}

