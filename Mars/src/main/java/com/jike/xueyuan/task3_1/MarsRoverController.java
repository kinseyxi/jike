package com.jike.xueyuan.task3_1;

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

        return marsRover.getPositon();
    }

    private void executeCommand(String command) {
        switch (command){
            case "f":
                marsRover.moveForward();
                break;
            case "b":
                marsRover.moveBack();
                break;
            case "l":
                marsRover.turnLeft();
                break;
            case "r":
                marsRover.turnRight();
                break;
        }
    }
}
