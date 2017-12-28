package teamfour_test.kotlinfirststudy

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by 曹少航 on 2017/12/27.
 */
interface ApiService {
    @GET("categories")
    fun getData(@Query("udid") udid:String, @Query("vc") vc :Int ): Flowable<List<GoodsInfo>>

}