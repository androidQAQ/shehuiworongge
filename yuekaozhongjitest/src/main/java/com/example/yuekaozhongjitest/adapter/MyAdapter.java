package com.example.yuekaozhongjitest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuekaozhongjitest.R;
import com.example.yuekaozhongjitest.bean.FilmBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 曹少航 on 2017/11/23.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<FilmBean.DataBean> data;

    public MyAdapter(Context context, List<FilmBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item1, null);
        final MyViewHolder holder=new MyViewHolder(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRecyclerListener.onRecycler(holder.getPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv1.setText(data.get(position).getTitle());
        Picasso.with(context).load(data.get(position).getImage_url()).into(holder.image1);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView image1;
        private final TextView tv1;

        public MyViewHolder(View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.image1);
            tv1 = itemView.findViewById(R.id.title1);

        }
    }
    /**
     * 自定义接口实现点击事件
     */
    private OnRecyclerListener onRecyclerListener;

    public  interface  OnRecyclerListener{
        void onRecycler(int position);
    }
    public  void setOnRecyclerListener(OnRecyclerListener onRecyclerListener){
        this.onRecyclerListener=onRecyclerListener;
    }

}
