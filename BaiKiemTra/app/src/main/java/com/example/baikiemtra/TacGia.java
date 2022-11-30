package com.example.baikiemtra;

public class TacGia {
    private int hinhAnh;
    private  String ten;
    private String moTa;
    private String sao;
    private String quocGia;

    public TacGia() {
    }

    public TacGia(int hinhAnh, String ten, String moTa, String sao, String quocGia) {
        this.hinhAnh = hinhAnh;
        this.ten = ten;
        this.moTa = moTa;
        this.sao = sao;
        this.quocGia = quocGia;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSao() {
        return sao;
    }

    public void setSao(String sao) {
        this.sao = sao;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
}
