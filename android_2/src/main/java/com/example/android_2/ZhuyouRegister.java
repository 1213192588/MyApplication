package com.example.android_2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 123456 on 2017/9/30.
 */

public class ZhuyouRegister extends Activity {
   private  static  final String[] c = {"中国","澳大利亚","美国","英国","加拿大"};
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private EditText et_country;
    private EditText et_region;
    private EditText et_city;
    private EditText et_name;
    private EditText et_email;
    private EditText et_reEmail;
    private EditText et_phone;
    private EditText et_password;
    private EditText et_rePassword;
    private CheckBox cb_accept;
    private Button btn_register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuyou_register);
        initView();
        listener();
    }

    public void initView(){
        et_country = (EditText)findViewById(R.id.et_country);
        et_region = (EditText)findViewById(R.id.et_region);
        et_city = (EditText)findViewById(R.id.et_city);
        et_name = (EditText)findViewById(R.id.et_name);
        et_email = (EditText)findViewById(R.id.et_email);
        et_reEmail = (EditText)findViewById(R.id.et_reEmail);
        et_phone = (EditText)findViewById(R.id.et_phone);
        et_password = (EditText)findViewById(R.id.et_password);
        et_rePassword = (EditText)findViewById(R.id.et_repassword);
        cb_accept = (CheckBox)findViewById(R.id.cb_accept);
        spinner= (Spinner) findViewById(R.id.spinner_1);
        btn_register = (Button)findViewById(R.id.btn_register);
        //将可选内容与ArrayAdapter连接起来
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,c);
        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter添加到spinner中
        spinner.setAdapter(adapter);
        //添加事件Spinner事件监听
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
        //设置默认值
        spinner.setVisibility(View.VISIBLE);

    }

    public void listener(){
        cb_accept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                btn_register.setEnabled(b);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country = String.valueOf(et_country.getText());
                String region = String.valueOf(et_region.getText());
                Toast.makeText(ZhuyouRegister.this, region, Toast.LENGTH_SHORT).show();
                Toast.makeText(ZhuyouRegister.this, country, Toast.LENGTH_SHORT).show();
            }
        });

    }

    //使用数组形式操作
    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            et_country.setText(c[i]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}
