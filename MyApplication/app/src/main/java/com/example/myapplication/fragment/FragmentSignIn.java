    package com.example.myapplication.fragment;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.fragment.app.Fragment;
    import android.content.Intent;
    import android.database.Cursor;
    import android.os.Bundle;
    import android.text.InputType;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageButton;
    import android.widget.ImageView;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.example.myapplication.taikhoan.repository.DatabaseHelper;
    import com.example.myapplication.activity.ForgotPassword;
    import com.example.myapplication.R;
    import com.example.myapplication.activity.SignUp;


    public class FragmentSignIn extends Fragment {
        public static String check ="";
        private EditText edtPassWord,edtUseName;
        private TextView editTextForgotPassword;
        private Button btnSignIn, btnSignIn_SignUp;
        private ImageView imageViewFbLogin,imageViewEmailLogin;
        private ImageButton imageButtonMat,imageButtonNhamMat;
        public static DatabaseHelper database;
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_sign_in,container,false);
            database= new DatabaseHelper(getContext());
            edtUseName= (EditText) view.findViewById(R.id.edtUserName);
            edtPassWord= (EditText) view.findViewById(R.id.edtPassword);
            btnSignIn= (Button) view.findViewById(R.id.btnSignIn);
            btnSignIn_SignUp =(Button) view.findViewById(R.id.btnSignIn_SignUp);
            imageViewFbLogin=(ImageView) view.findViewById(R.id.imgfblogin);
            imageViewEmailLogin=(ImageView) view.findViewById(R.id.imggmaillogin);
            imageButtonMat=(ImageButton) view.findViewById(R.id.imgMat);
            imageButtonNhamMat=(ImageButton) view.findViewById(R.id.imgNhamMat);
            editTextForgotPassword=(TextView) view.findViewById(R.id.forgotPassword);
            imageButtonNhamMat.setVisibility(View.INVISIBLE);
            controlButton();
            return view;
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
                            if (edtUseName.getText().toString().equals(userName) && edtPassWord.getText().toString().equals(password)) {
                                Toast.makeText(getContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                check="Đăng nhập thành công";
                                edtUseName.setBackgroundResource(R.drawable.round_border);
                                edtPassWord.setBackgroundResource(R.drawable.round_border);
                                getFragmentManager().beginTransaction()
                                        .add(R.id.fragment_container, new FragmentMainProfile())
                                        .remove(FragmentSignIn.this)
                                        .commit();
                                status=true;
                                break;
                            }
                        }
                        if(!dataAccount.moveToNext()&&!status)  {
                            Toast.makeText(getContext(), "Sai thông tin tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                            edtUseName.setBackgroundResource(R.drawable.round_boder_red);
                            edtPassWord.setBackgroundResource(R.drawable.round_boder_red);
                        }
                    } else {
                        Toast.makeText(getContext(), "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                        edtUseName.setBackgroundResource(R.drawable.round_boder_red);
                        edtPassWord.setBackgroundResource(R.drawable.round_boder_red);
                    }
                }
            });
            btnSignIn_SignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), SignUp.class);
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
                    Intent intent = new Intent(getActivity(), ForgotPassword.class);
                    startActivity(intent);
                }
            });
        }
    }