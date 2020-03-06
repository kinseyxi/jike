package com.jike.xueyuan.task3;

import java.awt.*;
import java.util.List;

public class MarsRover {
    private Direction direction;
    private Area area;
    private Point point;
    private Obstacle obstacle;
    public MarsRover(int X, int Y, int x, int y, Direction direction) {
        //初始化坐标位置point(100,100),朝东E
        area = new Area(X, Y);
        point = new Point(x, y);
        this.direction = direction;
    }
    public MarsRover(int X, int Y, int x, int y, Direction direction,int x1,int y1) {
        //初始化坐标位置point(100,100),朝东E
        area = new Area(X, Y);
        point = new Point(x, y);
        this.direction = direction;
        obstacle=new Obstacle(x1,y1);
    }
    //判断是否受阻(当小车与障碍物相差1m是则认为小车受阻，不能执行剩余指令)
    public boolean isStruct(Point point,Obstacle obstacle){
        if(obstacle.getX1()==point.x && Math.abs(obstacle.getY1()-point.y)<=1){
            return true;
        }
        if(obstacle.getY1()==point.y && Math.abs(obstacle.getX1()-point.x)<=1){
            return true;
        }
       return false;
   }

    public Point move(Command command) {
        List<String> commands = command.commandList;
        for (int i = 0; i < commands.size(); i++) {
            if(isStruct(point,obstacle)){
                break;
            }
            //朝东
            if (direction.getDes() == "E") {
                switch (commands.get(i)) {
                    case "f":
                        point.x = point.x + Integer.parseInt(commands.get(++i));


                        if (point.x > area.getX()) {
                            point.x = area.getX();
                            break;
                        }
                        continue;
                    case "b":
                        point.x = point.x - Integer.parseInt(commands.get(++i));
                        if (point.x < 0) {
                            point.x = 0;
                            break;
                        }
                        continue;
                    case "l":
                        //左转
                        direction = direction.N;
                        continue;
                    case "r":
                        //右转
                        direction = direction.S;
                        continue;
                }
            }
            //朝西
            if (direction.getDes() == "W") {
                switch (commands.get(i)) {
                    case "f":
                        point.x = point.x - Integer.parseInt(commands.get(++i));
                        if (point.x < 0) {
                            point.x = 0;
                            break;
                        }
                        continue;
                    case "b":
                        point.x = point.x + Integer.parseInt(commands.get(++i));
                        if (point.x > area.getX()) {
                            point.x = area.getX();
                            break;
                        }
                        continue;
                    case "l":
                        //左转
                        direction = direction.S;
                        continue;
                    case "r":
                        //右转
                        direction = direction.N;
                        continue;
                }
            }
            //朝南
            if (direction.getDes() == "S") {
                switch (commands.get(i)) {
                    case "f":
                        point.y = point.y + Integer.parseInt(commands.get(++i));
                        if (point.y > area.getY()) {
                            point.y = area.getY();
                            break;
                        }
                        continue;
                    case "b":
                        point.y = point.y - Integer.parseInt(commands.get(++i));
                        if (point.y < 0) {
                            point.y = 0;
                            break;
                        }
                        continue;
                    case "l":
                        //左转
                        direction = direction.E;
                        continue;
                    case "r":
                        //右转
                        direction = direction.W;
                        continue;
                }
            }
            //朝北
            if (direction.getDes() == "N") {
                switch (commands.get(i)) {
                    case "f":
                        point.y = point.y - Integer.parseInt(commands.get(++i));
                        if (point.y < 0) {
                            point.y = 0;
                            break;
                        }
                        continue;
                    case "b":
                        point.y = point.y + Integer.parseInt(commands.get(++i));
                        if (point.y > area.getY()) {
                            point.y = area.getY();
                            break;
                        }
                        continue;
                    case "l":
                        //左转
                        direction = direction.W;
                        continue;
                    case "r":
                        //右转
                        direction = direction.E;
                        continue;
                }
            }
        }
        return point;
    }

}

