import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int zero = 5;

        try {
            File file = new File("src/02.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char a = line.charAt(i);
                    if (a == 'U') {
                        zero = up(zero);
                    }
                    if (a == 'D') {
                        zero = down(zero);
                    }
                    if (a == 'L') {
                        zero = left(zero);
                    }
                    if (a == 'R') {
                        zero = right(zero);
                    }

                }
                System.out.println(zero);
                line = reader.readLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


    public static int up(int a) {
        if (a == 1 || a == 2 || a == 5 || a == 4 || a == 9) {
            return a;
        } else if (a == 6 || a == 7 || a == 8
                || a == 10 || a == 11 || a == 12) {
            return a - 4;
//(a == 3 || a == 13)
        } else {
            return a - 2;
        }
    }

    public static int down(int a) {
        if (a == 5 || a == 10 || a == 13 || a == 12 || a == 9) {
            return a;
        } else if (a == 2 || a == 3 || a == 4
                || a == 6 || a == 7 || a == 9) {
            return a + 4;
            //a == 1 || a == 11
        } else {
            return a + 2;
        }
    }

    public static int left(int a) {
        if (a == 1 || a == 2 || a == 5 || a == 10 || a == 13) {
            return a;
        } else if (a == 3 || a == 4 || a == 7 || a == 8 || a == 11 || a == 12) {
            return a - 1;
            //  (a == 6 || a == 9)
        } else {
            return a - 1;
        }
    }

    public static int right(int a) {
        if (a == 1 || a == 4 || a == 9 || a == 12 || a == 13) {
            return a;
        } else if (a == 2 || a == 6 || a == 10 || a == 3 || a == 7 || a == 11) {
            return a + 1;
            //(a == 5 || a == 8)
        } else {
            return a + 1;
        }
    }
}
