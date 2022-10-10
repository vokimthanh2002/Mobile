package com.example.myapplication.game.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myapplication.R;
import com.example.myapplication.game.model.Game;

import java.util.List;

public class GameViewPagerAdapter extends PagerAdapter {
    List<Game> gameList;

    public GameViewPagerAdapter(List<Game> gameList) {
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo,container,false);
        ImageView imgPhoTo =view.findViewById(R.id.img_photo);
        Game game = gameList.get(position);
        imgPhoTo.setImageResource(game.getImg());
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if(gameList !=null){
            return  gameList.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
