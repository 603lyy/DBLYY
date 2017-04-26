package com.dblyy.buyticket.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dblyy.R;
import com.dblyy.buyticket.mvp.model.bean.BuyShowingListBean;
import com.dblyy.util.TimeUtil;

import java.util.List;

/**
 * 作者：linyaye on 2017/4/21 14:36
 */

public class ShowingListAdapter extends BaseQuickAdapter<BuyShowingListBean, BaseViewHolder> {


    public ShowingListAdapter(List<BuyShowingListBean> data) {
        super(R.layout.item_buy_ticket_showing, data);
//        addItemType(BuyShowingListBean1.SHOWING, R.layout.item_buy_ticket_showing);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, BuyShowingListBean item) {
        String mShowTime, mCinema;
        mShowTime = TimeUtil.timeStampTransformToYMDHMS(mContext.getResources(), item.getNearestDay());
        mCinema = mContext.getString(R.string.buy_ticket_cinema,
                item.getNearestCinemaCount() + "",
                item.getNearestShowtimeCount() + "");

        viewHolder.setText(R.id.tv_title, item.getTCn())
                .setText(R.id.tv_scr, item.getCommonSpecial())
                .setText(R.id.tv_show_time, mShowTime)
                .setText(R.id.tv_movie_number, mCinema);

        Glide.with(mContext)
                .load(item.getImg())
                .centerCrop()
                .crossFade()
                .into((ImageView) viewHolder.getView(R.id.iv_movie));

    }
}
