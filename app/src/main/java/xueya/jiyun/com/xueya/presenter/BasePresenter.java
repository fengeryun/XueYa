package xueya.jiyun.com.xueya.presenter;

import java.lang.ref.WeakReference;

import xueya.jiyun.com.xueya.model.biz.BaseModelInter;
import xueya.jiyun.com.xueya.view.BaseViewInter;

/**
 * Created by my on 2017/6/9.
 */

public abstract class BasePresenter<T extends BaseViewInter, M extends BaseModelInter> {
    private WeakReference<T> weakReference;
    protected M model;
    public void attach(T t) {
        weakReference = new WeakReference<>(t);
        model = getModel();
    }

    public void deAttach() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    public boolean isViewAttached() {
        return weakReference != null && weakReference.get() != null;
    }

    public T getView() {
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
    protected abstract M getModel();
}
