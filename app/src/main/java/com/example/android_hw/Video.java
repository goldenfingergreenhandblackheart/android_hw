package com.example.android_hw;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("_id")
    public String id;

    @SerializedName("feedurl")
    public String feed_url;

    @SerializedName("nickname")
    public String nickname;

    @SerializedName("description")
    public String description;

    @SerializedName("likecount")
    public int like_count;

    @SerializedName("avatar")
    public String avatar;

    @NonNull
    @Override
    public String toString() {
        return " _id: " + id +
                " feedurl: " + feed_url +
                " nickname: " + nickname +
                " description: " + description +
                " likecount: " + like_count +
                "avatar: " + avatar;
    }

}

//public class Video {
//
//    private String description;
//
//    private int imageId;
//
//    public Video(String description, int imageId){
//
//        this.description = description;
//
//        this.imageId = imageId;
//
//    }
//
//    public String getDescription() {
//
//        return description;
//
//    }
//
//    public int getImageId() {
//
//        return imageId;
//    }
//
//}
