import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Pattern patternDis = Pattern.compile("[1-9]+[0-9]*");
        int size;
        int discount;
        int offset;
        int indexArray = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество новых цен: ");
        while (true)
        {
            String priceOld = sc.nextLine();
            Matcher matcherSize = patternDis.matcher(priceOld);
            if (matcherSize.matches())
            {
                size = Integer.parseInt(priceOld);
                break;
            }
            System.out.println("Введено неккоректное значение. Попробуйте еще раз: ");
        }
        int array[] = new int[size];
        System.out.println("Введите новые цены:");

        while (true)
        {
            String priceNew = sc.nextLine();
            Matcher matcherSize2 = patternDis.matcher(priceNew);
            if (matcherSize2.matches())
            {
                array[indexArray] = Integer.parseInt(priceNew);
                indexArray++;
                if (indexArray == size)
                {
                    break;
                }
            } else {
                System.out.println("Введено некорректное число");
            }
        }
        System.out.println("Новые цены:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Введите размер скидки");
        while (true) {
            String discount1 = sc.nextLine();
            Matcher matcherDis = patternDis.matcher(discount1);
            if (matcherDis.matches() && discount1.length() <= 2) {
                discount = Integer.parseInt(discount1);
                break;
            }
            System.out.println("Введена неверная скидка. Введите заново");
        }
        System.out.println("С какой позиции применить скидку?");
        while (true) {
            String offset1 = sc.nextLine();
            Matcher matcherDis = patternDis.matcher(offset1);
            if ((matcherDis.matches() && Integer.parseInt(offset1) < size && Integer.parseInt(offset1) >= 0)) {
                offset = Integer.parseInt(offset1);
                break;
            }
            System.out.println("Введено некорректное значение. Введите заново");
        }
        System.out.println("К какому количеству позиций применить скидку?: ");
        int readLength;
        while (true) {
            String readLength1 = sc.nextLine();
            Matcher matcherDis = patternDis.matcher(readLength1);
            if (matcherDis.matches() && Integer.parseInt(readLength1) <= size - offset || offset != size) {
                readLength = Integer.parseInt(readLength1);
                break;
            }
            System.out.println("Введено некорректное значение. Введите заново");
        }
        rageDis(readLength, array, offset, discount);
    }



    public static void rageDis(int readLength, int[] array, int offset, int discount) {
        int arrayNew[] = Arrays.copyOfRange(array, offset, offset + readLength);
        for (int i = 0; i < readLength; i++) {
            double percent = ((double) (arrayNew[i] * discount)) / 100.0;
            double discountPrice = arrayNew[i] - percent;
            int finalPrice = (int) Math.floor(discountPrice);
            System.out.print(finalPrice + " ");
        }
    }


}