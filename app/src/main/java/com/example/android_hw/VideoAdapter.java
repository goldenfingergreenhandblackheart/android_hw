package com.example.android_hw;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private List<Video> mVideoList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView videoImage;

        TextView description;

        ImageButton play;

        public ViewHolder(View view) {

            super(view);

            videoImage = (ImageView) view.findViewById(R.id.video_image);

            description = (TextView) view.findViewById(R.id.video_description);

            play = (ImageButton) view.findViewById(R.id.play_button);

        }

    }

    public VideoAdapter(List<Video> videoList){
        mVideoList = videoList;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {

        Video video = mVideoList.get(position);

        holder.videoImage.setImageResource(video.getImageId());

        holder.description.setText(video.getDescription());

        holder.play.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Log.d("test","Play!!!!!!!!!!!!!!!");

            }

        } );
    }

    @Override
    public int getItemCount() {
        return mVideoList.size();
    }
}
