package com.gohon.material.mduisdk.weight.progressBar.sample;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.gohon.material.mduisdk.R;
import com.gohon.material.mduisdk.weight.progressBar.NexusRotationCrossDrawable;

/**
 * Created by liuyonglong on 16/5/13.
 */
public class GoogProgressBarSample extends Fragment {
    private Drawable drawable;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.drawable = new NexusRotationCrossDrawable.Builder(getContext()).colors(getResources().getIntArray(R.array.google_colors)).build();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sample_progressbar_google, container, false);
        ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.progress);
        progressBar.setIndeterminateDrawable(drawable);
        return rootView;
    }
}
