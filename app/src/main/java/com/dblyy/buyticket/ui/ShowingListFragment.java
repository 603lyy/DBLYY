package com.dblyy.buyticket.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.utils.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dblyy.R;
import com.dblyy.buyticket.adapter.ShowingListAdapter;
import com.dblyy.buyticket.api.BuyTicketAPI;
import com.dblyy.buyticket.mvp.model.bean.BuyShowingListBean;
import com.dblyy.buyticket.mvp.presenter.impl.BuyShowingListPresenterImpl;
import com.dblyy.buyticket.mvp.view.IShowingListFragment;
import com.dblyy.widget.fragment.BaseFragment;
import com.dblyy.widget.recyclerview.CustomLoadMoreView;
import com.dblyy.widget.recyclerview.DividerItemDecoration;
import com.dblyy.widget.recyclerview.animation.CustomAnimation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：linyaye on 2017/4/20 15:45
 */

public class ShowingListFragment extends BaseFragment implements IShowingListFragment,
        BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private static final String BUYTICKET_TYPE_ID = "buyticket_type_id";

    private final List<BuyShowingListBean> showingList = new ArrayList<>();

    private Context context;

    private ShowingListAdapter sListAdapter;

    private BuyShowingListPresenterImpl presenter;

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
            presenter.getBuyShowingList("290");
    }

    private void initView() {
        //初始化MVP
        presenter = new BuyShowingListPresenterImpl(this);
        //设置RefreshLayout

        //设置RecyclerView
        sListAdapter = new ShowingListAdapter(showingList);
        sListAdapter.openLoadAnimation(new CustomAnimation());
        sListAdapter.setAutoLoadMoreSize(BuyTicketAPI.LIMIT);//加载更多的触发条件
        sListAdapter.setOnLoadMoreListener(this, recyclerview);//加载更多回调监听
        sListAdapter.setLoadMoreView(new CustomLoadMoreView());

        recyclerview.setLayoutManager(new LinearLayoutManager(context));
        recyclerview.setAdapter(sListAdapter);
        recyclerview.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL_LIST));
    }


    @Override
    public void updateRecyclerView(List<BuyShowingListBean> list) {
        sListAdapter.addData(list);
        if (list.size() < BuyTicketAPI.LIMIT) {//分页数据size比每页数据的limit小，说明已全部加载数据
            sListAdapter.loadMoreEnd();
        } else {
            sListAdapter.loadMoreComplete();
        }
    }

    @Override
    public void showError(String message) {
        sListAdapter.loadMoreFail();//在加载失败的时候调用showLoadMoreFailedView()就能显示加载失败的footer了，点击footer会重新加载
        ToastUtils.showShortToast(message);
    }

    @Override
    public void onLoadMoreRequested() {
        presenter.getBuyShowingList("290");
    }
}
