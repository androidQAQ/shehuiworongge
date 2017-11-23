package com.example.yuekaozhongjitest.model;

import com.example.yuekaozhongjitest.OnSuccessful;
import com.example.yuekaozhongjitest.api.MyApi;
import com.example.yuekaozhongjitest.bean.FilmBean;
import com.example.yuekaozhongjitest.inter.MyApiService;
import com.example.yuekaozhongjitest.utils.RetrofitUtils;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 曹少航 on 2017/11/23.
 */

public class FModelImpl implements  FModel {
    @Override
    public void getData(final OnSuccessful successful) {

        Retrofit retrofit = RetrofitUtils.getRetrofit(MyApi.HttpApi);

        MyApiService service = retrofit.create(MyApiService.class);

        Observable<FilmBean> observable=  service.getFilm("vedio");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FilmBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FilmBean filmBean) {
                        successful.Success(filmBean);

                    }
                });
    }
}
