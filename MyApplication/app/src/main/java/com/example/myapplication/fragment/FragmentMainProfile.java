package com.example.myapplication.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;

public class FragmentMainProfile extends Fragment {
    ImageView imageViewLogOut;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_profile,container,false);
                imageViewLogOut=(ImageView) view.findViewById(R.id.imgLogOut);
                imageViewLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder  builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_DeviceDefault_Dialog);
                builder.setTitle("Bạn có chắc muốn đăng xuất");
                builder.setMessage("Hãy lựa chọn để xác nhận!!");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                     FragmentSignIn.check="";
                        Toast.makeText(getContext(), "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                        getFragmentManager().beginTransaction()
                                .add(R.id.fragment_container, new FragmentSignIn())
                                .remove(FragmentMainProfile.this)
                                .commit();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();
            }
        });
        return view;
    }

}