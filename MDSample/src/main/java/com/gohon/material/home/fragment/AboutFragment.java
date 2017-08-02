package com.gohon.material.home.fragment;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

import com.gohon.material.R;

/**
 * Created by liuyonglong on 16/4/12.
 */
public class AboutFragment extends Fragment implements View.OnTouchListener{
    private Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about,container,false);
        button= (Button) rootView.findViewById(R.id.button);
        button.setOnTouchListener(this);
//        rootView.setOnTouchListener(this);

        int colorFrom = getResources().getColor(R.color.red);
        int colorTo = getResources().getColor(R.color.blue);

        ValueAnimator.ofInt();


        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(2500); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                button.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();
        return rootView;
    }

    float dX, dY;
    float color;
    float beforeX,beforeY;

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                color = view.getAlpha();
                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                beforeX = dX;
                beforeY = dY;
                break;

            case MotionEvent.ACTION_MOVE:
                view.animate()
                        .x(event.getRawX() + dX)
                        .y(event.getRawY() + dY)
                        .setDuration(0)
                        .start();



                if(event.getRawY()>beforeY){
                    color-=0.005f;
                }else{
                    color+=0.005f;
                }
                beforeY = event.getRawY();
                view.animate().alpha(color).setDuration(0).start();
                break;
            default:
                return false;
        }
        return true;
    }
}


