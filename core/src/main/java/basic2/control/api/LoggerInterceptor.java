package basic2.control.api;

import java.io.IOException;

import basic2.control.log.Logger;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/25
 */

public class LoggerInterceptor implements Interceptor {

    private volatile Level level = Level.NONE;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /**
     * Change the level at which this interceptor logs.
     */
    public LoggerInterceptor setLevel(Level level) {
        if (level == null) throw new NullPointerException("level == null. Use Level.NONE instead.");
        this.level = level;
        return this;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Level level = this.level;

        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }

        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;


        Connection connection = chain.connection();
        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
        String requestStartMessage = "--> " + request.method() + ' ' + request.url() + ' ' + protocol;

        return null;
    }
}
