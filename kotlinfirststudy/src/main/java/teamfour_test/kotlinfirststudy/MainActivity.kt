package teamfour_test.kotlinfirststudy

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :BaseActivity<GoodsPresenter>(),GoodView{

    override fun showData(goodsInfo: List<GoodsInfo>) {
     Log.i("xxxxx",goodsInfo?.get(0).name)
        var adapter=MyAdapter(this,goodsInfo)
        recycler.adapter=adapter
        adapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener{
            override fun OnItemClickListener(position: Int) {
                Toast.makeText(this@MainActivity,"点击"+position, Toast.LENGTH_LONG).show()
            }

        })

    }

    override fun layoutId(): Int =R.layout.activity_main

    override fun initView() {
        recycler.layoutManager=LinearLayoutManager(this)


    }

    override fun getPresenter(): GoodsPresenter {
        return  GoodsPresenter(this)
    }

    override fun initData() {
        presenter!!.pm()
    }


}
