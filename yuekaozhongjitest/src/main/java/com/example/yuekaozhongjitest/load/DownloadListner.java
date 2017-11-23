package com.example.yuekaozhongjitest.load;

/**
 * Created by 曹少航 on 2017/11/23.
 */

public interface  DownloadListner {
    void onFinished();

    void onProgress(float progress);

    void onPause();

    void onCancel();
}
