package xueya.jiyun.com.xueya.view.fragment.mine;

import android.support.v4.app.FragmentManager;
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
    ImageView msg_quiz,meg_back;
    LinearLayout activity_message;
    @Override
    public void initView(View view) {
        msg_quiz= (ImageView) view.findViewById(R.id.msg_quiz);
        activity_message= (LinearLayout) view.findViewById(R.id.activity_message);
        meg_back= (ImageView) view.findViewById(R.id.meg_back);
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
        meg_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager message = App.activity.getSupportFragmentManager();
                message.popBackStackImmediate();
                String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
                BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
                FragmentBuilder.getInstance().setLastFragment(fragment);
            }
        });
        msg_quiz.setOnClickListener(this);
        activity_message.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.msg_quiz:
                FragmentBuilder.getInstance().start(R.id.activity_home,FreeFragment.class).isBacked(true);
                break;
            case R.id.activity_message:

                break;
        }
    }
}
