import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

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
//                System.out.println(line);
                line = reader.readLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public static int up(int a) {
        if (a == 1 || a == 2 || a == 3) {
            return a;
        } else {
            return a - 3;
        }
    }

    public static int down(int a) {
        if (a == 7 || a == 8 || a == 9) {
            return a;
        } else {
            return a + 3;
        }

    }

    public static int left(int a) {
        if (a == 1 || a == 4 || a == 7) {
            return a;
        } else {
            return a - 1;
        }

    }

    public static int right(int a) {
        if (a == 3 || a == 6 || a == 9) {
            return a;
        } else {
            return a + 1;
        }
    }

}


