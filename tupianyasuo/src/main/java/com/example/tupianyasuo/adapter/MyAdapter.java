package com.example.tupianyasuo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tupianyasuo.R;
import com.example.tupianyasuo.bean.FilmBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.R.id.list;

/**
 * Created by 曹少航 on 2017/11/21.
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
        final MyViewHolder holder = new MyViewHolder(inflate);
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
        Picasso.with(context).load(data.get(position).getImage_url()).into(holder.filmposter);
        holder.filmName.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView filmposter;
        private final TextView filmName;

        public MyViewHolder(View itemView) {
            super(itemView);
            filmposter = itemView.findViewById(R.id.filmposter);
            filmName = itemView.findViewById(R.id.filmName);
        }
    }

    /**
     * 自定义接口回掉实现点击子条目跳转
     */

    private OnRecyclerListener onRecyclerListener;
    public interface OnRecyclerListener{
        void onRecycler(int position);
    }
    public void setOnRecyclerListener(OnRecyclerListener onRecyclerListener){
        this.onRecyclerListener=onRecyclerListener;
    }

}
