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

import java.security.PublicKey;

/**
 * 状态布局
 * - 未加载 - 加载中 - 加载失败 - 数据为空 - 加载成功
 * Created by admin on 2018/1/25.
 */

public abstract class StatePage extends FrameLayout {
    private static final int STATE_LOAD_UNDO = 0;
    private static final int STATE_LOAD_LOADING = 1;
    private static final int STATE_LOAD_ERROR = 2;
    private static final int STATE_LOAD_EMPTY = 3;
    private static final int STATE_LOAD_SUCCESS = 4;

    private int mCurrentState = STATE_LOAD_UNDO;
    private View mPageLoading;
    private View mPageError;
    private View mPageEmpty;
    private View mPageSuccess;

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
            addView(mPageLoading);
        }
        if (mPageError == null) {
            mPageError = LayoutInflater.from(getContext()).inflate(R.layout.state_page_error, null, false);
            addView(mPageError);
        }
        if (mPageEmpty == null) {
            mPageEmpty = LayoutInflater.from(getContext()).inflate(R.layout.state_page_empty, null, false);
            addView(mPageEmpty);
        }
        showPage();

    }

    /**
     * 根据状态显示布局
     */
    private void showPage() {
        mPageLoading.setVisibility(mCurrentState == STATE_LOAD_UNDO || mCurrentState == STATE_LOAD_LOADING ? VISIBLE : GONE);
        mPageError.setVisibility(mCurrentState == STATE_LOAD_ERROR ? VISIBLE : GONE);
        mPageEmpty.setVisibility(mCurrentState == STATE_LOAD_EMPTY ? VISIBLE : GONE);

        if (mPageSuccess == null && mCurrentState == STATE_LOAD_SUCCESS) {
            mPageSuccess = onCreateSuccessView();
            if (mPageSuccess != null) {
                addView(mPageSuccess);
            }
        }
    }

    /**
     * 加载数据
     */
    public void loadData() {
        if (mCurrentState != STATE_LOAD_LOADING) {
            mCurrentState = STATE_LOAD_LOADING;
            new Thread() {
                @Override
                public void run() {
                    ResultState resultState = onLoad();
                    post(() -> {
                        if (resultState != null) {
                            mCurrentState = resultState.getState();
                            showPage();
                        }
                    });
                }
            }.start();
        }

    }

    public abstract View onCreateSuccessView();

    public abstract ResultState onLoad();

    public enum ResultState {
        STATE_SUCCESS(STATE_LOAD_SUCCESS),
        STATE_EMPTY(STATE_LOAD_EMPTY),
        STATE_ERROR(STATE_LOAD_ERROR);

        private int state;

        ResultState(int loadState) {
            state = loadState;
        }

        public int getState() {
            return state;
        }
    }
}
