package com.example.tupianyasuo.model;

import com.example.tupianyasuo.OnFilmBeanListener;
import com.example.tupianyasuo.api.MyApi;
import com.example.tupianyasuo.bean.FilmBean;
import com.example.tupianyasuo.inter.MyService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 曹少航 on 2017/11/21.
 */

public class FilmModelImpl implements  FilmModel {
    /**
     *从网络获取数据
     * @param listener
     */
    @Override
    public void getData(final OnFilmBeanListener listener) {

        Retrofit retrofit =new Retrofit.Builder().baseUrl(MyApi.VadioURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyService service= retrofit.create(MyService.class);//生产事件
        //得到observable对象
        Observable<FilmBean> observable=service.getParam("vedio");

        observable.subscribeOn(Schedulers.io())//在IO线程做耗时操作
                    .observeOn(AndroidSchedulers.mainThread())//指定更新UI在主线程
                    .subscribe(new Observer<FilmBean>() {
                        @Override
                        public void onCompleted() {//完成
                        }
                        @Override
                        public void onError(Throwable e) {//失败
                        }
                        @Override
                        public void onNext(FilmBean filmBean) {//消费事件
                            System.out.println("xxxxxxxxxxx"+filmBean);
                            listener.OnSuccess(filmBean);
                        }
                    });

    }
}
