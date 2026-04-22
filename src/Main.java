import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Тестирование всех методов (для проверки работоспособности)

        // Задача 1
        System.out.println("1. Сумма в пределах 10-20 (5 + 7): " + isSumInRange(5, 7));
        System.out.println("1. Сумма в пределах 10-20 (15 + 7): " + isSumInRange(15, 7));

        // Задача 2
        System.out.print("2. Число 5: "); printSign(5);
        System.out.print("2. Число -3: "); printSign(-3);
        System.out.print("2. Число 0: "); printSign(0);

        // Задача 3
        System.out.println("3. Число -7 отрицательное? " + isNegative(-7));
        System.out.println("3. Число 10 отрицательное? " + isNegative(10));
        System.out.println("3. Число 0 отрицательное? " + isNegative(0));

        // Задача 4
        System.out.println("4. Печать строки 3 раза:");
        printStringMultipleTimes("Hello, Java!", 3);

        // Задача 5
        System.out.println("5. 2024 високосный? " + isLeapYear(2024));
        System.out.println("5. 1900 високосный? " + isLeapYear(1900));
        System.out.println("5. 2000 високосный? " + isLeapYear(2000));

        // Задача 6
        int[] binaryArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("6. Исходный массив: " + Arrays.toString(binaryArray));
        invertArray(binaryArray);
        System.out.println("6. Инвертированный: " + Arrays.toString(binaryArray));

        // Задача 7
        int[] hundredArray = createArrayFrom1To100();
        System.out.println("7. Массив 1..100 (первые 10): " +
                Arrays.toString(Arrays.copyOf(hundredArray, 10)) + "...");

        // Задача 8
        int[] mixedArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("8. Исходный массив: " + Arrays.toString(mixedArray));
        multiplyLessThan6By2(mixedArray);
        System.out.println("8. Изменённый массив: " + Arrays.toString(mixedArray));

        // Задача 9
        System.out.println("9. Квадратный массив 5x5 с диагоналями:");
        int[][] diagonalArray = createDiagonalArray(5);
        print2DArray(diagonalArray);

        // Задача 10
        int[] customArray = createArray(5, 42);
        System.out.println("10. Массив длиной 5 со значениями 42: " + Arrays.toString(customArray));
    }

    // 1. Проверка суммы в пределах от 10 до 20 включительно
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // 2. Печать знака числа (0 считаем положительным)
    public static void printSign(int number) {
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    // 3. Проверка, является ли число отрицательным
    public static boolean isNegative(int number) {
        return number < 0;
    }

    // 4. Печать строки указанное количество раз
    public static void printStringMultipleTimes(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    // 5. Проверка високосного года
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    // 6. Замена 0 на 1 и 1 на 0 в массиве
    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
            // Альтернатива: array[i] = 1 - array[i];
        }
    }

    // 7. Заполнение массива значениями от 1 до 100
    public static int[] createArrayFrom1To100() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // 8. Умножение чисел меньше 6 на 2
    public static void multiplyLessThan6By2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    // 9. Заполнение диагоналей единицами (обеих диагоналей)
    public static int[][] createDiagonalArray(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            array[i][i] = 1;                 // Главная диагональ
            array[i][size - 1 - i] = 1;      // Побочная диагональ
        }
        return array;
    }

    // Вспомогательный метод для печати двумерного массива
    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }

    // 10. Создание массива заданной длины с одинаковыми значениями
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        // Альтернатива: for (int i = 0; i < len; i++) { array[i] = initialValue; }
        return array;
    }
}