package com.dblyy.buyticket.mvp.view;

import com.dblyy.buyticket.mvp.model.bean.BuyComingListBean;
import com.dblyy.buyticket.mvp.model.bean.BuyComingListItemBean;
import com.dblyy.util.retrofit.exception.IErrorView;

import java.util.List;

/**
 * 作者：linyaye on 2017/5/2 16:40
 */

public interface IComingListFragment extends IErrorView {

    void updateRecyclerView(BuyComingListBean item);//更新列表

    void updateRecyclerViewMain(List<BuyComingListItemBean> list);//更新主列表
}
