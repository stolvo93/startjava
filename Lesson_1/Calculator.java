public class Calculator {
    public static void main(String[] args) {
        System.out.println("\n1. Калькулятор");

        int a = 16_777_216;
        char sign = '/';
        int b = 65_536;
        int result = 1;

        if (sign == '+') {
            result = a + b;
        } else if (sign == '-') {
            result = a - b;
        } else if (sign == '*') {
            result = a * b;
        } else if (sign == '/') {
            if (b == 0) {
                System.out.println("Деление на ноль запрещено.");
            } else {
                double divisionResult = (double) a / (double) b;
                // не выводим дробную часть результата, если это целое число
                if (divisionResult * 10 % 10 == 0) {
                    System.out.printf("%d %s %d = %.0f%n", a, sign, b, divisionResult);
                } else {
                    System.out.println(a + " " + sign + " " + b + " = " + divisionResult);
                }
            }
            return;
        } else if (sign == '^') {
            for (int i = 0; i < b; i++) {
                result *= a;
            }
        } else if (sign == '%') {
            if (b == 0) {
                System.out.println("Деление на ноль запрещено.");
                return;
            }
            result = a % b;
        } else {
            System.out.println("Неверный знак. Используйте один из следующих знаков: +, -, *, /, ^, %");
        }

        System.out.println(a + " " + sign + " " + b + " = " + result);
    }
}