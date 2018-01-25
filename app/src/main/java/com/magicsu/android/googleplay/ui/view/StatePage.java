package com.magicsu.android.googleplay.ui.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.magicsu.android.googleplay.R;

/**
 * 状态布局
 * - 未加载 - 加载中 - 加载失败 - 数据为空 - 加载成功
 * Created by admin on 2018/1/25.
 */

public class StatePage extends FrameLayout {
    private static final int STATE_LOAD_UNDO = 0;
    private static final int STATE_LOAD_LOADING = 1;
    private static final int STATE_LOAD_ERROR = 2;
    private static final int STATE_LOAD_EMPTY = 3;
    private static final int STATE_LOAD_SUCCESS = 4;

    private int mCurrentState = STATE_LOAD_UNDO;
    private View mPageLoading;

    public StatePage(@NonNull Context context) {
        super(context);
        initView();
    }

    public StatePage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public StatePage(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public StatePage(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        if (mPageLoading == null) {
            mPageLoading = LayoutInflater.from(getContext()).inflate(R.layout.state_page_loading, null, false);
        }
        addView(mPageLoading);
    }
}
