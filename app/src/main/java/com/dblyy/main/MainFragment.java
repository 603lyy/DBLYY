package com.dblyy.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.dblyy.R;
import com.dblyy.buyticket.ui.BuyTicketFragment;
import com.dblyy.discover.DiscoverFragment;
import com.dblyy.user.UserFragment;
import com.dblyy.widget.fragment.BaseFragment;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * 作者：linyaye on 2017/4/11 15:17
 */

public class MainFragment extends BaseFragment {

    private static final String KEY = "key";

//    @BindView(R.id.layout_container)
    FrameLayout layout_container;
//    @BindView(R.id.magic_indicator)
    MagicIndicator indicator;

    private final int[] normalResId = new int[]{
            R.drawable.ic_hot_showing_normal,
            R.drawable.ic_discover_normal,
            R.drawable.ic_user_normal
    };
    private final int[] pressedResId = new int[]{
            R.drawable.ic_hot_showing_pressed,
            R.drawable.ic_discover_pressed,
            R.drawable.ic_user_pressed
    };
    private final int[] resName = new int[]{
            R.string.hot_showing,
            R.string.discover,
            R.string.my
    };

    private final SupportFragment[] fragments = new SupportFragment[3];
    private final FragmentContainerHelper fragmentContainerHelper = new FragmentContainerHelper();

    //用于按两次Back键退出
    private long exitTime;
    private Context context;
    private int current;

    public static MainFragment newInstance() {
        return newInstance("");
    }

    private static MainFragment newInstance(String value) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(KEY, value);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        indicator = (MagicIndicator) view.findViewById(R.id.magic_indicator);
        layout_container = (FrameLayout) view.findViewById(R.id.layout_container);

        ButterKnife.bind(this, view);

        context = view.getContext();

        initView();

        return view;
    }

    private void initView() {

        CommonNavigator navigator = new CommonNavigator(context);

        //Fragment相关
        fragments[0] = BuyTicketFragment.newInstance();
        fragments[1] = DiscoverFragment.newInstance();
        fragments[2] = UserFragment.newInstance();

        loadMultipleRootFragment(R.id.layout_container, 0,
                fragments[0],
                fragments[1],
                fragments[2]);

        current = 0;

        navigator.setAdjustMode(true);
        navigator.setFollowTouch(true);
        navigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return fragments.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                CommonPagerTitleView titleView = new CommonPagerTitleView(context);
                titleView.setContentView(R.layout.item_main_tab_indicator_layout);//加载自定义布局作为Tab

                final Button tab_btn = (Button) titleView.findViewById(R.id.tab_btn);
                final TextView tab_name = (TextView) titleView.findViewById(R.id.tab_name);
                tab_name.setText(resName[index]);
                titleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
                    @Override
                    public void onSelected(int i, int i1) {
                        tab_btn.setBackgroundResource(pressedResId[i]);
                        tab_name.setTextColor(ContextCompat.getColor(context, R.color.color_primary_text));
                    }

                    @Override
                    public void onDeselected(int i, int i1) {
                        tab_btn.setBackgroundResource(normalResId[i]);
                        tab_name.setTextColor(ContextCompat.getColor(context, R.color.color_secondary_text));
                    }

                    @Override
                    public void onLeave(int i, int i1, float v, boolean b) {

                    }

                    @Override
                    public void onEnter(int i, int i1, float v, boolean b) {

                    }
                });
                titleView.setOnClickListener(v -> {
                    fragmentContainerHelper.handlePageSelected(index);
                    showHideFragment(fragments[index], fragments[current]);
                    current = index;
                });

                return titleView;
            }

            //指示器圆点
            @Override
            public IPagerIndicator getIndicator(Context context) {
//                BezierPagerIndicator indicator = new BezierPagerIndicator(context);
//                indicator.setMaxCircleRadius(UIUtil.dip2px(context, 3));
//                indicator.setColors(ContextCompat.getColor(context, R.color.color_primary));
//                return indicator;
                return null;
            }
        });

        indicator.setNavigator(navigator);
        fragmentContainerHelper.attachMagicIndicator(indicator);
    }

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            exitTime = System.currentTimeMillis();
            ToastUtils.showShortToast(getString(R.string.second_exit));
            return true;
        } else {
            return super.onBackPressedSupport();
        }
    }
}
