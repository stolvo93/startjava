import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int requiredNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        Random r = new Random();
        requiredNumber = r.nextInt(1, 101);
        boolean isPlayer1Turn = true;

        while (!makeMove(isPlayer1Turn ? player1 : player2)) {
            isPlayer1Turn = !isPlayer1Turn;
        }
    }

    private boolean makeMove(Player player) {
        System.out.printf("%nИгрок %s угадывает число: ", player.getName());
        Scanner scanner = new Scanner(System.in);
        player.setNumber(scanner.nextInt());

        if (player.getNumber() == requiredNumber) {
            System.out.printf("%nЧисло %d угадано! Победитель - %s! 🎉%n%n", requiredNumber, player.getName());
            return true;
        }

        System.out.printf("Число %d %s того, что загадал компьютер%n",
                player.getNumber(), player.getNumber() > requiredNumber ? "больше" : "меньше");
        return false;
    }
}