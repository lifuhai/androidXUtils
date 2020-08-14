package com.lfh.utils.adapter;

import android.content.Context;
import android.util.Log;

import com.lfh.frame.RecyerAdapter.BaseRecyerAdapter;
import com.lfh.frame.RecyerAdapter.RecyerViewHolder;
import com.lfh.utils.R;

import java.util.List;

public class RecyerAdapter extends BaseRecyerAdapter<String> {
    public RecyerAdapter(Context context, List<String> datas) {
        super(context, datas, R.layout.item_list);


    }

    @Override
    public void convert(RecyerViewHolder recyerViewHolder, String s, int postion) {
        recyerViewHolder.setText(R.id.tv_lv,s);
        Log.d("cccccccccccccccc", "convert: "+s);
   
    }
}
