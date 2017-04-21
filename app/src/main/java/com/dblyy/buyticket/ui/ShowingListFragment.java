package com.dblyy.buyticket.ui;

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
 * 作者：linyaye on 2017/4/20 15:45
 */

public class ShowingListFragment extends BaseFragment {

    private static final String BUYTICKET_TYPE_ID = "buyticket_type_id";

    private Context context;

    public static ShowingListFragment newInstance() {
        return newInstance("");
    }

    public static ShowingListFragment newInstance(String explore_type_id) {
        ShowingListFragment fragment = new ShowingListFragment();
        Bundle args = new Bundle();
        args.putString(BUYTICKET_TYPE_ID, explore_type_id);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot_showing, container, false);

        ButterKnife.bind(this, view);

        context = view.getContext();

        return view;
    }
}
