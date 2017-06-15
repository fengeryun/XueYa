package xueya.jiyun.com.xueya.presenter.login;

/**
 * Created by 123 on 2017/6/14.
 */

public interface IChangePswPresenter {

    boolean LoginPsw(String psw,String tpsw);

    void PanDuan(String psw,String tpsw);

    void DPanDuan(String psw,String tpsw);
}
