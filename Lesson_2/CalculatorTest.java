import java.util.Scanner;

public class CalculatorTest {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String answer;

        do {
            System.out.print("\nВведите первое число: ");
            int a = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Введите знак математической операции: ");
            char mathOperation = scanner.nextLine().charAt(0);
            System.out.print("Введите второе число: ");
            int b = scanner.nextInt();
            calculator.calculate(a, mathOperation, b);
            scanner.nextLine();
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                answer = scanner.nextLine();
            } while (!("yes".equals(answer) || "no".equals(answer)));
        } while ("yes".equals(answer));
    }
}