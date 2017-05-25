package basic2;

import android.app.Application;
import android.content.Context;

/**
 * @USER: https://github.com/meikoz/
 * @DATE: 2017/5/25
 */

public class TApp extends Application {
    
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
