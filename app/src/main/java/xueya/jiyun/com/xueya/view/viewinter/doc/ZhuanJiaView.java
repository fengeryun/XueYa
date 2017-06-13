package xueya.jiyun.com.xueya.view.viewinter.doc;

import java.util.List;

import xueya.jiyun.com.xueya.model.bean.ZhuanJiaBean;

/**
 * Created by my on 2017/6/12.
 */

public interface ZhuanJiaView {

    void showToast(String cont);

    void goListItem();

    void loadList(List<ZhuanJiaBean.DataBean> list);

}
