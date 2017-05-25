package basic2.base.adapter;

import android.content.Context;

import com.joanzapata.android.QuickAdapter;

import java.util.List;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/25
 */

public abstract class CommonAdapter<T> extends QuickAdapter<T> {

    public CommonAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    public CommonAdapter(Context context, int layoutResId, List<T> data) {
        super(context, layoutResId, data);
    }
}
