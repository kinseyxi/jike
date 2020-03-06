package com.jike.xueyuan.task3;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Task3ApplicationTests {

    @Test
    public void commandTest(){
        new Command("-f 30,-l,-b 60,-r,-f 60");
    }

}
