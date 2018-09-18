package com.android.dialoglibrary.usefuldialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.dialoglibrary.EditType;
import com.android.dialoglibrary.R;
import com.android.dialoglibrary.UsefulDialogManager;

/**
 * Created by radio on 2017/9/28.
 */

public class EditDialog extends Dialog implements View.OnClickListener {
    private TextView tvDiloagTitle;
    private Button btnDialogCancle;
    private Button btnDialogSure;
    private EditText edDiloagMessage;
    private String title;
    private String cancle;
    private String sure;
    private String editText;
    private onBtnClickListener onBtnClickListener;

    public EditDialog setEditType(EditType editType) {
        this.editType = editType;
        if (editType == EditType.number) {
            edDiloagMessage.setInputType(InputType.TYPE_CLASS_NUMBER);
        }else{
            edDiloagMessage.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        return this;
    }

    private EditType editType;
    private Activity activity;
    public EditDialog(@NonNull Context context) {
        super(context);
    }

    public EditDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        activity=(Activity) context;
    }

    public EditDialog initBtnText(String cancleText, String sureText) {
        this.cancle = cancleText;
        this.sure = sureText;
        return this;
    }

    public void setEditText(String s){
        this.editText=s;
        setText();

    }
    public EditDialog initEditText(String s){
        this.editText=s;
        return this;
    }
    public EditDialog initTitle(String title) {
        this.title = title;
        return this;
    }
    public void setBtnText(String cancleText, String sureText) {
        this.cancle = cancleText;
        this.sure = sureText;
        setText();
    }

    public void setTitle(String title) {
        this.title = title;
        setText();
    }
    public EditDialog setOnBtnClickListener(EditDialog.onBtnClickListener onBtnClickListener) {
        this.onBtnClickListener = onBtnClickListener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usefuldialog_eidttext);
        initView();
        setText();
    }

    private void initView() {
        tvDiloagTitle=(TextView)findViewById(R.id.tv_diloag_title);
        btnDialogCancle=(Button)findViewById(R.id.btn_dialog_cancle);
        btnDialogCancle.setOnClickListener(this);
        btnDialogSure=(Button)findViewById(R.id.btn_dialog_sure);
        btnDialogSure.setOnClickListener(this);
        edDiloagMessage=(EditText)findViewById(R.id.ed_diloag_message);
        if (UsefulDialogManager.getInstance().getEditType()!=null) {
            if (UsefulDialogManager.getInstance().getEditType() == EditType.number) {
                edDiloagMessage.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
        }
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
        if (!TextUtils.isEmpty(editText)) {
            edDiloagMessage.setText(editText);
            edDiloagMessage.setSelection(editText.length());
        }else{
            edDiloagMessage.setText("");
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
                onBtnClickListener.onSure(edDiloagMessage.getText().toString());
                dismiss();
            }
        }
    }

    public interface onBtnClickListener {
        void onSure(String message);
        void onCancle();
    }
}
