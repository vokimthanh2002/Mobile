package com.example.myapplication.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.fragment.FragmentSignIn;
import com.example.myapplication.taikhoan.model.TaiKhoan;

import java.util.ArrayList;

public class FragmentDanhSachTaiKhoan extends Fragment {
    ArrayList<TaiKhoan> listTaiKhoan = new ArrayList<>();
    ListView listViewTaiKhoan;
    EditText edtNhapTaiKhoan,edtNhapMatKhau;
    Button btnthem,btnSua,btnXoa;
    int vitri=-1;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     try {
         View view = inflater.inflate(R.layout.fragment_danh_sach_tai_khoan,container,false);
         listViewTaiKhoan=(ListView) view.findViewById(R.id.listViewTaiKhoan);
         edtNhapTaiKhoan=(EditText) view.findViewById(R.id.edtNhapTaiKhoan);
         edtNhapMatKhau = (EditText) view.findViewById(R.id.edtNhapMatKhau);
         btnthem =(Button) view.findViewById(R.id.btnThem);
         btnSua =(Button) view.findViewById(R.id.btnSua);
         btnXoa =(Button) view.findViewById(R.id.btnXoa);
         Cursor dataAccount = FragmentSignIn.database.GetData("SELECT * FROM DuLieuTaiKhoan");
         while (dataAccount.moveToNext()){
             String userName =dataAccount.getString(0);
             String password =dataAccount.getString(1);
             TaiKhoan tk= new TaiKhoan(userName,password);
             listTaiKhoan.add(tk);
         }
         ArrayAdapter arrayAdapter= new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,listTaiKhoan);
         listViewTaiKhoan.setAdapter(arrayAdapter);
         btnthem.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 boolean status=false;
                 if(edtNhapTaiKhoan.getText().length()!=0 && edtNhapMatKhau.getText().length()!=0){
                     Cursor dataAccount = FragmentSignIn.database.GetData("SELECT * FROM DuLieuTfffraiKhoan");
                     while (dataAccount.moveToNext()){
                         String userName =dataAccount.getString(0);
                         String password =dataAccount.getString(1);
                         if(userName.equals(edtNhapTaiKhoan.getText().toString())){
                             Toast.makeText(getContext(), "T??n t??i kho???n ???? c?? ng?????i s??? d???ng", Toast.LENGTH_SHORT).show();
                             status= true;
                         }
                     }
                     if(!dataAccount.moveToNext()&& !status){
                         TaiKhoan tk = new TaiKhoan();
                         tk.setUserName(edtNhapTaiKhoan.getText().toString());
                         tk.setPassword(edtNhapMatKhau.getText().toString());
                         FragmentSignIn.database.insertTaiKhoan(tk);
                         Toast.makeText(getContext(), "Th??m m???i t??i kho???n th??nh c??ng", Toast.LENGTH_SHORT).show();
                         edtNhapTaiKhoan.setText("");
                         edtNhapMatKhau.setText("");
                         listTaiKhoan.add(tk);
                         listViewTaiKhoan.setAdapter(arrayAdapter);
                     }
                 }else{
                     Toast.makeText(getContext(), "Nh???p ?????y ????? th??ng tin", Toast.LENGTH_SHORT).show();
                 }
             }
         });
         listViewTaiKhoan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 edtNhapTaiKhoan.setText(listTaiKhoan.get(i).getUserName());
                 edtNhapMatKhau.setText(listTaiKhoan.get(i).getPassword());
                 vitri=i;
             }
         });
         btnSua.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if( arrayAdapter.isEmpty()){
                     Toast.makeText(getContext(), "Danh s??ch t??i kho???n r???ng!!", Toast.LENGTH_SHORT).show();
                 }else{
                     AlertDialog.Builder  builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_DeviceDefault_Dialog);
                     builder.setTitle("B???n c?? ch???c mu???n c???p nh???t");
                     builder.setMessage("H??y l???a ch???n ????? x??c nh???n!!");
                     builder.setIcon(android.R.drawable.ic_dialog_alert);
                     builder.setPositiveButton("C??", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             boolean status =false;
                             Cursor dataAccount = FragmentSignIn.database.GetData("SELECT * FROM DuLieuTaiKhoan");
                             while (dataAccount.moveToNext()){
                                 String userName =dataAccount.getString(0);
                                 String password =dataAccount.getString(1);
                                 if(userName.equals(edtNhapTaiKhoan.getText().toString())){
                                     TaiKhoan tk = new TaiKhoan();
                                     tk.setUserName(edtNhapTaiKhoan.getText().toString());
                                     tk.setPassword(edtNhapMatKhau.getText().toString());
                                     FragmentSignIn.database.updateTK(edtNhapTaiKhoan.getText().toString(),edtNhapMatKhau.getText().toString());
                                     listTaiKhoan.set(vitri,tk);
                                     arrayAdapter.notifyDataSetChanged();
                                     Toast.makeText(getContext(), "B???n ???? c???p nh???t th??nh c??ng!!!", Toast.LENGTH_SHORT).show();
                                     status= true;
                                 }
                             }
                             if(!dataAccount.moveToNext()&& !status){
                                 Toast.makeText(getContext(), "T??n t??i kho???n ???? c?? ng?????i s??? d???ng!!", Toast.LENGTH_SHORT).show();
                             }
                         }
                     });
                     builder.setNegativeButton("Kh??ng", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                         }
                     });
                     builder.show();
                 }
             }
         });
         btnXoa.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if( arrayAdapter.isEmpty()){
                     Toast.makeText(getContext(), "Danh s??ch t??i kho???n r???ng!", Toast.LENGTH_SHORT).show();
                 }else if(edtNhapTaiKhoan.getText().length()==0){
                     Toast.makeText(getContext(), "Ch???n t??i kho???n c???n x??a!!", Toast.LENGTH_SHORT).show();
                 }
                 else{
                     AlertDialog.Builder  builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_DeviceDefault_Dialog);
                     builder.setTitle("B???n c?? ch???c mu???n x??a");
                     builder.setMessage("H??y l???a ch???n b??n d?????i ????? x??c nh???n");
                     builder.setIcon(android.R.drawable.ic_dialog_alert);
                     builder.setPositiveButton("C??", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             FragmentSignIn.database.deleteUser(edtNhapTaiKhoan.getText().toString());
                             listTaiKhoan.remove(vitri);
                             arrayAdapter.notifyDataSetChanged();
                             edtNhapTaiKhoan.setText("");
                             edtNhapMatKhau.setText("");
                             Toast.makeText(getContext(), "B???n ???? x??a th??nh c??ng!!!", Toast.LENGTH_SHORT).show();
                         }
                     });
                     builder.setNegativeButton("Kh??ng", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                         }
                     });
                     builder.show();
                 }

             }
         });
         return view;
     }catch (Exception e){
         Toast.makeText(getContext(), "??ang t???i d??? li???u h??y ????ng nh???p tr?????c!!", Toast.LENGTH_SHORT).show();
     }
        return null;
    }
}