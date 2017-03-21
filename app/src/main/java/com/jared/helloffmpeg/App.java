package com.jared.helloffmpeg;

import android.app.Application;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;

/**
 * Created by 00013811 on 2017/3/21.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //setContentView(R.layout.activity_main);
        BmobConfig config =new BmobConfig.Builder(getApplicationContext())
                //请求超时时间（单位为秒）：默认15s
                .setConnectTimeout(30)
                //文件分片上传时每片的大小（单位字节），默认512*1024
                .setUploadBlockSize(500*1024)
                .setApplicationId("26d404d814cb46c2071ce52fdaf80500")
                .build();
        Bmob.initialize(config);
    }
}
