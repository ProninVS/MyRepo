import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args)
            throws IOException {

        StringBuilder builder = new StringBuilder();

        int floor = 0;
        Reader reader = new FileReader("text/example.txt");
        BufferedReader buffReader = new BufferedReader(reader);

        while (buffReader.ready()) {

            builder.append(buffReader.readLine());
        }
        String text = builder.toString();
        reader.close();
        buffReader.close();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ')') {
                floor--;

            }
            if (text.charAt(i) == '(') {
                floor++;
            }

        }
        System.out.println(floor);
    }
}