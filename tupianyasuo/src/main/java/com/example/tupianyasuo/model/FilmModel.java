package com.example.tupianyasuo.model;

import com.example.tupianyasuo.OnFilmBeanListener;
import com.example.tupianyasuo.bean.FilmBean;

/**
 * Created by 曹少航 on 2017/11/21.
 */

public interface FilmModel {
    void getData(OnFilmBeanListener listener);
}
