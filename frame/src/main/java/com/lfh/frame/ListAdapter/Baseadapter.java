package com.lfh.frame.ListAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 万能适配器
 */
public abstract class Baseadapter<T>extends BaseAdapter {

    public List<T> list;
    private Context context;
    private LayoutInflater inflater;
    private  int layout_id;
    public Baseadapter(List<T> list, Context context, int layout_id){
        this.list = list;
        this.context =context;
        inflater=LayoutInflater.from(context);
        this. layout_id = layout_id;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public T getItem(int position) {
        return list.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder =ViewHolder.get(context,convertView,parent,layout_id,position);

    convert(holder,getItem(position),position);
    return  holder.getConvertView();
}

    public  abstract  void  convert(ViewHolder holder ,T t,int p);
}
