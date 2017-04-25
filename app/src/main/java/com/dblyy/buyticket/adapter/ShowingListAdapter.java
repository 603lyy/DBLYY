package com.dblyy.buyticket.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
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
                        .setText(R.id.tv_scr, item.getCommonSpecial());

                Glide.with(mContext)
                        .load(item.getImg())
                        .centerCrop()
                        .crossFade()
                        .into((ImageView) viewHolder.getView(R.id.iv_movie));

                break;
        }
    }
}
