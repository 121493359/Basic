package basic2;

import android.app.Activity;
import android.support.v4.app.Fragment;

import java.lang.ref.WeakReference;

/**
 * USER: Stayokay
 * DATE: 六月, 02
 */

public class Basic {

    private final WeakReference<Activity> mContext;
    private final WeakReference<Fragment> mFragment;
    public static final boolean DEBUG = Boolean.parseBoolean("true");

    private Basic(Activity acty) {
        this(acty, null);
    }

    private Basic(Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }


    private Basic(Activity acty, Fragment fragment) {
        mContext = new WeakReference<>(acty);
        mFragment = new WeakReference<>(fragment);
    }

    /**
     * Start Basic from an Activity.
     *
     * @param acty Activity instance.
     * @return Basic instance.
     */
    public static Basic from(Activity acty) {
        return new Basic(acty);
    }

    /**
     * Start Basic from an Fragment.
     *
     * @param fragment Fragment instance.
     * @return Basic instance.
     */
    public static Basic from(Fragment fragment) {
        return new Basic(fragment);
    }
}
