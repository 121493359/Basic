package com.meikoz.basic.ui;

import com.meikoz.basic.app.ApiInterface;
import com.meikoz.basic.model.Gank;

import basic2.engine.api.HttpFactory;
import basic2.base.mvp.BaseLogicImp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/25
 */

public class LoginLoigcImpl extends BaseLogicImp<LoginContact.View> implements LoginContact {

    public LoginLoigcImpl(View view) {
        super(view);
    }

    @Override
    public void login(String username, String passwrod) {
        HttpFactory
                .of()
                .create(ApiInterface.class)
                .onLoadNetworkData(1, 2)
                .enqueue(new Callback<Gank>() {
                    @Override
                    public void onResponse(Call<Gank> call, Response<Gank> response) {
                        view().successful(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<Gank> call, Throwable t) {

                    }
                });
    }
}
