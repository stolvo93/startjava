public class Calculator {
    public static void main(String[] args) {
        System.out.println("\n1. Калькулятор");

        int a = 43;
        char sign = '/';
        int b = 3;
        double result = 1;

        if (sign == '+') {
            result = a + b;
        } else if (sign == '-') {
            result = a - b;
        } else if (sign == '*') {
            result = a * b;
        } else if (sign == '/') {
            if (b == 0) {
                System.out.println("Деление на ноль запрещено.");
                return;
            }
            result = (double) a / (double) b;
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