package com.android.dialoglibrary;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.dialoglibrary.usefuldialog.EditDialog;
import com.android.dialoglibrary.usefuldialog.GifLoadingDialog;
import com.android.dialoglibrary.usefuldialog.ListDialog;
import com.android.dialoglibrary.usefuldialog.LoadingDialog;
import com.android.dialoglibrary.usefuldialog.OneTitleDialog;
import com.android.dialoglibrary.usefuldialog.SmallLoadingDialog;
import com.android.dialoglibrary.usefuldialog.TitleAndMessageDialog;
import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by radio on 2017/9/19.
 */

public class UsefulDialogManager {
    private static UsefulDialogManager dialogHelp;
    private HashMap<Activity,LoadingDialog> loadingDialogHashMap;
    private HashMap<Activity,OneTitleDialog> oneTitleDialogHashMap;
    private HashMap<Activity,EditDialog> editDialogHashMap;
    private HashMap<Activity,TitleAndMessageDialog> titleAndMessageDialogHashMap;
    private HashMap<Activity,ListDialog> listDialogHashMap;
    private HashMap<Activity,SmallLoadingDialog> smallLoadingDialogHashMap;
    private HashMap<Activity,TimePickerView> timePickerViewHashMap;
    private HashMap<Activity,OptionsPickerView> optionsPickerViewHashMap;
    private HashMap<Activity,GifLoadingDialog> gifLoadingDialogHashMap;
    private @ColorRes int btnCancleColor;
    private @ColorRes int btnSureColor;
    public EditType getEditType() {
        return editType;
    }

    public void setEditType(EditType editType) {
        this.editType = editType;
    }

    private  EditType editType;



