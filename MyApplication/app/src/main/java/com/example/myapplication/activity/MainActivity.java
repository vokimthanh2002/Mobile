package com.example.myapplication.activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.fragment.FragmentDowLoad;
import com.example.myapplication.fragment.FragmentSignIn;
import com.example.myapplication.fragment.FragmentTrangChu;
import com.example.myapplication.fragment.FragmentMainProfile;
import com.example.myapplication.fragment.FragmentDanhSachTaiKhoan;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    String user;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Hack game hay tai Gamehay24.vn", Toast.LENGTH_SHORT).show();
                BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
                if(SignUp.check){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentSignIn()).commit();
                }else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentTrangChu()).commit();
                }
                bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment= null;
                        switch (item.getItemId()){
                            case R.id.nav_games:
                                selectedFragment= new FragmentTrangChu();
                                break;
                            case R.id.nav_caidat:
                                selectedFragment= new FragmentDowLoad();
                                break;
                            case R.id.nav_vip:
                                selectedFragment= new FragmentDanhSachTaiKhoan();
                                break;
                            case R.id.nav_taikhoan:
                                if(FragmentSignIn.check=="")
                                {
                                    selectedFragment= new FragmentSignIn();
                                }else{
                                    selectedFragment= new FragmentMainProfile();
                                }
                                break;
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                        return true;
                    }
                });

            }
        }