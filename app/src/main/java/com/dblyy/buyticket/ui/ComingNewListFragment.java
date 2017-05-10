package com.dblyy.buyticket.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dblyy.R;
import com.dblyy.buyticket.adapter.ComingListAdapter;
import com.dblyy.buyticket.adapter.ComingListHeaderAdapter;
import com.dblyy.buyticket.mvp.model.bean.BuyComingListBean;
import com.dblyy.buyticket.mvp.model.bean.BuyComingListItemBean;
import com.dblyy.buyticket.mvp.presenter.impl.BuyComingListPresenterImpl;
import com.dblyy.buyticket.mvp.view.IComingListFragment;
import com.dblyy.widget.fragment.BaseFragment;
import com.dblyy.widget.recyclerview.animation.CustomAnimation;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * 作者：linyaye on 2017/5/2 15:38
 */

public class ComingNewListFragment extends BaseFragment implements IComingListFragment,
        BaseQuickAdapter.RequestLoadMoreListener {

    private static final String BUYTICKET_TYPE_ID = "buyticket_type_id";

    //    @BindView(R.id.recycler_view_coming_list)
    RecyclerView recycler_view;

    private LinearLayout ll_section_header;

    private RecyclerView recycler_view_header;

    private TextView tv_date;

    private BuyComingListPresenterImpl presenter;

    private ComingListAdapter listAdapter;

    private ComingListHeaderAdapter headerAdapter;

    private final List<BuyComingListBean> comingList = new ArrayList<>();

//    private final List<BuyComingListBean> attentionList = new ArrayList<>();

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

        tv_date = (TextView) view.findViewById(R.id.tv_date);
        recycler_view = (RecyclerView) view.findViewById(R.id.recycler_view_coming_list);
        ll_section_header = (LinearLayout) view.findViewById(R.id.ll_item_buy_ticket_coming_section_header);

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
        listAdapter = new ComingListAdapter(new ArrayList<>());
        listAdapter.openLoadAnimation(new CustomAnimation());

        headerAdapter = new ComingListHeaderAdapter(new ArrayList<>());
        headerAdapter.openLoadAnimation(new CustomAnimation());

        View header = getActivity().getLayoutInflater().inflate(R.layout.header_buy_ticket_coming, (ViewGroup) recycler_view.getParent(), false);
        recycler_view_header = (RecyclerView) header.findViewById(R.id.recycler_view_header);
        recycler_view_header.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recycler_view_header.setAdapter(headerAdapter);
        listAdapter.addHeaderView(header);

        recycler_view.setLayoutManager(new LinearLayoutManager(context));
        recycler_view.setAdapter(listAdapter);

        ll_section_header.setVisibility(View.GONE);
        recycler_view.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView view, int dx, int dy) {
                super.onScrolled(view, dx, dy);

                int firstItemPosition = -1;
                RecyclerView.LayoutManager layoutManager = view.getLayoutManager();
                //判断是当前layoutManager是否为LinearLayoutManager
                // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                    //获取第一个可见view的位置
                    firstItemPosition = linearManager.findFirstVisibleItemPosition();
                    if (firstItemPosition == 0)
                        ll_section_header.setVisibility(View.INVISIBLE);
                    else
                        ll_section_header.setVisibility(View.VISIBLE);
                }

                //找到recycleview可见区域中的第一个item，判断时候为日期头部，是则将获取到的日期赋值到
                //覆盖在recycleview上方的textview中
                View stickyInfoView = view.findChildViewUnder(ll_section_header.getMeasuredWidth() / 2, 10);
                if (stickyInfoView != null) {
                    TextView textView = (TextView) stickyInfoView.findViewById(R.id.tv_date);
                    if (textView != null && dy > 0)
                        tv_date.setText(textView.getText().toString());
                    else if (dy < 0 && firstItemPosition > 0 && listAdapter.getData().size() > 0) {
                        BuyComingListBean.MoviecomingsBean item =
                                (BuyComingListBean.MoviecomingsBean) listAdapter.getData().get(firstItemPosition - 1).t;
                        if (item != null)
                            tv_date.setText(getString(R.string.buy_ticket_date, item.getRMonth() + "", item.getRDay() + ""));
                    }
                }

                //找到固定在头部的日期的view下面一个像素位的view，判断是否为日期头部view，根据这个view
                //移动的距离移动覆盖在recycleview上方的头部headerView
                View transInfoView = view.findChildViewUnder(
                        ll_section_header.getMeasuredWidth() / 2, ll_section_header.getMeasuredHeight() + 1);
                if (transInfoView != null && transInfoView.getTag() != null) {
                    int tag = (int) transInfoView.getTag();
                    int dealtY = transInfoView.getTop() - ll_section_header.getMeasuredHeight();

                    if (tag == ComingListAdapter.SECTION_HEADER) {
                        if (transInfoView.getTop() > 0) {
                            ll_section_header.setTranslationY(dealtY);
                        } else {
                            ll_section_header.setTranslationY(0);
                        }
                    } else if (tag == ComingListAdapter.NOT_SECTION_HEADER) {
                        ll_section_header.setTranslationY(0);
                    }
                }

            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

    @Override
    public void updateRecyclerViewHeader(List<BuyComingListBean.AttentionBean> list) {
        headerAdapter.addData(list);
    }

    @Override
    public void updateRecyclerViewMain(List<BuyComingListItemBean> list) {
        listAdapter.addData(list);
    }

    @Override
    public void showError(String message) {
        listAdapter.loadMoreFail();//在加载失败的时候调用showLoadMoreFailedView()就能显示加载失败的footer了，点击footer会重新加载
        ToastUtils.showShortToast(message);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
