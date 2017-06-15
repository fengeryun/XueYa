package xueya.jiyun.com.xueya.view.fragment.doctors.datapag;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by my on 2017/6/15.
 */

public class FragmentAddNext extends BaseFragment {
    @Bind(R.id.addnext_backs)
    ImageView addnextBacks;
    @Bind(R.id.addnext_name)
    TextView addnextName;
    @Bind(R.id.addnext_location)
    TextView addnextLocation;
    @Bind(R.id.addnext_person)
    TextView addnextPerson;
    @Bind(R.id.up_next)
    Button upNext;
    @Bind(R.id.add_commit)
    Button addCommit;
    @Bind(R.id.addNextLayout)
    LinearLayout addNextLayout;
    ProgressDialog dialog;

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.adduser_next;
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

    @OnClick({R.id.addnext_backs, R.id.up_next, R.id.add_commit, R.id.addNextLayout,R.id.addnext_name,R.id.addnext_location,R.id.addnext_person})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.addnext_backs:
                onBack();
                break;
            case R.id.up_next:
                onBack();
                break;
            case R.id.add_commit:
                    dialog = new ProgressDialog(App.activity);
                    dialog.setMessage("loading");
                    ThreadUtils.runOnSubThread(new Runnable() {
                        @Override
                        public void run() {
                            dialog.show();
                            SystemClock.sleep(1000);
                        }
                    });
                    Toast.makeText(App.activity, "上传成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.addnext_name:
                break;
            case R.id.addnext_location:
                break;
            case R.id.addnext_person:
                break;
            case R.id.addNextLayout:
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
