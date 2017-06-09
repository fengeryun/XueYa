package xueya.jiyun.com.xueya.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xueya.jiyun.com.xueya.model.Error.RunTimeError;


/**
 * Created by 123 on 2017/6/9.
 */

public abstract class BaseFragment extends Fragment {
    //判断布局是否是第一次加载
    private boolean isFirst=true;

    private Bundle params;
    //初始化加载布局
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) throws RunTimeError{
        if(getLayoutId()!=0){
            return inflater.inflate(getLayoutId(),container,false);
        }else{
            throw new RunTimeError("Fragment加载失败,请查看"+getClass().getSimpleName()+"的布局ID是否为0");
        }

    }
    //布局加载完成后加载数据
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isFirst=true;
        initView(view);
        initData();
        initListener();
    }

    //当界面处于可见状态执行
    @Override
    public void onResume() {
        super.onResume();
        if(isFirst){
            loadData();
            isFirst=false;
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
            //当前Fragment处于隐藏状态
            onHidden();
        }else{
            //当前Fragment处于可见状态
            onShow();
        }
    }

    //初始化view 寻找控件ID
    public abstract void initView(View view) ;

    //寻找布局ID
    public abstract int getLayoutId();

    //初始化数据
    public abstract void initData();

    //加载数据
    public abstract void loadData();

    //初始化监听事件
    public abstract void initListener();

    //在Fragment加载完成后在该方法中刷新数据

    public void onShow(){
       //可以在该方法中重新加载数据
    }


    //在Fragment隐藏时调用
    public void onHidden(){

    }


    //用于传递过来的参数
    public void setParams(Bundle bundle){
      this.params=bundle;
    }


    public Bundle getParams(){
        return params;
    }
}
