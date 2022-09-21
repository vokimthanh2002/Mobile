package com.example.btdiemdanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView ten,msv,gt,lop,sdt;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Anhxa();
        Intent intent1 = getIntent();
        msv.setText(intent1.getStringExtra("key_1"));
        ten.setText(intent1.getStringExtra("key_2"));
        gt.setText(intent1.getStringExtra("key_3"));
        lop.setText(intent1.getStringExtra("key_4"));
        sdt.setText(intent1.getStringExtra("key_5"));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        ten = (TextView) findViewById(R.id.tenl2);
        msv = (TextView) findViewById(R.id.msvl2);
        gt = (TextView) findViewById(R.id.gtl2);
        lop = (TextView) findViewById(R.id.lopl2);
        sdt = (TextView) findViewById(R.id.sdtl2);
        back = (Button) findViewById(R.id.back);
    }
}