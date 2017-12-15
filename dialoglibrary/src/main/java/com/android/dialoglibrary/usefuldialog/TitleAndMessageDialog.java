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

public class TitleAndMessageDialog extends Dialog implements View.OnClickListener{
    private TextView tvDiloagTitle;
    private Button btnDialogCancle;
    private Button btnDialogSure;
    private TextView tvDiloagMessage;
    private String title;
    private String message;
    private String cancle;
    private String sure;
    private Activity activity;

    private onBtnClickListener onBtnClickListener;

    public TitleAndMessageDialog(@NonNull Context context) {
        super(context);
    }

    public TitleAndMessageDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        activity=(Activity) context;
    }

    public TitleAndMessageDialog initBtnText(String cancleText, String sureText) {
        this.cancle = cancleText;
        this.sure = sureText;
        return this;
    }
    public TitleAndMessageDialog initTitleAndMessage(String title, String message) {
        this.title = title;
        this.message = message;
        return this;
    }
    public void setBtnText(String cancleText, String sureText) {
        this.cancle = cancleText;
        this.sure = sureText;
        setText();
    }
    public void setTitleAndMessage(String title, String message) {
        this.title = title;
        this.message = message;
        setText();
    }
    public TitleAndMessageDialog setOnBtnClickListener(TitleAndMessageDialog.onBtnClickListener onBtnClickListener) {
        this.onBtnClickListener = onBtnClickListener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usefuldialog_titleandmessage);
        initView();
        setText();
    }

    private void initView() {
        tvDiloagMessage=(TextView)findViewById(R.id.tv_diloag_message);
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
        if (!TextUtils.isEmpty(message)) {
            tvDiloagMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancle)) {
            btnDialogCancle.setText(cancle);
        }
        if (!TextUtils.isEmpty(sure)) {
            btnDialogSure.setText(sure);
        }
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
