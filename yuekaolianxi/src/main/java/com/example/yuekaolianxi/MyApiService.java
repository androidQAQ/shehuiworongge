package com.example.yuekaolianxi;

import com.example.yuekaolianxi.bean.MBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 曹少航 on 2017/11/22.
 */

public interface MyApiService {
    @GET("iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9")
    Observable<MBean> getParam(@Query("uri") String uri);

}
