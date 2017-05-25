package basic2.base;

import android.app.Fragment;
import android.support.annotation.StringRes;
import android.widget.Toast;

import java.util.List;

import basic2.base.mvp.BaseLogicImp;
import basic2.base.mvp.BaseView;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/25
 */

public class BaseFragment<T extends BaseLogicImp> extends Fragment implements BaseView {

    /*-------------View Method-------------*/
    @Override
    public void showLoading() {

    }

    @Override
    public void closeLoading() {

    }

    @Override
    public void showErrorView() {

    }

    /*-------------function Method-------------*/
    public boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public void showToast(@StringRes int resId) {
        Toast.makeText(getActivity(), resId, Toast.LENGTH_SHORT).show();
    }

    public void showToast(CharSequence string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
    }
}
