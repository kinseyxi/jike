package com.jike.xueyuan.task3;

public class Area {
    private final int X;
    private final int Y;

    public Area(int X, int Y) {

        this.X = X;
        this.Y = Y;
    }
    public boolean containsCoordinate(int x,int y){
        return  x <= X-1;
    }
}
