package com.dblyy.buyticket;

import android.os.Bundle;

import com.dblyy.widget.fragment.BaseFragment;

/**
 * 作者：linyaye on 2017/4/20 15:45
 */

public class BuyTicketListFragment extends BaseFragment {

    private static final String BUYTICKET_TYPE_ID = "buyticket_type_id";

    public static BuyTicketListFragment newInstance() {
        return newInstance("");
    }

    public static BuyTicketListFragment newInstance(String explore_type_id) {
        BuyTicketListFragment fragment = new BuyTicketListFragment();
        Bundle args = new Bundle();
        args.putString(BUYTICKET_TYPE_ID, explore_type_id);
        fragment.setArguments(args);
        return fragment;
    }
}
