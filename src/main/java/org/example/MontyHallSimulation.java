package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MontyHallSimulation {
    private static final int GAMES_TO_PLAY = 1000;
    private final static int countDoors = 3;
    private static int getRandomInt() {
        return (int) (Math.random() * MontyHallSimulation.countDoors) + 1;
    }
    private static int getUniqueRandomInt2(int number1, int number2) {
        int result = getRandomInt();
        while (result == number1 || result == number2) {
            result = getRandomInt();
        }
        return result;
    }
    private static boolean playGame() {
        int doorWithCarNumber = getRandomInt();
//        System.out.println("doorWithCar = " + doorWithCarNumber);

        int doorSelectedNumber = getRandomInt();
//        System.out.println("doorSelectedNumber = " + doorSelectedNumber);

        int doorOpenNumber = getUniqueRandomInt2(doorWithCarNumber, doorSelectedNumber);
//        System.out.println("doorOpenNumber = " + doorOpenNumber);

        int doorLosing = getUniqueRandomInt2(doorOpenNumber, doorWithCarNumber);
//        System.out.println("doorLosing = " + doorLosing);

        if (doorSelectedNumber == doorWithCarNumber) {
            doorSelectedNumber = new Random().nextBoolean() ? doorLosing : doorWithCarNumber;
        }

//        System.out.println("doorSelectedNumber = " + doorSelectedNumber);
        return doorSelectedNumber == doorWithCarNumber;
    }
    private static void getGameCycle() {
        List<Boolean> results = new ArrayList<>();

        for (int i = 0; i < GAMES_TO_PLAY; i++) {
            System.out.println("________________________________");
            System.out.println("Round -> " + i);
            boolean result = playGame();
            System.out.println("Result -> " + result);
            results.add(result);
        }
        System.out.println("********************************");
        System.out.println("Count Win -> " + results.stream().filter(Boolean::booleanValue).count());
        System.out.println("Count Los -> " + results.stream().filter(aBoolean -> !aBoolean).count());
    }


    public static void main(String[] args) {
        getGameCycle();
    }



}





