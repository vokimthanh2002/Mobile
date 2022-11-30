package com.example.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListTacGiaActivity extends AppCompatActivity {
    ListView listViewTacGia;
    ArrayList<TacGia> tacGiaArrayList;
    AdapterTacGia adapterTacGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tac_gia);
        listViewTacGia =(ListView) findViewById(R.id.listView);
        tacGiaArrayList = new ArrayList<>();
        tacGiaArrayList.add(new TacGia(R.drawable.huycan,"Huy Cận","Nhà Văn","4.5 Sao","Việt Nam"));
        tacGiaArrayList.add(new TacGia(R.drawable.tohuu,"Tố Hữu","Nhà Văn","4.5 Sao","Việt Nam"));
        tacGiaArrayList.add(new TacGia(R.drawable.macngon,"Mạc Ngôn","Nhà Văn","5 Sao","Trung Quốc"));
        tacGiaArrayList.add(new TacGia(R.drawable.shakespeare,"Shakespeare","Nhà Văn","3 Sao","Anh"));
        tacGiaArrayList.add(new TacGia(R.drawable.hemingway,"Hemingway","Nhà Văn","5 Sao","Pháp"));

        adapterTacGia = new AdapterTacGia(ListTacGiaActivity.this,R.layout.custom_line_tacgia, tacGiaArrayList);
        listViewTacGia.setAdapter(adapterTacGia);

      listViewTacGia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              Intent intent = new Intent(ListTacGiaActivity.this,DetailActivity.class);
              intent.putExtra("name",tacGiaArrayList.get(i).getTen());
              startActivity(intent);
          }
      });
    }
}