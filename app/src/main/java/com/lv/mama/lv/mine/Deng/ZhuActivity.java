package com.lv.mama.lv.mine.Deng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lv.mama.lv.R;
import com.lv.mama.lv.mine.Deng.presenter.UserPresenter;
import com.lv.mama.lv.mine.Deng.view.IUserView;
import com.lv.mama.lv.utils.ToastUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZhuActivity extends AppCompatActivity implements IUserView {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.zhu_top)
    RelativeLayout zhuTop;
    @BindView(R.id.editText4)
    EditText editText4;
    @BindView(R.id.editText5)
    EditText editText5;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.zhu_bom)
    RelativeLayout zhuBom;
    @BindView(R.id.activity_zhu)
    RelativeLayout activityZhu;
    private UserPresenter userpresenter;
    private String name;
    private String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        ButterKnife.bind(this);
        userpresenter=new UserPresenter(this);
    }
    @OnClick(R.id.button2)
    public void onViewClicked() {
        name = editText4.getText().toString().trim();
        pass = editText5.getText().toString().trim();
        HashMap<String,String> map=new HashMap<>();
        map.put("mobile",name);
        map.put("password",pass);
        userpresenter.getdaTa("reg",map);
    }
    @Override
    public void onLoginYes(String msg) {

    }

    @Override
    public void onLoginNo(String msg) {
        if (msg.equals("注册成功")) {
            ToastUtil.show(ZhuActivity.this, msg,Toast.LENGTH_SHORT);
            finish();
        } else {
            ToastUtil.show(ZhuActivity.this, msg, Toast.LENGTH_SHORT);
        }
    }


}
