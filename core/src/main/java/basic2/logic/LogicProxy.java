package basic2.logic;

import android.app.Activity;

import basic2.logic.annotation.Logic;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/17
 */

public class LogicProxy {

    public static BaseLogicImp bind(Activity act, BaseV v) {
        Class<? extends Activity> clzz = act.getClass();
        if (clzz.isAnnotationPresent(Logic.class)) {
            Logic imp = clzz.getAnnotation(Logic.class);
            BaseLogicImp value = null;
            try {
                value = (BaseLogicImp) imp.value().newInstance();
                value.bind(v);
            } catch (InstantiationException e) {

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return value;
        }
        return null;
    }
}
