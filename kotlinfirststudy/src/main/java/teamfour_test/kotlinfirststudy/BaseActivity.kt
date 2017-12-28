package teamfour_test.kotlinfirststudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by 曹少航 on 2017/12/28.
 */
 abstract class BaseActivity<T : GoodsPresenter> :AppCompatActivity(){
    var presenter : T?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView()
        presenter=getPresenter()
        initData()
    }
    abstract  fun layoutId():Int
    abstract  fun  initView()
    //内部的internal
    internal  abstract  fun getPresenter() : T
    abstract fun initData()

}