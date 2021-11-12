package com.example.ghichu_java2;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class adapterdanhmuc extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<danhmuc> danhmucList;
    //ham xay dung 3 doi so
    public  adapterdanhmuc (Context Context, int Layout, ArrayList<danhmuc> danhmucList){
        this.context = Context;
        this.layout = Layout;
        this.danhmucList = danhmucList;
    }

    @Override
    public int getCount() {
        return danhmucList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        //anh xa view
        TextView tvdanhmuc = (TextView) convertView.findViewById(R.id.tv_danhmuc);

        //Set du lieu vao view
        danhmuc dm = danhmucList.get(position);
        tvdanhmuc.setText(dm.getTenloai().toString());

        return convertView;
    }
}
