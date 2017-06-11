package xueya.jiyun.com.xueya.view.fragment.blood;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;

/**
 * Created by Asus on 2017/6/9.
 */

public class RecordFragment extends BaseFragment implements View.OnClickListener {
    @Bind(R.id.record_back)
    ImageView recordBack;
    @Bind(R.id.record_titlle)
    TextView recordTitlle;
    @Bind(R.id.shebei)
    TextView shebei;
    @Bind(R.id.gaoya)
    TextView gaoya;
    @Bind(R.id.diya)
    TextView diya;
    @Bind(R.id.record_commit)
    Button recordCommit;
    @Bind(R.id.record_txt)
    TextView recordTxt;
    private ImageView record_back;

    @Override
    public void initView(View view) {
        record_back = (ImageView) view.findViewById(R.id.record_back);
    }

    @Override
    public int getLayoutId() {
        return R.layout.record;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        record_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.record_back:
                FragmentManager message = App.activity.getSupportFragmentManager();
                message.popBackStackImmediate();
                String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount() - 1).getName();
                BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
                FragmentBuilder.getInstance().setLastFragment(fragment);
                break;
        }
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

    @OnClick(R.id.record_txt)
    public void onViewClicked() {
    }
}
