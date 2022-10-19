package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {
    private List<Game> gameList;

    public void setData(List<Game> list){
        this.gameList=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game,parent,false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Game game = gameList.get(position);
        if(game==null){
            return;
        }else {
            holder.img_View.setImageResource(game.getImg());
            holder.txt_TenGame.setText(game.getTenGame());
            holder.txt_MoTa.setText(game.getMoTa());
        }

    }

    @Override
    public int getItemCount() {
        if(!gameList.isEmpty()){
            return gameList.size();
        }
        return 0;
    }

    public  class GameViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_View;
        private TextView txt_TenGame;
        private TextView txt_MoTa;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            img_View = itemView.findViewById(R.id.img_game);
            txt_TenGame =itemView.findViewById(R.id.txt_tenGame);
            txt_MoTa =itemView.findViewById(R.id.txt_moTa);
        }
    }
}