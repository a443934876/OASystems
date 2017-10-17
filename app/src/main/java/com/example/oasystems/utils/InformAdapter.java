package com.example.oasystems.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oasystems.R;

import java.util.List;

/**
 * 项目名称：OASystems
 * 创建时间：2017/9/27 17:37
 * 注释说明：
 */

public class InformAdapter extends BaseAdapter {

    private List<Inform> informList;
    private LayoutInflater inflater;

    public InformAdapter(List<Inform> informList, LayoutInflater inflater) {
        this.informList = informList;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return informList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View informView;
        if (convertView == null) {
            informView = inflater.inflate(R.layout.inform_item, null);
        } else {
            informView = convertView;
        }
        Inform inform = informList.get(position);
        ImageView imageView = (ImageView) informView.findViewById(R.id.imageView);
        TextView title = (TextView) informView.findViewById(R.id.tv_title);
        TextView content = (TextView) informView.findViewById(R.id.tv_content);
        TextView date = (TextView) informView.findViewById(R.id.tv_date);
        imageView.setImageResource(inform.getImageView());
        title.setText(inform.getTitle());
        content.setText(inform.getContent());
        date.setText(inform.getDate());
        return informView;
    }
}
