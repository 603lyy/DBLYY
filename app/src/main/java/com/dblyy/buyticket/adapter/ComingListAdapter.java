package com.dblyy.buyticket.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dblyy.R;
import com.dblyy.buyticket.mvp.model.bean.BuyComingListBean;
import com.dblyy.buyticket.mvp.model.bean.BuyComingListItemBean;

import java.util.List;

/**
 * 作者：linyaye on 2017/5/3 10:19
 */

public class ComingListAdapter extends BaseSectionQuickAdapter<BuyComingListItemBean, BaseViewHolder> {

    public static final int SECTION_HEADER = 1;
    public static final int NOT_SECTION_HEADER = 2;

    public ComingListAdapter(List<BuyComingListItemBean> data) {
        super(R.layout.item_buy_ticket_coming, R.layout.item_buy_ticket_coming_section_header, data);
    }

    @Override
    protected void convertHead(BaseViewHolder holder, BuyComingListItemBean bean) {
        holder.setText(R.id.tv_date, bean.header);
        holder.itemView.setTag(SECTION_HEADER);
    }

    @Override
    protected void convert(BaseViewHolder holder, BuyComingListItemBean bean) {

        holder.itemView.setTag(NOT_SECTION_HEADER);
        BuyComingListBean.MoviecomingsBean item = (BuyComingListBean.MoviecomingsBean) bean.t;

        Glide.with(mContext)
                .load(item.getImage())
                .centerCrop()
                .crossFade()
                .into((ImageView) holder.getView(R.id.iv_movie_coming));

        holder.setText(R.id.tv_title_coming, item.getTitle());
    }


//    public ComingListAdapter(List<BuyComingListBean.MoviecomingsBean> data) {
//        super(R.layout.item_buy_ticket_coming, data);
//    }
//
//    @Override
//    protected void convert(BaseViewHolder holder, BuyComingListBean.MoviecomingsBean item) {
//
//        Glide.with(mContext)
//                .load(item.getImage())
//                .centerCrop()
//                .crossFade()
//                .into((ImageView) holder.getView(R.id.iv_movie_coming));
//
//        holder.setText(R.id.tv_title_coming, item.getTitle());
//    }
}
