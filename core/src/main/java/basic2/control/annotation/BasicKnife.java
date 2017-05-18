package basic2.control.annotation;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import butterknife.ButterKnife;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/18
 */

public class BasicKnife {

    public static void bind(Object target) {
        bind(target, null);
    }

    public static void bind(Object target, View v) {
        if (target instanceof Activity)
            ButterKnife.bind((Activity) target);
        Class<?> clzz = target.getClass();
        if (target instanceof Activity && clzz.isAnnotationPresent(LayoutId.class)) {
            int layoutRes = clzz.getAnnotation(LayoutId.class).value();
            try {
                Method method = clzz.getMethod("setContentView", int.class);
                method.setAccessible(true);
                method.invoke(target, layoutRes);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException(target.getClass().getName() + " must have @interface LayoutId");
        }
    }
}
