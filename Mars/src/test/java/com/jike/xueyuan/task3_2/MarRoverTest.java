package com.jike.xueyuan.task3_2;


import com.jike.xueyuan.task3_2.MarsRover;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class MarRoverTest {
    @Rule
    public ExpectedException expectedException=ExpectedException.none();
    @Test
    public void should_new_mars_rover_with_area(){
        MarsRover marsRover = new MarsRover(new Area(5,5));
        assertThat(marsRover).isNotNull();
    }
    @Test
    public void should_land_mars_rover(){
        MarsRover marsRover = new MarsRover(new Area(5,5));
        marsRover.land(3,3,'E');
        Assert.assertEquals(marsRover.getPositon(),"33E");

    }
    @Test
    public void should_not_land_out_of_area(){
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Coordinate 6,6 is out of area 5x5");
        MarsRover marsRover = new MarsRover(new Area(5,5));
        marsRover.land(6,6,'E');

        Assert.assertEquals(marsRover.getPositon(),"33E");
    }
    @Test
    public void should_move_forward(){
        MarsRover marsRover=new MarsRover(new Area(5,5));
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
        MarsRover marsRover=new MarsRover(new Area(5,5));
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
        MarsRover marsRover=new MarsRover(new Area(5,5));
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
        MarsRover marsRover=new MarsRover(new Area(5,5));
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
