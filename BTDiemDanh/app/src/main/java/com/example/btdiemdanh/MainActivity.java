package com.example.btdiemdanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ten,msv,gioitinh,lop,sdt;
    Button nhap, huy;
    SinhVien sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();

        nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sv = new SinhVien();
                sv.setMSV(msv.getText().toString());
                sv.setHoTen(ten.getText().toString());
                sv.setGioiTinh(gioitinh.getText().toString());
                sv.setLop(lop.getText().toString());
                sv.setSDT(sdt.getText().toString());
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("key_1", sv.getMSV());
                intent.putExtra("key_2", sv.getHoTen());
                intent.putExtra("key_3", sv.getGioiTinh());
                intent.putExtra("key_4", sv.getLop());
                intent.putExtra("key_5", sv.getSDT());
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        ten = (EditText) findViewById(R.id.ten);
        msv = (EditText) findViewById(R.id.msv);
        gioitinh = (EditText) findViewById(R.id.gioitinh);
        lop = (EditText) findViewById(R.id.lop);
        sdt = (EditText) findViewById(R.id.sdt);
    }
}