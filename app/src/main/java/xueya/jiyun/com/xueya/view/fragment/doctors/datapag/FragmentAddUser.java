package xueya.jiyun.com.xueya.view.fragment.doctors.datapag;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by my on 2017/6/14.
 */

public class FragmentAddUser extends BaseFragment {
    @Bind(R.id.adduser_backs)
    ImageView adduserBacks;
    @Bind(R.id.adduser_name)
    EditText adduserName;
    @Bind(R.id.adduser_location)
    EditText adduserLocation;
    @Bind(R.id.adduser_person)
    EditText adduserPerson;
    @Bind(R.id.adduser_phone)
    EditText adduserPhone;
    @Bind(R.id.adduser_next)
    Button adduserNext;
    @Bind(R.id.adduserLayout)
    LinearLayout adduserLayout;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.add_user;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.adduser_backs, R.id.adduser_next,R.id.adduserLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.adduser_backs:
                onBack();
                break;
            case R.id.adduser_next:
                if(adduserName.getText().length()>=1 && adduserLocation.getText().length()>=1){
                    if(adduserPerson.getText().length()==18){
                        if(adduserPhone.getText().length()==11){
                            FragmentBuilder.getInstance().start(R.id.activity_home,FragmentAddNext.class).isBacked(true);
                        }else {
                            Toast.makeText(App.activity, "手机号不正确", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(App.activity, "身份证格式不正确", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(App.activity, "请检查是否填写完整", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.adduserLayout:
                break;
        }
    }
    private void onBack() {
        FragmentManager message = App.activity.getSupportFragmentManager();
        message.popBackStackImmediate();
        String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount() - 1).getName();
        BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
        FragmentBuilder.getInstance().setLastFragment(fragment);
    }
}
