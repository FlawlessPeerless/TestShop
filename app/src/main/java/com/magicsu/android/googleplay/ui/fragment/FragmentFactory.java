package com.magicsu.android.googleplay.ui.fragment;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.magicsu.android.googleplay.base.BaseFragment;

import java.util.HashMap;

/**
 * fragment 工厂类
 * Created by admin on 2018/1/25.
 */

public class FragmentFactory {
    private static SparseArray<BaseFragment> mFragmentMap = new SparseArray<>();

    public static BaseFragment createFragment(int pos) {
        BaseFragment fragment = mFragmentMap.get(pos);
        if (fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new AppFragment();
                    break;
                case 2:
                    fragment = new GameFragment();
                    break;
                case 3:
                    fragment = new  SubjectFragment();
                    break;
                case 4:
                    fragment = new RecommendFragment();
                    break;
                case 5:
                    fragment = new CategoryFragment();
                    break;
                case 6:
                    fragment = new HotFragment();
                    break;
            }
            mFragmentMap.put(pos, fragment);
        }

        return fragment;
    }
}
