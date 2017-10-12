package com.example.android_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox cb_accept;
    private Button btn_register;
    private RadioGroup rg_sex;
    private RadioButton rb_boy;
    private RadioButton rb_girl;
    private CheckBox cb_sport,cb_code,cb_music;
    private EditText et_userName;
    private EditText et_password;
    private EditText et_repassword;
    private EditText et_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.register_layout);
        initView();
        listener();
    }
    private void initView(){
        cb_accept =(CheckBox) findViewById(R.id.cb_accept);
        btn_register = (Button)findViewById(R.id.btn_register);
        rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
        cb_sport = (CheckBox)findViewById(R.id.cb_sport);
        cb_code = (CheckBox)findViewById(R.id.cb_code);
        cb_music = (CheckBox)findViewById(R.id.cb_music);
        et_userName = (EditText)findViewById(R.id.et_userName);
        et_password = (EditText)findViewById(R.id.et_password);
        et_repassword = (EditText)findViewById(R.id.et_repassword);
        et_email = (EditText)findViewById(R.id.et_email);
    }
    private void listener(){
        //复选框勾选的事件监听
        cb_accept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //Toast.makeText(MainActivity.this, b+"", Toast.LENGTH_SHORT).show();
                btn_register.setEnabled(b);
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.获取性别
                String sex = null;
                //获得按钮组被选按钮的id
                int id = rg_sex.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(id);
                sex = (String) rb.getText();

                //2.获取兴趣爱好
                StringBuffer hobby = new StringBuffer();
                if(cb_sport.isChecked()){
                    hobby.append(cb_sport.getText().toString());
                    hobby.append(",");
                }
                if(cb_code.isChecked()){
                    hobby.append(cb_code.getText().toString());
                    hobby.append(",");
                }
                if(cb_music.isChecked()){
                    hobby.append(cb_music.getText().toString());
                    hobby.append(",");
                }
                //删除最后一个逗号
                hobby.deleteCharAt(hobby.length()-1);
                Editable userName1 = et_userName.getText();
                String userName = String.valueOf(userName1);
                String password = String.valueOf(et_password.getText());
                String repassword = String.valueOf(et_repassword.getText());
                String email = String.valueOf(et_email.getText());
                Toast.makeText(MainActivity.this, "用户名:"+userName, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "密码:"+password, Toast.LENGTH_SHORT).show();
                if(!userName.equals(repassword)){
                    Toast.makeText(MainActivity.this, "两次密码不一样", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity.this, "邮箱地址:"+email, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"性别:"+sex, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "兴趣:"+hobby, Toast.LENGTH_SHORT).show();
                Log.i("",hobby.toString());
            }
        });
    }

}
