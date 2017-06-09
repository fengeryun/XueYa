package xueya.jiyun.com.xueya.tools;

import android.os.Handler;
import android.os.Looper;

/**
 *
 * 线程切换
 * Created by my on 2017/5/14.
 */

public class ThreadUtils {
    private static Handler sHander = new Handler(Looper.getMainLooper());

    //主线程
    public static void runOnMain(Runnable runnable) {
        sHander.post(runnable);
    }

    //子线程
    public static void runOnSubThread(Runnable runnable) {
        new Thread(runnable).start();
    }
}
