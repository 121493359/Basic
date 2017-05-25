package com.meikoz.basic.ui;

import basic2.base.mvp.BaseView;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/25
 */

public interface LoginContact {
    void login(String username, String passwrod);

    interface View extends BaseView {
        void successful(String body);
    }
}
