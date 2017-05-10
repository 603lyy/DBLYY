package com.dblyy.buyticket.mvp.presenter.impl;

import com.blankj.utilcode.utils.Utils;
import com.dblyy.R;
import com.dblyy.buyticket.api.BuyTicketAPI;
import com.dblyy.buyticket.mvp.model.bean.BuyComingListBean;
import com.dblyy.buyticket.mvp.model.bean.BuyComingListItemBean;
import com.dblyy.buyticket.mvp.presenter.IBuyComingListPresenter;
import com.dblyy.buyticket.mvp.view.IComingListFragment;
import com.dblyy.util.GsonHelper;
import com.dblyy.util.retrofit.HttpSubscriber;
import com.dblyy.util.retrofit.RetrofitHelper;
import com.google.gson.JsonObject;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：linyaye on 2017/5/2 15:49
 */

public class BuyComingListPresenterImpl implements IBuyComingListPresenter {

    //view层的接口实现
    private final IComingListFragment view;

    public BuyComingListPresenterImpl(IComingListFragment view) {
        this.view = view;
    }

    @Override
    public void getBuyComingList(String locationId) {
        RetrofitHelper.getRetrofitHelper().create(BuyTicketAPI.class)
                .getComingNewList(locationId)
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<JsonObject, Publisher<BuyComingListBean>>() {
                    @Override
                    public Publisher<BuyComingListBean> apply(@NonNull JsonObject jsonObject) throws Exception {
                        BuyComingListBean bean = (BuyComingListBean) GsonHelper.parseJson(jsonObject, BuyComingListBean.class);
                        return Flowable.just(bean);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new HttpSubscriber<BuyComingListBean>() {
                    @Override
                    public void _onNext(BuyComingListBean item) {
                        int month = 0, day = 0;
                        List<BuyComingListBean.MoviecomingsBean> list = item.getMoviecomings();
                        List<BuyComingListItemBean> itemList = new ArrayList<BuyComingListItemBean>();
                        for (int i = 0; i < list.size(); i++) {
                            if (month != list.get(i).getRMonth() || day != list.get(i).getRDay()) {
                                month = list.get(i).getRMonth();
                                day = list.get(i).getRDay();
                                itemList.add(new BuyComingListItemBean(true,
                                        Utils.getContext().getString(R.string.buy_ticket_date, month + "", day + "")));
                            }
                            if (month == list.get(i).getRMonth() && day == list.get(i).getRDay()) {
                                itemList.add(new BuyComingListItemBean(list.get(i)));
                            }
                        }
                        view.updateRecyclerView(item);
                        view.updateRecyclerViewMain(itemList);
                    }

                    @Override
                    public void _onError(String message) {

                    }
                });
    }
}
