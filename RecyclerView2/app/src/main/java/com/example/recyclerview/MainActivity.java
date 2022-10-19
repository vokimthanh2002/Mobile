package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView) findViewById(R.id.rcv_category);
        categoryAdapter= new CategoryAdapter(MainActivity.this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(getListcategory());
        recyclerView.setAdapter(categoryAdapter);
    }


    private List<Category> getListcategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Game>  gameArrayList = new ArrayList<>();
        gameArrayList.add(new Game("CS Go",R.drawable.csgo,"Game ban sung"));
        gameArrayList.add(new Game("Lien Minh",R.drawable.lmht,"Game ban sung"));
        gameArrayList.add(new Game("Fifa online 4",R.drawable.ffo,"Game da bong"));
        gameArrayList.add(new Game("Lien quan mobile",R.drawable.lq,"Game chien thuat"));
        gameArrayList.add(new Game("Minecraft",R.drawable.mig,"Game phieu luu"));
        gameArrayList.add(new Game("Pubg",R.drawable.pubg,"Game ban sung"));
        gameArrayList.add(new Game("Free Fire",R.drawable.ff,"Game ban sung"));
        gameArrayList.add(new Game("Gta 5",R.drawable.gta,"Game kham pha"));
        gameArrayList.add(new Game("Warcraft",R.drawable.warcraft,"Game phieu luu"));
        gameArrayList.add(new Game("CS Go",R.drawable.csgo,"Game ban sung"));
        gameArrayList.add(new Game("Lien Minh",R.drawable.lmht,"Game ban sung"));
        gameArrayList.add(new Game("Fifa online 4",R.drawable.ffo,"Game da bong"));
        gameArrayList.add(new Game("Lien quan mobile",R.drawable.lq,"Game chien thuat"));
        gameArrayList.add(new Game("Minecraft",R.drawable.mig,"Game phieu luu"));
        gameArrayList.add(new Game("Pubg",R.drawable.pubg,"Game ban sung"));
        listCategory.add(new Category("Game de xuat",gameArrayList));
        listCategory.add(new Category("Game chien thuat",gameArrayList));
        listCategory.add(new Category("Game ban sung",gameArrayList));
        listCategory.add(new Category("Game ban sung",gameArrayList));
        listCategory.add(new Category("Game sing ton",gameArrayList));
        listCategory.add(new Category("Game chien thuat",gameArrayList));
        listCategory.add(new Category("Game ban sung",gameArrayList));
        listCategory.add(new Category("Game ban sung",gameArrayList));
        listCategory.add(new Category("Game sing ton",gameArrayList));
        return listCategory;
    }
    }
