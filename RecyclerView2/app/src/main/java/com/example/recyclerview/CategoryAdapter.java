package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context mContext;
    private List<Category> mListcategory;

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<Category> list){
        this.mListcategory=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category =mListcategory.get(position);
        if(category==null){
            return;
        }

        holder.txt_gamXuHuong.setText(category.getGameXuHuong());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false);
        holder.rcv_game.setLayoutManager(linearLayoutManager);
        GameAdapter gameAdapter = new GameAdapter();
        gameAdapter.setData(category.getGameList());
        holder.rcv_game.setAdapter(gameAdapter);
    }

    @Override
    public int getItemCount() {
        if(!mListcategory.isEmpty()){
            return mListcategory.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_gamXuHuong;
        private RecyclerView rcv_game;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_gamXuHuong= itemView.findViewById(R.id.txt_xuHuong);
            rcv_game =itemView.findViewById(R.id.rcv_game);
        }
    }
}
