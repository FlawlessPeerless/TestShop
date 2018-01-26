package com.magicsu.android.googleplay.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magicsu.android.googleplay.ui.view.StatePage;

/**
 * fragment基类
 * Created by admin on 2018/1/25.
 */

public abstract class BaseFragment extends Fragment {
    private StatePage mStatePage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mStatePage = new StatePage(getContext()) {
            @Override
            public View onCreateSuccessView() {
                return BaseFragment.this.onCreateSuccessView();
            }

            @Override
            public ResultState onLoad() {
                return BaseFragment.this.onLoad();
            }
        };
        return mStatePage;
    }

    public abstract View onCreateSuccessView();

    public abstract StatePage.ResultState onLoad();

    public void loadData() {
        if (mStatePage != null) {
            mStatePage.loadData();
        }
    }
}
