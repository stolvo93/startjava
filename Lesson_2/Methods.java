public class Methods {
    public static String getCurrentMethodName() {
        String currentMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return currentMethodName;
    }
}