package com.lv.mama.lv.kind.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lv.mama.lv.R;
import com.lv.mama.lv.kind.bean.DateGridBean;

import java.util.List;


/**
 * Created by 武晓瑞 on 2017/10/20.
 */

public class MyAdapter_TypeGridView extends BaseAdapter {
    private Context context;
    private List<DateGridBean.DatasBean.ClassListBean> list;

    public MyAdapter_TypeGridView(Context context, List<DateGridBean.DatasBean.ClassListBean> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.type_grid_item,null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.tv_gv_type);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position).getGc_name());
        return convertView;
    }
    class ViewHolder{
        TextView tv;
    }
}

