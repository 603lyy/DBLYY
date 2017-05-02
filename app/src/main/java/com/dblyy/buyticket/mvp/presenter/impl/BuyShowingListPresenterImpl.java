package com.dblyy.buyticket.mvp.presenter.impl;

import com.dblyy.buyticket.api.BuyTicketAPI;
import com.dblyy.buyticket.mvp.model.bean.BuyShowingListBean;
import com.dblyy.buyticket.mvp.presenter.IBuyShowingListPresenter;
import com.dblyy.buyticket.mvp.view.IShowingListFragment;
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
 * 作者：linyaye on 2017/4/24 15:31
 */

public class BuyShowingListPresenterImpl implements IBuyShowingListPresenter {

    //view层的接口实现
    private final IShowingListFragment view;

    public BuyShowingListPresenterImpl(IShowingListFragment view) {
        this.view = view;
    }

    @Override
    public void getBuyShowingList(String locationId) {
        RetrofitHelper.getRetrofitHelper().create(BuyTicketAPI.class)
                .getBuyShowingList(locationId)
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<JsonObject, Publisher<ArrayList<BuyShowingListBean>>>() {
                    @Override
                    public Publisher<ArrayList<BuyShowingListBean>> apply(@NonNull JsonObject jsonObject) throws Exception {
                        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                            if (entry.getValue().isJsonArray()) {
                                JsonArray array = entry.getValue().getAsJsonArray();

                                ArrayList<BuyShowingListBean> list = new ArrayList<>();
                                for (JsonElement element : array) {
                                    list.add((BuyShowingListBean) GsonHelper.parseJson(element, BuyShowingListBean.class));
                                }
                                return Flowable.just(list);
                            }
                        }
                        return null;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new HttpSubscriber<ArrayList<BuyShowingListBean>>() {
                    @Override
                    public void _onNext(ArrayList<BuyShowingListBean> list) {
                        view.updateRecyclerView(list);
                    }

                    @Override
                    public void _onError(String message) {

                    }
                });
    }


}
