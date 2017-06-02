package com.meikoz.basic.ui;

import com.meikoz.basic.R;

import basic2.base.BaseActy;
import basic2.engine.annotation.Layout;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/18
 */
@Layout(R.layout.activity_splash)
public class LoginActy extends BaseActy<LoginLoigcImpl> implements LoginContact.View {

    private LoginLoigcImpl mLogic;

    @Override
    protected void setupLayout() {
        mLogic = new LoginLoigcImpl(this);
        mLogic.login("username", "passwrod");
    }

    @Override
    protected Class<LoginLoigcImpl> getLogicClzz() {
        return LoginLoigcImpl.class;
    }

    @Override
    public void successful(String body) {

    }
}
