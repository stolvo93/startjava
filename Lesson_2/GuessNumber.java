public class GuessNumber {
    Player player1;
    Player player2;
    int targetNumber;

    public GuessNumber(Player player1, Player player2, int number) {
        this.player1 = player1;
        this.player2 = player2;
        targetNumber = number;
    }

    String failureMessage = "%d %s того, что загадал компьютер%n";

    private void play(int playerNumber) {
        while (playerNumber != targetNumber) {
            if (playerNumber < targetNumber) {
                System.out.printf(failureMessage, playerNumber, "меньше");
            } else {
                System.out.printf(failureMessage, playerNumber, "больше");
            }
        }
        System.out.println("\nИскомое число - " + playerNumber + ". Вы победили!\n");
    }

}