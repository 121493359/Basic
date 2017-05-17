package basic2.temp;

import com.meikoz.core.R;

import basic2.BaseAct;
import basic2.logic.annotation.Logic;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/17
 */
@Logic(LoginLogicImp.class)
public class LoginAct extends BaseAct<LoginLogicImp> {

    @Override
    protected int getLayoutResource() {
        return R.layout.abc_navi_tab_view;
    }

    @Override
    protected void setupLayout() {
        mLogic.login("zhangsan", "123456");
    }

}