    public int getBtnCancleColor() {
        return btnCancleColor;
    }
    public void setBtnColor(int btnCancleColor,int btnSureColor) {
        this.btnCancleColor = btnCancleColor;
        this.btnSureColor = btnSureColor;

    }
    public int getBtnSureColor() {
        return btnSureColor;
    }
    private UsefulDialogManager(){
        loadingDialogHashMap=new HashMap<>();
        oneTitleDialogHashMap=new HashMap<>();
        editDialogHashMap=new HashMap<>();
        titleAndMessageDialogHashMap=new HashMap<>();
        listDialogHashMap=new HashMap<>();
        smallLoadingDialogHashMap=new HashMap<>();
        timePickerViewHashMap=new HashMap<>();
        optionsPickerViewHashMap=new HashMap<>();
        gifLoadingDialogHashMap=new HashMap<>();
    }
    public static UsefulDialogManager getInstance(){
        if (dialogHelp==null){
            synchronized (UsefulDialogManager.class){
                if (dialogHelp==null){
                    dialogHelp=new UsefulDialogManager();
                }
            }
        }
        return dialogHelp;
    }
    /**gif的loadingDialog*/
    public void showGifLoadingDialog(Activity activity, String title, @DrawableRes int gif,boolean cancle){
        if (!gifLoadingDialogHashMap.containsKey(activity)){
            GifLoadingDialog gifLoadingDialog=new GifLoadingDialog(activity, R.style.useful_dialog)
                    .initGif(gif).initTitle(title);
            gifLoadingDialog.setCancelable(cancle);
            gifLoadingDialog.show();
            gifLoadingDialogHashMap.put(activity,gifLoadingDialog);
        }else {
            if (!gifLoadingDialogHashMap.get(activity).isShowing()){
                gifLoadingDialogHashMap.get(activity).setCancelable(cancle);
                gifLoadingDialogHashMap.get(activity).setTitle(title);
                gifLoadingDialogHashMap.get(activity).setGif(gif);
                gifLoadingDialogHashMap.get(activity).show();
            }
        }
    }
    /**ListView的dialog*/
    public void showListDialog(Activity activity, List<String> list, ListDialog.onDialogListItemClickListener onDialogListItemClickListener){
        if (!listDialogHashMap.containsKey(activity)){
            ListDialog listDialog=new ListDialog(activity, R.style.useful_dialog).setOnDialogListItemClickListener(onDialogListItemClickListener);
            listDialog.show();
            listDialog.setList(list);
            listDialogHashMap.put(activity,listDialog);
        }else {
                if (!listDialogHashMap.get(activity).isShowing()){
                    listDialogHashMap.get(activity).setList(list);
                    listDialogHashMap.get(activity).setOnDialogListItemClickListener(onDialogListItemClickListener);
                    listDialogHashMap.get(activity).show();
                }
            }
    }
    /**带输入框的dialog*/
    public  void showEditDialog(Activity activity, String title, String cancleText, String sureText,EditDialog.onBtnClickListener listener){
        if (!editDialogHashMap.containsKey(activity)){
            EditDialog editDialog=new EditDialog(activity, R.style.useful_dialog).initTitle(title)
                    .initBtnText(cancleText,sureText).initEditText("")
                    .setOnBtnClickListener(listener);
            editDialog.show();
            editDialogHashMap.put(activity,editDialog);
        }else{

            if (!editDialogHashMap.get(activity).isShowing()){
                editDialogHashMap.get(activity).setTitle(title);
                editDialogHashMap.get(activity).setBtnText(cancleText,sureText);
                editDialogHashMap.get(activity).setOnBtnClickListener(listener);
                editDialogHashMap.get(activity).setEditText("");
                editDialogHashMap.get(activity).show();
            }
        }
    }
    /**带输入框的dialog,有预输入内容*/
    public  void showEditDialog(Activity activity, String title, String cancleText, String sureText,String editText,EditDialog.onBtnClickListener listener){
        if (!editDialogHashMap.containsKey(activity)){
            EditDialog editDialog=new EditDialog(activity, R.style.useful_dialog).initTitle(title)
                    .initBtnText(cancleText,sureText).initEditText(editText)
                    .setOnBtnClickListener(listener);
            editDialog.show();
            editDialogHashMap.put(activity,editDialog);
        }else{
            if (!editDialogHashMap.get(activity).isShowing()){
                editDialogHashMap.get(activity).setTitle(title);
                editDialogHashMap.get(activity).setBtnText(cancleText,sureText);
                editDialogHashMap.get(activity).setOnBtnClickListener(listener);
                editDialogHashMap.get(activity).setEditText(editText);
                editDialogHashMap.get(activity).show();
            }
        }
    }
    /**带Title和message的dialog*/
    public  void showTitleAndMessageDialog(Activity activity, String title,String message, String cancleText, String sureText,TitleAndMessageDialog.onBtnClickListener listener){
        if (!titleAndMessageDialogHashMap.containsKey(activity)){
            TitleAndMessageDialog titleAndMessageDialog=new TitleAndMessageDialog(activity, R.style.useful_dialog).initTitleAndMessage(title,message)
                    .initBtnText(cancleText,sureText)
                    .setOnBtnClickListener(listener);
            titleAndMessageDialog.show();
            titleAndMessageDialogHashMap.put(activity,titleAndMessageDialog);
        }else{
            if (!titleAndMessageDialogHashMap.get(activity).isShowing()){
                titleAndMessageDialogHashMap.get(activity).setTitleAndMessage(title,message);
                titleAndMessageDialogHashMap.get(activity).setBtnText(cancleText,sureText);
                titleAndMessageDialogHashMap.get(activity).setOnBtnClickListener(listener);
                titleAndMessageDialogHashMap.get(activity).show();
            }
        }
    }
    /**只有Title的dialog*/
    public  void showOneTitleDialog(Activity activity, String title, String cancleText, String sureText,OneTitleDialog.onBtnClickListener listener){
        if (!oneTitleDialogHashMap.containsKey(activity)){
            OneTitleDialog oneTitleDialog=new OneTitleDialog(activity, R.style.useful_dialog).initTitle(title,cancleText,sureText)
                    .setOnBtnClickListener(listener);
            oneTitleDialog.show();
            oneTitleDialogHashMap.put(activity,oneTitleDialog);
        }else{
            if (!oneTitleDialogHashMap.get(activity).isShowing()){
                oneTitleDialogHashMap.get(activity).setTitle(title,cancleText,sureText);
                oneTitleDialogHashMap.get(activity).setOnBtnClickListener(listener);
                oneTitleDialogHashMap.get(activity).show();
            }
        }
    }
    /**加载的dialog*/
    public  void showLoadingDialog(Activity activity, String title,boolean cancle){
        if (!loadingDialogHashMap.containsKey(activity)){
            LoadingDialog loadingDialog=new LoadingDialog(activity, R.style.useful_dialog).initTitle(title);
            loadingDialog.setCancelable(cancle);
            loadingDialog.show();
            loadingDialogHashMap.put(activity,loadingDialog);

        }else{
            if (!loadingDialogHashMap.get(activity).isShowing()){
                loadingDialogHashMap.get(activity).setCancelable(cancle);
                loadingDialogHashMap.get(activity).setTitle(title);
                loadingDialogHashMap.get(activity).show();
            }
        }

    }
    /**加载的dialog*/
    public  void showSmallLoadingDialog(Activity activity,boolean cancle){
        if (!smallLoadingDialogHashMap.containsKey(activity)){
            SmallLoadingDialog smallLoadingDialog=new SmallLoadingDialog(activity, R.style.useful_small_loadingdialog);
            smallLoadingDialog.setCancelable(cancle);
            smallLoadingDialog.show();
            smallLoadingDialogHashMap.put(activity,smallLoadingDialog);

        }else{
            if (!smallLoadingDialogHashMap.get(activity).isShowing()){
                smallLoadingDialogHashMap.get(activity).setCancelable(cancle);
                smallLoadingDialogHashMap.get(activity).show();
            }
        }
    }
    public  void showDateDialog(Activity activity, Calendar startDate, Calendar endDate,Calendar nowDate,boolean[] dateType, TimePickerView.OnTimeSelectListener onTimeSelectListener){
        if (!timePickerViewHashMap.containsKey(activity)){
        TimePickerView pvTime = new TimePickerView.Builder(activity, onTimeSelectListener)
                .setContentSize(23) .setType(dateType).setRangDate(startDate, endDate).build();
        pvTime.setDate(nowDate);
        pvTime.show();
            timePickerViewHashMap.put(activity,pvTime);
        }else{
            if (!timePickerViewHashMap.get(activity).isShowing()){
                timePickerViewHashMap.remove(activity);
                TimePickerView pvTime = new TimePickerView.Builder(activity, onTimeSelectListener)
                        .setContentSize(23) .setType(dateType).setRangDate(startDate, endDate).build();
                pvTime.setDate(nowDate);
                pvTime.show();
                timePickerViewHashMap.put(activity,pvTime);
            }
        }
    }
    public  void showSelectDialog(Activity activity, List<String> list, String title,OptionsPickerView.OnOptionsSelectListener onOptionsSelectListener){
        if (!optionsPickerViewHashMap.containsKey(activity)){
            OptionsPickerView pvOptions = new  OptionsPickerView.Builder(activity,onOptionsSelectListener).setContentTextSize(20).setTitleText(title).build();
            pvOptions.setPicker(list);
            pvOptions.show();
        }else{
            if (!optionsPickerViewHashMap.get(activity).isShowing()){
                optionsPickerViewHashMap.remove(activity);
                OptionsPickerView pvOptions = new  OptionsPickerView.Builder(activity,onOptionsSelectListener).setContentTextSize(20).setTitleText(title).build();
                pvOptions.setPicker(list);
                pvOptions.show();
                optionsPickerViewHashMap.put(activity,pvOptions);
            }
        }
    }
    public void closeDialog(Activity activity){
        if (loadingDialogHashMap.containsKey(activity)){
            if (loadingDialogHashMap.get(activity).isShowing()){
                loadingDialogHashMap.get(activity).dismiss();
            }
        }
        if (oneTitleDialogHashMap.containsKey(activity)){
            if (oneTitleDialogHashMap.get(activity).isShowing()){
                oneTitleDialogHashMap.get(activity).dismiss();
            }
        }
        if (editDialogHashMap.containsKey(activity)){
            if (editDialogHashMap.get(activity).isShowing()){
                editDialogHashMap.get(activity).dismiss();
            }
        }
        if (titleAndMessageDialogHashMap.containsKey(activity)){
            if (titleAndMessageDialogHashMap.get(activity).isShowing()){
                titleAndMessageDialogHashMap.get(activity).dismiss();
            }
        }
        if (listDialogHashMap.containsKey(activity)){
            if (listDialogHashMap.get(activity).isShowing()){
                listDialogHashMap.get(activity).dismiss();
            }
        }
        if (smallLoadingDialogHashMap.containsKey(activity)){
            if (smallLoadingDialogHashMap.get(activity).isShowing()){
                smallLoadingDialogHashMap.get(activity).dismiss();
            }
        }
        if (timePickerViewHashMap.containsKey(activity)){
            if (timePickerViewHashMap.get(activity).isShowing()){
                timePickerViewHashMap.get(activity).dismiss();
            }
        }
        if (optionsPickerViewHashMap.containsKey(activity)){
            if (optionsPickerViewHashMap.get(activity).isShowing()){
                optionsPickerViewHashMap.get(activity).dismiss();
            }
        }
        if (gifLoadingDialogHashMap.containsKey(activity)){
            if (gifLoadingDialogHashMap.get(activity).isShowing()){
                gifLoadingDialogHashMap.get(activity).dismiss();
            }
        }
    }
    public void onDestoryDialog(Activity activity){
        if (loadingDialogHashMap.containsKey(activity)){
            if (loadingDialogHashMap.get(activity).isShowing()){
                loadingDialogHashMap.get(activity).dismiss();
            }
            loadingDialogHashMap.remove(activity);
        }
        if (oneTitleDialogHashMap.containsKey(activity)){
            if (oneTitleDialogHashMap.get(activity).isShowing()){
                oneTitleDialogHashMap.get(activity).dismiss();
            }
            oneTitleDialogHashMap.remove(activity);
        }
        if (editDialogHashMap.containsKey(activity)){
            if (editDialogHashMap.get(activity).isShowing()){
                editDialogHashMap.get(activity).dismiss();
            }
            editDialogHashMap.remove(activity);
        }
        if (titleAndMessageDialogHashMap.containsKey(activity)){
            if (titleAndMessageDialogHashMap.get(activity).isShowing()){
                titleAndMessageDialogHashMap.get(activity).dismiss();
            }
            titleAndMessageDialogHashMap.remove(activity);
        }
        if (listDialogHashMap.containsKey(activity)){
            if (listDialogHashMap.get(activity).isShowing()){
                listDialogHashMap.get(activity).dismiss();
            }
            listDialogHashMap.remove(activity);
        }
        if (smallLoadingDialogHashMap.containsKey(activity)){
            if (smallLoadingDialogHashMap.get(activity).isShowing()){
                smallLoadingDialogHashMap.get(activity).dismiss();
            }
            smallLoadingDialogHashMap.remove(activity);
        }
        if (timePickerViewHashMap.containsKey(activity)){
            if (timePickerViewHashMap.get(activity).isShowing()){
                timePickerViewHashMap.get(activity).dismiss();
            }
            timePickerViewHashMap.remove(activity);
        }
        if (optionsPickerViewHashMap.containsKey(activity)){
            if (optionsPickerViewHashMap.get(activity).isShowing()){
                optionsPickerViewHashMap.get(activity).dismiss();
            }
            optionsPickerViewHashMap.remove(activity);
        }
        if (gifLoadingDialogHashMap.containsKey(activity)){
            if (gifLoadingDialogHashMap.get(activity).isShowing()){
                gifLoadingDialogHashMap.get(activity).dismiss();
            }
            gifLoadingDialogHashMap.remove(activity);
        }
    }
}
