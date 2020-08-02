package com.example.douyin;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.VideoViewManager;
import com.example.douyin.widget.OnViewPagerListener;
import com.example.douyin.widget.PagerLayoutManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Bean> mDatas = new ArrayList<>();
    private VideoAdapter mAdapter;
    private IjkVideoView mVideoView;
    private List<Video> videoList = new ArrayList<Video>();

    public interface MyCallback {
        void onDataGot(List<Video> videos);
    }

    private void getData(MyCallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://beiyou.bytedance.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Video>> videos = apiService.getVideos();
        videos.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                if (response.body() != null) {
                    callback.onDataGot(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Log.d("retrofit", t.getMessage());
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context con = this;
        getData(new MyCallback() {
            @Override
            public void onDataGot(List<Video> videos) {
                videoList = videos;

                recyclerView = findViewById(R.id.recycler_view);
                PagerLayoutManager mLayoutManager = new PagerLayoutManager(con, OrientationHelper.VERTICAL);
                mDatas.addAll(DataUtils.getDatas(videoList));
                mAdapter = new VideoAdapter(con, mDatas);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(mAdapter);

                mLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
                    @Override
                    public void onInitComplete(View view) {
                        playVideo(0, view);
                    }

                    @Override
                    public void onPageSelected(int position, boolean isBottom, View view) {
                        playVideo(position, view);
                    }

                    @Override
                    public void onPageRelease(boolean isNext, int position, View view) {
                        int index = 0;
                        if (isNext) {
                            index = 0;
                        } else {
                            index = 1;
                        }
                        releaseVideo(view);
                    }


                });
            }
        });

    }

    private void playVideo(int position, View view) {
        if (view != null) {
            mVideoView = view.findViewById(R.id.video_view);
            mVideoView.start();
        }
    }

    private void releaseVideo(View view) {
        if (view != null) {
            IjkVideoView videoView = view.findViewById(R.id.video_view);
            videoView.stopPlayback();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mVideoView != null) {
            mVideoView.resume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mVideoView != null) {
            mVideoView.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VideoViewManager.instance().releaseVideoPlayer();
    }
}
