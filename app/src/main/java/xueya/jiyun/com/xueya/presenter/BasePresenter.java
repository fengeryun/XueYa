package xueya.jiyun.com.xueya.presenter;

import java.lang.ref.WeakReference;

import xueya.jiyun.com.xueya.model.modelinter.BaseModelInter;
import xueya.jiyun.com.xueya.view.BaseViewInter;

/**
 * Created by my on 2017/6/9.
 */

public abstract class BasePresenter<T extends BaseViewInter, M extends BaseModelInter> {
    private WeakReference<T> weakReference; //视图接口
    protected M model;  //model接口

    //将需要与具体的presenter类做绑定的view关联起来,并且将对应的model也绑定起来
    public void attach(T t) {
        weakReference = new WeakReference<>(t);
        model = getModel();
    }

    //presenter没有即使返回数据，则deAttach就会把对应的view取消关联
    public void deAttach() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    //判断view与presente是否关联
    public boolean isViewAttached() {
        return weakReference != null && weakReference.get() != null;
    }

    //返回一个绑定好的view对象
    public T getView() {
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    //让具体的presenter子类去创建具体的model对象。
    protected abstract M getModel();
}


