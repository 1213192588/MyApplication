package com.example.homework_5.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homework_5.R;
import com.example.homework_5.entity.Info;

import java.util.ArrayList;
import java.util.List;

import static com.example.homework_5.R.id.iv_lv_head;
import static com.example.homework_5.R.id.tv_lv_name;

/**
 * Created by 123456 on 2017/10/10.
 */

public class BaseInfoAdapter extends BaseAdapter {
    private static final String TAG = "BaseInfoAdapter.class";
    //1.List集合Bean
    private List<Info> listInfo = new ArrayList<>();
    //2.布局加载器
    LayoutInflater mLayoutInflater;

    public BaseInfoAdapter(List<Info> listInfo, Context context){
        this.listInfo = listInfo;
        mLayoutInflater = LayoutInflater.from(context);
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
        ViewHolder mHolder;
        if(view==null){
            Log.i(TAG, "第一次");
            view1 = mLayoutInflater.inflate(R.layout.lv_baseinfo_item,null);
            mHolder = new ViewHolder();
            mHolder.iv_lv_head = view1.findViewById(iv_lv_head);
            mHolder.tv_lv_name = view1.findViewById(tv_lv_name);
            mHolder.tv_lv_phone = view1.findViewById(R.id.tv_lv_phone);
            //建立view和mHolder的关联
            view1.setTag(mHolder);
        }else{
            Log.i(TAG,"重用");
            view1 = view;
            mHolder =(ViewHolder) view1.getTag();
        }
        //2.从集合中取出数据
        Info info = listInfo.get(i);
        //绑定数据
        mHolder.iv_lv_head.setImageResource(info.getHead());
        mHolder.tv_lv_name.setText(info.getName());
        mHolder.tv_lv_phone.setText(info.getphone());
        return view1;
    }
    private static class ViewHolder{
        ImageView iv_lv_head;
        TextView tv_lv_name;
        TextView tv_lv_phone;
    }
}
