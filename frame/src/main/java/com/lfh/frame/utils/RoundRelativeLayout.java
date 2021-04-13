package com.lfh.frame.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.lfh.frame.R;


/**
 * 圆形线性布局
 */

public class RoundRelativeLayout extends RelativeLayout {

    private Context mContext;
    private int[] shapeTypes = new int[]{GradientDrawable.RECTANGLE, GradientDrawable.OVAL, GradientDrawable.LINE, GradientDrawable.RING};
    private GradientDrawable gd;
    private int solidColor;

    public RoundRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundRelativeLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRelativeLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundRelativeLayout);
        //显示类型
        int shapeTpe = a.getInt(R.styleable.RoundRelativeLayout_viewShapeTpe, shapeTypes[0]);
        //圆角大小
        float cornerRadius = a.getLayoutDimension(R.styleable.RoundRelativeLayout_viewCornerRadius, 0);

        float topLeftRadius = a.getLayoutDimension(R.styleable.RoundRelativeLayout_viewTopLeftRadius, 0);
        float topRightRadius = a.getLayoutDimension(R.styleable.RoundRelativeLayout_viewTopRightRadius, 0);
        float bottomLeftRadius = a.getLayoutDimension(R.styleable.RoundRelativeLayout_viewBottomLeftRadius, 0);
        float bottomRightRadius = a.getLayoutDimension(R.styleable.RoundRelativeLayout_viewBottomRightRadius, 0);

        //填充色
        solidColor = a.getColor(R.styleable.RoundRelativeLayout_viewSolidColor, 0x0);
        //边框
        int strokeColor = a.getColor(R.styleable.RoundRelativeLayout_viewStrokeColor, 0x0);
        int strokeWidth = a.getDimensionPixelSize(R.styleable.RoundRelativeLayout_viewStrokeWidth, 0);
        int strokeDashWidth = a.getDimensionPixelSize(R.styleable.RoundRelativeLayout_viewStrokeDashWidth, 0);
        int strokeDashGap = a.getDimensionPixelSize(R.styleable.RoundRelativeLayout_viewStrokeDashGap, 0);

        a.recycle();

        gd = new GradientDrawable();

        gd.setColor(solidColor);
        //设置类型
        gd.setShape(shapeTypes[shapeTpe]);
        //类型为矩形才可设置圆角
        if (shapeTypes[shapeTpe] == GradientDrawable.RECTANGLE) {
            if (cornerRadius != 0) {
                gd.setCornerRadius(cornerRadius);
            } else {
                gd.setCornerRadii(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius});
            }
        }

        gd.setStroke(strokeWidth, strokeColor, strokeDashWidth, strokeDashGap);


        setBackground(gd);
    }

//    /**
//     * 设置边框宽度
//     *
//     * @param withSize 宽度
//     */
//    public void setBorderStrokeWidth(int withSize, int color) {
//        gd.setStroke(Tools.dp2px(mContext, 2), Color.parseColor("#ffffff"), 0, 0);
//        invalidate();
//    }
    public  void  setSoidColor(int color){

        this.solidColor=color;

        gd.setColor(solidColor);
        setBackground(gd);
        invalidate();
    }

}
