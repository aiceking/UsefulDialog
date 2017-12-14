package com.android.dialoglibrary.usefuldialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.widget.TextView;

import com.android.dialoglibrary.R;
import com.victor.loading.rotate.RotateLoading;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by radio on 2017/9/27.
 */

public class GifLoadingDialog extends Dialog {
    private TextView textView;
    private GifImageView gifImageView;
    private int gif;
    private String title;
    public GifLoadingDialog(@NonNull Context context) {
        super(context);
    }

    public GifLoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }
    public GifLoadingDialog initGif(@DrawableRes int gif){
        this.gif=gif;
        return this;
    }
    public void setGif(@DrawableRes int gif){
        this.gif=gif;
        setView();
    }
    public GifLoadingDialog initTitle(String title){
        this.title=title;
        return this;
    }
    public void setTitle(String title){
        this.title=title;
        setView();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usefuldialog_loading_gif);
        initView();
        setView();
    }

    private void setView() {
        if (gif!=0){
            gifImageView.setImageResource(gif);
        }
        if (!TextUtils.isEmpty(title)){
            textView.setText(title);
        }
    }

    private void initView() {
        textView=(TextView)findViewById(R.id.tv_diloag_title);
        gifImageView=(GifImageView)findViewById(R.id.loading_gifview);
    }

}
