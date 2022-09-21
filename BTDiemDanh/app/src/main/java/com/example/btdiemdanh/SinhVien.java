package com.example.btdiemdanh;

public class SinhVien {
    private String MSV;
    private String hoTen;
    private String gioiTinh;
    private String lop;
    private String SDT;

    public SinhVien(String MSV, String hoTen, String gioiTinh, String lop, String SDT) {
        this.MSV = MSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.lop = lop;
        this.SDT = SDT;
    }
    public SinhVien(){}

    public String getMSV() {
        return MSV;
    }

    public void setMSV(String MSV) {
        this.MSV = MSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
