package com.gohon.material;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gohon.material.adapter.UserAdapter;
import com.gohon.material.events.UserEvents;
import com.gohon.material.handlers.UserHandlers;
import com.gohon.material.pojo.User;
import com.gohon.material.databinding.FragmentMainBinding;
import com.gohon.material.http.UserApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    MainActivity mainActivity;
    private List<User> userList = new ArrayList<>();
    private UserAdapter adapter;


    public MainActivityFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding fragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        fragmentMainBinding.setUser(mainActivity.user);
        View rootView = fragmentMainBinding.getRoot();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new UserAdapter(userList);
        recyclerView.setAdapter(adapter);

        UserEvents events = new UserEvents(this, mainActivity.user);
        UserHandlers handlers = new UserHandlers();
        fragmentMainBinding.setEvent(events);
        fragmentMainBinding.setHandler(handlers);
        retrofit2Request();

        return rootView;
    }

    public void onCreateListData() {
        for (int i = 0; i < 10; i++) {
            User user = new User("name" + i, i);
            userList.add(user);
        }
        adapter.notifyDataSetChanged();
    }

    private void retrofit2Request() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.37.63.86:8080/MDProjectServer/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserApi userApi = retrofit.create(UserApi.class);
        Call<com.gohon.material.http.User> call = userApi.getUser();

        call.enqueue(new Callback<com.gohon.material.http.User>() {
            @Override
            public void onResponse(Call<com.gohon.material.http.User> call, Response<com.gohon.material.http.User> response) {
//                Log.e("retrofit2",response.body().getName());
            }

            @Override
            public void onFailure(Call<com.gohon.material.http.User> call, Throwable t) {
//                Log.e("retrofit2",t.toString());
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
