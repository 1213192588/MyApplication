package com.example.android_4;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by 123456 on 2017/10/3.
 */

public class Spinner_layout extends Activity {
    private AutoCompleteTextView actv;
    private Spinner sp_class;
    private ListView lv_class;
    private GridView gv_seat;
    private ArrayAdapter spAdapter;
    private ArrayAdapter actvAdapter;

    //如果要放图片,SimpleAdapter,特点:数据必须封装成List<Map<key,value>>
    private SimpleAdapter lvAdapter;
    private SimpleAdapter gvAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_layout);
        initView();
        getSpinner();//注意:数据最终是需要得到的,所有的适配器应该设置为全局
        getActv();
        getData();
        getListView();
        getGridView();
        listener();
    }
    private void listener(){
        //为ListView添加事件监听
        lv_class.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //最重要的是position 就是用户点击条目的下标,它于适配器中数据下标一致
                Map<String,Object> map = (Map<String,Object>)lvAdapter.getItem(i);
                Toast.makeText(Spinner_layout.this, map.get("name")+","+map.get("age"), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //准备数据
    List<Map<String,Object>> lists;
    private void getData(){
        lists = new ArrayList<>();
        int heads[] = {R.drawable.gasses,R.drawable.luggage,R.drawable.music,R.drawable.taxicab};
        for (int i=0;i<20;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("name","八嘎雅鹿"+i);
            map.put("age",20+i);
            map.put("status",i%4==0?"在校":"离校");
            map.put("head",heads[i%4]);
            lists.add(map);
        }
    }
    private void getGridView(){
        gvAdapter = new SimpleAdapter(
                Spinner_layout.this,
                lists,
                R.layout.gv_seat_item,
                new String[]{"head","name"},
                new int[]{R.id.iv_head,R.id.tv_name
                });
        //绑定
        gv_seat.setAdapter(gvAdapter);
    }

    private void getListView(){
        lvAdapter = new SimpleAdapter(
            Spinner_layout.this,//上下文
               lists,//List<Map<key,value>>
                //android.R.layout.simple_list_item_1,//xml,安卓自带的
                R.layout.lv_classinfo_item,//xml,自定义
                new String[]{"name","age","status"},
                new int[]{R.id.tv_name,R.id.tv_age,R.id.tv_status}
        );
        lv_class.setAdapter(lvAdapter);
    }
    private void getActv(){
        String names[] = {"apple","android","blue","and","car"};
        //如何打一个字的时候匹配
        //xml文件式(设置此控件的属性),代码式
        actvAdapter = new ArrayAdapter(Spinner_layout.this,R.layout.sp_class_item,names);
        actv.setAdapter(actvAdapter);
    }

    private void getSpinner(){
        //适配器是什么:装配数据到视图上!
        //1.准备数据
        String classes[] = {"中国","美国","加拿大","英国"};
        //2.准备数组适配器
        /*ArrayAdapter spAdapter = new ArrayAdapter(
                Spinner_layout.this,//上下文
                //android.R.layout.simple_spinner_dropdown_item,
                R.layout.sp_class_item,//自定义的xml
                //数据---数组
                classes
        );*/
        spAdapter = ArrayAdapter.createFromResource(Spinner_layout.this,R.array.classes,R.layout.sp_class_item);
        //3.绑定适配器
        sp_class.setAdapter(spAdapter);
    }

    private void initView(){
        actv = (AutoCompleteTextView)findViewById(R.id.actv);
        sp_class = (Spinner)findViewById(R.id.sp_class);
        lv_class = (ListView)findViewById(R.id.lv_class);
        gv_seat = (GridView)findViewById(R.id.gv_seat);
    }
}
