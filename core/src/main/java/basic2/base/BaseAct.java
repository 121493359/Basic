package basic2.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import basic2.control.mvp.BaseLogicImp;
import basic2.control.BaseV;

/**
 * @USER: https://github.com/meikoz
 * @DATE: 2017/5/17
 */

public abstract class BaseAct<T extends BaseLogicImp> extends Activity implements BaseV {

    protected abstract int getLayoutResource();

    protected abstract void setupLayout();

    protected T mLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        if (getLayoutResource() != 0)
            setContentView(getLayoutResource());
        setupLayout();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
