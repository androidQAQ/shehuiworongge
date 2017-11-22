package com.example.yuekaolianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuekaolianxi.bean.MBean;
import com.example.yuekaolianxi.presenter.MPresenter;
import com.example.yuekaolianxi.presenter.MPresenterImpl;
import com.example.yuekaolianxi.view.MView;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements MView{

    private ImageView image1;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //http://result.eolinker.com/iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=vedio
        image1 = (ImageView) findViewById(R.id.image1);
        tv1 = (TextView) findViewById(R.id.tv1);
        MPresenterImpl presenter=new MPresenterImpl(this);
        presenter.relata();

    }

    @Override
    public void setData(MBean bean) {
        tv1.setText(bean.getCode()+"");
        Picasso.with(MainActivity.this).load(bean.getData().get(0).getImage_url()).into(image1);
    }
}
