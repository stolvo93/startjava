public class Methods {
    public static String getCurrentMethodName() {
        String currentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        return currentMethodName;
    }
}