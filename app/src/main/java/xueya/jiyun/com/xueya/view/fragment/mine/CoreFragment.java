package xueya.jiyun.com.xueya.view.fragment.mine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import xueya.jiyun.com.xueya.App;
import xueya.jiyun.com.xueya.R;
import xueya.jiyun.com.xueya.model.GlideCircleTransform;
import xueya.jiyun.com.xueya.presenter.login.IMainPresenter;
import xueya.jiyun.com.xueya.tools.FragmentBuilder;
import xueya.jiyun.com.xueya.tools.ThreadUtils;
import xueya.jiyun.com.xueya.view.base.BaseFragment;
import xueya.jiyun.com.xueya.view.fragment.blood.information.NousFragment;
import xueya.jiyun.com.xueya.view.fragment.mine.LogInFragment;
import xueya.jiyun.com.xueya.view.viewinter.mine.MineView;


/**
 * 个人中心
 * Created by Asus on 2017/6/9.
 */

public class CoreFragment extends BaseFragment implements View.OnClickListener,MineView {
    //          顶层LinearLayout  登录   加号        收藏        资料     消息  设置
    LinearLayout login_lin,mine_nologin,mine_sign,mine_collect,mine_data,mine_msg,mine_set,mine_oklogin;
    Button loginbut;
    IMainPresenter iMainPresenter;
    boolean IsOk;
    ImageView core_img;
    TextView mine_okname;
    BroadcastReceiver broad = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, final Intent intent) {
            if(intent.getStringExtra("shuaxin")!=null){
                initData();
            }

        }
    };
    private TextView item_photo;
    private TextView item_camare;
    private Dialog dialog;

    @Override
    public void initView(View view) {
        login_lin= (LinearLayout) view.findViewById(R.id.login_lin);
        mine_nologin= (LinearLayout) view.findViewById(R.id.mine_nologin);
        mine_sign= (LinearLayout) view.findViewById(R.id.mine_sign);
        mine_collect= (LinearLayout) view.findViewById(R.id.mine_collect);
        mine_data= (LinearLayout) view.findViewById(R.id.mine_data);
        mine_msg= (LinearLayout) view.findViewById(R.id.mine_msg);
        mine_set= (LinearLayout) view.findViewById(R.id.mine_set);
        loginbut = (Button) view.findViewById(R.id.loginbut);
        mine_oklogin= (LinearLayout) view.findViewById(R.id.mine_oklogin);
        iMainPresenter=new IMainPresenter(this);
        mine_okname= (TextView) view.findViewById(R.id.mine_okname);
        core_img= (ImageView) view.findViewById(R.id.core_img);

        //注册广播
        IntentFilter filter = new IntentFilter();
        filter.addAction("login");
        App.activity.registerReceiver(broad,filter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.corefragment;
    }

    @Override
    public void initData() {
        IsOk=iMainPresenter.login();
        iMainPresenter.getName();
        Glide.with(App.activity).load(R.mipmap.head).transform(new GlideCircleTransform(App.activity)).into(core_img);
    }
    @Override
    public void loadData() {
    }
    @Override
    public void initListener() {
        core_img.setOnClickListener(this);
        login_lin.setOnClickListener(this);
        loginbut.setOnClickListener(this);
        mine_msg.setOnClickListener(this);
        login_lin.setOnClickListener(this);
        mine_set.setOnClickListener(this);
        mine_data.setOnClickListener(this);
        mine_collect.setOnClickListener(this);
        mine_sign.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        /*if (IsOk){
            FragmentBuilder.getInstance().start(R.id.activity_home,LogInFragment.class).isBacked(true);
        }else{*/
            switch (v.getId()){
                case R.id.loginbut:
                    FragmentBuilder.getInstance().start(R.id.activity_home,LogInFragment.class).isBacked(true);
                    break;
                case R.id.mine_msg:
                    FragmentBuilder.getInstance().start(R.id.activity_home,MessageFragment.class).isBacked(true);
                    break;
                case R.id.mine_set:
                    FragmentBuilder.getInstance().start(R.id.activity_home,SettingFragment.class).isBacked(true);
                    break;
                case R.id.mine_data:
                    FragmentBuilder.getInstance().start(R.id.activity_home,PersonalFragment.class).isBacked(true);
                    break;
                case R.id.mine_collect:
                    Bundle bundle=new Bundle();
                    bundle.putString("type","1");
                    FragmentBuilder.getInstance().start(R.id.activity_home,NousFragment.class).isBacked(true).setParams(bundle);
                    break;
                case R.id.mine_sign:
                    FragmentBuilder.getInstance().start(R.id.activity_home,SignFragment.class).isBacked(true);
                    break;
                case R.id.core_img:
                    View view = LayoutInflater.from(App.activity).inflate(R.layout.coreitem,null);
                    item_photo = (TextView) view.findViewById(R.id.item_photo);
                    item_camare = (TextView) view.findViewById(R.id.item_camare);
                    dialog = new AlertDialog.Builder(App.activity)
                            .setView(view)
                            .setNegativeButton("取消",null)
                            .create();
                    dialog.show();
                    WindowManager.LayoutParams params =
                            dialog.getWindow().getAttributes();
                    params.width = 300;
                    params.height = 400 ;
                    dialog.getWindow().setAttributes(params);
                    item_photo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                                    startActivityForResult(cameraIntent,2);

                        }
                    });
                    item_camare.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getImageFromAlbum();
                        }
                    });
                    break;
            }

        //}
    }
    //判断登录状态来控制头像的隐藏显示
    @Override
    public void showToux() {
        mine_oklogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideToux() {
        mine_oklogin.setVisibility(View.GONE);
    }
    //判断登录状态来控制登录按钮的隐藏显示
    @Override
    public void showBt() {
        mine_nologin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideBt() {
        mine_nologin.setVisibility(View.GONE);
    }

    @Override
    public void setName(String name) {
        mine_okname.setText(name);
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
            core_img.setVisibility(View.VISIBLE);
            Glide.with(App.activity).load(uri).transform(new GlideCircleTransform(App.activity)).into(core_img);
            dialog.dismiss();
        } else if (requestCode == 2 ) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            core_img.setImageBitmap(photo);
            dialog.dismiss();
        } }

}
