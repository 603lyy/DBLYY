package com.dblyy.root;

import android.os.Bundle;

import com.dblyy.R;
import com.dblyy.main.MainFragment;
import com.dblyy.widget.activity.BaseActivity;

/**
 * 作者：linyaye on 2017/4/11 15:13
 */

public class RootActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        loadRootFragment(R.id.layout_container_root, MainFragment.newInstance());
    }
}
