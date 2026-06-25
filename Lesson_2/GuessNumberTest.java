public class GuessNumberTest {
    public static void main(String[] args) {
        System.out.println("\n***** УГАДАЙ ЧИСЛО *****\n");
        
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player(scanner.nextLine());
        scanner.nextLine();
        Player player2 = new Player(scanner.nextLine());

        Random r = new Random();
        String answer = "";

        do {
            

            scanner.nextLine();
            do {
                System.out.print("\Хотите продолжить игру? [yes/no]: ");
                answer = scanner.nextLine();
            } while (!"yes".equals(answer) && !"no".equals(answer));
        } while ("yes".equals(answer));
    }
}