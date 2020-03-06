package com.jike.xueyuan.task3;

import org.junit.Assert;
import org.junit.Test;

public class CommandTest {
    @Test
    public void commandTest1(){
        Command command=new Command("-f 30 -l");
        Assert.assertEquals(command.getValue(0),"f");
        Assert.assertEquals(command.getValue(1),"30");
        Assert.assertEquals(command.getValue(2),"l");
    }
    @Test
    public void commandTest2(){
        Command command=new Command("-l -l -f 30");
        Assert.assertEquals(command.getValue(0),"l");
        Assert.assertEquals(command.getValue(1),"l");
        Assert.assertEquals(command.getValue(2),"f");
        Assert.assertEquals(command.getValue(3),"30");
    }
    @Test
    public void commandTest3(){
        Command command=new Command("-r -l -b 30");
        Assert.assertEquals(command.getValue(0),"r");
        Assert.assertEquals(command.getValue(1),"l");
        Assert.assertEquals(command.getValue(2),"b");
        Assert.assertEquals(command.getValue(3),"30");
    }

}