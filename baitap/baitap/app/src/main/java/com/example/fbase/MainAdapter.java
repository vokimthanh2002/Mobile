package com.example.fbase;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel, MainAdapter.myViewHolder> {
    private Context mcontext;
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options, Context mcontext) {
        super(options);
        this.mcontext = mcontext;
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, final @SuppressLint("RecyclerView") int position, @NonNull MainModel model) {
        holder.ten.setText(model.getTenKhoaHoc());
        holder.tenThuong.setText(model.getTenThuongGoi());
        holder.mauLa.setText(model.getMauLa());

        Glide.with(holder.anh.getContext())
                .load(model.getHinhAnh())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.anh);

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.anh.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true, 1200)
                        .create();

                //dialogPlus.show();

                View view = dialogPlus.getHolderView();
                EditText name = view.findViewById(R.id.txtNameUd);
                EditText tenThuong = view.findViewById(R.id.txttenthuonggoiud);
                EditText dacTinh = view.findViewById(R.id.txtdactinhud);
                EditText mauLa = view.findViewById(R.id.txtmauud);
                EditText congDung = view.findViewById(R.id.txtcongdungud);
                EditText duocTinh = view.findViewById(R.id.txtduoctinhud);
                EditText chuY = view.findViewById(R.id.txtchuyud);
                EditText anh = view.findViewById(R.id.txtanhud);

                Button btnUpdate = view.findViewById(R.id.btnUpdate);

                name.setText(model.getTenKhoaHoc());
                tenThuong.setText(model.getTenThuongGoi());
                dacTinh.setText(model.getDacTinh());
                mauLa.setText(model.getMauLa());
                anh.setText(model.getHinhAnh());
                congDung.setText(model.getCongDung());
                duocTinh.setText(model.getDuocTinh());
                chuY.setText(model.getChuY());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("tenKhoaHoc", name.getText().toString());
                        map.put("tenThuongGoi", tenThuong.getText().toString());
                        map.put("dacTinh", dacTinh.getText().toString());
                        map.put("mauLa", mauLa.getText().toString());
                        map.put("congDung", congDung.getText().toString());
                        map.put("duocTinh", duocTinh.getText().toString());
                        map.put("chuY", chuY.getText().toString());
                        map.put("hinhAnh", anh.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("caythuocnam")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.ten.getContext(), "Data Update Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.ten.getContext(), "Error While Updating", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });

                    }
                });
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.ten.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Deleted data can't be Undo");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    FirebaseDatabase.getInstance().getReference().child("cayxanh")
                            .child(getRef(position).getKey()).removeValue();
                }
            });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.ten.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        holder.cvitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, ChiTietActivity.class);
                intent.putExtra("tenKhoaHoc", model.getTenKhoaHoc());
                intent.putExtra("tenThuongGoi", model.getTenThuongGoi());
                intent.putExtra("dacTinh", model.getDacTinh());
                intent.putExtra("hinhAnh", model.getHinhAnh());
                mcontext.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView anh;
        TextView ten, tenThuong,  mauLa;
        CardView cvitem;

        Button btnEdit, btnDelete;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            anh = (CircleImageView) itemView.findViewById(R.id.img1);
            ten = (TextView) itemView.findViewById(R.id.nametext);
            tenThuong = (TextView) itemView.findViewById(R.id.tinhtrang);
            mauLa = (TextView) itemView.findViewById(R.id.mau);
            cvitem = (CardView) itemView.findViewById(R.id.cvitem);
            btnEdit = (Button) itemView.findViewById(R.id.btnEdit);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
        }
    }
}
