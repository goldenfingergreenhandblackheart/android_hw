package com.example.douyin;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {
    public static ArrayList<Bean> getDatas(List<Video> videoList) {

        ArrayList<Bean> beanList = new ArrayList<>();

        for(int i=0; i<videoList.size(); i++){

            Bean bean = new Bean(videoList.get(i).feed_url);

            beanList.add(bean);

        }

        return beanList;
    }
}
