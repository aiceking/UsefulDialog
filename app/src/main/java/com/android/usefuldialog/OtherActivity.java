package com.android.usefuldialog;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.dialoglibrary.UsefulDialogManager;
import com.android.dialoglibrary.usefuldialog.EditDialog;
import com.android.dialoglibrary.usefuldialog.ListDialog;
import com.android.dialoglibrary.usefuldialog.OneTitleDialog;
import com.android.dialoglibrary.usefuldialog.TitleAndMessageDialog;
import com.bigkoo.pickerview.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
                Calendar startDate1 = Calendar.getInstance();
                Calendar endDate1 = Calendar.getInstance();
                Calendar nowDate1 = Calendar.getInstance();
                boolean []type1=new boolean[]{false,false,false,true,true,false};
                endDate1.set(2018, 11, 31);
                UsefulDialogManager.getInstance().showDateDialog(this, startDate1, endDate1,nowDate1,type1, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        Toast.makeText(OtherActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                    }});
                break;
            case R.id.btn_old:
                Calendar startDate = Calendar.getInstance();
                Calendar endDate = Calendar.getInstance();
                Calendar nowDate = Calendar.getInstance();
                boolean []type=new boolean[]{true,true,true,false,false,false};
                startDate.set(2017, 0, 31);
                endDate.set(2019, 11, 31);
                UsefulDialogManager.getInstance().showDateDialog(this, startDate, endDate,nowDate,type, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        Toast.makeText(OtherActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
    public String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间显示样式，可选
        return format.format(date);
    }
    @Override
    protected void onDestroy() {
        UsefulDialogManager.getInstance().onDestoryDialog(this);
        super.onDestroy();
    }
}
