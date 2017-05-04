package com.dblyy.buyticket.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dblyy.R;
import com.dblyy.buyticket.adapter.ComingListAdapter;
import com.dblyy.buyticket.adapter.ComingListHeaderAdapter;
import com.dblyy.buyticket.mvp.model.bean.BuyComingListBean;
import com.dblyy.buyticket.mvp.presenter.impl.BuyComingListPresenterImpl;
import com.dblyy.buyticket.mvp.view.IComingListFragment;
import com.dblyy.widget.fragment.BaseFragment;
import com.dblyy.widget.recyclerview.animation.CustomAnimation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：linyaye on 2017/5/2 15:38
 */

public class ComingNewListFragment extends BaseFragment implements IComingListFragment {

    private static final String BUYTICKET_TYPE_ID = "buyticket_type_id";

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    private RecyclerView recycler_view_header;

    private BuyComingListPresenterImpl presenter;

    private ComingListAdapter listAdapter;

    private ComingListHeaderAdapter headerAdapter;

    private final List<BuyComingListBean.MoviecomingsBean> comingList = new ArrayList<>();

    private final List<BuyComingListBean.AttentionBean> attentionList = new ArrayList<>();

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
        View view = inflater.inflate(R.layout.fragment_coming_list, container, false);

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

        //设置RefreshLayout
        //设置RecyclerView
        listAdapter = new ComingListAdapter(comingList);
        headerAdapter = new ComingListHeaderAdapter(attentionList);

//        View header = LayoutInflater.from(getActivity()).inflate(R.layout.header_buy_ticket_coming, null);
        View header = getActivity().getLayoutInflater().inflate(R.layout.header_buy_ticket_coming,
                (ViewGroup) recycler_view.getParent(), false);
        recycler_view_header = (RecyclerView) header.findViewById(R.id.recycler_view_header);
        recycler_view_header.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recycler_view_header.setAdapter(headerAdapter);

        listAdapter.addHeaderView(header);
        listAdapter.openLoadAnimation(new CustomAnimation());
        recycler_view.setLayoutManager(new LinearLayoutManager(context));
        recycler_view.setAdapter(listAdapter);
    }

    @Override
    public void updateRecyclerView(BuyComingListBean data) {
        Log.i(TAG, "updateRecyclerView: ");
        Log.i(TAG, "updateRecyclerView: ");
        for (int i = 0; i <5 ; i++) {
            i++;
        }
//        listAdapter.addData(data.getMoviecomings());
//        headerAdapter.addData(data.getAttention());
//        headerAdapter.loadMoreEnd();
//        listAdapter.loadMoreEnd();
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
