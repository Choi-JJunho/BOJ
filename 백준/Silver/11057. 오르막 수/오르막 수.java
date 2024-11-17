import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[t + 1][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= t; i++) {
            for (int j = 0; j <= 9; j++) {
                dp[i][j] = 0;
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] %= 10007;
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dp[t][i];
        }
        result %= 10007;
        System.out.println(result);
    }

}