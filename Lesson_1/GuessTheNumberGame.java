import java.util.Random;

class GuessTheNumberGame {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNumber = r.nextInt(1, 100);
        int playerNumber = 60;

        while (playerNumber != randomNumber) { 
            if (playerNumber < randomNumber) {
                System.out.printf(playerNumber + "меньше того, что загадал компьютер\n");
                playerNumber = (playerNumber + 100) / 2;
            } else {
                System.out.printf(playerNumber + "больше того, что загадал компьютер\n");
                playerNumber = (playerNumber + 1) / 2;
            }
        }

        System.out.println("\nВы победили!");
    }
}