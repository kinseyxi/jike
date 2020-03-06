package com.jike.xueyuan.task3;

import org.junit.Assert;
import org.junit.Test;

public class MarsRoverControllerTest {
    @Test
    public void new_controller_test(){
        //创建对象  执行构造函数
        MarsRoverController controller = new MarsRoverController(new MarsRover(new Area(5, 5)));
        String result=controller.execute("3,3,E,f");
        Assert.assertEquals(result,"43E");
    }

}