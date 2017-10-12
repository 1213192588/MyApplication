package com.example.homework_5;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.homework_5.adapter.BaseInfoAdapter;
import com.example.homework_5.entity.Info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123456 on 2017/10/9.
 */

public class Homework_4_1 extends Activity {
    private AutoCompleteTextView actv_name;
    private String names[];
    private ArrayAdapter<String> nameAdapter;

    private Spinner sp_class;
    private ArrayAdapter<String> classAdapter;
    private String classes[];

    private ListView lv_baseInfo;
    private SimpleAdapter baseInfoAdapter;
    private List<Map<String,Object>> infoLists;

    private GridView gv_seat_info;
    private SimpleAdapter seatInfoAdpter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_4_1);
        //准备控件
        initView();
        //准备数据
        initData();
        //准备适配器
        initAdapter();
        //绑定
        initBinder();
        //事件监听
        initListener();
    }

    private void initListener() {
        lv_baseInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //如何获取选中条目的值
                //所有的数据在Adpter中,就从这里面拿
                Map<String,Object> map =(Map<String, Object>) baseInfoAdapter.getItem(i);
                String name = (String)map.get("name");
                String phone = (String)map.get("phone");
                Toast.makeText(Homework_4_1.this, name+","+phone, Toast.LENGTH_SHORT).show();
            }
        });
        gv_seat_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Map<String,Object> map = (Map<String,Object>)seatInfoAdpter.getItem(i);
                String name = (String)map.get("name");
                String phone = (String)map.get("phone");
                Toast.makeText(Homework_4_1.this, name+","+phone, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initBinder() {
        actv_name.setAdapter(nameAdapter);
        sp_class.setAdapter(classAdapter);
        lv_baseInfo.setAdapter(new BaseInfoAdapter(getAllInfo(),Homework_4_1.this));
        gv_seat_info.setAdapter(seatInfoAdpter);
    }
    
    private List<Info> getAllInfo(){
        List<Info> lists = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            Info info = new Info();
            info.setHead(android.R.drawable.ic_menu_camera);
            info.setName("张三"+i);
            info.setphone("1111"+i);
            lists.add(info);
        }
        return lists;
    }

    private void initAdapter() {
        nameAdapter = new ArrayAdapter<String>(this,R.layout.actv_name,R.id.tv_name,names);
        classAdapter = new ArrayAdapter<String>(this,R.layout.actv_name,R.id.tv_name,classes);
        baseInfoAdapter = new SimpleAdapter(
                this,
                infoLists,
                R.layout.lv_baseinfo_item,
                new String[]{"head","name","phone"},
                new int[]{R.id.iv_lv_head,R.id.tv_lv_name,R.id.tv_lv_phone}
                );
        seatInfoAdpter = new SimpleAdapter(
                this,
                infoLists,
                R.layout.gv_seat_baseinfo_item,
                new String[]{"head","name"},
                new int[]{R.id.iv_lv_head,R.id.tv_lv_name}

        );
    }

    private void initData() {
        names = new String[]{"apple","add","BLUE","CAR","cat"};
        classes = new String[]{"Java78","Java79","Java80","Java81"};
        getInfoData();
    }

    private void getInfoData(){
        infoLists = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("head",android.R.drawable.ic_menu_camera);
            map.put("name","张三"+i);
            map.put("phone","132131"+i);
            infoLists.add(map);
        }
    }

    private void initView() {
        actv_name = findViewById(R.id.actv_name);
        sp_class = findViewById(R.id.sp_class);
        lv_baseInfo = findViewById(R.id.lv_baseInfo);
        gv_seat_info = findViewById(R.id.gv_seat_info);
    }
}
