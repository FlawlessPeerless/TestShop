package com.magicsu.android.googleplay.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.magicsu.android.googleplay.base.BaseFragment;
import com.magicsu.android.googleplay.ui.view.StatePage;

/**
 * 首页
 * Created by admin on 2018/1/25.
 */

public class HomeFragment extends BaseFragment {
    @Override
    public View onCreateSuccessView() {
        TextView textView = new TextView(getContext());
        textView.setText(getClass().getSimpleName());
        return textView;
    }

    @Override
    public StatePage.ResultState onLoad() {
        return StatePage.ResultState.STATE_SUCCESS;
    }
}
