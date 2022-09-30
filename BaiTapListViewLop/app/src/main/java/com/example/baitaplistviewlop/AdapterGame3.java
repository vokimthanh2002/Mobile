package com.example.baitaplistviewlop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterGame3 extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Game> gameList;

    public AdapterGame3(Context context, int layout, List<Game> gamelist) {
        this.context = context;
        this.layout = layout;
        this.gameList = gamelist;
    }

    @Override
    public int getCount() {
        return gameList.size();
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
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view= layoutInflater.inflate(layout,null);
        // anh xa view
        ImageView imgView =(ImageView) view.findViewById(R.id.imgHinhDl);
        TextView txtTenGame= (TextView) view.findViewById(R.id.txtTenGameDl);
        TextView txtMoTa= (TextView) view.findViewById(R.id.txtMoTaDl);
        TextView txtDungLuong= (TextView) view.findViewById(R.id.txtDUngLuongDl);

        Game game = gameList.get(i);
        imgView.setImageResource(game.getImg());
        txtTenGame.setText(game.getTenGame());
        txtMoTa.setText(game.getMoTa());
        txtDungLuong.setText(game.getDungLuong());
        return view;
    }
}