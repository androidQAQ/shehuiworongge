package com.example.yuekaolianxi.model;

import com.example.yuekaolianxi.MyApiService;
import com.example.yuekaolianxi.OnFinishListener;
import com.example.yuekaolianxi.utils.RetrofitUtils;
import com.example.yuekaolianxi.bean.MBean;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 曹少航 on 2017/11/22.
 */

public class MModelImpl implements MModel {
    @Override
    public void getData(final OnFinishListener listener) {
        String URL="http://result.eolinker.com/";

        //进行网络请求
        Retrofit retrofit = RetrofitUtils.getRetrofit(URL);
        MyApiService myApiService = retrofit.create(MyApiService.class);

        Observable<MBean> observable=  myApiService.getParam("vedio");

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MBean>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MBean mBean) {

                       listener.OnSuccess(mBean);

                    }
                });
    }
}
