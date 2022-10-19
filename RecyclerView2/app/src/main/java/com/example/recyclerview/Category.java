package com.example.recyclerview;

import java.util.List;

public class Category {
    private String gameXuHuong;
    private List<Game> gameList;

    public Category(String gameXuHuong, List<Game> gameList) {
        this.gameXuHuong = gameXuHuong;
        this.gameList = gameList;
    }

    public Category() {
    }

    public String getGameXuHuong() {
        return gameXuHuong;
    }

    public void setGameXuHuong(String gameXuHuong) {
        this.gameXuHuong = gameXuHuong;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}

