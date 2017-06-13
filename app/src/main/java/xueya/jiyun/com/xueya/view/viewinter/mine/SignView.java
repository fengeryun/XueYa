package xueya.jiyun.com.xueya.view.viewinter.mine;

import xueya.jiyun.com.xueya.model.bean.SignBean;

/**
 * Created by 123 on 2017/6/13.
 */

public interface SignView {
    void ShowList();
    void HideList();
    void ShowText();
    void HideText();
    void GetBean(SignBean signBean);
}
