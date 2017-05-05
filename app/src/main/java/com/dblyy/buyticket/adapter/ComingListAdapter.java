package com.dblyy.buyticket.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dblyy.R;
import com.dblyy.buyticket.mvp.model.bean.BuyComingListBean;

import java.util.List;

/**
 * 作者：linyaye on 2017/5/3 10:19
 */

public class ComingListAdapter extends BaseQuickAdapter<BuyComingListBean, BaseViewHolder> {


    public ComingListAdapter(List<BuyComingListBean> data) {
        super(R.layout.item_buy_ticket_coming, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, BuyComingListBean item) {

        Glide.with(mContext)
                .load(item.getImage())
                .centerCrop()
                .crossFade()
                .into((ImageView) holder.getView(R.id.iv_movie_coming));

        holder.setText(R.id.tv_title_coming, item.getTitle());
    }
}
