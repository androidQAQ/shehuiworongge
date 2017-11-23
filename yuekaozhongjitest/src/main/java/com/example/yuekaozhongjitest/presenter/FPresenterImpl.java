package com.example.yuekaozhongjitest.presenter;

import com.example.yuekaozhongjitest.OnSuccessful;
import com.example.yuekaozhongjitest.bean.FilmBean;
import com.example.yuekaozhongjitest.model.FModel;
import com.example.yuekaozhongjitest.model.FModelImpl;
import com.example.yuekaozhongjitest.view.FView;

/**
 * Created by 曹少航 on 2017/11/23.
 */

public class FPresenterImpl implements FPresenter,OnSuccessful {
    private  FView fView;
    private final FModel fModel;

    public FPresenterImpl(FView fView) {
        this.fView = fView;
        fModel = new FModelImpl();
    }

    @Override
    public void relate() {
        fModel.getData(this);
    }

    @Override
    public void Success(FilmBean bean) {
        fView.setData(bean);
    }

}
