package com.meikoz.basic.ui;

import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

import com.meikoz.basic.R;

import basic2.base.BaseActy;
import basic2.control.StatusBarUtil;
import butterknife.Bind;

/**
 * @User: 蜡笔小新
 * @date: 16-12-9
 * @GitHub: https://github.com/meikoz
 */

public abstract class SplashImplActy extends BaseActy {

    private int DELAYED_TIME = 1500;
    @Bind(R.id.iv_splash_background)
    ImageView mImageView;

    @Override
    protected Class getLogicClzz() {
        return null;
    }

    @Override
    protected void setupLayout() {
        StatusBarUtil.setTranslucentBackground(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getNextActivity2Launch() != null)
                    startNextActivity(getNextActivity2Launch());
            }
        }, 1500);
    }

    protected abstract Class getNextActivity2Launch();

    private void startNextActivity(final Class clazz) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashImplActy.this, clazz));
                finish();
            }
        });
    }
}
