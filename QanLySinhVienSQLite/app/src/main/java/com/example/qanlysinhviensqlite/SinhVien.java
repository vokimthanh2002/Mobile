package com.example.qanlysinhviensqlite;

import java.io.Serializable;

public class SinhVien implements Serializable {
    String maSV331, tenSV331, maLop331;
    public SinhVien(String maSV331, String tenSV331, String maLop331) {
        this.maSV331 = maSV331;
        this.tenSV331 = tenSV331;
        this.maLop331 = maLop331;
    }

    public String getMaSV() {
        return maSV331;
    }

    public void setMaSV(String maSV331) {
        this.maSV331 = maSV331;
    }

    public String getTenSV() {
        return tenSV331;
    }

    public void setTenSV(String tenSV331) {
        this.tenSV331 = tenSV331;
    }

    public String getMaLop() {
        return maLop331;
    }

    public void setMaLop(String maLop331) {
        this.maLop331 = maLop331;
    }
}
