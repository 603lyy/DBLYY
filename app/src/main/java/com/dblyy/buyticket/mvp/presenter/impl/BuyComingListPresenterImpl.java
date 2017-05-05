package com.dblyy.buyticket.mvp.presenter.impl;

import com.dblyy.buyticket.api.BuyTicketAPI;
import com.dblyy.buyticket.mvp.model.bean.BuyComingListBean;
import com.dblyy.buyticket.mvp.presenter.IBuyComingListPresenter;
import com.dblyy.buyticket.mvp.view.IComingListFragment;
import com.dblyy.util.GsonHelper;
import com.dblyy.util.retrofit.HttpSubscriber;
import com.dblyy.util.retrofit.RetrofitHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.Map;

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
                .flatMap(new Function<JsonObject, Publisher<ArrayList<BuyComingListBean>>>() {
                    @Override
                    public Publisher<ArrayList<BuyComingListBean>> apply(@NonNull JsonObject jsonObject) throws Exception {
                        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                            if (entry.getValue().isJsonArray()) {
                                JsonArray jsonArray = entry.getValue().getAsJsonArray();
                                ArrayList<BuyComingListBean> list = new ArrayList<>();
                                for (JsonElement element : jsonArray) {
                                    list.add((BuyComingListBean) GsonHelper.parseJson(element, BuyComingListBean.class));
                                }
                                return Flowable.just(list);
                            }
//                            JsonElement jsonElement = entry.getValue();
//                            BuyComingListBean item = (BuyComingListBean) GsonHelper.parseJson(jsonObject, BuyComingListBean.class);
//                            return Flowable.just(item);
                        }
                        return null;
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new HttpSubscriber<ArrayList<BuyComingListBean>>() {
                    @Override
                    public void _onNext(ArrayList<BuyComingListBean> item) {
                        view.updateRecyclerView(item);
                    }

                    @Override
                    public void _onError(String message) {

                    }
                });
    }
}
