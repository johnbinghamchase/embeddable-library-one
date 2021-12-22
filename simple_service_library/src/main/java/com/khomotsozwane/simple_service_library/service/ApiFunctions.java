package com.khomotsozwane.simple_service_library.service;

import com.khomotsozwane.simple_service_library.models.Post;

import java.util.List;

import retrofit2.Call;

public class ApiFunctions {
    public static Call<List<Post>> getPosts(){
        return ApiClient.getApiService().getPosts();
    }
}
