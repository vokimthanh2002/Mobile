package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText edtPass,edtUse;
    public Button btnDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        controlButton();
    }
    private void  controlButton() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUse.getText().length() != 0 && edtPass.getText().length() != 0) {
                    if (edtUse.getText().toString().equals("vokimthanh") && edtPass.getText().toString().equals("123")) {
                        Toast.makeText(MainActivity.this, "Ban da dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Sai thong tin tai khoan hoac mat khau", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Moi ban nhap du thong tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void anhxa() {
        edtUse= (EditText) findViewById(R.id.edtUseName);
        edtPass= (EditText) findViewById(R.id.edtPassword);
        btnDangNhap= (Button) findViewById(R.id.btnLogin);
    }

}