class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("\n1. ВЫВОД ASCII-символов\n");

        System.out.printf("%-10s%-12s%s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");

        String rowFormat = "%4d\t%7c\t\t   %-25s%n";
        char character = 33;

        while (character <= 'z') {
            if (character % 2 != 0 && character < '0'
                    || character % 2 == 0 && character >= 'a') {
                System.out.printf(rowFormat, (int) character, character, Character.getName(character));
            }
            character++;
        }

        System.out.println("\n2. ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР\n");

        int height = 28;
        int width = height * 4 + 2;

        for (int i = 0; i < height; i++) {
            for (int j = 1; j <= width; j++) {
                if (j == width / 2 
                        || (j == width / 2 + height - i + 1)) {
                    System.out.print(' ');
                } else if (j < width / 2) {
                    System.out.print('-');
                } else if (j <= (width / 2 + height - i)) {
                    System.out.print('*');
                } else if (j <= (width / 2 + height + i + 2)) {
                    System.out.print('^');
                }
            }
            System.out.println();
        }

        System.out.println("\n3. ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ\n");
    }
}