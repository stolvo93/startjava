import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int targetNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        Random r = new Random();
        targetNumber = r.nextInt(1, 101);
        Player currentPlayer = player1;

        while (!makeMove(currentPlayer)) {
            currentPlayer = currentPlayer == player1 ? player2 : player1;
        }
    }

    private boolean makeMove(Player player) {
        System.out.printf("%nИгрок %s угадывает число: ", player.getName());
        Scanner scanner = new Scanner(System.in);
        player.setNumber(scanner.nextInt());

        if (player.getNumber() == targetNumber) {
            System.out.printf("%nЧисло %d угадано! Победитель - %s! 🎉%n%n", targetNumber, player.getName());
            return true;
        }

        System.out.printf("Число %d %s того, что загадал компьютер%n",
                player.getNumber(), player.getNumber() > targetNumber ? "больше" : "меньше");
        return false;
    }
}