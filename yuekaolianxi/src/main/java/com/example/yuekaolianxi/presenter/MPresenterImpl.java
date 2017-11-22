package com.example.yuekaolianxi.presenter;

import com.example.yuekaolianxi.bean.MBean;
import com.example.yuekaolianxi.OnFinishListener;
import com.example.yuekaolianxi.model.MModel;
import com.example.yuekaolianxi.model.MModelImpl;
import com.example.yuekaolianxi.view.MView;

/**
 * Created by 曹少航 on 2017/11/22.
 */

public class MPresenterImpl implements MPresenter,OnFinishListener {
        MView view;
     MModel mModel;

    public MPresenterImpl(MView view) {
        this.view = view;
        mModel=new MModelImpl();
    }

    @Override
    public void relata() {
        mModel.getData(this);
    }

    @Override
    public void OnSuccess(MBean bean) {
        view.setData(bean);
    }

}
