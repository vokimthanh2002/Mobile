package com.example.fbase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    EditText ten, anh, tenThuong, dacTinh, mauLa,chuY,congDung,duocTinh;
    Button btnSave, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ten = (EditText) findViewById(R.id.txtName);
        tenThuong = (EditText) findViewById(R.id.txttinhtrang);
        dacTinh = (EditText) findViewById(R.id.txtdactinh);
        mauLa = (EditText) findViewById(R.id.txtmau);
        chuY = (EditText) findViewById(R.id.txtchuy);
        congDung = (EditText) findViewById(R.id.txtcongdung);
        duocTinh = (EditText) findViewById(R.id.txtduoctinh);
        anh = (EditText) findViewById(R.id.ivanh);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                clearAll();
                startActivity(new Intent(AddActivity.this, MainActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddActivity.this, MainActivity.class));
            }
        });
    }

    private void insertData(){
        Map<String, Object> map = new HashMap<>();
        map.put("tenKhoahoc", ten.getText().toString());
        map.put("tenThuongGoi", tenThuong.getText().toString());
        map.put("dacTinh", tenThuong.getText().toString());
        map.put("mauLa", tenThuong.getText().toString());
        map.put("chuY", chuY.getText().toString());
        map.put("congDung", congDung.getText().toString());
        map.put("duocTinh", duocTinh.getText().toString());
        map.put("hinhAnh", anh.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("caythuocnam").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddActivity.this, "Error while Insertion", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private  void clearAll(){
        ten.setText("");
        tenThuong.setText("");
        dacTinh.setText("");
        mauLa.setText("");
        chuY.setText("");
        duocTinh.setText("");
        congDung.setText("");
        anh.setText("");
    }
}