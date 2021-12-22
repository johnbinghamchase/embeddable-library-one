package com.khomotsozwane.simple_service_library.service;

import com.khomotsozwane.simple_service_library.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/posts")
    Call<List<Post>> getPosts();

}
