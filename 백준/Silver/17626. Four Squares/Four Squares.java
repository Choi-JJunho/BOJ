import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 1;
        int min = Integer.MAX_VALUE;
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j;
                min = Math.min(min, dp[temp]);
            }
            dp[i] = min + 1;
        }
        bufferedWriter.write(String.valueOf(dp[N]));
        bufferedWriter.flush();
    }
}
