package fm.material.weather.materialweather.utils;

import android.view.View;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by fm on 2016/2/23.
 */
public class AnimationUtil {

    private static AnimatorSet mAnimatorSet;

    private static AnimatorSet getAnimatorSet() {
        if (mAnimatorSet == null) {
            mAnimatorSet = new AnimatorSet();
        }
        return mAnimatorSet;
    }

    //View渐现
    public static void fadeIn(View view, int duration) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(duration)
        );
        getAnimatorSet().start();
    }

    //View渐隐
    public static void fadeOut(View view, int duration) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view, "alpha", 1, 0).setDuration(duration)
        );
        getAnimatorSet().start();
    }

    //View渐现并且从大变成正常
    public static void fall(View view, int duration) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.5f).setDuration(duration),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.5f).setDuration(duration),
                ObjectAnimator.ofFloat(view, "alpha", 1, 0.6f).setDuration(duration * 3 / 2)
        );
        getAnimatorSet().start();
    }


    //重置View的动画
    public static void reset(View view) {
        ViewHelper.setAlpha(view, 1);
        ViewHelper.setRotationX(view, 1);
        ViewHelper.setRotation(view, 1);
        ViewHelper.setScaleX(view, 1);
        ViewHelper.setScaleY(view, 1);
//        ViewHelper.setPivotX(view, view.getMeasuredWidth() / 2.0f);
//        ViewHelper.setPivotY(view, view.getMeasuredHeight() / 2.0f);
    }


}
