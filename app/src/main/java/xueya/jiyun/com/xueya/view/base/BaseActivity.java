package xueya.jiyun.com.xueya.view.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by 123 on 2017/6/11.
 */

public abstract class BaseActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
        initListener();
        loadData();
    }

    public abstract int getLayoutId();

    //初始化view
    public abstract void initView();

    //初始化数据
    public abstract void initData();

    //初始化监听
    public abstract void initListener();

    //加载数据
    public abstract void loadData();

}
