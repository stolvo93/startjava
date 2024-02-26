public class Calculator {
    public static void main(String[] args) {
        System.out.println("\n1. Калькулятор");

        double a = 43;
        char sign = '/';
        double b = 3;
        double result = 1;
        boolean signValid = true;
        boolean hasDivisionByZero = false;

        switch (sign) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    hasDivisionByZero = true;
                    System.out.println("Деление на ноль запрещено.");
                }
                result = a / b;
                break;
            case '^':
                if (b > 0) {
                    for (int i = 0; i < b; i++) {
                        result *= a;
                    }
                } else if (b < 0) {
                    for (int i = 0; i > b; i--) {
                        result /= a;
                    }
                }
                break;
            case '%':
                if (b == 0) {
                    hasDivisionByZero = true;
                    System.out.println("Деление на ноль запрещено.");
                }
                result = a % b;
                break;
            default:
                signValid = false;
                System.out.println("Неверный знак. Используйте один из следующих знаков: +, -, *, /, ^, %");
                break;
        }

        if (signValid & !hasDivisionByZero) {
            System.out.println(a + " " + sign + " " + b + " = " + result);
        }
    }
}