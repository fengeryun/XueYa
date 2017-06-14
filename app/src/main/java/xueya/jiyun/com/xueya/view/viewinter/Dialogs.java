package xueya.jiyun.com.xueya.view.viewinter;

import android.app.ProgressDialog;

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
    public  static ProgressDialog ShowDialog() {
        pd = new ProgressDialog(App.activity);
        pd.setMessage("正在加载....");
        pd.show();
        ThreadUtils.runOnSubThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    ThreadUtils.runOnMain(new Runnable() {
                        @Override
                        public void run() {
                            pd.dismiss();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        return pd;
    }

    public static void disDialog(){
        pd.dismiss();
    }
    public  static ProgressDialog Show2Dialog() {
        pd = new ProgressDialog(App.activity);
        pd.setMessage("正在加载....");
        pd.setCanceledOnTouchOutside(false);
        pd.show();
        return pd;
    }

}
