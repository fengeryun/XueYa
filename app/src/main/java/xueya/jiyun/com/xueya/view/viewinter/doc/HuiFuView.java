package xueya.jiyun.com.xueya.view.viewinter.doc;

import java.util.List;

import xueya.jiyun.com.xueya.model.bean.HuiFuBean;
import xueya.jiyun.com.xueya.model.bean.ZhuanJiaBean;

/**
 * Created by my on 2017/6/13.
 */

public interface HuiFuView {

    void showToast(String cont);

    void loadList(List<HuiFuBean.DataBean> list);

}
