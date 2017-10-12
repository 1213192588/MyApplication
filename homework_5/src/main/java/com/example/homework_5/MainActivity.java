package com.example.homework_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework_5.adapter.LvClassInfoAdapter;
import com.example.homework_5.entity.Info;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv_info;
    private LvClassInfoAdapter infoAdapter;
    private TextView tv_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        tv_count =(TextView) findViewById(R.id.tv_count);
        lv_info =(ListView) findViewById(R.id.lv_info);
        infoAdapter = new LvClassInfoAdapter(getAllClassInfo(),MainActivity.this,tv_count);
        lv_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //如何获取选中条目的值
                //所有的数据在Adapter中,就从这里面拿
                Info info = (Info) infoAdapter.getItem(i);
                Toast.makeText(MainActivity.this, info.getName()+":"+info.getphone(), Toast.LENGTH_SHORT).show();
            }
        });
        lv_info.setAdapter(infoAdapter);
    }
    private List<Info> getAllClassInfo(){
        List<Info> lists = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            Info info = new Info();
            info.setHead(android.R.drawable.ic_menu_camera);
            info.setName("李四"+i);
            info.setphone("110"+i);
            lists.add(info);
        }
        return lists;
    }
}
