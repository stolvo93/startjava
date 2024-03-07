import java.util.Scanner;

public class CalculatorTest {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculation = new Calculator();
        boolean isAgree = false;

        do {
            System.out.print("\nВведите первое число: ");
            int firstNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Введите знак математической операции: ");
            char mathOperation = scanner.nextLine().charAt(0);
            System.out.print("Введите второе число: ");
            int secondNumber = scanner.nextInt();
            calculation.calculate(firstNumber, mathOperation, secondNumber);
            scanner.nextLine();
            while (true) {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                String answer = scanner.nextLine();
                if (answer.equals("yes")) {
                    isAgree = true;
                    break;
                } else if (answer.equals("no")) {
                    isAgree = false;
                    break;
                }
            }
        } while (isAgree);
    }
}