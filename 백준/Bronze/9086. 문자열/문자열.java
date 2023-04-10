import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            bufferedWriter.write(String.valueOf(input.charAt(0)) + String.valueOf(input.charAt(input.length() - 1)) + System.lineSeparator());
        }

        bufferedWriter.flush();
    }
}
