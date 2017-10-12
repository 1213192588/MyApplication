package com.example.android_2;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by 123456 on 2017/9/30.
 */

public class PhoneRegister extends Activity implements View.OnClickListener{
    private CheckBox cb_accept;
    private Button btn_register;
    private EditText et_phone;
    private EditText et_code;
    private EditText et_password;
    private EditText et_repassword;
    private Button btn_code;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_register);
        initView();
        listener();
    }

    public void initView(){
        cb_accept = (CheckBox)findViewById(R.id.cb_accept);
        btn_register = (Button)findViewById(R.id.btn_register);
        et_phone = (EditText)findViewById(R.id.et_phone);
        et_code = (EditText)findViewById(R.id.et_code);
        et_password =(EditText)findViewById(R.id.et_password);
        et_repassword = (EditText)findViewById(R.id.et_repassword);
        btn_code = (Button)findViewById(R.id.btn_code);
    }

    public void listener(){
        //复选框勾选的事件监听
        cb_accept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                btn_register.setEnabled(b);
            }
        });
        //验证码按钮的事件监听
        btn_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                StringBuffer sb = new StringBuffer();
                for(int i=0;i<4;i++){
                    int number = r.nextInt(9);
                    sb.append(number);
                }
                et_code.setText(sb);
            }
        });
        //注册按钮的事件监听
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = String.valueOf(et_phone.getText());
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(PhoneRegister.this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
                }
                String code = String.valueOf(et_code.getText());
                if(TextUtils.isEmpty(code)){
                    Toast.makeText(PhoneRegister.this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                }
                String password = String.valueOf(et_password.getText());
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(PhoneRegister.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                String repassword = String.valueOf(et_repassword);
                if(TextUtils.isEmpty(repassword)){
                    Toast.makeText(PhoneRegister.this, "确认密码为空", Toast.LENGTH_SHORT).show();
                }
                if(!password.equals(repassword)){
                    Toast.makeText(PhoneRegister.this, "两次密码不一样", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(PhoneRegister.this,"手机号码:"+phone, Toast.LENGTH_SHORT).show();
                Toast.makeText(PhoneRegister.this,"验证码:"+code, Toast.LENGTH_SHORT).show();
                Toast.makeText(PhoneRegister.this, "密码:"+password, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
