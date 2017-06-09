package xueya.jiyun.com.xueya.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.ThreadUtils;

public class MainActivity extends AppCompatActivity {

    Handler mainhand = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 666:
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    finish();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.activity = this;
        goHome();

    }

    private void goHome(){
        ThreadUtils.runOnSubThread(new Runnable() {
            @Override
            public void run() {
                mainhand.sendEmptyMessageDelayed(666,2000);
            }
        });
    }

}
