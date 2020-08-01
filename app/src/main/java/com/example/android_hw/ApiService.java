package com.example.android_hw;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/invoke/video/invoke/video")
    Call<List<Video>> getVideos();

}
