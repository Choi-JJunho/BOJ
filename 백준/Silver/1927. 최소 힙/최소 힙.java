import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());

            if (input == 0) {
                if (queue.isEmpty()) {
                    bufferedWriter.write("0" + System.lineSeparator());
                } else {
                    bufferedWriter.write(queue.poll() + System.lineSeparator());
                }
            } else {
                queue.add(input);
            }
        }

        bufferedWriter.flush();
    }
}
