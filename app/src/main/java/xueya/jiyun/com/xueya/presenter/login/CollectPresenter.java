package xueya.jiyun.com.xueya.presenter.login;

import java.util.List;

import xueya.jiyun.com.xueya.model.bean.CollectBean;
import xueya.jiyun.com.xueya.view.viewinter.mine.CollectView;

/**
 * Created by 123 on 2017/6/13.
 */

public class CollectPresenter implements ICollectPresenter {
   CollectView collectView;

    public CollectPresenter(CollectView collectView) {
        this.collectView = collectView;
    }

    @Override
    public List<CollectBean> GetBean() {

        return null;
    }
}
