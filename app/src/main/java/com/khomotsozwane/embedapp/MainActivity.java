package com.khomotsozwane.embedapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.khomotsozwane.embedapp.adapters.SimpleAdapter;
import com.khomotsozwane.simple_service_library.models.Post;
import com.khomotsozwane.simple_service_library.service.ApiFunctions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public RecyclerView recyclerView;
    public TextView simpleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        simpleView = findViewById(R.id.simple_message);

        final Context context = this;

        ApiFunctions.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(response.isSuccessful()){
                    simpleView.setVisibility(View.GONE);

                    for(Post posts : response.body()){
                        Log.d(TAG, "onResponse: ikhom posts [ " + posts.getTitle() + " ]");
                    }

                    SimpleAdapter simpleAdapter = new SimpleAdapter(context, response.body());
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(simpleAdapter);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, "onFailure: ikhom something went wrong " + t.getMessage());
                recyclerView.setVisibility(View.GONE);
                simpleView.setText(t.getMessage());
            }
        });

        /*
        ApiClientMethods.getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(response.isSuccessful()){
                    simpleView.setVisibility(View.GONE);

                    for(Posts posts : response.body()){
                        Log.d(TAG, "onResponse: ikhom posts [ " + posts.getTitle() + " ]");
                    }

                    SimpleAdapter simpleAdapter = new SimpleAdapter(context, response.body());
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(simpleAdapter);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Log.d(TAG, "onFailure: ikhom something went wrong " + t.getMessage());
                recyclerView.setVisibility(View.GONE);
                simpleView.setText(t.getMessage());
            }
        });

         */
    }
}