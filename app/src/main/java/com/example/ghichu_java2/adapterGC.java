package com.example.ghichu_java2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class adapterGC extends BaseAdapter {

    private Context context;
    private int layout;
    private List<ghichu> ghichuList;
    //ham xay dung 3 doi so
    public adapterGC(Context Context, int Layout, List<ghichu> GhichuList){
        this.context = Context;
        this.layout = Layout;
        this.ghichuList = GhichuList;
    }
    @Override
    public int getCount() {
        return ghichuList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        //anh xa view
        TextView tvNoidung = (TextView) convertView.findViewById(R.id.tv_Noidung);
        TextView tvDate = (TextView) convertView.findViewById(R.id.tv_Date);
//      TextView tvLoai = (TextView) convertView.findViewById(R.id.tv_Loai);

        //Set du lieu vao view
        ghichu gc = ghichuList.get(position);
        tvNoidung.setText(gc.getNoidung().toString());
        tvDate.setText(gc.getThoigiantao().toString());
//      tvLoai.setText(gc.getTenloai().toString());

        return convertView;
    }


}
