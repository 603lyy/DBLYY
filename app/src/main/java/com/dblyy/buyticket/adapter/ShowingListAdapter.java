package com.dblyy.buyticket.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dblyy.buyticket.mvp.model.bean.BuyShowingListBean;

import java.util.List;

/**
 * 作者：linyaye on 2017/4/21 14:36
 */

public class ShowingListAdapter extends BaseMultiItemQuickAdapter<BuyShowingListBean,BaseViewHolder> {


    public ShowingListAdapter(List<BuyShowingListBean> data) {
        super(data);
        addItemType(BuyShowingListBean.SHOWING,);
    }

    @Override
    protected void convert(BaseViewHolder helper, BuyShowingListBean item) {

    }
}
