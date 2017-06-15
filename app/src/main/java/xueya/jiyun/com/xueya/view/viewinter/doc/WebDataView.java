package xueya.jiyun.com.xueya.view.viewinter.doc;

import java.util.List;

import xueya.jiyun.com.xueya.model.bean.WebDataBean;
import xueya.jiyun.com.xueya.model.bean.ZhuanJiaBean;

/**
 * Created by my on 2017/6/14.
 */

public interface WebDataView {
    void showToest(String cont);

    void loadGrid(WebDataBean.DataBean bean);
}
