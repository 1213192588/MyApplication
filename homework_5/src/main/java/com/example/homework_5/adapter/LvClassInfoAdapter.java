package com.example.homework_5.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework_5.R;
import com.example.homework_5.entity.Info;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123456 on 2017/10/10.
 */

public class LvClassInfoAdapter extends BaseAdapter {
    TextView tv_count;
    private static final String TAG = "MainActivity.class" ;
    //1.List集合Bean
    private List<Info> listInfo = new ArrayList<>();
    //2.布局加载器
    LayoutInflater mLayoutInflater;
    Context context;
    private int count=0;//记录选中的条数
    public LvClassInfoAdapter(List<Info> listInfo,Context context,TextView tv_count){
        this.listInfo = listInfo;
        mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.tv_count = tv_count;
    }
    @Override
    public int getCount() {
        return listInfo.size();
    }

    @Override
    public Object getItem(int i) {
        return listInfo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //1.加载布局文件以便找到控件
        View view1 = null;
        final ViewHolder mHolder;
        //第一次加载
        if(view==null){
            Log.i(TAG,"第一次");
            view1 = mLayoutInflater.inflate(R.layout.lv_info_item,null);
            mHolder = new ViewHolder();
            mHolder.iv_lv_head = view1.findViewById(R.id.iv_lv_head);
            mHolder.tv_lv_name = view1.findViewById(R.id.tv_lv_name);
            mHolder.tv_lv_phone = view1.findViewById(R.id.tv_lv_phone);
            mHolder.cb_select = view1.findViewById(R.id.cb_select);
            //建立view和mHolder的关联
            view1.setTag(mHolder);
        }else{
            Log.i(TAG,"重用");
            view1 = view;
            mHolder = (ViewHolder)view1.getTag();
        }
        //2.从集合中取出数据
        final Info info = listInfo.get(i);
        //3.绑定数据
        mHolder.iv_lv_head.setImageResource(info.getHead());
        mHolder.tv_lv_name.setText(info.getName());
        mHolder.tv_lv_phone.setText(info.getphone());
        //添加事件监听
        mHolder.cb_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mHolder.cb_select.isChecked()){
                    //如果是被选中的话
                    //存起来
                    info.setHasChecked(true);
                    count++;
                }else {
                    info.setHasChecked(false);
                    count--;
                }
            }
        });
        /*mHolder.cb_select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                info.setHasChecked(b);
            }
        });*/
        tv_count.setText(count+"");
        //Toast.makeText(context, count+"", Toast.LENGTH_SHORT).show();
        mHolder.cb_select.setChecked(info.isHasChecked());
        //隔行换色
        if(i%2==0){
            view1.setBackgroundColor(context.getResources().getColor(android.R.color.holo_blue_light));
        }else {
            view1.setBackgroundColor(Color.WHITE);
        }
        return view1;
    }

    private static class ViewHolder{
        CheckBox cb_select;
        ImageView iv_lv_head;
        TextView tv_lv_name;
        TextView tv_lv_phone;
    }
}
