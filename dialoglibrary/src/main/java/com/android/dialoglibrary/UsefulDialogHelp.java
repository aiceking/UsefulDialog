package com.android.dialoglibrary;

import android.app.Activity;
import android.content.Context;

import com.android.dialoglibrary.usefuldialog.EditDialog;
import com.android.dialoglibrary.usefuldialog.ListDialog;
import com.android.dialoglibrary.usefuldialog.LoadingDialog;
import com.android.dialoglibrary.usefuldialog.OneTitleDialog;
import com.android.dialoglibrary.usefuldialog.SmallLoadingDialog;
import com.android.dialoglibrary.usefuldialog.TitleAndMessageDialog;
import com.bigkoo.pickerview.TimePickerView;

import java.util.Calendar;
import java.util.List;

/**
 * Created by radio on 2017/9/19.
 */

public class UsefulDialogHelp {
    private static UsefulDialogHelp dialogHelp;
    private LoadingDialog loadingDialog;
    private OneTitleDialog oneTitleDialog;
    private EditDialog editDialog;
    private TitleAndMessageDialog titleAndMessageDialog;
    private ListDialog listDialog;
    private SmallLoadingDialog smallLoadingDialog;
    public static UsefulDialogHelp getInstance(){
        if (dialogHelp==null){
            synchronized (UsefulDialogHelp.class){
                if (dialogHelp==null){
                    dialogHelp=new UsefulDialogHelp();
                }
            }
        }
        return dialogHelp;
    }
    /**ListView的dialog*/
    public void showListDialog(Activity activity, List<String> list, ListDialog.onDialogListItemClickListener onDialogListItemClickListener){
        try{
             listDialog=new ListDialog(activity, R.style.useful_dialog).setOnDialogListItemClickListener(onDialogListItemClickListener);
             listDialog.show();
             listDialog.setList(list);
        }catch (Exception e){
        }
    }
    /**带输入框的dialog*/
    public  void showEditDialog(Activity activity, String title, String cancleText, String sureText,EditDialog.onBtnClickListener listener){
        try {
                editDialog=new EditDialog(activity, R.style.useful_dialog).initTitle(title)
                        .initBtnText(cancleText,sureText)
                        .setOnBtnClickListener(listener);
                editDialog.show();
        }catch (Exception e){

        }
    }
    /**带输入框的dialog,有预输入内容*/
    public  void showEditDialog(Activity activity, String title, String cancleText, String sureText,String editText,EditDialog.onBtnClickListener listener){
        try {
                editDialog=new EditDialog(activity, R.style.useful_dialog).initTitle(title)
                        .initBtnText(cancleText,sureText)
                        .setOnBtnClickListener(listener);
                editDialog.show();
                editDialog.setEditText(editText);
        }catch (Exception e){
        }
    }
    /**带Title和message的dialog*/
    public  void showTitleAndMessageDialog(Activity activity, String title,String message, String cancleText, String sureText,TitleAndMessageDialog.onBtnClickListener listener){
        try {
                titleAndMessageDialog=new TitleAndMessageDialog(activity, R.style.useful_dialog).initTitleAndMessage(title,message)
                        .initBtnText(cancleText,sureText)
                        .setOnBtnClickListener(listener);
                titleAndMessageDialog.show();

        }catch (Exception e){
        }
    }
    /**只有Title的dialog*/
    public  void showOneTitleDialog(Activity activity, String title, String cancleText, String sureText,OneTitleDialog.onBtnClickListener listener){
        try {
            oneTitleDialog=new OneTitleDialog(activity, R.style.useful_dialog).initTitle(title,cancleText,sureText)
            .setOnBtnClickListener(listener);
            oneTitleDialog.show();

        }catch (Exception e){

        }
    }
    /**加载的dialog*/
    public  void showLoadingDialog(Activity activity, String title,boolean cancle){
        try {
                loadingDialog=new LoadingDialog(activity, R.style.useful_dialog).initTitle(title);
                loadingDialog.setCancelable(cancle);
                loadingDialog.show();
        }catch (Exception e){

        }
    }
    /**加载的dialog*/
    public  void showSmallLoadingDialog(Activity activity,boolean cancle){
        try {
                smallLoadingDialog=new SmallLoadingDialog(activity, R.style.useful_small_loadingdialog);
                smallLoadingDialog.setCancelable(cancle);
                smallLoadingDialog.show();
        }catch (Exception e){

        }
    }
    public  void showDateDialog(Context activity, Calendar startDate, Calendar endDate, TimePickerView.OnTimeSelectListener onTimeSelectListener){
        TimePickerView pvTime = new TimePickerView.Builder(activity, onTimeSelectListener)
                .setContentSize(23) .setType(new boolean[]{true, true, true, false, false, false}).setRangDate(startDate, endDate).build();
        pvTime.setDate(Calendar.getInstance());
        pvTime.show();
    }
    public void closeLoadingDialog(){
        try {
        if (loadingDialog!=null){
            if (loadingDialog.isShowing()){
                loadingDialog.dismiss();
            }
        }
        }catch (Exception e){

        }
    }
    public void closeSmallLoadingDialog(){
        try {
            if (smallLoadingDialog!=null){
                if (smallLoadingDialog.isShowing()){
                    smallLoadingDialog.dismiss();
                }
            }
        }catch (Exception e){

        }

    }
}
