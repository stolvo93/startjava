import java.util.Random;

public class RpsGameFormatting {
    // Игра Камень-Ножницы-Бумага
    public static void main(String[] args) throws InterruptedException {
        char rock = 'R';
        char scissors = 'S';
        char paper = 'P';
        Random r = new Random();

        // Ход первого игрока
        String name1 = "HEL";
        int position1 = r.nextInt(1, 100);
        char sign1 = rock;

        if (position1 > 66) {
            sign1 = paper;
        } else if (position1 > 33) {
            sign1 = scissors;
        }

        System.out.println("Ход " + name1 + ": ");

        for (int i = 0; i < 5; i++) {
            System.out.print(rock + "\r");
            Thread.sleep(100);
            System.out.print(scissors + "\r");
            Thread.sleep(100);
            System.out.print(paper + "\r");
            Thread.sleep(100);
        }

        System.out.println(sign1);

        // Ход второго игрока
        String name2 = "WALLE";
        int position2 = r.nextInt(1, 100);
        char sign2 = rock;

        if (position2 > 66) {
            sign2 = paper;
        } else if (position2 > 33) {
            sign2 = scissors;
        }

        System.out.println("Ход " + name2 + ": ");

        for (int i = 0; i < 5; i++) {
            System.out.print(rock + "\r");
            Thread.sleep(100);
            System.out.print(scissors + "\r");
            Thread.sleep(100);
            System.out.print(paper + "\r");
            Thread.sleep(100);
        }

        System.out.println(sign2);

        if (sign1 == sign2) {
            System.out.println("Победила дружба!");
        } else if (sign1 == rock && sign2 == scissors ||
                sign1 == scissors && sign2 == paper ||
                sign1 == paper && sign2 == rock) {
            System.out.println("\nПобедил - " + name1);
        } else {
            System.out.println("\nПобедил - " + name2);
        }

    }
}