package com.meikoz.basic.ui;

import com.meikoz.basic.R;

import basic2.control.annotation.Layout;

/**
 * Author: 码农小阿新
 * Date: 2016/9/23
 * Github: https://github.com/racofix
 */
@Layout(R.layout.activity_splash)
public class SplashAty extends SplashImplActy {

    @Override
    protected Class getNextActivity2Launch() {
        return LoginActy.class;
    }
}