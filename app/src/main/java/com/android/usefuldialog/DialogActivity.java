package com.android.usefuldialog;

import android.content.Intent;
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


public class DialogActivity extends AppCompatActivity {

    @BindView(R.id.btn_loading)
    Button btnLoading;
    @BindView(R.id.btn_title)
    Button btnTitle;
    @BindView(R.id.btn_title_message)
    Button btnTitleMessage;
    @BindView(R.id.btn_edittext)
    Button btnEdittext;
    @BindView(R.id.btn_date)
    Button btnDate;
    @BindView(R.id.btn_list_one)
    Button btnListOne;
    @BindView(R.id.btn_list_two)
    Button btnListTwo;
    @BindView(R.id.btn_small_loading)
    Button btnSmallLoading;
    @BindView(R.id.btn_next)
    Button btnNext;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(!isFinishing()){
            super.handleMessage(msg);
            if (msg.what == 10) {
                UsefulDialogManager.getInstance().closeDialog(DialogActivity.this);
            }
        }}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_loading, R.id.btn_title,R.id.btn_next, R.id.btn_small_loading, R.id.btn_title_message, R.id.btn_edittext, R.id.btn_date, R.id.btn_list_one, R.id.btn_list_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                startActivity(new Intent(this,SecondActivity.class));
                break;
            case R.id.btn_small_loading:
                UsefulDialogManager.getInstance().showSmallLoadingDialog(this, true);
                break;
            case R.id.btn_loading:
                UsefulDialogManager.getInstance().showLoadingDialog(this, "加载中 ...", true);

                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(3000);
                            handler.sendEmptyMessage(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                break;
            case R.id.btn_title:
                UsefulDialogManager.getInstance().showOneTitleDialog(this, "确认要提交吗?", "再想想", "提交", new OneTitleDialog.onBtnClickListener() {
                    @Override
                    public void onSure() {
                        Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancle() {
                        Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_title_message:
                UsefulDialogManager.getInstance().showTitleAndMessageDialog(this, "提示", "确认要提交吗？", "再想想", "提交", new TitleAndMessageDialog.onBtnClickListener() {
                    @Override
                    public void onSure() {
                        Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancle() {
                        Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_edittext:
                UsefulDialogManager.getInstance().showEditDialog(this, "请填写内容", "取消", "确定", new EditDialog.onBtnClickListener() {
                    @Override
                    public void onSure(String message) {
                        Toast.makeText(DialogActivity.this, "输入内容为：" + message, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancle() {
                        Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_date:
                Calendar startDate = Calendar.getInstance();
                Calendar endDate = Calendar.getInstance();
                Calendar nowDate = Calendar.getInstance();
                boolean []type=new boolean[]{true,true,true,false,false,false};
                endDate.set(2100, 12, 31);
                UsefulDialogManager.getInstance().showDateDialog(this, startDate, endDate,nowDate,type, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        Toast.makeText(DialogActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_list_one:
                List<String> list1 = new ArrayList<>();
                list1.add("测试 1");
                list1.add("测试 2");
                list1.add("测试 3");
                list1.add("测试 4");
                UsefulDialogManager.getInstance().showListDialog(this, list1, new ListDialog.onDialogListItemClickListener() {
                    @Override
                    public void onClick(int position, String itemContent) {
                        Toast.makeText(DialogActivity.this, position + "=" + itemContent, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_list_two:
                List<String> list2 = new ArrayList<>();
                list2.add("测试 111");
                list2.add("测试 222");
                list2.add("测试 333");
                list2.add("测试 444");
                list2.add("测试 555");
                list2.add("测试 666");
                list2.add("测试 777");
                list2.add("测试 888");
                UsefulDialogManager.getInstance().showListDialog(this, list2, new ListDialog.onDialogListItemClickListener() {
                    @Override
                    public void onClick(int position, String itemContent) {
                        Toast.makeText(DialogActivity.this, position + "=" + itemContent, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }

    public String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//时间显示样式，可选
        return format.format(date);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UsefulDialogManager.getInstance().closeDialog(this);
    }
}
