package com.android.dialoglibrary.usefuldialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.dialoglibrary.R;
import com.android.dialoglibrary.UsefulDialogManager;


/**
 * Created by radio on 2017/9/28.
 */

public class OneTitleDialog extends Dialog implements View.OnClickListener{
    private TextView tvDiloagTitle;
    private Button btnDialogCancle;
    private Button btnDialogSure;
    private String title;
    private String cancle;
    private String sure;
    private Activity activity;

    private onBtnClickListener onBtnClickListener;

    public OneTitleDialog(@NonNull Context context) {
        super(context);
    }

    public OneTitleDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        activity=(Activity) context;
    }

    public OneTitleDialog initTitle(String title, String cancleText, String sureText) {
        this.title = title;
        this.cancle=cancleText;
        this.sure=sureText;
        return this;
    }
    public void setTitle(String title, String cancleText, String sureText) {
        this.title = title;
        this.cancle=cancleText;
        this.sure=sureText;
        setText();
    }

    public OneTitleDialog setOnBtnClickListener(OneTitleDialog.onBtnClickListener onBtnClickListener) {
        this.onBtnClickListener = onBtnClickListener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usefuldialog_onetitle);
        initView();
        setText();
    }

    private void initView() {
        tvDiloagTitle=(TextView)findViewById(R.id.tv_diloag_title);
        btnDialogCancle=(Button)findViewById(R.id.btn_dialog_cancle);
        btnDialogCancle.setOnClickListener(this);
        btnDialogSure=(Button)findViewById(R.id.btn_dialog_sure);
        btnDialogSure.setOnClickListener(this);
        if (UsefulDialogManager.getInstance().getBtnCancleColor()!=0){
            btnDialogCancle.setTextColor(activity.getResources().getColor(UsefulDialogManager.getInstance().getBtnCancleColor()));
        }
        if (UsefulDialogManager.getInstance().getBtnSureColor()!=0){
            btnDialogSure.setTextColor(activity.getResources().getColor(UsefulDialogManager.getInstance().getBtnSureColor()));
        }
    }

    private void setText() {
        if (!TextUtils.isEmpty(title)) {
            tvDiloagTitle.setText(title);
        }
        if (!TextUtils.isEmpty(cancle)) {
            btnDialogCancle.setText(cancle);
        }
        if (!TextUtils.isEmpty(sure)) {
            btnDialogSure.setText(sure);
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_dialog_cancle) {
            if (onBtnClickListener != null) {
                onBtnClickListener.onCancle();
                dismiss();
            }

        } else if (i == R.id.btn_dialog_sure) {
            if (onBtnClickListener != null) {
                onBtnClickListener.onSure();
                dismiss();
            }

        }
    }

    public interface onBtnClickListener {
        void onSure();

        void onCancle();
    }
}
