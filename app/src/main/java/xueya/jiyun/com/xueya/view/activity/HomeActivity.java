package xueya.jiyun.com.xueya.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        App.activity = this;

    }
}
