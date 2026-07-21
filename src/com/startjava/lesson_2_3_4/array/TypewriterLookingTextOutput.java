public class TypewriterLookingTextOutput {
    private static final String JAMES_GOSLING_QUOTE = """
            Java - это C++, из которого убрали все пистолеты, ножи и дубинки.
            - James Gosling""";
    private static final String ROBERT_MARTIN_QUOTE = """
            Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.
            - Robert Martin""";

    public static void main(String[] args) {
        String[] arguments = {
                JAMES_GOSLING_QUOTE,
                ROBERT_MARTIN_QUOTE,
                null,
                ""
        };

    }

    private static String[] findShortestAndLongestWords(String string) {
        char[] stringChars = string.toCharArray();
        int maxWordLen = 0;
        int maxWordStart = 0;
        int minWordLen = 0;
        int minWordStart = 0;
        for (int i = 0, charsCount = 0; i < stringChars.length; i++) {
            if (Character.isLetter(stringChars[i])) {
                charsCount++;
                continue;
            }
            
            if (charsCount > maxWordLen) {
                maxWordLen = charsCount;
            } else if (minWordLen == 0 || charsCount < minWordLen) {
                minWordLen = charsCount;
            }
            charsCount = 0;
        }
    }

}