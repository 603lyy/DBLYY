package com.dblyy.buyticket.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dblyy.R;
import com.dblyy.buyticket.mvp.model.bean.BuyComingListBean;

import java.util.List;

/**
 * 作者：linyaye on 2017/5/3 11:38
 */

public class ComingListHeaderAdapter extends BaseQuickAdapter<BuyComingListBean.AttentionBean, BaseViewHolder> {

    public ComingListHeaderAdapter(List<BuyComingListBean.AttentionBean> data) {
        super(R.layout.item_buy_ticket_coming_header, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, BuyComingListBean.AttentionBean item) {

        Glide.with(mContext)
                .load(item.getImage())
                .crossFade()
                .centerCrop()
                .into((ImageView) holder.getView(R.id.iv_movie_header));

        holder.setText(R.id.tv_title_header, item.getTitle());
    }
}
