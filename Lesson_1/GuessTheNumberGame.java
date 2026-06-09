import java.util.Random;

class GuessTheNumberGame {
    public static void main(String[] args) {
        System.out.println("\n***** УГАДАЙ ЧИСЛО *****\n");
        
        Random r = new Random();
        int randomNumber = r.nextInt(1, 100);
        int playerNumber = 60;
        int upperLimit = 100;
        int lowerLimit = 1;

        while (playerNumber != randomNumber) { 
            if (playerNumber < randomNumber) {
                System.out.printf(playerNumber + " меньше того, что загадал компьютер\n");
                lowerLimit = playerNumber;
                playerNumber = (playerNumber + upperLimit) / 2;
            } else {
                System.out.printf(playerNumber + " больше того, что загадал компьютер\n");
                upperLimit = playerNumber;
                playerNumber = (playerNumber + lowerLimit) / 2;
            }
        }

        System.out.println("\nИскомое число - " + playerNumber + ". Вы победили!\n");
    }
}