package com.dblyy.buyticket.mvp.model.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * 作者：lyy on 2017/5/10 10:37
 */

public class BuyComingListItemBean extends SectionEntity {

    public BuyComingListItemBean(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public BuyComingListItemBean(BuyComingListBean.MoviecomingsBean bean) {
        super(bean);
    }
}
