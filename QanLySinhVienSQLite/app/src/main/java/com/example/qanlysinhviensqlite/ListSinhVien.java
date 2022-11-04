package com.example.qanlysinhviensqlite;

import java.io.Serializable;
import java.util.List;

public class ListSinhVien implements Serializable {
    List<SinhVien> sinhVienList;

    public ListSinhVien(List<SinhVien> sinhVienList) {
        this.sinhVienList = sinhVienList;
    }

    public List<SinhVien> getSinhVienList() {
        return sinhVienList;
    }

    public void setSinhVienList(List<SinhVien> sinhVienList) {
        this.sinhVienList = sinhVienList;
    }
}
