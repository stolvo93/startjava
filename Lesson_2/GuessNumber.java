import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public void play(Player player1, Player player2) {
        Random r = new Random();
        int requiredNumber = r.nextInt(1, 101);
        boolean isPlayer1Turn = true;

        while (!makeMove(isPlayer1Turn ? player1 : player2, requiredNumber)) {
            isPlayer1Turn = !isPlayer1Turn;
        }
    }

    private boolean makeMove(Player player, int requiredNumber) {
        System.out.printf("%nХод игрока %s: ", player.getName());
        Scanner scanner = new Scanner(System.in);
        int playerNumber = scanner.nextInt();
        if (playerNumber == requiredNumber) {
            System.out.printf("%nЧисло %d угадано! Победитель - %s! 🎉%n%n", requiredNumber, player.getName());
            return true;
        }
        System.out.printf("Число %d %s того, что загадал компьютер%n",
                playerNumber, playerNumber > requiredNumber ? "больше" : "меньше");
        return false;
    }
}