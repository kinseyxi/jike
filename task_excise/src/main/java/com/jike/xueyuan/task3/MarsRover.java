package com.jike.xueyuan.task3;


public class MarsRover {
    private int x;
    private int y;
    private char faceTo;
    private Direction direction;
    private Area area;

    public MarsRover(Area area) {
        this.area = area;
    }

    public void land(int x, int y, char faceTo) {
       if(!area.containsCoordinate(x,y)){
           throw new IllegalStateException(String.format("超出范围%d,%d",x,y));
       }
        this.x = x;
        this.y = y;
        this.faceTo = faceTo;
        direction = Direction.valueOf(String.valueOf(faceTo));
    }

    public void forward() {
        Offset offset=direction.fowardOffset();
        this.x+=offset.x;
        this.y+=offset.y;
    }
    public void back() {
        Offset offset=direction.backOffset();
        this.x+=offset.x;
        this.y+=offset.y;
    }

    public String getPosition() {
        return String.valueOf(x)+this.y+this.faceTo;
    }
}
