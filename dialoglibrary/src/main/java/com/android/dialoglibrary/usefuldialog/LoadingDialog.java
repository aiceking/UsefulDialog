package com.android.dialoglibrary.usefuldialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.widget.TextView;

import com.android.dialoglibrary.R;
import com.victor.loading.rotate.RotateLoading;

/**
 * Created by radio on 2017/9/27.
 */

public class LoadingDialog extends Dialog {
    private TextView tvDiloagTitle;
    private RotateLoading rotateloading;

    private String title;

    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    public LoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    public LoadingDialog initTitle(String title) {
        this.title = title;
        return this;
    }
    public void setTitle(String title) {
        this.title = title;
        if (!TextUtils.isEmpty(title)) {
            tvDiloagTitle.setText(title);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usefuldialog_loading);
        initView();
        rotateloading.start();
        if (!TextUtils.isEmpty(title)) {
            tvDiloagTitle.setText(title);
        }
    }

    private void initView() {
        rotateloading=(RotateLoading)findViewById(R.id.rotateloading);
        tvDiloagTitle=(TextView)findViewById(R.id.tv_diloag_title);
    }

}
