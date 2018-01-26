package com.magicsu.android.googleplay.ui.fragment;

import android.view.View;

import com.magicsu.android.googleplay.base.BaseFragment;
import com.magicsu.android.googleplay.ui.view.StatePage;

/**
 * 应用
 * Created by admin on 2018/1/25.
 */

public class AppFragment extends BaseFragment {
    @Override
    public View onCreateSuccessView() {
        return null;
    }

    @Override
    public StatePage.ResultState onLoad() {
        return StatePage.ResultState.STATE_ERROR;
    }
}
