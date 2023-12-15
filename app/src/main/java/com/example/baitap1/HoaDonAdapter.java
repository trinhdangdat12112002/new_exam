package com.example.baitap1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HoaDonAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<HoaDon> arrayList;

    public HoaDonAdapter(Context context, int layout, ArrayList<HoaDon> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);


        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvSoPhong = (TextView) view.findViewById(R.id.tvSoPhong);
        TextView tvTongTien = (TextView) view.findViewById(R.id.tvTongTien);



        HoaDon hoadon = arrayList.get(i);
        tvName.setText(hoadon.getName());
        tvSoPhong.setText(hoadon.getSophong() + "");
        float tongtien = hoadon.getDongia()*hoadon.getNgay();
        tvTongTien.setText(tongtien + "");
        return view;
    }

    public void setData(ArrayList<HoaDon> newData) {
        this.arrayList = newData;
    }
}
