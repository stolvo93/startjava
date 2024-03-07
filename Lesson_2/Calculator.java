public class Calculator {

        private int a;
        private char sign;
        private int b;
        private int result;

    public void calculate(int a, char sign, int b) {
        this.a = a;
        this.sign = sign;
        this.b = b;
        result = 1;

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
                if (!hasDivisionByZero(b)) {
                    divide(a, b);
                }
                return;
            case '^':
                for (int i = 0; i < b; i++) {
                    result *= a;
                    System.out.println(result);
                }
                break;
            case '%':
                if (!hasDivisionByZero(b)) {
                    result = a % b;
                    break;
                } else {
                    return;
                }
            default:
                System.out.print("Неверный знак математической операции. ");
                System.out.println("Поддерживаются следующие знаки: +, -, *, /, ^, %");
                return;
        }
        System.out.println(a + " " + sign + " " + b + " = " + result);
    }

    private boolean hasDivisionByZero(int divisor) {
        if (divisor == 0) {
            System.out.println("Деление на ноль запрещено.");
            return true;
        } else {
            return false;
        }
    }

    private void divide(int a, int b) {
        double divisionResult = (double) a / b;
        
        // не выводим дробную часть результата, если он является целым числом
        if (divisionResult % 1 == 0) {
            System.out.printf("%d / %d = %.0f%n", a, b, divisionResult);
        } else {
            System.out.println(a + " / " + b + " = " + divisionResult);
        }
    }
}