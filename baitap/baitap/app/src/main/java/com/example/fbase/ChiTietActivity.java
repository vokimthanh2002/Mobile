package com.example.fbase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ChiTietActivity extends AppCompatActivity {
    TextView ten, tenThuong, dacTinh;
    ImageView nen,anh, backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        ten = (TextView) findViewById(R.id.ten_ct);
        tenThuong = (TextView) findViewById(R.id.tinhtrang);
        dacTinh = (TextView) findViewById(R.id.thongtin_ct);
        nen = (ImageView) findViewById(R.id.iv_nen);
        anh = (ImageView) findViewById(R.id.iv_anh_ct);
        backbtn = (ImageView) findViewById(R.id.back_btn);

        Intent intent = getIntent();
        ten.setText(intent.getStringExtra("tenKhoaHoc"));
        tenThuong.setText(intent.getStringExtra("tenThuongGoi"));
        dacTinh.setText(intent.getStringExtra("dacTinh"));
        new LoadImage().execute(intent.getStringExtra("hinhAnh"));

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChiTietActivity.this, MainActivity.class));
            }
        });
    }

    private class LoadImage extends AsyncTask<String, Void, Bitmap> {
        Bitmap bitmapHinh = null;
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);

                InputStream inputStream = url.openConnection().getInputStream();

                bitmapHinh = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmapHinh;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            nen.setImageBitmap(bitmap);
            anh.setImageBitmap(bitmap);
        }

    }
}