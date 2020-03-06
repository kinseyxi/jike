package com.jike.xueyuan.task3_1;

public class MarsRover {
    private int x;
    private int y;
    private char faceTo;

    public MarsRover(int x, int y){

    }

    public void land(int x, int y, char faceTo) {
        this.x = x;
        this.y = y;
        this.faceTo = faceTo;
    }

    public String getPositon() {
        return String.valueOf(this.x)+this.y+this.faceTo;
    }

    public void moveForward() {
        switch (faceTo) {
            case 'E':
                this.x++;
                break;
            case 'W':
                this.x--;
                break;
            case 'N':
                this.y++;
                break;
            case 'S':
                this.y--;
                break;
        }
    }

    public void moveBack() {
        switch (faceTo) {
            case 'E':
                this.x--;
                break;
            case 'W':
                this.x++;
                break;
            case 'N':
                this.y--;
                break;
            case 'S':
                this.y++;
                break;
        }
    }

    public void turnLeft() {
        switch (faceTo) {
            case 'E':
                faceTo='N';
                break;
            case 'W':
                faceTo='S';
                break;
            case 'N':
                faceTo='W';
                break;
            case 'S':
                faceTo='E';
                break;
        }
    }

    public void turnRight() {
        switch (faceTo) {
            case 'E':
                faceTo='S';
                break;
            case 'W':
                faceTo='N';
                break;
            case 'N':
                faceTo='E';
                break;
            case 'S':
                faceTo='W';
                break;
        }
    }
}
