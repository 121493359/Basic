package basic2.base.mvp;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/17
 * <p>
 * Common baseView interface of common extends for an that
 * can be used in both {@link android.app.Activity/Fragment} some basic method
 */

public interface BaseView {

    void showLoading();

    void closeLoading();

    void showErrorView();
}
