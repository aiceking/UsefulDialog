package com.android.usefuldialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OtherActivity extends AppCompatActivity {

    @BindView(R.id.btn_new)
    Button btnNew;
    @BindView(R.id.btn_old)
    Button btnOld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_new, R.id.btn_old})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_new:
                break;
            case R.id.btn_old:
                break;
        }
    }
}
