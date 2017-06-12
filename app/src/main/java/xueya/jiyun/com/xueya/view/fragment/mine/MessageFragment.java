package xueya.jiyun.com.xueya.view.fragment.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by 123 on 2017/6/11.
 */

public class MessageFragment extends BaseFragment implements View.OnClickListener {
    ImageView msg_quiz;
    LinearLayout activity_message;
    @Override
    public void initView(View view) {
        msg_quiz= (ImageView) view.findViewById(R.id.msg_quiz);
        activity_message= (LinearLayout) view.findViewById(R.id.activity_message);
    }

    @Override
    public int getLayoutId() {
        return R.layout.message_doc;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        msg_quiz.setOnClickListener(this);
        activity_message.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.msg_quiz:
                FragmentBuilder.getInstance().start(R.id.activity_message,FreeFragment.class);
                break;
        }
    }
}
