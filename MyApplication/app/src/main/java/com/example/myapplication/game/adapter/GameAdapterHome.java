package com.example.myapplication.game.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.game.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameAdapterHome extends ArrayAdapter<Game> {
    private Context context;
    private ArrayList<Game> gameArrayList;

    public GameAdapterHome(@NonNull Context context, int resource, @NonNull List<Game> objects) {
        super(context, resource, objects);
        this.context= context;
        this.gameArrayList= new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView ==null){
            LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= layoutInflater.inflate(R.layout.item_game,null);
        }
        if(gameArrayList.size()>0){
            Game game = this.gameArrayList.get(position);

            ImageView imggame =(ImageView) convertView.findViewById(R.id.img_game);
            TextView txtTenGame=(TextView) convertView.findViewById(R.id.txt_tenGame);
            TextView txtMoTa=(TextView) convertView.findViewById(R.id.txt_moTa);
            imggame.setImageResource(game.getImg());
            txtTenGame.setText(game.getTenGame());
            txtMoTa.setText(game.getMoTa());
        }
        return convertView;
    }
}
