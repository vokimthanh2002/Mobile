package com.example.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChiTietBaiThoActivity extends AppCompatActivity {
    TextView txtChiTietBaiTho;
    TextView txtBaiTho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_bai_tho);
        txtChiTietBaiTho =(TextView) findViewById(R.id.chitiettho);
        txtBaiTho =(TextView) findViewById(R.id.baitho);
        Intent intent= getIntent();
        txtChiTietBaiTho.setText(intent.getStringExtra("tentacpham"));
        if(intent.getStringExtra("tentacpham").equals("Trời Mỗi Ngày Lại Sáng")){
            txtBaiTho.setText(ChiTietBaiTho.TROIMOINGAYMOISANG);
        }else if(intent.getStringExtra("tentacpham").equals("Ba Lần Về Thăm Bát Tràng")){
            txtBaiTho.setText(ChiTietBaiTho.BALANVETHAMBATTRANG);
        }else if(intent.getStringExtra("tentacpham").equals("Bài Thơ Cuộc Đời")){
            txtBaiTho.setText(ChiTietBaiTho.BAITHOCUOCDOI);
        }else if(intent.getStringExtra("tentacpham").equals("Đoàn Thuyền Đánh Cá")){
            txtBaiTho.setText(ChiTietBaiTho.DOANTHUYENDANHCA);
        }else if(intent.getStringExtra("tentacpham").equals("Tràng Giang")){
            txtBaiTho.setText(ChiTietBaiTho.TRANGGIANG);
        }
        ImageView imgBack= (ImageView) findViewById(R.id.btnBackChiTiet);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChiTietBaiThoActivity.this,DetailActivity.class));
            }
        });
    }


}