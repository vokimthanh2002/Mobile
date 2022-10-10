package com.example.myapplication.game.model;


public class Game {
    private String moTaChiTiet;
    private String dungLuong;
    private String gameXuHuong;
    private String tenGame;
    private int img;
    private String moTa;

    public Game(String gameXuHuong, String tenGame, int img, String moTa) {
        this.tenGame = tenGame;
        this.img = img;
        this.moTa = moTa;
        this.gameXuHuong=gameXuHuong;
    }


    public String getMoTaChiTiet() {
        return moTaChiTiet;
    }

    public void setMoTaChiTiet(String moTaChiTiet) {
        this.moTaChiTiet = moTaChiTiet;
    }

    public Game(String dungLuong, String moTaChiTiet, String tenGame, int img, String moTa) {
        this.dungLuong = dungLuong;
        this.moTaChiTiet = moTaChiTiet;
        this.tenGame = tenGame;
        this.img = img;
        this.moTa = moTa;
    }

    public Game(int img) {
        this.img = img;
    }

    public String getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

    public Game(String tenGame, int img, String moTa) {
        this.tenGame = tenGame;
        this.img = img;
        this.moTa = moTa;
    }

    public Game() {
    }

    public String getGameXuHuong() {
        return gameXuHuong;
    }

    public void setGameXuHuong(String gameXuHuong) {
        this.gameXuHuong = gameXuHuong;
    }

    public String getTenGame() {
        return tenGame;
    }

    public void setTenGame(String tenGame) {
        this.tenGame = tenGame;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
