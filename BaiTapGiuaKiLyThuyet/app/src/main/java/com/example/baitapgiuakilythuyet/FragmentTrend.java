package com.example.baitapgiuakilythuyet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentTrend extends Fragment {
    private GridView gridView;
    private AdapterDiscover adapterDiscover;
    private List<Movie> movieList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_discover, container, false);
        gridView = (GridView) view.findViewById(R.id.grView);
        movieList = new ArrayList<>();
        movieList.add(new Movie("",R.drawable.ct_kinhdi, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM KINH DỊ"));
        movieList.add(new Movie("",R.drawable.ct_vientuong, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM VIỄN TƯỞNG"));
        movieList.add(new Movie("",R.drawable.ct_hanhdong, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM HÀNH ĐỘNG"));
        movieList.add(new Movie("",R.drawable.ct_phieuluu, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM PHIÊU LƯU"));
        movieList.add(new Movie("",R.drawable.ct_khoahoc, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM KHOA HỌC VIỄN TƯỞNG"));
        movieList.add(new Movie("",R.drawable.ct_trinhtham, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM TRINH THÁM"));
        movieList.add(new Movie("",R.drawable.ct_tinhcam, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM TÌNHH CẢM"));
        movieList.add(new Movie("",R.drawable.ct_hai, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM HÀI"));
        movieList.add(new Movie("",R.drawable.ct_hoathinh, MovieSummary.CHIENTRANH,"123,4K","00:04:29","HOẠT HÌNH"));
        movieList.add(new Movie("",R.drawable.ct_canhac, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM CA NHẠC"));
        movieList.add(new Movie("",R.drawable.ct_anime, MovieSummary.CHIENTRANH,"123,4K","00:04:29","ANIME"));
        movieList.add(new Movie("",R.drawable.ct_chientranh, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM CHIẾN TRANH"));
        movieList.add(new Movie("",R.drawable.ct_toipham, MovieSummary.CHIENTRANH,"123,4K","00:04:29","PHIM TỘI PHẠM" ));
        adapterDiscover= new AdapterDiscover(getContext(),0, movieList);
        gridView.setAdapter(adapterDiscover);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ActivitycategoryDetail.class);
                intent.putExtra("key1", movieList.get(i).getCategory());
                intent.putExtra("key2", movieList.get(i).getImg());
                startActivity(intent);
            }
        });
        return view;
    }
}