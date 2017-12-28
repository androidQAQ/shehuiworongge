package teamfour_test.kotlinfirststudy

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by 曹少航 on 2017/12/27.
 */
class GoodsModel {
    fun  getServerData():Flowable<List<GoodsInfo>>{
        val  retrofit =Retrofit.Builder().baseUrl(MyApi.FirstURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        val apiService =retrofit.create(ApiService::class.java)
        val  flowable =apiService.getData("26868b32e808498db32fd51fb422d00175e179df", 83)
        return flowable
    }

}