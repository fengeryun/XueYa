package xueya.jiyun.com.xueya.view.fragment.mine;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.sp.SpUtils;
import xueya.jiyun.com.xueya.presenter.login.ChangeNamePresenter;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.mine.ChangeNameView;

/**
 * Created by 123 on 2017/6/13.
 */

public class ChangNameFragment extends BaseFragment implements View.OnClickListener,ChangeNameView {
    TextView change_send;
    EditText name_name;
    private String trim;
    ChangeNamePresenter chang;
    @Override
    public void initView(View view) {
        change_send= (TextView) view.findViewById(R.id.change_send);
        name_name= (EditText) view.findViewById(R.id.name_name);
        chang=new ChangeNamePresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.change_name;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        change_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        trim = name_name.getText().toString().trim();
        chang.GetMsg(trim);
    }

    @Override
    public void ShowMeg(String msg) {
        Toast.makeText(App.activity, msg, Toast.LENGTH_SHORT).show();
    }

}
