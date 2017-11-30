package com.android.usefuldialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.android.dialoglibrary.UsefulDialogHelp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.btn_small_loading)
    Button btnSmallLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_small_loading)
    public void onViewClicked() {
        UsefulDialogHelp.getInstance().showSmallLoadingDialog(this, true);
    }
}
