public class Factorial {
    public static void calculate(int... nums) {
        if (nums == null) {
            printDataError();
        } else if (nums.length == 0) {
            printNoDataMessage();
        } else {
            int[] factorials = new int[nums.length];
            for (int num : nums) {
                
            }
        }
    }

    private static void printDataError() {
        System.out.println("Ошибка в данных.");
    }

    private static void printNoDataMessage() {
        System.out.println("Нет данных.");
    }
}