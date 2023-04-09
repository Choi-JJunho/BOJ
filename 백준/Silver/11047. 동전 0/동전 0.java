import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int target = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> coins = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());
            coins.add(input);
        }
        coins.sort(Collections.reverseOrder());

        int result = 0;
        int count = 0;
        for (final Integer coin : coins) {
            if ((target - result) >= coin) {
                int bound = (target - result) / coin;
                result += coin * bound;
                count += bound;
            }

            if (result >= target) {
                break;
            }
        }
        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
    }
}
