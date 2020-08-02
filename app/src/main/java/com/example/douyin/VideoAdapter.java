package com.example.douyin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.PlayerConfig;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Bean> mDatas;
    private final PlayerConfig playerConfig;


    public VideoAdapter(Context context, ArrayList<Bean> datas) {
        mContext = context;
        mDatas = datas;

        playerConfig = new PlayerConfig.Builder()
                .enableCache()
                .usingSurfaceView()
                .savingProgress()
                .disableAudioFocus()
                .setLooping()
                .addToPlayerManager()
                .build();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.videoView.setUrl(mDatas.get(position).url);
        holder.videoView.setPlayerConfig(playerConfig);
        holder.videoView.setScreenScale(IjkVideoView.SCREEN_SCALE_CENTER_CROP);

        holder.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "onClick: " + holder.mFlag);
                if (!holder.mFlag) {
                    holder.videoView.pause();
                    holder.mPlay.setVisibility(View.VISIBLE);
                }
                else {
                    holder.videoView.start();
                    holder.mPlay.setVisibility(View.GONE);
                }
                holder.mFlag = !holder.mFlag;
                Log.d("click", "onClick: " + holder.mFlag);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public IjkVideoView videoView;
        private boolean mFlag;
        private ImageView mPlay;

        public ViewHolder(View itemView) {
            super(itemView);
            mFlag = false;
            mPlay = itemView.findViewById(R.id.iv_play);
            Log.d("holder", mPlay.toString());
            videoView = itemView.findViewById(R.id.video_view);
        }
    }
}
