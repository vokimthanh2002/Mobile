package com.example.qanlysinhviensqlite;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LopAdapter extends BaseAdapter {
    List<Lop> lopList;
    private Activity activity;

    public LopAdapter(List<Lop> lopList, Activity activity) {
        this.lopList = lopList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return lopList.size();
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
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.activity_custom_lop, null);
        TextView maLopTVAX = view.findViewById(R.id.maLopTV);
        TextView tenLopTVAX = view.findViewById(R.id.tenLopTV);
        Lop lop = lopList.get(i);
        maLopTVAX.setText(lop.getMaLop());
        tenLopTVAX.setText(lop.getTenLop());
        return view;
    }
}
