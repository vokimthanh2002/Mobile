package com.example.qanlysinhviensqlite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SinhVienActivity extends AppCompatActivity {
    ListSinhVien listSinhVien331;
    SinhVienAdapter sinhVienAdapter331;
    ListView sinhVien331;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinhvien);
        Intent intent = getIntent();
        listSinhVien331 = (ListSinhVien) intent.getSerializableExtra("SinhVienList");
        sinhVienAdapter331 = new SinhVienAdapter(listSinhVien331, SinhVienActivity.this);
        sinhVien331 = findViewById(R.id.sinhVienList);
        sinhVien331.setAdapter(sinhVienAdapter331);
    }

}
