package com.android.usefuldialog.application;

import android.app.Application;

import com.android.dialoglibrary.UsefulDialogManager;
import com.android.usefuldialog.R;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by static on 2017/12/13/013.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        UsefulDialogManager.getInstance().setBtnColor(R.color.colorPrimary,R.color.colorAccent);
    }
}
