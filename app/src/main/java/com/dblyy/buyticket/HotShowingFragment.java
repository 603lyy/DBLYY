package com.dblyy.buyticket;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.utils.SizeUtils;
import com.dblyy.R;
import com.dblyy.util.global.FragmentAdapter;
import com.dblyy.widget.fragment.BaseFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：linyaye on 2017/4/11 16:30
 */

public class HotShowingFragment extends BaseFragment {

    @BindView(R.id.tv_movie)
    TextView tv_movie;
    @BindView(R.id.tv_cinema)
    TextView tv_cinema;
    @BindView(R.id.magic_indicator)
    MagicIndicator magic_indicator;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private final List<Fragment> fragmentList = new ArrayList<>();

    private List<String> selectedTitleList = new ArrayList<>();

    private String[] nameArray;

    private Context context;

    private CommonNavigator navigator;

    public static HotShowingFragment newInstance() {
        return new HotShowingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hot_showing, container, false);

        ButterKnife.bind(this, view);

        context = view.getContext();

        return view;
    }

    @Override
    public void onLazyInitView(Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initView();
    }

    private void initView() {

        nameArray = getResources().getStringArray(R.array.buy_type_tname);
        for (String aTnameArray : nameArray)
            selectedTitleList.add(aTnameArray);

        for (int i = 0; i < selectedTitleList.size(); i++) {
            fragmentList.add(BuyTicketListFragment.newInstance(i + ""));
        }
        FragmentAdapter fAdapter = new FragmentAdapter(this.getChildFragmentManager(), fragmentList);
        viewpager.setAdapter(fAdapter);
        viewpager.setOffscreenPageLimit(2);

        navigator = new CommonNavigator(context);
        navigator.setAdjustMode(true);
        navigator.setIndicatorOnTop(true);
        navigator.setSkimOver(true);
        navigator.setScrollPivotX(0.2f);

        CommonNavigatorAdapter nAdapter = new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return selectedTitleList == null ? 0 : selectedTitleList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int i) {

                //框架提供样式，在滑动过程中，文字的颜色随着滑动变色
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
                clipPagerTitleView.setTextSize(SizeUtils.sp2px(18));
                clipPagerTitleView.setText(selectedTitleList.get(i));
                clipPagerTitleView.setBackgroundResource(R.color.color_balck_1);
                clipPagerTitleView.setClipColor(ContextCompat.getColor(context, R.color.color_text_white));
                clipPagerTitleView.setTextColor(ContextCompat.getColor(context, R.color.color_text_subheading));
                clipPagerTitleView.setOnClickListener(v -> viewpager.setCurrentItem(i));
                return clipPagerTitleView;

                //自定义布局
//                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
//                commonPagerTitleView.setContentView(R.layout.item_buy_ticket_indicator_layout);
//
//                final TextView tab_textview = (TextView) commonPagerTitleView.findViewById(R.id.tab_text);
//                tab_textview.setText(selectedTitleList.get(i));
//                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
//                    @Override
//                    public void onSelected(int i, int i1) {
//                        tab_textview.setTextColor(ContextCompat.getColor(context, R.color.color_text_white));
//                    }
//
//                    @Override
//                    public void onDeselected(int i, int i1) {
//                        tab_textview.setTextColor(ContextCompat.getColor(context, R.color.color_text_subheading));
//                    }
//
//                    @Override
//                    public void onLeave(int i, int i1, float v, boolean b) {
//
//                    }
//
//                    @Override
//                    public void onEnter(int i, int i1, float v, boolean b) {
//
//                    }
//                });
//                commonPagerTitleView.setOnClickListener(v -> viewpager.setCurrentItem(i));
//                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_MATCH_EDGE);
                indicator.setLineHeight(SizeUtils.px2dp(15));
                indicator.setRoundRadius(SizeUtils.px2dp(2));
                indicator.setYOffset(SizeUtils.px2dp(10f));
                indicator.setColors(ContextCompat.getColor(context, R.color.color_white));
                return indicator;
            }
        };
        navigator.setAdapter(nAdapter);
        magic_indicator.setNavigator(navigator);
        ViewPagerHelper.bind(magic_indicator, viewpager);
    }
}
