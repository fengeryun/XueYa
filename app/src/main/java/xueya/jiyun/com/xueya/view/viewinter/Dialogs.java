package xueya.jiyun.com.xueya.view.viewinter;

import android.app.ProgressDialog;
import android.widget.Toast;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.tools.ThreadUtils;

/**
 * Created by Asus on 2017/6/12.
 */

public class Dialogs {
    private static Dialogs dialogs = null;
    private static ProgressDialog pd ;

    private Dialogs(){

    }
    public static synchronized Dialogs getInstent(){
        if (dialogs==null){
            dialogs = new Dialogs();
        }
        return dialogs;
    }
    public  static ProgressDialog ShowDialog(final String msg){
        pd  = new ProgressDialog(App.activity);
            pd.setMessage("正在加载....");
            pd.show();
            ThreadUtils.runOnSubThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        ThreadUtils.runOnMain(new Runnable() {
                            @Override
                            public void run() {
                                pd.dismiss();
                                if(msg!=null){
                                    Toast.makeText(App.activity,msg, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        return pd;
    }
    public  static ProgressDialog Show2Dialog(){
        pd  = new ProgressDialog(App.activity);
        pd.setMessage("正在加载....");
        pd.setCancelable(false);
        pd.show();

        return pd;
    }
    public static ProgressDialog DissDialog(String msg){
        pd.dismiss();
        Toast.makeText(App.activity, msg, Toast.LENGTH_SHORT).show();
        return pd;
    }

}
