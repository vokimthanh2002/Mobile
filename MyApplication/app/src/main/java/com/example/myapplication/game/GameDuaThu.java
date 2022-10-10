package com.example.myapplication.game;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.Random;

public class GameDuaThu extends AppCompatActivity {

    TextView textViewDiemSo;
    EditText edittextDiemCuoc;
    SeekBar seekBarOne,seekBarTwo,seekBarThree,seekBarFor;
    CheckBox checkBoxOne,checkBoxTwo,checkBoxThree,checkBoxFor;
    ImageButton buttonPlay;
    Button btnXacNhanMouse,btnXacNhanDragon,btnXacNhanDog,btnXacNhanVoi;
    TextView textViewDiemDacCuoc1,textViewDiemThang1,textViewDiemDongGop1,textViewDiemNhanDuoc1;
    TextView textViewDiemDacCuoc2,textViewDiemThang2,textViewDiemDongGop2,textViewDiemNhanDuoc2;
    TextView textViewDiemDacCuoc3,textViewDiemThang3,textViewDiemDongGop3,textViewDiemNhanDuoc3;
    TextView textViewDiemDacCuoc4,textViewDiemThang4,textViewDiemDongGop4,textViewDiemNhanDuoc4;
    ImageButton imageButtonGift;

    int soDiem= 100;
    Random random= new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_dua_thu);
        anhXa();
        seekBarOne.setEnabled(false);
        seekBarTwo.setEnabled(false);
        seekBarThree.setEnabled(false);
        seekBarFor.setEnabled(false);
        textViewDiemSo.setText(100+"");
        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                if(seekBarOne.getProgress()>=seekBarOne.getMax()){
                    Dialog dialog= new Dialog(GameDuaThu.this);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.mousewin);
                    dialog.show();
                    textViewDiemDacCuoc1=dialog.findViewById(R.id.textviewDiemCuoc1);
                    textViewDiemThang1=dialog.findViewById(R.id.textviewDiemThang1);
                    textViewDiemDongGop1=dialog.findViewById(R.id.textviewDiemDongGop1);
                    textViewDiemNhanDuoc1=dialog.findViewById(R.id.textviewDiemNhanDuoc1);

                    btnXacNhanMouse =(Button) dialog.findViewById(R.id.buttonxacNhanMouse);
                    btnXacNhanMouse.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.cancel();
                        }
                    });
                    this.cancel();
                    buttonPlay.setVisibility(View.VISIBLE);
                    if(checkBoxOne.isChecked()){
                        textViewDiemDacCuoc1.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))+"");
                        textViewDiemThang1.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*4+"");
                        textViewDiemDongGop1.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))+"");
                        textViewDiemNhanDuoc1.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3+"");
                        soDiem+=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3;
                        Toast.makeText(GameDuaThu.this, "+"+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3, Toast.LENGTH_SHORT).show();
                    }else{
                        textViewDiemDacCuoc1.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))+"");
                        textViewDiemThang1.setText(0+"");
                        textViewDiemDongGop1.setText(0+"");
                        textViewDiemNhanDuoc1.setText(0+"");
                        soDiem-=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()));
                        Toast.makeText(GameDuaThu.this, "-"+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText())), Toast.LENGTH_SHORT).show();
                    }
                    textViewDiemSo.setText(soDiem+"");
                    enableCheckbox();
                    edittextDiemCuoc.setVisibility(View.VISIBLE);
                }
                if(seekBarTwo.getProgress()>=seekBarTwo.getMax()){
                    Dialog dialog= new Dialog(GameDuaThu.this);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.dragonwin);
                    dialog.show();
                    textViewDiemDacCuoc2=dialog.findViewById(R.id.textviewDiemCuoc2);
                    textViewDiemThang2=dialog.findViewById(R.id.textviewDiemThang2);
                    textViewDiemDongGop2=dialog.findViewById(R.id.textviewDiemDongGop2);
                    textViewDiemNhanDuoc2=dialog.findViewById(R.id.textviewDiemNhanDuoc2);

                    btnXacNhanMouse =(Button) dialog.findViewById(R.id.buttonxacNhanMouse);
                    btnXacNhanDragon =(Button) dialog.findViewById(R.id.buttonxacNhanDragon);
                    btnXacNhanDragon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.cancel();
                        }
                    });
                    this.cancel();
                    buttonPlay.setVisibility(View.VISIBLE);
                    if(checkBoxTwo.isChecked()){
                        textViewDiemDacCuoc2.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))+"");
                        textViewDiemThang2.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*4+"");
                        textViewDiemDongGop2.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))+"");
                        textViewDiemNhanDuoc2.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3+"");
                        soDiem+=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3;
                        Toast.makeText(GameDuaThu.this, "+"+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3, Toast.LENGTH_SHORT).show();
                    }else{
                        textViewDiemDacCuoc2.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))+"");
                        textViewDiemThang2.setText(0+"");
                        textViewDiemDongGop2.setText(0+"");
                        textViewDiemNhanDuoc2.setText(0+"");
                        soDiem-=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()));
                        Toast.makeText(GameDuaThu.this, "-"+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText())), Toast.LENGTH_SHORT).show();
                    }
                    textViewDiemSo.setText(soDiem+"");
                    enableCheckbox();
                    edittextDiemCuoc.setVisibility(View.VISIBLE);
                }
                if(seekBarThree.getProgress()>=seekBarThree.getMax()){
                    Dialog dialog= new Dialog(GameDuaThu.this);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.dogwin);
                    dialog.show();
                    textViewDiemDacCuoc3=dialog.findViewById(R.id.textviewDiemCuoc3);
                    textViewDiemThang3=dialog.findViewById(R.id.textviewDiemThang3);
                    textViewDiemDongGop3=dialog.findViewById(R.id.textviewDiemDongGop3);
                    textViewDiemNhanDuoc3=dialog.findViewById(R.id.textviewDiemNhanDuoc3);

                    btnXacNhanMouse =(Button) dialog.findViewById(R.id.buttonxacNhanMouse);
                    btnXacNhanDog =(Button) dialog.findViewById(R.id.buttonxacNhanDog);
                    btnXacNhanDog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.cancel();
                        }
                    });
                    this.cancel();
                    buttonPlay.setVisibility(View.VISIBLE);
                    if(checkBoxThree.isChecked()){
                        textViewDiemDacCuoc3.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))+"");
                        textViewDiemThang3.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*4+"");
                        textViewDiemDongGop3.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))+"");
                        textViewDiemNhanDuoc3.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3+"");
                        soDiem+=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3;
                        Toast.makeText(GameDuaThu.this, "+"+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3, Toast.LENGTH_SHORT).show();
                    }else{
                        textViewDiemDacCuoc3.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))+"");
                        textViewDiemThang3.setText(0+"");
                        textViewDiemDongGop3.setText(0+"");
                        textViewDiemNhanDuoc3.setText(0+"");
                        soDiem-=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()));
                        Toast.makeText(GameDuaThu.this, "-"+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText())), Toast.LENGTH_SHORT).show();
                    }
                    textViewDiemSo.setText(soDiem+"");
                    enableCheckbox();
                    edittextDiemCuoc.setVisibility(View.VISIBLE);
                }
                if(seekBarFor.getProgress()>=seekBarFor.getMax()){
                    Dialog dialog= new Dialog(GameDuaThu.this);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.voiwin);
                    dialog.show();
                    textViewDiemDacCuoc4=dialog.findViewById(R.id.textviewDiemCuoc4);
                    textViewDiemThang4=dialog.findViewById(R.id.textviewDiemThang4);
                    textViewDiemDongGop4=dialog.findViewById(R.id.textviewDiemDongGop4);
                    textViewDiemNhanDuoc4=dialog.findViewById(R.id.textviewDiemNhanDuoc4);

                    btnXacNhanMouse =(Button) dialog.findViewById(R.id.buttonxacNhanMouse);
                    btnXacNhanVoi =(Button) dialog.findViewById(R.id.buttonxacNhanVoi);
                    btnXacNhanVoi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.cancel();
                        }
                    });
                    this.cancel();
                    buttonPlay.setVisibility(View.VISIBLE);
                    if(checkBoxFor.isChecked()){
                        textViewDiemDacCuoc4.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))+"");
                        textViewDiemThang4.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*4+"");
                        textViewDiemDongGop4.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))+"");
                        textViewDiemNhanDuoc4.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3+"");
                        soDiem+=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3;
                        Toast.makeText(GameDuaThu.this, "+"+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))*3, Toast.LENGTH_SHORT).show();
                    }else{
                        textViewDiemDacCuoc4.setText(Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()))+"");
                        textViewDiemThang4.setText(0+"");
                        textViewDiemDongGop4.setText(0+"");
                        textViewDiemNhanDuoc4.setText(0+"");
                        soDiem-=Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()));
                        Toast.makeText(GameDuaThu.this, "-"+Integer.parseInt(String.valueOf(edittextDiemCuoc.getText())), Toast.LENGTH_SHORT).show();
                    }
                    textViewDiemSo.setText(soDiem+"");
                    enableCheckbox();
                    edittextDiemCuoc.setVisibility(View.VISIBLE);
                }
                if(checkBoxOne.isChecked()){
                    seekBarOne.setProgress(seekBarOne.getProgress()+random.nextInt(3));
                    seekBarTwo.setProgress(seekBarTwo.getProgress()+random.nextInt(3));
                    seekBarThree.setProgress(seekBarThree.getProgress()+random.nextInt(3));
                    seekBarFor.setProgress(seekBarFor.getProgress()+random.nextInt(3));
                }
                if(checkBoxTwo.isChecked()){
                    seekBarOne.setProgress(seekBarOne.getProgress()+random.nextInt(3));
                    seekBarTwo.setProgress(seekBarTwo.getProgress()+random.nextInt(2));
                    seekBarThree.setProgress(seekBarThree.getProgress()+random.nextInt(3));
                    seekBarFor.setProgress(seekBarFor.getProgress()+random.nextInt(3));
                }
                if(checkBoxThree.isChecked()){
                    seekBarOne.setProgress(seekBarOne.getProgress()+random.nextInt(3));
                    seekBarTwo.setProgress(seekBarTwo.getProgress()+random.nextInt(3));
                    seekBarThree.setProgress(seekBarThree.getProgress()+random.nextInt(2));
                    seekBarFor.setProgress(seekBarFor.getProgress()+random.nextInt(3));
                }
                if(checkBoxFor.isChecked()){
                    seekBarOne.setProgress(seekBarOne.getProgress()+random.nextInt(3));
                    seekBarTwo.setProgress(seekBarTwo.getProgress()+random.nextInt(3));
                    seekBarThree.setProgress(seekBarThree.getProgress()+random.nextInt(3));
                    seekBarFor.setProgress(seekBarFor.getProgress()+random.nextInt(2));
                }
            }

            @Override
            public void onFinish() {

            }
        };

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edittextDiemCuoc.length()!=0&&checkBoxOne.isChecked() || edittextDiemCuoc.length()!=0&&checkBoxTwo.isChecked()|| edittextDiemCuoc.length()!=0&&checkBoxThree.isChecked() || edittextDiemCuoc.length()!=0&&checkBoxFor.isChecked()){
                    int diemCuoc= Integer.parseInt(String.valueOf(edittextDiemCuoc.getText()));
                    if(diemCuoc<=Integer.parseInt(String.valueOf(textViewDiemSo.getText())))
                    {
                        if(Integer.parseInt(String.valueOf(textViewDiemSo.getText()))>0){
                            edittextDiemCuoc.setVisibility(View.INVISIBLE);
                            seekBarOne.setProgress(0);
                            seekBarTwo.setProgress(0);
                            seekBarThree.setProgress(0);
                            seekBarFor.setProgress(0);
                            buttonPlay.setVisibility(View.INVISIBLE);
                            countDownTimer.start();
                            disableCheckBox();
                        }else {
                            Toast.makeText(GameDuaThu.this, "Ban da het diem de dac cuoc!!", Toast.LENGTH_SHORT).show();
                        }
                    }else
                        Toast.makeText(GameDuaThu.this, "Ban khong du diem cuoc!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(GameDuaThu.this, "Ban phai dat cuoc truoc khi choi!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        imageButtonGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(String.valueOf(textViewDiemSo.getText()))>10){
                    Toast.makeText(GameDuaThu.this, "Ban chi co the nhan diem neu be hon 10!!", Toast.LENGTH_SHORT).show();
                }else{
                    Dialog dialog= new Dialog(GameDuaThu.this);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.gitf);
                    dialog.show();
                    TextView textViewGift= dialog.findViewById(R.id.textViewGift);
                    Random random= new Random();
                    textViewGift.setText(random.nextInt(100)+"");
                    textViewDiemSo.setText(textViewGift.getText());
                    soDiem= Integer.parseInt(String.valueOf(textViewDiemSo.getText()));
                    Button btnXacNhanGift =(Button) dialog.findViewById(R.id.buttonXacNhanGift);
                    btnXacNhanGift =(Button) dialog.findViewById(R.id.buttonXacNhanGift);
                    btnXacNhanGift.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.cancel();
                        }
                    });
                }
            }
        });
        checkBoxOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxTwo.setChecked(false);
                    checkBoxThree.setChecked(false);
                    checkBoxFor.setChecked(false);
                }
            }
        });
        checkBoxTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxOne.setChecked(false);
                    checkBoxThree.setChecked(false);
                    checkBoxFor.setChecked(false);
                }
            }
        });
        checkBoxThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxOne.setChecked(false);
                    checkBoxTwo.setChecked(false);
                    checkBoxFor.setChecked(false);
                }
            }
        });
        checkBoxFor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkBoxOne.setChecked(false);
                    checkBoxTwo.setChecked(false);
                    checkBoxThree.setChecked(false);
                }
            }
        });
    }

    public void anhXa(){
        textViewDiemSo= (TextView) findViewById(R.id.textviewDiemSo);
        seekBarOne=(SeekBar) findViewById(R.id.seekbarOne);
        seekBarTwo=(SeekBar) findViewById(R.id.seekbarTwo);
        seekBarThree=(SeekBar) findViewById(R.id.seekbarThree);
        seekBarFor=(SeekBar) findViewById(R.id.seekbarFor);
        checkBoxOne= (CheckBox) findViewById(R.id.checkboxOne);
        checkBoxTwo= (CheckBox) findViewById(R.id.checkboxTwo);
        checkBoxThree= (CheckBox) findViewById(R.id.checkboxThree);
        checkBoxFor= (CheckBox) findViewById(R.id.checkboxFor);
        buttonPlay = (ImageButton) findViewById(R.id.buttonPlay);
        edittextDiemCuoc=(EditText) findViewById(R.id.edittextNhapCuoc);
        imageButtonGift=(ImageButton) findViewById(R.id.imageButtonGift);
    }
    public void enableCheckbox(){
        checkBoxOne.setEnabled(true);
        checkBoxTwo.setEnabled(true);
        checkBoxThree.setEnabled(true);
    }
    public void disableCheckBox(){
        checkBoxOne.setEnabled(false);
        checkBoxTwo.setEnabled(false);
        checkBoxThree.setEnabled(false);
    }
}