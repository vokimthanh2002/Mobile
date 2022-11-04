package com.example.qanlysinhviensqlite;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    List<SinhVien> sinhVienList331;
    Activity activity331;

    public SinhVienAdapter(ListSinhVien sinhVienList331, Activity activity331) {
        this.sinhVienList331 = sinhVienList331.getSinhVienList();
        this.activity331 = activity331;
    }

    @Override
    public int getCount() {
        return sinhVienList331.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity331.getLayoutInflater();
        view = inflater.inflate(R.layout.activity_custom_sinhvien, null);
        TextView maSVTVAX = view.findViewById(R.id.maSVTV);
        TextView tenSVTVAX = view.findViewById(R.id.tenSVTV);
        TextView maLopSVTVAX = view.findViewById(R.id.maLopSVTV);
        SinhVien sinhVien = sinhVienList331.get(i);
        maSVTVAX.setText(sinhVien.getMaLop());
        tenSVTVAX.setText(sinhVien.getTenSV());
        maLopSVTVAX.setText(sinhVien.getMaLop());
        return view;
    }
}
