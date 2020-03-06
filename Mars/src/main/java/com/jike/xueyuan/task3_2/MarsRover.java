package com.jike.xueyuan.task3_2;

public class MarsRover {
    private Area area;
    private int x;
    private int y;
    private char faceTo;
    private Direction direction;

    public MarsRover(Area area){
       this.area = area;
    }

    public void land(int x, int y, char faceTo) {
        if(!area.containsCoordinate(x)){
            throw new IllegalStateException(String.format("Coordinate %d,%d is out of area %dx%d",x,y,area.getWidth(),area.getHeight()));
        }
        this.x = x;
        this.y = y;
        this.faceTo = faceTo;
        direction = Direction.valueOf(String.valueOf(this.faceTo).toUpperCase());

    }

    public String getPositon() {
        return String.valueOf(this.x)+this.y+direction;
    }

    public void moveForward() {
        Offset offset=direction.forwardOffset();
        this.x+=offset.x;
        this.y+=offset.y;
    }

    public void moveBack() {
        Offset offset=direction.backOffset();
        this.x+=offset.x;
        this.y+=offset.y;
    }

    public void turnLeft() {
        this.direction=direction.left();
    }

    public void turnRight() {
        this.direction=direction.right();
    }
}
