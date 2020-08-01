package com.example.android_hw;

public class Video {

//    private String nickName;
//
//    private String videoUrl;
//
//    private String description;
//
//    private String avatarUrl;
//
//    private int likeCount;
//
//    private String videoId;
//
//    public Video(String videoId, String videoUrl, String nickName, String description, int likeCount, String avatarUrl){
//
//        this.videoId = videoId;
//
//        this.videoUrl = videoUrl;
//
//        this.nickName = nickName;
//
//        this.description = description;
//
//        this.likeCount = likeCount;
//
//        this.avatarUrl = avatarUrl;
//
//    }
//
//    public String getVideoId(){
//
//        return videoId;
//
//    }
//
//    public String getVideoUrl(){
//
//        return videoUrl;
//
//    }
//
//    public String getNickName(){
//
//        return nickName;
//
//    }
//
//    public String getDescription(){
//
//        return description;
//
//    }
//
//    public int getLikeCount(){
//
//        return likeCount;
//
//    }
//
//    public String getAvatarUrl(){
//
//        return avatarUrl;
//
//    }

    private String description;

    private int imageId;

    public Video(String description, int imageId){

        this.description = description;

        this.imageId = imageId;

    }

    public String getDescription() {

        return description;

    }

    public int getImageId() {

        return imageId;
    }

}
