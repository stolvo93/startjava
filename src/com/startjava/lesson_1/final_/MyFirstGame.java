package com.startjava.lesson_1.final_;

public class MyFirstGame {
    public static void main(String[] args) {
        System.out.println("\n2. Игра \"Угадай число\"");

        int requiredNumber = 42;
        int playerNumber = 1;
        int minPossibleNumber = 1;
        int maxPossibleNumber = 100;

        while (playerNumber != requiredNumber) {
            if (playerNumber > requiredNumber) {
                System.out.printf("Число %d больше того, что загадал компьютер%n", playerNumber);
                maxPossibleNumber = playerNumber - 1;
            } else {
                System.out.printf("Число %d меньше того, что загадал компьютер%n", playerNumber);
                minPossibleNumber = playerNumber + 1;
            }
            playerNumber = (maxPossibleNumber + minPossibleNumber) / 2;
        }
        System.out.println("\nВы победили!\n");
    }
}