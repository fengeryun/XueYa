package xueya.jiyun.com.xueya.view.fragment.mine;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.presenter.login.FreePresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.viewinter.mine.FreeView;

/**
 * Created by 123 on 2017/6/11.
 */

public class FreeFragment extends BaseFragment implements View.OnClickListener,FreeView {
    LinearLayout free_lin;
    EditText free_dc_shuru,free_dc_et;
    ImageView free_dc_im,free_dc_imt,free_back;
    TextView free_dc_tv;
    Button free_dc_bt;
    RadioButton free_dc_nan,free_dc_nv;
    FreePresenter freePresenter;
    String sex;
    private String trim;

    @Override
    public void initView(View view) {
        free_lin= (LinearLayout) view.findViewById(R.id.free_lin);
        free_dc_shuru= (EditText) view.findViewById(R.id.free_dc_shuru);
        free_dc_et= (EditText) view.findViewById(R.id.free_dc_et);
        free_dc_im= (ImageView) view.findViewById(R.id.free_dc_im);
        free_dc_tv= (TextView) view.findViewById(R.id.free_dc_tv);
        free_dc_bt= (Button) view.findViewById(R.id.free_dc_bt);
        free_dc_nan= (RadioButton) view.findViewById(R.id.free_dc_nan);
        free_dc_nv= (RadioButton) view.findViewById(R.id.free_dc_nv);
        freePresenter=new FreePresenter(this);
        free_dc_imt= (ImageView) view.findViewById(R.id.free_dc_imt);
        free_back= (ImageView) view.findViewById(R.id.free_back);
    }

    @Override
    public int getLayoutId() {
        return R.layout.freequiz;
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {
        free_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager message = App.activity.getSupportFragmentManager();
                message.popBackStackImmediate();
                String lastname = message.getBackStackEntryAt(message.getBackStackEntryCount()-1).getName();
                BaseFragment fragment = (BaseFragment) message.findFragmentByTag(lastname);
                FragmentBuilder.getInstance().setLastFragment(fragment);
            }
        });
        sex=free_dc_nan.getText().toString().trim();
        free_lin.setOnClickListener(this);
        free_dc_bt.setOnClickListener(this);
        free_dc_nan.setOnClickListener(this);
        free_dc_nv.setOnClickListener(this);
        free_dc_im.setOnClickListener(this);
        free_dc_shuru.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                trim = free_dc_shuru.getText().toString().trim();
                freePresenter.GetMsgNum(trim);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.free_dc_bt:
              String str= free_dc_et.getText().toString().trim();
                Toast.makeText(App.activity, "您的网速有点慢......性别:"+sex+"年龄"+str+"症状;"+trim, Toast.LENGTH_SHORT).show();
                break;
            case R.id.free_dc_nan:
                sex=free_dc_nan.getText().toString().trim();
                break;
            case R.id.free_dc_nv:
                sex=free_dc_nv.getText().toString().trim();
                break;
            case R.id.free_dc_im:
                getImageFromAlbum();
                break;
        }
    }

    @Override
    public void ChangeTv(int num) {
        free_dc_tv.setText(num+"/500");
    }
    protected void getImageFromAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        startActivityForResult(intent,1);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            Uri uri = data.getData();
            free_dc_imt.setVisibility(View.VISIBLE);
            Glide.with(App.activity).load(uri).into(free_dc_imt);
        } else if (requestCode == 2 ) {
            Uri uri = data.getData();
        } }
}
