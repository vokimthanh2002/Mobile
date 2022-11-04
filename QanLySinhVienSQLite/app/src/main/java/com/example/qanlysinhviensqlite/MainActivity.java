package com.example.qanlysinhviensqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;
    List<Lop> lopList;
    LopAdapter lopAdapter;
    ListView listViewAX;
    List<SinhVien> sinhVienList;
    ListSinhVien listSinhVienIntent;
    int position = -1;
    int time = 1;
    Button insertBTAX, updateBTAX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createOrOpenDataBase();
        createLopTable();
        createSinhVienTable();
        doInsertTable("Lop", "1","20T1", "", "");
        doInsertTable("Lop", "2","20T2", "", "");
        doInsertTable("Lop", "3","20T3", "", "");
        doInsertTable("Lop", "4","19T1", "", "");
        doInsertTable("Lop", "5","19T2", "", "");
        doInsertTable("Lop", "6","19T3", "", "");
        doInsertTable("Lop", "7","19T4", "", "");
        doInsertTable("SinhVien", "2","", "2050531200331", "Vo Kim Thanh");
        doInsertTable("SinhVien", "1","", "2050531200332", "Vo Kim Thanh");
        doInsertTable("SinhVien", "2","", "2050531200331", "Vo Kim Thanh");
//        deleteDatabase("QuanLySinhVien.db");
        lopList = new ArrayList<>();
        SetDataLopTable();
        lopAdapter = new LopAdapter(lopList, MainActivity.this);
        listViewAX = (ListView) findViewById(R.id.lopListView);
        listViewAX.setAdapter(lopAdapter);
        sinhVienList = new ArrayList<>();
        listViewAX.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SetPosition(i);
                if(time < 2){
                    Lop lop = lopList.get(position);
                    SetDataSinhVienTableByMaLop(lop.getMaLop());
                    listSinhVienIntent = new ListSinhVien(sinhVienList);
                    Intent intent = new Intent(MainActivity.this, SinhVienActivity.class);
                    intent.putExtra("SinhVienList", listSinhVienIntent);
                    startActivity(intent);
                }
                time = 1;
            }
        });
        listViewAX.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                time = 2;
                SetPosition(i);
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Xoa");
                alert.setMessage("Bạn có chắc chắn muốn xóa lớp này?");
                alert.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.out.println("i bi an la: "+i);
                        Lop lop = lopList.get(position);
                        doDeleteLopTable(lop.getMaLop());
                        SetDataLopTable();
                        lopAdapter.notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.show();
                return false;
            }
        });
        insertBTAX = findViewById(R.id.insertBT);
        insertBTAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Chen du lieu");
                dialog.setContentView(R.layout.activity_dialog);
                dialog.show();
                Button okBT = dialog.findViewById(R.id.okBT);

                EditText maLopETAX = dialog.findViewById(R.id.maLopET);
                EditText tenLopETAX = dialog.findViewById(R.id.tenLopET);
                okBT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        doInsertTable("Lop", maLopETAX.getText().toString(), tenLopETAX.getText().toString(), "", "");
                        SetDataLopTable();
                        lopAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                Button cancelBT = dialog.findViewById(R.id.cancelBT);
                cancelBT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
            }
        });

        updateBTAX = findViewById(R.id.updateBT);
        updateBTAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_dialog);
                dialog.show();
                TextView operationTVAX = dialog.findViewById(R.id.operationTV);
                operationTVAX.setText("Cap nhap ");
                Lop lop = lopList.get(position);
                EditText maLopVAX = dialog.findViewById(R.id.maLopET);
                EditText tenLopAX = dialog.findViewById(R.id.tenLopET);
                maLopVAX.setText(lop.getMaLop());
                tenLopAX.setText(lop.getTenLop());

                Button okBTAX = dialog.findViewById(R.id.okBT);
                okBTAX.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        doUpdateLopTable("Lop",maLopVAX.getText().toString(),tenLopAX.getText().toString());
                        SetDataLopTable();
                        lopAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                Button cancelBTAX = dialog.findViewById(R.id.cancelBT);
                cancelBTAX.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
            }
        });

    }
    public void SetPosition(int i){
        position = i;
    }


    public void createOrOpenDataBase(){
        database = openOrCreateDatabase("QuanLySinhVien.db",MODE_PRIVATE, null);
    }

    public void createLopTable(){
        String sql =    "Create table Lop("
                +       "maLop TEXT primary key,"
                +       "tenLop TEXT)";
        database.execSQL(sql);
    }

    public void createSinhVienTable(){
        String sql =    "Create table SinhVien("
                +       "maSV TEXT primary key,"
                +       "tenSV TEXT,"
                +       "maLop TEXT not null constraint maLop "
                +       "references Lop(maLop) on update cascade on delete cascade)";

        database.execSQL(sql);
    }

    public void doInsertTable(String tableName, String maLop, String tenLop, String maSV, String tenSV){
        ContentValues values = new ContentValues();
        if(tableName.equals("Lop")){
            values.put("maLop", maLop);
            values.put("tenLop", tenLop);
        }
        else{
            values.put("maSV", maSV);
            values.put("tenSV",tenSV);
            values.put("maLop", maLop);
        }
        database.insert(tableName,null,values);
        System.out.println("Insert " + tableName + " table successful");
    }

    public void doUpdateLopTable(String tableName, String malop, String newLopName){
        ContentValues values = new ContentValues();
        values.put("tenLop", newLopName);
        database.update(tableName, values, "maLop = ?", new String[]{malop});
        System.out.println("Update a row of "+ tableName+ " Table");
    }

    public void doDeleteLopTable(String maLop){
        database.delete("Lop","maLop = ?", new String[]{maLop});
        System.out.println("Delete a row of Lop Table");
    }
    public void SetDataLopTable(){
        lopList.clear();
        Cursor cursor = database.query("Lop", null, null,null,null,null,null);
        cursor.moveToFirst();
        String data ="";
        while (cursor.isAfterLast()==false){
            lopList.add(new Lop(cursor.getString(0),cursor.getString(1)));
            cursor.moveToNext();
        }
    }
    public void SetDataSinhVienTableByMaLop(String maLop){
        sinhVienList.clear();
        try (Cursor cursor = database.query("SinhVien", null, "maLop = ?", new String[]{maLop}, null, null, null)) {
            cursor.moveToFirst();
            String data = "";
            while (cursor.isAfterLast() == false) {
                sinhVienList.add(new SinhVien(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
                cursor.moveToNext();
            }
        }
    }


    public void doQueryTable(){
//        Cursor cursor = database.query("SinhVien", null, "maLop = ? and tenSV = ?", new String[]{"2", "Le Van Long"},null,null,null);
        Cursor cursor = database.query("SinhVien", null, "maLop = ?", new String[]{"2"},null,null,null);
        cursor.moveToFirst();
        String data ="";
        while (cursor.isAfterLast()==false){
            data += cursor.getString(0) + "_" + cursor.getString(1) + "_" + cursor.getString(2);
            data += "\n";
            cursor.moveToNext();
        }
        System.out.println(data);
    }
}