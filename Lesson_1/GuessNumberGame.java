import java.util.Random;

public class GuessNumberGame {
    public static void main(String[] args) {
        System.out.println("\n***** УГАДАЙ ЧИСЛО *****\n");
        
        Random r = new Random();
        int targetNumber = r.nextInt(1, 100);
        int playerNumber = 60;
        int upperLimit = 100;
        int lowerLimit = 1;
        String failureMessage = "%d %s того, что загадал компьютер%n";

        while (playerNumber != targetNumber) { 
            if (playerNumber < targetNumber) {
                System.out.printf(failureMessage, playerNumber, "меньше");
                lowerLimit = playerNumber;
                playerNumber = (playerNumber + upperLimit) / 2;
            } else {
                System.out.printf(failureMessage, playerNumber, "больше");
                upperLimit = playerNumber;
                playerNumber = (playerNumber + lowerLimit) / 2;
            }
        }

        System.out.println("\nИскомое число - " + playerNumber + ". Вы победили!\n");
    }
}