package com.jike.xueyuan.task3_1;


import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarRoverTest {
    @Test
    public void should_new_mars_rover_with_area(){
        MarsRover marsRover = new MarsRover(5,5);
        assertThat(marsRover).isNotNull();
    }
    @Test
    public void should_land_mars_rover(){
        MarsRover marsRover = new MarsRover(5, 5);
        marsRover.land(3,3,'E');
        Assert.assertEquals(marsRover.getPositon(),"33E");

    }
    @Test
    public void should_move_forward(){
        MarsRover marsRover=new MarsRover(5,5);
        marsRover.land(3,3,'E');
        marsRover.moveForward();
        Assert.assertEquals(marsRover.getPositon(),"43E");
        marsRover.land(3,3,'W');
        marsRover.moveForward();
        Assert.assertEquals(marsRover.getPositon(),"23W");
        marsRover.land(3,3,'N');
        marsRover.moveForward();
        Assert.assertEquals(marsRover.getPositon(),"34N");
        marsRover.land(3,3,'S');
        marsRover.moveForward();
        Assert.assertEquals(marsRover.getPositon(),"32S");
    }
    @Test
    public void should_move_back(){
        MarsRover marsRover=new MarsRover(5,5);
        marsRover.land(3,3,'E');
        marsRover.moveBack();
        Assert.assertEquals(marsRover.getPositon(),"23E");
        marsRover.land(3,3,'W');
        marsRover.moveBack();
        Assert.assertEquals(marsRover.getPositon(),"43W");
        marsRover.land(3,3,'N');
        marsRover.moveBack();
        Assert.assertEquals(marsRover.getPositon(),"32N");
        marsRover.land(3,3,'S');
        marsRover.moveBack();
        Assert.assertEquals(marsRover.getPositon(),"34S");
    }
    @Test
    public void should_turn_left(){
        MarsRover marsRover=new MarsRover(5,5);
        marsRover.land(3,3,'E');
        marsRover.turnLeft();
        Assert.assertEquals(marsRover.getPositon(),"33N");
        marsRover.turnLeft();
        Assert.assertEquals(marsRover.getPositon(),"33W");
        marsRover.turnLeft();
        Assert.assertEquals(marsRover.getPositon(),"33S");
        marsRover.turnLeft();
        Assert.assertEquals(marsRover.getPositon(),"33E");
    }
    @Test
    public void should_turn_right(){
        MarsRover marsRover=new MarsRover(5,5);
        marsRover.land(3,3,'E');
        marsRover.turnRight();
        Assert.assertEquals(marsRover.getPositon(),"33S");
        marsRover.turnRight();
        Assert.assertEquals(marsRover.getPositon(),"33W");
        marsRover.turnRight();
        Assert.assertEquals(marsRover.getPositon(),"33N");
        marsRover.turnRight();
        Assert.assertEquals(marsRover.getPositon(),"33E");
    }
}
