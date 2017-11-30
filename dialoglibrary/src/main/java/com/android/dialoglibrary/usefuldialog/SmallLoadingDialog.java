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

public class SmallLoadingDialog extends Dialog {
    private RotateLoading rotateloading;
    public SmallLoadingDialog(@NonNull Context context) {
        super(context);
    }

    public SmallLoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usefuldialog_loading_small);
        initView();
        rotateloading.start();
    }

    private void initView() {
        rotateloading=(RotateLoading)findViewById(R.id.rotateloading);
    }

}
