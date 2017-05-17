package basic2.logic;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/17
 */

public interface BaseLogic<V extends BaseV> {
    void bind(V v);

    void unbind();

    boolean isBind();

    V view();
}
