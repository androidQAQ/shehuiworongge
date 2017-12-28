package teamfour_test.kotlinfirststudy

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by 曹少航 on 2017/12/27.
 */
class GoodsPresenter (goodsView: GoodView) {
    val model:GoodsModel?= GoodsModel()

    val goodsView :GoodView?=goodsView
    //p跟m关联
    fun pm(){
        val flowable =model!!.getServerData()

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<List<GoodsInfo>>(){
                    override fun onError(t: Throwable?) {

                    }
                    override fun onComplete() {

                    }

                    override fun onNext(t: List<GoodsInfo>?) {
                        //把数据给view
                        goodsView!!.showData(t!!)
                    }

                })
    }

}