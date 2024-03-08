public class Calculator {

    public void calculate(int a, char sign, int b) {
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
                if (!hasDivisionByZero(b)) {
                    divide(a, b);
                }
                return;
            case '^':
                for (int i = 0; i < b; i++) {
                    result *= a;
                }
                break;
            case '%':
                if (!hasDivisionByZero(b)) {
                    result = a % b;
                    break;
                }
                return;
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
        }
        return false;
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