package xueya.jiyun.com.xueya;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.baidu.mapapi.SDKInitializer;

import xueya.jiyun.com.xueya.view.activity.HomeActivity;

/**
 * Created by Asus on 2017/6/9.
 */

public class App extends Application{
    public static AppCompatActivity activity;


    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }
}
