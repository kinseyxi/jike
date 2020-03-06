package com.jike.xueyuan.task3_2;

import org.junit.Assert;
import org.junit.Test;

public class MarsRoverControllerTest {
    @Test
    public void should_execute_batch_commands(){
        MarsRoverController controller = new MarsRoverController(new MarsRover(new Area(5,5)));
       String result= controller.execute("3,3,E,f,l,b,r");
        Assert.assertEquals(result,"42E");

    }
}
