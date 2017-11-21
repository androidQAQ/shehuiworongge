package com.example.tupianyasuo.presenter;
import com.example.tupianyasuo.OnFilmBeanListener;
import com.example.tupianyasuo.bean.FilmBean;
import com.example.tupianyasuo.model.FilmModel;
import com.example.tupianyasuo.model.FilmModelImpl;
import com.example.tupianyasuo.view.FilmView;
/**
 * Created by 曹少航 on 2017/11/21.
 */

public class FilmPresenterImpl implements  FilmPresenter,OnFilmBeanListener {
     FilmView filmView;
    FilmModel filmModel;

    public FilmPresenterImpl(FilmView filmView) {
        this.filmView = filmView;
        filmModel=new FilmModelImpl();
    }
    @Override
    public void ralate() {
        filmModel.getData(this);
    }

    @Override
    public void OnSuccess(FilmBean bean) {
        filmView.setData(bean);
    }
}
