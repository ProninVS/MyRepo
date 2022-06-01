import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static int size;
    private static int offset;
    private static int readLength;
    private static final Scanner sc = new Scanner(System.in);
    private static final Pattern patternDis = Pattern.compile("[1-9]+[0-9]*");

    public static void main(String[] args) {

        int indexArray = 0;
        int[] array;
        int discount;

        System.out.println("Введите количество новых цен: ");
        size = check();
        array = new int[size];

        System.out.println("Введите значения новых цены:");
        for (int i = 0; i < size; i++) {
            array[indexArray] = check();
            indexArray++;
        }
        System.out.println("Новые цены:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("\nВведите размер скидки");
        discount = check();

        System.out.println("С какой позиции применить скидку?");
        offset = check() - 1;
        while (true) {
            if (offset >= size) {
                System.out.println("Введенное число превышает количество новых цен. Введите корректное число: ");
                offset = check() - 1;
            } else break;
        }

        System.out.println("К какому количеству позиций применить скидку?");
        readLength = check();
        while (true) {
            if (readLength > size - offset) {
                System.out.println("Такого количества цен неприменимо. Введите меньшее количество: ");
                readLength = check();
            } else break;
        }
        for (int i = offset; readLength > 0; i++) {
            double percent = ((double) (array[i] * discount)) / 100.0;
            double discountPrice = array[i] - percent;
            int finalPrice = (int) Math.floor(discountPrice);
            System.out.print(finalPrice + " ");
            readLength--;
        }
    }

    private static int check() {
        while (true) {
            String value = sc.nextLine();
            Matcher matcher = patternDis.matcher(value);
            if (!matcher.matches()) {
                System.out.println("Введенный символ не является числом. Введите целочисленное значени: ");
            } else {
                return Integer.parseInt(value);
            }
        }
    }

}