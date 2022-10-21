package com.example.baitapgiuakilythuyet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySignIn extends AppCompatActivity {
    private EditText edtPassWord,edtUseName;
    private TextView editTextForgotPassword;
    private Button btnSignIn, btnSignIn_SignUp;
    private ImageView imageViewFbLogin,imageViewEmailLogin;
    private ImageButton imageButtonMat,imageButtonNhamMat;
    public static DatabaseHelper database;
    private CheckBox checkBox;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        database= new DatabaseHelper(ActivitySignIn.this);
        edtUseName= (EditText) findViewById(R.id.edtUserName);
        edtPassWord= (EditText) findViewById(R.id.edtPassword);
        btnSignIn= (Button) findViewById(R.id.btnSignIn);
        btnSignIn_SignUp =(Button) findViewById(R.id.btnSignIn_SignUp);
        imageViewFbLogin=(ImageView) findViewById(R.id.imgfblogin);
        imageViewEmailLogin=(ImageView) findViewById(R.id.imggmaillogin);
        imageButtonMat=(ImageButton) findViewById(R.id.imgMat);
        imageButtonNhamMat=(ImageButton) findViewById(R.id.imgNhamMat);
        editTextForgotPassword=(TextView) findViewById(R.id.forgotPassword);
        imageButtonNhamMat.setVisibility(View.INVISIBLE);
        checkBox =(CheckBox) findViewById(R.id.checkbox);
        controlButton();
        return ;
    }
    boolean status=false;
    private void  controlButton() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUseName.getText().length() != 0 && edtPassWord.getText().length() != 0) {
                    Cursor dataAccount = database.GetData("SELECT * FROM DuLieuTaiKhoan");
                    while (dataAccount.moveToNext()){
                        String userName =dataAccount.getString(0);
                        String password =dataAccount.getString(1);
                        if (edtUseName.getText().toString().equals(userName) && edtPassWord.getText().toString().equals(password) ) {
                            Toast.makeText(ActivitySignIn.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ActivitySignIn.this, ActivityContaint.class));
                            status=true;
                            if(checkBox.isChecked()){
                                SharedPreferences .Editor editor = sharedPreferences.edit();
                                editor.putString("taikhoan",userName);
                                editor.putString("matkhau",password);
                                editor.putBoolean("checked",true);
                                editor.commit();
                            }else{
                                SharedPreferences.Editor  editor = sharedPreferences.edit();
                                editor.remove("taikhoan");
                                editor.remove("matkhau");
                                editor.remove("checked");
                                editor.commit();
                            }
                            break;
                        }
                    }
                    if(!dataAccount.moveToNext()&&!status)  {
                        Toast.makeText(ActivitySignIn.this, "Sai thông tin tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ActivitySignIn.this, "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSignIn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivitySignIn.this, ActivitySignUp.class);
                startActivity(intent);
            }
        });
        imageButtonMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPassWord.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                imageButtonNhamMat.setVisibility(View.VISIBLE);
                imageButtonMat.setVisibility(View.INVISIBLE);
            }
        });
        imageButtonNhamMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPassWord.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                imageButtonNhamMat.setVisibility(View.INVISIBLE);
                imageButtonMat.setVisibility(View.VISIBLE);
            }
        });
        editTextForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivitySignIn.this, ActivityForgotPassword.class);
                startActivity(intent);
            }
        });
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        edtUseName.setText(sharedPreferences.getString("taikhoan",""));
        edtPassWord.setText(sharedPreferences.getString("matkhau",""));
        checkBox.setChecked(sharedPreferences.getBoolean("checked",false));
    }
}

