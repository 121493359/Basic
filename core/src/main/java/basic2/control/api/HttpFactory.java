package basic2.control.api;

import android.support.annotation.NonNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

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
    private HashMap<Class, Object> objects;

    private HttpFactory() {
        objects = new HashMap<>();
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

    public <T> T create(@NonNull Class<T> clz) {
        Object obj = objects.get(clz);
        if (obj == null) {
            obj = retrofit.create(clz);
            objects.put(clz, obj);
        }
        return (T) obj;
    }

    private OkHttpClient provideOKhttp() {
        return new OkHttpClient.Builder().addInterceptor().build();
    }
}
