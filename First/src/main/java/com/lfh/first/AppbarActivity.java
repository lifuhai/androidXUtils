package com.lfh.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/first/appbar")
public class AppbarActivity extends AppCompatActivity {
    private static final String TAG = "AppbarActivity";
    private int[] imgs = { R.drawable.timg, R.drawable.timg_1,
            R.drawable.timg_03};
    private ViewFlipper viewFlipper;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar);

        viewFlipper = findViewById(R.id.viewpager);
      LinearLayout linearLayout = findViewById(R.id.linear);

      linearLayout.setClickable(true);
      linearLayout.setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View v, MotionEvent event) {
              viewFlipper.stopFlipping();				// 点击事件后，停止自动播放
              viewFlipper.setAutoStart(false);
              return  gestureDetector.onTouchEvent(event); 		// 注册手势事件
          }
      });

        for (int i = 0; i < imgs.length; i++) { 			// 添加图片源
            ImageView iv = new ImageView(this);
            iv.setImageResource(imgs[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(iv, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        }


        viewFlipper.setAutoStart(true);			// 设置自动播放功能（点击事件，前自动播放）
        viewFlipper.setFlipInterval(3000);
        if(viewFlipper.isAutoStart() && !viewFlipper.isFlipping()){
            viewFlipper.startFlipping();
        }


        gestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() {
            //当按下时触发该方法，所有手势第一个必定触发该方法
            @Override
            public boolean onDown(MotionEvent e) {
                Log.d(TAG, "onDown: "+e.toString());
                return true;
            }

          //  当用户手指按下，但没有移动时触发该方法
            @Override
            public void onShowPress(MotionEvent e) {

                Log.d(TAG, "onShowPress: "+e.toString());
            }

            //当用户单击时触发
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.d(TAG, "onSingleTapUp: "+e.toString());
                return false;
            }
            //
            // 当用户手指在屏幕上拖动时触发
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            //当用户手指在长按屏幕时触发
            @Override
            public void onLongPress(MotionEvent e) {

            }

            //用户手指在屏幕拖动后 离开屏幕时触发
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {


                if (e2 .getY()-e1.getY()>0) {

                    Log.d(TAG, "onFling: 下滑");
                }else {
                    Log.d(TAG, "onFling: 上滑");

                }
                Log.d(TAG, "onFlingY: "+e1.getY()+"X"+e1.getX());
                Log.d(TAG, "onFlingz: "+e2.getY()+"X"+e2.getX());

                if (e2.getX() - e1.getX() > 120) {			 // 从左向右滑动（左进右出）
                    Animation rInAnim = AnimationUtils.loadAnimation(AppbarActivity.this, R.anim.push_right_in); 	// 向右滑动左侧进入的渐变效果（alpha  0.1 -> 1.0）
                    Animation rOutAnim = AnimationUtils.loadAnimation(AppbarActivity.this, R.anim.push_right_out); // 向右滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）

                    viewFlipper.setInAnimation(rInAnim);
                    viewFlipper.setOutAnimation(rOutAnim);
                    viewFlipper.showPrevious();
                    return true;
                } else if (e2.getX() - e1.getX() < -120) {		 // 从右向左滑动（右进左出）
                    Animation lInAnim = AnimationUtils.loadAnimation(AppbarActivity.this, R.anim.push_left_in);		// 向左滑动左侧进入的渐变效果（alpha 0.1  -> 1.0）
                    Animation lOutAnim = AnimationUtils.loadAnimation(AppbarActivity.this, R.anim.push_left_out); 	// 向左滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）

                    viewFlipper.setInAnimation(lInAnim);
                    viewFlipper.setOutAnimation(lOutAnim);
                    viewFlipper.showNext();
                    return true;
                }
                return true;
            }
        });

    }

}