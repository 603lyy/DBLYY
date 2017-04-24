package com.dblyy.buyticket.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dblyy.R;
import com.dblyy.buyticket.mvp.model.bean.BuyShowingListBean;

import java.util.List;

/**
 * 作者：linyaye on 2017/4/21 14:36
 */

public class ShowingListAdapter extends BaseMultiItemQuickAdapter<BuyShowingListBean, BaseViewHolder> {


    public ShowingListAdapter(List<BuyShowingListBean> data) {
        super(data);
        addItemType(BuyShowingListBean.SHOWING, R.layout.item_buy_ticket_showing);
        addItemType(BuyShowingListBean.UNSHOW, R.layout.item_buy_ticket_showing);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, BuyShowingListBean item) {
        switch (viewHolder.getItemViewType()) {
            case BuyShowingListBean.SHOWING:
                viewHolder.setText(R.id.tv_title, item.getTitleCn())
                        .setText(R.id.tv_scr, item.getCommonSpecial())
                        .setText(R.id.tv_show_time, mContext.getString(R.string.buy_ticket_show_time, item.getRDay() + "", item.getRMonth() + ""))
                        .setText(R.id.tv_cinema, mContext.getString(R.string.buy_ticket_cinema, item.getNearestShowtime().getNearestCinemaCount() + "", item.getNearestShowtime().getNearestShowtimeCount() + ""));
                break;
        }
    }
}
