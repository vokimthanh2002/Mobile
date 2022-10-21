package com.example.baitapgiuakilythuyet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class ActivityContaint extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_containt);
        RelativeLayout linearLayout =(RelativeLayout) findViewById(R.id.linear_containt);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentHome()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment= null;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedFragment= new FragmentHome();
                        linearLayout.setVisibility(View.VISIBLE);
                        break;
                    case R.id.nav_discover:
                        selectedFragment= new FragmentTrend();
                        linearLayout.setVisibility(View.VISIBLE);
                        break;
                    case R.id.nav_dowload:
                        selectedFragment= new FragmentMusicRemix();
                        linearLayout.setVisibility(View.VISIBLE);
                        break;
                    case R.id.nav_category:
                            selectedFragment= new FragmentCategory();
                        linearLayout.setVisibility(View.VISIBLE);
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                return true;
            }
        });
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout =(DrawerLayout) findViewById(R.id.drawLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_drawer_oppen,R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//        ImageView img_menu= (ImageView) findViewById(R.id.img_menu);
//        img_menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });
        NavigationView navigationView =(NavigationView) findViewById(R.id.nav_View);
//        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.nav_info){
            startActivity(new Intent(ActivityContaint.this,ActivityProfile.class));
        }else if(id==R.id.nav_favorite){
            startActivity(new Intent(ActivityContaint.this,ActivityFavorite.class));
        }else if(id==R.id.nav_dow){
            startActivity(new Intent(ActivityContaint.this,ActivityDowload.class));
        }else  if(id==R.id.nav_app_reviews){
            startActivity(new Intent(ActivityContaint.this,ActivityReview.class));
        }else if(id==R.id.nav_share){
            startActivity(new Intent(ActivityContaint.this, ActivityShare.class));
        }
        else if(id==R.id.nav_out){
            startActivity(new Intent(ActivityContaint.this,ActivitySignIn.class));
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}