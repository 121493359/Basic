package basic2.engine.api;

import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import basic2.TApp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/25
 */

public abstract class TCallback<T> implements Callback<T> {

    protected abstract void successful(Response<T> response);

    protected void onFailure(String msg) {
        Toast.makeText(TApp.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T body = response.body();
        if (body instanceof Repo && !((Repo) body).isSuccessful())
            onFailure(((Repo) body).err_msg);
        else successful(response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

        if (t instanceof SocketTimeoutException) onFailure("SocketTimeoutException");
        else if (t instanceof ConnectException) onFailure("ConnectException");
        else if (t instanceof RuntimeException) onFailure("RuntimeException");
        else onFailure(t.getMessage());
    }
}
