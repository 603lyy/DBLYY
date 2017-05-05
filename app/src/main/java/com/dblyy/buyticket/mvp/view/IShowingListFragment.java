package com.dblyy.buyticket.mvp.view;

import com.dblyy.buyticket.mvp.model.bean.BuyShowingListBean;
import com.dblyy.util.retrofit.exception.IErrorView;

import java.util.List;

/**
 * 作者：linyaye on 2017/4/24 11:50
 */

public interface IShowingListFragment extends IErrorView {

    void updateRecyclerView(List<BuyShowingListBean> list);//更新列表
}
