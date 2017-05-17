package basic2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import basic2.logic.BaseLogicImp;
import basic2.logic.BaseV;
import basic2.logic.annotation.Logic;

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
        if (mLogic == null) {
            mLogic = of(this);
        }
        setupLayout();
    }

    private <T extends BaseLogicImp> T of(BaseV v) {
        Class<? extends Activity> clzz = this.getClass();
        if (clzz.isAnnotationPresent(Logic.class)) {
            Logic imp = clzz.getAnnotation(Logic.class);
            try {
                T value = (T) imp.value().newInstance();
                if (value !=null &&v != value.view()) {
                    if (value.isBind()) {
                        value.unbind();
                    }
                    value.bind(v);
                }
                return value;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
