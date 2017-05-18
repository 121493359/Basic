package basic2.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import basic2.control.annotation.BasicKnife;
import basic2.control.mvp.BaseLogicImp;
import basic2.control.BaseV;

/**
 * @USER: https://github.com/meikoz
 * @DATE: 2017/5/17
 */

public abstract class BaseAct<T extends BaseLogicImp> extends FragmentActivity implements BaseV {

    protected abstract void setupLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BasicKnife.of(this);
        setupLayout();
    }
}
