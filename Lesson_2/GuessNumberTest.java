import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        String name = scanner.nextLine();
        Player player1 = new Player(name);

        System.out.print("Введите имя второго игрока: ");
        name = scanner.nextLine();
        Player player2 = new Player(name);

        GuessNumber game = new GuessNumber();
        String answer;

        do {
            game.play(player1, player2);
            do {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                answer = scanner.nextLine();
            } while (!("yes".equals(answer) || "no".equals(answer)));
        } while ("yes".equals(answer));
    }
}