package xueya.jiyun.com.xueya.view.viewinter.doc;

import java.util.List;

import xueya.jiyun.com.xueya.model.bean.JingYanBean;

/**
 * Created by my on 2017/6/13.
 */

public interface JingYanView {
    void showToest(String cont);

    void loadGrid(List<JingYanBean.DataBean> list);
}
