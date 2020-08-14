package com.lfh.frame.RecyerAdapter;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyerAdapter<T> extends RecyclerView.Adapter<RecyerViewHolder> {

    private static final String TAG = "BaseRecyerAdapter";


    protected Context mContext;
    protected List<T> mDatas;
    private int layout_id;
    protected OnItemClickListener mOnItemClickListener;

    public BaseRecyerAdapter(Context context, List<T> datas, int layoutId) {
        this.mContext = context;
        this.layout_id = layoutId;
        this.mDatas = datas;
    }

    @Override
    public RecyerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyerViewHolder holder = RecyerViewHolder.createViewHolder(mContext, viewGroup, layout_id);
        setListener(viewGroup, holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyerViewHolder recyerViewHolder, int i) {
        convert(recyerViewHolder, mDatas.get(i), i);
    }

    public abstract void convert(RecyerViewHolder recyerViewHolder, T t, int postion);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    /**
     * 设置item 监听事件
     *
     * @param parent
     * @param viewHolder
     */
    protected void setListener(final ViewGroup parent, final RecyerViewHolder viewHolder) {

        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    mOnItemClickListener.onItemClick(v, viewHolder, position);
                }
            }
        });
        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    return mOnItemClickListener.onItemLongClick(v, viewHolder, position);
                }
                return false;
            }
        });
    }


    public interface OnItemClickListener {
        void onItemClick(View view, RecyclerView.ViewHolder holder, int position);

        boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

}
