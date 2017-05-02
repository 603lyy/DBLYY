package com.dblyy.buyticket.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dblyy.R;
import com.dblyy.buyticket.mvp.model.bean.BuyShowingListBean;
import com.dblyy.buyticket.mvp.presenter.impl.BuyComingListPresenterImpl;
import com.dblyy.buyticket.mvp.view.IComingListFragment;
import com.dblyy.widget.fragment.BaseFragment;

import java.util.List;

import butterknife.ButterKnife;

/**
 * 作者：linyaye on 2017/5/2 15:38
 */

public class ComingNewListFragment extends BaseFragment implements IComingListFragment {

    private static final String BUYTICKET_TYPE_ID = "buyticket_type_id";

    private BuyComingListPresenterImpl presenter;

    private Context context;

    public static ComingNewListFragment newInstance() {
        return newInstance("");
    }

    public static ComingNewListFragment newInstance(String explore_type_id) {
        ComingNewListFragment fragment = new ComingNewListFragment();
        Bundle args = new Bundle();
        args.putString(BUYTICKET_TYPE_ID, explore_type_id);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_showing_list, container, false);

        ButterKnife.bind(this, view);

        context = view.getContext();

        initView();

        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (savedInstanceState == null)
            presenter.getBuyComingList("290");
    }

    private void initView() {
        //初始化MVP
        presenter = new BuyComingListPresenterImpl(this);

    }

    @Override
    public void updateRecyclerView(List<BuyShowingListBean> roomBeanList) {

    }

    @Override
    public void showError(String message) {

    }
}
