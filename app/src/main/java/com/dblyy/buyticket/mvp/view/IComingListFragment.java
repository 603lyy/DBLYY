package com.dblyy.buyticket.mvp.view;

import com.dblyy.buyticket.mvp.model.bean.BuyShowingListBean;
import com.dblyy.util.retrofit.exception.IErrorView;

import java.util.List;

/**
 * 作者：linyaye on 2017/5/2 16:40
 */

public interface IComingListFragment extends IErrorView {

    void updateRecyclerView(List<BuyShowingListBean> roomBeanList);//更新列表
}
