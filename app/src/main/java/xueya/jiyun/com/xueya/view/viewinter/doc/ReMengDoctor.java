package xueya.jiyun.com.xueya.view.viewinter.doc;

import java.util.List;

import xueya.jiyun.com.xueya.model.bean.ReMengBean;
import xueya.jiyun.com.xueya.model.bean.ZhuanJiaBean;

/**
 * Created by my on 2017/6/12.
 */

public interface ReMengDoctor {
    void showToest(String cont);

    void loadGrid(List<ZhuanJiaBean.DataBean> list);
}
