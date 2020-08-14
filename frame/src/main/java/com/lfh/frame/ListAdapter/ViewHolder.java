package com.lfh.frame.ListAdapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * 万能Horder
 */
public class ViewHolder {
	private final SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;

	private ViewHolder(Context context, ViewGroup parent, int layoutId,
                       int position) {
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
				false);
		// setTag
		mConvertView.setTag(this);
	}

	/**
	 * 拿到一个ViewHolder对象
	 * 
	 * @param context
	 * @param convertView
	 * @param parent
	 * @param layoutId
	 * @param position
	 * @return
	 */
	public static ViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {
			return new ViewHolder(context, parent, layoutId, position);
		}
		return (ViewHolder) convertView.getTag();
	}

	public View getConvertView() {
		return mConvertView;
	}

	/**
	 * 通过控件的Id获取对于的控件，如果没有则加入views
	 * 
	 * @param viewId
	 * @return
	 */
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	/**
	 * 为TextView设置字符串
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public ViewHolder setText(int viewId, CharSequence text) {
		TextView view = getView(viewId);
		view.setText(text);
		return this;
	}
	public ViewHolder setText1(int viewId, String text) {
		TextView view = getView(viewId);
		view.setText(text);
		return this;
	}

    public ViewHolder setProgress(int viewId,int progress){
       ProgressBar bar =  getView(viewId);
        bar.setProgress(progress);
        return this;
    }
	/**
	 * 为ImageView设置图片
	 *
	 * @param viewId
	 * @param drawableId
	 * @return
	 */
	public ViewHolder setImageResource(int viewId, int drawableId) {
		ImageView view = getView(viewId);
		view.setImageResource(drawableId);
		return this;
	}

	/**
	 * 显示隐藏view
	 * 
	 * @param viewId
	 * @param visibility
	 * @return
	 */
	public ViewHolder setVisibility(int viewId, int visibility) {
		View view = getView(viewId);
		view.setVisibility(visibility);
		return this;
	}



	/**
	 * 
	 * 为ImageView设置图片
	 * 
	 * @param
	 * @param viewId
	 * @param
	 * @return
	 * 
	 */





	public ViewHolder setImageByUrl(int viewId, String url) {

		if (!TextUtils.isEmpty(url)) {
//			x.image().bind((ImageView) getView(viewId), url);


//			Glides.Image(url,(ImageView) getView(viewId));
		}
		return this;
	}



	public int getPosition() {
		// return mViews.indexOfValue(mConvertView);
		return mPosition;
	}

}