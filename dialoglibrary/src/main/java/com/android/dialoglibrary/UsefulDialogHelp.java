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
         if (listDialog==null){
             listDialog=new ListDialog(activity, R.style.useful_dialog).setOnDialogListItemClickListener(onDialogListItemClickListener);
             listDialog.show();
             listDialog.setList(list);
         }else{
             listDialog.setList(list);
             if (!listDialog.isShowing()){
                 listDialog.show();
             }
         }
        }catch (Exception e){
            listDialog=new ListDialog(activity, R.style.useful_dialog).setOnDialogListItemClickListener(onDialogListItemClickListener);
            listDialog.show();
            listDialog.setList(list);
        }
    }
    /**带输入框的dialog*/
    public  void showEditDialog(Activity activity, String title, String cancleText, String sureText,EditDialog.onBtnClickListener listener){
        try {
            if (editDialog==null){
                editDialog=new EditDialog(activity, R.style.useful_dialog).initTitle(title)
                        .initBtnText(cancleText,sureText)
                        .setOnBtnClickListener(listener);
                editDialog.show();
            }else{
                editDialog.setTitle(title);
                editDialog.setBtnText(cancleText,sureText);
                editDialog.ClearEdit();
                if (!editDialog.isShowing()){
                    editDialog.show();
                }
            }
        }catch (Exception e){
            editDialog=new EditDialog(activity, R.style.useful_dialog).initTitle(title)
                    .initBtnText(cancleText,sureText)
                    .setOnBtnClickListener(listener);
            editDialog.show();
        }
    }
    /**带输入框的dialog,有预输入内容*/
    public  void showEditDialog(Activity activity, String title, String cancleText, String sureText,String editText,EditDialog.onBtnClickListener listener){
        try {
            if (editDialog==null){
                editDialog=new EditDialog(activity, R.style.useful_dialog).initTitle(title)
                        .initBtnText(cancleText,sureText)
                        .setOnBtnClickListener(listener);
                editDialog.show();
                editDialog.setEditText(editText);
            }else{
                editDialog.setTitle(title);
                editDialog.setBtnText(cancleText,sureText);
                editDialog.setEditText(editText);
                if (!editDialog.isShowing()){
                    editDialog.show();
                }
            }
        }catch (Exception e){
            editDialog=new EditDialog(activity, R.style.useful_dialog).initTitle(title)
                    .initBtnText(cancleText,sureText)
                    .setOnBtnClickListener(listener);
            editDialog.show();
            editDialog.setEditText(editText);
        }
    }
    /**带Title和message的dialog*/
    public  void showTitleAndMessageDialog(Activity activity, String title,String message, String cancleText, String sureText,TitleAndMessageDialog.onBtnClickListener listener){
        try {
            if (titleAndMessageDialog==null){
                titleAndMessageDialog=new TitleAndMessageDialog(activity, R.style.useful_dialog).initTitleAndMessage(title,message)
                        .initBtnText(cancleText,sureText)
                        .setOnBtnClickListener(listener);
                titleAndMessageDialog.show();
            }else{
                titleAndMessageDialog.setTitleAndMessage(title,message);
                titleAndMessageDialog.setBtnText(cancleText,sureText);
                if (!titleAndMessageDialog.isShowing()){
                    titleAndMessageDialog.show();
                }
            }
        }catch (Exception e){
            titleAndMessageDialog=new TitleAndMessageDialog(activity, R.style.useful_dialog).initTitleAndMessage(title,message)
                    .initBtnText(cancleText,sureText)
                    .setOnBtnClickListener(listener);
            titleAndMessageDialog.show();
        }
    }
    /**只有Title的dialog*/
    public  void showOneTitleDialog(Activity activity, String title, String cancleText, String sureText,OneTitleDialog.onBtnClickListener listener){
        try {
        if (oneTitleDialog==null){
            oneTitleDialog=new OneTitleDialog(activity, R.style.useful_dialog).initTitle(title,cancleText,sureText)
            .setOnBtnClickListener(listener);
            oneTitleDialog.show();
        }else{
            oneTitleDialog.setTitle(title,cancleText,sureText);
            if (!oneTitleDialog.isShowing()){
                oneTitleDialog.show();
             }
            }
        }catch (Exception e){
            oneTitleDialog=new OneTitleDialog(activity, R.style.useful_dialog).initTitle(title,cancleText,sureText)
                    .setOnBtnClickListener(listener);
            oneTitleDialog.show();
        }
    }
    /**加载的dialog*/
    public  void showLoadingDialog(Activity activity, String title,boolean cancle){
        try {
            if (loadingDialog==null){
                loadingDialog=new LoadingDialog(activity, R.style.useful_dialog).initTitle(title);
                loadingDialog.setCancelable(cancle);
                loadingDialog.show();
            }else{
                loadingDialog.setTitle(title);
                if (!loadingDialog.isShowing()){
                    loadingDialog.show();
                }
            }
        }catch (Exception e){
            loadingDialog=new LoadingDialog(activity, R.style.useful_dialog).initTitle(title);
            loadingDialog.setCancelable(cancle);
            loadingDialog.show();
        }
    }
    /**加载的dialog*/
    public  void showSmallLoadingDialog(Activity activity,boolean cancle){
        try {
            if (smallLoadingDialog==null){
                smallLoadingDialog=new SmallLoadingDialog(activity, R.style.useful_small_loadingdialog);
                smallLoadingDialog.setCancelable(cancle);
                smallLoadingDialog.show();
            }else{
                if (!smallLoadingDialog.isShowing()){
                    smallLoadingDialog.show();
                }
            }
        }catch (Exception e){
            smallLoadingDialog=new SmallLoadingDialog(activity, R.style.useful_small_loadingdialog);
            smallLoadingDialog.setCancelable(cancle);
            smallLoadingDialog.show();
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
        } }catch (Exception e){

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
