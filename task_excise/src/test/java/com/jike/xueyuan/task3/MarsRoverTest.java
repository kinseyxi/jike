package com.jike.xueyuan.task3;

import org.junit.Assert;
import org.junit.Test;

public class MarsRoverTest {
    @Test
    public void new_marsRover_test(){
        MarsRover marsRover = new MarsRover(new Area(5,5));
        Assert.assertNotNull(marsRover);
    }
    @Test
    public void land_test(){
        MarsRover marsRover = new MarsRover(new Area(5,5));
        marsRover.land(3,3,'E');
        String position=marsRover.getPosition();
        Assert.assertEquals(position,"33E");
    }
    @Test
    public void forward_test(){
        MarsRover marsRover = new MarsRover(new Area(5,5));
        marsRover.land(3,3,'E');
        marsRover.forward();
        String position=marsRover.getPosition();
        Assert.assertEquals(position,"43E");
    }
}
