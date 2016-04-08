package com.gohon.material;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gohon.material.Adapter.UserAdapter;
import com.gohon.material.Events.UserEvents;
import com.gohon.material.Handlers.UserHandlers;
import com.gohon.material.POJO.User;
import com.gohon.material.databinding.FragmentMainBinding;
import com.gohon.material.http.ResponseData;
import com.gohon.material.http.TransportApi;
import com.gohon.material.http.TransportParamsBody;
import com.gohon.material.http.TransportParamsHead;
import com.gohon.material.http.TransportParamsObject;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        testVolley();

        return rootView;
    }

    public void onCreateListData() {
        for (int i = 0; i < 10; i++) {
            User user = new User("name"+i,i);
            userList.add(user);
        }
        adapter.notifyDataSetChanged();
    }

    private void testVolley(){
        final Gson gson = new Gson();
        String json = "{\"head\": {\"oemid\": \"F4893DC9-D84E-4B19-96E3-3996188E6924\",\"platform\": \"IOS\",\"phone_code\": \"iPhone 6 Plus (A1522\\/A1524)\",\"version\": \"34\",\"token\": \"de3481a6aa593e98b326457327f2220f\",\"sign\": \"229eb8199f0a64d946608053a27fce79\",\"net\": \"WIFI\",\"idfa\": \"0ABE7114-BDC0-4B61-9D4C-090CA413CFBC\"},\"body\": {\"province\": \"北京\"}}";

//
        TransportParamsHead head = new TransportParamsHead();
        head.setNet("WIFI");
        head.setOemid("F4893DC9-D84E-4B19-96E3-3996188E6924");
        head.setPartner("");
        head.setPhone_code("iPhone 6 Plus (A1522\\/A1524)");
        head.setPlatform("IOS");
        head.setVersion("34");
        head.setToken("de3481a6aa593e98b326457327f2220f");
        head.setSign("229eb8199f0a64d946608053a27fce79");
        TransportParamsObject holder = new TransportParamsObject();
        holder.setHead(head);
        TransportParamsBody body = new TransportParamsBody();
        body.setProvince("北京");
        holder.setBody(body);




//        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://123.56.70.231/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        TransportApi transportApi =  retrofit.create(TransportApi.class);

        String gsonStr = gson.toJson(holder);

        Log.e("gsonStr",gsonStr);

       Call<ResponseData> call = transportApi.getData(holder);
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                Log.e("test",response.message());
                Log.e("test",response.raw().message());
                Log.e("test",gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {

            }
        });

//正确
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://10.37.63.86:8080/MDProjectServer/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        UserApi userApi = retrofit.create(UserApi.class);
//        Call<com.gohon.material.http.User> call = userApi.getUser();
//
//        call.enqueue(new Callback<com.gohon.material.http.User>() {
//            @Override
//            public void onResponse(Call<com.gohon.material.http.User> call, Response<com.gohon.material.http.User> response) {
//                Log.e("test",response.body().getName());
//            }
//
//            @Override
//            public void onFailure(Call<com.gohon.material.http.User> call, Throwable t) {
//                Log.e("test",t.toString());
//            }
//        });



    }

}
