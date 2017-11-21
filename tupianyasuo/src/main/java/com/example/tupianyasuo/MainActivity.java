package com.example.tupianyasuo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tupianyasuo.adapter.MyAdapter;
import com.example.tupianyasuo.bean.FilmBean;
import com.example.tupianyasuo.presenter.FilmPresenterImpl;
import com.example.tupianyasuo.view.FilmView;
import java.util.List;

import static android.R.id.list;
import static com.example.tupianyasuo.R.id.recycler;

public class MainActivity extends AppCompatActivity implements FilmView{
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(recycler);
        FilmPresenterImpl presenter=new FilmPresenterImpl(this);
        presenter.ralate();

    }
    @Override
    public void setData(FilmBean bean) {

        final List<FilmBean.DataBean> data = bean.getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(this,data);
        recyclerView.setAdapter(adapter);

        adapter.setOnRecyclerListener(new MyAdapter.OnRecyclerListener() {
            @Override
                public void onRecycler(int position) {

               Intent intent =new Intent(MainActivity.this,OtherActivity.class);
                intent.putExtra("URL",data.get(position).getVedio_url());
                intent.putExtra("title",data.get(position).getTitle());
                startActivity(intent);

              //startActivity(new Intent(MainActivity.this,OtherActivity.class));

            }
        });
    }
}
