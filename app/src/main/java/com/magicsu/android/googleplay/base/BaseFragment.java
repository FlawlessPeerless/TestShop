package com.magicsu.android.googleplay.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magicsu.android.googleplay.ui.view.StatePage;

/**
 * fragment基类
 * Created by admin on 2018/1/25.
 */

public class BaseFragment extends Fragment {
    private StatePage mPageLoading;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPageLoading = new StatePage(getContext());
        return mPageLoading;
    }
}
