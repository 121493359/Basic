package basic2.control.api;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/25
 */

public class Repo<T> {
    public int err_code;
    public String err_msg;
    public T data;

    public boolean isSuccessful() {
        return err_code == 0;
    }
}
