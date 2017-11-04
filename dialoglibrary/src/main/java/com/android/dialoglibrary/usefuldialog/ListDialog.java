package com.android.dialoglibrary.usefuldialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.dialoglibrary.R;
import com.android.dialoglibrary.adapter.UsefulDialogStringListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by radio on 2017/9/28.
 */

public class ListDialog extends Dialog  {
private List<String> list_strings;
private UsefulDialogStringListAdapter adapter;
private ListView lv;
private Context context;

    public ListDialog setOnDialogListItemClickListener(ListDialog.onDialogListItemClickListener onDialogListItemClickListener) {
        this.onDialogListItemClickListener = onDialogListItemClickListener;
        return this;
    }

    private onDialogListItemClickListener onDialogListItemClickListener;

    public ListDialog(@NonNull Context context) {
        super(context);
    }

    public ListDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.context=context;
    }
    public ListDialog setList(List<String> list){
        if (list!=null){
            list_strings.clear();
            list_strings.addAll(list);
            adapter.notifyDataSetChanged();
        }
        return this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usefuldialog_list);
        initView();
    }
    private void initView() {
       lv=(ListView)findViewById(R.id.lv_usefuldialog);
        list_strings=new ArrayList<>();
        adapter=new UsefulDialogStringListAdapter(list_strings,context);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              if (onDialogListItemClickListener!=null){
                  onDialogListItemClickListener.onClick(i,list_strings.get(i));
              }
            }
        });
    }
    public interface onDialogListItemClickListener {
        void onClick(int position,String itemContent);
    }
}
