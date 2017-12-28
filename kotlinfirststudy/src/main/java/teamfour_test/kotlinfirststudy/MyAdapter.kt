package teamfour_test.kotlinfirststudy

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by 曹少航 on 2017/12/28.
 */
class MyAdapter(context:Context,list:List<GoodsInfo>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var context: Context = context
    private var list : List<GoodsInfo> = list

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.item_1,parent,false)
        return  MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {

        holder?.textView?.text=list.get(position).name
        Picasso.with(context).load(list.get(position).bgPicture).into(holder?.imageView)

        holder?.linearLayout?.setOnClickListener{
            litener?.OnItemClickListener(position)
        }

    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
        var textView=itemView!!.findViewById<TextView>(R.id.tv1)as TextView
        var imageView=itemView!!.findViewById<ImageView>(R.id.img) as ImageView
        var linearLayout =itemView!!.findViewById<LinearLayout>(R.id.ll)as LinearLayout
    }

    //设置点击事件的方法
    var litener:OnItemClickListener?=null
    interface OnItemClickListener{
        fun  OnItemClickListener(position: Int)
    }
    fun  setOnItemClickListener(litener : OnItemClickListener){
        this.litener=litener
    }
}