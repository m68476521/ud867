package com.m68476521.mike.jokeprovider;

import java.util.Random;

public class Joker {
    public String getJoker() {
        Random random = new Random();
        int x = random.nextInt(3);

        String joke1 = "Q. Why do the French like to eat snails so much?" +
                "-" + "\n" +
                "A. They can’t stand fast food.";

        String joke2 = "How many gorillas can fit into a car?\n" +
                "\n" +
                "Eight.\n" +
                "\n" +
                "How many chickens can fit into the car? \n" +
                "\n" +
                "None, the car is already full of gorillas.\n" +
                "\n";

        String joke3 = "She: I have a doctor’s appointment today but I really don’t want to go… \n" +
                "-\n" +
                "He: Just call in sick then.\n";

        switch (x) {
            case 1:
                return joke1;
            case 2:
                return joke2;
            default:
                return joke3;
        }
    }
}
