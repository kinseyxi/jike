package com.jike.xueyuan.task3;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class MarsRoverTest {
    @Test
    public void MarsRoverEastTest(){
        //测试向东向前运动
        MarsRover marsRover = new MarsRover(100,100,40, 40, Direction.E);
        Point p1 = marsRover.move(new Command("-f 30 -f 10 -l "));
        Assert.assertEquals(p1.x,80);
        Assert.assertEquals(p1.y,40);
    }
    @Test
    public void MarsRoverWest(){
        //测试向西向前运动
        MarsRover marsRover = new MarsRover(100,100,40, 40, Direction.E);
        Point p1 = marsRover.move(new Command("-r -r -f 30"));
        Assert.assertEquals(p1.x,10);
        Assert.assertEquals(p1.y,40);
    }
    @Test
    public void MarsRoverSouth(){
        //测试向南向前运动
        MarsRover marsRover = new MarsRover(100,100,40, 40, Direction.E);
        Point p1 = marsRover.move(new Command("-r -f 30"));
        Assert.assertEquals(p1.x,40);
        Assert.assertEquals(p1.y,70);
    }
    @Test
    public void MarsRoverNorth(){
        //测试向北向前运动
        MarsRover marsRover = new MarsRover(100,100,40, 40, Direction.E);
        Point p1 = marsRover.move(new Command("-l -f 30"));
        Assert.assertEquals(p1.x,40);
        Assert.assertEquals(p1.y,10);
    }
    @Test
    public void MarsRoverEastRangeOutTest(){
        //测试向东向前运动
        MarsRover marsRover = new MarsRover(100,100,40, 40, Direction.E);
        Point p1 = marsRover.move(new Command("-f 70 -f 10 -l "));
        Assert.assertEquals(p1.x,100);
        Assert.assertEquals(p1.y,40);
    }
}
