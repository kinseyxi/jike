package com.jike.xueyuan.task3_2;

import lombok.Getter;

@Getter
public class Area {
    private  final int width;
    private  final int height;

    public Area(int width, int height) {
        this.width = width;
        this.height = height;
    }
    boolean containsCoordinate(int x){
        return x <= getWidth()-1;
    }
}
