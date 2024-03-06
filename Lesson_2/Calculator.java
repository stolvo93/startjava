public class Calculator {
    public static void main(String[] args) {
        System.out.println("\n1. Калькулятор");

        int a = 16_777_216;
        char sign = '5';
        int b = 65_536;
        int result = 1;

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
                    System.out.println("Деление на ноль запрещено.");
                } else {
                    double divisionResult = (double) a / b;
                    // не выводим дробную часть результата, если он является целым числом
                    if (divisionResult % 1 == 0) {
                        System.out.printf("%d %s %d = %.0f%n", a, sign, b, divisionResult);
                    } else {
                        System.out.println(a + " " + sign + " " + b + " = " + divisionResult);
                    }
                }
                return;
            case '^':
                for (int i = 0; i < b; i++) {
                    result *= a;
                }
                break;
            case '%':
                if (b == 0) {
                    System.out.println("Деление на ноль запрещено.");
                    return;
                }
                result = a % b;
                break;
            default:
                System.out.print("Неверный знак математической операции. ");
                System.out.println("Доступны следующие знаки: +, -, *, /, ^, %");
                return;
        }
        System.out.println(a + " " + sign + " " + b + " = " + result);
    }
}