package com.jike.xueyuan.task3;

import java.util.Arrays;
import java.util.List;

public class MarsRoverController {
    private MarsRover marsRover;

    public MarsRoverController(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    public String execute(String commands) {
        String[] array = commands.split(",");
        marsRover.land(Integer.parseInt(array[0]),Integer.parseInt(array[1]),array[2].charAt(0));
        List<String> commandList = Arrays.asList(array).subList(3, array.length);
        for (String command:commandList){
            executeCommand(command);
        }
        return marsRover.getPosition();

    }

    private void executeCommand(String command) {
        switch (command){
            case "f":
                marsRover.forward();
                break;
        }
    }
}
