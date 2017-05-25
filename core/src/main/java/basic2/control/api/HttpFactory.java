package basic2.control.api;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/25
 */

public class HttpFactory {

    private static HttpFactory factory;
    private final Retrofit retrofit;

    private HttpFactory() {
        retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(provideOKhttp())
                .build();
    }

    public static HttpFactory of() {
        if (factory == null) synchronized (HttpFactory.class) {
            if (factory == null) factory = new HttpFactory();
        }
        return factory;
    }

    public <T> T create(@NonNull Class<T> clzz) {
        return retrofit.create(clzz);
    }

    private OkHttpClient provideOKhttp() {
        return new OkHttpClient.Builder().build();
    }
}
