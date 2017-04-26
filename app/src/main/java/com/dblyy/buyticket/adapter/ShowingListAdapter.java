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

    private long nowTime;

    public ShowingListAdapter(List<BuyShowingListBean> data) {
        super(R.layout.item_buy_ticket_showing, data);
//        addItemType(BuyShowingListBean1.SHOWING, R.layout.item_buy_ticket_showing);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, BuyShowingListBean item) {
        boolean isShow;
        String mShowTime, mCinema;

        mShowTime = TimeUtil.timeStampTransformToMD(mContext.getResources(), item.getNearestDay());
        mCinema = mContext.getString(R.string.buy_ticket_cinema,
                item.getNearestCinemaCount() + "",
                item.getNearestShowtimeCount() + "");

        nowTime = System.currentTimeMillis();

        viewHolder.setText(R.id.tv_title, item.getTCn())
                .setText(R.id.tv_scr, item.getCommonSpecial())
                .setText(R.id.tv_show_time, mContext.getString(R.string.buy_ticket_show_time, mShowTime));

        if (item.getR() > 0)
            viewHolder.setText(R.id.tv_point, item.getR() + "");
        else
            viewHolder.setText(R.id.tv_point, "");

        if (nowTime > TimeUtil.MDTransformToTimeStamp(mContext.getResources(), item.getRd()))
            viewHolder.setText(R.id.btn_buy, R.string.buy_ticket_is_ticket)
                    .setBackgroundRes(R.id.btn_buy, R.drawable.common_orange_border_inside)
                    .setText(R.id.tv_movie_number, mContext.getString(R.string.buy_ticket_cinema_today, mCinema));
        else
            viewHolder.setText(R.id.btn_buy, R.string.buy_ticket_is_unticket)
                    .setBackgroundRes(R.id.btn_buy, R.drawable.common_green_border_inside)
                    .setText(R.id.tv_movie_number, mShowTime + mCinema);

        Glide.with(mContext)
                .load(item.getImg())
                .centerCrop()
                .crossFade()
                .into((ImageView) viewHolder.getView(R.id.iv_movie));

    }
}
