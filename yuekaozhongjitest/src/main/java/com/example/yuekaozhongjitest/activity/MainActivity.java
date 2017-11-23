package com.example.yuekaozhongjitest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yuekaozhongjitest.R;
import com.example.yuekaozhongjitest.adapter.MyAdapter;
import com.example.yuekaozhongjitest.bean.FilmBean;
import com.example.yuekaozhongjitest.presenter.FPresenterImpl;
import com.example.yuekaozhongjitest.view.FView;

import java.util.List;

/**
 * 网络请求数据下载到本地在进行播放
 * 实现方式Retrofit+RxJava+MVP+多线程下载
 */
public class MainActivity extends AppCompatActivity implements FView{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        //关联
        FPresenterImpl fPresenter=new FPresenterImpl(this);
        fPresenter.relate();

    }
    @Override
    public void setData(FilmBean bean) {
        final List<FilmBean.DataBean> data = bean.getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter =new MyAdapter(this,data);
        recyclerView.setAdapter(adapter);
        adapter.setOnRecyclerListener(new MyAdapter.OnRecyclerListener() {
            @Override
            public void onRecycler(int position) {
                Intent intent =new Intent(MainActivity.this,OtherActivity.class);
                intent.putExtra("URL",data.get(position).getVedio_url());
                startActivity(intent);
            }
        });

    }
}
