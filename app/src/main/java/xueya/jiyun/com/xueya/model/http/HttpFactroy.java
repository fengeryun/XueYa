package xueya.jiyun.com.xueya.model.http;


/**
 * Created by my on 2017/5/13.
 */

public class HttpFactroy {
    public static final int OKHTTP = 1;
    public static final int VOLLEY = 2;
    public static final int RETROFIT = 3;

    public static Ihttp getUrlType(int type){
        Ihttp ihttp = null;
        switch (type){
            case VOLLEY:
                //ihttp = VolleyUtils.getInstance();
                break;
            case OKHTTP:
                ihttp = OKhttpUtils.getInstance();
                break;
        }
        return ihttp;
    }

}
