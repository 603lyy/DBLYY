package com.dblyy.hotshowing;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dblyy.R;
import com.dblyy.widget.fragment.BaseFragment;

import butterknife.ButterKnife;

/**
 * 作者：linyaye on 2017/4/11 16:30
 */

public class HotShowingFragment extends BaseFragment {

    private Context context;

    public static HotShowingFragment newInstance() {
        return new HotShowingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hot_showing, container, false);

        ButterKnife.bind(this, view);

        context = view.getContext();

        return view;
    }
}
