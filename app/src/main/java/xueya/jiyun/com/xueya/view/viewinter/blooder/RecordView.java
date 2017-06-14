package xueya.jiyun.com.xueya.view.viewinter.blooder;

/**
 * Created by Asus on 2017/6/13.
 */

public interface RecordView {
    String  getDevice();
    String getHeight();
    String getLow();
    void getDeviceMess(String msg);
    void getHeightMess(String msg);
    void getLowMess(String msg);
    void getButtonMess(String msg);
}
