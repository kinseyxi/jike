package com.jike.xueyuan.task3;

import sun.awt.SunHints;

import java.util.*;

public class Command {
    List<String> commandList = new ArrayList<String>();
    public Command(String command) {
                    ListIterator<String> commandIterator = Arrays.asList(command.split("\\s+")).listIterator();
                    while (commandIterator.hasNext()) {
                        String name = commandIterator.next().substring(1);
                        if ("f".equals(name) || "b".equals(name)) {
                            if (commandIterator.hasNext()) {
                                String value = commandIterator.next();
                                commandList.add(name);
                                commandList.add(value);
                            }
                        }
                        if ("r".equals(name) || "l".equals(name)) {
                            commandList.add(name);
                        }
                    }

                }


    public String getValue(int index) {
        String value = (String) commandList.get(index);
            return value;

    }
}
