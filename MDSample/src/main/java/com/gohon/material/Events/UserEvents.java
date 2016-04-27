/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:53:10
 */

package com.gohon.material.events;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gohon.material.MainActivityFragment;
import com.gohon.material.pojo.User;

/**
 * Created by liuyonglong on 16/3/23.
 */
public class UserEvents implements Runnable{
    private MainActivityFragment mainActivityFragment;
    private Handler handler = new Handler();
    private User user;

    public UserEvents(MainActivityFragment mainActivityFragment,  User user){
        this.mainActivityFragment = mainActivityFragment;
        this.user = user;
    }


    public void onInputEvent(View view){
        Toast.makeText(mainActivityFragment.getContext(),user.getFile(),Toast.LENGTH_SHORT).show();
        mainActivityFragment.onCreateListData();

    }


    public void onStartEvent(View view){
        handler.postDelayed(this,3000);
    }

    public void onStopEvent(View view){
        handler.removeCallbacks(this);
        Log.e("UserEvents","remove");
        Toast.makeText(mainActivityFragment.getContext(),"remove",Toast.LENGTH_SHORT).show();
    }

    public TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
//            text.set(s.toString());
            user.setFile(s.toString());
        }
    };

    @Override
    public void run() {
        Log.e("UserEvents","running....");
        Toast.makeText(mainActivityFragment.getContext(),"running....",Toast.LENGTH_SHORT).show();
    }
}
